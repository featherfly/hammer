
package cn.featherfly.juorm.rdb.tpl.freemarker;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Condition
 * </p>
 * 
 * @author zhongj
 */
public class ConditionGroup {

    private int amount = 0;

    private ConditionGroup parent;

    private List<ConditionGroup> child = new ArrayList<>();

    public void addChild(ConditionGroup group) {
        child.add(group);
        group.setParent(this);
    }

    public void addCondition() {
        amount++;
    }

    /**
     * 返回amount
     * 
     * @return amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * 返回child
     * 
     * @return child
     */
    public List<ConditionGroup> getChild() {
        return child;
    }

    /**
     * 返回parent
     * 
     * @return parent
     */
    public ConditionGroup getParent() {
        return parent;
    }

    /**
     * 设置parent
     * 
     * @param parent
     *            parent
     */
    public void setParent(ConditionGroup parent) {
        this.parent = parent;
    }
}
