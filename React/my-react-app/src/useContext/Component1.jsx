import React,{useState,useContext} from "react";
import Component2 from "./Component2";
export const userContext = useContext();

function MainComponent(){
    const[name,setName] = useState('Arhan');
    return(
        <div>
            <h1>componet 1</h1>
            <p>my name is :</p>
            <useContext.Provider value={name}>

            <Component2  name= {name}/>
            </useContext.Provider>
        </div>
    );
}
export default MainComponent;