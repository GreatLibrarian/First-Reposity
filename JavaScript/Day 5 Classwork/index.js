// let str = "aawwbbcced";
// console.log(str.lastIndexOf("d"));

// var scope = "global";
// function checkScope(){
//     let scope = 'local';
//     return scope;
// }
// console.log(checkScope());
// alert("hello" + 20);


// let arr = ["yo", 1, 13.6, "gravy"];

//******THESE ALL DO THE SAME THING************** */

// for(let idx in arr){
//     console.log(arr[idx]);
// }

// arr.forEach(function(idx){
//     console.log(idx);
// });

// arr.forEach((idx) =>{
//     console.log(idx);
// });

//************************** */

// let bruh = arr.map(function(val) {
//     return 2;
// });

// console.log(arr);
// console.log(bruh);

//Does not modify the current array, creates a new one
// let newArr = arr.filter(function(word){
//     return word.length >= 2;
// })

// console.log(arr);
// console.log(newArr);

// Each return function displays the same #
// const add =(a,b) =>{
//     let c = '8';
//     let cn = Number(c);

//     return a+b+Number(c);
//     return a+b+parseInt(c);
//     return a+b+(+c);
//     return a+b+cn;
// }
// Returns 11 no matter which return is used
// console.log(add(1, 2));

// // Returns 22
// console.log(eval('2' + '2'));
// // Retuns 22
// console.log(eval('2' + 2));
// // Returns 22
// console.log(eval(2 + '2'));
// // Returns 4
// console.log(eval(2 + 2));
// // Returns 4
// console.log(eval('2 + 2'));
// // Returns 4
// console.log(eval('2' + ' + 2'));

//Should probably never use the eval() function ever

function outerFunction(x){
    //returning the outer function
    return function(y){
        //returning the inner function
        return x+y;
    }
}
// this function acts as the inner function
//Called a closure
let adder = outerFunction(5);
//returns 7
console.log(adder(2));