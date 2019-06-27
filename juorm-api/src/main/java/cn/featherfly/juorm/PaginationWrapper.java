
package cn.featherfly.juorm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.structure.page.Pagination;

/**
 * <p>
 * PaginationImpl
 * </p>
 * @param <E> 泛型对象
 * @author zhongj
 */
public class PaginationWrapper<E> {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(PaginationWrapper.class);

	private Pagination pagination;

	private Integer start;

	private Integer limit;

	private Integer total;

//	/**
//	 * @param start start
//	 * @param limit limit
//	 * @param total total
//	 * @param pageResults pageResults
//	 */
//	public PaginationWrapper(int start, int limit, int total, Iterable<E> pageResults) {
//		this.start = start;
//		this.limit = limit;
//		this.total = total;
//		pagination = new SimplePagination<E>();
//		pagination.setTotal(this.total);
//		pagination.setPageSize(this.limit);
//		pagination.setPageNumber((start + limit - 1) / limit);
//		pagination.setPageResults(pageResults);
//	}
	/**
	 * @param pagination 分页模型
	 */
	public PaginationWrapper(Pagination pagination) {
//		AssertStandardSys.isNotNull(pagination, "pagination分页模型对象不能为空");
		AssertIllegalArgument.isNotNull(pagination, "pagination分页模型对象不能为空");
		Integer pageNumber = pagination.getPageNumber();
		Integer pageSize = pagination.getPageSize();
		if (pageNumber == null) {
			pageNumber = 1;
			LOGGER.debug("pageNumber == null， 设置为 {}", pageNumber);
		} else if (pageNumber < 1) {
			pageNumber = 1;
			LOGGER.debug("pageNumber < 1， 设置为 {}", pageNumber);
		}
		if (pageSize == null) {
			pageSize = -1;
			LOGGER.debug("pageSize == null， 设置为 {}", pageSize);
		}
		pagination.setPageNumber(pageNumber);
		pagination.setPageSize(pageSize);
		this.limit = pageSize;
		this.total = pagination.getTotal();
		this.start = (pageNumber - 1) * pageSize;
		LOGGER.debug("计算出start为 {}", this.start);
		this.pagination = pagination;
	}

	/**
	 * 返回limit
	 * @return limit
	 */
	public Integer getLimit() {
		return limit;
	}

	/**
	 * 返回total
	 * @return total
	 */
	public Integer getTotal() {
		return total;
	}

	/**
	 * <p>
	 * 根据pageSize和pageNumber返回起始位置
	 * </p>
	 * @return 起始位置
	 */
	public Integer getStart() {
		return this.start;
	}
	/**
	 * 返回pagination
	 * @return pagination
	 */
	public Pagination getPagination() {
		return pagination;
	}
}
