// let header = document.getElementById("header_title");
// console.log(header);

// let items = document.getElementsByName('list-group-item');
// for(item of items) {
//     console.log(item);
// }

// let li = document.getElementsByTagName('li');
// console.log(li);
// for(item of li) {
//     console.log(item);
// }

// let arr = Array.prototype.slice.call(li, 1, 3);
// for(item of arr) {
//     console.log(item);
// }

// let selectId = document.querySelector('b.selectClass');
// let tagName = document.querySelectorAll('font[color="blue"]')
// console.log(selectId);
// console.log(tagName);

// function showChange() {
//     let change = "change the text";
//     document.getElementById("myChange").value = change;
// }

// let divOne = document.createElement('div');
// divOne.id = "content";
// divOne.innerHTML = '<p> create new element </p>';
// document.body.appendChild(divOne);

// let h2 = document.createElement('h2');
// h2.textContent='Added an h2 to div';
// divOne.appendChild(h2);

// function menuCreateItem(name) {
//     let li = document.createElement('li');
//     li.textContent = name;
//     return li;
// }

// const menu = document.querySelector('#menu');
// menu.appendChild(menuCreateItem("Bruhv I swear to my Christ in brother"));
// menu.appendChild(menuCreateItem("Swear on me mum"));

// let btnOne = document.getElementById('btnOne');

// function btnClick() {
//     console.log('is clicked');
//     const s = document.querySelector('span');

//     s.textContent = "I have been clicked";
//     btnOne.textContent = "I was Clicked";
// }

// btnOne.addEventListener('click', btnClick);

document.addEventListener('keypress', function(e) {
    console.log('you pressed any key');
    console.log('key' + e.code);
    console.log('key' + e.key);
})