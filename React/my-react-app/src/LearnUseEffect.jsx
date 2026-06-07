import { useState,useEffect } from "react";
//any time for any variabel if you want to change in the document create a 
//state for it.
function LearnUseEffect(){

    const[click,setClick] = useState(0);
    

    function increament(){
        setClick(c => c + 1);
    }
    //a use effect is like we have created a effect and we use
    //it when a particular action is happend like
    //1-element value change [renderd]
    // 2-if new element added [mount]
    // 3-if value change or mount 
    useEffect(()=>{
        document.title = `count = ${click}`
    },[click])
    return(
        <div>
            <p>count = {click}</p>
            <button onClick={increament}>count+1</button>

        </div>
    )
}
export default LearnUseEffect;