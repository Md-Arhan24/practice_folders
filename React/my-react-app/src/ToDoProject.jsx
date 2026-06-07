import React,{ useState } from "react";
// import styled from 'styled-components';

function ToDoProject(){
   

    const [task,setTask] = useState(["running"+"\n"]);//forgotten to put array
    const[inputTask,setinputTask] = useState("")

    function inputTextUpdate(event){
        setinputTask(event.target.value);//change the text dynamic in input from
    }
    function addTask(){
        setTask(t => [...t, inputTask]);
        setinputTask("")
    }

    function removeTask(index){
        setTask(task.filter((_,i) => i!==index ))
    }
    function moveUp(index){
        if (index > 0){
        const prevTasks = [...task];
        [prevTasks[index],prevTasks[index-1]] = [prevTasks[index-1],prevTasks[index]]//we are swaping the task
        //suppose [task1,task2] = [task2,task1] task 1 = task 2| task 2 = task 1
    }
}
    function moveDown(index){

        if (index < 0){
            const prevTasks = [...task];
            [prevTasks[index],prevTasks[index+1]] = [prevTasks[index+1],prevTasks[index]]//we are swaping the task
            //suppose [task1,task2] = [task2,task1] task 1 = task 2| task 2 = task 1
        }
        
    }
    return(<div>
          <heading>
            TO DO LIST
          </heading>
          <input type="text" placeholder="enter task" onChange={inputTextUpdate} value={inputTask}/>
          <button onClick={addTask}>add</button>
          <ol>
            {task.map((ele,index) =>
               <li key={index}>
                <span>{ele}</span>
                {/* when i code i have kept some part of my mind which leads to a basic mistake 
                that i have use a map and in it there is a ele which is equal to task 
                but when i done it i have wrote task which is array total values and i try what mistakws i have done */}
               <button onClick={() => moveUp(index)}> up</button>
               <button onClick={() => moveDown(index)}>down</button >
               <button onClick={() => removeTask(index)}>X</button> </li>
            )}
          </ol>
    </div>)
}

export default ToDoProject;