export default function Todo({text,id,onDelete,status,onDone}){
    let styles = {
        backgroundColor:"white",
        color:"black",
        padding: "13px 18px",
        borderRadius:"5%",
        display:"flex",
        justifyContent:"space-between",
        alignItems:"center",
        width:"20vw",
        height:"6vh"
    }
    let del1 = {
        height:"5%",
        width:"5%",
        backgroundColor:"red",
        color:"white",
        borderRadius:"3%",
        textAlign:"center"
    }
    
    return(
        <div className="card" style={styles}>
            <p>{text}</p>
            <div>
            {status ? "V" : "X" }
            <button onClick={() => onDelete(id)} style={del1}className="del" id={id} >X</button>
            <button onClick={() => onDone(id)}  id={id} >Done</button>
            </div>
        </div>
    );
}