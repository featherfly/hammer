# 0.7.0
1. 加入强类型dsl查询
   一级、二级、三级、四级、五级join实现与测试
   
2. 实现TransverterManager
3. 实现upsert在全部是插入时为entity设置自动生成的主键（存在update时返回的key无法确定）
4. 优化GetOperate的ForUpdate逻辑

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