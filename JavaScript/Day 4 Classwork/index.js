let input = document.querySelector("#email");
let btn = document.querySelector("#button");

console.log("input", input);
console.log("button", btn);

let arrList = [];

// add function
btn.addEventListener("click", function (event) {
  event.preventDefault;
  let li = document.createElement("li");
  let inputVal = document.querySelector("#email").value;
  li.appendChild(inputVal);
  if (inputVal === "") {
    alert("Must add an email");
  } else {
    document.querySelector("#text").appendChild(li);
  }
  //   let text = input.textContent;
  //   input.value = "";
  input.value = '';
  console.log(event.type); //click event
});

let sp = document.createElement('span');
let txt = document.createTextNode('X');
sp.className = "remove";
sp.appendChild(txt);
li.appendChild(sp);

for(let i = 0; i < remove.length; i++) {
    remove[1].oneclick = function(){
        let div = this.parentElement;
        div.style.display = "none";
    }
}