
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-29 02:42:29
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl;

import org.testng.annotations.Test;

import cn.featherfly.common.exception.NotImplementedException;

/**
 * QueryPaginationCacheTest.
 *
 * @author zhongj
 */

public class RepositoryQueryCacheTest extends AbstractQueryCacheTest {

    @Override
    @Test
    public void queryPagination_CountCache() { // without page list cache
        throw new NotImplementedException();
    }

    @Override
    @Test
    public void queryPagination_CountCache_PageListCache() {
        // NOIMPL 后续来实现
        throw new NotImplementedException();
    }

    @Override
    @Test(dependsOnMethods = "queryPagination_CountCache_PageListCache")
    public void queryPagination_CountCache_OptimizationPage() { // without page list cache
        // NOIMPL 后续来实现
        throw new NotImplementedException();
    }

    @Override
    @Test
    public void queryPagination_CountCache_OptimizationPage_PageNumber_Gt_MaxPageNumber() {
        // NOIMPL 后续来实现
        throw new NotImplementedException();
    }

    @Override
    @Test
    public void queryPagination_CountCache_OptimizationPage_Find_Empty() {
        // NOIMPL 后续来实现
        throw new NotImplementedException();
    }

    @Override
    @Test(dependsOnMethods = "queryPagination_CountCache_PageListCache")
    public void queryPagination_CountCache_PageListCache_OptimizationPage() {
        // NOIMPL 后续来实现
        throw new NotImplementedException();
    }

    @Override
    @Test
    public void queryPagination() { // without CountCache
        // NOIMPL 后续来实现
        throw new NotImplementedException();
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
