import {useState} from 'react';
export default function Board(){
    const [Moves,setMoves] = useState({blue:0,yellow:0,green:0,red:0});
    const[arr,setarr] = useState(["no moves"]);
   function updateBlue(){
        // setMoves(...Moves,Moves.blue+=1);
        // setMoves((prev_obj) => {
        //     return {...prev_obj,blue : prev_obj.blue+=1};//must be return
        // })
        // setarr([...arr,"new moves"]);
        //better option
        setarr((prev_Arr) => {
            return [...prev_Arr," new vlaue "];
        })



    }
    function updateYello(){
        setMoves((prev_obj) => {
            return {...prev_obj,yellow : prev_obj.yellow+=1};
        })
    }
    function updateGreen(){
        setMoves((prev_obj) => {
            return {...prev_obj,green : prev_obj.green+=1};
        })
    }
     function updateRed(){
        setMoves((prev_obj) => {
            return {...prev_obj,red : prev_obj.red+=1};
        })
    }
    
    return(<div>
        <div className="board">
            <p>{arr}</p>
            <p >Blue moves ={Moves.blue} </p>
            <button style={{backgroundColor:"blue",color:"white"}} onClick={updateBlue}>+1</button>
             <p>Yellow moves ={Moves.yellow}  </p>
            <button onClick={updateYello} style={{backgroundColor:"yellow",color:"black"}}>+1</button>
             <p>Green moves = {Moves.green} </p>
            <button onClick={updateGreen} style={{backgroundColor:"green",color:"white"}}>+1</button>
             <p>Red moves ={Moves.red}  </p>
            <button onClick={updateRed} style={{backgroundColor:"red",color:"white"}}>+1</button>


        </div>
        </div>);
}