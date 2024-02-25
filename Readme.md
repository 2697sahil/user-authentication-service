# user-authentication-service

A simple project to demonstrate the user authentication flow using following:
* Spring Security
* Spring Data JPA
* Mongo DB

## Overview
This service has 2 endpoints 

### /signup: 
Enable users to sign up, set their username & password.
    ![img.png](img.png)

Once the user signs up the details are stored in the mongodbDB, with a sample as follows.
    ![img_2.png](img_2.png)

### /login: 
Enable users to login using their credentials.
    ![img_1.png](img_1.png)

**How to set up:**
1. Clone the repo.
2. run "mvn clean install".
3. run "docker-compose up".
4. application is ready to run & test in postman.