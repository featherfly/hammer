
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-01-10 17:43:10
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dsl.query.relation;

/**
 * OnConsumer.
 *
 * @author zhongj
 */
public class AbstractOnFields {

    private String joinField;

    private String sourceField;

    /**
     * Sets the join field.
     *
     * @param joinField the new join field
     */
    public void setJoinField(String joinField) {
        this.joinField = joinField;
    }

    /**
     * Sets the source field.
     *
     * @param sourceField the new source field
     */
    public void setSourceField(String sourceField) {
        this.sourceField = sourceField;
    }

    /**
     * Gets the join field.
     *
     * @return the join field
     */
    public String getJoinField() {
        return joinField;
    }

    /**
     * Gets the source field.
     *
     * @return the source field
     */
    public String getSourceField() {
        return sourceField;
    }
}
