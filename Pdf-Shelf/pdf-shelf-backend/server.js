const express = require('express');
const app = express();
const dotenv = require('dotenv').config();
const url = process.env.URL;
const mongoose = require('mongoose');
const port = process.env.PORT || 8080;
const user_model = require('./models/user.js');
const pdf_model = require('./models/pdf.js');
const cors = require('cors');
const userRouter = require('./routs/user.js');
const passport = require('passport');
const localStatagey = require('passport-local');
const session = require('express-session');


// IMPORTANT: Order matters! Set up middleware in this order:
// 1. CORS - MUST BE FIRST (before any other middleware)
app.use(cors({
    origin: 'http://localhost:5173', // Your Vite frontend URL
    credentials: true, // Important for sessions/cookies
    methods: ['GET', 'POST', 'PUT', 'DELETE', 'OPTIONS'],
    allowedHeaders: ['Content-Type', 'Authorization']
}));


// 2. Body parsers
app.use(express.json());
app.use(express.urlencoded({extended:true}));

// 3. Session middleware BEFORE passport
app.use(session({
    secret: process.env.SESSION_SECRET || '123hampppyjoubd', // Use env variable in production
    resave: false,
    saveUninitialized: false,
    cookie: {
        httpOnly: true,
        maxAge: 1000 * 60 * 60 * 24 // 1 days
    }
}));

// 4. Passport initialization AFTER session
app.use(passport.initialize());
app.use(passport.session());

// 5. Passport configuration
passport.use(new localStatagey(user_model.authenticate()));
passport.serializeUser(user_model.serializeUser());
passport.deserializeUser(user_model.deserializeUser());
app.use('/api/users',userRouter);

app.get('/',(req,res) => {
    res.send("server started");
})




connect();
async function connect(){
    try{
        await mongoose.connect(url);
        console.log("successfully connected");
    }catch(e){
        console.log("error occured"+e);
    }
}

app.listen(port,() => {
    console.log(`server started at ${port}`);
})
