## hammer-sqldb

`hammer-sqldb` 是基于 jdbc 实现对关系型数据库进行数据操作的框架。

## 快速入门

`Maven` 配置：

```xml
<dependency>
    <groupId>cn.featherfly.hammer</groupId>
    <artifactId>hammer-sqldb</artifactId>
    <version>LATEST</version>
</dependency>
```

`Gradle` 配置：

```
compile group: 'cn.featherfly.hammer', name: 'hammer-sqldb', version: '+'
```

#### 操作代码概览

通过快速预览各种实际代码对 hammer 有一个大致的了解

通过使用 hammer api 操作的代码概览：

```java

// 示例用，具体配置看SqlDbHammerImpl配置章节
Hammer hammer = new SqldbHammerImpl(jdbc, mappingFactory, configFactory);

// 通过主键获取
User u = hammer.get(id, User.class);

// 插入数据
int result = hammer.save(u);

// 更新数据
int result = hammer.update(u);// 或者 hammer.merge(u); // update和merge区别在后面具体介绍的章节中有说明

// 删除数据
int result = hammer.delete(u);

// DSL模式更新数据
int result = hammer.update(User.class)
    			.set("name", newName)
    			.property("descp").set(newDescp)
    			.where()
    			.eq("id", id)
    			.execute();
int result = hammer.update(User.class)
    			.set(User::getName, newName)
    			.property(User::getDescp).set(newDescp)
    			.where()
    			.eq(User::getId, id)
    			.execute();

// DSL模式更新自增长数据
int result = hammer.update(User.class)
    			.increase("age", 1)
    			.where()
    			.eq("id", id)
    			.execute();
int result = hammer.update(User.class)
    			.increase(User::getAge, 1)
    			.where()
    			.eq(User::getId, id)
    			.execute();

// DSL模式删除数据
int result = hammer.delete(Role.class)
    			.where()
    			.in("id", new Integer[] { r.getId(), r2.getId() })
    			.or()
    			.eq("id", r3.getId())
    			.or()
    			.ge("id", r4.getId())
    			.execute();
int result = hammer.delete(Role.class)
    			.where()
    			.eq(Role::getId, r3.getId())
    			.execute();

// DSL模式查询数据
User user = hammer.query("user")
    			.where()
    			.eq("username", username)
    			.and()
    			.eq("password", password)
    			.single()    
User user = hammer.query(User.class)
    			.where()
    			.eq(User::getUsername, username)
    			.and()
    			.eq(User::getPassword, password)
    			.single()
List<User> users = hammer.query("user")
    			.where()
    			.eq("username", username)
    			.and()
    			.eq("password", password)
    			.and()
    			.group()
    				.gt("age", 18)
    				.and()
    				.lt("age", 60)
    			.list(User.class)
List<Role> roles = hammer.query(Role.class)
    			.where()
    			.gt("id", 5)
    			.and()
    			.le("id", 10)
    			.list()

// 模板SQL查询数据
String str = hammer.template().string("selectString", new HashMap<String, Object>());
int avg = hammer.template().numberInt("selectAvg2", new ChainMapImpl<String, Serializable>().putChain("age", 40));
User u = hammer.template().single("selectByUsername@user", User.class,
                new ChainMapImpl<String, Serializable>().putChain("username", username));
List<User> users = hammer.template().list("selectConditions@user", User.class, new ChainMapImpl<String, Serializable>()
                .putChain("minAge", minAge).putChain("maxAge", maxAge).putChain("username", username2 + "%"));
PaginationResults<User> userPaginationResults = hammer.template().pagination("selectConditions@user", User.class,
                new ChainMapImpl<String, Serializable>(), start, limit);
```

通过使用 mapper 操作的代码概览（类似 mybatis 的 mapper）：

```java
// 类似于mybatis，直接执行模板中的sql
@Mapper(namespace = "user")
public interface UserMapper {
    User selectByUsername(@Param("username") String username);

    User selectByUsernameAndPassword(@Param("username") String username, @Param("password") String pwd);

    Integer selectAvg();

    String selectString();

    @Template(namespace = "user_info")
	List<Map<String, Object>> select2();

    @Template(namespace = "user_info", name = "select2")
    List<Map<String, Object>> select2(Page page);

    @Template(namespace = "user_info", name = "select2")
    PaginationResults<Map<String, Object>> select2Page(Page page);
}
```

```java
// 除了可以使用模板sql进行查询外，可以继承Hammer、GenericHammer进行api操作,或者继承HammerSupport通过getHammer获取hammer对象进行操作，需要使用jdk8的default method
@Mapper(namespace = "user")
public interface UserMapper3 extends GenericHammer<User> {
	// 这里的query方法就是GenericHammer接口定义的方法
    default User getByUsernameAndPassword2(String username, String pwd) {
        return query().where().eq("username", username).and().eq("password", pwd).single();
    }
}

@Mapper
public interface HammerSupportMapper extends HammerSupport {
    default User get(Long id) {
        return getHammer().get(id, User.class);
    }
    User getByUsername(String username);
}

// 外部调用也可以直接使用hammer或者GenericHammer里定义的方法
public class UserService {
    UserMapper3 userMapper;
    public void regist(User user) {
        // ....
        // 其他业务代码
        if (userMapper.getByUsernameAndPassword2(user.getUsername(), user.getPassword()) == null) {
            userMapper.save(user);
        } else {
            // 用户已经存在异常处理
        }
    }
}


```

## 目录

