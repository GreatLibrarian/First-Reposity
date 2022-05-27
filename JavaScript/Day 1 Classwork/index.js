//var is a global scope variable ie. static
// var nameOne = "String";
// var number = 23452;
// var booleanType = true;

//let is a local scope ie. instance
// let nameTwo = "string";
// let numberTwo = 2345.23453;
// let booleanTypeTwo = true;

//const = final
// const nameThree = "string";

// nameOne = 'Erik'
// nameTwo = "Erik"
// nameThree = 'Erik'

// console.log(" var type ", nameOne);
// console.log(" var type ", number);
// console.log(" var type ", booleanType);

// console.log(" const type ", nameThree)

// JavaScript's version of methods
// function newMessage(num) {
//   for (let i = 0; i < num; i++) {
//     console.log(i);
//   }
// }
// newMessage(10);

// function add(numOne, numTwo) {
//   let result = numOne + numTwo;

//   return result;
// }
// let result = add(3, 5);
// console.log(result);

// let person = {
//     first_name:'Luke',
//     last_name:'Skywalker',
//     job:'Jack of all trades'
// }
// //For in = object, for of = array
// function printObject(p){
//     for(let i in p) {
//         console.log(i + ": " + p[i])
//     }
// }
//Prints first_name : Luke, last_name: Skywalker, job : Jack of all trades, undefined"
// console.log(printObject(person));

// var name = "global";
// function check() {
//     let name = 'local';
//     var myScope = 'new Scope';
//     return name;
// }
// let result = check();
// console.log(result);
// console.log(name);
// console.log(myScope); Will be undefined

//Comparison operator
// ==  : looks if the value is the same
// === : looks if the data type + value are the same

// console.log(3 === '3');

// console.log(3 != '3'); // opposite of ==
// console.log(3 !== '3');// opposite of ===

// let score = 89;
// if(score < 90 && score > 80) {
//     console.log("B");
// }

// var x = 10;
// var y = 4;

// let operand = "*";

// switch (operand) {
//   case "+":
//     console.log(x + y);
//     break;
//   case "-":
//     console.log(x - y);
//     break;
//   case "*":
//     console.log(x * y);
//     break;
//   case "%":
//     console.log(x % y);
//     break;
//   default:
//     console.log("wtf is this");
//     break;
// }

// let x = 10;

// while (x < 20) {
//   console.log(x);
//   x++;
// }

// let userInput = "";

// userInput = prompt("Enter your name");
// console.log(userInput);

let myLuckyNumber = 7;
if (myLuckyNumber == 0) {
  console.log("not my number");
} else if (myLuckyNumber > 0) {
  console.log("Yes");
} else if (myLuckyNumber < 0) {
  console.log("No");
} else {
  console.log("Try again");
}
