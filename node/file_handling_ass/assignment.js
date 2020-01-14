// const fs=require('fs');
// const http=require('http');

// var promise1 = new Promise(function(resolve, reject){
// 	fs.readFile('a.docx','utf-8', function(err, data){
// 		if(err) throw err;

// 		else console.log(data);
// 	});
// });

// var promise2 = new Promise(function(resolve, reject){
// 	fs.readFile('b.txt','utf-8', function(err, data){
// 		if(err) throw err;

// 		else console.log(data);
// 	});
// });

// var promise3 = new Promise(function(resolve, reject){
// 	fs.readFile('c.txt','utf-8', function(err, data){
// 		if(err) throw err;

// 		else console.log(data);
// 	});
// });

// var promise4 = new Promise(function(resolve, reject){
// 	fs.readFile('d.txt','utf-8', function(err, data){
// 		if(err) throw err;

// 		else console.log(data);
// 	});
// });

// var promise5 = new Promise(function(resolve, reject){
// 	fs.readFile('e.txt','utf-8', function(err, data){
// 		if(err) throw err;

// 		else console.log(data);
// 	});
// });

// Promise.all([promise1, promise2, promise3, promise4, promise5]).then(function(){
// 	console.log("all files read and printed");
// });

const path = require('path');
const fs = require('fs');
 
const directoryPath = path.join(__dirname+'/sub_dir');

fs.readdir(directoryPath, function (err, files) {
    if (err) {
        return console.log('Unable to scan directory: ' + err);
    } 
    files.forEach(function (file) {
        console.log("File name: ", file); 
    });
});


























