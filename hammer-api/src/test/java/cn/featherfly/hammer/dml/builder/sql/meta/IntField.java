
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-10 16:02:10
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dml.builder.sql.meta;

import cn.featherfly.common.repository.Field;

/**
 * IntField.
 *
 * @author zhongj
 */
public interface IntField extends Field {

    void eq(int value);

    void ne(int value);

    void ge(int value);

    void gt(int value);

    void le(int value);

    void lt(int value);

    void in(int... values);

    void nin(int... values);
}
