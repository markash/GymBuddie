import SetButton from "./SetButton.tsx";
import { SetProps } from "./SetButton.tsx";

export interface ExerciseProps {
  /** The unique identifier for the exercise */
  id: Number,
  /** The number of the exercise in the workout */
  number: Number,
  /** The name of the exercise */
  name: String,
  /** The description of the exercise */
  description: String,
  /** The weight setting on the equipment of the exercise */
  weight: Number,
  /** The sets of the exercise */
  sets: SetProps[]
}

export default function Exercise({exercise}: {exercise: ExerciseProps}) {
  return (
    <article key={exercise.id.toString()} className="mx-auto max-w-lg mt-5 overflow-hidden rounded-xl bg-white shadow-md md:max-w-3xl">
      <h2>
        <span className="text-orange-700 mt-5 text-base font-bold tracking-tight">{"0" + exercise.number}&nbsp;</span>
        <span className="text-gray-900 mt-5 text-base font-bold tracking-tight">{exercise.name}</span>
      </h2>
      <p className="text-gray-500 dark:text-gray-400 mt-2 text-sm">{exercise.description}</p>

      {exercise.sets.map((set: SetProps) => (
        <SetButton key={set.id.toString()} set={set} />
      ))}
    </article>
  );
}
