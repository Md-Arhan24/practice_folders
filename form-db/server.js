import express from 'express';
import path from 'path';

const app = express();
function setInfo(){
app.get('/submit',(req,res)=>{
    console.log(req.body);
    // res.send('hello')
    res.sendFile('user.html',{root:__dirname});
})

app.listen(3000,()=>{
    console.log("server started at 3000 port");
})
}