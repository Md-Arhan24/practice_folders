const API_URL = 'http://localhost:8080/api';

export const singupUser = async (name,email,password) => {
    try{
        const response = await fetch(`${API_URL}/users/singup`,{
            method:'POST',
            headers:{'Content-Type':'application/json'},
            body:JSON.stringify({name,email,password})
        });
        return await response.json();

    }catch(e){
        console.log("error occured");
        throw e;

    }
}
export const loginUser = async (email,password) => {
    try{
        let data = await fetch(`${API_URL}/users/login`,{
        method:'POST',
        headers:{'Content-Type':'application/json'},
        body : JSON.stringify({email,password})
    });
    return await data.json();
    }catch(e){
        console.log("error occured");
        throw e;
    }
}