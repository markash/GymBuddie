package com.github.markash.model;

import lombok.Data;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Data
public class Exercise {

	/** The unique identifier for the exercise */
	private Integer id;
	/** The number of the exercise in the workout */
	private Integer number;
	/** The name of the exercise */
	private String name;
	/** The description of the exercise */
	private String description;
	/** The weight setting on the equipment of the exercise */
	private Double weight;

	private final List<Repetition> repetitions = new ArrayList<>();

	public void addRepetitions(Repetition[] repetitions) {
		Arrays.stream(repetitions).forEach(this::addRepetition);
	}

	public void addRepetition(Repetition repetition) {
		this.repetitions.add(repetition);
	}

	public String getExerciseNumber() { return Optional.ofNullable(this.number).map(n -> new DecimalFormat("00").format(n)).orElse("00"); }

	public Integer getSets() { return repetitions.size(); }

	public static ExerciseBuilder define() {
		return new ExerciseBuilder();
	}
}
