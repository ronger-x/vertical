INSERT INTO vertical.user (id, user_no, user_email, user_password, user_url, user_avatar_type, user_avatar_url, user_name) VALUES ('4bffddf7-04e9-4229-8fbe-e8809ef9743d', 1, 'admin', '123123', '', null, '/images/avatar/mario.jpg', '系统管理员');


INSERT INTO vertical.article (id, article_title, article_tags, article_thinker_id, article_permalink, article_create_time, article_update_time, article_status, article_type, article_content, article_summary) VALUES (1034256661512065024, 'Spring Data JPA入门（一）', 'JPA', '4bffddf7-04e9-4229-8fbe-e8809ef9743d', 'http://voally.com/article/1034256661512065024', '1535420978321', '1535420978321', 0, 0, '## 什么是JPA
JPA(Java Persistence API)是Sun官方提出的Java持久化规范。它为Java开发人员提供了一种对象/关联映射工具来管理Java应用中的关系数据。它的出现主要是为了简化现有的持久化开发工作和整合ORM技术结束现在Hibernate、TopLink等ORM框架各自为营的局面。
>ORM：通过使用描述对象和数据库之间映射的元数据，将程序中的对象自动持久化到关系数据库中。本质就是将数据从一种形式转换到另外一种形式。

JPA是在充分吸收了现有Hibernate、TopLink等ORM框架的基础上发展起来的，具有易于使用，伸缩性强等优点。

>注意: JPA不是一种新的ORM框架，它的出现只是用于规范现有的ORM技术，它不能取代现有的Hibernate等ORM框架，相反，采用JPA开发时，我们仍将使用这些ORM框架，只是此时开发出来的应用不在依赖于某个持久化提供商。应用可以在不修改代码的情况下在任何JPA环境下运行，真正做到低耦合，可扩展的程序设计。类似于JDBC，在JDBC出现以前，我们的程序针对特性的数据库API进行编程，但是现在我们只需要针对JDBC API编程，这样能够在不改变代码的情况下就能换成其他的数据库。

JPA是一套规范，不是一套产品。Hibernate是一套产品，如果这些产品实现了JPA规范，那么我们可以叫它们为JPA的实现产品。使用JPA，就可以把我们的应用完全从Hibernate中解脱出来。
JPA规范与ORM框架的关系如下图：
![](https://diycode.b0.upaiyun.com/photo/2018/70f4ac26816255c9d9c593b749d8cc6a.png)
## JPA相关的技术
### ORM映射元数据
JPA支持XML和JDK5.0注解两种元数据形式，元数据描述对象和表之间的映射关系，框架根据这个关系将实体对象持久化到数据库表中。
### Java持久化API
用来操作实体对象，执行CRUD操作，框架在后台替我们完成所有的事情，开发者可以从繁琐的JDBC和SQL代码中解脱出来。
### 查询语言（JPQL）
这是持久化操作中很重要的一个方面，通过面向对象而非面向数据库的查询语言查询数据，避免程序的SQL语句紧密耦合。
## 什么是Spring-data-jpa
Spring Data JPA是Spring Data数据系列的一部分，使用它可以轻松实现基于JPA的基础库。 该模块对JPA的数据访问层进行了增强支持。 它使得Spring应用程序构建和使用数据访问技术变得更加容易。
## Spring-data-jpa和JPA区别
Spring data jpa是在JPA规范下提供了Repository层的实现，但是使用哪一种ORM需要你来决定。虽然ORM框架都实现了JPA规范，但是在不同的ORM框架之间切换仍然需要编写不同的代码，而通过使用Spring data jpa能够方便大家在不同的ORM框架之间进行切换而不要更改代码。并且spring data jpa 对Repository层封装的很好，也省去了不少的麻烦。
![](https://diycode.b0.upaiyun.com/photo/2018/a066b1af52c500974b1b0e81fe4ae459.png)
## 实际使用
在实际的工程中，推荐采用Spring Data JPA + ORM(如：Hibernate)进行开发，这样在切换不同的ORM提供了方面，同时也使得Repository变得简单。程序低耦合。
## spring-boot中使用
只需要在pom.xml中添加如下代码：
```
<dependency>
        <groupId>org.springframework.data</groupId>
        <artifactId>spring-data-jpa</artifactId>
</dependency>

<!--spring-boot-starter-data-jpa包含spring-data-jpa、spring-orm 和 Hibernate 来支持 JPA-->
<dependency>
        <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```', 'JPA(Java Persistence API) 是 Sun 官方提出的 Java 持久化规范。它为 Java 开发人员提供了一种对象 / 关联映射工具来管理 Java 应用中的关系数据。它的出现主要是为了简化现有的持久化开发工作和整合 ORM 技术结束现在 Hibernate、TopLink 等 ORM 框架各自为营的局面。');