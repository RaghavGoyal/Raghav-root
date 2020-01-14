var http=require('http');

http.createServer(function(req,res){
	res.write("hello world");
	res.end("byee");
}).listen(8088)