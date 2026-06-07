import {useState} from 'react';
function Todolist(){

    const[task,setTask] = useState(['running','journaling']);

    function addTask(){
        const val = document.querySelector("#enterTask").value;
        document.querySelector("#enterTask").value = '';
        setTask([...task,val]);
        

    }
    function removeTask(){

    }

    return(<div>
          <h2>TASK TO DO</h2>
          <ul>
            {task.map((ele,i) => <><input type="checkbox" /><label htmlFor="sting" key={i}>{ele}</label><br/></>)}

          </ul>
          <input type="text" id='enterTask' placeholder='enter the task' /><button onClick={addTask}>+</button>
    </div>);
    
}
export default Todolist;