## PasteBin -  service for creating some post (like Reddit)

### Back-end: PostgreSQL for users and post + cache, MongoDB for feedbacks

--------

### ***URIs:***
+ #### Create new user => POST '/auth/signup' ***body:*** { nickname, email, password }
+ #### Create new post (authenticated) => POST '/users/{nickname}/create' ***body:*** { title, subtitle }
+ #### Show all posts => GET '/posts'
+ #### Show all users => GET '/users' 
+ #### Show user's info => GET '/users/{nickname}'
+ #### Create new feedback (authenticated) => POST '/feedbacks/create' ***body:*** { id, title }
+ #### Show all feedback => GET '/feedbacks'
--------------------
### ***System design***
![1](img/systemDesign.png)
--------------
### ***Quickstart***
```shell
git clone https://github.com/Max1m3L/PasteBin.git
```
or download <https://github.com/Max1m3L/PasteBin.git>

*then go to this directory and...*
```shell
mvn package
```

```shell
docker build .
```
*and run docker-compose.yml*

---------