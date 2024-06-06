
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-29 02:42:29
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.testng.annotations.Test;

import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.common.structure.page.SimplePage;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.User2;

/**
 * QueryPaginationCacheTest.
 *
 * @author zhongj
 */

public class EntityQueryCacheTest extends AbstractQueryCacheTest {

    @Override
    @Test
    public void queryPagination_CountCache() { // without page list cache
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

    @Override
    @Test
    public void queryPagination_CountCache_PageListCache() {
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

    @Override
    @Test(dependsOnMethods = "queryPagination_CountCache_PageListCache")
    public void queryPagination_CountCache_OptimizationPage() { // without page list cache
        SimplePage page = new SimplePage();
        page.setSize(2);
        page.setNumber(1);

        PaginationResults<User2> results = null;

        Limit limit = null;
        Limit preLimit = null;
        results = query.find(User2.class).configure(c -> c.setCachePageResults(false)).where().gt(User2::getAge, 0) //
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

    @Override
    @Test
    public void queryPagination_CountCache_OptimizationPage_PageNumber_Gt_MaxPageNumber() {
        SimplePage page = new SimplePage();
        page.setSize(2);
        page.setNumber(1);

        PaginationResults<User2> results = null;

        Limit limit = null;
        Limit preLimit = null;
        results = query.find(User2.class).configure(c -> c.setCachePageResults(false)).where().ge(User2::getAge, 0) //
            .limit(page) //
            .pagination();

        limit = new Limit(page);
        assertEquals(results.getPageResults().size(), page.getSize());
        assertEquals(results.getPageResults().get(0).getId(), 1);
        assertTrue(queryPageResultCache.getIndex() == 0);

        page.setNumber(100);
        preLimit = limit;
        limit = new Limit(page);
        results = query.find(User2.class).configure(c -> c.setCachePageResults(false)).where().ge(User2::getAge, 0)
            .limit(page).pagination();
        assertEquals(results.getPageResults().size(), 0);
        assertEquals(queryPageResultCache.getIndex(), 1);

        page.setNumber(2);
        preLimit = limit;
        limit = new Limit(page);
        results = query.find(User2.class).configure(c -> c.setCachePageResults(false)).where().ge(User2::getAge, 0)
            .limit(page).pagination();
        assertEquals(results.getPageResults().size(), page.getSize());
        assertEquals(results.getPageResults().get(0).getId(), 3);
        assertEquals(queryPageResultCache.getIndex(), 2);
        assertEquals(page.getSize(), queryPageResultCache.getLast().getLimit());
        assertNull(queryPageResultCache.getLast().getPageList(limit.getOffset()));

        page.setNumber(3);
        preLimit = limit;
        limit = new Limit(page);
        results = query.find(User2.class).configure(c -> c.setCachePageResults(false)).where().ge(User2::getAge, 0)
            .limit(page).pagination();
        assertEquals(results.getPageResults().size(), page.getSize());
        assertEquals(results.getPageResults().get(0).getId(), 5);
        assertEquals(queryPageResultCache.getIndex(), 3);
        assertEquals(page.getSize(), queryPageResultCache.getLast().getLimit());
        assertEquals(preLimit.getOffset() + limit.getLimit(),
            queryPageResultCache.getLast().getNearestQueryPageResult(new Limit(page)).getOffset());
        assertNull(queryPageResultCache.getLast().getPageList(limit.getOffset()));
    }

    @Test
    public void queryPagination_CountCache_Find_Empty() {
        SimplePage page = new SimplePage();
        page.setSize(2);
        page.setNumber(1);

        PaginationResults<User2> results = null;

        results = query.find(User2.class).configure(c -> c.setCachePageResults(false).setPagingOptimization(false)) //
            .where().ge(User2::getAge, Integer.MAX_VALUE) //
            .limit(page) //
            .pagination();

        assertEquals(results.getPageResults().size(), 0);
        page.setNumber(2);
        results = query.find(User2.class).configure(c -> c.setCachePageResults(false).setPagingOptimization(false)) //
            .where().ge(User2::getAge, Integer.MAX_VALUE) //
            .limit(page).pagination();
        assertEquals(results.getPageResults().size(), 0);
    }

    @Override
    @Test
    public void queryPagination_CountCache_OptimizationPage_Find_Empty() {
        // 测试缓存空指针问题，解决没有
        SimplePage page = new SimplePage();
        page.setSize(2);
        page.setNumber(1);

        PaginationResults<User2> results = null;

        results = query.find(User2.class).configure(c -> c.setCachePageResults(false)).where()
            .ge(User2::getAge, Integer.MAX_VALUE) //
            .limit(page) //
            .pagination();

        assertEquals(results.getPageResults().size(), 0);
        page.setNumber(2);
        results = query.find(User2.class).configure(c -> c.setCachePageResults(false)).where()
            .ge(User2::getAge, Integer.MAX_VALUE) //
            .limit(page).pagination();
        assertEquals(results.getPageResults().size(), 0);
    }

    @Override
    @Test(dependsOnMethods = "queryPagination_CountCache_PageListCache")
    public void queryPagination_CountCache_PageListCache_OptimizationPage() {
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

    @Override
    @Test
    public void queryPagination() { // without CountCache
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

    /**
     * {@inheritDoc}
     */
    @Override
    @Test
    public void queryList_OptimizationPage() {
        SimplePage page = new SimplePage();
        page.setSize(2);
        page.setNumber(1);

        List<User2> results = null;

        results = query.find(User2.class).configure(c -> c.setCachePageResults(false).setPagingOptimization(true)) //
            .where().gt(User2::getAge, 1) //
            .limit(page) //
            .list();
        assertEquals(results.size(), page.getSize());
        assertTrue(queryPageResultCache.getIndex() == 0);
        assertNull(queryPageResultCache.getLast());

        page.setNumber(2);
        results = query.find(User2.class).configure(c -> c.setCachePageResults(false).setPagingOptimization(true)) //
            .where().gt(User2::getAge, 1).limit(page).list();
        assertEquals(results.size(), page.getSize());
        assertEquals(queryPageResultCache.getIndex(), 1);
        assertNotNull(queryPageResultCache.getLast());

        page.setNumber(3);
        results = query.find(User2.class).configure(c -> c.setCachePageResults(false).setPagingOptimization(true)) //
            .where().gt(User2::getAge, 1).limit(page).list();
        assertEquals(results.size(), page.getSize());
        assertEquals(queryPageResultCache.getIndex(), 2);
        assertNotNull(queryPageResultCache.getLast());

        page.setNumber(4);
        results = query.find(User2.class).configure(c -> c.setCachePageResults(false).setPagingOptimization(true)) //
            .where().gt(User2::getAge, 1).limit(page).list();
        assertEquals(results.size(), page.getSize());
        assertEquals(queryPageResultCache.getIndex(), 3);
        assertNotNull(queryPageResultCache.getLast());

        // ----------------------------------------------------------------------------------------------------------------

        queryPageResultCache.reset(); // 重置

        page.setNumber(1);
        results = query.find(User2.class).configure(c -> c.setCachePageCount(false).setCachePageResults(false)) //
            .where().gt(User2::getAge, 5).limit(page).list();
        assertEquals(results.size(), page.getSize());
        assertEquals(queryPageResultCache.getIndex(), 0);
        assertNull(queryPageResultCache.getLast());

        page.setNumber(2);
        results = query.find(User2.class).configure(c -> c.setCachePageCount(false).setCachePageResults(false)) //
            .where().gt(User2::getAge, 5).limit(page).list();
        assertEquals(results.size(), page.getSize());
        assertEquals(queryPageResultCache.getIndex(), 1);
        assertNotNull(queryPageResultCache.getLast());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Test
    public void queryList_PageListCache() {
        SimplePage page = new SimplePage();
        page.setSize(2);
        page.setNumber(1);

        List<User2> results = null;

        Limit limit = null;

        results = query.find(User2.class).configure(q -> q.setPagingOptimization(false).setCachePageResults(true))
            .where().gt(User2::getAge, 0).limit(page).list();
        limit = new Limit(page);
        assertEquals(results.size(), page.getSize());
        assertEquals(results.get(0).getId(), 1);
        assertEquals(queryPageResultCache.getIndex(), 0);

        page.setNumber(2);
        limit = new Limit(page);
        results = query.find(User2.class).configure(q -> q.setPagingOptimization(false).setCachePageResults(true))
            .where().gt(User2::getAge, 0).limit(page).list();
        assertEquals(results.size(), page.getSize());
        assertEquals(results.get(0).getId(), 3);
        assertEquals(queryPageResultCache.getIndex(), 1);
        assertEquals(queryPageResultCache.getLast().getPageList(limit.getOffset()), results);

        page.setNumber(3);
        limit = new Limit(page);
        results = query.find(User2.class).configure(q -> q.setPagingOptimization(false).setCachePageResults(true))
            .where().gt(User2::getAge, 0).limit(page).list();
        assertEquals(results.size(), page.getSize());
        assertEquals(results.get(0).getId(), 5);
        assertEquals(queryPageResultCache.getIndex(), 2);
        assertEquals(queryPageResultCache.getLast().getPageList(limit.getOffset()), results);

        // skip 2 page

        page.setNumber(5);
        limit = new Limit(page);
        results = query.find(User2.class).configure(q -> q.setPagingOptimization(false).setCachePageResults(true))
            .where().gt(User2::getAge, 0).limit(page).list();
        assertEquals(results.size(), page.getSize());
        assertEquals(results.get(0).getId(), 9);
        assertEquals(queryPageResultCache.getIndex(), 3);
        assertEquals(queryPageResultCache.getLast().getPageList(limit.getOffset()), results);

        // ----------------------------------------------------------------------------------------------------------------

        page.setNumber(1);
        results = query.find(User2.class).configure(q -> q.setPagingOptimization(false).setCachePageResults(true))
            .where().gt(User2::getAge, 5).limit(page).list();
        assertEquals(results.size(), page.getSize());
        assertEquals(queryPageResultCache.getIndex(), 0);

        page.setNumber(2);
        results = query.find(User2.class).configure(q -> q.setPagingOptimization(false).setCachePageResults(true))
            .where().gt(User2::getAge, 5).limit(page).list();
        assertEquals(results.size(), page.getSize());
        assertEquals(queryPageResultCache.getIndex(), 1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Test(dependsOnMethods = "queryList_PageListCache")
    public void queryList_PageListCache_OptimizationPage() {
        SimplePage page = new SimplePage();
        page.setSize(2);
        page.setNumber(1);

        List<User2> results = null;

        Limit limit = null;
        Limit preLimit = null;
        results = query.find(User2.class).where().gt(User2::getAge, 0) //
            .limit(page) //
            .list();

        limit = new Limit(page);
        assertEquals(results.size(), page.getSize());
        assertEquals(results.get(0).getId(), 1);
        assertTrue(queryPageResultCache.getIndex() == 0);

        page.setNumber(2);
        preLimit = limit;
        limit = new Limit(page);
        results = query.find(User2.class).where().gt(User2::getAge, 0).limit(page).list();
        assertEquals(results.size(), page.getSize());
        assertEquals(results.get(0).getId(), 3);
        assertTrue(queryPageResultCache.getIndex() == 1);
        assertEquals(page.getSize(), queryPageResultCache.getLast().getLimit());
        assertEquals(preLimit.getOffset() + preLimit.getLimit(),
            queryPageResultCache.getLast().getNearestQueryPageResult(new Limit(page)).getOffset());
        assertEquals(queryPageResultCache.getLast().getPageList(limit.getOffset()), results);

        page.setNumber(3);
        preLimit = limit;
        limit = new Limit(page);
        results = query.find(User2.class).where().gt(User2::getAge, 0).limit(page).list();
        assertEquals(results.size(), page.getSize());
        assertEquals(results.get(0).getId(), 5);
        assertTrue(queryPageResultCache.getIndex() == 2);
        assertEquals(page.getSize(), queryPageResultCache.getLast().getLimit());
        assertEquals(preLimit.getOffset() + limit.getLimit(),
            queryPageResultCache.getLast().getNearestQueryPageResult(new Limit(page)).getOffset());
        assertEquals(queryPageResultCache.getLast().getPageList(limit.getOffset()), results);

        // skip 2 page
        page.setNumber(5);
        preLimit = limit;
        limit = new Limit(page);
        results = query.find(User2.class).where().gt(User2::getAge, 0).limit(page).list();
        assertEquals(results.size(), page.getSize());
        assertEquals(results.get(0).getId(), 9);
        assertTrue(queryPageResultCache.getIndex() == 3);
        assertEquals(page.getSize(), queryPageResultCache.getLast().getLimit());
        assertEquals(preLimit.getOffset() + limit.getLimit() * 2,
            queryPageResultCache.getLast().getNearestQueryPageResult(new Limit(page)).getOffset());
        assertEquals(queryPageResultCache.getLast().getPageList(limit.getOffset()), results);
        // ----------------------------------------------------------------------------------------------------------------

        queryPageResultCache.reset(); // 重置

        page.setNumber(1);
        results = query.find(User2.class).where().gt(User2::getAge, 5).limit(page).list();
        assertEquals(results.size(), page.getSize());
        assertTrue(queryPageResultCache.getIndex() == 0);

        page.setNumber(3);
        results = query.find(User2.class).where().gt(User2::getAge, 5).limit(page).list();
        assertEquals(results.size(), page.getSize());
        assertTrue(queryPageResultCache.getIndex() == 1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Test
    public void queryList_OptimizationPage_PageNumber_Gt_MaxPageNumber() {
        SimplePage page = new SimplePage();
        page.setSize(2);
        page.setNumber(1);

        List<User2> results = null;

        Limit limit = null;
        Limit preLimit = null;
        results = query.find(User2.class).configure(c -> c.setCachePageResults(false)).where().ge(User2::getAge, 0) //
            .limit(page) //
            .list();

        limit = new Limit(page);
        assertEquals(results.size(), page.getSize());
        assertEquals(results.get(0).getId(), 1);
        assertTrue(queryPageResultCache.getIndex() == 0);

        page.setNumber(100);
        preLimit = limit;
        limit = new Limit(page);
        results = query.find(User2.class).configure(c -> c.setCachePageResults(false)).where().ge(User2::getAge, 0)
            .limit(page).list();
        assertEquals(results.size(), 0);
        assertEquals(queryPageResultCache.getIndex(), 1);

        page.setNumber(2);
        preLimit = limit;
        limit = new Limit(page);
        results = query.find(User2.class).configure(c -> c.setCachePageResults(false)).where().ge(User2::getAge, 0)
            .limit(page).list();
        assertEquals(results.size(), page.getSize());
        assertEquals(results.get(0).getId(), 3);
        assertEquals(queryPageResultCache.getIndex(), 2);
        assertEquals(page.getSize(), queryPageResultCache.getLast().getLimit());
        assertNull(queryPageResultCache.getLast().getPageList(limit.getOffset()));

        page.setNumber(3);
        preLimit = limit;
        limit = new Limit(page);
        results = query.find(User2.class).configure(c -> c.setCachePageResults(false)).where().ge(User2::getAge, 0)
            .limit(page).list();
        assertEquals(results.size(), page.getSize());
        assertEquals(results.get(0).getId(), 5);
        assertEquals(queryPageResultCache.getIndex(), 3);
        assertEquals(page.getSize(), queryPageResultCache.getLast().getLimit());
        assertEquals(preLimit.getOffset() + limit.getLimit(),
            queryPageResultCache.getLast().getNearestQueryPageResult(new Limit(page)).getOffset());
        assertNull(queryPageResultCache.getLast().getPageList(limit.getOffset()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Test
    public void queryList_OptimizationPage_Find_Empty() {
        // 测试缓存空指针问题，解决没有
        SimplePage page = new SimplePage();
        page.setSize(2);
        page.setNumber(1);

        List<User2> results = null;

        results = query.find(User2.class).configure(c -> c.setCachePageResults(false)).where()
            .ge(User2::getAge, Integer.MAX_VALUE) //
            .limit(page) //
            .list();

        assertEquals(results.size(), 0);

        page.setNumber(2);
        results = query.find(User2.class).configure(c -> c.setCachePageResults(false)).where()
            .ge(User2::getAge, Integer.MAX_VALUE) //
            .limit(page).list();
        assertEquals(results.size(), 0);
    }

}
