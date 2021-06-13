import express from 'express';
import schema from './schema/querySchema';
import { graphqlHTTP } from 'express-graphql';

const app = express();

app.get('/', (request, response) => {
    response.send('GraphQL server is all set.');
});




app.use('/graphql', graphqlHTTP({
    schema: schema,
    rootValue: root,
    graphiql: true
}))

app.listen(4000, () => console.log('Server is running on localhost:4000/graphql...'));