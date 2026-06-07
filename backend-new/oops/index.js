function factoryFunction(name,age){
    const obj = {
        name:name,
        age:age,
        isAlpha: function() {
            console.log(age > 18 ? "alpha" : "not Alpha");
        }
    }

    return obj;
}

let factoryObj = factoryFunction("shardha",23);
let factoryObj2 = factoryFunction("aman",23);

// console.log(factoryObj.name == factoryObj2.name);//false
// console.log(factoryObj.isAlpha == factoryObj2.isAlpha);//false
console.log(factoryObj.isAlpha());

//consturctors
function Constructor(name,age){
    this.name = name;
    this.age = age;
    // this.isAlpha = () => {
    //     return (age > 18 ? "alpha" : "not Alpha");
    // }
}

Constructor.prototype.isAlpha =  function () {
    return (this.age > 18?"alpha":"not Alpha");
}

let cobj = new Constructor("shardha",22);
let cobj2 = new Constructor("aman",22);

console.log(cobj.name == cobj2.name);//false
console.log(cobj.isAlpha == cobj2.isAlpha);//ture - only once created  : memory effciency
console.log(cobj.isAlpha());

//using classes
class Person{
    constructor(name,age){
        this.name = name;
        this.age = age;
        this.greet =  () => {
            console.log(`hello! my name is ${this.name}`);
        }
        //both are same where in  explicit constructor - out side of class the differ
        /*this.greet = function () {
            console.log(`hello! my name is ${this.name}`);
        }*/
    }
    salam()
    {
        console.log(`Asslamalikum from ${this.name}`)
    }
}

let p = new Person('arhan',19);
p.salam();
p.greet();