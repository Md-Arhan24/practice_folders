import React,{useContext} from "react";
import { userContext } from "./Component1";
function Component3(){
const name = useContext(userContext());
    return(
        <>
        <div>
            <h1>{name}</h1>
        </div>
        </>
    )
}
export default Component3;