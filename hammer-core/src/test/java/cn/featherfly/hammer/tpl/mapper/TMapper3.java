
package cn.featherfly.hammer.tpl.mapper;

import java.util.List;

import cn.featherfly.hammer.HammerSupport;
import cn.featherfly.hammer.annotation.Mapper;
import cn.featherfly.hammer.annotation.Template;

/**
 * TestMapper.
 *
 * @author zhongj
 */
@Mapper
public interface TMapper3 extends HammerSupport {

    @Template("getGtAge")
    List<User> getGtAge(int age);

}
