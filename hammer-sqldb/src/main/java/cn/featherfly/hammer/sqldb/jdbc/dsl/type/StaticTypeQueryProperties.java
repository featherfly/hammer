//
//package cn.featherfly.hammer.sqldb.jdbc.dsl.type;
//
//import cn.featherfly.common.db.mapping.JdbcMappingFactory;
//import cn.featherfly.hammer.sqldb.jdbc.dsl.query.SqlQueryEntity;
//
///**
// * <p>
// * TypeQueryEntity
// * </p>
// * .
// *
// * @author zhongj
// * @param <E> the element type
// * @param <C> the generic type
// * @param <Q> the generic type
// */
//public abstract class StaticTypeQueryProperties<E, C extends StaticTypeQueryConditionGroupExpression<E, C>,
//        Q extends StaticTypeQueryProperties<E, C, Q>> extends StaticTypeQueryEntity<E, C, Q> {
//
//    /** The query entity properties. */
//    private SqlQueryEntity queryEntity;
//
//    /**
//     * Instantiates a new type query properties.
//     *
//     * @param queryEntity    the query entity
//     * @param mappingFactory the mapping factory
//     */
//    public StaticTypeQueryProperties(SqlQueryEntity queryEntity, JdbcMappingFactory mappingFactory) {
//        super(queryEntity, mappingFactory);
//        this.queryEntity = queryEntity;
//    }
//
//    /**
//     * Property.
//     *
//     * @param propertyName the property name
//     * @return the q
//     */
//    @SuppressWarnings("unchecked")
//    public Q property(String propertyName) {
//        queryEntity.property(propertyName);
//        setProperty = true;
//        return (Q) this;
//    }
//
//    /**
//     * Property.
//     *
//     * @param columnName the column name
//     * @param asName     the as name
//     * @return the q
//     */
//    @SuppressWarnings("unchecked")
//    public Q property(String columnName, String asName) {
//        queryEntity.propertyAlias(columnName, asName);
//        setProperty = true;
//        return (Q) this;
//    }
//
//}
