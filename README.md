urls:
 + POST auth/signup -- ***body:*** nickname, email, password 
 + GET auth/signin -- ***body:*** nickname, password
 + GET users / GET users/{nickname}
 + POST users/{nickname}/create -- ***body:*** title, subtitle

***Plan:***
 + make GET all posts and user's posts
 + add redis for get all post faster
 + draw a new system design
 + add correct exceptions 
 + docker


now
![1](img/systemDesignV1.png)

later
![2](img/systemDesignV2.png)