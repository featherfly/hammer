新功能

- [x] 预加载sql模板进行优化，把count sql在加载期预加载到count sql配置属性中（如果能够确定）

- [ ] hammer加入update(entity, Predicate<BeanProperty> ignore)对在更新时需要忽略的对象属性进行帅选

- [ ] TplExecutor各种方法中的TplTemplateId可以加入直接传入字符串模板的方式（用于jdk17的多行字符串），类似@Template(value = "sql template....")
    使用sha1把编码sql template，作为sql template的name进行模板注册，使用固定的

- [ ] TplExecuteId的字符串表现形式应该从namespace@name改为name@namesapce，这样就和现在url,email等中的@使用方式一致了，表示name at namesapce

- [ ] 对象映射加入动态表名

- [ ] 对象映射加入id生成器支持

- [ ] 加入获取实体对象以及其关系对象的查询方式

  > 例如

  ```java
  hammer.get(id, UserInfo.class, UserInfo::getUser);
  // 需要加入级联获取的规则，即一条sql级联查询，还是分两条sql查询
  // 其他方式还在考虑
  ```

- [ ] 加入实体对象的延迟级联查询，基于JPA注解

  1. 延迟级联查询可以设置级联获取的层级（大于层级则不再级联查询）
  2. 实体对象的级联查询可以使用编译期织入(编译的时候字节码修改）和运行期织入（启动的时候字节码修改）
   编译期织入在实现中需要获取版本号，用于后续版本加载出来判断兼容性问题
  3. 一对多和多对多加入PageList、PageSet、PageMap等支持分页查询的

- [ ] 加入继承支持（保存都支持，主要是查询）  

  > 例如

  ```java
  User extends Authorized {
  ...
  }
  App extends Authorized {
  ...
  }
  List<Authorized> authorizeds = hamer.query(Authorized.class).list();      
  User user = (User) authorizeds.get(0);
  App app = (App) authorizeds.get(1);
  ```

  > 可能的实现方案  

  1. 设置类映射配置，在查询映射类时，先找映射配置，有则使用配置的映射映射对象，如果没有，则走现有模式。  

  > 例如 

  ```java
  hammer.regist(Authorized.class, new AuthorizedMapper());
  ```

  2. 设置抽象类（接口）映射配置，在查询映射类时，先判断映射的类是否时抽象的，如果是抽象的，则在映射配置中查找，如果查找不到，则抛出异常  

  > 例如 

  ```java
  hammer.regist(Authorized.class, new AuthorizedMapper());
  ```
  3. 加入一个映射类（类似spring的BeanFactory）  

  > 例如

  ```java
  List<Authorized> authorizeds = query(AuthorizedMapper<Authorized>.class).list();

  List<Authorized> authorizeds = query(Authorized.class).mapper(AuthorizedMapper.class).list();
  ```

- [ ] 优化page查询，缓存total_size，在相同查询条件下，使用缓存的total_size

- [ ] 加入查询结果缓存翻译功能

- [ ] 加入查询结果自动加入总计的功能

- [x] 加入upsert支持

- [x] 加入一次交互完成锁查询、修改，并返回修改后的结果的功能

    hammer加入updateFetch、~~saveOrUpdateFetch~~锁记录，修改，并返回修改后的信息

    updateFetch的原理:  

    默认使用Result Sets中检索和修改值的相关内容。

    当JDBC driver不支持ResultSet的并发更新时，可以根据参数使用数据库行锁或者自定义锁(如redis lock)锁定,然后再加载,最后进行更新(产生两次交互)
    数据数据库（sql数据库一般都支持行锁）不支持（如elasticsearch, mongodb等暂时不确定这两是否有行锁，做相应实现时再查询期特性），使用内置的locker来实现

- [ ] 加入@Execution|@Dsl（@Sql）注解，用于非模板执行字符串（sql，json等）的直接运行，并去掉@Template的isTemplate方法（需要处理字节码动态加载）

- [x] dsl条件查询eq(SerialFunction<T, R>, T),ne(SerialFunction<T, R> t)方法支持@Embedded对象，自动使用该对象的所有非空属性（参考eq(SerializableSupplier<R>),ne(SerializableSupplier<R>)支持@Embedded对象的实现）

- [x] dsl api (update、delete、query) 实现 configure方法用于配置当前表达式实例的相关配置项（只影响当前表达式实例）

  > 例如

  ```
  update(XX).configure(c -> c.setIgnorePolity(IgnorePolity.EMPTY)) ...
  delete(XX).configure(c -> c.setIgnorePolity(IgnorePolity.EMPTY)) ...
  query(XX).configure(c -> c.setIgnorePolity(IgnorePolity.EMPTY)) ...
  
  update(XX).where().configure(c -> c.setIgnorePolity(IgnorePolity.EMPTY)).eq ....
  delete(XX).where().configure(c -> c.setIgnorePolity(IgnorePolity.EMPTY)).eq ....
  query(XX).where().configure(c -> c.setIgnorePolity(IgnorePolity.EMPTY)).eq ....
  
  ```

- [x] dsl api 更新操作set方法加入set(Consumer<UpdateSetDsl>)用于在链式调用中进行条件帅选
  
  > 例如

  ```
  hammer.update(Device.class)
    .set(Device::getChannel1State, channel1State)
    .set(Device::getChannel2State, channel2State)
    .set(Device::getChannel3State, channel3State)
    .set((u)-> {
      if (xxx == yyy) {
        u.set(Device::isOnline, true)
      }
     })
    .set(Device::getLastModifyTime, new Date())
    .where()
    .eq(Device::getId, id)
    .execute();
  ```

- [x] dsl api 更新操作集成update(String, BeanPropertyValue<?>...)用于完善自定义属性映射

- [ ] dsl api 条件查询加入表达式支持，（例如 store - :outNum >= 0[这种可以用传入的参数名用一个特殊的类来处理]， u.id = ur.user_id[这种可以用传入的value以一个特殊类来处理，表示传入的是需要拼接的字符串，不需要用占位符]）

- [x] dsl api （eq,ne,co,sw,ew,lk）加入查询大小写敏感的支持（即 = 和 like 支持区分大小写）

- [ ] dsl api 查询条件的表达式加入带运算的条件判断

    ```java
    // 带运算的条件判断
    where().property(Account::getAmount).subtract(10).ge(0)
    where().exp(e -> e.property(Account::getAmount).subtract(10).ge(0))
    where().ge(Calculators.subtract(Account::getAmount, 10), 0)
    // where acount.amount - 10 >= 0
        
    where().value(10).subtract(Account::getAmount).ge(0)
    where().exp(e -> e.value(10).subtract(Account::getAmount).ge(0))
    where().ge(Calculators.subtract(10, Account::getAmount), 0)
    // where 10 - acount.amount >= 0
        
    where().property(Order::getPrice).subtract(10).ge(Order::getCharge)
    where().exp(e -> e.property(Order::getPrice).subtract(10).ge(Order::getCharge))
    where().ge(Calculators.subtract(Order::getPrice, 10), Order::getCharge))
    // where order.price - 10 == order.charge
        
    where().property(Order::getPrice).subtract(10).eq(e -> e.property(Order::getCharge).add(10))
    where().exp(e -> e.property(Order::getPrice).subtract(10).eq(e -> e.property(Order::getCharge).add(10)))
    where().eq(Calculators.subtract(Order::getPrice, 10), Calculators.add(Order::getCharge, 10))
    // where order.price - 10 == order.charge + 10
    ```

- [ ] dsl api join on 目前只支持a=b，后续加入其他条件判断（如a<>b, a<b and c>d）

    ```java
    find(User.class).join(UserInfo.class).on(e-> e.property(User::getId).eq(UserInfo::getUserId));
    // 等价 find(User.class).join(UserInfo.class).on(User::getId, UserInfo::getUserId)
    // select * from user u join user_info ui on u.id = ui.user_id
    find(User.class).join(UserInfo.class).on(e-> e.property(User::getId).eq(UserInfo::getUserId).and().property(UserInfo::getSex).eq(Gender.MALE));
    // select * from user u join user_info ui on u.id = ui.user_id and ui.gender = ? ['male']
    find(User.class).join(UserInfo.class).on(e-> e.property(User::getId).gt(UserInfo::getUserId));
    // select * from user u join user_info ui on u.id > ui.user_id
    ```

- [ ] dsl api 加入gourp by和having支持 

  ```sql
  SELECT m.`name` mn, count(model_id) num FROM `smoking_facility` s 
      join smoking_facility_model m on s.model_id = m.id
  where s.id > 1
  group by mn
  having num > 20
  ```

- [ ] dsl api 的属性获取(fetch)以及条件查询(eq, gt等) 加入子查询支持（是否支持再考虑）

    ```java
    find("user") 
      	.fetch(f -> f.find("order").fetch("id").where().eq("id", 1))
        .where()
        .in("id", f -> f.find("order").fetch(true /*distinct*/, "user_id").where().gt("price", 10000))
        .in("id", f -> f.find("order").fetch(new Field("user_id").distinct()).where().gt("price", 10000))
        .in("id", f -> f.find("order").fetch(Field.nameOf("user_id").distinct()).where().gt("price", 10000))
    //  .in("id", f -> f.find("order").fetch(field -> field.name("user_id").distinct()).where().gt("price", 10000))
    ```

    

- [ ] dsl api 加入代码生成强类型支持, 基于数据库元数据

    ```java
    find(UserTableMetadata) // 生成的字段大小写再考虑，如果全部大写，可以把关键字生成为小写，例如u.distinct.AGE而不是u.distinct().AGE
      	.fetch((fetcher,u) -> fetcher.accept(u.NAME, u.AGE, u.GENDER))
        .fetch(u -> u.NAME, u -> u.AGE, u -> u.GENDER) 
        .fetch(u -> u.PASSWORD.alias("pwd"))
        .fetch(u -> u.distinct().NATIONNALITY)
        .fetch(u -> u.birthday.format("%Y-%m-%d"))
        .fetch(e -> e.name().age().gender().password("pwd").nationality(e-> e.distinct()).city(e -> e.distinct().alias("city")))
        // 上面这种形式再考虑是否需要，因为最上面那个可变参数就能实现一个fetch()方法获取多个字段的目的了
    	.where()
        .eq(u -> u.NAME.apply|accept|value("name")) // 方法名在考虑，或者 .eq(u -> u.NAME, "name") 
        // 或者
        .where(
        	e -> e.NAME.eq("name")
        		.and().AGE.ge(18)
        		.and().BIRTHDAY.getYear().ge(2000)    // getYear() getMonth()等等方法只有日期类型才有
    		    .and().BIRTHDAY.getMonth().in(12,1,2) // 冬季出生
        );
    
    // 生成表达式
    find(UserTableMetadata) // 生成的字段大小写再考虑
        fetch()
        .name().age().gender()
        .password("pwd") // .password(e-> e.alias("pwd"))
        .nationnality(e -> e.distinct())
        .city(e -> e.distinct().alias("city"))
    	.where()
        .name.eq("name")
        .and().age.ge(18)
    	.and().birthday.getYear().ge(2000)    // getYear() getMonth()等等方法只有日期类型才有
    	.and().birthday.getMonth().in(12,1,2) // 冬季出生
        
    // join
    find(UserTableMetadata)
        // 省略 fetch，查询所有
    	.join(UserInfoTableMetadata).on((e1,e2) -> e1.id.eq(e2.userId))
        // 省略 fetch，查询所有
        .where((e1,e2) -> e2.username.eq("username")
    				    .and(e2).age.ge(18);
        );
    
    find(UserTableMetadata)
        .join(UserInfoTableMetadata).on((e1,e2) -> e1.id.eq(e2.userId))
        .where()
        .username.eq("username")
        .and().r2.age.ge(18)     				// 这里大概率要用下面这种方式，因为r2类型是join时动态确定的，只能用方法+泛型来动态约束
        .and().r2().age.ge(18).and().age.le(60) // r(x)切换后的表达式主题都是r(x)
        .and().r1().username.eq("username")     // 要使用另外一个主题就调用r(x)进行切换
        ;
    
    
    find(UserTableMetadata)
        // 省略 fetch，查询所有
    	.join(UserInfoTableMetadata).on((e1,e2) -> e1.id.eq(e2.userId))
        // 省略 fetch，查询所有
        .where()
        .username.eq("username")
        .and((e1,e2) -> e2).age.ge(18); // 这个方法模式很大可能强类型会失效并报编译错误
    ```

    

- [ ] dsl api 加入代码生成强类型支持, 基于实体对象

    ```java
    // 生成表达式
    find(UserEntityMetadata.class) // find(UserEntityMetadataInstanceObject)
      	.fetch((fetcher,u) -> fetcher.accept(u.name, u.age, u.gender, u.password.alias("pwd")
                                             ,u.distinct().nationality, u.birthday.format("%Y-%m-%d"))
         )
        .fetch(u -> u.name, u -> u.age, u -> u.gender) 
        .fetch(u -> u.password.alias("pwd"))
        .fetch(u -> u.distinct().nationality)
        .fetch(u -> u.birthday.format("%Y-%m-%d"))
    	.where()
        .name.eq("name")
        .and().age.ge(18)
    	.and().birthday.getYear().ge(2000)    // getYear() getMonth()等等方法只有日期类型才有
    	.and().birthday.getMonth().in(12,1,2) // 冬季出生
    
    find(UserEntityMetadata.class)
        .join(UserInfoEntityMetadata.class).on((e1,e2) -> e1.id.eq(e2.userId))
        .where((e1,e2) -> e2.username.eq("username")
    				    .and(e2).age.ge(18);
        );
    
    find(UserEntityMetadata.class)
        .join(UserInfoEntityMetadata.class).on((e1,e2) -> e1.id.eq(e2.userId))
        .where()
        .username.eq("username")
        .and().e2.age.ge(18)     				// 这里大概率要用下面这种方式，因为e2类型是join时动态确定的，只能用方法+泛型来动态约束
        .and().e2().age.ge(18).and().age.le(60) // e(x)切换后的表达式主题都是e(x)
        .and().e1().username.eq("username")     // 要使用另外一个主题就调用e(x)进行切换
        ;
    
    
    find(UserEntityMetadata.class)
        .join(UserInfoEntityMetadata.class).on((e1,e2) -> e1.id.eq(e2.userId))
        .where()
        .username.eq("username")
        .and((e1,e2) -> e2).age.ge(18); // 这个方法模式很大可能强类型会失效并报编译错误
    
    find(UserEntityMetadata.class)
        .join(UserInfoEntityMetadataInstance.user)
        .where((e1,e2) -> e2.username.eq("username")
    				    .and().user.age.ge(18);
        );
    
    find(UserInfoEntityMetadata.class)
        .join(e -> e.user)
        .where()
        .username.eq("username")
        .and().user.age.ge(18);
    
    find(User.class).proxy(UserEntityMetadata.class) // .enhance(...) 或者 .metadata(...) .bind(...)
        .join(UserInfo::getUser).proxy(UserInfoMetadata.class)
    	.where()
        .name.eq("name")
        .and().age.ge(18)
    	.and().birthday.getYear().ge(2000)    // getYear() getMonth()等等方法只有日期类型才有
    	.and().birthday.getMonth().in(12,1,2) // 冬季出生
    ```

    

- [x] dsl api 强类型全局支持

    1.查询的数据泛型要在启动那时候就确定（例如query(User.class).list()或.single() 这个list方法的泛型参数一定是User）
    2.条件查询中的SerializableFunction中的实体类型泛型需要和启动时(query,udpate,delete)绑定的类一致 
    3.删除的查询条件强类型支持
    4.更新的set和查询条件强类型支持

- [x] dsl api with(SerializableFunction<T, R>, int) 重构为 relate[x]|join[x](SerializableFunction<T, R>) x表示前面relate|join的调用次数来确定（即x= relate|join调用次数+1，因为可以join find的对象, 所以需要+1), 

