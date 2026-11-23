
package cn.featherfly.hammer.tpl.mapper;

import java.util.List;

import javax.validation.constraints.NotNull;

import cn.featherfly.hammer.HammerSupport;
import cn.featherfly.hammer.annotation.Mapper;

/**
 * 用于回归测试：继承 GenericHammerSupport 并定义重载的 update(User) 与
 * update(List&lt;User&gt;) default 方法。
 * <p>
 * 覆盖 TplDynamicExecutorFactory.validateForDefaultMethod 对同名重载方法的处理。
 * </p>
 * <p>
 * 注意：Bean Validation（HV）不允许对同名且参数个数相同的方法分别声明
 * 参数约束（会合并两个重载的约束），因此这里只在单个非重载方法 validate 上
 * 保留 {@code @NotNull}。
 * </p>
 *
 * @author zhongj
 */
@Mapper
public interface OverloadUpdateMapper4 extends HammerSupport {

    default int update(@NotNull User entity) {
        return 1;
    }

    default int update(@NotNull List<User> entities) {
        if (entities == null) {
            return 0;
        }
        return entities.size();
    }

    /** 单个带约束的方法，用于验证参数校验字节码仍然生成。 */
    default int validate(@NotNull User user) {
        return 0;
    }
}
