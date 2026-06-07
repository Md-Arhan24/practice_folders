const mongoose = require('mongoose');
const schema = mongoose.Schema({
    name:{
        type:String,
        required:true
    },
    type :{
        type:String,
        enum:['fictional','non fictional'],
    },
    author:{
        type:String,
        required:true
    },
    choices:[String],
    age:{type:Number,min:[18,'users above age 18 can only access']}

});

const Book = mongoose.model('Book',schema);
//find by id
// User.findById('688615092894610fd40ad358')
// .then(res => {console.log(res)})
// .catch(e => {console.log(e)});

//insert manu
// User.insertMany([
//     {name:'steve',email:'stevehard@gmail.com',age:34},
//     {name:'harby',email:'harby939@gmail.com',age:33},
//     {name:'nanu',email:'nanu@gmail.com',age:98},
//     {name:'sham',email:'shamsd883@gmail.com',age:99},
//     {name:'steven',email:'stevedd43hard@gmail.com',age:333},

// ])
// .then((res) =>{
//     console.log(res);
// })
// .catch((err) => {
//     console.log(err);
// })
// const user1 = new User({name:'arhan',email:'arhanmohammed@gmail.com',age:19});

// //async method return promise
// user1.save()
// .then(() => {
//     console.log('successfully inserted');
// })
// .catch((e) => {
//  console.log('error occured' ,e);
// })

// User.findByIdAndUpdate('688615092894610fd40ad358',{name:'arhan'},{new: true})
// .then((res) => {
//     console.log(res);
// })
// .catch((e) => {console.log(e)});

// User.deleteMany({age:{$gt:100}})
// .then((res) => {console.log(res);})
// .catch((e) => {console.log(e);})

//validations

const b1 = new Book({
    name:'rich dad poor dad',
    type:'non fictional',
    author:"robert kyusaki",
    choices:['comics','fictiona','non fictional','super heros'],
    age:17
    });
b1.save().then((res) => {
    console.log(res);
})
.catch((err) => {console.log(err.errors.age.properties.message)});

main()
.then(() =>{
    console.log('connection successful');
})
.catch((err) => {
    console.log('error occured' ,err);
})

async function main(){
    await mongoose.connect('mongodb://127.0.0.1:27017/test');
}