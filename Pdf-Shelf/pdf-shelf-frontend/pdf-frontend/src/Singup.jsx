import React from 'react'
import TextField from "@mui/material/TextField";
import { useState } from 'react';
import Button from "@mui/material/Button";
import './Singup.css'
import {singupUser} from './services/api';
const Singup = () => {
  const [singupData,setSingUpData] = useState({name:'',email:'',password:''});

  function handleSingupData(event){
    setSingUpData((prev_obj) => {
      return {...prev_obj,[event.target.name]:event.target.value};
    })
  }

  async function handleSubmit(event){
    event.preventDefault();
    try{

      let user = await singupUser(singupData.name,singupData.email,singupData.password);
      if(user.message){
        window.location.href = "/main";
      }
      console.log(singupData);
    }catch(e){

      alert("error occured");

    }
    setSingUpData({name:'',email:'',password:''});
  }

  return (
    <div className='singup'>
        <div className="form">
            <form action="/" onSubmit={handleSubmit} method="post">
                <h1>Sing up</h1>
                 <TextField id="outlined-basic" label="Name" variant="outlined" placeholder='Name' name='name' onChange={handleSingupData}/>
                 <TextField id="outlined-bsic" label="Email" variant="outlined" placeholder='Email' name='email'onChange={handleSingupData} />
                 <TextField id="outlined-bas" label="Password" variant="outlined" placeholder='password' name='password' onChange={handleSingupData}/>
                 <Button variant="contained" type='submit'>Sing up</Button>
                 <span>already have an account ? <a href='/'>login</a></span>
            </form>
        </div>

    </div>
  )
}

export default Singup