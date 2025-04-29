package com.github.markash.model;

public class WorkoutBuilder {

	private final Workout workout;

	WorkoutBuilder() {
		this.workout = new Workout();
	}

	public WorkoutBuilder id(final Integer id) {
		this.workout.setId(id);
		return this;
	}

	public WorkoutBuilder name(final String name) {
		this.workout.setName(name);
		return this;
	}

	public WorkoutBuilder description(final String description) {
		this.workout.setDescription(description);
		return this;
	}

	public WorkoutBuilder exercises(Exercise...exercise) {
		this.workout.addExercise(exercise);
		return this;
	}

	public ExerciseBuilder exercise() {
		return new ExerciseBuilder(this);
	}

	public Workout build() {
		return workout;
	}
}
