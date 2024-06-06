
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-29 02:42:29
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import cn.featherfly.common.exception.NotImplementedException;
import cn.featherfly.common.repository.Params;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.common.structure.page.SimplePage;
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.config.HammerConfigImpl;
import cn.featherfly.hammer.config.cache.CacheConfigImpl;
import cn.featherfly.hammer.sqldb.jdbc.SimpleSqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.User2;
import cn.featherfly.hammer.sqldb.tpl.SqlTplExecutor;
import cn.featherfly.hammer.sqldb.tpl.freemarker.SqldbFreemarkerTemplateEngine;
import cn.featherfly.hammer.tpl.TplExecutor;
import cn.featherfly.hammer.tpl.TransverterManager;

/**
 * The Class TplQueryCacheTest.
 *
 * @author zhongj
 */

public class TplQueryCacheTest extends AbstractQueryCacheTest {

    /**
     * {@inheritDoc}
     */
    @Override
    @Test
    public void queryPagination_CountCache() {
        HammerConfig hammerConfig = new HammerConfigImpl(true)
            .setCacheConfig(new CacheConfigImpl().setQueryPageResultCache(queryPageResultCache));
        hammerConfig.getQueryConfig().setCachePageResults(false);

        // 使用局部变量，不能覆盖成员变量executor
        TplExecutor executor = new SqlTplExecutor(hammerConfig, configFactory2,
            new SqldbFreemarkerTemplateEngine(configFactory2, hammerConfig.getTemplateConfig()), jdbc, mappingFactory,
            new SimpleSqlPageFactory(), new TransverterManager());

        SimplePage page = new SimplePage();
        page.setSize(2);
        page.setNumber(1);

        Limit limit = null;

        PaginationResults<User2> results = null;

        results = executor.pagination("queryUser", User2.class, Params.setParam("age", 0), page);
        assertEquals(results.getPageResults().size(), page.getSize());
        assertEquals(results.getPageResults().get(0).getId(), 1);
        assertTrue(queryPageResultCache.getIndex() == 0);
        assertNull(queryPageResultCache.getLast());

        page.setNumber(2);
        limit = new Limit(page);
        results = executor.pagination("queryUser", User2.class, Params.setParam("age", 0), page);
        assertEquals(results.getPageResults().size(), page.getSize());
        assertEquals(results.getPageResults().get(0).getId(), 3);
        assertEquals(results.getTotal(), queryPageResultCache.getLast().getTotal());
        assertTrue(queryPageResultCache.getIndex() == 1);
        assertNull(queryPageResultCache.getLast().getPageList(limit.getOffset()));

        page.setNumber(3);
        limit = new Limit(page);
        results = executor.pagination("queryUser", User2.class, Params.setParam("age", 0), page);
        assertEquals(results.getPageResults().size(), page.getSize());
        assertEquals(results.getPageResults().get(0).getId(), 5);
        assertEquals(results.getTotal(), queryPageResultCache.getLast().getTotal());
        assertTrue(queryPageResultCache.getIndex() == 2);
        //assertNull(queryPageResultCache.getLast().getPageList(limit.getOffset()));

        // skip 2 page
        page.setNumber(5);
        limit = new Limit(page);
        results = executor.pagination("queryUser", User2.class, Params.setParam("age", 0), page);
        assertEquals(results.getPageResults().size(), page.getSize());
        assertEquals(results.getPageResults().get(0).getId(), 9);
        assertEquals(results.getTotal(), queryPageResultCache.getLast().getTotal());
        assertTrue(queryPageResultCache.getIndex() == 3);
        //assertNull(queryPageResultCache.getLast().getPageList(limit.getOffset()));

        // ----------------------------------------------------------------------------------------------------------------

        page.setNumber(1);
        results = executor.pagination("queryUser", User2.class, Params.setParam("age", 5), page);
        assertEquals(results.getPageResults().size(), page.getSize());
        assertTrue(queryPageResultCache.getIndex() == 0);

        page.setNumber(2);
        results = executor.pagination("queryUser", User2.class, Params.setParam("age", 5), page);
        assertEquals(results.getPageResults().size(), page.getSize());
        assertTrue(queryPageResultCache.getIndex() == 1);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Test
    public void queryPagination_CountCache_PageListCache() {
        SimplePage page = new SimplePage();
        page.setSize(2);
        page.setNumber(1);

        PaginationResults<User2> results = null;

        Limit limit = null;

        results = executor.pagination("queryUser", User2.class, Params.setParam("age", 0), page);
        assertEquals(results.getPageResults().size(), page.getSize());
        assertEquals(results.getPageResults().get(0).getId(), 1);
        assertTrue(queryPageResultCache.getIndex() == 0);
        assertNull(queryPageResultCache.getLast());

        page.setNumber(2);
        limit = new Limit(page);
        results = executor.pagination("queryUser", User2.class, Params.setParam("age", 0), page);
        assertEquals(results.getPageResults().size(), page.getSize());
        assertEquals(results.getPageResults().get(0).getId(), 3);
        assertEquals(results.getTotal(), queryPageResultCache.getLast().getTotal());
        assertTrue(queryPageResultCache.getIndex() == 1);
        assertEquals(queryPageResultCache.getLast().getPageList(limit.getOffset()), results.getPageResults());

        page.setNumber(3);
        limit = new Limit(page);
        results = executor.pagination("queryUser", User2.class, Params.setParam("age", 0), page);
        assertEquals(results.getPageResults().size(), page.getSize());
        assertEquals(results.getPageResults().get(0).getId(), 5);
        assertEquals(results.getTotal(), queryPageResultCache.getLast().getTotal());
        assertTrue(queryPageResultCache.getIndex() == 2);
        assertEquals(queryPageResultCache.getLast().getPageList(limit.getOffset()), results.getPageResults());

        // skip 2 page
        page.setNumber(5);
        limit = new Limit(page);
        results = executor.pagination("queryUser", User2.class, Params.setParam("age", 0), page);
        assertEquals(results.getPageResults().size(), page.getSize());
        assertEquals(results.getPageResults().get(0).getId(), 9);
        assertEquals(results.getTotal(), queryPageResultCache.getLast().getTotal());
        assertTrue(queryPageResultCache.getIndex() == 3);
        assertEquals(queryPageResultCache.getLast().getPageList(limit.getOffset()), results.getPageResults());

        // ----------------------------------------------------------------------------------------------------------------

        page.setNumber(1);
        results = executor.pagination("queryUser", User2.class, Params.setParam("age", 5), page);
        assertEquals(results.getPageResults().size(), page.getSize());
        assertTrue(queryPageResultCache.getIndex() == 0);

        page.setNumber(2);
        results = executor.pagination("queryUser", User2.class, Params.setParam("age", 5), page);
        assertEquals(results.getPageResults().size(), page.getSize());
        assertTrue(queryPageResultCache.getIndex() == 1);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Test(dependsOnMethods = "queryPagination_CountCache_PageListCache")
    public void queryPagination_CountCache_OptimizationPage() { // without page list cache
        // NOIMPL 后续来实现
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Test
    public void queryPagination_CountCache_OptimizationPage_PageNumber_Gt_MaxPageNumber() {
        // NOIMPL 后续来实现
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Test
    public void queryPagination_CountCache_OptimizationPage_Find_Empty() {
        // NOIMPL 后续来实现
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Test(dependsOnMethods = "queryPagination_CountCache_PageListCache")
    public void queryPagination_CountCache_PageListCache_OptimizationPage() {
        // NOIMPL 后续来实现
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Test
    public void queryPagination() { // without CountCache
        HammerConfig hammerConfig = new HammerConfigImpl(true);
        hammerConfig.getQueryConfig().setCachePageCount(false);

        // 使用局部变量，不能覆盖成员变量executor
        TplExecutor executor = new SqlTplExecutor(hammerConfig, configFactory2,
            new SqldbFreemarkerTemplateEngine(configFactory2, hammerConfig.getTemplateConfig()), jdbc, mappingFactory,
            new SimpleSqlPageFactory(), new TransverterManager());

        SimplePage page = new SimplePage();
        page.setSize(2);
        page.setNumber(1);

        PaginationResults<User2> results = null;
        results = executor.pagination("queryUser", User2.class, Params.setParam("age", 0), page);
        // IMPLSOON 后续加入调用方法时，传入相关的配置信息
        assertEquals(results.getPageResults().size(), page.getSize());
        assertTrue(queryPageResultCache.getIndex() == 0);

        page.setNumber(2);
        results = executor.pagination("queryUser", User2.class, Params.setParam("age", 0), page);
        assertEquals(results.getPageResults().size(), page.getSize());
        assertTrue(queryPageResultCache.getIndex() == 0);

        page.setNumber(3);
        results = executor.pagination("queryUser", User2.class, Params.setParam("age", 0), page);
        assertEquals(results.getPageResults().size(), page.getSize());
        assertTrue(queryPageResultCache.getIndex() == 0);

        page.setNumber(4);
        results = executor.pagination("queryUser", User2.class, Params.setParam("age", 0), page);
        assertEquals(results.getPageResults().size(), page.getSize());
        assertTrue(queryPageResultCache.getIndex() == 0);

        // ----------------------------------------------------------------------------------------------------------------

        page.setNumber(1);
        results = executor.pagination("queryUser", User2.class, Params.setParam("age", 5), page);
        assertEquals(results.getPageResults().size(), page.getSize());
        assertTrue(queryPageResultCache.getIndex() == 0);

        page.setNumber(2);
        results = executor.pagination("queryUser", User2.class, Params.setParam("age", 5), page);
        assertEquals(results.getPageResults().size(), page.getSize());
        assertTrue(queryPageResultCache.getIndex() == 0);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Test
    public void queryList_OptimizationPage() {
        // NOIMPL 后续来实现
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Test
    public void queryList_PageListCache() {
        // NOIMPL 后续来实现
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Test
    public void queryList_PageListCache_OptimizationPage() {
        // NOIMPL 后续来实现
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Test
    public void queryList_OptimizationPage_PageNumber_Gt_MaxPageNumber() {
        // NOIMPL 后续来实现
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Test
    public void queryList_OptimizationPage_Find_Empty() {
        // NOIMPL 后续来实现
        throw new NotImplementedException();
    }

}
