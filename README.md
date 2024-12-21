# Task-Manager-API
A task manager that keeps track of users TASKS. An API built with JAVA, SpringBoot that performs CRUD operations

* All DATA will be saved in a TASK-MANAGER DATABASE

# Endpoints

# POST Endpoint
User's will be able to create an account and in doing so their data will be saved in the `User's` Table
1. Id => Primary Key
2. Name
3. Accupation
4. Email
5. Password

Each user will have a unique ID to represent their TASK and task info when they POST it to the `TASK` Table
1. user_id => Primary Keys
2. task_id => Primary Keys
3. tasks
4. Created_Date => ( The date of wich the task was created )
5. Due_Date => ( Due date of the task )
6. Complete => ( 0 for incomplete and 1 for complete ) >> A Task will remain incomplete if its status is not changed to complete before the due date ends

# GET Endpoint
When a user logs in, their information will be retrieved to validate their login

When logged in, users will GET tasks matching their user id's

__For each user stats
1. Get the total number of Tasks
2. Get the total number of completed tasks
3. Get the total number of incomplete tasks

# PUT Endpoint
Each user:
1. Will be able to update thier Task incase they made a mistake
2. Will be abel to update their due date incase if it has to be increased or decreased
3. Will be able to mark their TASKS as complete or incomplete => Functionality only available if the due date has not passed

# DELETE Endpoint
Each user:
1. Will have be able to delete their task 
2. Will be able to delete their account
