package com.github.markash.model;

public class ExerciseBuilder {

	private final Exercise exercise;
	private WorkoutBuilder workoutBuilder;

	ExerciseBuilder() {
		this.exercise = new Exercise();
	}

	ExerciseBuilder(WorkoutBuilder workoutBuilder) {
		this.exercise = new Exercise();
		this.workoutBuilder = workoutBuilder;
	}

	public ExerciseBuilder id(Integer id) {
		this.exercise.setId(id);
		return this;
	}

	public ExerciseBuilder number(Integer number) {
		this.exercise.setNumber(number);
		return this;
	}

	public ExerciseBuilder name(String name) {
		this.exercise.setName(name);
		return this;
	}

	public ExerciseBuilder description(String description) {
		this.exercise.setDescription(description);
		return this;
	}

	public ExerciseBuilder weight(double weight) {
		this.exercise.setWeight(weight);
		return this;
	}

	public ExerciseBuilder repetitions(Set...repetition) {
		this.exercise.addRepetitions(repetition);
		return this;
	}

	public RepetitionBuilder repetition() {
		return new RepetitionBuilder(this);
	}

	public WorkoutBuilder end() {
		workoutBuilder.exercises(this.exercise);
		return workoutBuilder;
	}

	public Exercise build() {
		return exercise;
	}
}
