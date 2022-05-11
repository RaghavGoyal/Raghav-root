## **Creating Custom Runtime**

This folder shows how to create a custom runtime with multiple services using ZIO.
This example shows two services- <BR>
1. Logging <BR>
2. Email

Step 1: Create the traits(along with their companion objects) for each service.<BR>
Step 2: create the live implementation for logger service.<BR>
Step 3: Create the mock email service implementation.<BR>
Step 4: Create the custom runtime with required service dependencies.<BR>
Step 5: execute the app logic with created runtime.<BR>

