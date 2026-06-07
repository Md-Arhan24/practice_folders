import { useEffect, useState } from "react";

export default function JokerSayer() {
  let url = "https://official-joke-api.appspot.com/random_joke";
 
  //create a state to store the joke
  const [joke, setJoke] = useState({}); //define with empty object.

  //and we want when every the page first render it should get the joke
  useEffect(() => {
    getjoke(); //calling getJoke.
  }, []);

  async function getjoke() {
    console.log("claed");
    let res = await fetch(url);
    let json = await res.json();
    setJoke({ setup: json.setup, punchline: json.punchline });
  }

  return (
    <div>
      <h2>{joke.setup}</h2>
      <h3>{joke.punchline}</h3>
      <button onClick={getjoke}>get new Joke</button>
    </div>
  );
}
