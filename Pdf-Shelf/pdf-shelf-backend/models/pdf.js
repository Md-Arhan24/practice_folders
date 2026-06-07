const mongoose = require('mongoose');
const {Schema} = mongoose;

let pdf_schema = new Schema({
    name:{
        type:String,
        require:true
    },
    category:{
        type:String,
        require:true
    },
    note:{
        type:String,
        require:true,
    },
    result:{
        type:String,
        require:true
    },
    url:{
        type:String,
        require:true
    },
    owner:{
        type:mongoose.Schema.Types.ObjectId,
        ref:'User'
    }

});
module.exports = mongoose.model('Pdf',pdf_schema);
