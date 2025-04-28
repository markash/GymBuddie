import { useState } from "react";
import Header from "./Header.tsx";
import Exercises from "./Exercises.tsx";
import { ExerciseProps } from "./Exercise.tsx";


const data = [
  {
    id: 1,
    number: 1,
    name: "Push Up",
    description:
      "Assume a plank position, hands below your elbows and shoulders.<br/>Slowly bend your elbows to lower your chest to the floor (A). Keep your upper arms from flaring as you explosively push up to a straight arm position (B). Repeat.",
    weight: 0,
    sets: [
      { id: 1, repetition: 25, done: false },
      { id: 2, repetition: 10, done: false },
      { id: 3, repetition: 10, done: false },
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
      { id: 1, repetition: 25, done: false },
      { id: 2, repetition: 10, done: false },
      { id: 3, repetition: 10, done: false },
    ],
  },
];

export default function App() {
  const [exercises] = useState<ExerciseProps[]>(data);

  return (
    <div className="App">
      <Header />
      <Exercises exercises={exercises} />
    </div>
  );
}
