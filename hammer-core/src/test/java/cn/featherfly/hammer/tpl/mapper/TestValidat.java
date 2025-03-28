
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2025-03-28 15:01:28
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.tpl.mapper;

import javax.annotation.Nonnull;

import cn.featherfly.common.lang.AssertIllegalArgument;

/**
 * T.
 *
 * @author zhongj
 */
public interface TestValidat {
    default void hello(@Nonnull String name) {
        System.out.println("hello " + name);
    }
}

class TestValidatImpl implements TestValidat {

    @Override
    public void hello(String name) {
        AssertIllegalArgument.isNotNull(name, "name");
        TestValidat.super.hello(name);
    }

    public static void main(String[] args) {
        new TestValidatImpl().hello(null);
    }
}