-   [**`基础配置`**](#基础配置)
    -   [**`最基础的配置文件`**](#最基础的配置文件)
    -   [**`SqlDbHammer配置`**](#SqlDbHammer配置)
    -   [**`Mapper配置`**](#Mapper配置)
    -   [**`Spring集成`**](#Spring集成)
-   [**`对象映射基础操作`**](#对象映射基础操作)
    -   [**`数据对象映射配置`**](#数据对象映射配置)
    -   [**`主键查询对象`**](#主键查询对象)
    -   [**`保存对象`**](#保存对象)
    -   [**`更新对象`**](#更新对象)
    -   [**`删除对象`**](#删除对象)
-   [**`DSL模式操作数据`**](#DSL模式操作数据)
    -   [**`DSL模式更新数据`**](#DSL模式更新数据)
    -   [**`DSL模式删除数据`**](#DSL模式删除数据)
    -   [**`DSL模式查询数据`**](#DSL模式查询数据)
-   [**`模板SQL执行`**](#模板SQL执行)
    -   [**`模板数据操作SQL执行`**](#模板数据操作SQL执行)
    -   [**`模板SQL唯一值查询`**](#模板SQL唯一值查询)
    -   [**`模板SQL唯一记录查询`**](#模板SQL唯一记录查询)
    -   [**`模板SQL列表查询`**](#模板SQL列表查询)
    -   [**`模板SQL分页查询`**](#模板SQL分页查询)
-   [**`模板动态SQL`**](#模板动态SQL)
    -   [**`where支持`**](#where支持)
    -   [**`and和or支持`**](#and和or支持)
    -   [**`columns支持`**](#columns支持)
    -   [**`sql关键字支持`**](#sql关键字支持)
    -   [**`include支持`**](#include支持)
-   [**`Mapper详解`**](#Mapper详解)
    -   [**`Mapper中注解的含义`**](#Mapper中注解的含义)
    -   [**`Mapper方法sqlId的查找逻辑`**](#Mapper方法sqlId的查找逻辑)
    -   [**`Mapper方法与hammer模板API的对应关系`**](#Mapper方法与hammer模板API的对应关系)
    -   [**`Mapper中实现模板查询以外的操作`**](#Mapper中实现模板查询以外的操作)

> 本文档中所有的代码都是从单元测试中复制粘贴出来的，如果你有什么不清楚，可以直接下载代码并打开单元测试的代码查看具体的使用方法

## 基础配置

### 最基础的配置文件

**java 中初始化配置**


hammer-sqldb 不需要任何配置文件就能直接运行，所有配置都有默认值，所以下面这里加入文件不是必须的，不过鉴于开发要频繁修改 sql 模板文件，所以开启 devMode 更省事，devMode 下会热加载 sql 模板文件的内容   

### SqlDbHammer 配置

```java
DataSource dataSource = new BasicDataSource();
dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/hammer_jdbc");
dataSource.setDriverClassName("com.mysql.jdbc.Driver");
dataSource.setUsername("root");
dataSource.setPassword("123456");

Dialect dialect = Dialects.MYSQL;
// 这里的dataSource使用你自己的数据源实现
Jdbc jdbc = new JdbcImpl(dataSource, dialect, sqlTypeMappingManager);
DatabaseMetadata metadata = DatabaseMetadataManager.getDefaultManager().create(dataSource);

SqlTypeMappingManager sqlTypeMappingManager = new SqlTypeMappingManager();

//Jdbc jdbc = new SpringJdbcTemplateImpl(dataSource, Dialects.ORACLE);
//DatabaseMetadata metadata = DatabaseMetadataManager.getDefaultManager().create(dataSource, "hammer_jdbc");
// 如果数据库驱动不支持从connnection获取数据库名称，需要在create时传入数据库名称
JdbcMappingFactory mappingFactory = new JdbcMappingFactoryImpl(metadata, dialect, sqlTypeMappingManager);

Set<String> basePackages = new HashSet<>();
basePackages.add("cn.featherfly.hammer.sqldb.tpl.mapper");
boolean devMode = true;
// 这里的tpl/表示开始查找sql模板文件的根目录
// 这里的basePackages表示扫描Mapper文件的根目录集合,用于把@Template("sql")内置sql模板加入模板管理
// FreemarkerTemplatePreProcessor表示模板预处理，即把为sql处理特化的模板转换为freemarker模板
TplConfigFactory configFactory = new TplConfigFactoryImpl("tpl/", basePackages, new FreemarkerTemplatePreProcessor(), devMode);
hammer hammer = new hammerJdbcImpl(jdbc, mappingFactory, configFactory);
// 然后使用hammer进行数据操作
```

### Mapper 配置

> 使用 Mapper 这个单词是因为 Mybatis 使用此单词，这样会让有 Mybatis 经验的读者更容易理解。

**定义 Mapper**

```java
@Mapper(namespace = "user")
public interface UserMapper {
	User selectByUsername(@Param("username") String username);
    // 根据需要定义更多方法
}
```

**使用 Mapper**

```java
TplDynamicExecutorFactory mapperFactory = TplDynamicExecutorFactory.getInstance();
Hammer hammer = new SqldbHammerImpl(jdbc, mappingFactory, configFactory);
UserMapper userMapper = mapperFactory.newInstance(UserMapper.class, hammer);
// 然后使用userMapper进行数据操作
```

### Spring 集成

#### 配置 Mapper

```java
@Configuration
public class Appconfig {
	// 动态注册Mapper，类似mybatis,在packages里指定包扫描路径
    @Bean
    public DynamicTplExecutorSpringRegistor tplDynamicExecutorSpringRegistor() {
        Set<String> packages = new HashSet<>();
        packages.add("你需要扫描的包路径");
        // 例如 packages.add("cn.featherfly");
        DynamicTplExecutorScanSpringRegistor registor = new DynamicTplExecutorScanSpringRegistor(packages, "hammer");
        // 这里的"hammer"是你注册到spring的SqldbHammerImpl的name
        return registor;
    }

    @Bean
    public SqldbHammerImpl hammer(DataSource dataSource) {
    	// dataSource自行配置
        // 配置你自己的日志框架
        DOMConfigurator.configure(ClassLoaderUtils.getResource("log4j.xml", JdbcTestBase.class));
        DatabaseMetadata metadata = DatabaseMetadataManager.getDefaultManager().create(dataSource);
        Dialect dialect = new MysqlDialect();
        Jdbc jdbc = new JdbcSpringImpl(dataSource, dialect, metadata);
        JdbcMappingFactory mappingFactory = new JdbcMappingFactory(metadata, dialect);
        // tpl/代表sql模板从classpath查找的根目录，如果调用无参构造函数，则从classpath目录开始查找，
        // FreemarkerTemplatePreProcessor是freemarker模板的预处理器，从特化模板转换为freemarker模板
        TplConfigFactory configFactory = new TplConfigFactoryImpl("tpl/",new FreemarkerTemplatePreProcessor());
        SqlDbHammerImpl hammer = new SqlDbHammerImpl(jdbc, mappingFactory, configFactory);
        return hammer;
    }
}
```

#### 使用 Mapper

```java
@Service
public class UserService {
    @Resource
    UserMapper userMapper;
}
```

## 对象映射基础操作

### 数据对象映射配置

使用 JPA 标准注解进行对象映射，不支持级联更新和懒加载级别的级联查询。  
注解`@Table`或者`@Entity`标注的类，会被视为数据映射对象。如果没有指定 name 属性，则使用类名称进行映射，名称包含多个大写开头的单词被映射为下划线连接的全小写名称，如 UserInfo 映射为 user_info。  
注解`@Id`标注的属性映射为数据库主键列。  
注解`@Column`标注的属性强制映射一个数据库列，如果不指定 name，则使用属性名进行映射。  
注解`@ManyToOne`或者`@OneToOne`标注的属性与 JPA 一致，只是没有支持级联更新和懒加载级联查询。  
注解`@Embedded`标注的属性与 JPA 中一致。  
**没有被标注的属性使用隐式映射，使用数据库列反向映射到实体对象，如果是下划线连接的单词，会被转换为驼峰形式，如列名 parent_id 映射为属性名 parentId**

_后续文档使用的对象定义_

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

`hammer.get(entity)`  
`hammer.get(Serializable id, Class<E> type)`

#### 单一主键查询

```java
Role role = hammer.get(id, Role.class);
UserInfo ui = hammer.get(id, UserInfo.class);
```

#### 复合主键查询

```java
UserRole userRole = new UserRole();
Integer roleId = 2;
Integer userId = 2;
userRole.setRoleId(roleId);
userRole.setUserId(userId);
UserRole ur = hammer.get(userRole);

UserRole2 userRole = new UserRole2();
Integer roleId = 2;
Integer userId = 2;
userRole.setRole(new Role(roleId));
userRole.setUser(new User(userId));
UserRole2 ur = hammer.get(userRole);
```

### 保存对象

`hammer.save(entity)`  
`hammer.save(entity...array)`  
`hammer.save(List<Entity>)`

#### 单一主键保存

单一主键支持数据库自增长，保存是可以不设置主键，默认配置保存后会把数据库生成的主键设置会主键对应的属性

```java
Role role = new Role();
// 设置role属性
int result = hammer.save(role);
// 返回保存数据影响的行数

UserInfo ui = new UserInfo();
ui.setUser(new User(1));
ui.setDescp("descp_" + RandomUtils.getRandomInt(100));
ui.setName("name_" + RandomUtils.getRandomInt(100));
ui.setDivision(new DistrictDivision("四川", "成都", "高新"));
hammer.save(ui);
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
hammer.save(userRole);

UserRole2 userRole2 = new UserRole2();
Integer roleId = 2;
Integer userId = 2;
userRole2.setRole(new Role(roleId));
userRole2.setUser(new User(userId));
// 设置userRole2属性
hammer.save(userRole);
```

### 更新对象

`hammer.update(entity, IgnorePolicy)` 使用指定策略更新对象  
`hammer.update(List<Entity>, IgnorePolicy)` 使用指定策略更新对象列表  
**下面三个等于 update(entity, IgnorePolicy.NONE), 如果传入对象有 null 或者空字符串，会被更新到数据库**  
`hammer.update(entity)`  
`hammer.update(entity...array)`  
`hammer.update(List<Entity>)`  
**下面三个等于 update(entity, IgnorePolicy.EMPTY), 忽略传入对象的 null 或者空字符串，不会更新 null 和空字符串到数据库**  
`hammer.merge(entity)`  
`hammer.merge(entity...array)`  
`hammer.merge(List<Entity>)`

#### 单一主键更新

```java
Role r = new Role();
r.setId(1);
r.setName("name");
r.setDescp("descp");
hammer.update(r);

UserInfo ui = new UserInfo();
ui.setId(1);
ui.setUser(new User(1));
ui.setDescp("descp_" + RandomUtils.getRandomInt(100));
ui.setName("name_" + RandomUtils.getRandomInt(100));
ui.setDivision(new DistrictDivision("四川", "成都", "高新"));
hammer.update(ui);

Role r2 = new Role();
r2.setId(r.getId());
r2.setName("merge_name" + RandomUtils.getRandomInt(100));
hammer.merge(r2);

UserInfo ui2 = new UserInfo();
ui2.setId(2);
ui2.setDescp("descp_" + RandomUtils.getRandomInt(100));
hammer.merge(ui2);
```

#### 复合主键更新

```java
UserRole userRole = new UserRole();
userRole.setRoleId(3);
userRole.setUserId(3);
userRole.setDescp("descp_update_1");
userRole.setDescp2("descp2_update_1");
hammer.update(userRole);

UserRole2 userRole2 = new UserRole2();
userRole2.setRole(new Role(3));
userRole2.setUser(new User(3));
userRole2.setDescp("descp_update_2");
userRole2.setDescp2("descp2_update_2");
hammer.update(userRole2);

UserRole ur = new UserRole();
ur.setRoleId(4);
ur.setUserId(4);
ur.setDescp("descp_update_" + RandomUtils.getRandomInt(99));
hammer.merge(ur);
```

### 删除对象

`hammer.delete(entity)`  
`hammer.delete(entity...array)`  
`hammer.delete(List<Entity>)`

#### 单一主键删除

```java
Role r = new Role();
r.setId(1);
int result = hammer.delete(r);
// 返回删除数据影响的行数
// hammer.delete(entity array), hammer.delete(entity list)
```

#### 复合主键删除

```java
UserRole userRole = new UserRole();
userRole.setRoleId(111);
userRole.setUserId(111);
hammer.delete(userRole);

UserRole2 userRole2 = new UserRole2();
userRole2.setRole(new Role(111));
userRole2.setUser(new User(111));
hammer.delete(userRole2);

```

## DSL 模式操作数据

### DSL 模式更新数据

_条件查询方法_  
`where` 开启 where 条件表达式  
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

#### 数据更新

```java
hammer.update(Role.class).set("name", newName).property("descp").set(newDescp).where().eq("id", id).execute();
hammer.update(Role.class).set(Role::getName, newName).property(Role::getDescp).set(newDescp).where().eq(Role::getId, id).execute();
```

#### 数据自增长更新

```java
hammer.update(User.class).increase("age", 1).where().eq("id", id).execute();
hammer.update(User.class).increase(User::getAge, 1).where().eq(User::getId, id).execute();

hammer.update(User.class).propertyNumber("age").increase(1).where().eq("id", id).execute();
hammer.update(User.class).propertyNumber(User::getAge).increase(1).where().eq(User::getId, id).execute();
```

### DSL 模式删除数据

```java
hammer.delete(Role.class).where().eq("id", id).execute();
hammer.delete(Role.class).where().eq(Role::getId, id).execute();

hammer.delete(Role.class).where().in("id", new Integer[] { id1, id2 }).or().eq("id", id3)
            .or().ge("id", id4).execute();
hammer.delete(Role.class).where().in(Role::getId, new Integer[] { id1, id2 }).or().eq(Role::getId, id3)
            .or().ge(Role::getId, id4).execute();
```

### DSL 模式查询数据

`hammer.query(Class)` 返回映射传入对象的条件表达式  
`hammer.query(String)` 返回条件表达式，在最后执行查询操作时进行数据映射

#### 查询单一对象

`single` 查询唯一值

```java
Role r = hammer.query(Role.class).where().eq("id", id).single();
```

#### 查询列表

`list` 查询列表

```java
List<Role> roles = hammer.query(Role.class).where().gt("id", 5).and().le("id", 10).list();
```

#### 查询分页列表

`limit` 设置分页参数

```java
List<Role> roles = hammer.query(Role.class).where().gt("id", 5).and().le("id", 10).limit(2).list();
roles = hammer.query(Role.class).where().gt("id", 5).and().le("id", 10).limit(2, 3).list();
```

#### 查询排序列表

`sort` 调用后进入排序表达式  
`asc` 对传入属性进行升序  
`desc` 对传入属性进行降序

```java
List<Role> roles = hammer.query(Role.class).where().eq("id", 4).or().group().gt("id", 5).and().le("id", 10).sort().asc("id").desc("name").list();
```

## 模板 SQL 执行

模板配置文件使用 yaml 格式，属性名就是对应的 sql 模板 id,属性值就是需要使用的 sql 模板。
内置实现使用的模板引擎是 freemarker。

```yaml
select: "select <@prop/> from user_info"
select2: "select id,user_id as `user.id`, name, descp
, province `division.province`, city `division.city`, district `division.district`
 from user_info"
```

API 调用传入的模板ID字符串格式为 name@namespace（邮件格式xx@yy）
例：`hammer.template().single("selectByUsername@user", User.class, new ChainMapImpl<String, Serializable>().putChain("username", username))`  
如果SQL模板名称为全局唯一，也可以直接使用 name  
例：`hammer.template().numberInt("selectAvg", new ChainMapImpl<String, Serializable>())`

> 如果不同namespace的的模板拥有相同的名称（name），调用时只使用name就会抛出异常，因为程序不知道调用的是哪一个，所以最好是使用模板ID

使用模板ID对象进行查找

例：`hammer.template(b->b.name("selectByUsername").namespace("user"), new ChainMapImpl<String, Serializable>()).numberInt()`

后续文档使用的 sql 模板定义

[_`user.yaml.tpl`_](./src/test/resources/tpl/user.yaml.tpl)  [_`user.yaml.sql`_](./src/test/resources/tpl_pre/user.yaml.sql)

[_`role.yaml.tpl`_](./src/test/resources/tpl/role.yaml.tpl) [_`role.yaml.sql`_](./src/test/resources/tpl_pre/role.yaml.sql)

[_`role_common.yaml.tpl`_](./src/test/resources/tpl/user.yaml.tpl)

### 模板数据操作 SQL 执行

| 方法      | 说明                                               |
| :-------- | :------------------------------------------------- |
| `execute` | 执行数据操作（即执行 insert,update,delete 等操作） |

```java
int i = executor.template().execute("insertRole", new ChainMapImpl<String, Serializable>().putChain("name", name).putChain("descp", descp));

int i = executor.template().execute("updateRoleByName", new ChainMapImpl<String, Serializable>().putChain("name", name).putChain("descp", descp));

int i = executor.template().execute("deleteRoleByName", new ChainMapImpl<String, Serializable>().putChain("name", name));
```

### 模板 SQL 唯一值查询

| 方法               | 说明                 |
| :----------------- | :------------------- |
| `value`            | 查询返回唯一值       |
| `intValue`         | 查询返回 int         |
| `longValue`        | 查询返回 long        |
| `doubleValue`      | 查询返回 double      |
| `number`           | 查询返回 number 对象 |
| `numberInt`        | 查询返回 Integer     |
| `numberLong`       | 查询返回 Long        |
| `numberDouble`     | 查询返回 Double      |
| `numberBigDecimal` | 查询返回 BigDecimal  |
| `string`           | 查询返回 String      |

```java
Integer avg = hammer.template().numberInt("selectAvg", new ChainMapImpl<String, Serializable>());
Integer avg = hammer.template().numberInt("selectAvg2", new ChainMapImpl<String, Serializable>().putChain("age", 40));

String str = hammer.template().string("selectString", new ChainMapImpl<String, Serializable>());
String str = hammer.template().string("selectString2", new ChainMapImpl<String, Serializable>().putChain("id", 2));
```

### 模板 SQL 唯一记录查询

| 方法     | 说明                                                         |
| :------- | :----------------------------------------------------------- |
| `single` | 查询返回唯一对象，可返回空，返回条数大于一时抛出异常（null or one） |
| `unique` | 查询返回唯一对象，返回空或返回条数大于一都会抛出异常（only one） |



```java
User u1 = hammer.template().single("selectByUsername@user", User.class, new ChainMapImpl<String, Serializable>().putChain("username", username));
User u2 = hammer.template().single("selectByUsernameAndPassword@user", User.class, new ChainMapImpl<String, Serializable>().putChain("username", username).putChain("password", password));

User u1 = hammer.template().unique("selectByUsername@user", User.class, new ChainMapImpl<String, Serializable>().putChain("username", username));
User u2 = hammer.template().unique("selectByUsernameAndPassword@user", User.class, new ChainMapImpl<String, Serializable>().putChain("username", username).putChain("password", password));
```

### 模板 SQL 列表查询

| 方法   | 说明         |
| :----- | :----------- |
| `list` | 查询返回列表 |

```java
List<User> users = executor.template().list("selectUser@user", User.class, new ChainMapImpl<String, Serializable>());
List<User> users = executor.template().list("selectByAge@user", User.class, new ChainMapImpl<String, Serializable>().putChain("age", 5));
List<User> users = executor.template().list("selectConditions@user", User.class, new ChainMapImpl<String, Serializable>());
List<User> users = executor.template().list("selectConditions@user", User.class, new ChainMapImpl<String, Serializable>().putChain("minAge", minAge).putChain("maxAge", maxAge).putChain("username", username1 + "%"));
List<User> users = executor.template().list("selectConditions@user", User.class, new ChainMapImpl<String, Serializable>().putChain("minAge", minAge).putChain("maxAge", maxAge).putChain("username", username2 + "%"));
```

### 模板 SQL 分页查询

#### 基础分页

| 方法   | 说明             |
| :----- | :--------------- |
| `list` | 查询返回分页列表 |

```java
List<User> users = executor.template().list("selectConditions@user", User.class, new ChainMapImpl<String, Serializable>(), start, limit);
List<User> users = executor.template().list("selectConditions@user", User.class, new ChainMapImpl<String, Serializable>().putChain("minAge", minAge).putChain("maxAge", maxAge).putChain("username", username1 + "%"),new SimplePagination(start, limit));
```

#### 包装分页

| 方法         | 说明                                   |
| :----------- | :------------------------------------- |
| `pagination` | 查询返回分页列表包装对象，包含总数统计 |

##### 使用自动构建统计 sql

基于查询 sql 自动转换统计 sql

```java
PaginationResults<User> userPaginationResults = executor.template().pagination("selectConditions@user", User.class, new ChainMapImpl<String, Serializable>(), start, limit);
PaginationResults<User> userPaginationResults = executor.template().pagination("selectConditions@user", User.class, new ChainMapImpl<String, Serializable>().putChain("minAge", minAge).putChain("maxAge", maxAge).putChain("username", username1 + "%"), new SimplePagination(start, limit));
```

> 注意：sql 转换功能做的测试不可能覆盖所有的复查查询，当你的查询足够复杂并且自动转换不能正常工作时，请使用手动声明统计 sql

##### 手动声明统计 sql

yaml 配置文件中的 sql 模板,默认情况下只需要直接把 sql 模板跟在 SQL模板名称 后面就行了,当需要手动设置统计 sql 时，就需要明确声明

```yaml
sqlName:
    query: select sql
    count: count sql
```

查询 sql 对应的统计 sql 这两条 sql 的查询条件都是一样的，所以如果把条件写在两个模板中，每次改动都要改动两个地方，容易造成错误，可以直接使用模板引擎的 include 机制或者 hammer 自定义的 include 机制来引入查询条件部分

具体内容可以进入此章节[**`include支持`**](#include支持)

```java
PaginationResults<Role> uis = executor.pagination("selectWithTemplate@role", Role.class, new ChainMapImpl<String, Serializable>(), 0, 10);
PaginationResults<Role> uis = executor.pagination("selectWithTemplate2@role", Role.class, new ChainMapImpl<String, Serializable>(), 0, 10);
PaginationResults<Role> uis = executor.pagination("selectWithTemplate3@role", Role.class, new ChainMapImpl<String, Serializable>(), 0, 10);
```

## 模板动态 SQL

因为使用的模板引擎，所有在 sql 拼接中，对应的模板引擎支持的功能基本都能使用，不过由于我们只是用来动态拼接 SQL,所以为其定制化了一些专用于此的标签和函数。默认使用 freemarker，定制的功能也是 freemarker 的扩展。

### 特化的SQL模板预编译支持

为了让sql看起来更清晰，并更容易在sql客户端（heidiSQL,navicate等）和JAVA项目之间来回倒腾SQL，自定义了一套模板规则进行预编译，在加载期编译为内置模板引擎的模板样式（默认使用freemarker）

下面这句sql除了能在hammer中运行，同时也可以在sql客户端中正常执行（比较复杂的sql会在sql客户端进行编写调试，这样效率更高，一般分析统计sql会比较复杂）`下面的语句只为演示功能，与sql复杂度无关`

```sql
select id, username, password pwd, mobile_no, age from /*<<wrap*/user
/*<where*/ where
    /*??*/ username like /*$=:username*/'yufei'
    /*??*/ and password like /*$=:password*/'123456'
    /*??*/ and mobile_no like /*$=:mobileNo*/'12345678901'
    /*?*/ and age >= /*$=:minAge*/5
    /*??*/ and age <= /*$=:maxAge*/40
/*>where*/
```

如果你只是一个不太需要在sql客户端进行调试的sql，还可以简化为（其中符号的作用会再下面对应的章节描述）

```sql
select id, username, password pwd, mobile_no, age from /*<<wrap*/user
/*<where*/ where
    /*??*/ username like :username
    /*??*/ and password like :password
    /*??*/ and mobile_no like :mobileNo
    /*?*/ and age >= :minAge
    /*?*/ and age <= :maxAge
/*>where*/

-- 或者

select id, username, password pwd, mobile_no, age from /*<<wrap*/user
/*<where*/ where
    /*username??*/ username like ?
    /*password??*/ and password like ?
    /*mobile_no??*/ and mobile_no like ?
    /*age?*/ and age >= ?
    /*age?*/ and age <= ?
/*>where*/
```

### 特化SQL的标签定义规则

1. `/*  */` 使用作为标签的开始和结束符号，因为这在sql中是注释，所以可以直接在sql客户端里运行不出现问题

2. `/*<  */` 表示需要结束标签`/*  >*/`成对使用，类似html的标签: `<p> </p>`

3. `/*<  >*/` 表示自关闭标签，类似html的标签:  `<br/>`

4. `/*<<  */` 表示会把标签后面的字符包装进期标签内(规则为从标签后开始，直到遇到空格或者换行)，

   例如：`/*<<wrap*/user from`则会转换为`<@wrap>user</@wrap> from`

5. `/*$= */'yufei'` 表示使用$=后的内容替换标签后的字符(规则为从标签后开始，直到遇到空格或者换行)，

   例如：`/*$=:password*/'123456' `则会转换为`:password`

6. `/*[word][?|??]*/ [and | or]`  表示`<@and if=word[?|??]> ... </@and>`

   例如: `/*?*/ and age >= :minAge`则会转换为 `<@and if=age?> age >= ? </@and>`

    `/*??*/ username like :username`则会转换为 `<@and if=username??> username = ? </@and>`

7. 内置的freemarker标签，直接替换其开始和结束标签就能直接使用

   例如：`/*<tpl name='roleFromTemplate2' namespace='role_common'>*/`则转换为 `<@tpl name='roleFromTemplate2' namespace='role_common'/>

### where 支持

> freemarker模板

当<@where>   \</@where>中的内容不是空字符串时，会自动加入 where 关键字,相反则输出空字符串

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

#### where的SQL特化模板

特化模板中为 `/*<where*/ ... /*>where*/`

```sql
select id, username, password pwd, mobile_no, age from /*<<wrap*/user
/*<where*/ where
    /*??*/ username like :username
    /*??*/ and password like :password
    /*??*/ and mobile_no like :mobileNo
    /*?*/ and age >= :minAge
    /*?*/ and age <= :maxAge
/*>where*/
```

### and 和 or 支持

> freemarker 支持

`and`和`or`标签的属性是一致的，只是代表含义不同，如果其内容是查询条件，则当 if 为 true 时，则会自动追加 and(or)。如果内容是一个分组时（小括号包裹的条件表达式），逻辑等同于 where（不需要设置属性），只是自动加入的关键字是 and(or)。**此标签会自动判断是否需要加入 and(or)关键字，不需要人工判断，当成加强版的 if 标签用就行了**  
`if` 传入布尔值，表示是否需要标签内的内容，当内容是一个分组时，不需要指定  
`name` 字符串，表示当前标签内查询条件的参数名称，此属性大部分时候可以省略，只有无法从内容中获取确切的参数名时，才需要指定

_基于命名占位符_

```sql
select * from user<@where>
    <@and if= age?>
        age = :age
    </@and>
    <@and if= minAge? && maxAge?>
		age between :minAge and :maxAge
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

_基于问号占位符_

```sql
select * from user<@where>
    <@and if = age?>
        age = ?
    </@and>
    <@and if= minAge? && maxAge? name="minAge,maxAge">
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

#### and和or的SQL特化模板

特化模板中为 /\*?\*/  条件语句 换行

1. `/*?*/` 表示!=null
2. `/*??*/` 表示!=null并且长度为0（字符串，数组，集合）
3. `/*<?*/ [and|or] ... /*>?*/` 代表`<@and> ... </@and>` 或者 `<@or> ... </@or>`

```sql
select * from user
/*<where*/ where
	/*?*/ age = :age
	/*<?*/ and
    (
        /*??*/ name = :name
        /*?*/ and age = :age
        /*<?*/ or
        (
        	/*?*/ age > :minAge
			/*?*/ and age < :maxAge
        )
		/*>?*/
    )
	/*>?*/
	/*?*/ and age = :age
	/*<?*/ or 
	(
        /*??*/ name = :name
        /*?*/ and age = :age
    )
	/*>?*/
    /*?*/ and sex = :sex
    /*?*/ and mobile = :mobile
	/*?*/ or name = :name
	/*?*/ or age = :age
	/*?*/ or sex = :sex
	/*?*/ or mobile = :mobile
/*>where*/

-- 或者

select * from user
/*<where*/ where
	/*age?*/ age = ?
	/*<?*/ and
    (
        /*name??*/ name = ?
        /*age?*/ and age = ?
        /*<?*/ or
        (
        	/*minAge?*/ age > ?
			/*maxAge?*/ and age < ?
        )
		/*>?*/
    )
	/*>?*/
	/*age?*/ and age = ?
	/*<?*/ or 
	(
        /*name??*/ name = ?
        /*age?*/ and age = ?
    )
	/*>?*/
    /*sex?*/ and sex = ?
    /*mobile?*/ and mobile = ?
	/*name?*/ or name = ?
	/*age?*/ or age = ?
	/*sex?*/ or sex = ?
	/*mobile?*/ or mobile = ?
/*>where*/
```

### columns 支持

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
selectByAge: 'select <@prop/> from user where age = :age'
selectById: "select <@prop repo='user_info'/> from user_info where id = :id"
selectWithTemplate3:
    query: >
        select <@prop alias="_r"/> <@tpl id='roleFromTemplate2' namespace='tpl/role_common'/>
    count: "select count(*) <@sql id='roleFromTemplate2' namespace='tpl/role_common'/>"
```

**如果调用返回的映射对象是使用@Entity 或者@Table 标注的实体对象，则只需要`<@prop/>`或者`<@columns/>`就行了，标签实现会根据对象映射信息生成正确的内容  
如果调用返回的映射对象不是使用@Entity 或者@Table 标注的实体对象，则需要加入属性`<@columns table='user'/>或者<@prop repo='user_info'/>`**

#### columns SQL特化模板

```sql
selectByUsername: >
    select /*<<columns table='user'*/* from /*<<wrap*/user where username = :username
selectUser: select username, password pwd from /*<<wrap*/user
selectByAge: >
    select /*<<prop*/* from /*<<wrap*/user where age = :age
selectWithTemplate3:
  query: |
    select /*prop alias="_r"*/* /*<tpl id='roleFromTemplate2' namespace='role_common'>*/
  count: |
    select count(*) /*<sql id='roleFromTemplate2' namespace='role_common'>*/
selectConditions: |
    select id, username, password pwd, mobile_no, age from /*<<wrap*/user
    /*<where*/ where
    /*??*/ username like :username
    /*??*/ and password like :password
    /*??*/ and mobile_no like :mobileNo
    /*?*/ and age >= :minAge
    /*?*/ and age <= :maxAge
    /*>where*/
```

**需要注意的是，某些需要换行格式的标签（/*<where*/ where 或者 /*??*/ 等），在写模板时，在yaml的key后面要跟 |，表示key对应的value不需要去掉换行符 **



### sql 关键字支持

如果你的某一个列名或者表名是数据库的关键字，在写 SQL 时就要使用数据库特定的符号把其括起来  
mysql 使用 \`\`，例：\`user\`  
postgresql 使用 "", 例: "user"  
所以提供了一个专门用来包装 SQL 关键字的标签和函数，其输出的格式通过指定的 Dialect 决定

_标签实现_

```yaml
selectByUsernameAndPassword: >
    select username, password pwd from <@wrap value="user"/> where username = :username and password = :password
```

_函数实现_

```yaml
selectByUsernameAndPassword: >
    select username, password pwd from ${tpl_wrap("user")} where username = :username and password = :password
```

#### SQL关键字的SQL特化模板

_标签实现_

```sql
selectByUsernameAndPassword: >
    select username, password pwd from /*<<wrap*/user where username = :username and password = :password
```

### include 支持

前面已经说了，使用模板引擎，所以模板引擎有的功能都能使用，include 也是一样。  
**不建议使用模板自带 include 机制，因为模板的实际位置和扫描模板的前置路径相关（可以设置多个前置路径进行扫描，如：rbac/, order/），实际情况会比较复杂，而自定义的 include 已经帮你处理了实现了namespace和路径的关联**

#### 自定义 include 实现

同一个实现默认注册了两个标签名，推荐使用<@tpl>，因为这是标准名称，<@sql>只是为了在这里更应景而已。

`<@tpl name='roleFromTemplate2'/>`和`<@sql name='roleFromTemplate2'/>`是同一个实现不同的别名  
`name` 表示模板SQL名称（[**`template name`**](#`@Template`  )）  
`namespace` 表示模板SQL所在的名称空间（[**`template namespace`**](#`@Template` )）  ，对应定义在 yaml 模板文件中的模板 sql 而言, 如果是同一个文件中，可以省略此配置

```yaml
selectWithTemplate2:
  query: "select <@prop/> <@tpl id='roleFromTemplate2'/>"
  count: "select count(*) <@sql id='roleFromTemplate2'/>"
roleFromTemplate2: >
	from role <@where>
	<@and if = name??>
	    name like :name
	</@and>
	</@where>
selectWithTemplate3:
  query: >
    select <@prop alias="_r"/> <@tpl id='roleFromTemplate2' namespace='tpl/role_common'/>
  count: "select count(*) <@sql id='roleFromTemplate2' namespace='tpl/role_common'/>"
```

##### freemarker 的 include 机制

`<#include '/tpl/role@roleFromTemplate'>` /tpl/role 代表 yaml 模板文件，roleFromTemplate 代表文件中的 sqlId

```yaml
selectWithTemplate:
  query: "select <@prop/> <#include '/tpl/role@roleFromTemplate'>"
  count: "select count(*) <#include '/tpl/role@roleFromTemplate'>"
roleFromTemplate: >
	from role <@where>
	<@and if = name??>
    	name like :name
	</@and>
	</@where>
```

#### includ的SQL特化模板

```sql
selectWithTemplate:
  query: |
    select /*prop alias="_r"*/* /*<tpl id='roleFromTemplate2' namespace='role_common'>*/
  count: |
    select count(*) /*<sql id='roleFromTemplate2' namespace='role_common'>*/
```

## Mapper 详解

### Mapper 的定义方式

Mapper 就是定义指定操作方法的接口类，hammer 有三种 Mapper 的定义方式

1. 定义一个接口，使用@Mapper 标注，外部使用此 mapper 时，只提供此接口定义的方法

```java
@Mapper(namespace = "user")
public interface UserMapper {
	// methods
}
```

2. 定义一个接口，使用@Mapper 标注，继承 hammer 接口，外部使用此 mapper 时，除了提供此接口定义的方法，还能使用 Hammer 内定义的方法，方法内部也可以使用 default method 调用 Hammer 接口内的方法实现一些基础功能

```java
@Mapper(namespace = "user")
public interface UserMapper2 extends Hammer {
	// methods
}
```

3. 定义一个接口，使用@Mapper 标注，继承 GenericHammer 接口，外部使用此 mapper 时，除了提供此接口定义的方法，还能使用 GenericHammer 内定义的方法，方法内部也可以使用 default method 调用 hammer 接口内的方法实现一些基础功能

```java
@Mapper(namespace = "user")
public interface UserMapper3 extends GenericHammer<User> {
	// methods
}
```

**如果需要定义一个实体对象的 Mapper，建议使用继承 GenericHammer 接口的方式，这样此 mapper 就能把对应实体的基础操作都提供了**

如果觉得`Hammer`，`GenericHammer`定义的方法太多，污染了接口，可以选择第四种方式，就是继承`HammerSupport`或者`GenericHammerSupport`

这两个接口都只有两个方法，即`getHammer()`和`getHammerConfig()`，这样既能在自己的接口中使用hammer进行各种操作，又不会污染接口

```java
@Mapper(namespace = "user")
public interface UserMapper4 extends HammerSupport {
	// methods
    default User getByEmailAndPass(String email, String pass) {
        return getHammer().query(User.class).where()
            .eq(User::getEmail, email)
            .and().eq(User::getPass, pass)
            .single();
    }
}

@Mapper(namespace = "user")
public interface UserMapper5 extends GenericHammerSupport<User, Long> {
	// methods    
	default User getByEmailAndPass(String email, String pass) {
        return getHammer().query().where()
            .eq(User::getEmail, email)
            .and().eq(User::getPass, pass)
            .single();
    }
}
```





### Mapper 中注解的含义

#### `@Mapper` 

Mapper只能标注在类上

-   `namespace` 模板文件的路径，如果为空，则使用类型的名称 class.getSimpleName()

#### `@Template` 

既能标注在类上，也能标注在方法上

当标注在类上时，是把类当做SQL模板的聚合存在，类似（SQL模板存储文件）

- `namespace` SQL模板文件的名称空间

  1. SQL模板定义配在置文件中，则为文件去掉前缀（prefix）和后缀（suffix）后的路径
  2. 如果是定义在类（class）中，未设置namespace则使用 Mapper的简要名称（class.getSimpleName()）作为名称空间

- `name` SQL模板名称，如果为空，则使用方法名作为模板名称

- `value` SQL模板，如果不为空，则直接使用此模板执行，用法和在模板文件中定义的完全一样，模板管理器会使用 namespace 和 name 注册

  > 注意：需要给TplConfigFactory 设置合适的 basePackges 进行类扫描注册

-   `type` sql template type，默认值 AUTO，枚举 AUTO,QUERY,EXECUTE
    
-   `precompile`  模板预编译，可以在某个SQL模板强制关闭预编译，主要作用是在预编译在某些情况如果出现了BUG，可以关闭预编译直接退回模板引擎的写法
    
    > 在@Template 中定义 template 直接写 sql 模板其实是为了 jdk13，jdk14 中出现的文本块（目前还是预览版，不是正式版），目前把复杂 sql 模板放在@Template 中一点都不方便，也就适合放简单 sql, 但是简单 sql 我个人更倾向于直接使用 query dsl
    
    > 在类中定义模板的实例：
    
    ```java
    @Mapper(namespace = "role2")
    @Template(name = "selectIdList", value = "select id from role order by id")
    @Template(name = "selectList", value = "select <@prop repo='role'/> from role")
    @Template(name = "roleFromTemplate", value = "FROM role _r <@where><@and if = name??> name like :name </@and></@where>")
    @Template(name = "selectWithTemplate", value = "select <@prop alias=\"_r\"/> <@tpl name='roleFromTemplate'/>")
    @Template(name = "selectWithTemplate2",
            value = "select <@prop alias='_r'/> <@tpl name='roleFromTemplate' namespace='role2'/>")
    @Template(name = "selectWithTemplate3", value = "select /*<<prop alias=\"_r\"*/* /*<tpl name='roleFromTemplate' >*/")
    @Template(name = "selectWithTemplate4",
            value = "select /*<<prop alias='_r'*/* /*<tpl name='roleFromTemplate' namespace='role2' >*/")
    @Template(name = "selectWithTemplate5", value = "select /*prop alias=\"_r\"*/* /*<tpl name='roleFromTemplate' >*/")
    public interface RoleMapperDefineTemplates extends GenericHammer<Role, Integer> {
    
        @Template(name = "selectIdList")
        List<Long> idList();
    
        @Template(name = "selectList")
        List<Role> list();
    
        @Template(name = "selectWithTemplate")
        List<Role> selectWithTemplate(@Param("name") String name);
    
        @Template // name="selectWithTemplate2"
        List<Role> selectWithTemplate2(@Param("name") String name);
    
        @Template("select <@prop alias=\"_r\"/> <@tpl name='roleFromTemplate' />")
        List<Role> selectWithTemplate6(@Param("name") String name);
    
        @Template("select <@prop alias='_r'/> <@tpl name='roleFromTemplate' namespace='role2' />")
        List<Role> selectWithTemplate7(@Param("name") String name);
    
        @Template("select /*<<prop alias=\"_r\"*/* /*<tpl name='roleFromTemplate' >*/")
        List<Role> selectWithTemplate8(@Param("name") String name);
    }
    ```
    
    

#### `@Param` 标注在方法参数中，用于映射方法参数和查询参数

- `value` 查询参数名称，查询参数的名称，需要与模板SQL中的参数名称对应上

  > 注意： 如果是 java8 以上，并且**java 编译代码的时候开启了-parameters 选项**，不使用此注解依然能把参数名称映射正对

-   `type` 查询参数类型，枚举类型

### Mapper 方法 SQL模板的查找逻辑

标注在类（接口）上的`@Mapper`的`namespace`的值将作为内部所有方法的缺省默认值，
方法没有标注`@Template`时，使用方法名作为`@Template`的`name`值，如果某一些方法需要使用不同于类标注的`namespace`的值，可以在方法上标注`@Template`，并指定`namespace`的值

_参考示例代码_

```java
@Mapper(namespace = "user")
public interface UserMapper {

    User selectByUsername(@Param("username") String username);

    Map<String, Object> selectByUsername2(@Param("username") String username);

    User selectByUsernameAndPassword(@Param("username") String username, @Param("password") String pwd);

    Integer selectAvg();

    String selectString();

    List<User> selectByAge2(@Param("age") Integer age);

    @Template
    List<User> selectByAge2(@Param("age") Integer age, @Param(type = ParamType.PAGE_OFFSET) int offset,
            @Param(type = ParamType.PAGE_LIMIT) int limit);

    @Template
    List<User> selectByAge2(@Param("age") Integer age, Page page);

    @Template(name = "selectByAge2")
    PaginationResults<User> selectByAge2Page(@Param("age") Integer age,
            @Param(type = ParamType.PAGE_OFFSET) int offset, @Param(type = ParamType.PAGE_LIMIT) int limit);

    @Template(name = "selectByAge2")
    PaginationResults<User> selectByAge2Page(@Param("age") Integer age, Page page);

    List<User> selectById(@Param("id") Integer id);

    Integer selectAvg2(@Param("age") Integer age);

    String selectString2(@Param("id") Integer id);

    @Template(namespace = "user_info")
    List<Map<String, Object>> select2();

    @Template(namespace = "user_info", name = "select2")
    List<Map<String, Object>> select2(@Param(type = ParamType.PAGE_OFFSET) int offset,
            @Param(type = ParamType.PAGE_LIMIT) int limit);

    @Template(namespace = "user_info", name = "select2")
    List<Map<String, Object>> select2(Page page);

    @Template(namespace = "user_info", name = "select2")
    PaginationResults<Map<String, Object>> select2Page(@Param(type = ParamType.PAGE_OFFSET) int offset,
            @Param(type = ParamType.PAGE_LIMIT) int limit);

    @Template(namespace = "user_info", name = "select2")
    PaginationResults<Map<String, Object>> select2Page(Page page);

    @Template(namespace = "user_info", name = "selectById")
    List<Map<String, Object>> selectById2(@Param("id") Integer id);
}

@Mapper(namespace = "role")
public interface RoleMapper {

    @Template("select <@prop repo='role'/> from role")
    List<Role> list();

    @Template("select <@prop repo='role'/> from role")
    List<Role> list(Page page);

    @Template("select <@prop repo='role'/> from role")
    List<Role> list(@Param(type = ParamType.PAGE_OFFSET) int offset, @Param(type = ParamType.PAGE_LIMIT) int limit);

    @Template("select <@prop repo='role'/> from role")
    PaginationResults<Role> page(Page page);

    @Template("select <@prop repo='role'/> from role")
    PaginationResults<Role> page(@Param(type = ParamType.PAGE_OFFSET) int offset,
            @Param(type = ParamType.PAGE_LIMIT) int limit);

    @Template("select <@prop repo='role'/> from role <@where><@and if = name??>name like :name</@and></@where>")
    List<Role> selectByName2(@Param("name") String name);

    @Template("select <@prop repo='role'/> from role <@where><@and if = name??>name like ?</@and></@where>")
    List<Role> selectByName3(@Param("name") String name);

    @Template
    List<Role> selectByName(@Param("name") String name);

    @Template("select <@prop alias=\"_r\"/> <@tpl id='roleFromTemplate2' namespace='tpl/role_common'/>")
    List<Role> selectWithTemplate(@Param("name") String name);

    @Template("insert into role(name, descp) values(:name, :descp)")
    int insertRole(@Param("name") String name, @Param("descp") String descp);

    @Template("update role set descp = :descp where name = :name")
    int updateRoleByName(@Param("name") String name, @Param("descp") String descp);

    @Template("delete from role where name = :name")
    int deleteRoleByName(@Param("name") String name);

    @Template("select <@prop repo='role'/> from role where name = :name")
    Role getByName(@Param("name") String name);

    @Template(value = "select count(*) from role", type = TplType.QUERY)
    int countRole();

    @Template("select count(*) from role")
    Integer countRole2();

    @Template("select count(*) from role")
    long countRole3();
}
```

### Mapper 方法与 hammer 模板 API 的对应关系

对应原则基本都是按照方法调用的返回对象为依据，除了小部分特殊情况，下面章节为一一介绍。

#### [**`模板数据操作SQL执行`**](#模板数据操作SQL执行)章节介绍的 API 对应的 Mapper 调用

> Mapper 中 int xxx(ar1, ar2.. arn)， void yyy(ar1, ar2...arn) \
> 当返回值是 void 时，执行 execute（即执行 insert,update,delete 等操作）\
> 当返回值是 int 并且 type 参数是 AUTO 或者 EXECUTE 时，执行 execute（即执行 insert,update,delete 等操作）\
> 如果要执行一个查询返回一个 int 值，可以加上 type=QUERY 或者使用包装类型 Integer 作为返回值

```java
@Template("insert into role(name, descp) values(:name, :descp)")
int insertRole(@Param("name") String name, @Param("descp") String descp);

@Template("update role set descp = :descp where name = :name")
int updateRoleByName(@Param("name") String name, @Param("descp") String descp);

@Template("delete from role where name = :name")
int deleteRoleByName(@Param("name") String name);
```

#### [**`模板SQL唯一值查询`**](#模板SQL唯一值查询)章节介绍的 API 对应的 Mapper 调用

```java
Integer selectAvg();

String selectString();

Integer selectAvg2(@Param("age") Integer age);

String selectString2(@Param("id") Integer id);

@Template(value = "select count(*) from role", type = TplType.QUERY)
int countRole();

@Template("select count(*) from role")
Integer countRole2();

@Template("select count(*) from role")
long countRole3();
```

#### [**`模板SQL唯一记录查询`**](#模板SQL唯一记录查询)章节介绍的 API 对应的 Mapper 调用

```java
User selectByUsername(@Param("username") String username);

Map<String, Object> selectByUsername2(@Param("username") String username);

User selectByUsernameAndPassword(@Param("username") String username, @Param("password") String pwd);
```

#### [**`模板SQL列表查询`**](#模板SQL列表查询)章节介绍的 API 对应的 Mapper 调用

```java
List<User> selectByAge2(@Param("age") Integer age);

List<User> selectById(@Param("id") Integer id);

@Template(namespace = "user_info")
List<Map<String, Object>> select2();
```

#### [**`模板SQL分页查询`**](#模板SQL分页查询)章节介绍的 API 对应的 Mapper 调用

分页查询可以返回 List 和 PaginationResults，需要在查询参数之外还要传入分页参数，
可以使用 Page 对象，也可以使用 int, int 传入，当使用 int,int 传入时需要使用`@Param`标注并设置`type`的类型确定 limit 和 offset。

```java
@Template
List<User> selectByAge2(@Param("age") Integer age, Page page);

@Template(name = "selectByAge2")
PaginationResults<User> selectByAge2Page(@Param("age") Integer age,
        @Param(type = ParamType.PAGE_OFFSET) int offset, @Param(type = ParamType.PAGE_LIMIT) int limit);

@Template(name = "selectByAge2")
PaginationResults<User> selectByAge2Page(@Param("age") Integer age, Page page);
```

### Mapper 中实现模板查询以外的操作

定义接口继承自 hammer 、GenericHammer、HammerSupport，然后定义 default method，在其内部就可以使用已有的方法进行逻辑编写了。**需要 java8 的 default method**。  
通过此方式，我们可以把一种实体类型的数据库操作写在一个 Mapper 文件中，通过继承的接口已经获得了实体的基本增删改查方法，其他简单的查询（更新，删除）也可以用 DSL API 实现，只有复杂的查询，才需要在模板中写 sql。

```java
@Mapper(namespace = "user")
public interface UserMapper3 extends GenericHammer<User> {

    User selectByUsername(@Param("username") String username);
    // methods ....

	default User getByUsernameAndPassword(String username, String pwd) {
        return query().where().eq("username", username).and().eq("pwd", pwd).single();
    }

    default User getByUsernameAndPassword2(String username, String pwd) {
        return query().where().eq("username", username).and().eq("password", pwd).single();
    }

    default User getByUsernameAndPassword3(String username, String pwd) {
        return query().where().property("username").eq(username).and().property("pwd").eq(pwd).single();
    }

     default int updatePasswordByUsername(String username, String pwd) {
        //return update().set("password", pwd).where().eq("username", username).execute();
        return update().set(User::getPwd, pwd).where().eq(User::getUsername, username).execute();
    }

    default int deleteByUsername(String username) {
        //return delete().where().eq("username", username);
        return delete().where().eq(User::getUsername, username).execute();
    }
}

@Mapper
public interface HammerSupportMapper extends HammerSupport {
    default User get(Long id) {
        return getHammer().get(id, User.class);
    }
    User getByUsername(String username);
}
```
