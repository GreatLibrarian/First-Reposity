// // console.log("working");
// let name = "Bob";
// let hasJob = true;
// let age = 22;

// // Object == has key/value pairs
// let person = {
//   first_name: "Erik",
//   last_name: "Taylor",
//   isWorking: false,
//   hasJob: true,
//   jobTitle: "Software Dev",
//   fullName: function () {
//     return this.first_name + " " + this.last_name;
//   },
// };

// // Array == is a List (not bound to one type of Element)
// let names = ["Sara", "Erik", "Avani", "Adow", 234, true, 109.2345];

// // Returns full Array
// console.log(names);
// // Returns Avani
// console.log(names[2]);
// // Returns full Object
// console.log(person);
// // Returns undefined
// console.log(person[2]);

// // Returns the structure of the function
// console.log(person.fullName);
// // Returns Erik Taylor (adding parentheses calls the function)
// console.log(person.fullName());

// //Object classes in JS
// var obj1 = new Object();
// var str = new String();
// var num = new Number();
// var bool = new Boolean();
// var arr = new Array();
// var date = new Date();

// //Math Objects are Global
// Math.random();
// Math.floor();

// //JavaScript Constructor
// function Person(firstName, lastName, age, hasHairColor){
//     this.firstName = firstName;
//     this.lastName = lastName;
//     this.age = age;
//     this.hasHairColor = hasHairColor
//     this.changeName = function(name){
//         this.lastName = name;
//     }
// }
// //Creates a new Person Object
// var newPerson = new Person("John", "Doe", 68, true);

// let result = newPerson;
// //returns the newPerson Object
// console.log(result);

// //This doesn't modify the newPerson Object, but instead
// //Creates a whole new Person Object
// let nameChange = newPerson.changeName("Dave");
// //this returns undefined
// console.log(nameChange);

// //Seems to also affect the above console.log too (prototype appears in both)
// Person.prototype.age = 54;
// Person.prototype.firstName = "Jim"
// console.log(result);

//Array Helpers
let names = ["Sara", "Erik", "Avani", "Adow", 234, true, 109.2345];

// //An array of Objects
// let arr = [
//     {firstName: "me"},
//     {jobTitle: "dev"},
//     {labtop: "MSI"}
// ]
// console.log(arr);

// //Removes and returns the last item, modifies the array
// let lastItem = names.pop();
// console.log(lastItem);
// console.log("pop: " + names);

// //Removes and returns the first item, modifies the array
// let firstItem = names.shift()
// console.log(firstItem);
// console.log("shift: " + names);

// //Adds item to the end of an array
// let addItem = names.push("James");
// console.log("push: " + names);

// //Unshift adds to the start of an array
// let addItemStart = names.unshift("Sara");
// console.log("unshift: " + names);

// function revWord(word) {
//     return word.split('').reverse().join('');
// }

// console.log(revWord("hello"));

// let str = 'anything';
// //returns an array of a single string "anything"
// console.log(str.split());
// //returns an array of each individual character "anything"
// console.log(str.split(''));

// //returns a String "ythi" : slice(start inclusive, end exclusive)
// console.log(str.slice(2, 6));

// console.log(names);
// //splice(start, # to delete) removes elements and adds new ones
// //if given. Modifies the array
// console.log(names.splice(2,2, "Apple", "Kiwi"));
// console.log(names);

// //Slice does not modify the array
// console.log(names);
// console.log(names.slice(0, 2));
// console.log(names);

// var date = new Date();
// console.log(date);
// console.log(date.getMonth());

//Prototype = second Object, it creates a second Object for us to use

let arr = [22, 11, 667, 30, 33];

let newArr = [];

// //Copying one array into another
// for(let i = 0; i < arr.length; i++) {
//     //newArr = newArr + arr[i]
//     //newArr+=arr[i]

//     newArr.push(arr[i]);
// }
// console.log(newArr);

// //Squares the copied array
// for(let i of arr) {
//     newArr.push(i**2);
// }
// console.log(newArr);

// //Arrow function example
// function addOneMore(){
//     console.log(a+1);
// }
// //Arrow function of the same above method
// const addOne = (a)=>{
//     console.log(a+1);
// }
// addOne(5);

// //Single line format of Arrow function, works the same
// //But unintuitive when looking at a glance on what it's doing
// const addOneAgain = a => console.log(a+1);
// addOneAgain(5);

// // Callback Function = function that calls another function
// let newLoop = [];
// arr.forEach((n) => newLoop.push(n));
// console.log(newLoop);

let input = prompt("Enter a range from (10 - 30)");
let range = input.split("");
let guessNumber = Math.floor(
  Math.random() * (Number(range[1] - Number(range[0])) + Number(range[0]))
);

let stopper = 0;

let userGuess = prompt(`Guess a number between ${range[0]} and ${range}`);

while (stopper < 10) {
  if (guessNumber === userGuess) {
    alert("You guessed right: ", userGuess);
  }
  stopper++;
}

if(stopper >= 10) {
    alert("Sorry, the answer was ", userGuess);
}
