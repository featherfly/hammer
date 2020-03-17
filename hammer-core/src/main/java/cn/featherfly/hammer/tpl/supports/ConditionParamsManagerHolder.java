package cn.featherfly.hammer.tpl.supports;

/**
 * 基于ThreadLocal使用ConditionParamsManager的管理，主要用于不支持有状态指令的模板引擎来获取ConditionParamsManager
 */
public final class ConditionParamsManagerHolder {

    /**
     */
    private ConditionParamsManagerHolder() {
    }

    private static final ThreadLocal<ConditionParamsManager> HOLDER = new ThreadLocal<>();

    /**
     * <p>
     * 标记写
     * </p>
     */
    public static void hold(ConditionParamsManager manager) {
        HOLDER.set(manager);
    }

    /**
     * <p>
     * 重置标记
     * </p>
     */
    public static void reset() {
        HOLDER.set(null);
    }
}
