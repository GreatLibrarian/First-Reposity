// This is my javascript page. A ton of stuff is made here

// A List of person Objects that is used for the High Score Table
var persons = [makePerson("SAM", 3, "Easy"), makePerson("AMY", 4, "Medium")];

// These 3 variables are used for the Guessing Game
let difficulty = 0;
let lives = 3;
let correctCount = 0;

// Creates a person Object to be added to the persons List
function makePerson(nickname, score, dif) {
  var person = {
    nickname: nickname,
    score: score,
    dif: dif,
  };
  return person;
}
// Adds a person Object to the persons List
function addPerson(person) {
  persons += person;
  // Also calls the createHighScore function for the person
  createHighScore(person);
  console.log("person made");
}

// This is used to add a person's form info into the High Score Table
function createHighScore(person) {
  let table = document.getElementById("scoreTable");
  let row = table.insertRow(findSpotByScore(person.score));
  let cell1 = row.insertCell(0);
  cell1.innerHTML = person.nickname;
  let cell2 = row.insertCell(1);
  cell2.innerHTML = person.score;
  let cell3 = row.insertCell(2);
  cell3.innerHTML = person.dif;
}
// This is used to place a score into the High Score Table by order of Score value
function findSpotByScore(score) {
  let table = document.getElementById("scoreTable");
  if (2 >= table.rows.length) {
    return 2;
  }

  let counter = 2;
  while (counter < table.rows.length) {
    // Because both score and the cell data are non-numbers, anything 10 or higher will be misordered
    if (score > table.rows[counter].cells[1].innerHTML) {
      return counter;
    }
    counter++;
  }
  console.log("made it here");
  return counter;
}

// Used for the Guessing Game. Changes the possible number range of the game depending on input difficulty
function setDifficulty(dif) {
  switch (dif) {
    case "Easy":
      difficulty = 3;
      break;
    case "Medium":
      difficulty = 5;
      break;
    case "Hard":
      difficulty = 10;
      break;
    // This null case is used for if the user cancels out of the prompt
    case null:
      difficulty = -1;
      break;
    // This default is used for if the user inputs any other case
    default:
      difficulty = 0;
      break;
  }
}
// Creates a ranndom number based on the number range of the Guessing Game
function makeNumber() {
  let num = Math.floor(Math.random() * difficulty) + 1;
  return num;
}
// Checks if a submitted number answer equals the random number created
function verifyNumber(num) {
  // If the person has no more lives, they can no longer play. If they are correct 10 times, they've won and can no longer play
  if (lives <= 0 || correctCount >= 10) {
  } else {
    let answer = makeNumber();
    // If they got the right number, we up the counter and update our CSS and HTML
    if (num == answer) {
      correctCount++;
      updateCount();
      alert("Correct!");
      // Win condition alert
      if (correctCount >= 10) {
        alert("You've guessed ten in a row. You win!");
      }
    } else if (correctCount < 10) {
      // This is what happens when they guess incorrectly
      lives--;
      if (lives <= 0) {
        alert(
          "You have lost all of your lives. Game over!" +
            "\n" +
            "My number was: " +
            answer
        );
      } else {
        alert(
          "Incorrect! " +
            lives +
            " lives remaining." +
            "\n" +
            "My number was: " +
            answer
        );
      }
    }
  }
}
// Reads the given difficulty to initialize the game
function initGame() {
  // Used for when the input difficulty isn't valid
  if (difficulty == 0) {
    alert("Invalid Difficulty Setting, please Reenter your Difficulty");
    setDifficulty(prompt("Enter Your Difficulty: Easy, Medium, Hard."));
    initGame();
    // Used for when the user cancels out of the prompt
  } else if (difficulty == -1) {
    alert("Successfully cancelled. Please reload the page to play again!");
    // Used when a proper difficulty is inputted
    // Creates a text that displays what the number range for the game is to the html
  } else {
    let str =
      "I'm thinking of a number between 1 and " +
      difficulty +
      ". Can you guess what my number is?";
    let node = document.getElementById("start");
    node.textContent = str;
    node = document.getElementById("counter");
    node.textContent = "Begin!";
  }
}

// Creates a unique HTML and CSS change for each correct answer that is given
function updateCount() {
  // This is the "Begin!" header in the Guessing Game page. We modify its text and CSS properties for every correct answer
  let node = document.getElementById("counter");
  switch (correctCount) {
    case 1:
      node.textContent = "One!";
      node.style.color = "red";
      node.style.fontFamily = "Roboto Flex, sans-serif";
      node.style.fontSize = "50px";
      break;
    case 2:
      node.textContent = "Two!!";
      node.style.color = "blue";
      node.style.fontFamily = "Tiro Devanagari Marathi, serif;";
      node.style.fontSize = "70px";
      break;
    case 3:
      node.textContent = "Three!!!";
      node.style.color = "green";
      node.style.fontFamily = "Roboto Condensed, sans-serif;";
      node.style.fontSize = "90px";
      break;
    case 4:
      node.textContent = "!!Four!!";
      node.style.color = "yellow";
      node.style.fontFamily = "Spline Sans Mono, monospace";
      node.style.fontSize = "120px";
      break;
    case 5:
      node.textContent = "!!Five!1!";
      node.style.color = "orange";
      node.style.fontFamily = "Playfair Display, serif";
      node.style.fontSize = "150px";
      break;
    case 6:
      node.textContent = "!!!S1x!!!";
      node.style.color = "purple";
      node.style.fontFamily = "Blaka Hollow, cursive";
      node.style.fontSize = "180px";
      break;
    case 7:
      node.textContent = "!!!Sev!e!n!!";
      node.style.color = "pink";
      node.style.fontFamily = "Titillium Web, sans-serif";
      node.style.fontSize = "220px";
      break;
    case 8:
      node.textContent = "!!E!I!G!H!T!!";
      node.style.color = "indigo";
      node.style.fontFamily = "Bebas Neue, cursive";
      node.style.fontSize = "270px";
      break;
    case 9:
      node.textContent = "!!N!!I!!N!!E!";
      node.style.color = "teal";
      node.style.fontFamily = "Lobster, cursive";
      node.style.fontSize = "320px";
      break;
    case 10:
      node.textContent = "TEN!!!!!!!!!!";
      node.style.color = "crimson";
      node.style.fontFamily = "Tiro Devanagari Hindi, serif";
      node.style.fontSize = "400px";
      break;
  }
}

// This is used for the video on the Home Page, changes the video source depending on the dropdown value
function changeVideo(num) {
  let node = document.getElementById("vid");
  switch (num) {
    case "0":
      node.src = "";
      break;
    case "1":
      node.src = "https://www.youtube.com/embed/1eiWhyUCevs";
      break;
    case "2":
      node.src = "https://www.youtube.com/embed/4O9vrKXUv-g";
      break;
    case "3":
      node.src = "https://www.youtube.com/embed/rJ4bCZA3sdo";
  }
}

// This Event Listener starts upon any page loading
window.addEventListener("load", function () {
  // name = the name of the document (ie. program.html)
  let name = window.location.pathname.split("/").pop();
  // This code block only runs for the about.html page
  if (name === "about.html") {
    for (let i in persons) {
      createHighScore(persons[i]);
    }
    console.log("loaded");
  }
  // This only runs for the program.html page
  if (name === "program.html") {
    setDifficulty(prompt("Enter Your Difficulty: Easy, Medium, Hard."));
    initGame();
    console.log("Loaded");
  }
});
