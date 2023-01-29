
/*
 * All rights Reserved, Designed By zhongj
 * @Title: TransverterManager.java
 * @Package cn.featherfly.hammer.sqldb.tpl
 * @Description: TransverterManager
 * @author: zhongj
 * @date: 2021-08-17 15:06:17
 * @Copyright: 2021 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.tpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import cn.featherfly.hammer.HammerException;

/**
 * TransverterManager.
 *
 * @author zhongj
 */
public class TransverterManager {

    private Map<String, Transverter> transverterMap = new HashMap<>();

    /**
     * Instantiates a new transverter manager.
     */
    public TransverterManager() {
        super();
    }

    /**
     * Instantiates a new transverter manager.
     *
     * @param transverters the transverters
     */
    public TransverterManager(AutoRegistTransverter... transverters) {
        if (transverters != null) {
            for (AutoRegistTransverter transverter : transverters) {
                register(transverter);
            }
        }
    }

    /**
     * Register.
     *
     * @param transverter the transverter
     * @return the transverter manager
     */
    public TransverterManager register(AutoRegistTransverter transverter) {
        for (String operator : transverter.supportOperators()) {
            register(operator, transverter);
        }
        return this;
    }

    /**
     * Register.
     *
     * @param name        the name
     * @param transverter the transverter
     * @return the transverter manager
     */
    public TransverterManager register(String name, Transverter transverter) {
        Transverter t = transverterMap.get(name);
        if (t != null) {
            throw new HammerException(String.format("error register {0} with {1}, {1} already register for {2}",
                    transverter.getClass().getName(), name, t.getClass().getName()));
        }
        transverterMap.put(name, transverter);
        return this;
    }

    /**
     * Gets the.
     *
     * @param name the name
     * @return the transverter
     */
    public Transverter get(String name) {
        return transverterMap.get(name);
    }

    /**
     * Gets the exist.
     *
     * @param name the name
     * @return the exist
     * @exception HammerException Transverter is not found with name
     */
    public Transverter getExist(String name) {
        Transverter transverter = get(name);
        if (transverter == null) {
            throw new HammerException("transverter is not register with " + name);
        }
        return transverter;
    }

    /**
     * Gets the all.
     *
     * @return the all
     */
    public Collection<Transverter> getAll() {
        return new ArrayList<>(transverterMap.values());
    }
}
