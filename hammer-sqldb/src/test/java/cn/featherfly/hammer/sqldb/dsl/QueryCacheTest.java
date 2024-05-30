
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

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.CacheEntryListenerConfiguration;
import javax.cache.configuration.Configuration;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.CreatedExpiryPolicy;
import javax.cache.expiry.Duration;
import javax.cache.integration.CompletionListener;
import javax.cache.processor.EntryProcessor;
import javax.cache.processor.EntryProcessorException;
import javax.cache.processor.EntryProcessorResult;
import javax.cache.spi.CachingProvider;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cn.featherfly.common.exception.NotImplementedException;
import cn.featherfly.common.repository.Params;
import cn.featherfly.common.repository.QueryPageResult;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.common.structure.page.SimplePage;
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.config.HammerConfigImpl;
import cn.featherfly.hammer.config.cache.CacheConfigImpl;
import cn.featherfly.hammer.sqldb.dsl.query.SqlQuery;
import cn.featherfly.hammer.sqldb.jdbc.JdbcTestBase;
import cn.featherfly.hammer.sqldb.jdbc.SimpleSqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.User2;
import cn.featherfly.hammer.sqldb.tpl.SqlTplExecutor;
import cn.featherfly.hammer.sqldb.tpl.freemarker.SqldbFreemarkerTemplateEngine;
import cn.featherfly.hammer.tpl.TplConfigFactoryImpl;
import cn.featherfly.hammer.tpl.TplExecutor;
import cn.featherfly.hammer.tpl.TransverterManager;
import cn.featherfly.hammer.tpl.freemarker.FreemarkerTemplatePreProcessor;

/**
 * QueryPaginationCacheTest.
 *
 * @author zhongj
 */

public class QueryCacheTest extends JdbcTestBase {

    SqlQuery query;

    CacheManager cacheManager;

    CacheProxy<Object, QueryPageResult> queryPageResultCache;

    protected TplExecutor executor;

    @BeforeClass
    void setup() {
        CachingProvider cachingProvider = Caching
            .getCachingProvider("com.github.benmanes.caffeine.jcache.spi.CaffeineCachingProvider");
        cacheManager = cachingProvider.getCacheManager();
        MutableConfiguration<Object,
            QueryPageResult> mutableConfiguration = new MutableConfiguration<Object, QueryPageResult>()
                .setTypes(Object.class, QueryPageResult.class) //
                .setStoreByValue(false) //
                .setExpiryPolicyFactory(CreatedExpiryPolicy.factoryOf(new Duration(TimeUnit.MINUTES, 30)));
        Cache<Object,
            QueryPageResult> countResultCache = cacheManager.createCache("countResultCache", mutableConfiguration);

        queryPageResultCache = new CacheProxy<>(countResultCache);

        // set cache
        HammerConfig hammerConfig = new HammerConfigImpl(true)
            .setCacheConfig(new CacheConfigImpl().setQueryPageResultCache(queryPageResultCache));

        query = new SqlQuery(jdbc, mappingFactory, sqlPageFactory, hammerConfig);

        configFactory = TplConfigFactoryImpl.builder() //
            .prefixes("tpl_pre/", "tpl_pre2/").suffixes(".yaml.sql", ".yaml.tpl")
            .config(hammerConfig.getTemplateConfig())
            .preCompile(new FreemarkerTemplatePreProcessor(hammerConfig.getTemplateConfig())).build();

        executor = new SqlTplExecutor(hammerConfig, configFactory,
            new SqldbFreemarkerTemplateEngine(configFactory, hammerConfig.getTemplateConfig()), jdbc, mappingFactory,
            new SimpleSqlPageFactory(), new TransverterManager());

    }

    @AfterClass
    void after() {
        cacheManager.close();
    }

