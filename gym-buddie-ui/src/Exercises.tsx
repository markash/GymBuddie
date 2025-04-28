import Exercise from "./Exercise";
import { ExerciseProps } from "./Exercise";

export default function Exercises({exercises}: {exercises: ExerciseProps[]} ) {
  return (
    <div>
      {exercises.map((item) => (
        <Exercise key={item.id.toString()} exercise={item} />
      ))}
    </div>
  );
}
