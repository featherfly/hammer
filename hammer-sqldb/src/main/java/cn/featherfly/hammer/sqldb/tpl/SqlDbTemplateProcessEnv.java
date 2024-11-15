
package cn.featherfly.hammer.sqldb.tpl;

import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.hammer.tpl.AbstractTemplateProcessEnv;
import cn.featherfly.hammer.tpl.TemplateDirectives;
import cn.featherfly.hammer.tpl.TemplateMethods;
import cn.featherfly.hammer.tpl.directive.PropertiesMappingDirective;
import cn.featherfly.hammer.tpl.directive.TemplateDirective;
import cn.featherfly.hammer.tpl.method.TemplateMethod;

/**
 * SqlDbTemplateEnv .
 *
 * @author zhongj
 * @param <D> the generic type
 * @param <M> the generic type
 */
public abstract class SqlDbTemplateProcessEnv<D extends TemplateDirective, M extends TemplateMethod>
    extends AbstractTemplateProcessEnv<D, M> {

    /** The mapping factory. */
    protected JdbcMappingFactory mappingFactory;

    /** The dialect. */
    protected Dialect dialect;

    protected final boolean shared;

    /**
     * Instantiates a new sql db template process env.
     */
    public SqlDbTemplateProcessEnv(boolean shared) {
        super();
        this.shared = shared;
    }

    /**
     * set mappingFactory.
     *
     * @param mappingFactory mappingFactory
     */
    public void setMappingFactory(JdbcMappingFactory mappingFactory) {
        this.mappingFactory = mappingFactory;
        setDialect(mappingFactory.getDialect());
    }

    /**
     * get mappingFactory.
     *
     * @return mappingFactory
     */
    public JdbcMappingFactory getMappingFactory() {
        return mappingFactory;
    }

    /**
     * get dialect.
     *
     * @return dialect
     */
    public Dialect getDialect() {
        return dialect;
    }

    /**
     * set dialect.
     *
     * @param dialect dialect
     */
    public void setDialect(Dialect dialect) {
        this.dialect = dialect;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TemplateDirectives<D> createDirectives() {
        TemplateDirectives<D> directives = new TemplateDirectives<>();
        if (shared) {
            directives.addWrapDirective(createWrapDirective());
            directives.addStringReplaceDirective(createStringReplaceDirective());

            // include
            directives.addTemplateIncludeDirective(createIncludeDirective());
            directives.addDirective("sql", createIncludeDirective());
            // include
        } else {
            directives.addWhereDirective(createWhereDirective());
            directives.addAndDirective(createAndDirective());
            directives.addOrDirective(createOrDirective());

            //        directives.addWrapDirective(createWrapDirective());
            //        directives.addStringReplaceDirective(createStringReplaceDirective());

            // properties
            directives.addPropertiesDirective(createPropertiesDirective());
            D directive = createPropertiesDirective();
            if (directive instanceof PropertiesMappingDirective) {
                PropertiesMappingDirective p = (PropertiesMappingDirective) directive;
                p.setParamName("table");
                directives.addDirective("columns", directive);
            }
            // properties
        }
        return directives;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TemplateMethods<M> createMethods() {
        TemplateMethods<M> methods = new TemplateMethods<>();
        if (shared) {
            methods.addWrapMethode(createWrapMethode());
            methods.addStringReplaceMethode(createStringReplaceMethode());
        }
        return methods;
    }
}
