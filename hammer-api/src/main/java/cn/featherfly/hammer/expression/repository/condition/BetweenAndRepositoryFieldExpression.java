
package cn.featherfly.hammer.expression.repository.condition;

import java.util.Date;

import cn.featherfly.hammer.expression.condition.field.value.SetDateExpression2;
import cn.featherfly.hammer.expression.condition.field.value.SetDoubleExpression2;
import cn.featherfly.hammer.expression.condition.field.value.SetEnumExpression2;
import cn.featherfly.hammer.expression.condition.field.value.SetIntExpression2;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalDateExpression2;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalDateTimeExpression2;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalTimeExpression2;
import cn.featherfly.hammer.expression.condition.field.value.SetLongExpression2;
import cn.featherfly.hammer.expression.condition.field.value.SetNumberExpression2;
import cn.featherfly.hammer.expression.condition.field.value.SetStringExpression2;

/**
 * The Interface BetweenAndRepositoryFieldExpression.
 *
 * @author zhongj
 */
public interface BetweenAndRepositoryFieldExpression extends BetweenAndRepositoryExpression {

    //    /**
    //     * between and function property expression.
    //     *
    //     * @param <V>  the value type
    //     * @param name the name
    //     * @return entity great than function property expression.
    //     */
    //    <V extends Object> SetValueExpression2<V> field(String name); // ENHANCE 后续处理自定义类型，先用Object代替

    /**
     * between and function property expression.
     *
     * @param name the name
     * @return set between and values expression.
     */
    SetIntExpression2 fieldAsInt(String name);

    /**
     * between and function property expression.
     *
     * @param name the name
     * @return set between and values expression.
     */
    SetLongExpression2 fieldAsLong(String name);

    /**
     * entity between and function property expression.
     *
     * @param name the name
     * @return set between and values expression.
     */
    SetDoubleExpression2 fieldAsDouble(String name);

    /**
     * entity between and function property expression.
     *
     * @param <D>  the generic type
     * @param name the name
     * @return set between and values expression.
     */
    <D extends Date> SetDateExpression2<D> fieldAsDate(String name);

    /**
     * entity between and function property expression.
     *
     * @param name the name
     * @return set between and values expression.
     */
    SetLocalDateExpression2 fieldAsLocalDate(String name);

    /**
     * entity between and function property expression.
     *
     * @param name the name
     * @return set between and values expression.
     */
    SetLocalTimeExpression2 fieldAsLocalTime(String name);

    /**
     * entity between and function property expression.
     *
     * @param name the name
     * @return set between and values expression.
     */
    SetLocalDateTimeExpression2 fieldAsLocalDateTime(String name);

    /**
     * entity between and function property expression.
     *
     * @param <N>  the generic type
     * @param name the name
     * @return set between and values expression.
     */
    <N extends Number> SetNumberExpression2<N> fieldAsNumber(String name);

    /**
     * entity between and function property expression.
     *
     * @param <E>  the generic type
     * @param name the name
     * @return set between and values expression.
     */
    <E extends Enum<E>> SetEnumExpression2<E> fieldAsEnum(String name);

    /**
     * entity between and function property expression.
     *
     * @param name the name
     * @return set between and values expression.
     */
    SetStringExpression2 fieldAsString(String name);
}
