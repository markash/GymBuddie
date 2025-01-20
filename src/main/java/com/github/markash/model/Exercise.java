package com.github.markash.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
public class Exercise {

	private Integer id;
	private String name;
	private Double weight;

	private final List<Repetition> repetitions = new ArrayList<>();

	public void addRepetitions(Repetition[] repetitions) {
		Arrays.stream(repetitions).forEach(this::addRepetition);
	}

	public void addRepetition(Repetition repetition) {
		this.repetitions.add(repetition);
	}

	public Integer getSets() { return repetitions.size(); }

	public static ExerciseBuilder define() {
		return new ExerciseBuilder();
	}
}
