const express = require('express');
const path = require('path');
const app = express();


let port = 8080;

app.set('view engine','ejs');//set engine
app.set('views',path.join(__dirname,'/views'));//set path


app.get('/',(req,res) => {
    res.render('home'); // you can write res.render('home');
})

app.get('/rolldice',(req,res) => {
     let value = Math.floor(Math.random() * 6) + 1;
    res.render('rolldice.ejs',{dice : value});
})
app.get('/ig/:username',(req,res) => {
	const data = require('./data.json');
	let {username} = req.params;
	const data_to_send = data.username;
  
	res.render('instagram.ejs',{data_to_send});
	});

app.listen(port,()=>{
    console.log(`server started at port ${port}`);
})