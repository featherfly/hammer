
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-29 18:51:29
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.config.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.featherfly.common.structure.page.Limit;

/**
 * OrderedPage.
 *
 * @author zhongj
 */
public class QueryPageResult {

    private Map<Integer, PageInfo> pageResults = new HashMap<>();

    private Map<Integer, List<?>> pageLists = new HashMap<>();

    private Long total;

    private PageInfo last = null;

    /**
     * Instantiates a new query page result.
     */
    public QueryPageResult() {
    }

    /**
     * Instantiates a new query page result.
     *
     * @param total the count
     */
    public QueryPageResult(Long total) {
        this.total = total;
    }

    /**
     * Instantiates a new query page result.
     *
     * @param queryPageResult the query page result
     */
    public QueryPageResult(PageInfo queryPageResult) {
        this(queryPageResult, null);
    }

    /**
     * Instantiates a new query page result.
     *
     * @param queryPageResult the query page result
     * @param total the count
     */
    public QueryPageResult(PageInfo queryPageResult, Long total) {
        this.total = total;
        addQueryPageResult(queryPageResult);
    }

    /**
     * Adds the query page result.
     *
     * @param queryPageResult the query page result
     */
    public void addQueryPageResult(PageInfo queryPageResult) {
        last = queryPageResult;
        pageResults.put(queryPageResult.getOffset(), queryPageResult);
    }

    /**
     * Gets the query page result.
     *
     * @param limit the limit
     * @return the nearest
     */
    public PageInfo getNearestQueryPageResult(Limit limit) {
        PageInfo nearest = null;
        int value = Integer.MAX_VALUE;
        for (PageInfo qpr : pageResults.values()) {
            int diff = qpr.getOffset().intValue() > limit.getOffset() ? qpr.getOffset().intValue() - limit.getOffset()
                : limit.getOffset() - qpr.getOffset().intValue();
            if (value > diff) {
                value = diff;
                nearest = qpr;
            }
        }
        return nearest;
    }

    /**
     * Adds the page list.
     *
     * @param <E> the element type
     * @param offset the offset
     * @param pageList the page list
     */
    public <E> void addPageList(int offset, List<E> pageList) {
        pageLists.put(offset, pageList);
    }

    /**
     * Adds the page list.
     *
     * @param <E> the element type
     * @param offset the offset
     * @return the page list
     */
    @SuppressWarnings("unchecked")
    public <E> List<E> getPageList(int offset) {
        return (List<E>) pageLists.get(offset);
    }

    /**
     * Gets the limit.
     *
     * @return the limit
     */
    public Integer getLimit() {
        if (last == null) {
            return null;
        } else {
            return last.getLimit();
        }
    }

    /**
     * Gets the total.
     *
     * @return the total
     */
    public Long getTotal() {
        return total;
    }

    /**
     * Sets the total.
     *
     * @param total the new total
     */
    public void setTotal(Long total) {
        this.total = total;
    }

    /**
     * The Class QueryPageResult.
     *
     * @author zhongj
     */
    public static class PageInfo {

        private Integer limit;

        private Integer offset;

        private Number firstId;

        private Number lastId;

        /**
         * Instantiates a new query page result.
         *
         * @param limit the limit
         */
        public PageInfo(Limit limit) {
            offset = limit.getOffset();
            this.limit = limit.getLimit();
        }

        /**
         * Instantiates a new query page result.
         *
         * @param limit the limit
         * @param firstId the first id
         * @param lastId the last id
         */
        public PageInfo(Limit limit, Number firstId, Number lastId) {
            this(limit.getLimit(), limit.getOffset(), firstId, lastId);
        }

        /**
         * Instantiates a new query page result.
         *
         * @param limit the limit
         * @param offset the offset
         * @param firstId the first
         * @param lastId the last
         */
        public PageInfo(Integer limit, Integer offset, Number firstId, Number lastId) {
            super();
            this.limit = limit;
            this.offset = offset;
            this.firstId = firstId;
            this.lastId = lastId;
        }

        /**
         * Gets the first id.
         *
         * @return the first id
         */
        public Number getFirstId() {
            return firstId;
        }

        /**
         * Gets the last id.
         *
         * @return the last id
         */
        public Number getLastId() {
            return lastId;
        }

        /**
         * Sets the first id.
         *
         * @param firstId the new first id
         */
        public void setFirstId(Number firstId) {
            this.firstId = firstId;
        }

        /**
         * Sets the last id.
         *
         * @param lastId the new last id
         */
        public void setLastId(Number lastId) {
            this.lastId = lastId;
        }

        /**
         * Gets the limit.
         *
         * @return the limit
         */
        public Integer getLimit() {
            return limit;
        }

        /**
         * Sets the limit.
         *
         * @param limit the new limit
         */
        public void setLimit(Integer limit) {
            this.limit = limit;
        }

        /**
         * Gets the offset.
         *
         * @return the offset
         */
        public Integer getOffset() {
            return offset;
        }

        /**
         * Sets the offset.
         *
         * @param offset the new offset
         */
        public void setOffset(Integer offset) {
            this.offset = offset;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return "QueryPageResult [limit=" + limit + ", offset=" + offset + ", firstId=" + firstId + ", lastId="
                + lastId + "]";
        }
    }
}
