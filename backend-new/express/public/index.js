const express = require('express');
const app = express();

let port = 8080;


app.get('/',(req,res) => {
	res.send('<h1>you are at home </h1>');
	});
app.get('/about',(req,res) => {
	res.send('<h1>you are at about page </h1>');
	});


//path parameters
app.get('/:username/:id',(req,res) => {
	let user = req.params.username;
	res.send(`'<h1>hi ${user},welcome to beFit </h1>'`)
})

	//query stirng
app.get('/search',(req,res) => {
	let {q} = req.query;
	if(!q){//case where no query is passed
		res.send('nothing serach');
		}
	res.send(`<h1> you search for ${q} results`);
	});


app.listen(port, ()=> {
    console.log(`server started for checking requests at port ${port}`);
})

