
package cn.featherfly.hammer.tpl.freemarker.processor;

import java.util.ArrayList;
import java.util.List;

/**
 * AbstractElement .
 *
 * @author zhongj
 */
public abstract class AbstractElement implements Element {

    /** The value. */
    protected StringBuilder source = new StringBuilder();

    /** The parent. */
    protected Element parent;

    /** The childs. */
    protected List<Element> childs = new ArrayList<>();

    /** The start. */
    protected int start;

    /** The end. */
    protected int end;

    /** The parser. */
    protected Parser parser;

    /**
     * Instantiates a new abstract element.
     *
     * @param parser the parser
     */
    public AbstractElement(Parser parser) {
        this.parser = parser;
    }

    /**
     * Instantiates a new abstract element.
     *
     * @param source the source
     * @param parser the parser
     */
    public AbstractElement(String source, Parser parser) {
        super();
        this.parser = parser;
        this.source.append(source);
    }

    /**
     * Instantiates a new abstract element.
     *
     * @param parent the parent
     */
    public AbstractElement(Element parent) {
        super();
        this.parent = parent;
    }

    /**
     * Instantiates a new abstract element.
     *
     * @param parent the parent
     * @param value  the value
     */
    public AbstractElement(Element parent, String value) {
        super();
        this.parent = parent;
        source.append(value);
    }

    /**
     * Adds the child.
     *
     * @param child the child
     * @return the abstract element
     */
    public AbstractElement addChild(Element child) {
        if (child instanceof AbstractElement) {
            AbstractElement ae = (AbstractElement) child;
            ae.parent = this;
        }
        childs.add(child);
        return this;
    }

    /**
     * Append.
     *
     * @param c the c
     * @return this AbstractElement
     * @see java.lang.StringBuilder#append(char)
     */
    public AbstractElement append(char c) {
        source.append(c);
        return this;
    }

    /**
     * Append.
     *
     * @param str the str
     * @return this AbstractElement
     * @see java.lang.StringBuilder#append(java.lang.String)
     */
    public AbstractElement append(String str) {
        source.append(str);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [value=" + source + "]";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getSource() {
        return source.toString();
    }

    /**
     * Sets the source.
     *
     * @param source the new source
     */
    public void setSource(String source) {
        this.source = new StringBuilder(source);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Element parent() {
        return parent;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Element> childs() {
        return new ArrayList<>(childs);
    }

    /**
     * 返回start.
     *
     * @return start
     */
    @Override
    public int getStart() {
        return start;
    }

    /**
     * 设置start.
     *
     * @param start start
     */
    public void setStart(int start) {
        this.start = start;
    }

    /**
     * 返回end.
     *
     * @return end
     */
    @Override
    public int getEnd() {
        return end;
    }

    /**
     * 设置end.
     *
     * @param end end
     */
    public void setEnd(int end) {
        this.end = end;
    }
}
