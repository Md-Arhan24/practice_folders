import http from 'http';
const PORT = process.env.PORT;

const server = http.createServer((req,res) => {
    // res.setHeader('content-type','text/plain');
    // res.end('hello world');
    console.log(req.url);
    console.log(req.method);
    res.writeHead(202,{'content-type':'text/html'});
    res.end('<h1>asslamalikum sister</h1>');
})

server.listen(PORT,()=>{
    console.log(`server started at ${8000} port`);
})