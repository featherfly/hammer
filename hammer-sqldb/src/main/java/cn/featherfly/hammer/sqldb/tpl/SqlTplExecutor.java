
package cn.featherfly.hammer.sqldb.tpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.Nonnull;
import javax.cache.Cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.featherfly.common.db.SqlUtils;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.exception.NotImplementedException;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.AutoCloseableIterable;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.mapper.RowMapper;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.common.structure.page.SimplePaginationResults;
import cn.featherfly.common.tuple.Tuple2;
import cn.featherfly.common.tuple.Tuple3;
import cn.featherfly.common.tuple.Tuple4;
import cn.featherfly.common.tuple.Tuple5;
import cn.featherfly.common.tuple.Tuple6;
import cn.featherfly.common.tuple.Tuples;
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.config.cache.QueryPageResult;
import cn.featherfly.hammer.config.tpl.TemplateConfig.CountSqlConverteStrategy;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory.SqlPageQuery;
import cn.featherfly.hammer.sqldb.tpl.freemarker.directive.WhereDirectiveModel;
import cn.featherfly.hammer.tpl.TemplateDirectives;
import cn.featherfly.hammer.tpl.TplConfigFactory;
import cn.featherfly.hammer.tpl.TplException;
import cn.featherfly.hammer.tpl.TplExecuteConfig;
import cn.featherfly.hammer.tpl.TplExecuteConfig.ParamsFormat;
import cn.featherfly.hammer.tpl.TplExecuteId;
import cn.featherfly.hammer.tpl.TplExecutor;
import cn.featherfly.hammer.tpl.Transverter;
import cn.featherfly.hammer.tpl.TransverterManager;
import cn.featherfly.hammer.tpl.directive.TemplateDirective;
import cn.featherfly.hammer.tpl.method.TemplateMethod;
import cn.featherfly.hammer.tpl.supports.WhereConditionParams.Param;
import cn.featherfly.hammer.tpl.supports.ConditionParamsManager;
import cn.featherfly.hammer.tpl.supports.PropertiesMappingManager;

/**
 * sql template executor .
 *
 * @author zhongj
 */
public class SqlTplExecutor implements TplExecutor {

    /** The logger. */
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /** The config factory. */
    private TplConfigFactory configFactory;

    /** The jdbc. */
    private Jdbc jdbc;

    /** The mapping factory. */
    private JdbcMappingFactory mappingFactory;

    /** The template engine. */
    private SqlDbTemplateEngine<TemplateDirective, TemplateMethod> templateEngine;

    /** The sql page factory. */
    private SqlPageFactory sqlPageFactory;

    private TransverterManager transverterManager;

    private final HammerConfig hammerConfig;

