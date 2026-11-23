
package cn.featherfly.hammer.tpl.mapper;

import java.util.List;

import javax.validation.constraints.NotNull;

import cn.featherfly.hammer.GenericHammer;
import cn.featherfly.hammer.annotation.Mapper;

/**
 * 用于回归测试：继承带泛型的 GenericHammer 并覆写重载的 update(User) 与
 * update(List&lt;User&gt;)。
 * <p>
 * 该场景会在 mapper 接口中产生 javac 生成的桥接方法 update(Object)，
 * 用于覆盖 TplDynamicExecutorFactory 对桥接方法和泛型重载方法的处理：
 * 实现类必须能正常生成并调用，不能出现 VerifyError/ClassCastException。
 * </p>
 * <p>
 * 注意：Bean Validation（HV）不允许对同名且参数个数相同的方法分别声明
 * 参数约束（会触发 HV000152 或把两个重载的约束合并），因此这里只在单个
 * 非重载方法 validate 上保留 {@code @NotNull}，用于验证校验字节码仍被正确生成。
 * </p>
 *
 * @author zhongj
 */
@Mapper
public interface OverloadUpdateMapper extends GenericHammer<User, Long> {

    @Override
    int update(@NotNull User entity);

    @Override
    int[] update(@NotNull List<User> entities);

    /** 单个带约束的方法，用于验证参数校验字节码仍然生成。 */
    default int validate(@NotNull User user) {
        return 0;
    }
}
