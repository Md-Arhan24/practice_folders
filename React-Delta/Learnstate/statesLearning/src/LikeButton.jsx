import { useState } from "react";

export default function LikeButton(){
    const [isLike,setisLike] = useState(false);
    let toggle = () => {
        setisLike(!isLike);
    }
    let styles = {color:"red"};

    return(
        <>
        <p onClick={toggle}>
        {isLike ? <i style={styles}className="fa-solid fa-heart"></i> :<i className="fa-regular fa-heart"></i> }
        </p>
        </>
    );
}