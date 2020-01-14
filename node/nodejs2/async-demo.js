fs = require('fs');

function readDirectories(err, data)
{
	console.log('data: ',data);

}

fs.readdir('/Users/rgq5943/Desktop', readDirectories);
console.log("this comes after");