const http=require('http');
const fs=require('fs');

// http.createServer(function (req, res) {
//     // res.write("hello world");
//     // fs.readFile('demo.html', function(err, data) {
//     //   res.writeHead(200, {'Content-Type': 'text/html'});
//     //   res.write(data);
//     //   res.end();
//     // });

// fs.appendFile('mynewfile1.txt', '\nMy first application', function (err) {
//     if (err) throw err;
//     console.log('Saved!');
//   });

//   fs.close();

  

    
//   }).listen(1111);

// fs.rename('mynewfile1.txt', 'testfile.txt', function (err){
//     if (err) throw err;
//     console.log("renamed");
// });

fs.unlink('testfile.txt', function(err){});



  
  

  