- [ ] StringConditionExpression加入expression( ...  ,  Consumer<T extends Tuple>)能获取Tuple的重载方法

- [ ] ~~查询返回支持Map支持多对象映射~~ （因为已经实现了Tuple对象映射类型（强类型），所以此功能暂时不考虑了（弱类型，还需要类型转换））
    map的key为别名,value为映射对象

  > 例如

  ```java
  select u.name,u.age, r.name from ....
    
  Map<String,Object> userRoleMap =   
  List<Map<String,Object>> userRoleMapList =   
    
  User user = (User) userRoleMap.get("u");  
  Role role = (Role) userRoleMap.get("r");  
  ```

- [x] 查询返回支持Tuple对象映射类型

  > 例如

  ```java
  select u.name,u.age, r.name from ....
    
  Tuple2<User,Role> userRoleTuple = 
  List<Tuple2<User,Role>> userRoleTupleList =     
    
  User user = userRoleTuple.get0()
  Role role = userRoleTuple.get1();
  ```

- [ ] 查询返回支持Tuple值类型
  
  > 类似Map，但是可以支持强类型，因为是强类型，所以返回数据的个数要与Tuple对象的个数匹配，例如

  ```java
  select u.name, u.age from ....
    
  Tuple2<String,Integer> userTuple = 
  List<Tuple2<String,Integer>> userTupleList =     
    
  String name = userTuple.get0()
  Integer age = userTuple.get1();
  ```

