import { useState } from "react";
import { GenTicket,sum} from "./helper.js";
import Ticket from "./Ticket.jsx";

export default function Lottery({n,winningSum}){
    //here we need a state varibale for array
    const[arr,setArr] = useState(GenTicket(n));
    let isWin = winningSum(arr);
    function genLot(){
        setArr(GenTicket(n));
    }
    return(
        <div>
            <h1>Lottery Game</h1>
            <Ticket tickets={arr} />
            <br />
            <button onClick={genLot}>Start Game</button>
            {isWin && <h1>you won!</h1> }
        </div>
    );
}