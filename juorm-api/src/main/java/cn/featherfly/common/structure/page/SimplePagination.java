package cn.featherfly.common.structure.page;

import java.util.List;

/**
 * <p>
 * 简单分页模型实现
 * </p>
 *
 * @param <E> 存放的对象类型
 * @author zhongj
 */
public class SimplePagination<E> implements PaginationResults<E> {

    /**
     */
    public SimplePagination() {
    }

    /**
     * @param limit limit
     */
    public SimplePagination(Limit limit) {
        this(limit.getOffset(), limit.getLimit());
    }

    /**
     * @param offset offset
     * @param limit  limit
     */
    public SimplePagination(int offset, int limit) {
        this.pageSize = limit;
        this.pageNumber = (offset + limit) / limit;
    }

    private Integer total;

    private Integer pageSize;

    private Integer pageNumber;

    private List<E> pageResults;

    /**
     * <p>
     * 设置每页数量
     * </p>
     *
     * @param pageSize 每页数量
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * <p>
     * 设置页数
     * </p>
     *
     * @param pageNumber 页数
     */
    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPageResults(List<E> pageResults) {
        this.pageResults = pageResults;
    }

    /**
     * <p>
     * 设置总数
     * </p>
     *
     * @param total 总数
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getTotalPage() {
        return (getTotal() + pageSize - 1) / pageSize;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getTotal() {
        return total;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getPageNumber() {
        return pageNumber;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<E> getPageResults() {
        return pageResults;
    }

    /**
     * 返回resultSize
     *
     * @return resultSize
     */
    @Override
    public Integer getResultSize() {
        if (pageResults != null) {
            return pageResults.size();
        } else {
            return null;
        }
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public Pagination<E> next() {
    //        return to(pageNumber + 1);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public Pagination<E> previous() {
    //        return to(pageNumber - 1);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public Pagination<E> first() {
    //        return to(1);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public Pagination<E> last() {
    //        return to(getTotalPage());
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public Pagination<E> to(Integer pageNumber) {
    //        this.pageNumber = pageNumber;
    ////        setPageResults(null);
    //        return this;
    //    }
}
