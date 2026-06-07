const { faker } = require("@faker-js/faker");
const sql = require("mysql2");
const env = require("dotenv").config();

let connection = sql.createConnection({
  host: "localhost",
  user: "root",
  database: "backend",
  password: process.env.PASSWORD,
});

// function createUser() {
//   return [
//     faker.string.uuid(),
//     faker.internet.username(),
//     faker.internet.email(),
//     faker.internet.password().slice(0,9),
//   ];
// }

// let data=[];
// for(let i = 1;i < 10;i++){
//     data.push(createUser());
// }

// let sql_query = "INSERT INTO practice (id,user,email,password) VALUES ?";
// connection.query(sql_query,[data],(err,res) => {
//     if(err) throw err;
//     console.log(res);
// })

let another_query = "SELECT * FROM practice;";

connection.query(another_query,(err,res) => {
    if(err) throw err;
    let idw = res.map((i,res) => {return i});
    console.log(idw);
    })

// console.log(createUser());
connection.end();

