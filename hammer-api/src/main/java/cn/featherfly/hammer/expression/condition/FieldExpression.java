//
///*
// * All rights Reserved, Designed By zhongj
// * @Description:
// * @author: zhongj
// * @date: 2023-12-01 17:21:01
// * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
// */
//package cn.featherfly.hammer.expression.condition;
//
//import java.util.Date;
//
//import cn.featherfly.common.repository.Field;
//import cn.featherfly.hammer.expression.condition.field.DateFieldExpression;
//import cn.featherfly.hammer.expression.condition.field.EnumFieldExpression;
//import cn.featherfly.hammer.expression.condition.field.LocalDateFieldExpression;
//import cn.featherfly.hammer.expression.condition.field.LocalDateTimeFieldExpression;
//import cn.featherfly.hammer.expression.condition.field.LocalTimeFieldExpression;
//import cn.featherfly.hammer.expression.condition.field.NumberFieldExpression;
//import cn.featherfly.hammer.expression.condition.field.SerializableFieldExpression;
//import cn.featherfly.hammer.expression.condition.field.StringFieldExpression;
//
///**
// * field expression.
// *
// * @author zhongj
// * @param <C> the generic type
// * @param <L> the generic type
// */
//public interface FieldExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
//        extends ConditionExpression {
//
//    /**
//     * field.
//     *
//     * @param name the name
//     * @return the object expression
//     */
//    SerializableFieldExpression<C, L> field(String name);
//
//    /**
//     * Field as string.
//     *
//     * @param name the name
//     * @return the string expression
//     */
//    StringFieldExpression<C, L> fieldAsString(String name);
//
//    /**
//     * Field as number.
//     *
//     * @param <N>  the number type
//     * @param name the name
//     * @return the number expression
//     */
//    <N extends Number> NumberFieldExpression<N, C, L> fieldAsNumber(String name);
//
//    /**
//     * Field as enum.
//     *
//     * @param <R>  the generic type
//     * @param name the name
//     * @return the enum expression
//     */
//    <R extends Enum<R>> EnumFieldExpression<R, C, L> fieldAsEnum(String name);
//
//    /**
//     * Field as date.
//     *
//     * @param <D>  the generic type
//     * @param name the name
//     * @return the date expression
//     */
//    <D extends Date> DateFieldExpression<D, C, L> fieldAsDate(String name);
//
//    /**
//     * Field as local date.
//     *
//     * @param name the name
//     * @return the date expression
//     */
//    LocalDateFieldExpression<C, L> fieldAsLocalDate(String name);
//
//    /**
//     * Field as local date time.
//     *
//     * @param name the name
//     * @return the date expression
//     */
//    LocalDateTimeFieldExpression<C, L> fieldAsLocalDateTime(String name);
//
//    /**
//     * Field as local time.
//     *
//     * @param name the name
//     * @return the date expression
//     */
//    LocalTimeFieldExpression<C, L> fieldAsLocalTime(String name);
//
//    /**
//     * field.
//     *
//     * @param field the field
//     * @return the object expression
//     */
//    default SerializableFieldExpression<C, L> field(Field field) {
//        return field(field.name());
//    }
//
//    /**
//     * Field as string.
//     *
//     * @param field the field
//     * @return the string expression
//     */
//    default StringFieldExpression<C, L> fieldAsString(Field field) {
//        return fieldAsString(field.name());
//    }
//
//    /**
//     * Field as number.
//     *
//     * @param <N>   the number type
//     * @param field the field
//     * @return the number expression
//     */
//    default <N extends Number> NumberFieldExpression<N, C, L> fieldAsNumber(Field field) {
//        return fieldAsNumber(field.name());
//    }
//
//    /**
//     * Field as enum.
//     *
//     * @param <R>   the generic type
//     * @param field the field
//     * @return the enum expression
//     */
//    default <R extends Enum<R>> EnumFieldExpression<R, C, L> fieldAsEnum(Field field) {
//        return fieldAsEnum(field.name());
//    }
//
//    /**
//     * Field as date.
//     *
//     * @param <D>   the generic type
//     * @param field the field
//     * @return the date expression
//     */
//    default <D extends Date> DateFieldExpression<D, C, L> fieldAsDate(Field field) {
//        return fieldAsDate(field.name());
//    }
//
//    /**
//     * Field as local date.
//     *
//     * @param field the field
//     * @return the date expression
//     */
//    default LocalDateFieldExpression<C, L> fieldAsLocalDate(Field field) {
//        return fieldAsLocalDate(field.name());
//    }
//
//    /**
//     * Field as local date time.
//     *
//     * @param field the field
//     * @return the date expression
//     */
//    default LocalDateTimeFieldExpression<C, L> fieldAsLocalDateTime(Field field) {
//        return fieldAsLocalDateTime(field.name());
//    }
//
//    /**
//     * Field as local time.
//     *
//     * @param field the field
//     * @return the date expression
//     */
//    default LocalTimeFieldExpression<C, L> fieldAsLocalTime(Field field) {
//        return fieldAsLocalTime(field.name());
//    }
//}