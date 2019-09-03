
package cn.featherfly.juorm.config;

import cn.featherfly.constant.annotation.Constant;
import cn.featherfly.juorm.tpl.TemplateProcessor;
import cn.featherfly.juorm.tpl.TplConfigFactory;

/**
 * <p>
 * JuormConstant
 * </p>
 * <p>
 * 2019-08-26
 * </p>
 *
 * @author zhongj
 */
public abstract class JuormConstant {

    public static final String DEFAULT_SUFFIX = ".yaml.tpl";

    public static final String DEFAULT_PREFIX = "";

    @Constant(value = "TplConfig file suffix")
    private String tplConfigSuffix = DEFAULT_SUFFIX;

    @Constant(value = "TplConfig file prefix")
    private String tplConfigPrefix = DEFAULT_PREFIX;

    @Constant(value = "TplConfig file factory")
    private TplConfigFactory tplConfigFactory;

    @Constant(value = "template processor")
    @SuppressWarnings("rawtypes")
    private TemplateProcessor templateProcessor;

    /**
     * 返回tplConfigFactory
     *
     * @return tplConfigFactory
     */
    public TplConfigFactory getTplConfigFactory() {
        //        if (tplConfigFactory == null) {
        //            synchronized (this) {
        //                if (tplConfigFactory == null) {
        //                    tplConfigFactory = new TplConfigFactoryImpl(tplConfigPrefix, tplConfigSuffix);
        //                }
        //            }
        //        }
        return tplConfigFactory;
    }

    /**
     * 返回templateProcessor
     *
     * @return templateProcessor
     */
    @SuppressWarnings("rawtypes")
    public TemplateProcessor getTemplateProcessor() {
        //        if (templateProcessor == null) {
        //            synchronized (this) {
        //                if (templateProcessor == null && getTplConfigFactory() != null) {
        //                    templateProcessor = new FreemarkerTemplateProcessor(getTplConfigFactory());
        //                }
        //            }
        //        }
        return templateProcessor;
    }

    /**
     * 返回tplConfigSuffix
     *
     * @return tplConfigSuffix
     */
    public String getTplConfigSuffix() {
        return tplConfigSuffix;
    }

    /**
     * 返回tplConfigPrefix
     *
     * @return tplConfigPrefix
     */
    public String getTplConfigPrefix() {
        return tplConfigPrefix;
    }
}
