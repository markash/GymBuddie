import { useState } from "react";

export interface SetProps {
  id: Number, 
  repetition: Number, 
  done: Boolean
}

export default function SetButton({set} : {set: SetProps}) {
  const [exerciseSet] = useState<SetProps>(set);

  function handleClick() {}

  return (
    <button
      key={exerciseSet.id.toString()}
      className={exerciseSet.done ? "primary" : "secondary"}
      onClick={handleClick}
    >
      {exerciseSet.repetition.toString()}
    </button>
  );
}
