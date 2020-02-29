# WhiteProject
仿照某博客教程做的一个图书管理系统后台
## 技术栈
Springboot2.2.4
## 如何使用

## 个人笔记
### jdbc配置和jpa常用设置
```yaml
server:
  port: 8443
spring:
  datasource:
    url: jdbc:mysql://127.0.0.1:3306/whiteproject?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai
    username: root
    password: root
    driver-class-name: com.mysql.cj.jdbc.Driver
  jpa:
    show-sql: true
    properties:
      hibernate:
        format_sql: true
```
### 测试数据库连接
```java
@SpringBootTest
class WhiteprojectApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
        System.out.println(dataSource.getClass());
        System.out.println(dataSource.getConnection());
    }

}
```
### JPA的使用
#### jpa常用注解
`@Entity`: 实体类

`@Table`: 实体类映射的表名

`@JsonIgnoreProperties`: 转换为json格式时忽略的属性

`@Id`: 主键

`@GeneratedValue`: 生成策略

`@Column`: 映射的列名
```java
@Getter
@Setter
@Entity
@Table(name = "user")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    String username;
    String password;
}
```
> 代码中的`getter`和`setter`注解为lombok工具自动生成get和set方法
#### JpaRepository
常见用法
```java
public interface UserDao extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    User getByUsernameAndPassword(String username, String password);
}

public interface BookDao extends JpaRepository<Book, Integer> {
    List<Book> findAllByCategory(Category category);
//    List<Book> findAllByTitleLikeOrAuthorOrLike(String keyword1, String keyword2);
}
```

## 相关教程


