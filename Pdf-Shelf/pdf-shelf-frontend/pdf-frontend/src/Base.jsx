import { useState,useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import Nav from './Nav'
import './Base.css';
import Middle from './Middle';



export default function Base() {
  const navigate = useNavigate();
  useEffect(() => {
    fetch('http://localhost:8080/api/users/check',{
      credentials:'include',
    })
    .then(res => res.json())
    .then(data => {
      if(!data.isLogin){
        navigate('/login');
      }
    })
  },[navigate]);
  return (
    <div id="main">
        <Nav/>
      <h1 id='title'>The Best Online Pdf Organizer</h1>
      <h4 id='small'>Organize the Pdf & Arrange them how you want!</h4>
      <Middle/>
    </div>
  );
}
