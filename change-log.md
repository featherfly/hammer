TODO dsl实体查询加入以下（EntityQuery）

1. fetch多次(大于1)，数据返回加入Object[] values(), <T extends Tuple> T tuple() 和 List<Object[]> listValues()，<T extends Tuple> List<T> listTuple() 

# 0.7.3 

1. 修复DSL实体查询连接实体属性（多对一）生成的SQL从内连接（inner join）改变为到左连接（left join）

# 0.7.2 2024-11-15

1.  在启用缓存时，优化分页逻辑，如果页码大于最大页码，则不执行sql,直接返回空列表
2.  完成Entity query DSL查询一个属性时的分页优化功能
3.  TplExecutor,JdbcExecutor添加 value(String, Map<String, Serializable>|Serializable...) 方法
4.  Entity update DSL 添加 property(Entity::Nested, Nested::Number).increase(Number) 方法
5.  Field[In|NotIn]Expression加入各种 [in|not] (Collection<V>...) 方法
6.  所有 DSL 条件运算[eq|in...] 提供参数为Supplier,V的方法
7.  使用validation-api facade，而不是直接使用validation-api来兼容javax和Jakarta包名
8.  更换tuple包
9.  修复sql模板使用多个where，第一个以后得每一个where后跟的第一个条件没有过滤掉and|or
10.  修复repository|entity dsl query 条件查询 eq(FieldExpression) 无限递归导致的内存溢出问题

# 0.7.1 2024-06-02

1. 批量操作的逻辑优化，优先判断jdbc driver是否提供支持，再判断方言(Dialect)是否支持（构建为一条SQL)

2. HammerConfig加入insertBatchSize配置

3. 升级ASM依赖

4. 重构模板执行方法，从Hammer继承TplExecutor改为组合（因为Hammer方法太多了），只需要在原来的基础上加入.template()就行了

   例如 `hammer.string("selectStr", params)`  --> `hammer.template().string("selectStr", params)`

   还加入了多层次的写法 `hammer.template("selectList", params).list()` 或 `hammer.template("selectSinle", params).single()` 等等

   最重要的是把多级对象映射结构化了

   ```java
   // select u.name,ui.descp,o.amount from ......
   List<Tuple3<User,UserInfo,Order> list = hammer.template("selectList", params)
       .mapper(User.class, UserInfo.class, Order.class) // 按照SQL返回的前缀别名顺序映射
       .list();
   // 或者
   List<Tuple3<User,UserInfo,Order> list = hammer.template("selectList", params)
       .mapper(m->m.map("u.",User.class).map("ui.", UserInfo.class).map("o.", Order.class)) // 手动设置前缀别名映射关系
       .list();
   ```

5. 模板ID（TplExecuteId）字符串格式从namespace@name变更为name@namespace

6. 过滤条件设置的字段（属性）名添加了加、减、乘、除的数学运算

   ```java
   // add
   query.find("user").fetch("age").where().fieldAsNumber("age").add(5).eq(10).list();
   // subtract
   query.find("user").fetch("age").where().fieldAsNumber("age").subtract(5).eq(0).list();
   // multiply
   query.find("user").fetch("age").where().fieldAsNumber("age").multiply(5).eq(25).list();
   // divide
   query.find("user").fetch("age").where().fieldAsNumber("age").divide(5).eq(1).list();
   
   // add
   query.find(User.class).fetch(User::getAge).where().property(User::getAge).add(5).eq(10).valueList();
   // subtract
   query.find(User.class).fetch(User::getAge).where().property(User::getAge).subtract(5).eq(0).valueList();
   // multiply
   query.find(User.class).fetch(User::getAge).where().property(User::getAge).multiply(5).eq(25).valueList();
   // divide
   query.find(User.class).fetch(User::getAge).where().property(User::getAge).divide(5).eq(1).valueList();
   ```

6. 加入防止sql注入的模板标签（StringReplaceDirective）和模板方法（StringReplaceMethod）

