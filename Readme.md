**user-authentication-service**

A simple project to demonstrate the user authentication flow using following:
* Spring Security
* Spring Data JPA
* Mongo DB

This service has 2 endpoints 
1. **/signup** : Enable users to signup, set their username & password.
    ![img.png](img.png)
2. **/login** : Enable users to login using their credentials.
    ![img_1.png](img_1.png)

**How to set up:**
1. Clone the repo.
2. run "mvn clean install".
3. run "docker-compose up".
4. application is ready to run & test.