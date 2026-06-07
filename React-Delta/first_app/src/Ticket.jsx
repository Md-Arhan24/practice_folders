import TicketNum from "./TicketNum";
export default function Ticket({tickets}){
    let styles = {
            border:"1px solid pink",
            borderRadius: "5%",
            width: "25vw",
            textAlign:"center",
    }

    return(
        <div style={styles}>
           {tickets.map((ele,idx) =>( // the main thing is we dont have to keep braces here ,just keep ()
                <TicketNum key={idx} n={ele}/>
           ))}
        </div>
    );

}