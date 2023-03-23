
/*
 * All rights Reserved, Designed By zhongj
 * @Title: TuplesMapperImpl.java
 * @Package cn.featherfly.hammer.tpl.mapper
 * @Description: TuplesMapperImpl
 * @author: zhongj
 * @date: 2023-03-23 15:03:23
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.tpl.mapper;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.structure.ChainMapImpl;
import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.tpl.TplExecuteIdFileImpl;

/**
 * TuplesMapperImpl.
 *
 * @author zhongj
 */
public class TuplesMapperImpl extends BasedTplHammer implements TuplesMapper {

    /**
     * @param hammer
     */
    public TuplesMapperImpl(Hammer hammer) {
        super(hammer);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Tuple2<User, User2> selectUserInfoByUserId(Integer userId) {
        return hammer.single(new TplExecuteIdFileImpl("selectUserInfoByUserId", "TuplesMapper"), User.class,
                User2.class, new ChainMapImpl<String, Object>().putChain("userId", userId));
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public List<Tuple2<User, User2>> selectUserInfoAndUserList() {
    //        return hammer.list(new TplExecuteIdFileImpl("selectUserInfoAndUserList", "TuplesMapper"), User.class,
    //                User2.class, new ChainMapImpl<String, Object>());
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public PaginationResults<Tuple2<User, User2>> selectUserInfoAndUserPage(Page page) {
    //        return hammer.pagination(new TplExecuteIdFileImpl("selectUserInfoAndUserList", "TuplesMapper"), User.class,
    //                User2.class, new ChainMapImpl<String, Object>(), page);
    //    }

}
