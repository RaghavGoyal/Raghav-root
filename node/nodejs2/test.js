var myModule = require('./my-module.js');
var greet = require('./greet.js');

console.log("My name is: "+ myModule.name);

var greetObj = new greet();
console.log(greetObj.sayHello());