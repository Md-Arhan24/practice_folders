const express = require('express');
const app = express();
const path = require('path');

const port = 3030;
app.set("view engine","ejs");//set()-is basically a function use to set various things and one of the things
// is view e

app.set('views',path.join(__dirname,'/views'));
app.get('/',(req,res)=>{
    res.render('home.ejs');
})
app.get('/rolldice',(req,res)=>{
    let database = Math.floor(Math.random() * 6) +1;
    res.render('rolldice.ejs',{num : database});
})
app.get('/id/:username',(req,res)=>{
    let user = req.params ;
    res.render('rolldice.ejs',{user});
})
app.listen(port,()=>{
    console.log('server started');

})