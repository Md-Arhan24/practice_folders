const express = require('express');
const router = express.Router();
const User = require('../models/user');
const passport = require('passport');
const localStatagey = require('passport-local');

router.get('/check',(req,res) => {
    if(req.isAuthenticated()){
        res.json({isLogin: true,user : req.user});
    }else{
        res.json({isLogin : false});
    }
});


router.post('/singup', async (req,res) => {
    try{
        let {name,email,password} = req.body;
          console.log("Received data:", { name, email, password });
        let userExits = await User.findOne({email:email});
        if(userExits){
            return res.status(400).json({message:"user already exists"});
        }
        const newUser = new User({username:name,email});
        console.log("New user object created:", newUser); 
       const registeredUser =  await User.register(newUser,password);//auto saves
         console.log("Successfully registered:", registeredUser); 
       
        console.log("succesfully inserted")
        res.status(201).json({message:"user created successfully"});


    }catch(e){
        console.error("ERROR DETAILS:", e); // THIS IS CRITICAL - SEE THE ACTUAL ERROR
        console.error("Error name:", e.name);
        console.error("Error message:", e.message);
        res.status(500).json({ message: "error occurred: " + e.message });
    }

});

router.post('/login',passport.authenticate('local'),async (req,res) => {
    try{
        let {email,password} = req.body;
        let userExists = await User.findOne({email:email,password:password});
        if(!userExists){
            return res.status(201).json({message:"please sing up"});
        }
       
        return res.status(201).json({message:"successfully login",success : true,user : req.user});

    }catch(e){
        res.status(401).json({message:"error occured"});

    }
})

module.exports = router;