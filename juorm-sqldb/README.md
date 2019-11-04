***

## JUORM-SQLDB

`JUORM-SQLDB` 是基于jdbc实现对关系型数据库的数据操作。

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

// 模板DML查询数据
int avg = juorm.intValue("selectAvg2", new HashChainMap<String, Object>().putChain("age", 40));
String str = juorm.stringValue("selectString", new HashChainMap<String, Object>());
User u = juorm.single("user@selectByUsername", User.class,
                new HashChainMap<String, Object>().putChain("username", username));
List<User> users = juorm.list("user@selectConditions", User.class, new HashChainMap<String, Object>()
                .putChain("minAge", minAge).putChain("maxAge", maxAge).putChain("username", username2 + "%"));
PaginationResults<User> userPaginationResults = executor.pagination("user@selectConditions", User.class,
                new HashChainMap<String, Object>(), start, limit);
```

通过使用mapper操作的代码概览（类似mybatis）：

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
- [**`通过主键获取对象`**](#通过主键获取对象)
    - [**`单一主键`**](#单一主键获取对象)
    - [**`复合主键`**](#复合主键获取对象)

## 基础配置

### 最基础的配置文件

**在resources目录下加入constant.yaml文件（默认是从classpath根目录读取）**

```yaml
basePackeges: cn.featherfly
devMode: true
```
`basePackeges` 需要扫描constant配置的包路径，多个包使用逗号（,）隔开，如(cn.fetherfly,com.github)。如果你的项目没有使用constant配置，直接使用cn.featherfly就行了。
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

    private Jdbc jdbc;

    private JdbcMappingFactory mappingFactory;

    private TplConfigFactory configFactory;

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

**使用Mapper**

```java
@Service
public class UserService {

    @Resource
    UserMapper userMapper;

}
```