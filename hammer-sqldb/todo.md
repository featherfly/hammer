- [ ] 优化page查询，缓存total_size，在相同查询条件下，使用缓存的total_size
- [ ] FIXME Mapper参数是原始类型（int,long）会出现错误，需要在生成的类内部转换为包装类型
- [ ] 所有的数据库操作，都应该使用SqlTypeMappingManager来进行数据转换操作，为了实现自定义类型的存储和读取
                    目前dsl的update,delete,orm的save,update,delete都已经实现，查询操作还未实现
- [ ] dsl的链式调用考虑是否需要使用链表结构重构实现内容
