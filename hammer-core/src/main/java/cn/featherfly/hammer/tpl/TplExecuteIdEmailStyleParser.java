
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-11 01:08:11
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.tpl;

import cn.featherfly.common.lang.Lang;

/**
 * email style parser for TplExecuteId. <br>
 * such as name@namespace has the same style as username@domain. <br>
 * If it does not contain @, the TplExecuteId does not contain a namespace.
 *
 * @author zhongj
 */
public class TplExecuteIdEmailStyleParser implements TplExecuteIdParser {

    private static final String SEPARATOR = "@";

    /**
     * {@inheritDoc}
     */
    @Override
    public String getSeparator() {
        return SEPARATOR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TplExecuteId parse(String tplExecuteId) {
        String[] args = tplExecuteId.split(SEPARATOR);
        if (args.length == 2) {
            String name = args[0];
            String namespace = args[1];
            return new TplExecuteIdImpl(name, namespace, this);
        } else {
            return new TplExecuteIdImpl(tplExecuteId, this);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String format(String name, String namespace) {
        if (Lang.isEmpty(namespace)) {
            return name;
        } else {
            return name + SEPARATOR + namespace;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "TplExecuteIdEmailStyleParser [name" + getSeparator() + "namepsace]";
    }
}
