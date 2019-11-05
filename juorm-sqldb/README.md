***

## JUORM-SQLDB

`JUORM-SQLDB` 是基于jdbc实现对关系型数据库进行数据操作的框架。

## 快速入门

`Maven` 配置：

```xml
<dependency>
    <groupId>cn.featherfly.juorm</groupId>
    <artifactId>juorm-sqldb</artifactId>
    <version>0.2.0</version>
</dependency>
```
`Gradle` 配置：
```
compile group: 'cn.featherfly.juorm', name: 'juorm-sqldb', version: '0.2.0'
```

#### 操作代码概览

通过使用jurom api操作的代码概览：

```java
BasicDataSource dataSource = new BasicDataSource();
dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/juorm_jdbc");
dataSource.setDriverClassName("com.mysql.jdbc.Driver");
dataSource.setUsername("root");
dataSource.setPassword("123456");
Jdbc jdbc = new SpringJdbcTemplateImpl(dataSource, Dialects.MYSQL);
DatabaseMetadata metadata = DatabaseMetadataManager.getDefaultManager().create(dataSource);
JdbcMappingFactory mappingFactory = new JdbcMappingFactory(metadata, Dialects.MYSQL);
TplConfigFactory configFactory = new TplConfigFactoryImpl("tpl/");
Juorm juorm = new JuormJdbcImpl(jdbc, mappingFactory, configFactory);

// 通过主键获取
User u = juorm.get(id, User.class);

// 插入数据
int result = juorm.save(u);

// 更新数据
int result = juorm.update(u);// 或者 juorm.merge(u); // update和merge区别在后面具体介绍的章节中有说明

// 删除数据
int result = juorm.delete(u);

// DSL模式更新数据
int result = juorm.update(User.class).set("name", newName).property("descp").set(newDescp).where().eq("id", id).execute();

// DSL模式更新数据自增长
int result = juorm.update(User.class).increase("age", 1).where().eq("id", id).execute();

// DSL模式删除数据
int result = juorm.delete(User.class).where().in("id", new Integer[] { r.getId(), r2.getId() }).or().eq("id", r3.getId()).or().ge("id", r4.getId()).execute();

// DSL模式查询数据
List<User> users = query.find("user").where().eq("username", "yufei").and().eq("password", "123456").and().group().gt("age", 18).and().lt("age", 60).list(User.class)
List<Role> roles = juorm.query(Role.class).where().gt("id", 5).and().le("id", 10).list()

// 模板SQL查询数据
int avg = juorm.intValue("selectAvg2", new HashChainMap<String, Object>().putChain("age", 40));
String str = juorm.stringValue("selectString", new HashChainMap<String, Object>());
User u = juorm.single("user@selectByUsername", User.class,
                new HashChainMap<String, Object>().putChain("username", username));
List<User> users = juorm.list("user@selectConditions", User.class, new HashChainMap<String, Object>()
                .putChain("minAge", minAge).putChain("maxAge", maxAge).putChain("username", username2 + "%"));
PaginationResults<User> userPaginationResults = executor.pagination("user@selectConditions", User.class,
                new HashChainMap<String, Object>(), start, limit);
```

通过使用mapper操作的代码概览（类似mybatis的mapper）：

```java
// 类似于mybatis，直接执行模板中的sql
@TplExecution(namesapce = "user")
public interface UserMapper {
	User selectByUsername(@TplParam("username") String username);

    Map<String, Object> selectByUsername2(@TplParam("username") String username);

    User selectByUsernameAndPassword(@TplParam("username") String username, @TplParam("password") String pwd);

    Integer selectAvg();

    String selectString();

    List<User> selectByAge2(@TplParam("age") Integer age);

    @TplExecution
    List<User> selectByAge2(@TplParam("age") Integer age, @TplParam(type = TplParamType.PAGE_OFFSET) int offset,
            @TplParam(type = TplParamType.PAGE_LIMIT) int limit);

    @TplExecution
    List<User> selectByAge2(@TplParam("age") Integer age, Page page);

    @TplExecution(name = "selectByAge2")
    PaginationResults<User> selectByAge2Page(@TplParam("age") Integer age,
            @TplParam(type = TplParamType.PAGE_OFFSET) int offset, @TplParam(type = TplParamType.PAGE_LIMIT) int limit);

    @TplExecution(name = "selectByAge2")
    PaginationResults<User> selectByAge2Page(@TplParam("age") Integer age, Page page);

    List<User> selectById(@TplParam("id") Integer id);

    Integer selectAvg2(@TplParam("age") Integer age);

    String selectString2(@TplParam("id") Integer id);

    @TplExecution(namesapce = "user_info")
	List<Map<String, Object>> select2();

    @TplExecution(namesapce = "user_info", name = "select2")
    List<Map<String, Object>> select2(@TplParam(type = TplParamType.PAGE_OFFSET) int offset,
            @TplParam(type = TplParamType.PAGE_LIMIT) int limit);

    @TplExecution(namesapce = "user_info", name = "select2")
    List<Map<String, Object>> select2(Page page);

    @TplExecution(namesapce = "user_info", name = "select2")
    PaginationResults<Map<String, Object>> select2Page(@TplParam(type = TplParamType.PAGE_OFFSET) int offset,
            @TplParam(type = TplParamType.PAGE_LIMIT) int limit);

    @TplExecution(namesapce = "user_info", name = "select2")
    PaginationResults<Map<String, Object>> select2Page(Page page);

    @TplExecution(namesapce = "user_info", name = "selectById")
    List<Map<String, Object>> selectById2(@TplParam("id") Integer id);
}
```

