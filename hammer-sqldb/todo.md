## 新功能

- [ ] 对象映射加入动态表名

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

- [ ] 加入一次交互完成锁查询、修改，并返回修改后的结果的功能

- [ ] 加入@Execution（@Sql）注解，用于非模板执行字符串（sql，json等）的直接运行，并去掉@Template的isTemplate方法（需要处理字节码动态加载）

- [x] dsl条件查询eq(SerialFunction<T, R>, T),ne(SerialFunction<T, R> t)方法支持@Embedded对象，自动使用该对象的所有非空属性（参考eq(SerializableSupplier<R>),ne(SerializableSupplier<R>)支持@Embedded对象的实现）

- [x] dsl api where() 加入查询参数的忽略规则的配置

  > 例如

  ```
  where(c -> c.setIgnorePolity(IgnorePolity.EMPTY)).eq ....
  where().setIgnorePolity(IgnorePolity.EMPTY).eq ....
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
- [x] dsl api 条件查询加入表达式支持，（例如 store - :outNum >= 0[这种可以用传入的参数名用一个特殊的类来处理]， u.id = ur.user_id[这种可以用传入的value以一个特殊类来处理，表示传入的是需要拼接的字符串，不需要用占位符]）
- [x] dsl api （eq,ne,co,sw,ew,lk）加入查询大小写敏感的支持（即 = 和 like 支持区分大小写）
- [ ] dsl api 加入gourp by和having支持 

  ```sql
  SELECT m.`name` mn, count(model_id) num FROM `smoking_facility` s 
      join smoking_facility_model m on s.model_id = m.id
  where s.id > 1
  group by mn
  having num > 20
  ```

- [ ] dsl api 强类型全局支持

    1.查询的数据泛型要在启动那时候就确定（例如query(User.class).list()或.single() 这个list方法的泛型参数一定是User）
    2.条件查询中的SerializableFunction中的实体类型泛型需要和启动时(query,udpate,delete)绑定的类一致 

- [ ] dsl api with(SerializableFunction<T, R>, int) 重构为 with(SerializableFunction<T, R>,  Consumer<T extends Tuple>) Tuple(x)根据前面with的调用次数来确定（即x= with调用次数+1，因为可以join find的对象, 所以需要+1), StringConditionExpression加入expression( ...  ,  Consumer<T extends Tuple>)能获取Tuple的重载方法
  
- [ ] 查询返回支持Map支持多对象映射
    map的key为别名,value为映射对象
  > 例如

  ```
  select u.name,u.age, r.name from ....

  Map<String,Object> userRoleMap = 
  List<Map<String,Object>> userRoleMapList =     

  User user = userRoleMap.get("u")
  Role role = userRoleMap.get("r");
  ```

- [ ] 查询返回支持Tuple
    类似Map，但是可以支持强类型，因为是强类型，所以返回数据的个数要与Tuple对象的个数匹配

  > 例如

  ```
  select u.name, u.age from ....
    
  Tuple2<String,Integer> userTuple = 
  List<Tuple2<String,Integer>> userTupleList =     
    
  String name = userTuple.get0()
  Integer age = userTuple.get1();
  ```

  

  > 如果是多个对象类型，则对象的顺序以别名的顺序为准，例如

  ```
  select u.name,u.age, r.name from ....
    
  Tuple2<User,Role> userRoleTuple = 
  List<Tuple2<User,Role>> userRoleTupleList =     
    
  User user = userRoleTuple.get0()
  Role role = userRoleTuple.get1();
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

- [ ] ~~定制专门为dml准备的简单模板实现，让模板sql更简洁更接近原生sql~~（已经以预编译的形式实现了特化模板，此项暂时不考虑）

## 优化

- [x] 优化NestedBeanPropertyRowMapper在查询列表时，只进行一次类型检测和映射元数据，后续的都使用映射元数据结果直接进行赋值（相当于预编译的概念）

- [ ] 优化SingleColumnRowMapper在查询列表时，只进行一次类型检测和映射元数据，后续的都使用映射元数据结果直接进行赋值（相当于预编译的概念）

- [ ] ~~预编译把参数都编译为?，然后把参数映射加入Config内对应的paramMap映射paramName <--> paramIndex~~（因为使用了命名sql转换时的in支持，所以这条暂时搁置）

- [ ] ~~dsl的链式调用考虑是否需要重构，在每次方法调用后返回新对象，这样做方法调用就没有任何副作用（低优先级，暂时不考虑）~~

## 为云原生GraalVM打包原生应用的相关支持

- [ ] 加入mapper的编译期织入支持

- [ ] dslapi的SerialFunction如果GraalVM不支持，则加入编译期转换功能