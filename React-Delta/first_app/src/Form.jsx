function handleSubmit(event){
    event.preventDefault();
 
    console.log(event);
}
function handleValue(event){
    console.log(event.target.value);
}

export default function Form(){
    return(
        <form action="/" onSubmit={handleSubmit}>
            <input type="text" onChange={handleValue}/>
            <button>submit</button>
        </form>
    );
}