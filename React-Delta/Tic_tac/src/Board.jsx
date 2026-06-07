import { useState } from "react";
import Square from "./Square";
export default function Board() {
  //array
  const [pices, setPices] = useState(Array(9).fill(null));
  const [isTrunx, SetisTrunx] = useState(true);
  function handledClick(i) {
    //if pices[i] is already there
    if (pices[i] || checkWin(pices)) {
      return;
    }
    let arr = pices.slice();
    if (isTrunx) {

      arr[i] = "X";
    } else {
      arr[i] = "O";
    }
    setPices(arr);
    SetisTrunx(!isTrunx);
  }
  function checkWin(pices) {
    let winValue = [
      [0, 1, 2],//top - row
      [3, 4, 5],//middle - row
      [6, 7, 8],//bottom - row
      [0, 3, 6],//left most colum
      [1, 4, 7],//middle columc
      [2, 5, 8],//right column
      [0, 4, 8],//diagnaol
      [2, 4, 6],//diagnoal
    ];
    for(let i = 0;i < winValue.length;i++){
        const [a,b,c] = winValue[i];
        if(pices[a] && pices[a] == pices[b] && pices[a] == pices[c]){
            return pices[a];
        }
    }
    return null;
  }
  let status;
  let winner = checkWin(pices);
  if(winner){
    status = "winner is " + winner;
  }else{
    status = "Next player is " + (isTrunx?"X":"O");
  }
  return (
    <div>
      <h2>{status}</h2>
      <div className="Board">
        <Square value={pices[0]} handledClick={() => handledClick(0)} />
        <Square value={pices[1]} handledClick={() => handledClick(1)} />
        <Square value={pices[2]} handledClick={() => handledClick(2)} />
      </div>
       <div className="Board">
        <Square value={pices[3]} handledClick={() => handledClick(3)} />
        <Square value={pices[4]} handledClick={() => handledClick(4)} />
        <Square value={pices[5]} handledClick={() => handledClick(5)} />
      </div>
       <div className="Board">
        <Square value={pices[6]} handledClick={() => handledClick(6)} />
        <Square value={pices[7]} handledClick={() => handledClick(7)} />
        <Square value={pices[8]} handledClick={() => handledClick(8)} />
      </div>
    </div>
  );
}
