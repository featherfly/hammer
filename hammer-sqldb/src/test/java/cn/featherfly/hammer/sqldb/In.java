
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2025-03-28 18:41:28
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb;

import java.util.Iterator;
import java.util.List;

import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.InterceptionExecution;
import cn.featherfly.hammer.sqldb.In.Invoker;
import cn.featherfly.hammer.sqldb.jdbc.JdbcExecution;
import cn.featherfly.hammer.sqldb.jdbc.JdbcExecutionInterceptor;

/**
 * In.
 *
 * @author zhongj
 */
public interface In<E extends InterceptionExecution> {

    void intercept(Invoker<E> invoker, E execution);

    public interface Invoker<E extends InterceptionExecution> {
        void invoke(E execution);
    }

}

class InvokerImpl<E extends InterceptionExecution> implements Invoker<E> {

    private List<In<E>> ins;

    private Iterator<In<E>> iter;

    /**
     * @param ins
     */
    public InvokerImpl(List<In<E>> ins) {
        super();
        this.ins = ins;
    }

    @Override
    public void invoke(E execution) {
        In<E> interceptor = get();
        if (interceptor != null) {
            interceptor.intercept(this, execution);
        }
    }

    private In<E> get() {
        if (iter == null) {
            iter = ins.iterator();
        }

        if (iter.hasNext()) {
            return iter.next();
        }

        iter = null;
        return null;
    }

    public static void main(String[] args) {
        In<JdbcExecution> in1 = (invoker, execution) -> {
            System.out.println("before invoke 1");
            invoker.invoke(execution);
            System.out.println("after invoke 1");
        };

        In<JdbcExecution> in2 = (invoker, execution) -> {
            System.out.println("before invoke 2");
            invoker.invoke(execution);
            System.out.println("after invoke 2");
        };

        JdbcExecutionInterceptor interceptor = new JdbcExecutionInterceptor() {

            @Override
            public void preHandle(JdbcExecution execution) throws JdbcException {
                System.out.println("JdbcExecutionInterceptor preHandle");
            }

            @Override
            public void postHandle(JdbcExecution execution) throws JdbcException {
                System.out.println("JdbcExecutionInterceptor postHandle");
            }
        };

        In<JdbcExecution> in3 = (invoker, execution) -> {
            System.out.println("before invoke 3");
            interceptor.preHandle(execution);
            invoker.invoke(execution);
            System.out.println("after invoke 3");
            interceptor.postHandle(execution);
        };

        InvokerImpl<JdbcExecution> invoker = new InvokerImpl(Lang.list(in1, in2, in3));

        invoker.invoke(null);
    }
}
