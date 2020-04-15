***

## Hammer是什么？

`Hammer` 是一款 orm 框架，集成了常见的 orm 操作模式，用于解决不同的应用场景。   
因为每一种模式适合的场景不一致，而且每个项目都会出现这些场景，只是出现的比例不同，所以使用某一种框架在其不擅长场景都会比较麻烦。

## 框架概述

-   对象记录映射(object recored mapping)： 支持基于对象的数据记录映射（类似 hibernate,但不支持级联操作）
-   DSL 模式操作：支持基于 DSL 模式的 API 进行更新,删除,查询数据操作（类似 QueryDSL）
-   模板 DML 查询：支持基于模板的 DML 拼接进行查询操作，可以使复杂查询更直观（类似 mybatis）

## 支持的数据存储

- [√] 关系型数据库(基于 jdbc) [**`hammer-sqldb的文档`**](./hammer-sqldb/README.md)
- [ ] mongodb 敬请期待....
- [ ] elasitcserach 敬请期待....
