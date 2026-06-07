function Button(){
    const click = () =>{
        alert("button was clicked");
    }
    let count = 0;
    const click1 = (name) =>{
        count= count + 1;
         document.querySelector("h3").innerText = `count : ${count}`;
        // alert(`button was clicked by ${name} : ${count}`);
       
    }
    
    return(
        <>
          <div className="container">
          <div className="count"><h3>count:{count}</h3></div>
        {/* {comment should be write like this} */}
        {/* //we use arrow function to send data from the element to the function
        // <button className="btn" onClick={click1("arhan")}>click me</button>
        // the above example wonts work */}
    
        <button className="btn" onClick={() => click1("arhan")}>click me</button>
        </div>
        </>
    );
}
export default Button;