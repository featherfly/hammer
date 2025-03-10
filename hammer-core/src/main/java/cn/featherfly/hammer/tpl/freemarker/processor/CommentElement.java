
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
     * @param previous the previous
     * @param parser the parser
     */
    public CommentElement(CharSequence source, Element previous, Parser parser) {
        super(source, true, parser);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getValue() {
        return source.toString();
    }

}
