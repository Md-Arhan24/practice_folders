import React, { use } from 'react'
import AutoStoriesIcon from '@mui/icons-material/AutoStories';
import Button from '@mui/material/Button';
import Login from './Login';
import Singup from './Singup';
import './Nav.css'
import { useNavigate } from 'react-router-dom';
const Nav = () => {
  const navigate = useNavigate();
  function handleNavigate(path){
    navigate(path);
  }
  return (
    <div id='nav-bar'>
        <div className="head">
            <AutoStoriesIcon sx={{ fontSize: 40 }} color="secondary" />
            <div>
            <h1>PDF - SHELF</h1>
            <h5>Your Device - Your Wish</h5>
            </div>
        </div>
        <div className="singup">
         <Button variant="contained" onClick={() => handleNavigate('./Login')}>Log in</Button>
      <Button variant="outlined" onClick={() => handleNavigate('./Singup')}>Sing up</Button>
        </div>
    </div>
  )
}

export default Nav