import React from "react";
import Button from "@mui/material/Button";
import { useNavigate } from 'react-router-dom';
import Login from "../Login";
import "./Bottom.css";
const Bottom = () => {
  const navigate = useNavigate();
  function handleNavigate(path){
    navigate(path);

  }
  return (
    <div className="home-main">
      <div className="right-main-bottom">
        <h1>PDF-ORGANIZER</h1>
        <h2>A place for everything, and everything in its place</h2>
        <br />
        <br />
        <h3>A free tool to help you organize your PDF files effortlessly</h3>
        <br />
        <br />
        <p>
          I used to struggle with managing a large collection of PDF documents.
          None of the existing apps offered the flexibility to organize them the
          way I wanted. So, I built this solution — a simple, intuitive tool
          that puts you in control.
        </p>
        <br />
        <Button variant="contained" color="success" onClick={() => handleNavigate('./Login')}>
          Get Started
        </Button>
      </div>
      <div className="left-main-bottom">
        <img src="devices.webp" alt="image" />
      </div>
    </div>
  );
};

export default Bottom;