8. 存储过程支持支持多查询返回

   ```java
   // 延迟映射数据
   Serializable[] params = new Serializable[] { uid };
   try (MulitiQuery query = jdbc.callMultiQuery("procedurename", params)) {
         while (query.hasNext()) {
             Map<String,Object> map = query.next();
             // or
             User user =  query.next(User.class);
             // or
             RowMapper<User> userRowMapper = new ... // your custome RowMapper
             User user =  query.next(userRowMapper);
         }
    } catch (Exception e) {
          // Logic for handling exceptions
    }
   
   // 直接映射数据
   Tuple6<List<User>, List<UserInfo2>, List<Order2>, List<Map<String, Serializable>>, List<UserRole>,
               List<Map<String, Serializable>>> mulitiList = jdbc.callMultiQuery(name,
                   b -> b.map(User.class).map(UserInfo2.class).map(Order2.class).map().map(UserRole.class).map(), params);
   
   
   ```

6. 模板执行器（TplExecutor）和SQL执行器（JdbcExecutor）支持each查询，即延迟映射（需要手动管理）

6. 查询分页结果集(PagniationResults)时，支持缓存total参数，如果下次查询没有改变参数，如果查询参数未变化，只是页码变化（即翻页），则会直接使用缓存

6. DSL实体查询(DSL entity query) 的pagination()方法支持分页sql自动优化（如果能够优化），优化标准必须id字段为有序，并且查询没有排序（目前只要有排序就不会优化，后续加入更多情况判断）

6. DSL实体查询(DSL entity query) 和模板查询的pagination()和分页list()方法支持缓存list结果，如果查询参数未变化，只是页码变化（即翻页）,会从缓存中缓存对应页码的list结果。即访问 1 -> 2 -> 3 -> 2 -> 1 这样的翻页，后面两次的2,1就会从缓存获取数据

13. 实体对象保存支持ID生成器（IdGenerator）

15. 性能优化

    1. 优化批处理逻辑，如果数据库驱动支持高性能批处理，则交由数据库驱动处理，如果数据库驱动没有高性能批处理能力，则使用框架自行封装的高性能批处理逻辑（如果有方案的话）
    2. 使用PropertyAccessor（字节码）代替之前的BeanProperty（反射），包含对象的生成（new ）和属性的访问（get）和设置（set）
    3. 模板预编译直接把命名参数的sql转换为jdbc支持的问号占位符sql，即 id = :id 转换为 id = ?（这样就只有加载时转换一次，不用每次执行的时候都转换）
    4. 模板预编译支持直接静态include（即预编译阶段把include的内容直接解析进主题，需要配置TemplateConfig.isPrecompileNamedParamPlaceholder为 false），并且在静态include的情况下，还可以在加载时就把count sql生成（不用每次执行时再动态生成）
    5. entity|repository dsl pagination count sql使用直接生成，而不是从select sql转换
    6. 实体操作（InsertOperate,GetOperate）等，固化实体元数据，不会在调用时在获取元数据了

    

# 0.7.0 2024-05-05

1. 加入强类型dsl查询
   一级、二级、三级、四级、五级join实现与测试
   
2. 实现TransverterManager

3. 实现upsert在全部是插入时为entity设置自动生成的主键（存在update时返回的key无法确定）

4. 优化GetOperate的ForUpdate逻辑

5. Jdbc实现查询返回Tuple2,List<Tuple2>,Tuple3,List<Tuple3>,Tuple4,List<Tuple4>,Tuple5,List<Tuple5>,Tuple6,List<Tuple6>

6. 模板sql支持返回一系列Tuple[2-6]、List<Tuple[2-6]>、PaginationResults<Tuple[2-6]>

7. SqldbHammer加入QueryEntity query(Table table);Update update(Table table);Delete delete(Table table)方法

8. Jdbc实现存储过程支持

9. Entity DSL加入Consumer参数方法,加入带IgnoreStrategy|Predicate参数方法

10. Update DSL里的所有set、increase方法都新增了一个加入多一个参数Supplier<Boolean> setable的重载方法，用于判断此次方法调用是否设置值

11. 实现非spring环境下的Jdbc的功能和事务管理
    ```java
    // 使用原生jdbc管理事务
    Jdbc jdbc = jdbcFactory.create(conn);
    connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED); //设置隔离级别
    connection.setAutoCommit(false); //启用事务
    jdbc.update(sql)
    jdbc.update(sql2)
    conn.commit();// or conn.rollback();
    conn.close();
      
    // 使用包装管理事务
    JdbcSession jdbc = jdbcFactory.createSession(conn);
    JdbcTransaction tran = jdbc.beginTransation(Isolation.READ_COMMITTED); //设置隔离级别
    tran.update(sql)
    tran.update(sql2)
    tran.commit(); // or tran.rollback();
    jdbc.close();
    // 使用详情参考JdbcTransactionTest.java
    ```
    
