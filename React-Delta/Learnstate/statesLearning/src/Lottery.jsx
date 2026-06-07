export default function Lottery(){
    let random = math.random();
    return(
        <div>
            <h2>kello</h2>
            <h1>{random*100}</h1>
        </div>
    );
}