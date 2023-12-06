urls:
 + POST auth/signup -- ***body:*** nickname, email, password 
 + GET auth/signin -- ***body:*** nickname, password
 + GET users / GET users/{nickname}
 + POST users/{nickname}/create -- ***body:*** title, subtitle

***Plan:***
 + make GET all posts and user's posts
 + draw a new system design
 + add correct exceptions 
 + docker
 + add load balanser

now
![1](img/systemDesignV1.png)

later
![2](img/systemDesignV2.png)