- [x] Jdbc执行sql加入intercptor

- [x] 分页功能重构，加入PageFactory接口，方便后续扩展，提供默认实现（相当于之前的分页功能）
  
- [ ] 分页实现高性能分页功能（PageFactory接口的一个实现） 

- [x] 预编译实现对sql hints的支持，即不过滤/*+ */的内容
  
- [x] 移除对constant模块的强依赖，使用简单的java属性来设置开发模式

- [x] 自定义数据映射加入数据库返回数据到java对象映射时，加入其相关元数据（如列名，表名）进行更具体的映射

- [x] namedSql转换时候把in params进行相应的转换

- [x] 优化类型映射查询，自动处理处理返回List<Integer>,List<String>,List<Long>等单一属性列表，只要是SqlTypeMappingManager支持的类型都行

- [x] 在模板查询中加入快捷的模糊查询，即在sql中的查询条件两边加入%，则可以实现对应的模糊查询

   1. ConditionManger中加入对应的逻辑
   2. 在and和or条件标签中加入标签属性，可以设置value的转换逻辑
   3. 预编译时把%value, value%, %value%转换为对应的and or条件标签时直接转换为and or的对应标签

- [x] FIXME Mapper参数是原始类型（int,long）会出现错误，需要在生成的类内部转换为包装类型

