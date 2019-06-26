package cn.featherfly.juorm.sql.dml.builder;

import java.util.ArrayList;
import java.util.List;

import cn.featherfly.juorm.dml.builder.Builder;
import cn.featherfly.juorm.operator.OrderOperator;

/**
 * <p>
 * sql sort builder
 * </p>
 *
 * @author zhongj
 */
public class SqlJoinBasicBuilder implements Builder {

	/**
	 */
	public SqlJoinBasicBuilder() {
	}

	/*
	 * 排序参数
	 */
	private List<Order> orderParams = new ArrayList<Order>();
	
	/**
	 * add  property to asc list 
	 * @param names sort property name
	 * @return this
	 */
	public SqlJoinBasicBuilder addAsc(String...names) {
		if (names != null) {
			for (String name : names) {
				addOrderBy(name, OrderOperator.ASC);
			}
		}
		return this;
	}

	/**
     * add property to desc list 
     * @param names sort property name
     * @return this
     */
	public SqlJoinBasicBuilder addDesc(String...names) {
		if (names != null) {
			for (String name : names) {
				addOrderBy(name, OrderOperator.DESC);
			}
		}
		return this;
	}

	/**
	 * clear all sort properties
	 * @return this
	 */
	public SqlJoinBasicBuilder clear() {
		orderParams.clear();
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
    public String build() {
		StringBuilder sb = new StringBuilder();
		if (orderParams.size() > 0) {
			sb.append(" ORDER BY");
		}
		for (Order orderParam : orderParams) {
			sb.append(orderParam).append(",");
		}
		if (orderParams.size() > 0) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return this.getClass().getName() + " : " + build();
	}

	// ********************************************************************
	//	private method
	// ********************************************************************

	private void addOrderBy(String propertyName, OrderOperator orderOperator) {
		Order orderParam = null;
		if (orderParams.isEmpty()) {
		    orderParam = new Order(orderOperator);
		    orderParams.add(orderParam);
		} else {
			orderParam = orderParams.get(orderParams.size() - 1);
            if (!orderParam.isOrderOperator(orderOperator)) {
                orderParam = new Order(orderOperator);
                orderParams.add(orderParam);
            }
		}
		orderParam.addParam(propertyName);
	}

	// ********************************************************************
	//	内部类
	// ********************************************************************

	/**
	 * <p>
	 * 排序参数辅助对象
	 * </p>
	 *
	 * @author zhongj
	 */
	public static class Order {

		/**
		 * @param orderOperator orderOperator
		 */
		public Order(OrderOperator orderOperator) {
			this.orderOperator = orderOperator;
		}

		private OrderOperator orderOperator;

		private List<String> params = new ArrayList<String>();

		/**
		 * <p>
		 * 添加排序参数
		 * </p>
		 * @param param 排序参数
		 */
		public void addParam(String param) {
			params.add(param);
		}

		/**
		 * 返回是否是传入的操作
		 * @param orderOperator orderOperator
		 * @return 是否是传入的操作
		 */
		public boolean isOrderOperator(OrderOperator orderOperator) {
			return this.orderOperator == orderOperator;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (String param : params) {
				sb.append(" ").append(param).append(",");
			}
			if (params.size() > 0) {
				sb.deleteCharAt(sb.length() - 1);
				sb.append(" ").append(orderOperator.toString());
			}
			return sb.toString();
		}
	}

}