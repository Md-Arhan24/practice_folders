import './ShowComments.css';
export default function ShowComments({comment}){
    comment = comment.filter((e) => 
        e.username || e.remark ||e.rating
    );
    return(
        <div id="showCardCommet">
            {comment.map((e,idx) =>(
                <div id="showComment" key={idx} >
                    <h2>Name :{e.username}</h2>
                    <h3>Remark :{e.remark}</h3>
                    <h3>Rating:{e.rating}</h3>
                </div>
            ))}
        </div>
    );
}