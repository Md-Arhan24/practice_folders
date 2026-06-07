const express = require('express');
const path = require('path');
const body_parser = require('body-parser');


const app = express();

const PORT = 8080;

app.use(body_parser.urlencoded({extended : true}));
app.use(express.static(path.join(__dirname,"public")));
app.use(express.static(path.join(__dirname,"public/js")));
app.use(express.static(path.join(__dirname,"public/style")));
app.use(express.urlencoded({ extended: true }));
app.set('view engine','ejs');
app.set("views" , path.join(__dirname,"/views"));

app.get('/',(req,res) =>{
    res.send("<h1> hi every one </h1>");
})
app.get('/login',(req,res) =>{
    res.render('login');
})
app.post('/login',(req,res) =>{
    let {username,password} = req.body;

    if(username == "admin" && password == "1234" ){
        res.redirect('/counter');

    }
    else{
        res.send('invalid credentials');
    }
})

app.get('/counter',(req,res) => {
    res.render('count', { numbers: null });

})
app.post('/counter', (req, res) => {
  const limit = parseInt(req.body.limit);
  const numbers = Array.from({ length: limit }, (_, i) => i + 1);
  res.render('count', { numbers });
});

app.get('/insta/id/:username',(req,res) =>{
    const data = require('./InstaData.json');
    const {username} = req.params;

    const dataToSend = data[username];
    if(!dataToSend){
        res.render('NoSuchAccount');

    }else{

        res.render('Instagram',{dataToSend});
    }
})


app.listen(PORT , () =>{
    console.log(`server started at port ${PORT}`);
})