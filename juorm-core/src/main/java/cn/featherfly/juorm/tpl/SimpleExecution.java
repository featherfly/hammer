
package cn.featherfly.juorm.tpl;

import cn.featherfly.common.lang.AssertIllegalArgument;

/**
 * <p>
 * 简单查询
 * </p>
 *
 * @author zhongj
 */
public class SimpleExecution implements Execution {

    private String execute;

    private Object[] params;

    /**
     * @param execute execute string
     * @param params  params
     */
    public SimpleExecution(String execute, Object... params) {
        AssertIllegalArgument.isNotEmpty(execute, "execute string不能为空");
        this.execute = execute;
        this.params = params;
    }

    /**
     * 返回params
     *
     * @return params
     */
    @Override
    public Object[] getParams() {
        return params;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getExecute() {
        return execute;
    }
}
