// this is resolver that will read and return data from DB; 
// will send hardcoded data for now;
const resolver = { friend: () => {
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