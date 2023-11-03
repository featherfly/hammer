
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-03 17:29:03
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.debug;

import cn.featherfly.common.lang.debug.AbstractDebugMessage;
import cn.featherfly.common.structure.ChainMapImpl;

/**
 * UpdateDebugMessage.
 *
 * @author zhongj
 */
public class UpdateDebugMessage extends AbstractDebugMessage<UpdateDebugMessage> {

    private String columnTitle = "ColumnName";

    private String propertyTitle = "PropertyName";

    private String originalValueTitle = "OriginalValue";

    private String updateValueTitle = "UpdateValue";

    /**
     * Instantiates a new update debug message.
     *
     * @param debug the debug
     */
    public UpdateDebugMessage(boolean debug) {
        super(debug);
        addColumn(columnTitle, propertyTitle, originalValueTitle, updateValueTitle);
    }

    /**
     * add property update .
     *
     * @param property    the property
     * @param column      the column
     * @param original    the original
     * @param updateValue the update value
     * @return the update debug message
     */
    public UpdateDebugMessage addPropertyUpdate(String property, String column, Object original, Object updateValue) {
        return (UpdateDebugMessage) addRow(
                new ChainMapImpl<String, Object>().putChain(propertyTitle, property).putChain(columnTitle, column)
                        .putChain(originalValueTitle, original).putChain(updateValueTitle, updateValue));
    }

}
