const express = require('express');
const app = express();
const expressError = require('./expressError');
const port = 8080;

app.use('/apis',(req,res,next) => {
    let {token} = req.query;
    if(token == "giveAccess"){
        next();
    }else{
       throw new expressError("You are not allowed to access this api", 401);
    }
})

app.use('/admin',(req,res,next) => {
  let {token} = req.query;
  if(token == "iamadmin"){
    next();
  }else{
    throw new expressError("only admin can access",404);
  }
})

app.use((err,req,res,next) => {
 
  
  next(err);
})
app.use((err,req,res,next) => {
  let {status,message} = err;

  res.status(status).send(message); //once the browser gets response we cant send another one
  // next();
})


app.get('/', (req, res) => {
  res.send('Hello World!'); 
});
app.get('/apis',(req,res) => {
    res.send("<h1>welcome to new future</h1>");
})

app.get('/admin',(req,res) => {
  res.send("welcome admin");
})

app.listen(port, () => {
  console.log(`Server is running on http://localhost:${port}`);
});