12. EntityQuery支持多实体（muliti entity）查询（基于join），实现支持多实体条件过滤，实现多实体排序

    where().property(Xx:Yy).property(Yy::Name).[eq|ne|...] 如果需要join会自动加入join

    where().property()后的各种条件筛选方法加入带Predicate和IgnoreStrategy的重载方法

    where().eq()方法支持@Embeddable,@ManyToOne（传入是映射对象，对非空值使用and连接，如果是连表查询条件会自动join）

    fetch一次，数据返回加入T value()（单条）和 List<T> listValue()（多条列表），还原single和unique方法为原来的返回查询实体对象

13. Jdbc实现queryEach，主要用于大数据查询导出，不会依次把内容都加载到内存中，而是迭代的时候依次获取，需要调用者处理连接

    Jdbc各种执行sql的方法支持NamedParamSql参数（例如jdbc.query(NamedParamSql sql, Map<String,Object>）

15. 加入配置`HammerConfig`，实现update、delete、query等表达式的配置（configure方法）

16. RepositoryQuery支持多存储|表（muliti repository）查询（基于join），实现支持多存储|表条件过滤，实现多存储|表排序

16. EntityUpdate,EntityDelete支持join进行多实体条件过滤

17. RepositoryUpdate,RepositoryDelete支持join进行多实体条件过滤

18. Jdbc加入各种参数为NamedParamSql的重载方法

    ```java
    Jdbc jdbc = ...;
    Map<String,Object> userMap = jdbc.querySingle(namedParamSql, params);
    User user = jdbc.querySingle(namedParamSql, User.class, params); // 这里只是举两例子，更多用法参考Jdbc类
    ```

    

# 0.6.7 2023-04-18
1. 修复eq参数为空时报错的问题

# 0.6.6 2022-08-26
1. 修改L group(Consumer<C>)为L group(Function<C,L>)，
2. 修复分组多次调用分组层次不对的问题

# 0.6.5 2022-08-16
1. TplExecuteIdMapperImpl删除isTemplate相关代码
2. dsl条件查询eq(SerialFunction<T, R>, T),ne(SerialFunction<T, R> t)方法支持@Embedded对象，自动使用该对象的所有非空属性
3. where(Consumer<ConditionGroupConfig>)泛型参数变更
4. Hammer、GenericHammer加入querySingleBy，queryListBy等一系列方法
5. Jdbc.update支持多参数支持其中某几个参数是BeanPropertyValue
6. dsl api update的set方法支持自定义映射(使用BeanPropertyValue)
7. 加入StringConditionExpression，用于在dsl中加入特殊sql拼接
8. dsl api （eq,ne,co,sw,ew,lk）加入查询大小写敏感的支持（即 = 和 like 支持区分大小写）（根据数据库不同可能不支持）
9. Hammer加入get(id,Class,SerializableFunction)方法用于在获取对象时自动获取关联属性对象（目前只支持多对一和一对一（Entity），即不支持一对多(List)）
10. Hammer加入getLockUpdate用于一次交互完成锁查询、修改，并返回修改后的结果的功能

# 0.6.4 2022-07-15
1. 升级依赖
2. 修复使用jdk17时,springdev里的restartclassloader加载有错的问题

# 0.6.3 2022-06-08
1. NestedBeanPropertyRowMapper加入MapperObjectFactory
2. 动态Mapper实现生成时加入方法的注解
3. 修复devMode的时候读取@Template内置sql报错的问题

# 0.6.2 2022-05-31
1. 修复template文件在jar包中获取文件出错的问题

# 0.6.1 2022-05-31
1. 优化TplExecutionConfig的配置信息
2. 优化配置的日志输出
3. Template删除isTemplate()方法
4. 实现saveOrUpdate方法，如果数据库支持upsert，则使用upsert,否则判断id是否为空进行保存或者更新
5. Jdbc加入各种insert,upsert方法

# 0.6.0 2022-05-24  
1. 模板文件加载器加入支持从不同前置目录加载的实现(例如 rbac, cms, blog, common/config)
2. 模板文件加载器加入支持从不同文件后缀加载的实现(例如 .yaml.sql, .tpl.sql)

# 0.5.30 2022-04-22  
1. 修复在java11下生成mapper出现的空指针异常
2. dsl api 更新操作set方法加入set(Consumer<UpdateSetDsl>)用于在链式调用中进行条件帅选

# 0.5.29 2022-04-06  
1. 修复common-core不兼容升级
2. 优化AbstractJdbc的日志输出
3. update().set(SerialFunction, value)、where().eq(SerialFunction, value)/ne(SerialFunction, value)的value改为对应Function的泛型
4. SqldbHammer加入JdbcMappingFactory getMappingFactory()方法

# 0.5.28 2021-12-20
1. Mapper加入HammerSupport和GenericHammerSupport支持

# 0.5.27 2021-12-19
1. Hammer加入List<E> get(Class<E>, Serializable...)和List<E> get(Class<E>, List<Serializable>);
2. ConditionGroupExpression,RepositoryConditionGroupLogicExpression加入Predicate<Object> getIgnorePolicy(),C setIgnorePolicy(Predicate<Object> ignorePolicy)
3. dsl api 加入C where(Consumer<C> consumer)方法

# 0.5.26 2021-12-05
1. Jdbc加入update(String,BeanPropertyValue<?>...),update(String,GeneratedKeyHolder,BeanPropertyValue<?>...)方法
2. 相关operate类使用新的update方法

# 0.5.25 2021-12-04
1. 优化AbstractQueryOperate的日志输出格式
2. 优化NestedBeanPropertyRowMapper在查询列表时，只进行一次类型检测和映射元数据，后续的都使用映射元数据结果直接进行赋值
3. Jdbc执行sql加入intercptor

# 0.5.24 2021-12-03
1. 优化NestedBeanPropertyRowMapper的日志输出格式
2. 优化AbstractFreemarkerTemplateEngine的日志输出格式
3. 优化部分调试日志输出格式
4. 修复嵌套对象（xxx.yyy）获取值时没有使用自定义属性映射的问题

# 0.5.23 2021-12-01
1. 修复/*fieldName??*/ and column_name like /*$=%:fieldName%*/'123' 这种格式没有正确预编译的问题

# 0.5.22 2021-10-19
1. LogicExpression加入L and(Consumer<C> group)和L or(Consumer<C> group)
2. L group(Function<C,L> group)修改为L group(Consumer<C> group);

# 0.5.21 2021-09-21 
1. 修复版本升级出现的问题，不再依赖spring打包的objenesis,而是直接依赖objenesis包
2. 预编译实现对sql hints的支持，即不过滤/*+ */的内容，添加了注释不过滤功能
    /*后跟[ +\n]空格+号换行就认为是一个需要保留的注释
3. 移除对constant模块的强依赖，使用简单的java属性来设置开发模式
4. 分页功能重构，加入PageFactory接口，方便后续扩展，提供默认实现（相当于之前的分页功能）

# 0.5.20 2021-09-01
1. 修复模板sql中有参数传入没有进行条件判断，则参数会被过滤掉的问题

# 0.5.19 2021-08-31
1. 修复预编译把字符串中的%过滤掉的问题，例如DATE_FORMAT(date, '%Y-%D-%M')

# 0.5.18 2021-08-26
1. 加入isn(... Boolean),inn(... Boolean)方法

# 0.5.17 2021-08-20
1. sql模板加入precompile参数，可以使用false禁用当前sql的预编译

# 0.5.16 2021-08-18
1. 使用SqlUtils转换namedsql自动处理in的情况，去掉之前<@and>和<@or>的实现

# 0.5.15 2021-08-16
1. 修复预编译优化条件标签<@and>和<@Or>，在编译为Freemarker模板后，明确加入name="fieldName"属性时CO,SW,EW丢失的问题
2. 修复SqlTplExecutor执行模板语句时，都注册为TplExecuteId.count的问题

# 0.5.14 2021-08-11
1. 预编译优化条件标签<@and>和<@or>，在编译为Freemarker模板后，明确加入name="fieldName"属性
2. 修复LogicTemplateDirectiveModel在获取参数名称时的正则表达式不支持表别名的问题，并支持关键字转移符['"`]

# 0.5.13 2021-07-26
1. 加入QueryOperator.LK的支持

# 0.5.12 2021-07-14
1. sql模板(SqlTplExecutor中实现)支持<and if=ids??> id in :ids </and>自动设置集合或者数组参数

# 0.5.11 2021-06-18
1. 优化类型映射查询，自动处理处理返回List<Integer>,List<String>,List<Long>等单一属性列表，只要是SqlTypeMappingManager支持的类型都行
```
    List<Long> idList = jdbc.query("select id from role order by id", Long.class);
    
    @Template("select id from role order by id")
    List<Long> idList();
```

# 0.5.10 2021-05-12
1. 修复springboot使用dev-tool进行热部署时，重新加载生成mapper报错的问题

# 0.5.9 2021-05-06
1. 模板sql的<@and>和<@Or>标签加入transverter属性，用于对字符串模糊查询，支持CO,SW,EW
```
    <@and if = name?? transverter="CO"> 表示%value%
    <@and if = name?? transverter="SW"> 表示value%
    <@and if = name?? transverter="EW"> 表示%value
```
2. 预编译实现对模糊查询%的处理
   ```    
    /*??*/ name like /*$=%:name%*/\\_init\\_
    /*??*/ name like /*$=%:name*/init\\_98
    /*??*/ name like /*$=:name%*/n\\_init
    
    /*??*/ name like %:name%
    /*??*/ name like %:name
    /*??*/ name like :name%
    
    /*name??*/ name like %:name%
    /*name??*/ name like %:name
    /*name??*/ name like :name%
   ```
3. 修复where标签后换行直接跟order by语句没有空格符号导致最后的参数名称连接到order单词的问题

# 0.5.8 2021-03-26
1. SqlQueryEntity加入join(Join)，join(Join, String)，join(Class<T>)，join(Join, Class<T>)方法
2. QueryEntityExpression加入<QI> QI cast(Class<QI> queryEntityExpressionType)方法
3. Jdbc.querySingle返回集合的数量大于1时抛出异常
4. 所有的SingleExecutor都加入了对应single方法的unique方法
5. MergeOperate实现当对象除了id以外的属性都判定为忽略时（一般为null,空字符串，空集合等）不进行数据库操作
6. 修复AbstractJdbc抛出JdbcException没有添加错误信息的问题

# 0.5.7 2021-02-22
1. JdbcImpl的所有的query方法都支持SqlTypeMappingManager的自定义类型

# 0.5.6 2020-12-12
1. Jdbc方法参数位置修改
2. 修复JdbcImpl没有释放connection的问题
3. Asm使用ClassLoader加载类信息，可以加载fatjar模式的类
4. operate包下的所有数据库操作支持SqlTypeMappingManager的自定义类型管理
5. dsl条件查询eq(SerializableSupplier<R>),ne(SerializableSupplier<R>)方法支持ManyToOne对象自动使用id进行查询
```java
 UserRole2 userRole2 = new UserRole2();
 userRole2.setRole(new Role(2));
 userRole2.setUser(new User(1));
 query.find(UserRole2.class).where().eq(userRole2::getRole).and().ne(userRole2::getUser).list();
 // SELECT _user_role0.`user_id` `user.id`, _user_role0.`role_id` `role.id`, _user_role0.`descp` `descp`, _user_role0.`descp2` `descp2` FROM `user_role` _user_role0 WHERE _user_role0.`role_id` = ? AND _user_role0.`user_id` != ? , args -> [2, 1]
```
6. dsl条件查询eq(SerializableSupplier<R>),ne(SerializableSupplier<R>)方法支持@Embedded对象，自动使用该对象的所有非空属性
```java
 DistrictDivision division = new DistrictDivision();
 division.setCity("成都");
 division.setProvince("四川");
 division.setDistrict("高新");
 userInfo.setDivision(division);
 query.find(UserInfo.class).where().eq(userInfo::getDivision).list();
 // SELECT _user_info0.`province` `division.province`, _user_info0.`city` `division.city`, _user_info0.`district` `division.district`, _user_info0.`id` `id`, _user_info0.`user_id` `user.id`, _user_info0.`name` `name`, _user_info0.`descp` `descp` FROM `user_info` _user_info0 WHERE ( _user_info0.`province` = ? AND _user_info0.`city` = ? AND _user_info0.`district` = ? ) , args -> [四川, 成都, 高新]

 userInfo.getDivision().setDistrict(null);
 query.find(UserInfo.class).where().eq(userInfo::getDivision).or().eq(userInfo::getDivision).list();
 // SELECT _user_info0.`province` `division.province`, _user_info0.`city` `division.city`, _user_info0.`district` `division.district`, _user_info0.`id` `id`, _user_info0.`user_id` `user.id`, _user_info0.`name` `name`, _user_info0.`descp` `descp` FROM `user_info` _user_info0 WHERE ( _user_info0.`province` = ? AND _user_info0.`city` = ? ) OR ( _user_info0.`province` = ? AND _user_info0.`city` = ? ) , args -> [四川, 成都, 四川, 成都]
```
7. dsl查询query.find(Class)后的条件查询加入支持关联对象的连表查询
```java
query.find(UserInfo.class).where().eq(userInfo::getUser, User::getPwd).and().eq(userInfo::getId).and().lt(UserInfo::getUser, User::getAge, 10).list()
```

# 0.5.5 2020-12-8
1. DSL条件查询加入group(Fucntion<C,L> function)方法 ，不用手动调用endGroup方法
```java
where().eq("name", name).and().eq("pwd", pwd).and().group(c -> c.eq("sex", sex).or().gt("age", age)).and().eq("username", username)
```
2. QueryEntityExpression加入sum(propertyName),max(propertyName),min(propertyName),avg(propertyName),distinct(propertyName)方法

# 0.5.4 2020-12-7
1. 开启-parameter进行编译，保留名称信息
2. 修复Mapper覆盖超类接口asm自动生成的实现方法没有paramaeter name信息的问题

# 0.5.3 2020-12-04
1. 修复asm生成mapper实现类泛型定义出错的问题
2. GenericHammer加入id泛型
3. 支持继承自GenericHammer的Mapper重写带泛型参数的方法

# 0.5.2 2020-11-30
1. 预处理条件查询时，明确查询条件参数名称（可以加快执行效率，避免条件标签自动匹配查询条件参数名称）
2. TplConfigFactoryImpl默认后缀参数从.yaml.tpl改为.yaml.sql
   
# 0.5.1 2020-11-27
1. 修复??把array和string判断写反了的问题

# 0.5.0 2020-11-27
1. 加入预处理程序，把为sql特化的模板定义预编译为freemarker模板，参考下面示例
```sql
select /*<<prop alias='r'*/* from /*<<wrap*/user
/*<where*/ where
    /*?*/id = /*$=:id*/1
    /*??*/and name like /*$=:name*/'name'
    /*?*/ and gender = /*$=:gender*/1
    /*??*/ and tag in /*$=:tag*/(1,2,3)
    /*<?*/ and
    (
        /*username??*/ username = /*$=:username*/'admin'
        /*email??*/ or email = /*$=:email*/'featherfly@foxmail.com'
        /*mobile??*/ or mobile = /*$=:mobile*/13212345678
    )
    /*>?*/
/*>where*/
/*<sql id='roleFromTemplate'>*/
```
转换结果
```sql
select <@prop alias='r'>*</@prop> from <@wrap>user</@wrap>
<@where>
    <@and if=id?? name='id'>id = :id</@and>
    <@and if=name?? && name?length gt 0 name='name'>name like :name</@and>
    <@and if=gender?? name='gender'>gender = :gender</@and>
    <@and if=tag?? && tag?size gt 0 name='tag'>tag in :tag</@and>
    <@and>
        <@and if=username?? && username?size gt 0> username = :username</@and>
        <@or if=email?? && email?length gt 0>email = :email</@or>
        <@or if=mobile?? && mobile?length gt 0>mobile = :mobile</@or>
    </@and>
</@where>
</@sql id='roleFromTemplate'>
```

# 0.4.10 2020-11-25
1. 修复Mapper参数是基本值类型(int,integer等)时报错的问题
   
# 0.4.9 2020-11-24
1. 使用ASM替换javassist修复自定义的Mapper继承GenericHammer接口并重载了get(Serializable)方法报错的问题
   
# 0.4.8 2020-11-17
1. Hammer加入delete(Ids,Class)方法,delete(Ids),delete(Entities)方法实现一条sql进行批量删除
2. 升级common-core、common-db、common-model-repository

# 0.4.7 2020-7-16
1. 修复自定义Mapper接口覆盖了GenericHammer，Hammer接口定义的方法，没有继承来默认实现的问题（目前只是先了方法不带泛型的接口，后续实现带泛型的）
2. 加入JdbcImpl，临时实现，后续会剔除对SpringJdbcTemplateImpl的继承
3. 修复dsl中的条件参数为空时异常的问题

# 0.4.6 2020-7-14
1. 修复save(List) list.size = 0 时的空指针异常
2. 修复javassit动态创建Mapper在spring boot中出错的问题

# 0.4.5 2020-6-30
1. 所有参数为SerializableFunction, Value的方法加入同名参数为的SerializableSupplier方法
2. 部分参数为SerializableFunction更改为各种ReturnXXXFunction
3. 兼容性升级，LangUtils修改为Lang，StringUtils修改为Strings
4. 升级依赖包

# 0.4.4 2020-5-23
1. include标签的file参数改为namespace参数

# 0.4.3 2020-4-20
1. 完成batch save优化，如果数据库支持批量插入并且当使用数据库生成主键策略时数据库对应驱动能够返回批量生成的主键，则使用批量插入sql否则使用循环插入

# 0.4.2 2020-4-18
1. 重构项目，把builder，mapping移动到common-model-repository和common-db
	抽象模型在common-model-repository模块,sqldb的实现在common-db模块

# 0.4.1 2020-4-18
1. 修复获取type时判断用错参数的bug
2. 更新文档

# 0.4.0 2020-4-17
1. 为模板执行加入操作数据能力，可以使用模板sql进行insert,update,delete操作
2. @Template加入type参数，默认值AUTO
2. Mapper中int xxx(ar1, ar2.. arn)， void yyy(ar1, ar2...arn)
        当返回值是void时，执行execute（即执行insert,update,delete等操作）
        当返回值是int并且type参数是AUTO或者EXECUTE时，执行execute（即执行insert,update,delete等操作）
        如果要执行一个查询返回一个int值，可以加上type=QUERY或者使用包装类型Integer作为返回值

# 0.3.3 2020-4-15
1. 重命名@TplExecution为@Template,@TplParam为@Param，@TplParamType为ParamType
2. @Template加入value()，用于直接在注解上使用模板（如sqldb模块的sql模板）,加入isTemplate()用于在执行value()时是否使用模板引擎,用于value()是一个不可变的字符串就可以禁用其使用模板引擎，可以提高一丢丢的性能-_-，默认是开启的，当前版本未实现禁用模板引擎
3. @Param加入name(),而value()作为name()的快捷别名，name()优先级高于value()
4. 加入SqldbHammer接口

# 0.3.2 2020-4-11
1. 修正依赖BUG

# 0.3.1 2020-3-18
1. Hammer加入update(String),delete(String)方法

# 0.3.0 2020-3-17
1. 项目整体重命名（模块名，包名）为正式名称hammer
2. 加入Mapper注解，相当于以前TplExecution标注类的功能，移除TplExecution标注类的功能，现在只能标注方法

# 0.2.6 2020-2-17
1. 加入count方法,
```java
query.find(repo).count();
query.find(repo).where().lt("age", 18).count();
```
2. 加入property(String,AggregateFunction)方法
```java
query.find(repo).property("price", AggregateFunction.SUM);
```


# 0.2.5 2019-12-03
1. 升级依赖
   
# 0.2.4 2019-11-28
1. Juorm和GenericJuorm加入多个重载的delete方法
   
# 0.2.3 2019-11-21
1. 升级constant版本，支持constant无配置文件的默认配置

# 0.2.2 2019-11-15
1. Juorm api 方法名称变更

# 0.2.1 2019-11-15
1. QueryEntityExpression加入sort()
2. 加入QueryLimitExecutor和TypeQueryLimitExecutor，调用limit后的表达式可以使用pagination方法返回分页包装对象

# 0.2.0 2019-10-28
1. ClassMapping移动到core模块
2. Query加入with() on() property()用于联合查询
3. Updater的propertyNumber和increase方法中的SerializableFunction加入Number类型约束

# 0.1.4 2019-9-18
1. find(Class type)后的条件在执行时使用TypeExecutor，只能返回find时传入的对象
   
# 0.1.3 2019-9-17
1. 加入SQLiteDialect
2. 加入SerializableFunction支持

# 0.1.2 2019-9-3
1. 加入SqlDbConfigurator，可以从配置直接获取可运行的JuormJdbcImpl
2. Jdbc接口去掉spring依赖
   
# 0.1.1 2019-8-21
1. 升级依赖，解决版本导致出错问题
2. tpl mapper interface加入default method支持
3. tpl加入wrap模板方法 ${tpl_wrap("user")}
   
# 0.1.0 2019-8-20
1. 实现基本的crud
2. 实现dsl风格的query,update,delete
3. 实现基于模板的sql查询（类似mybatis）