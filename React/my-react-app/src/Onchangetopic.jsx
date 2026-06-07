import React,{useState} from 'react';
function Onchangetopic(){

    const [radio,setRadio] = useState("true");

    function checkRadio(e){
        setRadio(e.target.value);
    }
    return(<div>
        <label>
            <input type="radio" value="true" checked={radio === "yes"} onChange={checkRadio}/> true
        </label>
        <br/>
        <label >
        {/* <label>the checked is use the check whether the value is given one or not if not it break */}
            <input type="radio" value="medium" checked={radio === "medium"} onChange={checkRadio}/> medium
        </label>
        <br />
        <label >
        {/* <label>the checked is use the check whether the value is given one or not if not it break */}
            <input type="radio" value="false" checked={radio === "false"} onChange={checkRadio}/> false
        </label>
        <p>selected : {radio}</p>
    </div>)
}
export default Onchangetopic;