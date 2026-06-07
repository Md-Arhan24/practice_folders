import { useState } from "react";
import { v4 as uuidv4 } from "uuid";
import Todo from "./Todo";
export default function Todoui() {
  const [arr, setarr] = useState([{ text: "", id: uuidv4(),status:false }]);
  const [inputVal, setinputval] = useState("");
  let count = 0;
  function save_task() {
    if (inputVal.trim() == "") return;
    setarr((prev) => {
      return [...prev, { text: inputVal, id: uuidv4() }];
    });
    setinputval("");
  }
  let styles = {
    display: "flex",
    flexDirection: "column",
    justifyContent: "top",
    alignItems: "center",
    gap: "20px",
  };
  let style2 = {
    backgroundColor: "white",
    color: "black",
    padding: "13px 18px",
    borderRadius: "5%",
    display: "flex",
    justifyContent: "space-between",
    alignItems: "center",
    width: "20vw",
    height: "6vh",
  };
  let deleteTodo = (id) => {
    setarr((e) => {
      return e.filter((e) => e.id != id);
    });
  };
  let toUpper = () => {
    setarr((prev_arr) =>
        prev_arr.map((e) => ({
            ...e,text:e.text.toUpperCase(),
        }))
    )
  };
  let toLower = () => {
    setarr((prev_arr) => 
        prev_arr.map((e) => ({
            ...e,text:e.text.toLowerCase(),
        }))
    )
  };
  let isDone = (id) => {
   return setarr((prev_arr) => {
      return prev_arr.map((e) => {
        if(e.id == id){
            return {
                ...e,status:!e.status
            }
        }else{
            return e;
        }
       })
    })
  }
    
  /*
  let toUpper = () => {
  setarr((prev_arr) =>
    prev_arr.map((e) => ({
      ...e,
      text: e.text.toUpperCase(),
    }))
  );
}; */
  return (
    <>
      <div className="search_bar" style={styles}>
        <div style={{ display: "flex" }}>
          <input
            style={style2}
            type="text"
            className="todoval"
            value={inputVal}
            onChange={(e) => setinputval(e.target.value)}
          />
          <button className="sb" onClick={save_task}>
            <b>+</b>
          </button>
        </div>

        {arr
          .filter((val) => val.text.trim() != "")
          .map((val, idx) => (
            <Todo
              text={val.text}
              key={val.id}
              id={val.id}
              onDelete={deleteTodo}
              status={val.status}
              onDone={isDone}
            ></Todo>
          ))}
      </div>
      <button onClick={toUpper}>TO UPPER CASE</button>
      <button onClick={toLower}>TO lower CASE</button>
    </>
  );
}
