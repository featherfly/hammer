package cn.featherfly.hammer.debug;

import cn.featherfly.common.lang.debug.AbstractDebugMessage;
import cn.featherfly.common.structure.ChainMapImpl;

/**
 * The Class TplConfigDebugMessage.
 *
 * @author zhongj
 */
public class TplConfigDebugMessage extends AbstractDebugMessage<TplConfigDebugMessage> {

    /** The column template name. */
    private String columnTemplateName = "TemplateName";

    /** The column id. */
    private String columnId = "Id";

    /** The column namespace. */
    private String columnNamespace = "Namespace";

    /** The column file. */
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
     * @param file         the file
     * @return the tpl config debug message
     */
    public TplConfigDebugMessage addConfig(String templateName, String id, String namespace, String file) {
        return (TplConfigDebugMessage) addRow(
                new ChainMapImpl<String, Object>().putChain(columnTemplateName, templateName).putChain(columnId, id)
                        .putChain(columnNamespace, namespace).putChain(columnFile, file));
    }
}