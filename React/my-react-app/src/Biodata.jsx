import React,{useState} from "react";

function Biodata(){
    const [data,setData] = useState([]);
    const[naam,setNaam] = useState("");
    const [Dob,setDob] = useState(2006);
    const [Father,setFather] = useState("");


    function handelShowData(){
        const newNames = {name:naam,
                        dad:Father,
                        year:Dob};
        setData( d => ([...d,newNames]))
        setDob("");
        setFather("");
        setNaam("");
    }
    function handelRemoveData(index){
        //the below is the mistake i have wrote because i have thought that
        //there should be the previous data when i remove one of data form it
        //but i was wrong because the filter method will filter(remove and addd) all the 
        //elements of it.
        // setData(...d,d.filter((_,i) => i !== index))
        
        setData(d => d.filter((_,i) => i !== index))
        
    }
    function hadelNaam(event){
        setNaam(event.target.value);

    }
    function hadelDob(event){
        setDob(event.target.value);
    }
    function hadelFather(event){
        setFather(event.target.value);
        
    }

    return(<div>
          <h1>bio data</h1>

          <ul>
            {/* {data.map((ele,i) =>{ BIG MISTAKE:that i have kept a flower {} at the starting and ending
            of arrow of function as it is necessary to maintain the arrow function syntax ,
            but in react we dont have to put {} at start and end because we are returning it.
                <><li key={i}>{ele.name} {ele.dad} {ele.year}</li></>
})} */} 
            {data.map((ele,i) =>
                <><li key={i}>{ele.name} {ele.dad} {ele.year} <i onClick={() =>handelRemoveData(i)}>X</i></li></>
            )}


          </ul>
          <input type="text" placeholder="enter name" onChange={hadelNaam} value={naam}/><br />
          <input type="text" placeholder="enter father name" onChange={hadelFather} value={Father}/><br />
          <input type="number"  onChange={hadelDob} value={Dob}/><br />
          <button onClick={handelShowData}>submit</button>
    </div>);
}
export default Biodata;