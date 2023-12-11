## PasteBin -  service for creating some post (like Reddit)

### Back-end: PostgreSQL for users and post + cache, MongoDB for feedbacks

--------

### ***urls***
POST '/auth/signup' => ***body:*** nickname, email, password (create new user)

POST '/users/{nickname}/create => ***body:*** title, subtitle (create new post)

GET '/posts' (show all posts)

GET '/users' (show all users) 
GET '/users/{nickname}' (show user's info)

GET 'auth/signin' => ***body:*** nickname, password (check user in system)

POST '/feedbacks/create' -- ***body:*** id, title (create new feedback)

GET '/feedbacks' (show all feedback)

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