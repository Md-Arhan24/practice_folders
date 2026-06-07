import { useState } from "react";
export default function Counter() {
  
  const [count, setCount] = useState(0);
    function handelClick() {
    setCount(count+1);
  }
  return (
    <>
      <button onClick={handelClick}>click time :{count}</button>
    </>
  );
}
