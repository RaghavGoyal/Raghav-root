const express = require('express');
const data = require('./data.json');
const path = require('path')
const mysql = require('mysql')
const bodyParser=require('body-parser');
const app =  express();
const PORT=3000;

app.use(bodyParser.urlencoded({ extended: false }));

app.get('/', (req, res, next)=>{
    // res.send('Get request created');
    //create connection with DB
    //fire  a querry

    res.sendFile('input.html', {root: path.join(__dirname, './')});

    // next();
    // res.end();
    // document.getElementById('b1').addEventListener(click, function(){
    //     var first_name=document.getElementById('fname').value;
    //     var last_name=document.getElementById('lname').value;
    //     var mail=document.getElementById('email').value;
    //     var gender=document.getElementById('gender').value;

    // });
    
    // res.end();
    // res.json(data);
});

app.post('/postpage', (req, res)=>{
    // res.send('Post request created');

    let first_name=req.body.firstname;
    let last_name=req.body.lastname;
    let email=req.body.email;
    let gender=req.body.gender;

    console.log(first_name);
    console.log(last_name);
    console.log(email);
    console.log(gender);

    var connection = mysql.createConnection({
             host: 'localhost',
             user: 'root',
             password: '12345678',
             database: 'ExpressTraining'
    });

    connection.connect(function(err){
        if(!err){
        console.log("connected to DB");
        let sql="INSERT into employee (first_name, last_name, email, gender) VALUES ('"+first_name+"', '"+last_name+"', '"+email+"', '"+gender+"') ";
        // var dataarray=[first_name, last_name, email, gender]
        // console.log(dataarray);

        connection.query(sql, function(err, result){
            // if(err) throw err;
            console.log("inside querry function");
            {
            console.log("1 Record inserted");
            console.log(result);
            }
        });

    }
    });

    res.send("data entered into DB");
    res.end();

});

app.put('/', (req, res)=>{
    res.send('Put request created');
});

app.delete('/', (req, res)=>{
    res.send('Delete request created');
});

// app.get('/item/:id', (req, res)=>{
//     console.log(req.params.id);
//     let userId=Number(req.params.id);
//     console.log(userId);
//     console.log(data[userId]);
//     res.send(data[userId]);
// });

app.get('/item/:id', (req, res, next)=>{
    console.log(req.params.id);
    let userId=Number(req.params.id);
    console.log(userId);
    console.log(data[userId]);
    res.send(data[userId]);
    next();
}, (req, res) =>{
    console.log("did you get correct data?")
});

app.get('/name/:first_name', (req, res)=>{
    console.log(req.params.first_name);
    let reqName=req.params.first_name;
    for(let i=0;i<data.length;i++){
        if(data[i].first_name==reqName)
        {
            res.send(data[i]);
        }
    }
    // console.log(data[userId]);
    // res.send(data[userId]);

    res.end();
});

app.get('/itemRedirect', (req, res)=>{
    res.redirect('add any external link here');
});

//item Chaining
app.route('/itemChaining')
.get((req, res)=>{
    // res.send('Get request created');
    //create connection with DB
    //fire  a querry
    res.send("get request");
}).post((req, res)=>{
    res.send('Post request created');
}).put((req, res)=>{
    res.send('Put request created');
}).delete((req, res)=>{
    res.send('Delete request created');
});



//Built in middlewares:
app.use(express.json());

app.post('/newItem', (req, res) =>{
    console.log(req.body);
    res.send(req.body);
});



app.listen(PORT, () =>{
    console.log(`My application is running on port ${PORT}`);
    // console.log(data);
});
