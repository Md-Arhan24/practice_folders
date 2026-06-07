import React from "react";
import TextField from "@mui/material/TextField";
import Button from "@mui/material/Button";
import Typography from "@mui/material/Typography";
import { useState } from "react";
import "./Login.css";
import {loginUser} from './services/api.js';
const Login = () => {
  const [loginData,setLoginData] = useState({email:'',password:''});
  const [loading, setLoading] = useState(false);

  function handleLoginData(event){
    setLoginData({...loginData , [event.target.name]:event.target.value});
  }

  async function handleSubmit(e){
    console.log("called");
    e.preventDefault();//fony put target here
    setLoading(true);
    console.log("submit called");
    try{
    let user = await loginUser(loginData.email,loginData.password);
      if(user.message){
        alert(user.message);
        window.location.href = "/main";
      }
      
    }catch(e){
      alert("error occured: " + e.message);
    }
    finally{
      setLoading(false);
      setLoginData({email:'',password:''});
    }
  }
  return (
    <div className="loginpage">
      <div className="form">
        <form onSubmit={handleSubmit}>
          <Typography variant="caption" gutterBottom sx={{ display: "block" }}>
            <h2>Log in</h2>
          </Typography>
          <Typography variant="caption" gutterBottom sx={{ display: "block" }}>
            <h3>E-Mail</h3>
          </Typography>

          <TextField id="email" label="E-mail" variant="outlined" name="email" onChange={handleLoginData} />
          <Typography variant="caption" gutterBottom sx={{ display: "block" }}>
            <h3>PassWord</h3>
          </Typography>
          <TextField id="password" label="password" variant="outlined" name="password" onChange={handleLoginData}/>
          <Button variant="contained" color="success" type="submit">
            Log in
          </Button>
          <span>
            dont have an account ? <a href="/">sing up</a>
          </span>
        </form>
      </div>
    </div>
  );
};

export default Login;
