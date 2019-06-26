package cn.featherfly.juorm.sql.dml.builder;

import cn.featherfly.juorm.dml.builder.SortBuilder;
import cn.featherfly.juorm.sql.dml.builder.basic.SqlOrderByBasicBuilder;

/**
 * <p>
 * sql sort builder
 * </p>
 *
 * @author zhongj
 */
public class SqlSortBuilder implements SortBuilder {
    
    private SqlOrderByBasicBuilder orderByBuilder = new SqlOrderByBasicBuilder();

	/**
	 */
	public SqlSortBuilder() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SortBuilder asc(String...names) {
	    orderByBuilder.addAsc(names);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SortBuilder desc(String...names) {
		orderByBuilder.addDesc(names);
		return this;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
    public String build() {
	    return orderByBuilder.build();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return this.getClass().getName() + " : " + build();
	}
}