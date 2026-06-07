import React,{useState} from 'react';
function ColorPicker(){
 
    //creating a color picker//inital value is white color
    const [color,setcolor] = useState("#ffffff");

    function changecolor(e){
        setcolor(e.target.value)
    }
    return(
        <div>
            <h1>color picker</h1>
            <div className="display" style={{backgroundColor:color}}>
               <h2> selected color : {color}</h2>
            </div>
            <div className="result">
                <h4>select the color</h4>
            <input type="color" onChange={changecolor} />

            </div>
        </div>
    )
}
export default ColorPicker;