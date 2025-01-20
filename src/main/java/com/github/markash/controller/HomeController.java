package com.github.markash.controller;

import com.github.markash.model.Exercise;
import com.github.markash.model.Repetition;
import com.github.markash.model.State;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;


@Controller
public class HomeController {

	static List<String> searchResults =
			List.of("one", "two", "three", "four", "five");

	static List<Exercise> exercises =
			List.of(
					Exercise.define().id(1).name("Assisted Chin (w)").weight(35.0)
							.repetition().id(1).value(10).end()
							.repetition().id(2).value(8).end()
							.repetition().id(3).value(6).end()
							.repetition().id(4).value(6).end()
							.build(),
					Exercise.define().id(2).name("Assisted Chin (n)").weight(35.0)
							.repetition().id(5).value(10).end()
							.repetition().id(6).value(10).end()
							.repetition().id(7).value(10).end()
							.repetition().id(8).value(10).end()
							.build()
			);

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("results", searchResults);
		model.addAttribute("exercises", exercises);
		model.addAttribute("states", State.New);
		return "index";
	}

	@GetMapping("/search")
	public String search(String q, Model model) {
		var filtered = searchResults
				.stream()
				.filter(s -> s.startsWith(q.toLowerCase()))
				.toList();
		model.addAttribute("results", filtered);


		return "search :: results";
	}

	@PostMapping("repetitionState")
	public String repetitionState(Integer exerciseId, Integer repetitionId, Model model) {

		moveStateToNext(exerciseId, repetitionId);

		model.addAttribute("exercises", exercises);
		model.addAttribute("states", State.New);
		return "exercise :: exercise-rows";
	}

	public void moveStateToNext(Integer exerciseId, Integer repetitionId) {

		exercises.stream()
				.filter(e -> e.getId().equals(exerciseId))
				.findFirst()
				.orElse(new Exercise())
				.getRepetitions()
				.stream()
				.filter(r -> r.getId().equals(repetitionId))
				.findFirst()
				.ifPresent(Repetition::moveToNextState);
	}

	@PostMapping("/clicked")
	public String clicked(Model model) {
		model.addAttribute("now", LocalDateTime.now().toString());
		return "clicked :: result";
	}


}
