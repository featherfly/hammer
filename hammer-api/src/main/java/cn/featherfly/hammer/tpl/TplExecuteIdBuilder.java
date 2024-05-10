
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-10 16:54:10
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.tpl;

/**
 * TplExecuteIdBuilder.
 *
 * @author zhongj
 */
public interface TplExecuteIdBuilder {

    /**
     * Name.
     *
     * @param  name the name
     * @return      the named execute id
     */
    NamedExecuteId name(String name);

    /**
     * The Interface NamedExecuteId.
     *
     * @author zhongj
     */
    public interface NamedExecuteId {

        /**
         * Namespace.
         *
         * @param  namespace the namespace
         * @return           the tpl execute id
         */
        TplExecuteId namespace(String namespace);
    }
}
