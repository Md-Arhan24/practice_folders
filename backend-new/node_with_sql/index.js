const { faker } = require("@faker-js/faker");
const mysql = require('mysql2');
const dotenv = require('dotenv').config();
const fs = require('fs');

//building a connection
const connection = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  database: 'backend',
  password: process.env.PASSWORD,
});

// try{
// //executing sql query
// connection.query("SHOW TABLES",(err,result) => {
// 	if(err) throw err;
// 	console.log(result);
   
// });
// }catch(err){
//   console.log(err);
// }
 
// let my_query = fs.readFileSync('./schema.sql','utf-8');
function getUser(){

  return [
    faker.string.uuid().slice(1,8),
    faker.internet.username(), // before version 9.1.0, use userName()
    faker.internet.email(),
    faker.internet.password().slice(0,9)
  ];
}
let our_query = "INSERT INTO user (id,user,email,password) VALUES ?;"
let data_to_inset = [['003','@apha','alphamail0@gamil.com','alpha123'],
                     ['002','@pingpong','pingpong@gamil.com','ping123']];

let data = [];
for(let i = 0;i < 50;i++){
  data.push(getUser());
  

}
// console.log(data);

//inserting data in a row
connection.query(our_query,[data],(err,result) => {
  if(err) throw err;
  console.log(result);
})

 connection.end();// connection.close(); - it worked 