- [x] 所有的数据库操作，都应该使用SqlTypeMappingManager来进行数据转换操作

- [x] 模板文件加载器加入支持从不同前置目录加载的实现(例如 rbac, cms, blog, common/config)

- [x] 模板文件加载器加入支持从不同文件后缀加载的实现(例如 .yaml.sql, .tpl.sql)

- [ ] 为不同文件后缀名添加对应的解析器（例如.yaml.sql是yaml格式文件，.toml.sql是toml格式文件）

- [x] 实现预编译程序，把下面定义的模板定义预编译为freemarker模板

    1. 快捷实现的标签替换为标签对,例如`/*<<keyword*/user[\n ]`替换为`/*<keyword*/user/*>keyword*/[\n ]`
    2. 预编译替换替换掉，例如`mobile = /*$=:mobile*/13212345678[\n]`替换为`mobile = :mobile[\n]`
    3. 条件查询明确[if and or]并替换标签对，例如`/*id??*/id = ?[\n ]`替换为`/*<? id?*/id = ?/*>?*/[\n ]`,`/*name??*/and name = ?[\n ]`替换为`/*<and name??*/name = ?/*>and*/[\n ]`,`/*??*/ or email = ?[\n ]`替换为`/*<or email??*/email = ?/*>or*/[\n ]`
    4. 条件查询明确条件，例如`/*??*/ username = :username[\n ]`替换为`/*<? username??*/ username = :username/*>?*/[\n ]`

  > 例如

