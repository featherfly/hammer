- [ ] 优化page查询，缓存total_size，在相同查询条件下，使用缓存的total_size
- [ ] 下一步是否需要在namedSql转换时候把in params进行相应的转换
- [x] 优化类型映射查询，自动处理处理返回List<Integer>,List<String>,List<Long>等单一属性列表，只要是manager支持的类型都行
- [x] 在模板查询中加入快捷的模糊查询，即在sql中的查询条件两边加入%，则可以实现对应的模糊查询
   1. ConditionManger中加入对应的逻辑
   2. 在and和or条件标签中加入标签属性，可以设置value的转换逻辑
   3. 预编译时把%value, value%, %value%转换为对应的and or条件标签时直接转换为and or的对应标签
- [x] FIXME Mapper参数是原始类型（int,long）会出现错误，需要在生成的类内部转换为包装类型
- [x] 所有的数据库操作，都应该使用SqlTypeMappingManager来进行数据转换操作，为了实现自定义类型的存储和读取
        目前dsl的update,delete,orm的save,update,delete都已经实现，查询操作还未实现
- [ ] dsl的链式调用考虑是否需要使用链表结构重构实现内容
- [ ] 模板文件加载器加入支持从不同文件后缀加载的实现(例如 .yaml.sql, .tpl.sql)
- [x] 可以先编写预编译程序，把下面定义的模板定义预编译为freemarker模板，后续再来实现自己的模板
- [ ] 预编译把参数都编译为?，然后把参数映射加入Config内对应的paramMap映射paramName <--> paramIndex
- [ ] 定制专门为dml准备的简单模板实现，让模板sql更简洁更接近原生sql
	先进行预编译
	1. 快捷实现的标签替换为标签对,例如`/*<<keyword*/user[\n ]`替换为`/*<keyword*/user/*>keyword*/[\n ]`
	2. 预编译替换替换掉，例如`mobile = /*$=:mobile*/13212345678[\n]`替换为`mobile = :mobile[\n]`
	3. 条件查询明确[if and or]并替换标签对，例如`/*id??*/id = ?[\n ]`替换为`/*<? id?*/id = ?/*>?*/[\n ]`,`/*name??*/and name = ?[\n ]`替换为`/*<and name??*/name = ?/*>and*/[\n ]`,`/*??*/ or email = ?[\n ]`替换为`/*<or email??*/email = ?/*>or*/[\n ]`
	4. 条件查询明确条件，例如`/*??*/ username = :username[\n ]`替换为`/*<? username??*/ username = :username/*>?*/[\n ]`
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
- [ ] TODO1
- [ ] TODO2
- [ ] TODO3
