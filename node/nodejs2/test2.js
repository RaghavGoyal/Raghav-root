var http = require('http');
var myModule = require('./my-module.js');
var ejs = require('ejs');

var html='<html> <head> </head> <body> <p> My name is <%= name %></p>  </body> </html>';

http.createServer(function (req, res){
	res.writeHead(200,{'content-type':'text/html'});

	var name=myModule.name;
	var renderhtml = ejs.render(html,{name: name});
	res.end(renderhtml);
}).listen(8080);