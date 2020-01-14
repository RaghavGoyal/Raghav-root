// var http = require('http'); // Import Node.js core module

// var server = http.createServer(function (req, res) {   //create web server
//     if (req.url == '/') { //check the URL of the current request
        
//         // set response header
//         res.writeHead(200, { 'Content-Type': 'text/html' }); 
        
//         // set response content    
//         res.write('<html><body><p>This is home Page.</p></body></html>');
//         res.end();
    
//     }
//     else if (req.url == "/student") {
        
//         res.writeHead(200, { 'Content-Type': 'text/html' });
//         res.write('<html><body><p>This is student Page.</p></body></html>');
//         res.end();
    
//     }
//     else if (req.url == "/admin") {
        
//         res.writeHead(200, { 'Content-Type': 'text/html' });
//         res.write('<html><body><p>This is admin Page.</p></body></html>');
//         res.end();
    
//     }
//     else
//         res.end('Invalid Request!');

// });

// server.listen(5000); //6 - listen for any incoming requests
// console.log('Node.js web server at port 5000 is running..')

// var http = require('http'); 

// var server = http.createServer(function (req, res) {   
   
//     if (req.url == '/data') { //check the URL of the current request
//             res.writeHead(200, { 'Content-Type': 'application/json' });
//             res.write(JSON.stringify({ message: "Hello World"}));  
//             res.end();  
//     }
// });

// server.listen(5000);

// console.log('Node.js web server at port 5000 is running..');

// var fs = require('fs');

// fs.appendFile('test.docx', "\nhello World from node application", function (err) {
//                     if (err) 
//                         console.log("an error occured");
//     console.log("write operation completed");
// });

// console.log("after line1");
// console.log("after line 2");
// console.log("after line 3");


// console.log("First line");
// console.log("Second line");
// debugger;  //next to move to next line. cont to move to next debug statement. step to move into function.
// //out to step out of any function.
// //watch variable_name to check value of a variable.
// console.log("First line after debugger1");
// console.log("First line");
// console.log("First line");
// console.log("First line");
// debugger;
// console.log("Final line");




var http = require('http');
// var myModule = require('./my-module.js');
var ejs = require('ejs');

var html='<html> <head> </head> <body> <p> My name is <%= name %></p>  </body> </html>';

http.createServer(function (req, res){
    res.writeHead(200,{'content-type':'text/html'});

    var name='Raghav';
    var renderhtml = ejs.render(html,{name: name});
    res.end(renderhtml);
}).listen(8080);




























