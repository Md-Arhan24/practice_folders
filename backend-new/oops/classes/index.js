class person {
  constructor(name, age) {
    this.name = name;
    this.age = age;

  }
  talk() {
    console.log("hi");
  }
}
class student extends person {
  constructor(name,age,marks) {
    
    super(name,age,marks);
    this.marks = marks; 
  }

  intro() {
    console.log(`hi! my name is ${this.name} and my age is ${this.age} and my marks are ${this.marks}`);
  }
}

// let p = new person('arhan',19);
let s = new student("arhan",19,9.40);
s.intro();
s.talk();
