
package cn.featherfly.hammer.tpl.freemarker.processor;

/**
 * <p>
 * CommentElement
 * </p>
 *
 * @author zhongj
 */
public class CommentElement extends AbstractElement {

    /**
     * @param source
     * @param parser
     */
    public CommentElement(String source, Parser parser) {
        super(source, parser);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getValue() {
        return source.toString();
    }

}
