function printHello(){
    console.log("hello user");
}
export default function Button({col}){
    let styles = {
        color:"white",
        backgroundColor:col,
        borderRadius:"5%",
        border:"1px solid black",
        textAlign:"center",
        marginLeft:"40vw"
    };
    return(
        <>
        <button style={styles} onMouseOver={printHello}> Click me!</button>
        </>
    );
}