
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-11 01:06:11
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.tpl;

/**
 * TplExecuteIdParser.
 *
 * @author zhongj
 */
public interface TplExecuteIdParser {

    /**
     * Gets the separator.
     *
     * @return the separator
     */
    String getSeparator();

    /**
     * Parses tplExecuteId str.
     *
     * @param tplExecuteId the tpl execute id
     * @return the tpl execute id
     */
    TplExecuteId parse(String tplExecuteId);

    /**
     * Format TplExecuteId to str.
     *
     * @param tplExecuteId the tpl execute id
     * @return the string
     */
    default String format(TplExecuteId tplExecuteId) {
        return format(tplExecuteId.getName(), tplExecuteId.getNamespace());
    }

    /**
     * Format TplExecuteId to str.
     *
     * @param name      the name
     * @param namespace the namespace
     * @return the string
     */
    String format(String name, String namespace);
}