    /**
     * Instantiates a new sql tpl executor.
     *
     * @param hammerConfig the hammer config
     * @param configFactory configFactory
     * @param templateEngine templateEngine
     * @param jdbc jdbc
     * @param mappingFactory mappingFactory
     * @param sqlPageFactory the sql page factory
     * @param transverterManager the transverter manager
     */
    @SuppressWarnings("unchecked")
    public SqlTplExecutor(@Nonnull HammerConfig hammerConfig, @Nonnull TplConfigFactory configFactory,
        @SuppressWarnings("rawtypes") @Nonnull SqlDbTemplateEngine templateEngine, @Nonnull Jdbc jdbc,
        @Nonnull JdbcMappingFactory mappingFactory, SqlPageFactory sqlPageFactory,
        TransverterManager transverterManager) {
        super();
        this.hammerConfig = hammerConfig;
        this.configFactory = configFactory;
        this.jdbc = jdbc;
        this.mappingFactory = mappingFactory;
        this.templateEngine = templateEngine;
        this.sqlPageFactory = sqlPageFactory;
        this.transverterManager = transverterManager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int execute(String tplExecuteId, Map<String, Serializable> params) {
        return execute(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int execute(TplExecuteId tplExecuteId, Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
            PropertiesMappingManager> queryExecution = getQueryExecution(tplExecuteId, params, Integer.class);
        String sql = queryExecution.get0();
        ConditionParamsManager manager = queryExecution.get2();
        return jdbc.update(sql, getEffectiveParamMap(params, manager));
        // 模板SQL不支持默认占位符 xxx = ?
        //        if (manager.getParamNamed() == null || manager.getParamNamed()) {
        //            return jdbc.update(sql, getEffectiveParamMap(params, manager));
        //        } else {
        //            return jdbc.update(sql, getEffectiveParamArray(params, manager));
        //        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Serializable> single(String tplExecuteId, Map<String, Serializable> params) {
        return single(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Serializable> single(TplExecuteId tplExecuteId, Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
            PropertiesMappingManager> tuple3 = getQueryExecution(tplExecuteId, params, ArrayUtils.EMPTY_CLASS_ARRAY);
        String sql = tuple3.get0();
        ConditionParamsManager manager = tuple3.get2();
        TplExecuteConfig config = tuple3.get1();
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.querySingle(sql, getEffectiveParamArray(params, manager, config));
        } else {
            return jdbc.querySingle(sql, getEffectiveParamMap(params, manager));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E single(String tplExecuteId, Class<E> entityType, Map<String, Serializable> params) {
        return single(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E single(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
            PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, entityType);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        TplExecuteConfig config = tuple4.get1();
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.querySingle(sql, entityType, getEffectiveParamArray(params, manager, config));
        } else {
            return jdbc.querySingle(sql, entityType, getEffectiveParamMap(params, manager));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T single(TplExecuteId tplExecuteId, RowMapper<T> rowMapper, Map<String, Serializable> params) {
        // NOIMPL 模板执行未实现映射参数为RowMapper的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> Tuple2<R1, R2> single(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
        Map<String, Serializable> params) {
        return single(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> Tuple2<R1, R2> single(TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
        Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
            PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, entityType1, entityType2);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        PropertiesMappingManager propManager = tuple4.get3();
        TplExecuteConfig config = tuple4.get1();
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.querySingle(sql, entityType1, entityType2,
                Tuples.of(propManager.getValue(0).getAlias() + ".", propManager.getValue(1).getAlias() + "."),
                getEffectiveParamArray(params, manager, config));
        } else {
            return jdbc.querySingle(sql, entityType1, entityType2,
                Tuples.of(propManager.getValue(0).getAlias() + ".", propManager.getValue(1).getAlias() + "."),
                getEffectiveParamMap(params, manager));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> Tuple2<R1, R2> single(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
        Tuple2<String, String> prefixes, Map<String, Serializable> params) {
        return single(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> Tuple2<R1, R2> single(TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
        Tuple2<String, String> prefixes, Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
            PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, entityType1, entityType2);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        TplExecuteConfig config = tuple4.get1();
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.querySingle(sql, entityType1, entityType2, prefixes,
                getEffectiveParamArray(params, manager, config));
        } else {
            return jdbc.querySingle(sql, entityType1, entityType2, prefixes, getEffectiveParamMap(params, manager));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> Tuple3<R1, R2, R3> single(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
        Class<R3> entityType3, Map<String, Serializable> params) {
        return single(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> Tuple3<R1, R2, R3> single(TplExecuteId tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager, PropertiesMappingManager> tuple4 = getQueryExecution(
            tplExecuteId, params, entityType1, entityType2, entityType3);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        PropertiesMappingManager propManager = tuple4.get3();
        TplExecuteConfig config = tuple4.get1();
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.querySingle(
                sql, entityType1, entityType2, entityType3, Tuples.of(propManager.getValue(0).getAlias() + ".",
                    propManager.getValue(1).getAlias() + ".", propManager.getValue(2).getAlias() + "."),
                getEffectiveParamArray(params, manager, config));

        } else {
            return jdbc.querySingle(
                sql, entityType1, entityType2, entityType3, Tuples.of(propManager.getValue(0).getAlias() + ".",
                    propManager.getValue(1).getAlias() + ".", propManager.getValue(2).getAlias() + "."),
                getEffectiveParamMap(params, manager));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> Tuple3<R1, R2, R3> single(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
        Class<R3> entityType3, Tuple3<String, String, String> prefixes, Map<String, Serializable> params) {
        return single(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> Tuple3<R1, R2, R3> single(TplExecuteId tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Tuple3<String, String, String> prefixes,
        Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager, PropertiesMappingManager> tuple4 = getQueryExecution(
            tplExecuteId, params, entityType1, entityType2, entityType3);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        TplExecuteConfig config = tuple4.get1();
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.querySingle(sql, entityType1, entityType2, entityType3, prefixes,
                getEffectiveParamArray(params, manager, config));
        } else {
            return jdbc.querySingle(sql, entityType1, entityType2, entityType3, prefixes,
                getEffectiveParamMap(params, manager));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> Tuple4<R1, R2, R3, R4> single(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Map<String, Serializable> params) {
        return single(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, entityType4, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> Tuple4<R1, R2, R3, R4> single(TplExecuteId tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager, PropertiesMappingManager> tuple4 = getQueryExecution(
            tplExecuteId, params, entityType1, entityType2, entityType3, entityType4);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        PropertiesMappingManager propManager = tuple4.get3();
        TplExecuteConfig config = tuple4.get1();
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.querySingle(sql, entityType1, entityType2, entityType3, entityType4,
                Tuples.of(propManager.getValue(0).getAlias() + ".", propManager.getValue(1).getAlias() + ".",
                    propManager.getValue(2).getAlias() + ".", propManager.getValue(3).getAlias() + "."),
                getEffectiveParamArray(params, manager, config));
        } else {
            return jdbc.querySingle(sql, entityType1, entityType2, entityType3, entityType4,
                Tuples.of(propManager.getValue(0).getAlias() + ".", propManager.getValue(1).getAlias() + ".",
                    propManager.getValue(2).getAlias() + ".", propManager.getValue(3).getAlias() + "."),
                getEffectiveParamMap(params, manager));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> Tuple4<R1, R2, R3, R4> single(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Tuple4<String, String, String, String> prefixes, Map<String, Serializable> params) {
        return single(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, entityType4, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> Tuple4<R1, R2, R3, R4> single(TplExecuteId tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Tuple4<String, String, String, String> prefixes, Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager, PropertiesMappingManager> tuple4 = getQueryExecution(
            tplExecuteId, params, entityType1, entityType2, entityType3, entityType4);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        TplExecuteConfig config = tuple4.get1();
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.querySingle(sql, entityType1, entityType2, entityType3, entityType4, prefixes,
                getEffectiveParamArray(params, manager, config));
        } else {
            return jdbc.querySingle(sql, entityType1, entityType2, entityType3, entityType4, prefixes,
                getEffectiveParamMap(params, manager));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> Tuple5<R1, R2, R3, R4, R5> single(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
        Map<String, Serializable> params) {
        return single(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, entityType4, entityType5, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> Tuple5<R1, R2, R3, R4, R5> single(TplExecuteId tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
        Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager, PropertiesMappingManager> tuple4 = getQueryExecution(
            tplExecuteId, params, entityType1, entityType2, entityType3, entityType4, entityType5);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        PropertiesMappingManager propManager = tuple4.get3();
        TplExecuteConfig config = tuple4.get1();
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.querySingle(sql, entityType1, entityType2, entityType3, entityType4, entityType5,
                Tuples.of(propManager.getValue(0).getAlias() + ".", propManager.getValue(1).getAlias() + ".",
                    propManager.getValue(2).getAlias() + ".", propManager.getValue(3).getAlias() + ".",
                    propManager.getValue(4).getAlias() + "."),
                getEffectiveParamArray(params, manager, config));
        } else {
            return jdbc.querySingle(sql, entityType1, entityType2, entityType3, entityType4, entityType5,
                Tuples.of(propManager.getValue(0).getAlias() + ".", propManager.getValue(1).getAlias() + ".",
                    propManager.getValue(2).getAlias() + ".", propManager.getValue(3).getAlias() + ".",
                    propManager.getValue(4).getAlias() + "."),
                getEffectiveParamMap(params, manager));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> Tuple5<R1, R2, R3, R4, R5> single(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
        Tuple5<String, String, String, String, String> prefixes, Map<String, Serializable> params) {
        return single(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, entityType4, entityType5, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> Tuple5<R1, R2, R3, R4, R5> single(TplExecuteId tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
        Tuple5<String, String, String, String, String> prefixes, Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager, PropertiesMappingManager> tuple4 = getQueryExecution(
            tplExecuteId, params, entityType1, entityType2, entityType3, entityType4, entityType5);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        TplExecuteConfig config = tuple4.get1();
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.querySingle(sql, entityType1, entityType2, entityType3, entityType4, entityType5, prefixes,
                getEffectiveParamArray(params, manager, config));
        } else {
            return jdbc.querySingle(sql, entityType1, entityType2, entityType3, entityType4, entityType5, prefixes,
                getEffectiveParamMap(params, manager));

        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> Tuple6<R1, R2, R3, R4, R5, R6> single(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
        Class<R6> entityType6, Map<String, Serializable> params) {
        return single(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, entityType4, entityType5, entityType6, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> Tuple6<R1, R2, R3, R4, R5, R6> single(TplExecuteId tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Class<R5> entityType5, Class<R6> entityType6, Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager, PropertiesMappingManager> tuple4 = getQueryExecution(
            tplExecuteId, params, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        PropertiesMappingManager propManager = tuple4.get3();
        TplExecuteConfig config = tuple4.get1();
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.querySingle(sql, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6,
                Tuples.of(propManager.getValue(0).getAlias() + ".", propManager.getValue(1).getAlias() + ".",
                    propManager.getValue(2).getAlias() + ".", propManager.getValue(3).getAlias() + ".",
                    propManager.getValue(4).getAlias() + ".", propManager.getValue(5).getAlias() + "."),
                getEffectiveParamArray(params, manager, config));
        } else {
            return jdbc.querySingle(sql, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6,
                Tuples.of(propManager.getValue(0).getAlias() + ".", propManager.getValue(1).getAlias() + ".",
                    propManager.getValue(2).getAlias() + ".", propManager.getValue(3).getAlias() + ".",
                    propManager.getValue(4).getAlias() + ".", propManager.getValue(5).getAlias() + "."),
                getEffectiveParamMap(params, manager));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> Tuple6<R1, R2, R3, R4, R5, R6> single(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
        Class<R6> entityType6, Tuple6<String, String, String, String, String, String> prefixes,
        Map<String, Serializable> params) {
        return single(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, entityType4, entityType5, entityType6, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> Tuple6<R1, R2, R3, R4, R5, R6> single(TplExecuteId tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Class<R5> entityType5, Class<R6> entityType6, Tuple6<String, String, String, String, String, String> prefixes,
        Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager, PropertiesMappingManager> tuple4 = getQueryExecution(
            tplExecuteId, params, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        TplExecuteConfig config = tuple4.get1();
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.querySingle(sql, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6,
                prefixes, getEffectiveParamArray(params, manager, config));
        } else {
            return jdbc.querySingle(sql, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6,
                prefixes, getEffectiveParamMap(params, manager));
        }
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Serializable> unique(String tplExecuteId, Map<String, Serializable> params) {
        return unique(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Serializable> unique(TplExecuteId tplExecuteId, Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
            PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, ArrayUtils.EMPTY_CLASS_ARRAY);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        TplExecuteConfig config = tuple4.get1();
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.queryUnique(sql, getEffectiveParamArray(params, manager, config));
        } else {
            return jdbc.queryUnique(sql, getEffectiveParamMap(params, manager));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E unique(String tplExecuteId, Class<E> entityType, Map<String, Serializable> params) {
        return unique(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T unique(TplExecuteId execution, RowMapper<T> rowMapper, Map<String, Serializable> params) {
        // NOIMPL 模板执行未实现映射参数为RowMapper的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E unique(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
            PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, entityType);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        TplExecuteConfig config = tuple4.get1();
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.queryUnique(sql, entityType, getEffectiveParamArray(params, manager, config));
        } else {
            return jdbc.queryUnique(sql, entityType, getEffectiveParamMap(params, manager));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> Tuple2<R1, R2> unique(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
        Map<String, Serializable> params) {
        return unique(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> Tuple2<R1, R2> unique(TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
        Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
            PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, entityType1, entityType2);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        PropertiesMappingManager propManager = tuple4.get3();
        TplExecuteConfig config = tuple4.get1();
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.queryUnique(sql, entityType1, entityType2,
                Tuples.of(propManager.getValue(0).getAlias() + ".", propManager.getValue(1).getAlias() + "."),
                getEffectiveParamArray(params, manager, config));
        } else {
            return jdbc.queryUnique(sql, entityType1, entityType2,
                Tuples.of(propManager.getValue(0).getAlias() + ".", propManager.getValue(1).getAlias() + "."),
                getEffectiveParamMap(params, manager));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> Tuple2<R1, R2> unique(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
        Tuple2<String, String> prefixes, Map<String, Serializable> params) {
        return unique(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> Tuple2<R1, R2> unique(TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
        Tuple2<String, String> prefixes, Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
            PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, entityType1, entityType2);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        TplExecuteConfig config = tuple4.get1();
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.queryUnique(sql, entityType1, entityType2, prefixes,
                getEffectiveParamArray(params, manager, config));
        } else {
            return jdbc.queryUnique(sql, entityType1, entityType2, prefixes, getEffectiveParamMap(params, manager));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> Tuple3<R1, R2, R3> unique(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
        Class<R3> entityType3, Map<String, Serializable> params) {
        return unique(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> Tuple3<R1, R2, R3> unique(TplExecuteId tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager, PropertiesMappingManager> tuple4 = getQueryExecution(
            tplExecuteId, params, entityType1, entityType2, entityType3);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        PropertiesMappingManager propManager = tuple4.get3();
        TplExecuteConfig config = tuple4.get1();
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.queryUnique(
                sql, entityType1, entityType2, entityType3, Tuples.of(propManager.getValue(0).getAlias() + ".",
                    propManager.getValue(1).getAlias() + ".", propManager.getValue(2).getAlias() + "."),
                getEffectiveParamArray(params, manager, config));

        } else {
            return jdbc.queryUnique(
                sql, entityType1, entityType2, entityType3, Tuples.of(propManager.getValue(0).getAlias() + ".",
                    propManager.getValue(1).getAlias() + ".", propManager.getValue(2).getAlias() + "."),
                getEffectiveParamMap(params, manager));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> Tuple3<R1, R2, R3> unique(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
        Class<R3> entityType3, Tuple3<String, String, String> prefixes, Map<String, Serializable> params) {
        return unique(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> Tuple3<R1, R2, R3> unique(TplExecuteId tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Tuple3<String, String, String> prefixes,
        Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager, PropertiesMappingManager> tuple4 = getQueryExecution(
            tplExecuteId, params, entityType1, entityType2, entityType3);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        TplExecuteConfig config = tuple4.get1();
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.queryUnique(sql, entityType1, entityType2, entityType3, prefixes,
                getEffectiveParamArray(params, manager, config));
        } else {
            return jdbc.queryUnique(sql, entityType1, entityType2, entityType3, prefixes,
                getEffectiveParamMap(params, manager));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> Tuple4<R1, R2, R3, R4> unique(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Map<String, Serializable> params) {
        return unique(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, entityType4, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> Tuple4<R1, R2, R3, R4> unique(TplExecuteId tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager, PropertiesMappingManager> tuple4 = getQueryExecution(
            tplExecuteId, params, entityType1, entityType2, entityType3, entityType4);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        PropertiesMappingManager propManager = tuple4.get3();
        TplExecuteConfig config = tuple4.get1();
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.queryUnique(sql, entityType1, entityType2, entityType3, entityType4,
                Tuples.of(propManager.getValue(0).getAlias() + ".", propManager.getValue(1).getAlias() + ".",
                    propManager.getValue(2).getAlias() + ".", propManager.getValue(3).getAlias() + "."),
                getEffectiveParamArray(params, manager, config));
        } else {
            return jdbc.queryUnique(sql, entityType1, entityType2, entityType3, entityType4,
                Tuples.of(propManager.getValue(0).getAlias() + ".", propManager.getValue(1).getAlias() + ".",
                    propManager.getValue(2).getAlias() + ".", propManager.getValue(3).getAlias() + "."),
                getEffectiveParamMap(params, manager));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> Tuple4<R1, R2, R3, R4> unique(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Tuple4<String, String, String, String> prefixes, Map<String, Serializable> params) {
        return unique(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, entityType4, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> Tuple4<R1, R2, R3, R4> unique(TplExecuteId tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Tuple4<String, String, String, String> prefixes, Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager, PropertiesMappingManager> tuple4 = getQueryExecution(
            tplExecuteId, params, entityType1, entityType2, entityType3, entityType4);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        TplExecuteConfig config = tuple4.get1();
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.queryUnique(sql, entityType1, entityType2, entityType3, entityType4, prefixes,
                getEffectiveParamArray(params, manager, config));
        } else {
            return jdbc.queryUnique(sql, entityType1, entityType2, entityType3, entityType4, prefixes,
                getEffectiveParamMap(params, manager));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> Tuple5<R1, R2, R3, R4, R5> unique(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
        Map<String, Serializable> params) {
        return unique(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, entityType4, entityType5, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> Tuple5<R1, R2, R3, R4, R5> unique(TplExecuteId tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
        Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager, PropertiesMappingManager> tuple4 = getQueryExecution(
            tplExecuteId, params, entityType1, entityType2, entityType3, entityType4, entityType5);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        PropertiesMappingManager propManager = tuple4.get3();
        TplExecuteConfig config = tuple4.get1();
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.queryUnique(sql, entityType1, entityType2, entityType3, entityType4, entityType5,
                Tuples.of(propManager.getValue(0).getAlias() + ".", propManager.getValue(1).getAlias() + ".",
                    propManager.getValue(2).getAlias() + ".", propManager.getValue(3).getAlias() + ".",
                    propManager.getValue(4).getAlias() + "."),
                getEffectiveParamArray(params, manager, config));
        } else {
            return jdbc.queryUnique(sql, entityType1, entityType2, entityType3, entityType4, entityType5,
                Tuples.of(propManager.getValue(0).getAlias() + ".", propManager.getValue(1).getAlias() + ".",
                    propManager.getValue(2).getAlias() + ".", propManager.getValue(3).getAlias() + ".",
                    propManager.getValue(4).getAlias() + "."),
                getEffectiveParamMap(params, manager));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> Tuple5<R1, R2, R3, R4, R5> unique(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
        Tuple5<String, String, String, String, String> prefixes, Map<String, Serializable> params) {
        return unique(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, entityType4, entityType5, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> Tuple5<R1, R2, R3, R4, R5> unique(TplExecuteId tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
        Tuple5<String, String, String, String, String> prefixes, Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager, PropertiesMappingManager> tuple4 = getQueryExecution(
            tplExecuteId, params, entityType1, entityType2, entityType3, entityType4, entityType5);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        TplExecuteConfig config = tuple4.get1();
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.queryUnique(sql, entityType1, entityType2, entityType3, entityType4, entityType5, prefixes,
                getEffectiveParamArray(params, manager, config));
        } else {
            return jdbc.queryUnique(sql, entityType1, entityType2, entityType3, entityType4, entityType5, prefixes,
                getEffectiveParamMap(params, manager));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> Tuple6<R1, R2, R3, R4, R5, R6> unique(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
        Class<R6> entityType6, Map<String, Serializable> params) {
        return unique(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, entityType4, entityType5, entityType6, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> Tuple6<R1, R2, R3, R4, R5, R6> unique(TplExecuteId tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Class<R5> entityType5, Class<R6> entityType6, Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager, PropertiesMappingManager> tuple4 = getQueryExecution(
            tplExecuteId, params, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        PropertiesMappingManager propManager = tuple4.get3();
        TplExecuteConfig config = tuple4.get1();
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.queryUnique(sql, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6,
                Tuples.of(propManager.getValue(0).getAlias() + ".", propManager.getValue(1).getAlias() + ".",
                    propManager.getValue(2).getAlias() + ".", propManager.getValue(3).getAlias() + ".",
                    propManager.getValue(4).getAlias() + ".", propManager.getValue(5).getAlias() + "."),
                getEffectiveParamArray(params, manager, config));
        } else {
            return jdbc.queryUnique(sql, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6,
                Tuples.of(propManager.getValue(0).getAlias() + ".", propManager.getValue(1).getAlias() + ".",
                    propManager.getValue(2).getAlias() + ".", propManager.getValue(3).getAlias() + ".",
                    propManager.getValue(4).getAlias() + ".", propManager.getValue(5).getAlias() + "."),
                getEffectiveParamMap(params, manager));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> Tuple6<R1, R2, R3, R4, R5, R6> unique(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
        Class<R6> entityType6, Tuple6<String, String, String, String, String, String> prefixes,
        Map<String, Serializable> params) {
        return unique(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, entityType4, entityType5, entityType6, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> Tuple6<R1, R2, R3, R4, R5, R6> unique(TplExecuteId tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Class<R5> entityType5, Class<R6> entityType6, Tuple6<String, String, String, String, String, String> prefixes,
        Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager, PropertiesMappingManager> tuple4 = getQueryExecution(
            tplExecuteId, params, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        TplExecuteConfig config = tuple4.get1();
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.queryUnique(sql, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6,
                prefixes, getEffectiveParamArray(params, manager, config));
        } else {
            return jdbc.queryUnique(sql, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6,
                prefixes, getEffectiveParamMap(params, manager));
        }
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Serializable>> list(String tplExecuteId, Map<String, Serializable> params) {
        return list(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Serializable>> list(TplExecuteId tplExecuteId, Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
            PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, ArrayUtils.EMPTY_CLASS_ARRAY);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        TplExecuteConfig config = tuple4.get1();
        // after getQueryExecution
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.queryList(sql, getEffectiveParamArray(params, manager, config));
        } else {
            return jdbc.queryList(sql, getEffectiveParamMap(params, manager));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(String tplExecuteId, Class<E> entityType, Map<String, Serializable> params) {
        return list(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> List<T> list(TplExecuteId execution, RowMapper<T> rowMapper, Map<String, Serializable> params) {
        // NOIMPL 模板执行未实现映射参数为RowMapper的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
            PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, entityType);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        TplExecuteConfig config = tuple4.get1();
        // after getQueryExecution
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.queryList(sql, entityType, getEffectiveParamArray(params, manager, config));
        } else {
            return jdbc.queryList(sql, entityType, getEffectiveParamMap(params, manager));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Serializable>> list(String tplExecuteId, Map<String, Serializable> params, int offset,
        int limit) {
        return list(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), params, offset,
            limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> List<T> list(TplExecuteId execution, RowMapper<T> rowMapper, Map<String, Serializable> params,
        int offset, int limit) {
        // NOIMPL 模板执行未实现映射参数为RowMapper的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Serializable>> list(TplExecuteId tplExecuteId, Map<String, Serializable> params, int offset,
        int limit) {
        return findList(tplExecuteId, params, offset, limit).get0();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(String tplExecuteId, Class<E> entityType, Map<String, Serializable> params, int offset,
        int limit) {
        return list(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType, params,
            offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Serializable> params,
        int offset, int limit) {
        return findList(tplExecuteId, entityType, params, offset, limit).get0();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> List<Tuple2<R1, R2>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
        Map<String, Serializable> params) {
        return list(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, params);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> List<Tuple2<R1, R2>> list(TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
        Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
            PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, entityType1, entityType2);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        PropertiesMappingManager propManager = tuple4.get3();
        TplExecuteConfig config = tuple4.get1();
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.queryList(sql, entityType1, entityType2,
                Tuples.of(propManager.getValue(0).getAlias() + ".", propManager.getValue(1).getAlias() + "."),
                getEffectiveParamArray(params, manager, config));
        } else {
            return jdbc.queryList(sql, entityType1, entityType2,
                Tuples.of(propManager.getValue(0).getAlias() + ".", propManager.getValue(1).getAlias() + "."),
                getEffectiveParamMap(params, manager));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> List<Tuple2<R1, R2>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
        Map<String, Serializable> params, int offset, int limit) {
        return list(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> List<Tuple2<R1, R2>> list(TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
        Map<String, Serializable> params, int offset, int limit) {
        return findList(tplExecuteId, entityType1, entityType2, null, params, offset, limit).get0();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> List<Tuple2<R1, R2>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
        Tuple2<String, String> prefixes, Map<String, Serializable> params) {
        return list(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> List<Tuple2<R1, R2>> list(TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
        Tuple2<String, String> prefixes, Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
            PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, entityType1, entityType2);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        TplExecuteConfig config = tuple4.get1();
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.queryList(sql, entityType1, entityType2, prefixes,
                getEffectiveParamArray(params, manager, config));
        } else {
            return jdbc.queryList(sql, entityType1, entityType2, prefixes, getEffectiveParamMap(params, manager));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> List<Tuple2<R1, R2>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
        Tuple2<String, String> prefixes, Map<String, Serializable> params, int offset, int limit) {
        return list(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, prefixes, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> List<Tuple2<R1, R2>> list(TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
        Tuple2<String, String> prefixes, Map<String, Serializable> params, int offset, int limit) {
        return findList(tplExecuteId, entityType1, entityType2, prefixes, params, offset, limit).get0();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
        Class<R3> entityType3, Map<String, Serializable> params) {
        return list(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager, PropertiesMappingManager> tuple4 = getQueryExecution(
            tplExecuteId, params, entityType1, entityType2, entityType3);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        PropertiesMappingManager propManager = tuple4.get3();
        TplExecuteConfig config = tuple4.get1();
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.queryList(sql, entityType1, entityType2, entityType3,
                Tuples.of(propManager.getValue(0) + ".", propManager.getValue(1) + ".", propManager.getValue(2) + "."),
                getEffectiveParamArray(params, manager, config));
        } else {
            return jdbc.queryList(sql, entityType1, entityType2, entityType3,
                Tuples.of(propManager.getValue(0) + ".", propManager.getValue(1) + ".", propManager.getValue(2) + "."),
                getEffectiveParamMap(params, manager));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
        Class<R3> entityType3, Map<String, Serializable> params, int offset, int limit) {
        return list(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Map<String, Serializable> params, int offset, int limit) {
        return findList(tplExecuteId, entityType1, entityType2, entityType3, null, params, offset, limit).get0();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
        Class<R3> entityType3, Tuple3<String, String, String> prefixes, Map<String, Serializable> params) {
        return list(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Tuple3<String, String, String> prefixes,
        Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager, PropertiesMappingManager> tuple4 = getQueryExecution(
            tplExecuteId, params, entityType1, entityType2, entityType3);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        TplExecuteConfig config = tuple4.get1();
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.queryList(sql, entityType1, entityType2, entityType3, prefixes,
                getEffectiveParamArray(params, manager, config));
        } else {
            return jdbc.queryList(sql, entityType1, entityType2, entityType3, prefixes,
                getEffectiveParamMap(params, manager));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
        Class<R3> entityType3, Tuple3<String, String, String> prefixes, Map<String, Serializable> params, int offset,
        int limit) {
        return list(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, prefixes, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Tuple3<String, String, String> prefixes,
        Map<String, Serializable> params, int offset, int limit) {
        return findList(tplExecuteId, entityType1, entityType2, entityType3, prefixes, params, offset, limit).get0();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Map<String, Serializable> params) {
        return list(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, entityType4, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager, PropertiesMappingManager> tuple4 = getQueryExecution(
            tplExecuteId, params, entityType1, entityType2, entityType3, entityType4);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        PropertiesMappingManager propManager = tuple4.get3();
        TplExecuteConfig config = tuple4.get1();
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.queryList(
                sql, entityType1, entityType2, entityType3, entityType4, Tuples.of(propManager.getValue(0) + ".",
                    propManager.getValue(1) + ".", propManager.getValue(2) + ".", propManager.getValue(3) + "."),
                getEffectiveParamArray(params, manager, config));
        } else {
            return jdbc.queryList(
                sql, entityType1, entityType2, entityType3, entityType4, Tuples.of(propManager.getValue(0) + ".",
                    propManager.getValue(1) + ".", propManager.getValue(2) + ".", propManager.getValue(3) + "."),
                getEffectiveParamMap(params, manager));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Map<String, Serializable> params,
        int offset, int limit) {
        return list(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, entityType4, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Map<String, Serializable> params,
        int offset, int limit) {
        return findList(tplExecuteId, entityType1, entityType2, entityType3, entityType4, null, params, offset, limit)
            .get0();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Tuple4<String, String, String, String> prefixes, Map<String, Serializable> params) {
        return list(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, entityType4, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Tuple4<String, String, String, String> prefixes, Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager, PropertiesMappingManager> tuple4 = getQueryExecution(
            tplExecuteId, params, entityType1, entityType2, entityType3, entityType4);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        TplExecuteConfig config = tuple4.get1();
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.queryList(sql, entityType1, entityType2, entityType3, entityType4, prefixes,
                getEffectiveParamArray(params, manager, config));
        } else {
            return jdbc.queryList(sql, entityType1, entityType2, entityType3, entityType4, prefixes,
                getEffectiveParamMap(params, manager));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Tuple4<String, String, String, String> prefixes, Map<String, Serializable> params, int offset, int limit) {
        return list(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, entityType4, prefixes, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Tuple4<String, String, String, String> prefixes, Map<String, Serializable> params, int offset, int limit) {
        return findList(tplExecuteId, entityType1, entityType2, entityType3, entityType4, prefixes, params, offset,
            limit).get0();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
        Map<String, Serializable> params) {
        return list(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, entityType4, entityType5, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
        Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager, PropertiesMappingManager> tuple4 = getQueryExecution(
            tplExecuteId, params, entityType1, entityType2, entityType3, entityType4, entityType5);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        PropertiesMappingManager propManager = tuple4.get3();
        TplExecuteConfig config = tuple4.get1();
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.queryList(sql, entityType1, entityType2, entityType3, entityType4, entityType5,
                Tuples.of(propManager.getValue(0) + ".", propManager.getValue(1) + ".", propManager.getValue(2) + ".",
                    propManager.getValue(3) + ".", propManager.getValue(4) + "."),
                getEffectiveParamArray(params, manager, config));
        } else {
            return jdbc.queryList(sql, entityType1, entityType2, entityType3, entityType4, entityType5,
                Tuples.of(propManager.getValue(0) + ".", propManager.getValue(1) + ".", propManager.getValue(2) + ".",
                    propManager.getValue(3) + ".", propManager.getValue(4) + "."),
                getEffectiveParamMap(params, manager));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
        Map<String, Serializable> params, int offset, int limit) {
        return list(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, entityType4, entityType5, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
        Map<String, Serializable> params, int offset, int limit) {
        return findList(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, null, params,
            offset, limit).get0();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
        Tuple5<String, String, String, String, String> prefixes, Map<String, Serializable> params) {
        return list(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, entityType4, entityType5, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
        Tuple5<String, String, String, String, String> prefixes, Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager, PropertiesMappingManager> tuple4 = getQueryExecution(
            tplExecuteId, params, entityType1, entityType2, entityType3, entityType4, entityType5);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        TplExecuteConfig config = tuple4.get1();
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.queryList(sql, entityType1, entityType2, entityType3, entityType4, entityType5, prefixes,
                getEffectiveParamArray(params, manager, config));
        } else {
            return jdbc.queryList(sql, entityType1, entityType2, entityType3, entityType4, entityType5, prefixes,
                getEffectiveParamMap(params, manager));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
        Tuple5<String, String, String, String, String> prefixes, Map<String, Serializable> params, int offset,
        int limit) {
        return list(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, entityType4, entityType5, prefixes, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
        Tuple5<String, String, String, String, String> prefixes, Map<String, Serializable> params, int offset,
        int limit) {
        return findList(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, prefixes, params,
            offset, limit).get0();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> List<Tuple6<R1, R2, R3, R4, R5, R6>> list(String tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Class<R5> entityType5, Class<R6> entityType6, Map<String, Serializable> params) {
        return list(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, entityType4, entityType5, entityType6, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> List<Tuple6<R1, R2, R3, R4, R5, R6>> list(String tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Class<R5> entityType5, Class<R6> entityType6, Map<String, Serializable> params, int offset, int limit) {
        return list(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, entityType4, entityType5, entityType6, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> List<Tuple6<R1, R2, R3, R4, R5, R6>> list(TplExecuteId tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Class<R5> entityType5, Class<R6> entityType6, Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager, PropertiesMappingManager> tuple4 = getQueryExecution(
            tplExecuteId, params, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        PropertiesMappingManager propManager = tuple4.get3();
        TplExecuteConfig config = tuple4.get1();
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.queryList(sql, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6,
                Tuples.of(propManager.getValue(0) + ".", propManager.getValue(1) + ".", propManager.getValue(2) + ".",
                    propManager.getValue(3) + ".", propManager.getValue(4) + ".", propManager.getValue(5) + "."),
                getEffectiveParamArray(params, manager, config));

        } else {
            return jdbc.queryList(sql, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6,
                Tuples.of(propManager.getValue(0) + ".", propManager.getValue(1) + ".", propManager.getValue(2) + ".",
                    propManager.getValue(3) + ".", propManager.getValue(4) + ".", propManager.getValue(5) + "."),
                getEffectiveParamMap(params, manager));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> List<Tuple6<R1, R2, R3, R4, R5, R6>> list(TplExecuteId tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Class<R5> entityType5, Class<R6> entityType6, Map<String, Serializable> params, int offset, int limit) {
        return findList(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6,
            null, params, offset, limit).get0();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> List<Tuple6<R1, R2, R3, R4, R5, R6>> list(String tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Class<R5> entityType5, Class<R6> entityType6, Tuple6<String, String, String, String, String, String> prefixes,
        Map<String, Serializable> params) {
        return list(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, entityType4, entityType5, entityType6, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> List<Tuple6<R1, R2, R3, R4, R5, R6>> list(String tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Class<R5> entityType5, Class<R6> entityType6, Tuple6<String, String, String, String, String, String> prefixes,
        Map<String, Serializable> params, int offset, int limit) {
        return list(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, entityType4, entityType5, entityType6, prefixes, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> List<Tuple6<R1, R2, R3, R4, R5, R6>> list(TplExecuteId tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Class<R5> entityType5, Class<R6> entityType6, Tuple6<String, String, String, String, String, String> prefixes,
        Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager, PropertiesMappingManager> tuple4 = getQueryExecution(
            tplExecuteId, params, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        TplExecuteConfig config = tuple4.get1();
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.queryList(sql, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6,
                prefixes, getEffectiveParamArray(params, manager, config));
        } else {
            return jdbc.queryList(sql, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6,
                prefixes, getEffectiveParamMap(params, manager));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> List<Tuple6<R1, R2, R3, R4, R5, R6>> list(TplExecuteId tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Class<R5> entityType5, Class<R6> entityType6, Tuple6<String, String, String, String, String, String> prefixes,
        Map<String, Serializable> params, int offset, int limit) {
        return findList(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6,
            prefixes, params, offset, limit).get0();
    }

    // ----------------------------------------------------------------------------------------------------------------

    @Override
    public AutoCloseableIterable<Map<String, Serializable>> each(String tplExecuteId,
        Map<String, Serializable> params) {
        return each(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AutoCloseableIterable<Map<String, Serializable>> each(TplExecuteId tplExecuteId,
        Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
            PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, ArrayUtils.EMPTY_CLASS_ARRAY);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        TplExecuteConfig config = tuple4.get1();
        // after getQueryExecution
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.queryEach(sql, getEffectiveParamArray(params, manager, config));
        } else {
            return jdbc.queryEach(sql, getEffectiveParamMap(params, manager));
        }
    }

    @Override
    public <E> AutoCloseableIterable<E> each(String tplExecuteId, Class<E> entityType,
        Map<String, Serializable> params) {
        return each(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> AutoCloseableIterable<E> each(TplExecuteId tplExecuteId, Class<E> entityType,
        Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
            PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, entityType);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        TplExecuteConfig config = tuple4.get1();
        // after getQueryExecution
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.queryEach(sql, entityType, getEffectiveParamArray(params, manager, config));
        } else {
            return jdbc.queryEach(sql, entityType, getEffectiveParamMap(params, manager));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> AutoCloseableIterable<T> each(String tplExecuteId, RowMapper<T> rowMapper,
        Map<String, Serializable> params) {
        // NOIMPL 模板执行未实现映射参数为RowMapper的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> AutoCloseableIterable<T> each(TplExecuteId execution, RowMapper<T> rowMapper,
        Map<String, Serializable> params) {
        // NOIMPL 模板执行未实现映射参数为RowMapper的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> AutoCloseableIterable<T> each(String tplExecuteId, RowMapper<T> rowMapper,
        Map<String, Serializable> params, int offset, int limit) {
        // NOIMPL 模板执行未实现映射参数为RowMapper的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> AutoCloseableIterable<T> each(TplExecuteId execution, RowMapper<T> rowMapper,
        Map<String, Serializable> params, int offset, int limit) {
        // NOIMPL 模板执行未实现映射参数为RowMapper的情况
        throw new NotImplementedException();
    }

    @Override
    public AutoCloseableIterable<Map<String, Serializable>> each(String tplExecuteId, Map<String, Serializable> params,
        int offset, int limit) {
        return each(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), params, offset,
            limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AutoCloseableIterable<Map<String, Serializable>> each(TplExecuteId tplExecuteId,
        Map<String, Serializable> params, int offset, int limit) {
        return findEach(tplExecuteId, params, offset, limit).get0();
    }

    @Override
    public <E> AutoCloseableIterable<E> each(String tplExecuteId, Class<E> entityType, Map<String, Serializable> params,
        int offset, int limit) {
        return each(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType, params,
            offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> AutoCloseableIterable<E> each(TplExecuteId tplExecuteId, Class<E> entityType,
        Map<String, Serializable> params, int offset, int limit) {
        return findEach(tplExecuteId, entityType, params, offset, limit).get0();
    }

    public <R1, R2> AutoCloseableIterable<Tuple2<R1, R2>> each(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Map<String, Serializable> params) {
        return each(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, params);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> AutoCloseableIterable<Tuple2<R1, R2>> each(TplExecuteId tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
            PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, entityType1, entityType2);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        PropertiesMappingManager propManager = tuple4.get3();
        TplExecuteConfig config = tuple4.get1();
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.queryEach(sql, entityType1, entityType2,
                Tuples.of(propManager.getValue(0).getAlias() + ".", propManager.getValue(1).getAlias() + "."),
                getEffectiveParamArray(params, manager, config));
        } else {
            return jdbc.queryEach(sql, entityType1, entityType2,
                Tuples.of(propManager.getValue(0).getAlias() + ".", propManager.getValue(1).getAlias() + "."),
                getEffectiveParamMap(params, manager));
        }
    }

    public <R1, R2> AutoCloseableIterable<Tuple2<R1, R2>> each(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Map<String, Serializable> params, int offset, int limit) {
        return each(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> AutoCloseableIterable<Tuple2<R1, R2>> each(TplExecuteId tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Map<String, Serializable> params, int offset, int limit) {
        return findEach(tplExecuteId, entityType1, entityType2, null, params, offset, limit).get0();
    }

    public <R1, R2> AutoCloseableIterable<Tuple2<R1, R2>> each(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Tuple2<String, String> prefixes, Map<String, Serializable> params) {
        return each(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> AutoCloseableIterable<Tuple2<R1, R2>> each(TplExecuteId tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Tuple2<String, String> prefixes, Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
            PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, entityType1, entityType2);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        TplExecuteConfig config = tuple4.get1();
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.queryEach(sql, entityType1, entityType2, prefixes,
                getEffectiveParamArray(params, manager, config));
        } else {
            return jdbc.queryEach(sql, entityType1, entityType2, prefixes, getEffectiveParamMap(params, manager));
        }
    }

    public <R1, R2> AutoCloseableIterable<Tuple2<R1, R2>> each(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Tuple2<String, String> prefixes, Map<String, Serializable> params, int offset,
        int limit) {
        return each(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, prefixes, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> AutoCloseableIterable<Tuple2<R1, R2>> each(TplExecuteId tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Tuple2<String, String> prefixes, Map<String, Serializable> params, int offset,
        int limit) {
        return findEach(tplExecuteId, entityType1, entityType2, prefixes, params, offset, limit).get0();
    }

    public <R1, R2, R3> AutoCloseableIterable<Tuple3<R1, R2, R3>> each(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Map<String, Serializable> params) {
        return each(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> AutoCloseableIterable<Tuple3<R1, R2, R3>> each(TplExecuteId tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager, PropertiesMappingManager> tuple4 = getQueryExecution(
            tplExecuteId, params, entityType1, entityType2, entityType3);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        PropertiesMappingManager propManager = tuple4.get3();
        TplExecuteConfig config = tuple4.get1();
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.queryEach(sql, entityType1, entityType2, entityType3,
                Tuples.of(propManager.getValue(0) + ".", propManager.getValue(1) + ".", propManager.getValue(2) + "."),
                getEffectiveParamArray(params, manager, config));
        } else {
            return jdbc.queryEach(sql, entityType1, entityType2, entityType3,
                Tuples.of(propManager.getValue(0) + ".", propManager.getValue(1) + ".", propManager.getValue(2) + "."),
                getEffectiveParamMap(params, manager));
        }
    }

    public <R1, R2, R3> AutoCloseableIterable<Tuple3<R1, R2, R3>> each(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Map<String, Serializable> params, int offset, int limit) {
        return each(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> AutoCloseableIterable<Tuple3<R1, R2, R3>> each(TplExecuteId tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Map<String, Serializable> params, int offset, int limit) {
        return findEach(tplExecuteId, entityType1, entityType2, entityType3, null, params, offset, limit).get0();
    }

    public <R1, R2, R3> AutoCloseableIterable<Tuple3<R1, R2, R3>> each(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Tuple3<String, String, String> prefixes,
        Map<String, Serializable> params) {
        return each(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> AutoCloseableIterable<Tuple3<R1, R2, R3>> each(TplExecuteId tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Tuple3<String, String, String> prefixes,
        Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager, PropertiesMappingManager> tuple4 = getQueryExecution(
            tplExecuteId, params, entityType1, entityType2, entityType3);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        TplExecuteConfig config = tuple4.get1();
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.queryEach(sql, entityType1, entityType2, entityType3, prefixes,
                getEffectiveParamArray(params, manager, config));
        } else {
            return jdbc.queryEach(sql, entityType1, entityType2, entityType3, prefixes,
                getEffectiveParamMap(params, manager));
        }
    }

    public <R1, R2, R3> AutoCloseableIterable<Tuple3<R1, R2, R3>> each(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Tuple3<String, String, String> prefixes,
        Map<String, Serializable> params, int offset, int limit) {
        return each(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, prefixes, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> AutoCloseableIterable<Tuple3<R1, R2, R3>> each(TplExecuteId tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Tuple3<String, String, String> prefixes,
        Map<String, Serializable> params, int offset, int limit) {
        return findEach(tplExecuteId, entityType1, entityType2, entityType3, prefixes, params, offset, limit).get0();
    }

    public <R1, R2, R3, R4> AutoCloseableIterable<Tuple4<R1, R2, R3, R4>> each(String tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Map<String, Serializable> params) {
        return each(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, entityType4, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> AutoCloseableIterable<Tuple4<R1, R2, R3, R4>> each(TplExecuteId tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager, PropertiesMappingManager> tuple4 = getQueryExecution(
            tplExecuteId, params, entityType1, entityType2, entityType3, entityType4);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        PropertiesMappingManager propManager = tuple4.get3();
        TplExecuteConfig config = tuple4.get1();
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.queryEach(
                sql, entityType1, entityType2, entityType3, entityType4, Tuples.of(propManager.getValue(0) + ".",
                    propManager.getValue(1) + ".", propManager.getValue(2) + ".", propManager.getValue(3) + "."),
                getEffectiveParamArray(params, manager, config));
        } else {
            return jdbc.queryEach(
                sql, entityType1, entityType2, entityType3, entityType4, Tuples.of(propManager.getValue(0) + ".",
                    propManager.getValue(1) + ".", propManager.getValue(2) + ".", propManager.getValue(3) + "."),
                getEffectiveParamMap(params, manager));
        }
    }

    public <R1, R2, R3, R4> AutoCloseableIterable<Tuple4<R1, R2, R3, R4>> each(String tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Map<String, Serializable> params, int offset, int limit) {
        return each(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, entityType4, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> AutoCloseableIterable<Tuple4<R1, R2, R3, R4>> each(TplExecuteId tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Map<String, Serializable> params, int offset, int limit) {
        return findEach(tplExecuteId, entityType1, entityType2, entityType3, entityType4, null, params, offset, limit)
            .get0();
    }

    public <R1, R2, R3, R4> AutoCloseableIterable<Tuple4<R1, R2, R3, R4>> each(String tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Tuple4<String, String, String, String> prefixes, Map<String, Serializable> params) {
        return each(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, entityType4, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> AutoCloseableIterable<Tuple4<R1, R2, R3, R4>> each(TplExecuteId tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Tuple4<String, String, String, String> prefixes, Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager, PropertiesMappingManager> tuple4 = getQueryExecution(
            tplExecuteId, params, entityType1, entityType2, entityType3, entityType4);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        TplExecuteConfig config = tuple4.get1();
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.queryEach(sql, entityType1, entityType2, entityType3, entityType4, prefixes,
                getEffectiveParamArray(params, manager, config));
        } else {
            return jdbc.queryEach(sql, entityType1, entityType2, entityType3, entityType4, prefixes,
                getEffectiveParamMap(params, manager));
        }
    }

    public <R1, R2, R3, R4> AutoCloseableIterable<Tuple4<R1, R2, R3, R4>> each(String tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Tuple4<String, String, String, String> prefixes, Map<String, Serializable> params, int offset, int limit) {
        return each(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, entityType4, prefixes, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> AutoCloseableIterable<Tuple4<R1, R2, R3, R4>> each(TplExecuteId tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Tuple4<String, String, String, String> prefixes, Map<String, Serializable> params, int offset, int limit) {
        return findEach(tplExecuteId, entityType1, entityType2, entityType3, entityType4, prefixes, params, offset,
            limit).get0();
    }

    public <R1, R2, R3, R4, R5> AutoCloseableIterable<Tuple5<R1, R2, R3, R4, R5>> each(String tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Class<R5> entityType5, Map<String, Serializable> params) {
        return each(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, entityType4, entityType5, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> AutoCloseableIterable<Tuple5<R1, R2, R3, R4, R5>> each(TplExecuteId tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Class<R5> entityType5, Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager, PropertiesMappingManager> tuple4 = getQueryExecution(
            tplExecuteId, params, entityType1, entityType2, entityType3, entityType4, entityType5);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        PropertiesMappingManager propManager = tuple4.get3();
        TplExecuteConfig config = tuple4.get1();
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.queryEach(sql, entityType1, entityType2, entityType3, entityType4, entityType5,
                Tuples.of(propManager.getValue(0) + ".", propManager.getValue(1) + ".", propManager.getValue(2) + ".",
                    propManager.getValue(3) + ".", propManager.getValue(4) + "."),
                getEffectiveParamArray(params, manager, config));
        } else {
            return jdbc.queryEach(sql, entityType1, entityType2, entityType3, entityType4, entityType5,
                Tuples.of(propManager.getValue(0) + ".", propManager.getValue(1) + ".", propManager.getValue(2) + ".",
                    propManager.getValue(3) + ".", propManager.getValue(4) + "."),
                getEffectiveParamMap(params, manager));
        }
    }

    public <R1, R2, R3, R4, R5> AutoCloseableIterable<Tuple5<R1, R2, R3, R4, R5>> each(String tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Class<R5> entityType5, Map<String, Serializable> params, int offset, int limit) {
        return each(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, entityType4, entityType5, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> AutoCloseableIterable<Tuple5<R1, R2, R3, R4, R5>> each(TplExecuteId tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Class<R5> entityType5, Map<String, Serializable> params, int offset, int limit) {
        return findEach(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, null, params,
            offset, limit).get0();
    }

    public <R1, R2, R3, R4, R5> AutoCloseableIterable<Tuple5<R1, R2, R3, R4, R5>> each(String tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Class<R5> entityType5, Tuple5<String, String, String, String, String> prefixes,
        Map<String, Serializable> params) {
        return each(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, entityType4, entityType5, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> AutoCloseableIterable<Tuple5<R1, R2, R3, R4, R5>> each(TplExecuteId tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Class<R5> entityType5, Tuple5<String, String, String, String, String> prefixes,
        Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager, PropertiesMappingManager> tuple4 = getQueryExecution(
            tplExecuteId, params, entityType1, entityType2, entityType3, entityType4, entityType5);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        TplExecuteConfig config = tuple4.get1();
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.queryEach(sql, entityType1, entityType2, entityType3, entityType4, entityType5, prefixes,
                getEffectiveParamArray(params, manager, config));
        } else {
            return jdbc.queryEach(sql, entityType1, entityType2, entityType3, entityType4, entityType5, prefixes,
                getEffectiveParamMap(params, manager));
        }
    }

    public <R1, R2, R3, R4, R5> AutoCloseableIterable<Tuple5<R1, R2, R3, R4, R5>> each(String tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Class<R5> entityType5, Tuple5<String, String, String, String, String> prefixes,
        Map<String, Serializable> params, int offset, int limit) {
        return each(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, entityType4, entityType5, prefixes, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> AutoCloseableIterable<Tuple5<R1, R2, R3, R4, R5>> each(TplExecuteId tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Class<R5> entityType5, Tuple5<String, String, String, String, String> prefixes,
        Map<String, Serializable> params, int offset, int limit) {
        return findEach(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, prefixes, params,
            offset, limit).get0();
    }

    public <R1, R2, R3, R4, R5, R6> AutoCloseableIterable<Tuple6<R1, R2, R3, R4, R5, R6>> each(String tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Class<R5> entityType5, Class<R6> entityType6, Map<String, Serializable> params) {
        return each(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, entityType4, entityType5, entityType6, params);
    }

    public <R1, R2, R3, R4, R5, R6> AutoCloseableIterable<Tuple6<R1, R2, R3, R4, R5, R6>> each(String tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Class<R5> entityType5, Class<R6> entityType6, Map<String, Serializable> params, int offset, int limit) {
        return each(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, entityType4, entityType5, entityType6, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> AutoCloseableIterable<Tuple6<R1, R2, R3, R4, R5, R6>> each(
        TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3,
        Class<R4> entityType4, Class<R5> entityType5, Class<R6> entityType6, Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager, PropertiesMappingManager> tuple4 = getQueryExecution(
            tplExecuteId, params, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        PropertiesMappingManager propManager = tuple4.get3();
        TplExecuteConfig config = tuple4.get1();
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.queryEach(sql, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6,
                Tuples.of(propManager.getValue(0) + ".", propManager.getValue(1) + ".", propManager.getValue(2) + ".",
                    propManager.getValue(3) + ".", propManager.getValue(4) + ".", propManager.getValue(5) + "."),
                getEffectiveParamArray(params, manager, config));

        } else {
            return jdbc.queryEach(sql, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6,
                Tuples.of(propManager.getValue(0) + ".", propManager.getValue(1) + ".", propManager.getValue(2) + ".",
                    propManager.getValue(3) + ".", propManager.getValue(4) + ".", propManager.getValue(5) + "."),
                getEffectiveParamMap(params, manager));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> AutoCloseableIterable<Tuple6<R1, R2, R3, R4, R5, R6>> each(
        TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3,
        Class<R4> entityType4, Class<R5> entityType5, Class<R6> entityType6, Map<String, Serializable> params,
        int offset, int limit) {
        return findEach(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6,
            null, params, offset, limit).get0();
    }

    public <R1, R2, R3, R4, R5, R6> AutoCloseableIterable<Tuple6<R1, R2, R3, R4, R5, R6>> each(String tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Class<R5> entityType5, Class<R6> entityType6, Tuple6<String, String, String, String, String, String> prefixes,
        Map<String, Serializable> params) {
        return each(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, entityType4, entityType5, entityType6, prefixes, params);
    }

    public <R1, R2, R3, R4, R5, R6> AutoCloseableIterable<Tuple6<R1, R2, R3, R4, R5, R6>> each(String tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Class<R5> entityType5, Class<R6> entityType6, Tuple6<String, String, String, String, String, String> prefixes,
        Map<String, Serializable> params, int offset, int limit) {
        return each(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, entityType4, entityType5, entityType6, prefixes, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> AutoCloseableIterable<Tuple6<R1, R2, R3, R4, R5, R6>> each(
        TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3,
        Class<R4> entityType4, Class<R5> entityType5, Class<R6> entityType6,
        Tuple6<String, String, String, String, String, String> prefixes, Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager, PropertiesMappingManager> tuple4 = getQueryExecution(
            tplExecuteId, params, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        TplExecuteConfig config = tuple4.get1();
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.queryEach(sql, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6,
                prefixes, getEffectiveParamArray(params, manager, config));
        } else {
            return jdbc.queryEach(sql, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6,
                prefixes, getEffectiveParamMap(params, manager));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> AutoCloseableIterable<Tuple6<R1, R2, R3, R4, R5, R6>> each(
        TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3,
        Class<R4> entityType4, Class<R5> entityType5, Class<R6> entityType6,
        Tuple6<String, String, String, String, String, String> prefixes, Map<String, Serializable> params, int offset,
        int limit) {
        return findEach(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6,
            prefixes, params, offset, limit).get0();
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<Map<String, Serializable>> pagination(String tplExecuteId,
        Map<String, Serializable> params, int offset, int limit) {
        return pagination(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), params, offset,
            limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<Map<String, Serializable>> pagination(TplExecuteId tplExecuteId,
        Map<String, Serializable> params, int offset, int limit) {
        SimplePaginationResults<Map<String, Serializable>> pagination = new SimplePaginationResults<>(offset, limit);
        Tuple5<List<Map<String, Serializable>>, String, TplExecuteConfig, ConditionParamsManager,
            Map<String, Serializable>> listTuple = findList(tplExecuteId, params, offset, limit);
        pagination.setPageResults(listTuple.get0());
        pagination.setTotal(count(listTuple.get1(), listTuple.get4(), listTuple.get3(), listTuple.get2()));
        return pagination;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> PaginationResults<E> pagination(String tplExecuteId, Class<E> entityType,
        Map<String, Serializable> params, int offset, int limit) {
        return pagination(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType,
            params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> PaginationResults<E> pagination(TplExecuteId tplExecuteId, Class<E> entityType,
        Map<String, Serializable> params, int offset, int limit) {
        SimplePaginationResults<E> pagination = new SimplePaginationResults<>(offset, limit);

        Tuple6<List<E>, String, TplExecuteConfig, ConditionParamsManager, Map<String, Serializable>,
            Optional<QueryPageResult>> listTuple = findList(tplExecuteId, entityType, params, offset, limit);
        // IMPLSOON 这里加入分页sql的优化处理
        // 方案一，在模板中加入特定标签
        // 方案二，在预编译时，加入特定标签，就是方案一的加强版
        // 方案三，在这里进行sql解析
        pagination.setPageResults(listTuple.get0());
        pagination.setTotal(count(listTuple.get1(), listTuple.get4(), listTuple.get3(), listTuple.get2(),
            listTuple.get5().orElse(null)));

        return pagination;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> PaginationResults<T> pagination(TplExecuteId execution, RowMapper<T> rowMapper,
        Map<String, Serializable> params, int offset, int limit) {
        // NOIMPL 模板执行未实现映射参数为RowMapper的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> PaginationResults<Tuple2<R1, R2>> pagination(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Map<String, Serializable> params, int offset, int limit) {
        return pagination(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> PaginationResults<Tuple2<R1, R2>> pagination(TplExecuteId tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Map<String, Serializable> params, int offset, int limit) {
        return pagination(tplExecuteId, entityType1, entityType2, (Tuple2<String, String>) null, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> PaginationResults<Tuple2<R1, R2>> pagination(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Tuple2<String, String> prefixes, Map<String, Serializable> params, int offset,
        int limit) {
        return pagination(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, prefixes, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> PaginationResults<Tuple2<R1, R2>> pagination(TplExecuteId tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Tuple2<String, String> prefixes, Map<String, Serializable> params, int offset,
        int limit) {
        SimplePaginationResults<Tuple2<R1, R2>> pagination = new SimplePaginationResults<>(offset, limit);
        Tuple5<List<Tuple2<R1, R2>>, String, TplExecuteConfig, ConditionParamsManager,
            Map<String, Serializable>> listTuple = findList(tplExecuteId, entityType1, entityType2, prefixes, params,
                offset, limit);
        pagination.setPageResults(listTuple.get0());
        pagination.setTotal(count(listTuple.get1(), listTuple.get4(), listTuple.get3(), listTuple.get2()));
        return pagination;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> PaginationResults<Tuple3<R1, R2, R3>> pagination(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Map<String, Serializable> params, int offset, int limit) {
        return pagination(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> PaginationResults<Tuple3<R1, R2, R3>> pagination(TplExecuteId tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Map<String, Serializable> params,
        int offset, int limit) {
        return pagination(tplExecuteId, entityType1, entityType2, entityType3, (Tuple3<String, String, String>) null,
            params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> PaginationResults<Tuple3<R1, R2, R3>> pagination(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Tuple3<String, String, String> prefixes,
        Map<String, Serializable> params, int offset, int limit) {
        return pagination(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, prefixes, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> PaginationResults<Tuple3<R1, R2, R3>> pagination(TplExecuteId tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Tuple3<String, String, String> prefixes,
        Map<String, Serializable> params, int offset, int limit) {
        SimplePaginationResults<Tuple3<R1, R2, R3>> pagination = new SimplePaginationResults<>(offset, limit);
        Tuple5<List<Tuple3<R1, R2, R3>>, String, TplExecuteConfig, ConditionParamsManager,
            Map<String, Serializable>> listTuple = findList(tplExecuteId, entityType1, entityType2, entityType3,
                prefixes, params, offset, limit);
        pagination.setPageResults(listTuple.get0());
        pagination.setTotal(count(listTuple.get1(), listTuple.get4(), listTuple.get3(), listTuple.get2()));
        return pagination;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> PaginationResults<Tuple4<R1, R2, R3, R4>> pagination(String tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Map<String, Serializable> params, int offset, int limit) {
        return pagination(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, entityType4, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> PaginationResults<Tuple4<R1, R2, R3, R4>> pagination(TplExecuteId tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Map<String, Serializable> params, int offset, int limit) {
        return pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4,
            (Tuple4<String, String, String, String>) null, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> PaginationResults<Tuple4<R1, R2, R3, R4>> pagination(String tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Tuple4<String, String, String, String> prefixes, Map<String, Serializable> params, int offset, int limit) {
        return pagination(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, entityType4, prefixes, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> PaginationResults<Tuple4<R1, R2, R3, R4>> pagination(TplExecuteId tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Tuple4<String, String, String, String> prefixes, Map<String, Serializable> params, int offset, int limit) {
        SimplePaginationResults<Tuple4<R1, R2, R3, R4>> pagination = new SimplePaginationResults<>(offset, limit);
        Tuple5<List<Tuple4<R1, R2, R3, R4>>, String, TplExecuteConfig, ConditionParamsManager,
            Map<String, Serializable>> listTuple = findList(tplExecuteId, entityType1, entityType2, entityType3,
                entityType4, prefixes, params, offset, limit);
        pagination.setPageResults(listTuple.get0());
        pagination.setTotal(count(listTuple.get1(), listTuple.get4(), listTuple.get3(), listTuple.get2()));
        return pagination;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> PaginationResults<Tuple5<R1, R2, R3, R4, R5>> pagination(String tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Class<R5> entityType5, Map<String, Serializable> params, int offset, int limit) {
        return pagination(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, entityType4, entityType5, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> PaginationResults<Tuple5<R1, R2, R3, R4, R5>> pagination(TplExecuteId tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Class<R5> entityType5, Map<String, Serializable> params, int offset, int limit) {
        return pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5,
            (Tuple5<String, String, String, String, String>) null, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> PaginationResults<Tuple5<R1, R2, R3, R4, R5>> pagination(String tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Class<R5> entityType5, Tuple5<String, String, String, String, String> prefixes,
        Map<String, Serializable> params, int offset, int limit) {
        return pagination(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, entityType4, entityType5, prefixes, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> PaginationResults<Tuple5<R1, R2, R3, R4, R5>> pagination(TplExecuteId tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Class<R5> entityType5, Tuple5<String, String, String, String, String> prefixes,
        Map<String, Serializable> params, int offset, int limit) {
        SimplePaginationResults<Tuple5<R1, R2, R3, R4, R5>> pagination = new SimplePaginationResults<>(offset, limit);
        Tuple5<List<Tuple5<R1, R2, R3, R4, R5>>, String, TplExecuteConfig, ConditionParamsManager,
            Map<String, Serializable>> listTuple = findList(tplExecuteId, entityType1, entityType2, entityType3,
                entityType4, entityType5, prefixes, params, offset, limit);
        pagination.setPageResults(listTuple.get0());
        //        String countSql = null;
        //        ConditionParamsManagers manager = null;
        //        TplExecuteConfig config = listTuple.get2();
        //        if (Lang.isEmpty(config.getCount())) {
        //            countSql = SqlUtils.convertSelectToCount(listTuple.get1());
        //            manager = listTuple.get3();
        //        } else {
        //            Tuple2<String, ConditionParamsManager> countTuple = getCountExecution(tplExecuteId, params, config);
        //            countSql = countTuple.get0();
        //            manager = countTuple.get1();
        //        }
        //        pagination.setTotal(jdbc.queryInt(countSql, getEffectiveParamMap(listTuple.get4(), manager)));
        pagination.setTotal(count(listTuple.get1(), listTuple.get4(), listTuple.get3(), listTuple.get2()));
        return pagination;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> PaginationResults<Tuple6<R1, R2, R3, R4, R5, R6>> pagination(String tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Class<R5> entityType5, Class<R6> entityType6, Map<String, Serializable> params, int offset, int limit) {
        return pagination(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, entityType4, entityType5, entityType6, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> PaginationResults<Tuple6<R1, R2, R3, R4, R5, R6>> pagination(
        TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3,
        Class<R4> entityType4, Class<R5> entityType5, Class<R6> entityType6, Map<String, Serializable> params,
        int offset, int limit) {
        return pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6,
            (Tuple6<String, String, String, String, String, String>) null, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> PaginationResults<Tuple6<R1, R2, R3, R4, R5, R6>> pagination(String tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Class<R5> entityType5, Class<R6> entityType6, Tuple6<String, String, String, String, String, String> prefixes,
        Map<String, Serializable> params, int offset, int limit) {
        return pagination(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), entityType1,
            entityType2, entityType3, entityType4, entityType5, entityType6, prefixes, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> PaginationResults<Tuple6<R1, R2, R3, R4, R5, R6>> pagination(
        TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3,
        Class<R4> entityType4, Class<R5> entityType5, Class<R6> entityType6,
        Tuple6<String, String, String, String, String, String> prefixes, Map<String, Serializable> params, int offset,
        int limit) {
        SimplePaginationResults<
            Tuple6<R1, R2, R3, R4, R5, R6>> pagination = new SimplePaginationResults<>(offset, limit);
        Tuple5<List<Tuple6<R1, R2, R3, R4, R5, R6>>, String, TplExecuteConfig, ConditionParamsManager,
            Map<String, Serializable>> listTuple = findList(tplExecuteId, entityType1, entityType2, entityType3,
                entityType4, entityType5, entityType6, prefixes, params, offset, limit);
        pagination.setPageResults(listTuple.get0());
        pagination.setTotal(count(listTuple.get1(), listTuple.get4(), listTuple.get3(), listTuple.get2()));
        return pagination;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E value(String tplExecuteId, Map<String, Serializable> params) {
        return value(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), params);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <E> E value(TplExecuteId tplExecuteId, Map<String, Serializable> params) {
        return (E) value(tplExecuteId, Object.class, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E value(String tplExecuteId, Class<E> valueType, Map<String, Serializable> params) {
        return value(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), valueType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E value(TplExecuteId tplExecuteId, Class<E> valueType, Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
            PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, valueType);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        TplExecuteConfig config = tuple4.get1();
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            return jdbc.queryValue(sql, valueType, getEffectiveParamArray(params, manager, config));
        } else {
            return jdbc.queryValue(sql, valueType, getEffectiveParamMap(params, manager));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean bool(String tplExecuteId, Map<String, Serializable> params) {
        return bool(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean bool(TplExecuteId tplExecuteId, Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
            PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, int.class);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        return jdbc.queryBool(sql, getEffectiveParamMap(params, manager));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int intValue(String tplExecuteId, Map<String, Serializable> params) {
        return intValue(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int intValue(TplExecuteId tplExecuteId, Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
            PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, int.class);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        return jdbc.queryInt(sql, getEffectiveParamMap(params, manager));
        //        return numberInt(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long longValue(String tplExecuteId, Map<String, Serializable> params) {
        return longValue(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long longValue(TplExecuteId tplExecuteId, Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
            PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, long.class);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        return jdbc.queryLong(sql, getEffectiveParamMap(params, manager));
        //        return numberLong(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double doubleValue(String tplExecuteId, Map<String, Serializable> params) {
        return doubleValue(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(tplExecuteId), params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double doubleValue(TplExecuteId tplExecuteId, Map<String, Serializable> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
            PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, double.class);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        return jdbc.queryDouble(sql, getEffectiveParamMap(params, manager));
        //        return numberDouble(tplExecuteId, params);
    }

    // ****************************************************************************************************************

    private void setCountTemplate(TplExecuteConfig config) {
        // convert select sql to count sql once
        if (Lang.isEmpty(config.getCount())
            && hammerConfig.getTemplateConfig().getCountSqlConverteStrategy() == CountSqlConverteStrategy.USE_EXCEPTION
            && hammerConfig.getTemplateConfig().getCountSqlConvertor() != null) {
            config.setCount(hammerConfig.getTemplateConfig().getCountSqlConvertor().apply(config.getContent()));
            templateEngine.putTemplate(config.getCountExecuteId(), config.getCount());
        }
    }

    private Tuple4<String, TplExecuteConfig, ConditionParamsManager, PropertiesMappingManager> getQueryExecution(
        TplExecuteId tplExecuteId, Serializable[] params, Class<?>... resultTypes) {
        TplExecuteConfig config = configFactory.getConfig(tplExecuteId);
        if (config.getParamsFormat() == ParamsFormat.NAME) {
            throw new TplException(
                "ParamsFormat is set to INDEX in the template. MAP cannot be used to pass parameters");
        }

        setCountTemplate(config);

        Map<String, Serializable> paramMap = new HashMap<>();
        for (int i = 0; i < params.length; i++) {
            // process in params
            if (config.getInParamIndexs().contains(i)) {
                String name = hammerConfig.getTemplateConfig().getParamIndexToName().apply(i);
                paramMap.put(hammerConfig.getTemplateConfig().getInParamPlaceholderName().apply(name),
                    SqlUtils.convertInParamsPlaceholder(params[i]));
                paramMap.put(name, params[i]);
            } else {
                paramMap.put(hammerConfig.getTemplateConfig().getParamIndexToName().apply(i), params[i]);
            }
        }

        Tuple3<String, ConditionParamsManager, PropertiesMappingManager> tuple3 = getExecution(tplExecuteId.getId(),
            config.getContent(), paramMap, resultTypes);
        logger.debug("tplExecuteId -> {} \nexecuteQuerySql -> {} \nqueryTemplate -> {}", tplExecuteId, tuple3.get0(),
            config.getContent());
        return Tuples.of(tuple3.get0(), config, tuple3.get1(), tuple3.get2());
    }

    // ----------------------------------------------------------------------------------------------------------------

    private Tuple4<String, TplExecuteConfig, ConditionParamsManager, PropertiesMappingManager> getQueryExecution(
        TplExecuteId tplExecuteId, Map<String, Serializable> params, Class<?>... resultTypes) {
        TplExecuteConfig config = configFactory.getConfig(tplExecuteId);
        if (config.getParamsFormat() == ParamsFormat.INDEX
            && (config.getParams() == null || config.getParamNames() == null)) {
            throw new TplException(
                "ParamsFormat is set to INDEX in the template and (paramNames|params) is empty, MAP cannot be used to pass parameters");
        }

        setCountTemplate(config);

        // process in params
        for (String inParamName : config.getInParamNames()) {
            Object value = params.get(inParamName);
            if (value != null) {
                params.put(hammerConfig.getTemplateConfig().getInParamPlaceholderName().apply(inParamName),
                    SqlUtils.convertInParamsPlaceholder(value));
            }
        }

        Tuple3<String, ConditionParamsManager, PropertiesMappingManager> tuple3 = getExecution(tplExecuteId.getId(),
            config.getContent(), params, resultTypes);
        logger.debug("tplExecuteId -> {} \nexecuteQuerySql -> {} \nqueryTemplate -> {}", tplExecuteId, tuple3.get0(),
            config.getContent());
        return Tuples.of(tuple3.get0(), config, tuple3.get1(), tuple3.get2());
    }

    /**
     * Gets the count execution.
     *
     * @param params the params
     * @param config the config
     * @return the count execution
     */
    private Tuple2<String, ConditionParamsManager> getCountExecution(Map<String, Serializable> params,
        TplExecuteConfig config) {
        String templateName = config.getExecuteId() + TplConfigFactory.COUNT_SUFFIX;
        Tuple3<String, ConditionParamsManager, PropertiesMappingManager> result = getExecution(templateName,
            config.getCount(), params, ArrayUtils.EMPTY_CLASS_ARRAY);
        logger.debug("tplExecuteId -> {}  \nexecuteCountSql -> {}  \ncountTemplate -> {}", config.getExecuteId(),
            result.get0(), config.getCount());
        return Tuples.of(result.get0(), result.get1());
    }

    /**
     * Gets the execution.
     *
     * @param templateName the template name
     * @param sql the sql
     * @param params the params
     * @param resultType the result type
     * @return the execution
     */
    private Tuple3<String, ConditionParamsManager, PropertiesMappingManager> getExecution(String templateName,
        String sql, Map<String, Serializable> params, Class<?>... resultTypes) {
        logger.debug("execute template name : {}", templateName);
        // FIXME 多个where 共享了一个 ConditionParamsManager
        // 所以需要在where中创建，并且and or 标签必须在where 标签内使用
        // ConditionParamsManager 应该在where 标签的execute方法中实例化，再共享给内部的and or 使用
        // 这样where and or 标签就能全局初始化一次了

        PropertiesMappingManager propertiesMappingManager = new PropertiesMappingManager();

        Map<String, Serializable> root = new HashMap<>();
        root.putAll(params);
        SqlDbTemplateProcessEnv<TemplateDirective,
            TemplateMethod> templateProcessEnv = createTemplateProcessEnv(propertiesMappingManager, resultTypes);

        TemplateDirectives<TemplateDirective> directives = templateProcessEnv.createDirectives();
        WhereDirectiveModel whereDirective = (WhereDirectiveModel) directives.getWhereDirective();
        String result = templateEngine.process(templateName, sql, params, directives,
            templateProcessEnv.createMethods());
        return Tuples.of(result, whereDirective.getConditionParamsManagers(), propertiesMappingManager);
    }

    /**
     * Creates the template process env.
     *
     * @param manager the manager
     * @param resultType the result type
     * @return the sql db template process env
     */
    private SqlDbTemplateProcessEnv<TemplateDirective, TemplateMethod> createTemplateProcessEnv(
        PropertiesMappingManager propertiesMappingManager, Class<?>... resultTypes) {
        SqlDbTemplateProcessEnv<TemplateDirective, TemplateMethod> env = templateEngine.createTemplateProcessEnv();
        env.setConfigFactory(configFactory);
        env.setDialect(jdbc.getDialect());
        env.setTemplateConfig(hammerConfig.getTemplateConfig());
        env.setPropertiesMappingManager(propertiesMappingManager);
        env.setMappingFactory(mappingFactory);
        env.setResultTypes(resultTypes);
        return env;
    }

    /**
     * Find list.
     *
     * @param tplExecuteId the tpl execute id
     * @param params the params
     * @param offset the offset
     * @param limit the limit
     * @return the tuple 5
     */
    private Tuple5<List<Map<String, Serializable>>, String, TplExecuteConfig, ConditionParamsManager,
        Map<String, Serializable>> findList(TplExecuteId tplExecuteId, Map<String, Serializable> params, int offset,
            int limit) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
            PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, ArrayUtils.EMPTY_CLASS_ARRAY);
        List<Map<String, Serializable>> list = null;
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        TplExecuteConfig config = tuple4.get1();

        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            SqlPageQuery<Serializable[]> sqlPageQuery = sqlPageFactory.toPage(jdbc.getDialect(), sql, offset, limit,
                getEffectiveParamArray(params, manager, config));
            list = jdbc.queryList(sqlPageQuery.getSql(), sqlPageQuery.getParams());
            return Tuples.of(list, sql, tuple4.get1(), manager, getEffectiveParamMap(params, manager));
        } else {
            SqlPageQuery<Map<String, Serializable>> sqlPageQuery = sqlPageFactory.toPage(jdbc.getDialect(), sql, offset,
                limit, getEffectiveParamMap(params, manager));
            list = jdbc.queryList(sqlPageQuery.getSql(), sqlPageQuery.getParams());
            return Tuples.of(list, sql, tuple4.get1(), manager, sqlPageQuery.getParams());
        }
    }

    private <E> Tuple6<List<E>, String, TplExecuteConfig, ConditionParamsManager, Map<String, Serializable>,
        Optional<QueryPageResult>> findList(TplExecuteId tplExecuteId, Class<E> entityType,
            Map<String, Serializable> params, int offset, int limit) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
            PropertiesMappingManager> tuple3 = getQueryExecution(tplExecuteId, params, entityType);
        List<E> list = null;
        String sql = tuple3.get0();
        ConditionParamsManager manager = tuple3.get2();
        TplExecuteConfig config = tuple3.get1();
        // after getQueryExecution

        Map<String, Serializable> key = null;
        QueryPageResult queryPageResult = null;
        Cache<Object, QueryPageResult> queryPageResultCache = hammerConfig.getCacheConfig().getQueryPageResultCache();
        if (hammerConfig.getTemplateConfig().getQueryConfig().isCachePageResults() && queryPageResultCache != null) {
            key = getKey(sql, params);
            queryPageResult = queryPageResultCache.get(key);
            list = getCacheList(queryPageResult, offset);
        }

        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            SqlPageQuery<Serializable[]> sqlPageQuery = sqlPageFactory.toPage(jdbc.getDialect(), sql, offset, limit,
                getEffectiveParamArray(params, manager, config));
            if (list == null) {
                list = jdbc.queryList(sqlPageQuery.getSql(), entityType, sqlPageQuery.getParams());
                queryPageResult = setCacheList(queryPageResultCache, list, queryPageResult, offset);
            }
            return Tuples.of(list, sql, tuple3.get1(), manager, getEffectiveParamMap(params, manager),
                Optional.ofNullable(queryPageResult));
        } else {
            SqlPageQuery<Map<String, Serializable>> sqlPageQuery = sqlPageFactory.toPage(jdbc.getDialect(), sql, offset,
                limit, getEffectiveParamMap(params, manager));
            if (list == null) {
                list = jdbc.queryList(sqlPageQuery.getSql(), entityType, sqlPageQuery.getParams());
                queryPageResult = setCacheList(queryPageResultCache, list, queryPageResult, offset);
            }
            return Tuples.of(list, sql, tuple3.get1(), manager, sqlPageQuery.getParams(),
                Optional.ofNullable(queryPageResult));
        }
    }

    private <R> List<R> getCacheList(QueryPageResult queryPageResult, int offset) {
        if (hammerConfig.getTemplateConfig().getQueryConfig().isCachePageResults() && queryPageResult != null) {
            return queryPageResult.getPageList(offset);
        }
        return null;
    }

    private <R> QueryPageResult setCacheList(Cache<Object, QueryPageResult> queryPageResultCache, List<R> list,
        QueryPageResult queryPageResult, int offset) {
        if (queryPageResultCache != null) {
            //            if (hammerConfig.getTemplateConfig().getQueryConfig().isPagingOptimization()) { // cache id
            //                queryPageResult = Lang.ifNull(queryPageResult, new QueryPageResult());
            //                PageInfo pageInfo = null;
            //                if (list.isEmpty()) {
            //                    pageInfo = new PageInfo(limit);
            //                } else {
            //                    pageInfo = new PageInfo(limit, (Number) getId.apply(list.get(0)),
            //                        (Number) getId.apply(list.get(list.size() - 1)));
            //                }
            //                queryPageResult.addQueryPageResult(pageInfo);
            //            }
            if (hammerConfig.getTemplateConfig().getQueryConfig().isCachePageResults()) { // cache enable
                queryPageResult = Lang.ifNull(queryPageResult, new QueryPageResult());
                queryPageResult.addPageList(offset, list);
            }
        }
        return queryPageResult;
    }

    private <E1,
        E2> Tuple5<List<Tuple2<E1, E2>>, String, TplExecuteConfig, ConditionParamsManager,
            Map<String, Serializable>> findList(TplExecuteId tplExecuteId, Class<E1> entityType1, Class<E2> entityType2,
                Tuple2<String, String> prefixes, Map<String, Serializable> params, int offset, int limit) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
            PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, entityType1, entityType2);
        List<Tuple2<E1, E2>> list = null;
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        SqlPageQuery<Map<String, Serializable>> sqlPageQuery = sqlPageFactory.toPage(jdbc.getDialect(), sql, offset,
            limit, getEffectiveParamMap(params, manager));
        if (prefixes == null) {
            PropertiesMappingManager propManager = tuple4.get3();
            list = jdbc.queryList(sqlPageQuery.getSql(), entityType1, entityType2,
                Tuples.of(propManager.getValue(0).getAlias() + ".", propManager.getValue(1).getAlias() + "."),
                sqlPageQuery.getParams());
            return Tuples.of(list, sql, tuple4.get1(), manager, getEffectiveParamMap(params, manager));
        } else {
            list = jdbc.queryList(sqlPageQuery.getSql(), entityType1, entityType2, prefixes, sqlPageQuery.getParams());
            return Tuples.of(list, sql, tuple4.get1(), manager, sqlPageQuery.getParams());
        }
    }

    private <E1, E2,
        E3> Tuple5<List<Tuple3<E1, E2, E3>>, String, TplExecuteConfig, ConditionParamsManager,
            Map<String, Serializable>> findList(TplExecuteId tplExecuteId, Class<E1> entityType1, Class<E2> entityType2,
                Class<E3> entityType3, Tuple3<String, String, String> prefixes, Map<String, Serializable> params,
                int offset, int limit) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
            PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, entityType1, entityType2);
        List<Tuple3<E1, E2, E3>> list = null;
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        SqlPageQuery<Map<String, Serializable>> sqlPageQuery = sqlPageFactory.toPage(jdbc.getDialect(), sql, offset,
            limit, getEffectiveParamMap(params, manager));
        if (prefixes == null) {
            PropertiesMappingManager propManager = tuple4.get3();
            list = jdbc.queryList(sqlPageQuery.getSql(), entityType1, entityType2, entityType3,
                Tuples.of(propManager.getValue(0).getAlias() + ".", propManager.getValue(1).getAlias() + ".",
                    propManager.getValue(2).getAlias() + "."),
                sqlPageQuery.getParams());
            return Tuples.of(list, sql, tuple4.get1(), manager, getEffectiveParamMap(params, manager));
        } else {
            list = jdbc.queryList(sqlPageQuery.getSql(), entityType1, entityType2, entityType3, prefixes,
                sqlPageQuery.getParams());
            return Tuples.of(list, sql, tuple4.get1(), manager, sqlPageQuery.getParams());
        }
    }

    private <E1, E2, E3,
        E4> Tuple5<List<Tuple4<E1, E2, E3, E4>>, String, TplExecuteConfig, ConditionParamsManager,
            Map<String, Serializable>> findList(TplExecuteId tplExecuteId, Class<E1> entityType1, Class<E2> entityType2,
                Class<E3> entityType3, Class<E4> entityType4, Tuple4<String, String, String, String> prefixes,
                Map<String, Serializable> params, int offset, int limit) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
            PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, entityType1, entityType2);
        List<Tuple4<E1, E2, E3, E4>> list = null;
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        SqlPageQuery<Map<String, Serializable>> sqlPageQuery = sqlPageFactory.toPage(jdbc.getDialect(), sql, offset,
            limit, getEffectiveParamMap(params, manager));
        if (prefixes == null) {
            PropertiesMappingManager propManager = tuple4.get3();
            list = jdbc.queryList(sqlPageQuery.getSql(), entityType1, entityType2, entityType3, entityType4,
                Tuples.of(propManager.getValue(0).getAlias() + ".", propManager.getValue(1).getAlias() + ".",
                    propManager.getValue(2).getAlias() + ".", propManager.getValue(3).getAlias() + "."),
                sqlPageQuery.getParams());
            return Tuples.of(list, sql, tuple4.get1(), manager, getEffectiveParamMap(params, manager));
        } else {
            list = jdbc.queryList(sqlPageQuery.getSql(), entityType1, entityType2, entityType3, entityType4, prefixes,
                sqlPageQuery.getParams());
            return Tuples.of(list, sql, tuple4.get1(), manager, sqlPageQuery.getParams());
        }
    }

    private <E1, E2, E3, E4,
        E5> Tuple5<List<Tuple5<E1, E2, E3, E4, E5>>, String, TplExecuteConfig, ConditionParamsManager,
            Map<String, Serializable>> findList(TplExecuteId tplExecuteId, Class<E1> entityType1, Class<E2> entityType2,
                Class<E3> entityType3, Class<E4> entityType4, Class<E5> entityType5,
                Tuple5<String, String, String, String, String> prefixes, Map<String, Serializable> params, int offset,
                int limit) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
            PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, entityType1, entityType2);
        List<Tuple5<E1, E2, E3, E4, E5>> list = null;
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        SqlPageQuery<Map<String, Serializable>> sqlPageQuery = sqlPageFactory.toPage(jdbc.getDialect(), sql, offset,
            limit, getEffectiveParamMap(params, manager));
        if (prefixes == null) {
            PropertiesMappingManager propManager = tuple4.get3();
            list = jdbc.queryList(sqlPageQuery.getSql(), entityType1, entityType2, entityType3, entityType4,
                entityType5,
                Tuples.of(propManager.getValue(0).getAlias() + ".", propManager.getValue(1).getAlias() + ".",
                    propManager.getValue(2).getAlias() + ".", propManager.getValue(3).getAlias() + ".",
                    propManager.getValue(4).getAlias() + "."),
                sqlPageQuery.getParams());
            return Tuples.of(list, sql, tuple4.get1(), manager, getEffectiveParamMap(params, manager));
        } else {
            list = jdbc.queryList(sqlPageQuery.getSql(), entityType1, entityType2, entityType3, entityType4,
                entityType5, prefixes, sqlPageQuery.getParams());
            return Tuples.of(list, sql, tuple4.get1(), manager, sqlPageQuery.getParams());
        }
    }

    private <E1, E2, E3, E4, E5,
        E6> Tuple5<List<Tuple6<E1, E2, E3, E4, E5, E6>>, String, TplExecuteConfig, ConditionParamsManager,
            Map<String, Serializable>> findList(TplExecuteId tplExecuteId, Class<E1> entityType1, Class<E2> entityType2,
                Class<E3> entityType3, Class<E4> entityType4, Class<E5> entityType5, Class<E6> entityType6,
                Tuple6<String, String, String, String, String, String> prefixes, Map<String, Serializable> params,
                int offset, int limit) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
            PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, entityType1, entityType2);
        List<Tuple6<E1, E2, E3, E4, E5, E6>> list = null;
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        SqlPageQuery<Map<String, Serializable>> sqlPageQuery = sqlPageFactory.toPage(jdbc.getDialect(), sql, offset,
            limit, getEffectiveParamMap(params, manager));
        if (prefixes == null) {
            PropertiesMappingManager propManager = tuple4.get3();
            list = jdbc.queryList(sqlPageQuery.getSql(), entityType1, entityType2, entityType3, entityType4,
                entityType5, entityType6,
                Tuples.of(propManager.getValue(0).getAlias() + ".", propManager.getValue(1).getAlias() + ".",
                    propManager.getValue(2).getAlias() + ".", propManager.getValue(3).getAlias() + ".",
                    propManager.getValue(4).getAlias() + ".", propManager.getValue(5).getAlias() + "."),
                sqlPageQuery.getParams());
            return Tuples.of(list, sql, tuple4.get1(), manager, getEffectiveParamMap(params, manager));
        } else {
            list = jdbc.queryList(sqlPageQuery.getSql(), entityType1, entityType2, entityType3, entityType4,
                entityType5, entityType6, prefixes, sqlPageQuery.getParams());
            return Tuples.of(list, sql, tuple4.get1(), manager, sqlPageQuery.getParams());
        }
    }

    private Map<String, Serializable> getKey(String sql, Map<String, Serializable> params) {
        Map<String, Serializable> key = new HashMap<>(params.size() + 1);
        key.put("$@#SQL#$@", sql);
        key.putAll(params);
        return key;
    }

    private long count(String sql, Map<String, Serializable> effectiveParams,
        ConditionParamsManager ConditionParamsManagers, TplExecuteConfig config) {
        return count(sql, effectiveParams, ConditionParamsManagers, config, null);
    }

    private long count(String sql, Map<String, Serializable> effectiveParams,
        ConditionParamsManager conditionParamsManager, TplExecuteConfig config, QueryPageResult queryPageResult) {
        Long total = null;
        Map<String, Serializable> key = null;
        Cache<Object, QueryPageResult> queryPageResultCache = hammerConfig.getCacheConfig().getQueryPageResultCache();
        if (hammerConfig.getTemplateConfig().getQueryConfig().isCachePageCount() && queryPageResultCache != null) {
            key = getKey(sql, effectiveParams);
            if (queryPageResult == null) {
                queryPageResult = queryPageResultCache.get(key);
            }
            if (queryPageResult != null) {
                total = queryPageResult.getTotal();
            }
            if (total != null) {
                logger.debug("pagination count result [{}] found in cache", total);
                return total;
            }
        }

        String countSql = null;
        ConditionParamsManager manager = null;
        if (Lang.isEmpty(config.getCount())) {
            countSql = SqlUtils.convertSelectToCount(sql);
            manager = conditionParamsManager;
        } else {
            Tuple2<String, ConditionParamsManager> countTuple = getCountExecution(effectiveParams, config);
            countSql = countTuple.get0();
            manager = countTuple.get1();
        }

        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            total = jdbc.queryLong(countSql, getEffectiveParamArray(effectiveParams, manager, config));
        } else {
            total = jdbc.queryLong(countSql, effectiveParams);
        }
        if (hammerConfig.getTemplateConfig().getQueryConfig().isCachePageCount() && queryPageResultCache != null) {
            if (queryPageResult != null) {
                queryPageResult.setTotal(total);
            } else {
                queryPageResult = new QueryPageResult(total);
            }
        }
        if (queryPageResult != null && queryPageResultCache != null) {
            queryPageResultCache.put(key, queryPageResult);
        }
        return total;
    }

    private Serializable[] getEffectiveParamArray(Serializable[] params, ConditionParamsManager manager) {
        List<Object> paramList = new ArrayList<>(params.length);
        for (int i = 0; i < params.length; i++) {
            if (manager.filterParamIndex(i)) {
                continue;
            }
            Lang.eachObj(params[i], o -> paramList.add(o));
        }
        return paramList.toArray(new Serializable[paramList.size()]);
    }

    private Serializable[] getEffectiveParamArray(final Map<String, Serializable> params,
        ConditionParamsManager manager, TplExecuteConfig config) {
        return Arrays.stream(config.getParams()).filter( //
            p -> !manager.filterParamName(p.getName())) //
            .map( //
                p -> transvert(p.getName(), params.get(p.getName()), manager)) //
            .toArray( //
                n -> new Serializable[n]);
    }

    private Map<String, Serializable> getEffectiveParamMap(final Map<String, Serializable> params,
        ConditionParamsManager manager) {
        return params.entrySet().stream().filter(t -> {
            return !manager.filterParamName(t.getKey());
        }).collect(Collectors.toMap(e -> {
            return e.getKey();
        }, e -> {
            return transvert(e.getKey(), e.getValue(), manager);
        }));
    }

    private Serializable transvert(Param param, Serializable value, ConditionParamsManager manager) {
        if (param != null && Lang.isNotEmpty(param.getTransverter())) {
            Transverter transverter = transverterManager.getExist(param.getTransverter());
            return transverter.transvert(param.getTransverter(), value);
        }
        return value;
    }

    //    private Object transvert(int index, Object value, ConditionParamsManagers manager) {
    //        return transvert(manager.getParam(index), value, manager);
    //    }

    private Serializable transvert(String name, Serializable value, ConditionParamsManager manager) {
        // YUFEI_TEST 调用前已经吧value == null的过滤了，不确定IgnorePolicy会否影响，后续测试
        //        if (value == null) {
        //            return value;
        //        }
        return transvert(manager.getParam(name), value, manager);
    }

    /**
     * 返回sqlPageFactory.
     *
     * @return sqlPageFactory
     */
    public SqlPageFactory getSqlPageFactory() {
        return sqlPageFactory;
    }

    // ****************************************************************************************************************
    //
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public int execute(TplExecuteId tplExecuteId, Serializable... params) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean bool(TplExecuteId tplExecuteId, Serializable... params) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int intValue(TplExecuteId tplExecuteId, Serializable... params) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long longValue(TplExecuteId tplExecuteId, Serializable... params) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double doubleValue(TplExecuteId tplExecuteId, Serializable... params) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <V> V value(TplExecuteId execution, Serializable... params) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <V> V value(TplExecuteId tplExecuteId, Class<V> valueType, Serializable... params) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Serializable> single(TplExecuteId tplExecuteId, Serializable... params) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T single(TplExecuteId tplExecuteId, Class<T> mapType, Serializable... params) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2> Tuple2<T1, T2> single(TplExecuteId tplExecuteId, Class<T1> mapType1, Class<T2> mapType2,
        Tuple2<String, String> prefixes, Serializable... params) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3> Tuple3<T1, T2, T3> single(TplExecuteId tplExecuteId, Class<T1> mapType1, Class<T2> mapType2,
        Class<T3> mapType3, Tuple3<String, String, String> prefixes, Serializable... params) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> single(TplExecuteId tplExecuteId, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Tuple4<String, String, String, String> prefixes,
        Serializable... params) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> single(TplExecuteId tplExecuteId, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5,
        Tuple5<String, String, String, String, String> prefixes, Serializable... params) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5, T6> Tuple6<T1, T2, T3, T4, T5, T6> single(TplExecuteId tplExecuteId, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5, Class<T6> mapType6,
        Tuple6<String, String, String, String, String, String> prefixes, Serializable... params) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Serializable> unique(TplExecuteId tplExecuteId, Serializable... params) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T unique(TplExecuteId tplExecuteId, Class<T> mapType, Serializable... params) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2> Tuple2<T1, T2> unique(TplExecuteId tplExecuteId, Class<T1> mapType1, Class<T2> mapType2,
        Tuple2<String, String> prefixes, Serializable... params) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3> Tuple3<T1, T2, T3> unique(TplExecuteId tplExecuteId, Class<T1> mapType1, Class<T2> mapType2,
        Class<T3> mapType3, Tuple3<String, String, String> prefixes, Serializable... params) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> unique(TplExecuteId tplExecuteId, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Tuple4<String, String, String, String> prefixes,
        Serializable... params) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> unique(TplExecuteId tplExecuteId, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5,
        Tuple5<String, String, String, String, String> prefixes, Serializable... params) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5, T6> Tuple6<T1, T2, T3, T4, T5, T6> unique(TplExecuteId tplExecuteId, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5, Class<T6> mapType6,
        Tuple6<String, String, String, String, String, String> prefixes, Serializable... params) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Serializable>> list(TplExecuteId tplExecuteId, Serializable... params) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> List<T> list(TplExecuteId tplExecuteId, Class<T> mapType, Serializable... params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
            PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, mapType);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        return jdbc.queryList(sql, mapType, getEffectiveParamArray(params, manager));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Serializable>> list(TplExecuteId tplExecuteId, Serializable[] params, int offset,
        int limit) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> List<T> list(TplExecuteId tplExecuteId, Class<T> mapType, Serializable[] params, int offset, int limit) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2> List<Tuple2<T1, T2>> list(TplExecuteId tplExecuteId, Class<T1> mapType1, Class<T2> mapType2,
        Tuple2<String, String> prefixes, Serializable... params) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2> List<Tuple2<T1, T2>> list(TplExecuteId tplExecuteId, Class<T1> mapType1, Class<T2> mapType2,
        Tuple2<String, String> prefixes, Serializable[] params, int offset, int limit) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3> List<Tuple3<T1, T2, T3>> list(TplExecuteId tplExecuteId, Class<T1> mapType1, Class<T2> mapType2,
        Class<T3> mapType3, Tuple3<String, String, String> prefixes, Serializable... params) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3> List<Tuple3<T1, T2, T3>> list(TplExecuteId tplExecuteId, Class<T1> mapType1, Class<T2> mapType2,
        Class<T3> mapType3, Tuple3<String, String, String> prefixes, Serializable[] params, int offset, int limit) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4> List<Tuple4<T1, T2, T3, T4>> list(TplExecuteId tplExecuteId, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Tuple4<String, String, String, String> prefixes,
        Serializable... params) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4> List<Tuple4<T1, T2, T3, T4>> list(TplExecuteId tplExecuteId, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Tuple4<String, String, String, String> prefixes,
        Serializable[] params, int offset, int limit) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5> List<Tuple5<T1, T2, T3, T4, T5>> list(TplExecuteId tplExecuteId, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5,
        Tuple5<String, String, String, String, String> prefixes, Serializable... params) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5> List<Tuple5<T1, T2, T3, T4, T5>> list(TplExecuteId tplExecuteId, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5,
        Tuple5<String, String, String, String, String> prefixes, Serializable[] params, int offset, int limit) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5, T6> List<Tuple6<T1, T2, T3, T4, T5, T6>> list(TplExecuteId tplExecuteId,
        Class<T1> mapType1, Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5,
        Class<T6> mapType6, Tuple6<String, String, String, String, String, String> prefixes, Serializable... params) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5, T6> List<Tuple6<T1, T2, T3, T4, T5, T6>> list(TplExecuteId tplExecuteId,
        Class<T1> mapType1, Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5,
        Class<T6> mapType6, Tuple6<String, String, String, String, String, String> prefixes, Serializable[] params,
        int offset, int limit) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<Map<String, Serializable>> pagination(TplExecuteId tplExecuteId, Serializable[] params,
        int offset, int limit) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> PaginationResults<T> pagination(TplExecuteId tplExecuteId, Class<T> mapType, Serializable[] params,
        int offset, int limit) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2> PaginationResults<Tuple2<T1, T2>> pagination(TplExecuteId tplExecuteId, Class<T1> mapType1,
        Class<T2> mapType2, Tuple2<String, String> prefixes, Serializable[] params, int offset, int limit) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3> PaginationResults<Tuple3<T1, T2, T3>> pagination(TplExecuteId tplExecuteId, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Tuple3<String, String, String> prefixes, Serializable[] params,
        int offset, int limit) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4> PaginationResults<Tuple4<T1, T2, T3, T4>> pagination(TplExecuteId tplExecuteId,
        Class<T1> mapType1, Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4,
        Tuple4<String, String, String, String> prefixes, Serializable[] params, int offset, int limit) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5> PaginationResults<Tuple5<T1, T2, T3, T4, T5>> pagination(TplExecuteId tplExecuteId,
        Class<T1> mapType1, Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5,
        Tuple5<String, String, String, String, String> prefixes, Serializable[] params, int offset, int limit) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5, T6> PaginationResults<Tuple6<T1, T2, T3, T4, T5, T6>> pagination(
        TplExecuteId tplExecuteId, Class<T1> mapType1, Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4,
        Class<T5> mapType5, Class<T6> mapType6, Tuple6<String, String, String, String, String, String> prefixes,
        Serializable[] params, int offset, int limit) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T single(TplExecuteId execution, RowMapper<T> rowMapper, Serializable... params) {
        // NOIMPL 模板执行未实现映射参数为RowMapper的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T unique(TplExecuteId execution, RowMapper<T> rowMapper, Serializable... params) {
        // NOIMPL 模板执行未实现映射参数为RowMapper的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> List<T> list(TplExecuteId execution, RowMapper<T> rowMapper, Serializable... params) {
        // NOIMPL 模板执行未实现映射参数为RowMapper的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> List<T> list(TplExecuteId execution, RowMapper<T> rowMapper, Serializable[] params, int offset,
        int limit) {
        // NOIMPL 模板执行未实现映射参数为RowMapper的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> PaginationResults<T> pagination(TplExecuteId execution, RowMapper<T> rowMapper, Serializable[] params,
        int offset, int limit) {
        // NOIMPL 模板执行未实现映射参数为RowMapper的情况
        throw new NotImplementedException();
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public AutoCloseableIterable<Map<String, Serializable>> each(TplExecuteId execution, Serializable... params) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> AutoCloseableIterable<T> each(TplExecuteId execution, Class<T> mappingType, Serializable... params) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> AutoCloseableIterable<T> each(TplExecuteId execution, RowMapper<T> rowMapper, Serializable... params) {
        // NOIMPL 模板执行未实现映射参数为RowMapper的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AutoCloseableIterable<Map<String, Serializable>> each(TplExecuteId execution, Serializable[] params,
        int offset, int limit) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> AutoCloseableIterable<T> each(TplExecuteId execution, Class<T> mappingType, Serializable[] params,
        int offset, int limit) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> AutoCloseableIterable<T> each(TplExecuteId execution, RowMapper<T> rowMapper, Serializable[] params,
        int offset, int limit) {
        // NOIMPL 模板执行未实现映射参数为RowMapper的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2> AutoCloseableIterable<Tuple2<T1, T2>> each(TplExecuteId execution, Class<T1> mappingType1,
        Class<T2> mappingType2, Tuple2<String, String> prefixes, Serializable... params) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2> AutoCloseableIterable<Tuple2<T1, T2>> each(TplExecuteId execution, Class<T1> mappingType1,
        Class<T2> mappingType2, Tuple2<String, String> prefixes, Serializable[] params, int offset, int limit) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3> AutoCloseableIterable<Tuple3<T1, T2, T3>> each(TplExecuteId execution, Class<T1> mappingType1,
        Class<T2> mappingType2, Class<T3> mappingType3, Tuple3<String, String, String> prefixes,
        Serializable... params) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3> AutoCloseableIterable<Tuple3<T1, T2, T3>> each(TplExecuteId execution, Class<T1> mappingType1,
        Class<T2> mappingType2, Class<T3> mappingType3, Tuple3<String, String, String> prefixes, Serializable[] params,
        int offset, int limit) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4> AutoCloseableIterable<Tuple4<T1, T2, T3, T4>> each(TplExecuteId execution,
        Class<T1> mappingType1, Class<T2> mappingType2, Class<T3> mappingType3, Class<T4> mappingType4,
        Tuple4<String, String, String, String> prefixes, Serializable... params) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4> AutoCloseableIterable<Tuple4<T1, T2, T3, T4>> each(TplExecuteId execution,
        Class<T1> mappingType1, Class<T2> mappingType2, Class<T3> mappingType3, Class<T4> mappingType4,
        Tuple4<String, String, String, String> prefixes, Serializable[] params, int offset, int limit) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5> AutoCloseableIterable<Tuple5<T1, T2, T3, T4, T5>> each(TplExecuteId execution,
        Class<T1> mappingType1, Class<T2> mappingType2, Class<T3> mappingType3, Class<T4> mappingType4,
        Class<T5> mappingType5, Tuple5<String, String, String, String, String> prefixes, Serializable... params) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5> AutoCloseableIterable<Tuple5<T1, T2, T3, T4, T5>> each(TplExecuteId execution,
        Class<T1> mappingType1, Class<T2> mappingType2, Class<T3> mappingType3, Class<T4> mappingType4,
        Class<T5> mappingType5, Tuple5<String, String, String, String, String> prefixes, Serializable[] params,
        int offset, int limit) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5, T6> AutoCloseableIterable<Tuple6<T1, T2, T3, T4, T5, T6>> each(TplExecuteId execution,
        Class<T1> mappingType1, Class<T2> mappingType2, Class<T3> mappingType3, Class<T4> mappingType4,
        Class<T5> mappingType5, Class<T6> mappingType6, Tuple6<String, String, String, String, String, String> prefixes,
        Serializable... params) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5, T6> AutoCloseableIterable<Tuple6<T1, T2, T3, T4, T5, T6>> each(TplExecuteId execution,
        Class<T1> mappingType1, Class<T2> mappingType2, Class<T3> mappingType3, Class<T4> mappingType4,
        Class<T5> mappingType5, Class<T6> mappingType6, Tuple6<String, String, String, String, String, String> prefixes,
        Serializable[] params, int offset, int limit) {
        // NOIMPL 模板执行未实现参数为数组的情况
        throw new NotImplementedException();
    }

    // ****************************************************************************************************************
    //	private method
    // ****************************************************************************************************************

    /**
     * Find list.
     *
     * @param tplExecuteId the tpl execute id
     * @param params the params
     * @param offset the offset
     * @param limit the limit
     * @return the tuple 5
     */
    private Tuple5<AutoCloseableIterable<Map<String, Serializable>>, String, TplExecuteConfig, ConditionParamsManager,
        Map<String, Serializable>> findEach(TplExecuteId tplExecuteId, Map<String, Serializable> params, int offset,
            int limit) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
            PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, ArrayUtils.EMPTY_CLASS_ARRAY);
        AutoCloseableIterable<Map<String, Serializable>> iterable = null;
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        TplExecuteConfig config = tuple4.get1();

        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            SqlPageQuery<Serializable[]> sqlPageQuery = sqlPageFactory.toPage(jdbc.getDialect(), sql, offset, limit,
                getEffectiveParamArray(params, manager, config));
            iterable = jdbc.queryEach(sqlPageQuery.getSql(), sqlPageQuery.getParams());
            return Tuples.of(iterable, sql, tuple4.get1(), manager, getEffectiveParamMap(params, manager));
        } else {
            SqlPageQuery<Map<String, Serializable>> sqlPageQuery = sqlPageFactory.toPage(jdbc.getDialect(), sql, offset,
                limit, getEffectiveParamMap(params, manager));
            iterable = jdbc.queryEach(sqlPageQuery.getSql(), sqlPageQuery.getParams());
            return Tuples.of(iterable, sql, tuple4.get1(), manager, sqlPageQuery.getParams());
        }
    }

    private <E> Tuple5<AutoCloseableIterable<E>, String, TplExecuteConfig, ConditionParamsManager,
        Map<String, Serializable>> findEach(TplExecuteId tplExecuteId, Class<E> entityType,
            Map<String, Serializable> params, int offset, int limit) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
            PropertiesMappingManager> tuple3 = getQueryExecution(tplExecuteId, params, entityType);
        AutoCloseableIterable<E> list = null;
        String sql = tuple3.get0();
        ConditionParamsManager manager = tuple3.get2();
        TplExecuteConfig config = tuple3.get1();
        // after getQueryExecution
        if (config.getParamsFormat() == ParamsFormat.INDEX) {
            SqlPageQuery<Serializable[]> sqlPageQuery = sqlPageFactory.toPage(jdbc.getDialect(), sql, offset, limit,
                getEffectiveParamArray(params, manager, config));
            list = jdbc.queryEach(sqlPageQuery.getSql(), entityType, sqlPageQuery.getParams());
            return Tuples.of(list, sql, tuple3.get1(), manager, getEffectiveParamMap(params, manager));
        } else {
            SqlPageQuery<Map<String, Serializable>> sqlPageQuery = sqlPageFactory.toPage(jdbc.getDialect(), sql, offset,
                limit, getEffectiveParamMap(params, manager));
            list = jdbc.queryEach(sqlPageQuery.getSql(), entityType, sqlPageQuery.getParams());
            return Tuples.of(list, sql, tuple3.get1(), manager, sqlPageQuery.getParams());
        }
    }

    private <E1,
        E2> Tuple5<AutoCloseableIterable<Tuple2<E1, E2>>, String, TplExecuteConfig, ConditionParamsManager,
            Map<String, Serializable>> findEach(TplExecuteId tplExecuteId, Class<E1> entityType1, Class<E2> entityType2,
                Tuple2<String, String> prefixes, Map<String, Serializable> params, int offset, int limit) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
            PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, entityType1, entityType2);
        AutoCloseableIterable<Tuple2<E1, E2>> list = null;
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        SqlPageQuery<Map<String, Serializable>> sqlPageQuery = sqlPageFactory.toPage(jdbc.getDialect(), sql, offset,
            limit, getEffectiveParamMap(params, manager));
        if (prefixes == null) {
            PropertiesMappingManager propManager = tuple4.get3();
            list = jdbc.queryEach(sqlPageQuery.getSql(), entityType1, entityType2,
                Tuples.of(propManager.getValue(0).getAlias() + ".", propManager.getValue(1).getAlias() + "."),
                sqlPageQuery.getParams());
            return Tuples.of(list, sql, tuple4.get1(), manager, getEffectiveParamMap(params, manager));
        } else {
            list = jdbc.queryEach(sqlPageQuery.getSql(), entityType1, entityType2, prefixes, sqlPageQuery.getParams());
            return Tuples.of(list, sql, tuple4.get1(), manager, sqlPageQuery.getParams());
        }
    }

    private <E1, E2,
        E3> Tuple5<AutoCloseableIterable<Tuple3<E1, E2, E3>>, String, TplExecuteConfig, ConditionParamsManager,
            Map<String, Serializable>> findEach(TplExecuteId tplExecuteId, Class<E1> entityType1, Class<E2> entityType2,
                Class<E3> entityType3, Tuple3<String, String, String> prefixes, Map<String, Serializable> params,
                int offset, int limit) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
            PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, entityType1, entityType2);
        AutoCloseableIterable<Tuple3<E1, E2, E3>> list = null;
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        SqlPageQuery<Map<String, Serializable>> sqlPageQuery = sqlPageFactory.toPage(jdbc.getDialect(), sql, offset,
            limit, getEffectiveParamMap(params, manager));
        if (prefixes == null) {
            PropertiesMappingManager propManager = tuple4.get3();
            list = jdbc.queryEach(sqlPageQuery.getSql(), entityType1, entityType2, entityType3,
                Tuples.of(propManager.getValue(0).getAlias() + ".", propManager.getValue(1).getAlias() + ".",
                    propManager.getValue(2).getAlias() + "."),
                sqlPageQuery.getParams());
            return Tuples.of(list, sql, tuple4.get1(), manager, getEffectiveParamMap(params, manager));
        } else {
            list = jdbc.queryEach(sqlPageQuery.getSql(), entityType1, entityType2, entityType3, prefixes,
                sqlPageQuery.getParams());
            return Tuples.of(list, sql, tuple4.get1(), manager, sqlPageQuery.getParams());
        }
    }

    private <E1, E2, E3,
        E4> Tuple5<AutoCloseableIterable<Tuple4<E1, E2, E3, E4>>, String, TplExecuteConfig, ConditionParamsManager,
            Map<String, Serializable>> findEach(TplExecuteId tplExecuteId, Class<E1> entityType1, Class<E2> entityType2,
                Class<E3> entityType3, Class<E4> entityType4, Tuple4<String, String, String, String> prefixes,
                Map<String, Serializable> params, int offset, int limit) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
            PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, entityType1, entityType2);
        AutoCloseableIterable<Tuple4<E1, E2, E3, E4>> list = null;
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        SqlPageQuery<Map<String, Serializable>> sqlPageQuery = sqlPageFactory.toPage(jdbc.getDialect(), sql, offset,
            limit, getEffectiveParamMap(params, manager));
        if (prefixes == null) {
            PropertiesMappingManager propManager = tuple4.get3();
            list = jdbc.queryEach(sqlPageQuery.getSql(), entityType1, entityType2, entityType3, entityType4,
                Tuples.of(propManager.getValue(0).getAlias() + ".", propManager.getValue(1).getAlias() + ".",
                    propManager.getValue(2).getAlias() + ".", propManager.getValue(3).getAlias() + "."),
                sqlPageQuery.getParams());
            return Tuples.of(list, sql, tuple4.get1(), manager, getEffectiveParamMap(params, manager));
        } else {
            list = jdbc.queryEach(sqlPageQuery.getSql(), entityType1, entityType2, entityType3, entityType4, prefixes,
                sqlPageQuery.getParams());
            return Tuples.of(list, sql, tuple4.get1(), manager, sqlPageQuery.getParams());
        }
    }

    private <E1, E2, E3, E4,
        E5> Tuple5<AutoCloseableIterable<Tuple5<E1, E2, E3, E4, E5>>, String, TplExecuteConfig, ConditionParamsManager,
            Map<String, Serializable>> findEach(TplExecuteId tplExecuteId, Class<E1> entityType1, Class<E2> entityType2,
                Class<E3> entityType3, Class<E4> entityType4, Class<E5> entityType5,
                Tuple5<String, String, String, String, String> prefixes, Map<String, Serializable> params, int offset,
                int limit) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
            PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, entityType1, entityType2);
        AutoCloseableIterable<Tuple5<E1, E2, E3, E4, E5>> list = null;
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        SqlPageQuery<Map<String, Serializable>> sqlPageQuery = sqlPageFactory.toPage(jdbc.getDialect(), sql, offset,
            limit, getEffectiveParamMap(params, manager));
        if (prefixes == null) {
            PropertiesMappingManager propManager = tuple4.get3();
            list = jdbc.queryEach(sqlPageQuery.getSql(), entityType1, entityType2, entityType3, entityType4,
                entityType5,
                Tuples.of(propManager.getValue(0).getAlias() + ".", propManager.getValue(1).getAlias() + ".",
                    propManager.getValue(2).getAlias() + ".", propManager.getValue(3).getAlias() + ".",
                    propManager.getValue(4).getAlias() + "."),
                sqlPageQuery.getParams());
            return Tuples.of(list, sql, tuple4.get1(), manager, getEffectiveParamMap(params, manager));
        } else {
            list = jdbc.queryEach(sqlPageQuery.getSql(), entityType1, entityType2, entityType3, entityType4,
                entityType5, prefixes, sqlPageQuery.getParams());
            return Tuples.of(list, sql, tuple4.get1(), manager, sqlPageQuery.getParams());
        }
    }

    private <E1, E2, E3, E4, E5,
        E6> Tuple5<AutoCloseableIterable<Tuple6<E1, E2, E3, E4, E5, E6>>, String, TplExecuteConfig,
            ConditionParamsManager, Map<String, Serializable>> findEach(TplExecuteId tplExecuteId,
                Class<E1> entityType1, Class<E2> entityType2, Class<E3> entityType3, Class<E4> entityType4,
                Class<E5> entityType5, Class<E6> entityType6,
                Tuple6<String, String, String, String, String, String> prefixes, Map<String, Serializable> params,
                int offset, int limit) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
            PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, entityType1, entityType2);
        AutoCloseableIterable<Tuple6<E1, E2, E3, E4, E5, E6>> list = null;
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        SqlPageQuery<Map<String, Serializable>> sqlPageQuery = sqlPageFactory.toPage(jdbc.getDialect(), sql, offset,
            limit, getEffectiveParamMap(params, manager));
        if (prefixes == null) {
            PropertiesMappingManager propManager = tuple4.get3();
            list = jdbc.queryEach(sqlPageQuery.getSql(), entityType1, entityType2, entityType3, entityType4,
                entityType5, entityType6,
                Tuples.of(propManager.getValue(0).getAlias() + ".", propManager.getValue(1).getAlias() + ".",
                    propManager.getValue(2).getAlias() + ".", propManager.getValue(3).getAlias() + ".",
                    propManager.getValue(4).getAlias() + ".", propManager.getValue(5).getAlias() + "."),
                sqlPageQuery.getParams());
            return Tuples.of(list, sql, tuple4.get1(), manager, getEffectiveParamMap(params, manager));
        } else {
            list = jdbc.queryEach(sqlPageQuery.getSql(), entityType1, entityType2, entityType3, entityType4,
                entityType5, entityType6, prefixes, sqlPageQuery.getParams());
            return Tuples.of(list, sql, tuple4.get1(), manager, sqlPageQuery.getParams());
        }
    }
}
