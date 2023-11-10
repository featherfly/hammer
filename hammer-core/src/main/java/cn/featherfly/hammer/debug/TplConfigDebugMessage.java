package cn.featherfly.hammer.debug;

import cn.featherfly.common.lang.debug.AbstractDebugMessage;
import cn.featherfly.common.structure.ChainMapImpl;

/**
 * The Class TplConfigDebugMessage.
 *
 * @author zhongj
 */
public class TplConfigDebugMessage extends AbstractDebugMessage<TplConfigDebugMessage> {

    private String columnTemplateName = "TemplateName";

    private String columnId = "Id";

    private String columnNamespace = "Namespace";

    private String columnFile = "File";

    /**
     * Instantiates a new tpl config debug message.
     *
     * @param debug the debug
     */
    public TplConfigDebugMessage(boolean debug) {
        super(debug);
        addColumn(columnTemplateName, columnId, columnNamespace, columnFile);
    }

    /**
     * Adds the config.
     *
     * @param templateName the template name
     * @param id           the id
     * @param namespace    the namespace
     * @return the tpl config debug message
     */
    public TplConfigDebugMessage addConfig(String templateName, String id, String namespace, String file) {
        return (TplConfigDebugMessage) addRow(
                new ChainMapImpl<String, Object>().putChain(columnTemplateName, templateName).putChain(columnId, id)
                        .putChain(columnNamespace, namespace).putChain(columnFile, file));
    }
}