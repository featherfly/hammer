
package cn.featherfly.hammer.tpl.freemarker.processor;

/**
 * CommentElement .
 *
 * @author zhongj
 */
public class CommentElement extends AbstractElement {

    /**
     * Instantiates a new comment element.
     *
     * @param source the source
     * @param parser the parser
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
