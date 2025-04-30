package com.github.markash.model;

import lombok.Data;

import java.text.DecimalFormat;
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

	private final List<Set> sets = new ArrayList<>();

	public void addRepetitions(Set[] repetitions) {
		Arrays.stream(repetitions).forEach(this::addRepetition);
	}

	public void addRepetition(Set repetition) {
		this.sets.add(repetition);
	}

	public String getExerciseNumber() { return Optional.ofNullable(this.number).map(n -> new DecimalFormat("00").format(n)).orElse("00"); }

	public Integer getNoOfSets() { return sets.size(); }

	public static ExerciseBuilder define() {
		return new ExerciseBuilder();
	}
}
