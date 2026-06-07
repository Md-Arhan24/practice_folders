import './Square.css';
export default function Square({value,handledClick}){
  
    return(
        <>
        <button className="square" onClick={handledClick}>{value}</button>
        </>
    );
}