```sql
    select /*<<prop*/* from /*<<wrap*/user
    /*<where*/ where
        /*id?*/id = /*$=:id*/1
        /*name??*/and name like /*$=:name*/'name'
        /*gender??*/ and gender = /*$=:gender*/1
        /*<?*/ and
        (
            /*??*/ username = /*$=:username*/'admin'
            /*??*/ or email = /*$=:email*/'featherfly@foxmail.com'
            /*??*/ or mobile = /*$=:mobile*/13212345678
        )
        /*>?*/
    /*>where*/
    
    -- 另一种写法
    
    select /*#prop $*/*
    from /*#wrap*/user
    /*<where*/ where
        /*id?*/id = /*$=?*/1
        /*name??*/and name like /*$=?*/'name'
        /*gender?*/ and gender = /*$=?*/1
        /*<?*/ and
            (
            /*username??*/ username = /*$=?*/'admin'
            /*email??*/ or email = /*$=?*/'featherfly@foxmail.com'
            /*mobile??*/ or mobile_no = /*$=?*/'13212345678'
            )
        /*>?*/
    /*>where*/
    
    -- include模板
    <@tpl id='roleFromTemplate2' namespace='tpl/role_common'/>
    select /*#prop $*/ *
        /*@ roleFromTemplate*/
        
    select count(*)
        /*@ roleFromTemplate tpl/role_common*/
        
    -- roleFromTemplate
    from /*<<wrap*/ role
    /*<where*/ where
    /*name??*/ name like :name
    /*>where*/
```

