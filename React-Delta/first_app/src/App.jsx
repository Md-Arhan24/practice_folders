import Todo from "./Todo";
import Lottery from "./Lottery";
import { sum } from "./helper";

function App() {
  let winCodi = (lottery) =>{
    return lottery.every((num) => num === lottery[0]);
  }
  
  return (
<Lottery n={3} winningSum={winCodi}/>
  );
}

export default App;
// <div className="container">

    // <Card title={"mouse"} img={mouseUrl} desc={freatures} price={700} cutoff={1000}/>
    // <Card title={"Key board"} img={keyBoard} desc={freatures} price={700} cutoff={1000}/>
    // <Card title={"apple pen"} img={applePen} desc={freatures} price={700} cutoff={1000}/>
    // </div>