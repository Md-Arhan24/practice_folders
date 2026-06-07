const express = require('express');
const port = process.env.PORT || 8000;
const app = express();
const path = require('path');
const apis = [
    {id:'1',title:'api-data-one'},
    {id:'2',title:'api-data-two'},
    {id:'3',title:'api-data-three'},
]
// app.get('/',(req,res) => {
//     //req-is use to get the data
//     //res-response is use to send the data
    
//     res.send("<h1>hello world</h1>");
   
// })
// app.get('/about',(req,res) => {
//     res.sendFile(path.join(__dirname,'public','about.html'));
// })

//set uping a static folder-a folder which opens first when you enter a website
//middle-ware : use in between request or response from client to server or vise versa.
app.use(express.static(path.join(__dirname,'public')));//we set this as a default folder so that through this i can go to home,about pages.

//get the api data
app.get('/api/posts/:id',(req,res) => {
    // res.json(apis); // = res.send(apis)
    // console.log(typeof(req.params.id)); its a type string so we have to convert it interger
    let id = parseInt(req.params.id);
    // res.json(apis[id]);like this we cant send particular index data
    //to send this we have to write this
    res.json(apis.filter((data) => data.id == id));
})

//body prarser - sending  the data from server using post
app.use(express.json());
app.post('/',(req,res) => {
    console.log(req.body);
    res.status(202).json(apis);
})

app.listen(port,() => {console.log(`server is running at ${port}`)})