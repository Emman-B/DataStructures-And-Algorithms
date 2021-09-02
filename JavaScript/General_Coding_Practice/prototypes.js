// Creating objects with prototypes and without ES6 classes

// constructor
var Person = function(first, last, age) {
    // fields
    this.name = {
        first,
        last,
    };
    this.age = age;
}

// method
Person.prototype.greeting = function() {
    console.log(`Hello. My name is ${this.name.first} ${this.name.last}`);
}


// "main method"
function main() {
    var person = new Person('John', 'Doe', 23);

    console.log(typeof person);
    person.greeting();
}

// running the main method
main();
