//response can only be send once from the file.

const express = require('express');//import the express
const app = express();//define the app using express
const port = 3000;

// app.use(express.static('public'))
app.use('/static', express.static('public'))//this is used to add a virtual path (your own path ) .
//here user should have to use /static befor path to aceess the data

//middle ware concept -> a concept use between the req and response use to 
//perform modify operations to the request that has came 
//like getting the time stamp etc.
//syntax;it works when we send the request (refresh)
app.use((req,res,next) =>{
    console.log(`the time is ${Date.now()} at ${req.method}`)
    console.log('m2');
    next()
})

// you can load the files that are in the public directory:
//you must have to use extension of public file
app.get('/',(req,res)=>{
    res.send('hello world!')
})

app.get('/:slug',(req,res) =>{ 
    //mistake 
    //1- i have wrote first response then request like this(res,req)
    res.send(`you are at ${req.params.slug} page`)
})

// app.get('/:slug',(req,res) =>{
//     res.send(`you are in ${req.params.slug} page`);//we can create multiple pages by usign var
//   })
app.listen(port,()=>{
    console.log(`the server started at ${port}`);
})