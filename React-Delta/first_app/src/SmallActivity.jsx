export default function SmallActivity({user_name,color}){
    let sty = {color:color};
    user_name = user_name.charAt(0).toUpperCase() + user_name.slice(1);
    return(
       <div style={sty}>
        <h1>Hello {user_name}</h1>
       </div>
    );
}
