import React from "react";
import UploadFileIcon from "@mui/icons-material/UploadFile";
import Button from "@mui/material/Button";
import FileUploadIcon from "@mui/icons-material/FileUpload";
import './Middle.css';
const Middle = () => {
  return (
    <div className="main">
      <div className="right">
        <UploadFileIcon sx={{ fontSize:19 }} id='upload'/>
        <h2>Drag & Drop your file here</h2>
        <h5>or</h5>
        <Button
          variant="contained"
          color="success"
          startIcon={<FileUploadIcon />}
        >
          Click to uploade your file
        </Button>
      </div>
      <div className="left">
        <h2>Organize & Arrange pdf</h2>
        <p>
          so you can seprate your pdf or make <br/>
          the collection of your own
        </p>
          <h2>Save & Secure</h2>
        <p>
          We make sure you access them any where <br/>
          your pdf are in the irght hand
        </p>
          <h2>Create & Manage pdf</h2>
        <p>
          Here we manage all of your stuff <br/>
          and let your create a new Pdf
        </p>
      </div>
    </div>
  );
};

export default Middle;
