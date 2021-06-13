import {buildSchema} from 'graphql';

const schema = buildSchema(`
    input Employee {
        id: ID
        firstName: String
        lastName: String
        gender: String
        workEmail: String
        personalEmail: String
    }

    type Mutation {
        createEmployee(input: Employee): Employee
    }
    
`)

export default schema;