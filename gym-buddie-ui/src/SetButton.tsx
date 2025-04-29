import { useState } from "react";

export enum State {
	New,
	Done,
	Skip
}

export interface SetProps {
  id: Number, 
  repetition: Number, 
  state: State
}

export default function SetButton({set} : {set: SetProps}) {
  const [exerciseSet] = useState<SetProps>(set);

  function handleClick() {}

  return (
    <button
      key={exerciseSet.id.toString()}
      className={exerciseSet.state == State.Done ? "primary" : "secondary"}
      onClick={handleClick}
    >
      {exerciseSet.repetition.toString()}
    </button>
  );
}
