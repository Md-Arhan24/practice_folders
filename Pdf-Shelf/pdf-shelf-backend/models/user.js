const mongoose = require('mongoose');
const {Schema} = mongoose;
const passportLocalMongoose = require('passport-local-mongoose').default;


let user_model = new Schema({//i have removed this as passport auto check for require 
    username:{
        type:String,
      
    },
    email:{
        type:String,
       
    },
   
});
user_model.plugin(passportLocalMongoose);

module.exports= mongoose.model('User',user_model);