- [ ] ~~定制专门为dml准备的简单模板实现，让模板sql更简洁更接近原生sql~~（已经以预编译的形式实现了特化模板，此项暂时不考虑，后续需要性能优化时再考虑）

## 优化

- [ ] 为模板sql查询返回加入映射配置，能够对每一个返回值进行精确的类型映射（不用在handle manager 里查找）

- [x] 优化NestedBeanPropertyRowMapper在查询列表时，只进行一次类型检测和映射元数据，后续的都使用映射元数据结果直接进行赋值（相当于预编译的概念）

- [ ] 优化SingleColumnRowMapper在查询列表时，只进行一次类型检测和映射元数据，后续的都使用映射元数据结果直接进行赋值（相当于预编译的概念）

- [ ] ~~预编译把参数都编译为?，然后把参数映射加入Config内对应的paramMap映射paramName <--> paramIndex~~（因为使用了命名sql转换时的in支持，所以这条暂时搁置）

- [ ] ~~dsl的链式调用考虑是否需要重构，在每次方法调用后返回新对象，这样做方法调用就没有任何副作用（低优先级，暂时不考虑）~~

## 为云原生GraalVM打包原生应用的相关支持

- [ ] 加入mapper的编译期织入支持

- [ ] dslapi的SerialFunction如果GraalVM不支持，则加入编译期转换功能