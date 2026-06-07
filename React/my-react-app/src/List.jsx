
function List(props){
    const fruits = ['apple','orange','banana'];
    return(
        <>
        <h2>{props.name}</h2>
        <h3>{props.info}</h3>
        <ul>{fruits.map(f => <li>{f}</li>)}</ul>
        </>
    );

}
export default List;