```java
// 除了可以使用模板sql进行查询外，可以继承Juorm或者GenericJuorm进行api操作,需要使用jdk8的default method
@TplExecution(namesapce = "user")
public interface UserMapper3 extends GenericJuorm<User> {
	// 这里的query方法就是GenericJuorm接口定义的方法
	default User getByUsernameAndPassword(String username, String pwd) {
        return query().where().eq("username", username).and().eq("pwd", pwd).single();
    }

    default User getByUsernameAndPassword2(String username, String pwd) {
        return query().where().eq("username", username).and().eq("password", pwd).single();
    }

    default User getByUsernameAndPassword3(String username, String pwd) {
        return query().where().property("username").eq(username).and().property("pwd").eq(pwd).single();
    }
}
// 外部调用就可以直接使用Juorm或者GenericJuorm里定义的方法, UserMapper3 userMapper; userMapper.save(user);
```

## 目录

- [**`基础配置`**](#基础配置)
	- [**`最基础的配置文件`**](#最基础的配置文件)
    - [**`JuormJdbcImpl配置`**](#JuormJdbcImpl配置)
    - [**`Mapper配置`**](#Mapper配置)
    - [**`Spring集成`**](#Spring集成)
- [**`对象映射基础操作`**](#对象映射基础操作)
	- [**`数据对象映射配置`**](#数据对象映射配置)
    - [**`主键查询对象`**](#主键查询对象)
    - [**`保存对象`**](#保存对象)
    - [**`更新对象`**](#更新对象)
    - [**`删除对象`**](#删除对象)
- [**`DSL模式操作数据`**](#DSL模式操作数据)
	- [**`DSL模式更新数据`**](#DSL模式更新数据)
    - [**`DSL模式删除数据`**](#DSL模式删除数据)
    - [**`DSL模式查询数据`**](#DSL模式查询数据)
- [**`模板SQL查询`**](#模板SQL查询)
    - [**`模板SQL唯一值查询`**](#模板SQL唯一值查询)
    - [**`模板SQL唯一记录查询`**](#模板SQL唯一记录查询)
    - [**`模板SQL列表查询`**](#模板SQL列表查询)
    - [**`模板SQL分页查询`**](#模板SQL分页查询)
- [**`模板动态SQL`**](#模板动态SQL)
    - [**`where支持`**](#where支持)
    - [**`and和or支持`**](#and和or支持)
    - [**`columns支持`**](#columns支持)
    - [**`sql关键字支持`**](#sql关键字支持)
    - [**`include支持`**](#include支持)
- [**`使用Mapper`**](#使用Mapper)
    - [**`Mapper的定义方式`**](#Mapper的定义方式)

## 基础配置

### 最基础的配置文件

**在resources目录下加入constant.yaml文件（默认是从classpath根目录读取）**

```yaml
basePackeges: cn.featherfly
devMode: true
```
`basePackeges` 需要扫描constant配置的包路径，多个包使用逗号（,）隔开，如(cn.fetherfly,com.github)。如果你的项目没有使用constant配置，直接使用cn.featherfly就行了。\
`devMode` 开发模式，为true时，sql模板会在每次获取时都重新从文件读取，生产环境请设置为false，或者删除此配置，默认值就是false

**java中初始化配置**
```java
import cn.featherfly.constant.ConstantConfigurator;
//默认使用constant.yaml，如果你要使用其他名字，请使用config(fileName)传入文件名
ConstantConfigurator.config();
```

### JuormJdbcImpl配置
```java
import cn.featherfly.constant.ConstantConfigurator;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.db.metadata.DatabaseMetadataManager;
import cn.featherfly.juorm.rdb.jdbc.mapping.JdbcMappingFactory;
import cn.featherfly.juorm.rdb.sql.dialect.Dialects;
import cn.featherfly.juorm.tpl.TplConfigFactory;
import cn.featherfly.juorm.tpl.TplConfigFactoryImpl;

ConstantConfigurator.config();
BasicDataSource dataSource = new BasicDataSource();
dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/juorm_jdbc");
dataSource.setDriverClassName("com.mysql.jdbc.Driver");
dataSource.setUsername("root");
dataSource.setPassword("123456");
// 这里的dataSource使用你自己的数据源实现
Jdbc jdbc = new SpringJdbcTemplateImpl(dataSource, Dialects.MYSQL);
DatabaseMetadata metadata = DatabaseMetadataManager.getDefaultManager().create(dataSource);

//Jdbc jdbc = new SpringJdbcTemplateImpl(dataSource, Dialects.POSTGRESQL);
//DatabaseMetadata metadata = DatabaseMetadataManager.getDefaultManager().create(dataSource, "juorm_jdbc");
// 使用PostgreSQL和Oracle时需要在create时传入数据库名称

JdbcMappingFactory mappingFactory = new JdbcMappingFactory(metadata, Dialects.MYSQL);
TplConfigFactory configFactory = new TplConfigFactoryImpl("tpl/");
Juorm juorm = new JuormJdbcImpl(jdbc, mappingFactory, configFactory);
// 然后使用juorm进行数据操作
```

### Mapper配置

文档中使用Mapper这个名词是因为Mybatis使用此名词，这样会让有Mybatis经验的读者更容易理解。

**定义Mapper**

```java
@TplExecution(namesapce = "user")
public interface UserMapper {
	User selectByUsername(@TplParam("username") String username);
    // 根据需要定义更多方法
}
```

**使用Mapper**

```java
TplDynamicExecutorFactory mapperFactory = TplDynamicExecutorFactory.getInstance();
Juorm juorm = new JuormJdbcImpl(jdbc, mappingFactory, configFactory);
UserMapper userMapper = mapperFactory.newInstance(UserMapper.class, juorm);
// 然后使用userMapper进行数据操作
```

### Spring集成

**配置Mapper**

```java
@Configuration
public class Appconfig {
	// 动态注册Mapper，类似mybatis,在packages里指定包扫描路径
    @Bean
    public DynamicTplExecutorSpringRegistor tplDynamicExecutorSpringRegistor() {
        Set<String> packages = new HashSet<>();
        packages.add("cn.featherfly");
        //packages.add("你需要扫描的包路径");
        DynamicTplExecutorScanSpringRegistor registor = new DynamicTplExecutorScanSpringRegistor(packages, "juorm");
        return registor;
    }

    @Bean
    public JuormJdbcImpl juorm(DataSource dataSource) {
    	// dataSource通过xml配置，可以根据需求动态更换dataSource实现
        DOMConfigurator.configure(ClassLoaderUtils.getResource("log4j.xml", JdbcTestBase.class));
        ConstantConfigurator.config();
        Jdbc jdbc = new SpringJdbcTemplateImpl(dataSource, Dialects.MYSQL);
        DatabaseMetadata metadata = DatabaseMetadataManager.getDefaultManager().create(dataSource);
        JdbcMappingFactory mappingFactory = new JdbcMappingFactory(metadata, Dialects.MYSQL);
        // tpl/代表sql模板从classpath查找的根目录
        TplConfigFactory configFactory = new TplConfigFactoryImpl("tpl/");
        JuormJdbcImpl juorm = new JuormJdbcImpl(jdbc, mappingFactory, configFactory);
        return juorm;
    }
}
```
xml配置dataSource
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:p="http://www.springframework.org/schema/p"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
		http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">
	<context:component-scan
		base-package="cn.featherfly.juorm" />
	<cache:annotation-driven proxy-target-class="true"/>
	<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource">
	   <property name="url" value="jdbc:mysql://127.0.0.1:3306/juorm_jdbc"/>
	   <property name="driverClassName" value="com.mysql.jdbc.Driver"/>
	   <property name="username" value="root"/>
	   <property name="password" value="123456"/>
	</bean>
</beans>

```

**使用Mapper**

```java
@Service
public class UserService {
    @Resource
    UserMapper userMapper;
}
```

## 对象映射基础操作

### 数据对象映射配置

使用JPA标准注解进行对象映射，不支持级联更新和懒加载级别的级联查询。\
注解`@Table`或者`@Entity`标注的类，会被视为数据映射对象。如果没有指定name属性，则使用类名称进行映射，名称包含多个大写开头的单词被映射为下划线连接的全小写名称，如UserInfo映射为user_info。\
注解`@Id`标注的属性映射为数据库主键列。\
注解`@Column`标注的属性强制映射一个数据库列，如果不指定name，则使用属性名进行映射。\
注解`@ManyToOne`或者`@OneToOne`标注的属性与JPA一致，只是没有支持级联更新和懒加载级联查询。
注解`@Embedded`标注的属性与JPA中一致。\
**没有被标注的属性使用隐式映射，使用数据库列反向映射到实体对象，如果是下划线连接的单词，会被转换为驼峰形式，如列名parent_id映射为属性名parentId**

**后续文档使用的对象定义**

```java
@Table
public class User {
    @Id
    private Integer id;
    private String username;
    @Column(name = "password")
    private String pwd;
    private String mobileNo;
    private Integer age;
    // 省略get set
}

@Table
public class Role {
    @Id
    private Integer id;
    private String name;
    private String descp;
    // 省略get set
}

@Table
public class UserInfo {
    @Id
    private Integer id;
    private String name;
    private String descp;
    @ManyToOne
    //@OneToOne
    @Column(name = "user_id")
    private User user;
    @Embedded
    private DistrictDivision division;
    // 省略get set
}

@Table
public class UserRole {
    @Id
    private Integer userId;
    @Id
    private Integer roleId;
    private String descp;
    private String descp2;
}

@Table(name = "user_role")
public class UserRole2 {
    @Id
    @ManyToOne
    @Column(name = "user_id")
    private User user;
    @Id
    @ManyToOne
    @Column(name = "role_id")
    private Role role;
    private String descp;
    private String descp2;
}

@Entity(name = "cms_article")
public class Article {
    @Id
    private Integer id;
    private String title;
    private String content;
}
public class DistrictDivision {
    @Column
    private String city;
    private String province;
    private String district;
}
```

### 主键查询对象

`juorm.get(entity)`  
`juorm.get(Serializable id, Class<E> type)`


#### 单一主键查询

```java
Role role = juorm.get(id, Role.class);
UserInfo ui = juorm.get(id, UserInfo.class);
```

#### 复合主键查询

```java
UserRole userRole = new UserRole();
Integer roleId = 2;
Integer userId = 2;
userRole.setRoleId(roleId);
userRole.setUserId(userId);
UserRole ur = juorm.get(userRole);

UserRole2 userRole = new UserRole2();
Integer roleId = 2;
Integer userId = 2;
userRole.setRole(new Role(roleId));
userRole.setUser(new User(userId));
UserRole2 ur = juorm.get(userRole);
```

### 保存对象

`juorm.save(entity)`  
`juorm.save(entity...array)`  
`juorm.save(List<Entity>)`

#### 单一主键保存

单一主键支持数据库自增长，保存是可以不设置主键，默认配置保存后会把数据库生成的主键设置会主键对应的属性

```java
Role role = new Role();
// 设置role属性
int result = juorm.save(role);
// 返回保存数据影响的行数

UserInfo ui = new UserInfo();
ui.setUser(new User(1));
ui.setDescp("descp_" + RandomUtils.getRandomInt(100));
ui.setName("name_" + RandomUtils.getRandomInt(100));
ui.setDivision(new DistrictDivision("四川", "成都", "高新"));
juorm.save(ui);
```

#### 复合主键保存

复合主键只能手动设置值

```java
UserRole userRole = new UserRole();
Integer roleId = 2;
Integer userId = 2;
userRole.setRoleId(roleId);
userRole.setUserId(userId);
// 设置userRole属性
juorm.save(userRole);

UserRole2 userRole2 = new UserRole2();
Integer roleId = 2;
Integer userId = 2;
userRole2.setRole(new Role(roleId));
userRole2.setUser(new User(userId));
// 设置userRole2属性
juorm.save(userRole);
```

### 更新对象

`juorm.update(entity, IgnorePolicy)` 使用指定策略更新对象  
`juorm.update(List<Entity>, IgnorePolicy)` 使用指定策略更新对象列表  
**下面三个等于update(entity, IgnorePolicy.NONE), 如果传入对象有null或者空字符串，会被更新到数据库**  
`juorm.update(entity)`  
`juorm.update(entity...array)`  
`juorm.update(List<Entity>)`  
**下面三个等于update(entity, IgnorePolicy.EMPTY), 忽略传入对象的null或者空字符串，不会更新null和空字符串到数据库**  
`juorm.merge(entity)`  
`juorm.merge(entity...array)`  
`juorm.merge(List<Entity>)` 

#### 单一主键更新

```java
Role r = new Role();
r.setId(1);
r.setName("name");
r.setDescp("descp");
juorm.update(r);

UserInfo ui = new UserInfo();
ui.setId(1);
ui.setUser(new User(1));
ui.setDescp("descp_" + RandomUtils.getRandomInt(100));
ui.setName("name_" + RandomUtils.getRandomInt(100));
ui.setDivision(new DistrictDivision("四川", "成都", "高新"));
juorm.update(ui);

Role r2 = new Role();
r2.setId(r.getId());
r2.setName("merge_name" + RandomUtils.getRandomInt(100));
juorm.merge(r2);

UserInfo ui2 = new UserInfo();
ui2.setId(2);
ui2.setDescp("descp_" + RandomUtils.getRandomInt(100));
juorm.merge(ui2);
```

#### 复合主键更新

```java
UserRole userRole = new UserRole();
userRole.setRoleId(3);
userRole.setUserId(3);
userRole.setDescp("descp_update_1");
userRole.setDescp2("descp2_update_1");
juorm.update(userRole);

UserRole2 userRole2 = new UserRole2();
userRole2.setRole(new Role(3));
userRole2.setUser(new User(3));
userRole2.setDescp("descp_update_2");
userRole2.setDescp2("descp2_update_2");
juorm.update(userRole2);

UserRole ur = new UserRole();
ur.setRoleId(4);
ur.setUserId(4);
ur.setDescp("descp_update_" + RandomUtils.getRandomInt(99));
juorm.merge(ur);
```

### 删除对象

`juorm.delete(entity)`  
`juorm.delete(entity...array)`  
`juorm.delete(List<Entity>)`  

#### 单一主键删除

```java
Role r = new Role();
r.setId(1);
int result = juorm.delete(r);
// 返回删除数据影响的行数
// juorm.delete(entity array), juorm.delete(entity list)
```

#### 复合主键删除

```java
UserRole userRole = new UserRole();
userRole.setRoleId(111);
userRole.setUserId(111);
juorm.delete(userRole);

UserRole2 userRole2 = new UserRole2();
userRole2.setRole(new Role(111));
userRole2.setUser(new User(111));
juorm.delete(userRole2);

```

## DSL模式操作数据

### DSL模式更新数据

**条件查询方法**  
`where` 开启where条件表达式  
`and` and  
`or` or  
`eq` 等于 =  
`ne` 不等于 !=  
`lt` 小于 <  
`le` 小于等于 <=
`gt` 大于 >  
`ge` 大于等于 >=  
`sw` 字符串开始于 like 'value%'  
`ed` 字符串结束于 like '%value'  
`co` 包含字符串 like '%value%'  
`in` in  
`nin` not in  
`isn` is null  
`inn` is not null  
`group` 开启一个条件分组，相当于(  
`endGroup` 结束一个条件分组，相当于)  
`sort` 开启排序表达式

#### 数据更新

```java
juorm.update(Role.class).set("name", newName).property("descp").set(newDescp).where().eq("id", id).execute();
juorm.update(Role.class).set(Role::getName, newName).property(Role::getDescp).set(newDescp).where().eq(Role::getId, id).execute();
```

#### 数据自增长更新

```java
juorm.update(User.class).increase("age", 1).where().eq("id", id).execute();
juorm.update(User.class).increase(User::getAge, 1).where().eq(User::getId, id).execute();

juorm.update(User.class).propertyNumber("age").increase(1).where().eq("id", id).execute();
juorm.update(User.class).propertyNumber(User::getAge).increase(1).where().eq(User::getId, id).execute();
```

### DSL模式删除数据

```java
juorm.delete(Role.class).where().eq("id", id).execute();
juorm.delete(Role.class).where().eq(Role::getId, id).execute();

juorm.delete(Role.class).where().in("id", new Integer[] { id1, id2 }).or().eq("id", id3)
            .or().ge("id", id4).execute();
juorm.delete(Role.class).where().in(Role::getId, new Integer[] { id1, id2 }).or().eq(Role::getId, id3)
            .or().ge(Role::getId, id4).execute();
```

### DSL模式查询数据
`juorm.query(Class)` 返回映射传入对象的条件表达式  
`juorm.query(String)` 返回条件表达式，在最后执行查询操作时进行数据映射


#### 查询单一对象
`single` 查询唯一值

```java
Role r = juorm.query(Role.class).where().eq("id", id).single();
```

#### 查询列表
`list` 查询列表

```java
List<Role> roles = juorm.query(Role.class).where().gt("id", 5).and().le("id", 10).list();
```

#### 查询分页列表
`limit` 设置分页参数

```java
List<Role> roles = juorm.query(Role.class).where().gt("id", 5).and().le("id", 10).limit(2).list();
roles = juorm.query(Role.class).where().gt("id", 5).and().le("id", 10).limit(2, 3).list();
```

#### 查询排序列表
`sort` 调用后进入排序表达式  
`asc` 对传入属性进行升序  
`desc` 对传入属性进行降序

```java
List<Role> roles = juorm.query(Role.class).where().eq("id", 4).or().group().gt("id", 5).and().le("id", 10).sort().asc("id").desc("name").list();
```

## 模板SQL查询

模板配置文件使用yaml格式，属性名就是对应的sql模板id,属性值就是需要使用的sql模板。
内置实现使用的模板引擎是freemarker。

```yaml
select: "select <@prop/> from user_info"
select2: "select id,user_id as `user.id`, name, descp
, province `division.province`, city `division.city`, district `division.district`
 from user_info"
```

API调用传入的tplExecuteId字符串格式为filePath@sqlId  
例：`juorm.single("user@selectByUsername", User.class, new HashChainMap<String, Object>().putChain("username", username))`  
如果sqlId为全局唯一，也可以直接使用sqlId  
例：`juorm.intValue("selectAvg", new HashChainMap<String, Object>())`  
**如果同样的sqlId出现在不同的文件中，调用时没有使用filePath@sqlId进行调用，就会抛出异常，因为程序不知道调用的是哪一个**


后续文档使用的sql模板定义

[**`user.yaml.tpl`**](./src/test/resources/tpl/user.yaml.tpl)

[**`role.yaml.tpl`**](./src/test/resources/tpl/role.yaml.tpl)

[**`role_common.yaml.tpl`**](./src/test/resources/tpl/user.yaml.tpl)


### 模板SQL唯一值查询
`juorm.value`  
`juorm.number`  
`juorm.intValue`  
`juorm.longValue`  
`juorm.bigDecimalValue`  
`juorm.doubleValue`  
`juorm.stringValue`  

```java
Integer avg = juorm.intValue("selectAvg", new HashChainMap<String, Object>());
Integer avg = juorm.intValue("selectAvg2", new HashChainMap<String, Object>().putChain("age", 40));

String str = juorm.stringValue("selectString", new HashChainMap<String, Object>());
String str = juorm.stringValue("selectString2", new HashChainMap<String, Object>().putChain("id", 2));
```


### 模板SQL唯一记录查询
`juorm.single`

```java
User u1 = juorm.single("user@selectByUsername", User.class, new HashChainMap<String, Object>().putChain("username", username));
User u2 = juorm.single("user@selectByUsernameAndPassword", User.class, new HashChainMap<String, Object>().putChain("username", username).putChain("password", password));
```

### 模板SQL列表查询
`juorm.list`

```java
List<User> users = executor.list("user@selectUser", User.class, new HashChainMap<String, Object>());
List<User> users = executor.list("user@selectByAge", User.class, new HashChainMap<String, Object>().putChain("age", 5));
List<User> users = executor.list("user@selectConditions", User.class, new HashChainMap<String, Object>());
List<User> users = executor.list("user@selectConditions", User.class, new HashChainMap<String, Object>().putChain("minAge", minAge).putChain("maxAge", maxAge).putChain("username", username1 + "%"));
List<User> users = executor.list("user@selectConditions", User.class, new HashChainMap<String, Object>().putChain("minAge", minAge).putChain("maxAge", maxAge).putChain("username", username2 + "%"));
```

### 模板SQL分页查询

#### 基础分页
`juorm.list`

```java
List<User> users = executor.list("user@selectConditions", User.class, new HashChainMap<String, Object>(), start, limit);
List<User> users = executor.list("user@selectConditions", User.class, new HashChainMap<String, Object>().putChain("minAge", minAge).putChain("maxAge", maxAge).putChain("username", username1 + "%"),new SimplePagination(start, limit));
```

#### 包装分页
`juorm.pagination`

##### 使用自动构建统计sql

基于查询sql自动转换统计sql,sql转换测试不可能覆盖所有的复查查询，当自动转换有错误时，请使用手动声明统计sql

```java
PaginationResults<User> userPaginationResults = executor.pagination("user@selectConditions", User.class, new HashChainMap<String, Object>(), start, limit);
PaginationResults<User> userPaginationResults = executor.pagination("user@selectConditions", User.class, new HashChainMap<String, Object>().putChain("minAge", minAge).putChain("maxAge", maxAge).putChain("username", username1 + "%"), new SimplePagination(start, limit));
```

##### 手动声明统计sql

yaml配置文件中的sql模板,默认情况下只需要直接把sql模板跟在sqlId后面就行了,当需要手动设置统计sql时，就需要明确声明

```yaml
sqlId:
  query: select sql
  count: count sql
```

查询sql对应的统计sql这两条sql的查询条件都是一样的，所以如果把条件写在两个模板中，每次改动都要改动两个地方，容易造成错误，可以直接使用模板引擎的include机制或者juorm自定义的include机制来引入查询条件部分

具体内容可以进入此章节[**`include支持`**](#include支持)

```java
PaginationResults<Role> uis = executor.pagination("role@selectWithTemplate", Role.class, new HashChainMap<String, Object>(), 0, 10);
PaginationResults<Role> uis = executor.pagination("role@selectWithTemplate2", Role.class, new HashChainMap<String, Object>(), 0, 10);
PaginationResults<Role> uis = executor.pagination("role@selectWithTemplate3", Role.class, new HashChainMap<String, Object>(), 0, 10);
```

## 模板动态SQL

因为使用的模板引擎，所有在sql拼接中，对应的模板引擎支持的功能基本都能使用，不过由于我们只是用来动态拼接SQL,所以为其定制化了一些专用于此的标签和函数。默认使用freemarker，定制的功能也是freemarker的扩展。

### where支持

当<@where><\/@where>中的内容不是空字符串时，会自动加入where关键字,相反则输出空字符串

```sql
select id, username, password pwd, mobile_no, age from user<@where>
<@and if=username??>
    username like :username
</@and>
<@and if=password??>
    password like :password
</@and>
<@and if=mobileNo??>
    mobile_no like :mobileNo
</@and>
<@and if=minAge??>
    age >= :minAge
</@and>
<@and if=maxAge??>
    age <= :maxAge
</@and>
</@where>
```

### and和or支持

`and`和`or`标签的属性是一致的，只是代表含义不同，如果其内容是查询条件，则当if为true时，则会自动追加and(or)。如果内容是一个分组时（小括号包裹的条件表达式），逻辑等同于where（不需要设置属性），只是自动加入的关键字是and(or)。**此标签会自动判断是否需要加入and(or)关键字，不需要人工判断，当成加强版的if标签用就行了**  
`if` 传入布尔值，表示是否需要标签内的内容，当内容是一个分组时，不需要指定  
`name` 字符串，表示当前标签内查询条件的参数名称，此属性大部分时候可以省略，只有无法从内容中获取确切的参数名时，才需要指定

**基于命名占位符**
```sql
select * from user<@where>
    <@and if= age??>
        age = :age
    </@and>
    <@and>
        <@and if= name??>
            name = :name
        </@and>
        <@and if= age??>
            age = :age
        </@and>
        <@or>
            <@and if= minAge??>
                age > :minAge
            </@and>
            <@and if= maxAge??>
                age < :maxAge
            </@and>
        </@or>
        <@and if= minAge??>
            age between :minAge and :maxAge 
        </@and>
    </@and>
    <@and if= age??>
        age = :age
    </@and>
    <@or>
        <@and if= name??>
            name = :name
        </@and>
        <@or if= age??>
            age = :age
        </@or>
    </@or>
    <@and if=sex??>
        sex = :sex
    </@and>
    <@and if=mobile??>
        name = :mobile
    </@and>
    <@or if= name??>
        name = :name
    </@or>
    <@or if= age??>
        age = :age
    </@or>
    <@or if=sex??>
        sex = :sex
    </@or>
    <@or if=mobile??>
        mobile = :mobile
    </@or>
</@where>
```

**基于问号占位符**
```sql
select * from user<@where>
    <@and if = age??>
        age = ?
    </@and>
    <@and if= minAge?? && maxAge?? name="minAge,maxAge">
            age between ? and ?
    </@and>
    <@and>
        <@and if= name??>
            name = ?
        </@and>
        <@and if= age??>
            age = ?
        </@and>
        <@or>
            <@and if= minAge?? name="minAge">
                age > ?
            </@and>
            <@and if= maxAge?? name="maxAge">
                age < ?
            </@and>
        </@or>
    </@and>
    <@and if= age??>
        age = ?
    </@and>
    <@or>
        <@and if= name??>
            name = ?
        </@and>
        <@or if= age??>
            age = ?
        </@or>
    </@or>
    <@and if=sex??>
        sex = ?
    </@and>
    <@and if=mobile??>
        name = ?
    </@and>
    <@or if= name??>
        name = ?
    </@or>
    <@or if= age??>
        age = ?
    </@or>
    <@or if=sex??>
        sex = ?
    </@or>
    <@or if=mobile??>
        mobile = ?
    </@or>
</@where>
```

### columns支持

同一个实现默认注册了两个标签名，推荐使用<@prop>，因为这是标准名称，<@columns>只是为了在这里更应景而已。  
`<@columns>`  
&ensp;&ensp;`table` 查询的表名   
`<@prop>`  
&ensp;&ensp;`repo` 查询的表名   
**共有属性**  
&ensp;&ensp;`alias` 查询表名的别名  
<!-- 
&ensp;&ensp;`mapping` 查询结果需要映射的类型（className），一般不需要设置，因为外部调用时会传入需要返回的对象
-->

```yaml
selectByUsername: >
    select <@columns table='user'/> from <@wrap value='user'/> where username = :username    
selectByAge: "select <@prop/> from user where age = :age"
selectById: "select <@prop repo='user_info'/> from user_info where id = :id"
selectWithTemplate3:
  query: >
    select <@prop alias="_r"/> <@tpl id='roleFromTemplate2' file='tpl/role_common'/>
  count: "select count(*) <@sql id='roleFromTemplate2' file='tpl/role_common'/>"
```

**如果调用返回的映射对象是已经使用@Entity或者@Table标注的实体对象，则只需要`<@prop/>`或者`<@columns/>`就行了，标签实现会根据对象映射信息生成正确的内容  
如果调用返回的映射对象不是已经使用@Entity或者@Table标注的实体对象，则需要加入属性`<@columns table='user'/>或者<@prop repo='user_info'/>`**

### sql关键字支持

如果你的某一个列名或者表名是数据库的关键字，在写SQL时就要使用数据库特定的符号把其括起来  
mysql使用 \`\`，例：\`user\`  
postgresql使用 "", 例: "user"  
所以提供了一个专门用来包装SQL关键字的标签和函数，其输出的格式通过指定的Dialect决定

**标签实现**
```yaml
selectByUsernameAndPassword: >
    select username, password pwd from <@wrap value="user"/> where username = :username and password = :password
```

**函数实现**
```yaml
selectByUsernameAndPassword: >
    select username, password pwd from ${tpl_wrap("user")} where username = :username and password = :password    
```

### include支持

前面已经说了，使用模板引擎，所以模板引擎有的功能都能使用，include也是一样。  
**不建议使用模板自带include机制，因为自定义的include实现更方便**

#### 自定义include实现

同一个实现默认注册了两个标签名，推荐使用<@tpl>，因为这是标准名称，<@sql>只是为了在这里更应景而已。

`<@tpl id='roleFromTemplate2'/>`和`<@sql id='roleFromTemplate2'/>`是同一个实现不同的别名  
`id` 表示sqlId  
`file` 表示yaml模板文件,如果是同一个文件中，可以省略此配置  
```yaml
selectWithTemplate2:
  query: "select <@prop/> <@tpl id='roleFromTemplate2'/>"
  count: "select count(*) <@sql id='roleFromTemplate2'/>"
roleFromTemplate2: "from role <@where>
<@and if = name??>
    name like :name
</@and>
</@where>"
selectWithTemplate3:
  query: >
    select <@prop alias="_r"/> <@tpl id='roleFromTemplate2' file='tpl/role_common'/>
  count: "select count(*) <@sql id='roleFromTemplate2' file='tpl/role_common'/>"
```

##### freemarker的include机制
`<#include '/tpl/role@roleFromTemplate'>` /tpl/role代表yaml模板文件，roleFromTemplate代表文件中的sqlId
```yaml
selectWithTemplate:
  query: "select <@prop/> <#include '/tpl/role@roleFromTemplate'>"
  count: "select count(*) <#include '/tpl/role@roleFromTemplate'>"
roleFromTemplate: "from role <@where>
<@and if = name??>
    name like :name
</@and>
</@where>"
```

## 使用Mapper

### Mapper的定义方式

Mapper就是定义指定操作方法的接口类，juorm有三种Mapper的定义方式

1. 直接定义一个接口，使用@TplExecution标注，外部使用此mapper时，只提供此接口定义的方法
```java
@TplExecution(namesapce = "user")
public interface UserMapper {
	// methods
}
```
2. 直接定义一个接口，使用@TplExecution标注，继承Juorm接口，外部使用此mapper时，除了提供此接口定义的方法，还能使用Juorm内定义的方法，方法内部也可以使用default method调用Juorm接口内的方法实现一些基础功能
```java
@TplExecution(namesapce = "user")
public interface UserMapper2 extends Juorm {
	// methods
}
```
3. 直接定义一个接口，使用@TplExecution标注，继承GenericJuorm接口，外部使用此mapper时，除了提供此接口定义的方法，还能使用GenericJuorm内定义的方法，方法内部也可以使用default method调用Juorm接口内的方法实现一些基础功能
```java
@TplExecution(namesapce = "user")
public interface UserMapper3 extends GenericJuorm<User> {
	// methods
}
```

**如果需要定义一个实体对象的Mapper，建议使用继承GenericJuorm接口的方式，这样此mapper就能把对应实体的基础操作都提供了**