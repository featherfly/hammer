
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-29 18:51:29
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.common.repository;

import java.util.HashMap;
import java.util.Map;

import cn.featherfly.common.structure.page.Limit;

/**
 * OrderedPage.
 *
 * @author zhongj
 */
public class QueryPageResults {

    private Map<Integer, QueryPageResult> pageResults = new HashMap<>();

    private Long total;

    private QueryPageResult last = null;

    /**
     * Instantiates a new query page result.
     */
    public QueryPageResults() {
    }

    /**
     * Instantiates a new query page result.
     *
     * @param total the count
     */
    public QueryPageResults(Long total) {
        this.total = total;
    }

    /**
     * Instantiates a new query page result.
     *
     * @param queryPageResult the query page result
     */
    public QueryPageResults(QueryPageResult queryPageResult) {
        this(queryPageResult, null);
    }

    /**
     * Instantiates a new query page result.
     *
     * @param queryPageResult the query page result
     * @param total the count
     */
    public QueryPageResults(QueryPageResult queryPageResult, Long total) {
        this.total = total;
        addQueryPageResult(queryPageResult);
    }

    /**
     * Adds the query page result.
     *
     * @param queryPageResult the query page result
     */
    public void addQueryPageResult(QueryPageResult queryPageResult) {
        last = queryPageResult;
        pageResults.put(queryPageResult.getOffset(), queryPageResult);
    }

    /**
     * Gets the query page result.
     *
     * @param limit the limit
     * @return the nearest
     */
    public QueryPageResult getNearestQueryPageResult(Limit limit) {
        QueryPageResult nearest = null;
        int value = Integer.MIN_VALUE;
        for (QueryPageResult qpr : pageResults.values()) {
            int diff = qpr.getOffset().intValue() - limit.getOffset();
            if (value < diff) {
                value = diff;
                nearest = qpr;
            }
        }
        return nearest;
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
    public static class QueryPageResult {

        private Integer limit;

        private Integer offset;

        private Number firstId;

        private Number lastId;

        /**
         * Instantiates a new query page result.
         *
         * @param limit the limit
         * @param firstId the first id
         * @param lastId the last id
         */
        public QueryPageResult(Limit limit, Number firstId, Number lastId) {
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
        public QueryPageResult(Integer limit, Integer offset, Number firstId, Number lastId) {
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
