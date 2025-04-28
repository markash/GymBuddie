package com.github.markash.model;

public class RepetitionBuilder {

	private final Repetition repetition;
	private final ExerciseBuilder exerciseBuilder;

	RepetitionBuilder(ExerciseBuilder exerciseBuilder) {
		this.exerciseBuilder = exerciseBuilder;
		this.repetition = new Repetition();
		this.repetition.setState(State.New);
	}

	public RepetitionBuilder id(Integer id) {
		this.repetition.setId(id);
		return this;
	}

	public RepetitionBuilder state(final State state) {
		this.repetition.setState(state);
		return this;
	}

	public RepetitionBuilder value(final int value) {
		this.repetition.setValue(value);
		return this;
	}

	public ExerciseBuilder end() {
		exerciseBuilder.repetitions(this.repetition);
		return exerciseBuilder;
	}
}
