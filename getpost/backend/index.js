const express = require('express');

const app = express();
const PORT  = 8080;

app.use(express.urlencoded({extended:true}));
app.use(express.json());

app.get('/register',(req,res) => {
    let {username,password} = req.query;
    res.send(`welcome back ${username}`);
});
app.post('/register',(req,res) => {
    let {username,password} = req.body;
    res.send(`welcome back ${username}`);
});

app.listen(PORT,() => {
    console.log(`server started at port ${PORT}`);
})