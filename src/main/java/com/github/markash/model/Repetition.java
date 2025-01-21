package com.github.markash.model;

import lombok.Data;

@Data
public class Repetition {
	private Integer id;
	private State state;
	private Integer value;

	public void moveToNextState() {
		State nextState = switch (state) {
			case New -> State.Done;
			case Done -> State.New;
			case Skip -> State.Skip;
		};
		setState(nextState);
	}
}
