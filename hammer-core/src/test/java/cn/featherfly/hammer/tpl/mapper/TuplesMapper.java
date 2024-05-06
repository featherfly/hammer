
package cn.featherfly.hammer.tpl.mapper;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.annotation.Mapper;
import cn.featherfly.hammer.annotation.Param;

/**
 * The Interface TuplesMapper.
 *
 * @author zhongj
 */
@Mapper
public interface TuplesMapper {

    Tuple2<User, User2> selectUserInfoByUserId(@Param("userId") Integer userId);

    //    List<Tuple2<User, User2>> selectUserInfoAndUserList();
    //
    //    @Template(name = "selectUserInfoAndUserList")
    //    PaginationResults<Tuple2<User, User2>> selectUserInfoAndUserPage(Page page);
}
