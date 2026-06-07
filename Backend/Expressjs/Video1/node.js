// const http = require('node:http');

// const hostname = '127.0.0.1';
// const port = 3000;

// const server = http.createServer((req, res) => {
//   res.statusCode = 200;
//   res.setHeader('Content-Type', 'text/plain');
//   res.end('Asslamalikum!\n');
// });

// server.listen(port, hostname, () => {
//   console.log(`Server running at http://${hostname}:${port}/`);
// });


//this code is belong to express js 
// why?because it provide us more security and it is ease to use and manage then http.
const express = require('express');//import the express
const app = express();//define the app using express
const port = 3000;//choosen the port
//app.get(path,handler) when ever there i a 

//it will be huge mistale if you make the files puclic cally avialabel ,but some files 
//we need to be public availabel .to do create a folder name public and then 
// app.use(express.static.apply('public'));
app.get('/',(req,res) =>{
  res.send('asslamaliksum');
})
app.get('/about',(req,res) =>{//go to google chrome and paste the url localhost:3000/about will will see
  //the out put
  res.send(' your are in about');
})
app.get('/home',(req,res) =>{
  res.send('you are in home page');
})

//if you want to make the 10 pages like home support etc then you have to make 10 app.get function to over
//come this we use VARIABEL CONCEPT in this app.get function here is how it is:
app.get('/:slug',(req,res) =>{
  res.send(`you are in ${req.params.slug} page`);//we can create multiple pages by usign var
})
app.listen(port,() =>{
  console.log(`asslamalikum warahmatullahi wabarkatahu ${port}`);
})