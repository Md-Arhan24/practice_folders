function wrap(fn){
    return function(){
        fn();//like default if no function came as argumetn
        //is execute the below one
    }

}

let fun = () => {console.log("hello")};
let gotfun = wrap(fun);
gotfun();