import React,{useState} from 'react';
function Unstate(){
    var [count,setcount] = useState(0);
   
    //the usestate hook is use to change the dom as its updated awesome
    function Decrease(){
        setcount(count-1);
        // or
        // setcount(dec = count-1);
    }
    function reset(){
        setcount(0);
    }
    function increase(){
        setcount(count+1);
    }



    return(
       <div>
        <h1>{count}</h1> 
        <button onClick={Decrease}>Decrease</button>
        <button onClick={reset}>reset</button>
        <button onClick={increase}>increase</button>       
       </div>
    )

}
export default Unstate;