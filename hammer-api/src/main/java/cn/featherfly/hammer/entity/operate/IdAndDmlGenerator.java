
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-16 00:14:16
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.entity.operate;

/**
 * IdGenerator.
 *
 * @author zhongj
 */
public interface IdAndDmlGenerator extends IdGenerator {

    /**
     * Dml field value.
     *
     * @return the string
     */
    String dmlFieldValue();

}
