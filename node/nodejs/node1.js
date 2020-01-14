console.log("hello world!");   // console is a part/ object of global

var hello="hello";
console.log(hello);

var substring=hello.slice(2);
console.log(substring);

console.log(`${hello} Raghav`);   // has to be backtick for string concatination.

// alert("hello");

console.log(__dirname);
console.log(__filename);

var path=require("path");
console.log(`you are in ${path.basename(__filename)}`);

var us =require("underscore");
console.log(us);

console.log("hello again");
// console.log("hi there");


