import express from 'express';
import schema from './schema';
import { graphqlHTTP } from 'express-graphql';

const app = express();

//for setting data to DB:
const EmployeeDB = {};
class Employee{
    constructor(id, {firstName, lastName, gender, workEmail, personalEmail}){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.workEmail = workEmail;
        this.personalEmail = personalEmail

    }
}

app.get('/', (request, response) => {
    response.send('GraphQL server is all set.');
});

// this is resolver that will read and return data from DB; 
// will send hardcoded data for now;
const root = { friend: () => {
    return{
        "id": 101010101,
        "firstName": "Raghav",
        "lastName": "Goyal",
        "gender": "Male",
        "email": [
            { email: "raghav.goyal.test@dummy.com" },
            { email: "testing.graphQL@local.com" }
        ]

    }
}};

// const root2 = { employee: () => {
//     return{
//         "id": 101010101,
//         "firstName": "Raghav",
//         "lastName": "Goyal",
//         "gender": "Male",
//         "workEmail": "me@springer.com",
//         "personalEmail": "me@dummy.com"
//     }
//     },
//     createEmployee: ({input}) => {
//         let id = 12799;
//         EmployeeDB[id] = input;
//         return new Employee(id,input);
//     }
// };

app.use('/graphql', graphqlHTTP({
    schema: schema,
    rootValue: root,
    graphiql: true
}))

app.listen(8080, () => console.log('Server is running on localhost:8080/graphql...'));