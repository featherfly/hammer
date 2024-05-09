
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
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.tpl.TplExecuteIdEmailStyleParser;
import cn.featherfly.hammer.tpl.TplExecuteIdFileImpl;
import cn.featherfly.hammer.tpl.TplExecuteIdParser;

/**
 * TuplesMapperImpl.
 *
 * @author zhongj
 */
public class TuplesMapperImpl extends BasedTplHammer implements TuplesMapper {

    protected final TplExecuteIdParser parser = new TplExecuteIdEmailStyleParser();

    /**
     * @param hammer
     */
    public TuplesMapperImpl(Hammer hammer, HammerConfig hammerConfig) {
        super(hammer, hammerConfig);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Tuple2<User, User2> selectUserInfoByUserId(Integer userId) {
        return hammer.template().single(new TplExecuteIdFileImpl("selectUserInfoByUserId", "TuplesMapper", parser),
                User.class, User2.class, new ChainMapImpl<String, Object>().putChain("userId", userId));
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
