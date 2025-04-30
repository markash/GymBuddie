import { useEffect, useState } from "react";
import Header from "./Header.tsx";
import Exercises from "./Exercises.tsx";
import { ExerciseProps } from "./Exercise.tsx";
import { State } from "./SetButton.tsx";

const data = [
  {
    id: 100,
    name: 'Test',
    description: 'Test',
    exercises: [
      {
        id: 1,
        number: 1,
        name: "Push Up",
        description:
          "Assume a plank position, hands below your elbows and shoulders.<br/>Slowly bend your elbows to lower your chest to the floor (A). Keep your upper arms from flaring as you explosively push up to a straight arm position (B). Repeat.",
        weight: 0,
        sets: [
          { id: 1, repetition: 25, state: State.New },
          { id: 2, repetition: 10, state: State.New },
          { id: 3, repetition: 10, state: State.Done },
        ],
      },
      {
        id: 2,
        number: 2,
        name: "Plank shoulder tap",
        description:
          "Assume the plank position, arms straight, hands below your shoulders (A).<br />Reach hand up and touch the opposite shoulder (B), then place the hand back down and repeat with the other hand in quick succession. Keep your torso rigid and fighting rotation.",
        weight: 0.0,
        sets: [
          { id: 1, repetition: 25, state: State.New },
          { id: 2, repetition: 10, state: State.New },
          { id: 3, repetition: 10, state: State.Done },
        ],
      }
    ]
  }
];

export interface Workout {
  /** The unique identifier for the workout */
	id: Number;
	/** The name of the workout */
	name: String;
	/** The description of the workout */
	description: String;
  /** The exercises of the workout */
  exercises: ExerciseProps[]
}


export default function App() {

  const [workouts, setWorkouts] = useState<Workout[]>(data);

  useEffect(() => {
    fetch(`${import.meta.env.VITE_API_URL}/workouts`)
      .then((response) => {
        return response.json();
      })
      .then((data) => {
        const w = data as Workout[];
        setWorkouts(w);

        console.log(w);
      });
  }, []);

  return (
    <div className="App">
      <Header />
      <Exercises exercises={workouts[0].exercises} />
    </div>
  );
}