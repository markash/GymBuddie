package com.github.markash.model;

public class ExerciseBuilder {

	private final Exercise exercise;
	private RepetitionBuilder repetitionBuilder;

	ExerciseBuilder() {
		this.exercise = new Exercise();
	}

	public ExerciseBuilder id(Integer id) {
		this.exercise.setId(id);
		return this;
	}

	public ExerciseBuilder name(String name) {
		this.exercise.setName(name);
		return this;
	}

	public ExerciseBuilder weight(double weight) {
		this.exercise.setWeight(weight);
		return this;
	}

	public ExerciseBuilder repetitions(Repetition...repetition) {
		this.exercise.addRepetitions(repetition);
		return this;
	}

	public RepetitionBuilder repetition() {
		return new RepetitionBuilder(this);
	}

	public Exercise build() {
		return exercise;
	}
}
