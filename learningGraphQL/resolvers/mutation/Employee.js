//for setting data to DB (Mutation):

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


const resolver = { 
    getEmployee: ({ id }) => {
        return new Employee(id, EmployeeDB[id]);

    },
    createEmployee: ({input}) => {
        let id = 12799;
        EmployeeDB[id] = input;
        return new Employee(id,input);
    }
};

export default resolver;