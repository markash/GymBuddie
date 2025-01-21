package com.github.markash.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class Workout {

	private Integer id;
	private String name;
	private String description;
	private final List<Exercise> exercises = new ArrayList<>();

	public void addExercise(Exercise[] exercises) {
		Arrays.stream(exercises).forEach(this::addExercise);
	}

	public void addExercise(Exercise exercise) {
		this.exercises.add(exercise);
	}

	public static WorkoutBuilder define() {
		return new WorkoutBuilder();
	}
}
