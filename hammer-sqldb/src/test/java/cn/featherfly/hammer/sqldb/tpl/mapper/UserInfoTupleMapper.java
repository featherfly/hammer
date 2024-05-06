
package cn.featherfly.hammer.sqldb.tpl.mapper;

import java.util.List;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.structure.page.Page;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.annotation.Mapper;
import cn.featherfly.hammer.annotation.Param;
import cn.featherfly.hammer.annotation.ParamType;
import cn.featherfly.hammer.annotation.Template;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.UserInfo;

/**
 * UserInfoMapper.
 *
 * @author zhongj
 */
@Mapper(namespace = "user_info")
public interface UserInfoTupleMapper extends Hammer {

    Tuple2<UserInfo, User> selectUserInfoByUserId(@Param("userId") Integer userId);

    List<Tuple2<UserInfo, User>> selectUserInfoAndUserList();

    List<Tuple2<UserInfo, User>> selectUserInfoAndUserList(Page page);

    List<Tuple2<UserInfo, User>> selectUserInfoAndUserList(@Param(type = ParamType.PAGE_OFFSET) int offset,
            @Param(type = ParamType.PAGE_LIMIT) int limit);

    @Template(name = "selectUserInfoAndUserList")
    PaginationResults<Tuple2<UserInfo, User>> selectUserInfoAndUserPage(Page page);

    @Template(name = "selectUserInfoAndUserList")
    PaginationResults<Tuple2<UserInfo, User>> selectUserInfoAndUserPage(@Param(type = ParamType.PAGE_OFFSET) int offset,
            @Param(type = ParamType.PAGE_LIMIT) int limit);

}