    @BeforeMethod
    void bm() {
        queryPageResultCache.clear();
        queryPageResultCache.reset();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
        }
    }

    @Test
    public void entityQueryPagination_CountCache() { // without page list cache
        SimplePage page = new SimplePage();
        page.setSize(2);
        page.setNumber(1);

        PaginationResults<User2> results = null;

        Limit limit = null;

        results = query.find(User2.class).configure(q -> q.setPagingOptimization(false).setCachePageResults(false))
            .where().gt(User2::getAge, 0).limit(page).pagination();
        limit = new Limit(page);
        assertEquals(results.getPageResults().size(), page.getSize());
        assertEquals(results.getPageResults().get(0).getId(), 1);
        assertTrue(queryPageResultCache.getIndex() == 0);

        page.setNumber(2);
        limit = new Limit(page);
        results = query.find(User2.class).configure(q -> q.setPagingOptimization(false).setCachePageResults(false))
            .where().gt(User2::getAge, 0).limit(page).pagination();
        assertEquals(results.getPageResults().size(), page.getSize());
        assertEquals(results.getPageResults().get(0).getId(), 3);
        assertTrue(queryPageResultCache.getIndex() == 1);
        assertEquals(results.getTotal(), queryPageResultCache.getLast().getTotal());
        assertNull(queryPageResultCache.getLast().getPageList(limit.getOffset()));

        page.setNumber(3);
        limit = new Limit(page);
        results = query.find(User2.class).configure(q -> q.setPagingOptimization(false).setCachePageResults(false))
            .where().gt(User2::getAge, 0).limit(page).pagination();
        assertEquals(results.getPageResults().size(), page.getSize());
        assertEquals(results.getPageResults().get(0).getId(), 5);
        assertTrue(queryPageResultCache.getIndex() == 2);
        assertEquals(results.getTotal(), queryPageResultCache.getLast().getTotal());
        assertNull(queryPageResultCache.getLast().getPageList(limit.getOffset()));

        // skip 2 page

        page.setNumber(5);
        limit = new Limit(page);
        results = query.find(User2.class).configure(q -> q.setPagingOptimization(false).setCachePageResults(false))
            .where().gt(User2::getAge, 0).limit(page).pagination();
        assertEquals(results.getPageResults().size(), page.getSize());
        assertEquals(results.getPageResults().get(0).getId(), 9);
        assertTrue(queryPageResultCache.getIndex() == 3);
        assertEquals(results.getTotal(), queryPageResultCache.getLast().getTotal());
        assertNull(queryPageResultCache.getLast().getPageList(limit.getOffset()));

        // ----------------------------------------------------------------------------------------------------------------

        page.setNumber(1);
        results = query.find(User2.class).configure(q -> q.setPagingOptimization(false).setCachePageResults(false))
            .where().gt(User2::getAge, 5).limit(page).pagination();
        assertEquals(results.getPageResults().size(), page.getSize());
        assertTrue(queryPageResultCache.getIndex() == 0);

        page.setNumber(2);
        results = query.find(User2.class).configure(q -> q.setPagingOptimization(false).setCachePageResults(false))
            .where().gt(User2::getAge, 5).limit(page).pagination();
        assertEquals(results.getPageResults().size(), page.getSize());
        assertTrue(queryPageResultCache.getIndex() == 1);
    }

    @Test
    public void entityQueryPagination_CountCache_PageListCache() {
        SimplePage page = new SimplePage();
        page.setSize(2);
        page.setNumber(1);

        PaginationResults<User2> results = null;

        Limit limit = null;

        results = query.find(User2.class).configure(q -> q.setPagingOptimization(false)).where().gt(User2::getAge, 0)
            .limit(page).pagination();
        limit = new Limit(page);
        assertEquals(results.getPageResults().size(), page.getSize());
        assertEquals(results.getPageResults().get(0).getId(), 1);
        assertTrue(queryPageResultCache.getIndex() == 0);

        page.setNumber(2);
        limit = new Limit(page);
        results = query.find(User2.class).configure(q -> q.setPagingOptimization(false)).where().gt(User2::getAge, 0)
            .limit(page).pagination();
        assertEquals(results.getPageResults().size(), page.getSize());
        assertEquals(results.getPageResults().get(0).getId(), 3);
        assertTrue(queryPageResultCache.getIndex() == 1);
        assertEquals(results.getTotal(), queryPageResultCache.getLast().getTotal());
        assertEquals(queryPageResultCache.getLast().getPageList(limit.getOffset()), results.getPageResults());

        page.setNumber(3);
        limit = new Limit(page);
        results = query.find(User2.class).configure(q -> q.setPagingOptimization(false)).where().gt(User2::getAge, 0)
            .limit(page).pagination();
        assertEquals(results.getPageResults().size(), page.getSize());
        assertEquals(results.getPageResults().get(0).getId(), 5);
        assertTrue(queryPageResultCache.getIndex() == 2);
        assertEquals(results.getTotal(), queryPageResultCache.getLast().getTotal());
        assertEquals(queryPageResultCache.getLast().getPageList(limit.getOffset()), results.getPageResults());

        // skip 2 page

        page.setNumber(5);
        limit = new Limit(page);
        results = query.find(User2.class).configure(q -> q.setPagingOptimization(false)).where().gt(User2::getAge, 0)
            .limit(page).pagination();
        assertEquals(results.getPageResults().size(), page.getSize());
        assertEquals(results.getPageResults().get(0).getId(), 9);
        assertTrue(queryPageResultCache.getIndex() == 3);
        assertEquals(results.getTotal(), queryPageResultCache.getLast().getTotal());
        assertEquals(queryPageResultCache.getLast().getPageList(limit.getOffset()), results.getPageResults());

        // ----------------------------------------------------------------------------------------------------------------

        page.setNumber(1);
        results = query.find(User2.class).configure(q -> q.setPagingOptimization(false)).where().gt(User2::getAge, 5)
            .limit(page).pagination();
        assertEquals(results.getPageResults().size(), page.getSize());
        assertTrue(queryPageResultCache.getIndex() == 0);

        page.setNumber(2);
        results = query.find(User2.class).configure(q -> q.setPagingOptimization(false)).where().gt(User2::getAge, 5)
            .limit(page).pagination();
        assertEquals(results.getPageResults().size(), page.getSize());
        assertTrue(queryPageResultCache.getIndex() == 1);
    }

    @Test(dependsOnMethods = "entityQueryPagination_CountCache_PageListCache")
    public void entityQueryPagination_CountCache_OptimizationPage() { // without page list cache
        SimplePage page = new SimplePage();
        page.setSize(2);
        page.setNumber(1);

        PaginationResults<User2> results = null;

        Limit limit = null;
        Limit preLimit = null;
        results = query.find(User2.class).where().gt(User2::getAge, 0) //
            .limit(page) //
            .pagination();

        limit = new Limit(page);
        assertEquals(results.getPageResults().size(), page.getSize());
        assertEquals(results.getPageResults().get(0).getId(), 1);
        assertTrue(queryPageResultCache.getIndex() == 0);

        page.setNumber(2);
        preLimit = limit;
        limit = new Limit(page);
        results = query.find(User2.class).configure(c -> c.setCachePageResults(false)).where().gt(User2::getAge, 0)
            .limit(page).pagination();
        assertEquals(results.getPageResults().size(), page.getSize());
        assertEquals(results.getPageResults().get(0).getId(), 3);
        assertTrue(queryPageResultCache.getIndex() == 1);
        assertEquals(page.getSize(), queryPageResultCache.getLast().getLimit());
        assertEquals(preLimit.getOffset() + preLimit.getLimit(),
            queryPageResultCache.getLast().getNearestQueryPageResult(new Limit(page)).getOffset());
        assertNull(queryPageResultCache.getLast().getPageList(limit.getOffset()));

        page.setNumber(3);
        preLimit = limit;
        limit = new Limit(page);
        results = query.find(User2.class).configure(c -> c.setCachePageResults(false)).where().gt(User2::getAge, 0)
            .limit(page).pagination();
        assertEquals(results.getPageResults().size(), page.getSize());
        assertEquals(results.getPageResults().get(0).getId(), 5);
        assertTrue(queryPageResultCache.getIndex() == 2);
        assertEquals(page.getSize(), queryPageResultCache.getLast().getLimit());
        assertEquals(preLimit.getOffset() + limit.getLimit(),
            queryPageResultCache.getLast().getNearestQueryPageResult(new Limit(page)).getOffset());
        assertNull(queryPageResultCache.getLast().getPageList(limit.getOffset()));

        // skip 2 page
        page.setNumber(5);
        preLimit = limit;
        limit = new Limit(page);
        results = query.find(User2.class).configure(c -> c.setCachePageResults(false)).where().gt(User2::getAge, 0)
            .limit(page).pagination();
        assertEquals(results.getPageResults().size(), page.getSize());
        assertEquals(results.getPageResults().get(0).getId(), 9);
        assertTrue(queryPageResultCache.getIndex() == 3);
        assertEquals(page.getSize(), queryPageResultCache.getLast().getLimit());
        assertEquals(preLimit.getOffset() + limit.getLimit() * 2,
            queryPageResultCache.getLast().getNearestQueryPageResult(new Limit(page)).getOffset());
        assertNull(queryPageResultCache.getLast().getPageList(limit.getOffset()));

        // ----------------------------------------------------------------------------------------------------------------

        queryPageResultCache.reset(); // 重置

        page.setNumber(1);
        results = query.find(User2.class).configure(c -> c.setCachePageResults(false)).where().gt(User2::getAge, 5)
            .limit(page).pagination();
        assertEquals(results.getPageResults().size(), page.getSize());
        assertTrue(queryPageResultCache.getIndex() == 0);

        page.setNumber(3);
        results = query.find(User2.class).configure(c -> c.setCachePageResults(false)).where().gt(User2::getAge, 5)
            .limit(page).pagination();
        assertEquals(results.getPageResults().size(), page.getSize());
        assertTrue(queryPageResultCache.getIndex() == 1);

    }

    @Test(dependsOnMethods = "entityQueryPagination_CountCache_PageListCache")
    public void entityQueryPagination_CountCache_PageListCache_OptimizationPage() {
        SimplePage page = new SimplePage();
        page.setSize(2);
        page.setNumber(1);

        PaginationResults<User2> results = null;

        Limit limit = null;
        Limit preLimit = null;
        results = query.find(User2.class).where().gt(User2::getAge, 0) //
            .limit(page) //
            .pagination();

        limit = new Limit(page);
        assertEquals(results.getPageResults().size(), page.getSize());
        assertEquals(results.getPageResults().get(0).getId(), 1);
        assertTrue(queryPageResultCache.getIndex() == 0);

        page.setNumber(2);
        preLimit = limit;
        limit = new Limit(page);
        results = query.find(User2.class).where().gt(User2::getAge, 0).limit(page).pagination();
        assertEquals(results.getPageResults().size(), page.getSize());
        assertEquals(results.getPageResults().get(0).getId(), 3);
        assertTrue(queryPageResultCache.getIndex() == 1);
        assertEquals(page.getSize(), queryPageResultCache.getLast().getLimit());
        assertEquals(preLimit.getOffset() + preLimit.getLimit(),
            queryPageResultCache.getLast().getNearestQueryPageResult(new Limit(page)).getOffset());
        assertEquals(queryPageResultCache.getLast().getPageList(limit.getOffset()), results.getPageResults());

        page.setNumber(3);
        preLimit = limit;
        limit = new Limit(page);
        results = query.find(User2.class).where().gt(User2::getAge, 0).limit(page).pagination();
        assertEquals(results.getPageResults().size(), page.getSize());
        assertEquals(results.getPageResults().get(0).getId(), 5);
        assertTrue(queryPageResultCache.getIndex() == 2);
        assertEquals(page.getSize(), queryPageResultCache.getLast().getLimit());
        assertEquals(preLimit.getOffset() + limit.getLimit(),
            queryPageResultCache.getLast().getNearestQueryPageResult(new Limit(page)).getOffset());
        assertEquals(queryPageResultCache.getLast().getPageList(limit.getOffset()), results.getPageResults());

        // skip 2 page
        page.setNumber(5);
        preLimit = limit;
        limit = new Limit(page);
        results = query.find(User2.class).where().gt(User2::getAge, 0).limit(page).pagination();
        assertEquals(results.getPageResults().size(), page.getSize());
        assertEquals(results.getPageResults().get(0).getId(), 9);
        assertTrue(queryPageResultCache.getIndex() == 3);
        assertEquals(page.getSize(), queryPageResultCache.getLast().getLimit());
        assertEquals(preLimit.getOffset() + limit.getLimit() * 2,
            queryPageResultCache.getLast().getNearestQueryPageResult(new Limit(page)).getOffset());
        assertEquals(queryPageResultCache.getLast().getPageList(limit.getOffset()), results.getPageResults());
        // ----------------------------------------------------------------------------------------------------------------

        queryPageResultCache.reset(); // 重置

        page.setNumber(1);
        results = query.find(User2.class).where().gt(User2::getAge, 5).limit(page).pagination();
        assertEquals(results.getPageResults().size(), page.getSize());
        assertTrue(queryPageResultCache.getIndex() == 0);

        page.setNumber(3);
        results = query.find(User2.class).where().gt(User2::getAge, 5).limit(page).pagination();
        assertEquals(results.getPageResults().size(), page.getSize());
        assertTrue(queryPageResultCache.getIndex() == 1);

    }

    @Test
    public void entityQueryPagination() { // without CountCache
        SimplePage page = new SimplePage();
        page.setSize(2);
        page.setNumber(1);

        PaginationResults<User2> results = null;

        results = query.find(User2.class).configure(c -> c.setCachePageCount(false).setCachePageResults(false)) //
            .where().gt(User2::getAge, 1) //
            .limit(page) //
            .pagination();
        assertEquals(results.getPageResults().size(), page.getSize());
        assertTrue(queryPageResultCache.getIndex() == 0);
        assertNull(queryPageResultCache.getLast());

        page.setNumber(2);
        results = query.find(User2.class).configure(c -> c.setCachePageCount(false).setCachePageResults(false)) //
            .where().gt(User2::getAge, 1).limit(page).pagination();
        assertEquals(results.getPageResults().size(), page.getSize());
        assertTrue(queryPageResultCache.getIndex() == 0);
        assertNull(queryPageResultCache.getLast());

        page.setNumber(3);
        results = query.find(User2.class).configure(c -> c.setCachePageCount(false).setCachePageResults(false)) //
            .where().gt(User2::getAge, 1).limit(page).pagination();
        assertEquals(results.getPageResults().size(), page.getSize());
        assertTrue(queryPageResultCache.getIndex() == 0);
        assertNull(queryPageResultCache.getLast());

        page.setNumber(4);
        results = query.find(User2.class).configure(c -> c.setCachePageCount(false).setCachePageResults(false)) //
            .where().gt(User2::getAge, 1).limit(page).pagination();
        assertEquals(results.getPageResults().size(), page.getSize());
        assertTrue(queryPageResultCache.getIndex() == 0);
        assertNull(queryPageResultCache.getLast());

        // ----------------------------------------------------------------------------------------------------------------

        queryPageResultCache.reset(); // 重置

        page.setNumber(1);
        results = query.find(User2.class).configure(c -> c.setCachePageCount(false).setCachePageResults(false)) //
            .where().gt(User2::getAge, 5).limit(page).pagination();
        assertEquals(results.getPageResults().size(), page.getSize());
        assertTrue(queryPageResultCache.getIndex() == 0);
        assertNull(queryPageResultCache.getLast());

        page.setNumber(2);
        results = query.find(User2.class).configure(c -> c.setCachePageCount(false).setCachePageResults(false)) //
            .where().gt(User2::getAge, 5).limit(page).pagination();
        assertEquals(results.getPageResults().size(), page.getSize());
        assertTrue(queryPageResultCache.getIndex() == 0);
        assertNull(queryPageResultCache.getLast());
    }

    @Test
    public void repositoryQueryPaginationCountCache() {
        // NOIMPL 后续来实现
        throw new NotImplementedException();
    }

    @Test
    public void tplQueryPagination_CountCache_PageListCache() {
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

    @Test
    public void tplQueryPagination_CountCache() {

        HammerConfig hammerConfig = new HammerConfigImpl(true)
            .setCacheConfig(new CacheConfigImpl().setQueryPageResultCache(queryPageResultCache));
        hammerConfig.getQueryConfig().setCachePageResults(false);

        // 使用局部变量，不能覆盖成员变量executor
        TplExecutor executor = new SqlTplExecutor(hammerConfig, configFactory,
            new SqldbFreemarkerTemplateEngine(configFactory, hammerConfig.getTemplateConfig()), jdbc, mappingFactory,
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

    @Test
    public void tplQueryPagination() { // without CountCache

        HammerConfig hammerConfig = new HammerConfigImpl(true);
        hammerConfig.getQueryConfig().setCachePageCount(false);

        // 使用局部变量，不能覆盖成员变量executor
        TplExecutor executor = new SqlTplExecutor(hammerConfig, configFactory,
            new SqldbFreemarkerTemplateEngine(configFactory, hammerConfig.getTemplateConfig()), jdbc, mappingFactory,
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
}

class CacheProxy<K, V> implements Cache<K, V> {

    private final Cache<K, V> proxy;

    private int index;

    private V last;

    /**
     * @param proxy
     */
    public CacheProxy(Cache<K, V> proxy) {
        super();
        this.proxy = proxy;
    }

    public void reset() {
        index = 0;
        last = null;
    }

    /**
     * get last value
     *
     * @return last
     */
    public V getLast() {
        return last;
    }

    @Override
    public void forEach(Consumer<? super Entry<K, V>> action) {
        proxy.forEach(action);
    }

    @Override
    public Spliterator<Entry<K, V>> spliterator() {
        return proxy.spliterator();
    }

    @Override
    public V get(K key) {
        V v = proxy.get(key);
        if (v != null) {
            index++;
        } else {
            index = 0;
        }
        last = v;
        return v;
    }

    /**
     * @param keys
     * @return
     * @see javax.cache.Cache#getAll(java.util.Set)
     */
    @Override
    public Map<K, V> getAll(Set<? extends K> keys) {
        return proxy.getAll(keys);
    }

    /**
     * @param key
     * @return
     * @see javax.cache.Cache#containsKey(java.lang.Object)
     */
    @Override
    public boolean containsKey(K key) {
        return proxy.containsKey(key);
    }

    /**
     * @param keys
     * @param replaceExistingValues
     * @param completionListener
     * @see javax.cache.Cache#loadAll(java.util.Set, boolean,
     *      javax.cache.integration.CompletionListener)
     */
    @Override
    public void loadAll(Set<? extends K> keys, boolean replaceExistingValues, CompletionListener completionListener) {
        proxy.loadAll(keys, replaceExistingValues, completionListener);
    }

    @Override
    public void put(K key, V value) {
        proxy.put(key, value);
    }

    @Override
    public V getAndPut(K key, V value) {
        return proxy.getAndPut(key, value);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        proxy.putAll(map);
    }

    @Override
    public boolean putIfAbsent(K key, V value) {
        return proxy.putIfAbsent(key, value);
    }

    @Override
    public boolean remove(K key) {
        return proxy.remove(key);
    }

    @Override
    public boolean remove(K key, V oldValue) {
        return proxy.remove(key, oldValue);
    }

    @Override
    public V getAndRemove(K key) {
        return proxy.getAndRemove(key);
    }

    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        return proxy.replace(key, oldValue, newValue);
    }

    @Override
    public boolean replace(K key, V value) {
        return proxy.replace(key, value);
    }

    @Override
    public V getAndReplace(K key, V value) {
        return proxy.getAndReplace(key, value);
    }

    @Override
    public void removeAll(Set<? extends K> keys) {
        proxy.removeAll(keys);
    }

    @Override
    public void removeAll() {
        proxy.removeAll();
    }

    @Override
    public void clear() {
        proxy.clear();
    }

    @Override
    public <C extends Configuration<K, V>> C getConfiguration(Class<C> clazz) {
        return proxy.getConfiguration(clazz);
    }

    @Override
    public <T> T invoke(K key, EntryProcessor<K, V, T> entryProcessor, Object... arguments)
        throws EntryProcessorException {
        return proxy.invoke(key, entryProcessor, arguments);
    }

    @Override
    public <T> Map<K, EntryProcessorResult<T>> invokeAll(Set<? extends K> keys, EntryProcessor<K, V, T> entryProcessor,
        Object... arguments) {
        return proxy.invokeAll(keys, entryProcessor, arguments);
    }

    @Override
    public String getName() {
        return proxy.getName();
    }

    /**
     * @return
     * @see javax.cache.Cache#getCacheManager()
     */
    @Override
    public CacheManager getCacheManager() {
        return proxy.getCacheManager();
    }

    @Override
    public void close() {
        proxy.close();
    }

    @Override
    public boolean isClosed() {
        return proxy.isClosed();
    }

    @Override
    public <T> T unwrap(Class<T> clazz) {
        return proxy.unwrap(clazz);
    }

    @Override
    public void registerCacheEntryListener(CacheEntryListenerConfiguration<K, V> cacheEntryListenerConfiguration) {
        proxy.registerCacheEntryListener(cacheEntryListenerConfiguration);
    }

    @Override
    public void deregisterCacheEntryListener(CacheEntryListenerConfiguration<K, V> cacheEntryListenerConfiguration) {
        proxy.deregisterCacheEntryListener(cacheEntryListenerConfiguration);
    }

    @Override
    public Iterator<Entry<K, V>> iterator() {
        return proxy.iterator();
    }

    /**
     * get index value
     *
     * @return index
     */
    public int getIndex() {
        return index;
    }

}
