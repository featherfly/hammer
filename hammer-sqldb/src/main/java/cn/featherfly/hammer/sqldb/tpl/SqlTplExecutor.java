
package cn.featherfly.hammer.sqldb.tpl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Nonnull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.speedment.common.tuple.Tuple;
import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuple3;
import com.speedment.common.tuple.Tuple4;
import com.speedment.common.tuple.Tuple5;
import com.speedment.common.tuple.Tuples;

import cn.featherfly.common.db.SqlUtils;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.common.structure.page.SimplePaginationResults;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory.SqlPageQuery;
import cn.featherfly.hammer.tpl.TplConfigFactory;
import cn.featherfly.hammer.tpl.TplExecuteConfig;
import cn.featherfly.hammer.tpl.TplExecuteId;
import cn.featherfly.hammer.tpl.TplExecuteIdFileImpl;
import cn.featherfly.hammer.tpl.TplExecutor;
import cn.featherfly.hammer.tpl.Transverter;
import cn.featherfly.hammer.tpl.TransverterManager;
import cn.featherfly.hammer.tpl.directive.TemplateDirective;
import cn.featherfly.hammer.tpl.method.TemplateMethod;
import cn.featherfly.hammer.tpl.supports.ConditionParamsManager;
import cn.featherfly.hammer.tpl.supports.ConditionParamsManager.Param;
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

    /**
     * Instantiates a new sql tpl executor.
     *
     * @param configFactory      configFactory
     * @param templateEngine     templateEngine
     * @param jdbc               jdbc
     * @param mappingFactory     mappingFactory
     * @param sqlPageFactory     the sql page factory
     * @param transverterManager the transverter manager
     */
    @SuppressWarnings("unchecked")
    public SqlTplExecutor(@Nonnull TplConfigFactory configFactory,
            @SuppressWarnings("rawtypes") @Nonnull SqlDbTemplateEngine templateEngine, @Nonnull Jdbc jdbc,
            @Nonnull JdbcMappingFactory mappingFactory, SqlPageFactory sqlPageFactory,
            TransverterManager transverterManager) {
        super();
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
    public int execute(String tplExecuteId, Map<String, Object> params) {
        return execute(new TplExecuteIdFileImpl(tplExecuteId), params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int execute(TplExecuteId tplExecuteId, Map<String, Object> params) {
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
    public Map<String, Object> single(String tplExecuteId, Map<String, Object> params) {
        return single(new TplExecuteIdFileImpl(tplExecuteId), params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Object> single(TplExecuteId tplExecuteId, Map<String, Object> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager, PropertiesMappingManager> tuple3 = getQueryExecution(
                tplExecuteId, params, ArrayUtils.EMPTY_CLASS_ARRAY);
        String sql = tuple3.get0();
        ConditionParamsManager manager = tuple3.get2();
        return jdbc.querySingle(sql, getEffectiveParamMap(params, manager));
        // 模板SQL不支持默认占位符 xxx = ?
        //        if (manager.getParamNamed() == null || manager.getParamNamed()) {
        //            return jdbc.querySingle(sql, getEffectiveParamMap(params, manager));
        //        } else {
        //            return jdbc.querySingle(sql, getEffectiveParamArray(params, manager));
        //        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E single(String tplExecuteId, Class<E> entityType, Map<String, Object> params) {
        return single(new TplExecuteIdFileImpl(tplExecuteId), entityType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E single(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
                PropertiesMappingManager> tuple3 = getQueryExecution(tplExecuteId, params, entityType);
        String sql = tuple3.get0();
        ConditionParamsManager manager = tuple3.get2();
        return jdbc.querySingle(sql, entityType, getEffectiveParamMap(params, manager));
        // 模板SQL不支持默认占位符 xxx = ?
        //        if (manager.getParamNamed() == null || manager.getParamNamed()) {
        //            return jdbc.querySingle(sql, entityType, getEffectiveParamMap(params, manager));
        //        } else {
        //            return jdbc.querySingle(sql, entityType, getEffectiveParamArray(params, manager));
        //        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> Tuple2<R1, R2> single(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Map<String, Object> params) {
        return single(new TplExecuteIdFileImpl(tplExecuteId), entityType1, entityType2, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> Tuple2<R1, R2> single(TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Map<String, Object> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
                PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, entityType1, entityType2);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        PropertiesMappingManager propManager = tuple4.get3();

        return jdbc.querySingle(sql, entityType1, entityType2,
                Tuples.of(propManager.getValue(0).getAlias() + ".", propManager.getValue(1).getAlias() + "."),
                getEffectiveParamMap(params, manager));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> Tuple2<R1, R2> single(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Tuple2<String, String> prefixes, Map<String, Object> params) {
        return single(new TplExecuteIdFileImpl(tplExecuteId), entityType1, entityType2, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> Tuple2<R1, R2> single(TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Tuple2<String, String> prefixes, Map<String, Object> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
                PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, entityType1, entityType2);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        return jdbc.querySingle(sql, entityType1, entityType2, prefixes, getEffectiveParamMap(params, manager));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> Tuple3<R1, R2, R3> single(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Class<R3> entityType3, Map<String, Object> params) {
        return single(new TplExecuteIdFileImpl(tplExecuteId), entityType1, entityType2, entityType3, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> Tuple3<R1, R2, R3> single(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Map<String, Object> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
                PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, entityType1, entityType2);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        PropertiesMappingManager propManager = tuple4.get3();
        return jdbc.querySingle(
                sql, entityType1, entityType2, entityType3, Tuples.of(propManager.getValue(0).getAlias() + ".",
                        propManager.getValue(1).getAlias() + ".", propManager.getValue(2).getAlias() + "."),
                getEffectiveParamMap(params, manager));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> Tuple3<R1, R2, R3> single(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Class<R3> entityType3, Tuple3<String, String, String> prefixes, Map<String, Object> params) {
        return single(new TplExecuteIdFileImpl(tplExecuteId), entityType1, entityType2, entityType3, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> Tuple3<R1, R2, R3> single(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Tuple3<String, String, String> prefixes,
            Map<String, Object> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
                PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, entityType1, entityType2);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        return jdbc.querySingle(sql, entityType1, entityType2, entityType3, prefixes,
                getEffectiveParamMap(params, manager));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> Tuple4<R1, R2, R3, R4> single(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Map<String, Object> params) {
        return single(new TplExecuteIdFileImpl(tplExecuteId), entityType1, entityType2, entityType3, entityType4,
                params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> Tuple4<R1, R2, R3, R4> single(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Map<String, Object> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
                PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, entityType1, entityType2);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        PropertiesMappingManager propManager = tuple4.get3();
        return jdbc.querySingle(sql, entityType1, entityType2, entityType3, entityType4,
                Tuples.of(propManager.getValue(0).getAlias() + ".", propManager.getValue(1).getAlias() + ".",
                        propManager.getValue(2).getAlias() + ".", propManager.getValue(3).getAlias() + "."),
                getEffectiveParamMap(params, manager));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> Tuple4<R1, R2, R3, R4> single(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Tuple4<String, String, String, String> prefixes, Map<String, Object> params) {
        return single(new TplExecuteIdFileImpl(tplExecuteId), entityType1, entityType2, entityType3, entityType4,
                prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> Tuple4<R1, R2, R3, R4> single(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Tuple4<String, String, String, String> prefixes, Map<String, Object> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
                PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, entityType1, entityType2);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        return jdbc.querySingle(sql, entityType1, entityType2, entityType3, entityType4, prefixes,
                getEffectiveParamMap(params, manager));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> Tuple5<R1, R2, R3, R4, R5> single(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Map<String, Object> params) {
        return single(new TplExecuteIdFileImpl(tplExecuteId), entityType1, entityType2, entityType3, entityType4,
                entityType5, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> Tuple5<R1, R2, R3, R4, R5> single(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Map<String, Object> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
                PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, entityType1, entityType2);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        PropertiesMappingManager propManager = tuple4.get3();
        return jdbc.querySingle(sql, entityType1, entityType2, entityType3, entityType4, entityType5,
                Tuples.of(propManager.getValue(0).getAlias() + ".", propManager.getValue(1).getAlias() + ".",
                        propManager.getValue(2).getAlias() + ".", propManager.getValue(3).getAlias() + ".",
                        propManager.getValue(4).getAlias() + "."),
                getEffectiveParamMap(params, manager));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> Tuple5<R1, R2, R3, R4, R5> single(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Tuple5<String, String, String, String, String> prefixes, Map<String, Object> params) {
        return single(new TplExecuteIdFileImpl(tplExecuteId), entityType1, entityType2, entityType3, entityType4,
                entityType5, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> Tuple5<R1, R2, R3, R4, R5> single(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Tuple5<String, String, String, String, String> prefixes, Map<String, Object> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
                PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, entityType1, entityType2);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        return jdbc.querySingle(sql, entityType1, entityType2, entityType3, entityType4, entityType5, prefixes,
                getEffectiveParamMap(params, manager));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> list(String tplExecuteId, Map<String, Object> params) {
        return list(new TplExecuteIdFileImpl(tplExecuteId), params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> list(TplExecuteId tplExecuteId, Map<String, Object> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager, PropertiesMappingManager> tuple4 = getQueryExecution(
                tplExecuteId, params, ArrayUtils.EMPTY_CLASS_ARRAY);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        return jdbc.query(sql, getEffectiveParamMap(params, manager));
        // 模板SQL不支持默认占位符 xxx = ?
        //        if (manager.getParamNamed() == null || manager.getParamNamed()) {
        //            return jdbc.query(sql, getEffectiveParamMap(params, manager));
        //        } else {
        //            return jdbc.query(sql, getEffectiveParamArray(params, manager));
        //        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(String tplExecuteId, Class<E> entityType, Map<String, Object> params) {
        return list(new TplExecuteIdFileImpl(tplExecuteId), entityType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
                PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, entityType);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        return jdbc.query(sql, entityType, getEffectiveParamMap(params, manager));
        // 模板SQL不支持默认占位符 xxx = ?
        //        if (manager.getParamNamed() == null || manager.getParamNamed()) {
        //            return jdbc.query(sql, entityType, getEffectiveParamMap(params, manager));
        //        } else {
        //            return jdbc.query(sql, entityType, getEffectiveParamArray(params, manager));
        //        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> list(String tplExecuteId, Map<String, Object> params, int offset, int limit) {
        return list(new TplExecuteIdFileImpl(tplExecuteId), params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> list(TplExecuteId tplExecuteId, Map<String, Object> params, int offset,
            int limit) {
        return findList(tplExecuteId, params, offset, limit).get0();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(String tplExecuteId, Class<E> entityType, Map<String, Object> params, int offset,
            int limit) {
        return list(new TplExecuteIdFileImpl(tplExecuteId), entityType, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params, int offset,
            int limit) {
        return findList(tplExecuteId, entityType, params, offset, limit).get0();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> List<Tuple2<R1, R2>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Map<String, Object> params) {
        return list(new TplExecuteIdFileImpl(tplExecuteId), entityType1, entityType2, params);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> List<Tuple2<R1, R2>> list(TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Map<String, Object> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
                PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, entityType1, entityType2);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        PropertiesMappingManager propManager = tuple4.get3();
        return jdbc.query(sql, entityType1, entityType2,
                Tuples.of(propManager.getValue(0).getAlias() + ".", propManager.getValue(1).getAlias() + "."),
                getEffectiveParamMap(params, manager));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> List<Tuple2<R1, R2>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Map<String, Object> params, int offset, int limit) {
        return list(new TplExecuteIdFileImpl(tplExecuteId), entityType1, entityType2, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> List<Tuple2<R1, R2>> list(TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Map<String, Object> params, int offset, int limit) {
        return findList(tplExecuteId, entityType1, entityType2, null, params, offset, limit).get0();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> List<Tuple2<R1, R2>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Tuple2<String, String> prefixes, Map<String, Object> params) {
        return list(new TplExecuteIdFileImpl(tplExecuteId), entityType1, entityType2, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> List<Tuple2<R1, R2>> list(TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Tuple2<String, String> prefixes, Map<String, Object> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
                PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, entityType1, entityType2);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        return jdbc.query(sql, entityType1, entityType2, prefixes, getEffectiveParamMap(params, manager));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> List<Tuple2<R1, R2>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Tuple2<String, String> prefixes, Map<String, Object> params, int offset, int limit) {
        return list(new TplExecuteIdFileImpl(tplExecuteId), entityType1, entityType2, prefixes, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> List<Tuple2<R1, R2>> list(TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Tuple2<String, String> prefixes, Map<String, Object> params, int offset, int limit) {
        return findList(tplExecuteId, entityType1, entityType2, prefixes, params, offset, limit).get0();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Class<R3> entityType3, Map<String, Object> params) {
        return list(new TplExecuteIdFileImpl(tplExecuteId), entityType1, entityType2, entityType3, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Map<String, Object> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
                PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, entityType1, entityType2);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        PropertiesMappingManager propManager = tuple4.get3();
        return jdbc.query(sql, entityType1, entityType2, entityType3,
                Tuples.of(propManager.getValue(0) + ".", propManager.getValue(1) + ".", propManager.getValue(2) + "."),
                getEffectiveParamMap(params, manager));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Class<R3> entityType3, Map<String, Object> params, int offset, int limit) {
        return list(new TplExecuteIdFileImpl(tplExecuteId), entityType1, entityType2, entityType3, params, offset,
                limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Map<String, Object> params, int offset, int limit) {
        return findList(tplExecuteId, entityType1, entityType2, entityType3, null, params, offset, limit).get0();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Class<R3> entityType3, Tuple3<String, String, String> prefixes, Map<String, Object> params) {
        return list(new TplExecuteIdFileImpl(tplExecuteId), entityType1, entityType2, entityType3, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Tuple3<String, String, String> prefixes,
            Map<String, Object> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
                PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, entityType1, entityType2);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        return jdbc.query(sql, entityType1, entityType2, entityType3, prefixes, getEffectiveParamMap(params, manager));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Class<R3> entityType3, Tuple3<String, String, String> prefixes, Map<String, Object> params, int offset,
            int limit) {
        return list(new TplExecuteIdFileImpl(tplExecuteId), entityType1, entityType2, entityType3, prefixes, params,
                offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Tuple3<String, String, String> prefixes,
            Map<String, Object> params, int offset, int limit) {
        return findList(tplExecuteId, entityType1, entityType2, entityType3, prefixes, params, offset, limit).get0();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Map<String, Object> params) {
        return list(new TplExecuteIdFileImpl(tplExecuteId), entityType1, entityType2, entityType3, entityType4, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Map<String, Object> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
                PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, entityType1, entityType2);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        PropertiesMappingManager propManager = tuple4.get3();
        return jdbc.query(
                sql, entityType1, entityType2, entityType3, entityType4, Tuples.of(propManager.getValue(0) + ".",
                        propManager.getValue(1) + ".", propManager.getValue(2) + ".", propManager.getValue(3) + "."),
                getEffectiveParamMap(params, manager));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Map<String, Object> params, int offset,
            int limit) {
        return list(new TplExecuteIdFileImpl(tplExecuteId), entityType1, entityType2, entityType3, entityType4, params,
                offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Map<String, Object> params, int offset,
            int limit) {
        return findList(tplExecuteId, entityType1, entityType2, entityType3, entityType4, null, params, offset, limit)
                .get0();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Tuple4<String, String, String, String> prefixes, Map<String, Object> params) {
        return list(new TplExecuteIdFileImpl(tplExecuteId), entityType1, entityType2, entityType3, entityType4,
                prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Tuple4<String, String, String, String> prefixes, Map<String, Object> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
                PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, entityType1, entityType2);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        return jdbc.query(sql, entityType1, entityType2, entityType3, entityType4, prefixes,
                getEffectiveParamMap(params, manager));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Tuple4<String, String, String, String> prefixes, Map<String, Object> params, int offset, int limit) {
        return list(new TplExecuteIdFileImpl(tplExecuteId), entityType1, entityType2, entityType3, entityType4,
                prefixes, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Tuple4<String, String, String, String> prefixes, Map<String, Object> params, int offset, int limit) {
        return findList(tplExecuteId, entityType1, entityType2, entityType3, entityType4, prefixes, params, offset,
                limit).get0();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Map<String, Object> params) {
        return list(new TplExecuteIdFileImpl(tplExecuteId), entityType1, entityType2, entityType3, entityType4,
                entityType5, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Map<String, Object> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
                PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, entityType1, entityType2);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        PropertiesMappingManager propManager = tuple4.get3();
        return jdbc.query(sql, entityType1, entityType2, entityType3, entityType4, entityType5,
                Tuples.of(propManager.getValue(0) + ".", propManager.getValue(1) + ".", propManager.getValue(2) + ".",
                        propManager.getValue(3) + ".", propManager.getValue(4) + "."),
                getEffectiveParamMap(params, manager));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Map<String, Object> params, int offset, int limit) {
        return list(new TplExecuteIdFileImpl(tplExecuteId), entityType1, entityType2, entityType3, entityType4,
                entityType5, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Map<String, Object> params, int offset, int limit) {
        return findList(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, null, params,
                offset, limit).get0();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Tuple5<String, String, String, String, String> prefixes, Map<String, Object> params) {
        return list(new TplExecuteIdFileImpl(tplExecuteId), entityType1, entityType2, entityType3, entityType4,
                entityType5, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Tuple5<String, String, String, String, String> prefixes, Map<String, Object> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
                PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, entityType1, entityType2);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        return jdbc.query(sql, entityType1, entityType2, entityType3, entityType4, entityType5, prefixes,
                getEffectiveParamMap(params, manager));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Tuple5<String, String, String, String, String> prefixes, Map<String, Object> params, int offset,
            int limit) {
        return list(new TplExecuteIdFileImpl(tplExecuteId), entityType1, entityType2, entityType3, entityType4,
                entityType5, prefixes, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Tuple5<String, String, String, String, String> prefixes, Map<String, Object> params, int offset,
            int limit) {
        return findList(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, prefixes, params,
                offset, limit).get0();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<Map<String, Object>> pagination(String tplExecuteId, Map<String, Object> params,
            int offset, int limit) {
        return pagination(new TplExecuteIdFileImpl(tplExecuteId), params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<Map<String, Object>> pagination(TplExecuteId tplExecuteId, Map<String, Object> params,
            int offset, int limit) {
        SimplePaginationResults<Map<String, Object>> pagination = new SimplePaginationResults<>(offset, limit);
        Tuple5<List<Map<String, Object>>, String, TplExecuteConfig, ConditionParamsManager,
                Map<String, Object>> listTuple = findList(tplExecuteId, params, offset, limit);
        pagination.setPageResults(listTuple.get0());
        pagination.setTotal(
                count(tplExecuteId, listTuple.get1(), params, listTuple.get4(), listTuple.get3(), listTuple.get2()));
        //        String countSql = null;
        //        ConditionParamsManager manager = null;
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

        // 模板SQL不支持默认占位符 xxx = ?
        //        // 默认使用namedParameter
        //        if (manager.getParamNamed() == null || manager.getParamNamed()) {
        //            pagination.setTotal(jdbc.queryInt(countSql, getEffectiveParamMap(listTuple.get4(), manager)));
        //        } else {
        //            pagination.setTotal(jdbc.queryInt(countSql, getEffectiveParamArray(listTuple.get4(), manager)));
        //        }
        return pagination;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> PaginationResults<E> pagination(String tplExecuteId, Class<E> entityType, Map<String, Object> params,
            int offset, int limit) {
        return pagination(new TplExecuteIdFileImpl(tplExecuteId), entityType, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> PaginationResults<E> pagination(TplExecuteId tplExecuteId, Class<E> entityType,
            Map<String, Object> params, int offset, int limit) {
        SimplePaginationResults<E> pagination = new SimplePaginationResults<>(offset, limit);

        Tuple5<List<E>, String, TplExecuteConfig, ConditionParamsManager,
                Map<String, Object>> listTuple = findList(tplExecuteId, entityType, params, offset, limit);
        pagination.setPageResults(listTuple.get0());
        pagination.setTotal(
                count(tplExecuteId, listTuple.get1(), params, listTuple.get4(), listTuple.get3(), listTuple.get2()));
        //        String countSql = null;
        //        ConditionParamsManager manager = null;
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
        // 模板SQL不支持默认占位符 xxx = ?
        //        // 默认使用namedParameter
        //        if (manager.getParamNamed() == null || manager.getParamNamed()) {
        //            pagination.setTotal(jdbc.queryInt(countSql, getEffectiveParamMap(listTuple.get4(), manager)));
        //        } else {
        //            pagination.setTotal(jdbc.queryInt(countSql, getEffectiveParamArray(listTuple.get4(), manager)));
        //        }
        return pagination;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> PaginationResults<Tuple2<R1, R2>> pagination(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Map<String, Object> params, int offset, int limit) {
        return pagination(new TplExecuteIdFileImpl(tplExecuteId), entityType1, entityType2, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> PaginationResults<Tuple2<R1, R2>> pagination(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Map<String, Object> params, int offset, int limit) {
        return pagination(tplExecuteId, entityType1, entityType2, (Tuple2<String, String>) null, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> PaginationResults<Tuple2<R1, R2>> pagination(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Tuple2<String, String> prefixes, Map<String, Object> params, int offset, int limit) {
        return pagination(new TplExecuteIdFileImpl(tplExecuteId), entityType1, entityType2, prefixes, params, offset,
                limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> PaginationResults<Tuple2<R1, R2>> pagination(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Tuple2<String, String> prefixes, Map<String, Object> params, int offset, int limit) {
        SimplePaginationResults<Tuple2<R1, R2>> pagination = new SimplePaginationResults<>(offset, limit);
        Tuple5<List<Tuple2<R1, R2>>, String, TplExecuteConfig, ConditionParamsManager, Map<String,
                Object>> listTuple = findList(tplExecuteId, entityType1, entityType2, prefixes, params, offset, limit);
        pagination.setPageResults(listTuple.get0());
        pagination.setTotal(
                count(tplExecuteId, listTuple.get1(), params, listTuple.get4(), listTuple.get3(), listTuple.get2()));
        return pagination;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> PaginationResults<Tuple3<R1, R2, R3>> pagination(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Map<String, Object> params, int offset, int limit) {
        return pagination(new TplExecuteIdFileImpl(tplExecuteId), entityType1, entityType2, entityType3, params, offset,
                limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> PaginationResults<Tuple3<R1, R2, R3>> pagination(TplExecuteId tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Map<String, Object> params, int offset,
            int limit) {
        return pagination(tplExecuteId, entityType1, entityType2, entityType3, (Tuple3<String, String, String>) null,
                params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> PaginationResults<Tuple3<R1, R2, R3>> pagination(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Tuple3<String, String, String> prefixes,
            Map<String, Object> params, int offset, int limit) {
        return pagination(new TplExecuteIdFileImpl(tplExecuteId), entityType1, entityType2, entityType3, prefixes,
                params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> PaginationResults<Tuple3<R1, R2, R3>> pagination(TplExecuteId tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3,
            Tuple3<String, String, String> prefixes, Map<String, Object> params, int offset, int limit) {
        SimplePaginationResults<Tuple3<R1, R2, R3>> pagination = new SimplePaginationResults<>(offset, limit);
        Tuple5<List<Tuple3<R1, R2, R3>>, String, TplExecuteConfig, ConditionParamsManager,
                Map<String, Object>> listTuple = findList(tplExecuteId, entityType1, entityType2, entityType3, prefixes,
                        params, offset, limit);
        pagination.setPageResults(listTuple.get0());
        pagination.setTotal(
                count(tplExecuteId, listTuple.get1(), params, listTuple.get4(), listTuple.get3(), listTuple.get2()));
        return pagination;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> PaginationResults<Tuple4<R1, R2, R3, R4>> pagination(String tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Map<String, Object> params, int offset, int limit) {
        return pagination(new TplExecuteIdFileImpl(tplExecuteId), entityType1, entityType2, entityType3, entityType4,
                params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> PaginationResults<Tuple4<R1, R2, R3, R4>> pagination(TplExecuteId tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Map<String, Object> params, int offset, int limit) {
        return pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4,
                (Tuple4<String, String, String, String>) null, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> PaginationResults<Tuple4<R1, R2, R3, R4>> pagination(String tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Tuple4<String, String, String, String> prefixes, Map<String, Object> params, int offset, int limit) {
        return pagination(new TplExecuteIdFileImpl(tplExecuteId), entityType1, entityType2, entityType3, entityType4,
                prefixes, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> PaginationResults<Tuple4<R1, R2, R3, R4>> pagination(TplExecuteId tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Tuple4<String, String, String, String> prefixes, Map<String, Object> params, int offset, int limit) {
        SimplePaginationResults<Tuple4<R1, R2, R3, R4>> pagination = new SimplePaginationResults<>(offset, limit);
        Tuple5<List<Tuple4<R1, R2, R3, R4>>, String, TplExecuteConfig, ConditionParamsManager,
                Map<String, Object>> listTuple = findList(tplExecuteId, entityType1, entityType2, entityType3,
                        entityType4, prefixes, params, offset, limit);
        pagination.setPageResults(listTuple.get0());
        pagination.setTotal(
                count(tplExecuteId, listTuple.get1(), params, listTuple.get4(), listTuple.get3(), listTuple.get2()));
        return pagination;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> PaginationResults<Tuple5<R1, R2, R3, R4, R5>> pagination(String tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Map<String, Object> params, int offset, int limit) {
        return pagination(new TplExecuteIdFileImpl(tplExecuteId), entityType1, entityType2, entityType3, entityType4,
                entityType5, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> PaginationResults<Tuple5<R1, R2, R3, R4, R5>> pagination(TplExecuteId tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Map<String, Object> params, int offset, int limit) {
        return pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, null, params,
                offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> PaginationResults<Tuple5<R1, R2, R3, R4, R5>> pagination(String tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Tuple5<String, String, String, String, String> prefixes, Map<String, Object> params,
            int offset, int limit) {
        return pagination(new TplExecuteIdFileImpl(tplExecuteId), entityType1, entityType2, entityType3, entityType4,
                entityType5, prefixes, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> PaginationResults<Tuple5<R1, R2, R3, R4, R5>> pagination(TplExecuteId tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Tuple5<String, String, String, String, String> prefixes, Map<String, Object> params,
            int offset, int limit) {
        SimplePaginationResults<Tuple5<R1, R2, R3, R4, R5>> pagination = new SimplePaginationResults<>(offset, limit);
        Tuple5<List<Tuple5<R1, R2, R3, R4, R5>>, String, TplExecuteConfig, ConditionParamsManager,
                Map<String, Object>> listTuple = findList(tplExecuteId, entityType1, entityType2, entityType3,
                        entityType4, entityType5, prefixes, params, offset, limit);
        pagination.setPageResults(listTuple.get0());
        //        String countSql = null;
        //        ConditionParamsManager manager = null;
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
        pagination.setTotal(
                count(tplExecuteId, listTuple.get1(), params, listTuple.get4(), listTuple.get3(), listTuple.get2()));
        return pagination;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E value(String tplExecuteId, Class<E> valueType, Map<String, Object> params) {
        return value(new TplExecuteIdFileImpl(tplExecuteId), valueType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E value(TplExecuteId tplExecuteId, Class<E> valueType, Map<String, Object> params) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
                PropertiesMappingManager> tuple4 = getQueryExecution(tplExecuteId, params, valueType);
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();
        return jdbc.queryValue(sql, valueType, getEffectiveParamMap(params, manager));
        // 模板SQL不支持默认占位符 xxx = ?
        //        if (manager.getParamNamed() == null || manager.getParamNamed()) {
        //            return jdbc.queryValue(sql, valueType, getEffectiveParamMap(params, manager));
        //        } else {
        //            return jdbc.queryValue(sql, valueType, getEffectiveParamArray(params, manager));
        //        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int intValue(String tplExecuteId, Map<String, Object> params) {
        return numberInt(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int intValue(TplExecuteId tplExecuteId, Map<String, Object> params) {
        return numberInt(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long longValue(String tplExecuteId, Map<String, Object> params) {
        return numberLong(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long longValue(TplExecuteId tplExecuteId, Map<String, Object> params) {
        return numberLong(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double doubleValue(String tplExecuteId, Map<String, Object> params) {
        return numberDouble(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double doubleValue(TplExecuteId tplExecuteId, Map<String, Object> params) {
        return numberDouble(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> N number(String tplExecuteId, Class<N> numberType, Map<String, Object> params) {
        return value(tplExecuteId, numberType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> N number(TplExecuteId tplExecuteId, Class<N> numberType, Map<String, Object> params) {
        return value(tplExecuteId, numberType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer numberInt(String tplExecuteId, Map<String, Object> params) {
        return number(tplExecuteId, Integer.class, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer numberInt(TplExecuteId tplExecuteId, Map<String, Object> params) {
        return number(tplExecuteId, Integer.class, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long numberLong(String tplExecuteId, Map<String, Object> params) {
        return number(tplExecuteId, Long.class, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long numberLong(TplExecuteId tplExecuteId, Map<String, Object> params) {
        return number(tplExecuteId, Long.class, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double numberDouble(String tplExecuteId, Map<String, Object> params) {
        return number(tplExecuteId, Double.class, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double numberDouble(TplExecuteId tplExecuteId, Map<String, Object> params) {
        return number(tplExecuteId, Double.class, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal numberBigDecimal(String tplExecuteId, Map<String, Object> params) {
        return number(tplExecuteId, BigDecimal.class, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal numberBigDecimal(TplExecuteId tplExecuteId, Map<String, Object> params) {
        return number(tplExecuteId, BigDecimal.class, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String string(String tplExecuteId, Map<String, Object> params) {
        return value(tplExecuteId, String.class, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String string(TplExecuteId tplExecuteId, Map<String, Object> params) {
        return value(tplExecuteId, String.class, params);
    }

    private Tuple4<String, TplExecuteConfig, ConditionParamsManager, PropertiesMappingManager> getQueryExecution(
            TplExecuteId tplExecuteId, Map<String, Object> params, Class<?>... resultTypes) {
        TplExecuteConfig config = configFactory.getConfig(tplExecuteId);
        Tuple3<String, ConditionParamsManager, PropertiesMappingManager> tuple3 = getExecution(tplExecuteId.getId(),
                config.getQuery(), params, resultTypes);
        logger.debug("tplExecuteId -> {} \nexecuteQuerySql -> {} \nqueryTemplate -> {}", tplExecuteId, tuple3.get0(),
                config.getQuery());
        return Tuples.of(tuple3.get0(), config, tuple3.get1(), tuple3.get2());
    }

    //    private Tuple3<String, TplExecuteConfig, ConditionParamsManager> getQueryExecution(String tplExecuteId,
    //            Map<String, Object> params, Class<?> resultType) {
    //        TplExecuteConfig config = configFactory.getConfig(tplExecuteId);
    //        Tuple2<String, ConditionParamsManager> tuple2 = getExecution(tplExecuteId, config.getQuery(), params,
    //                resultType);
    //        Constants.LOGGER.debug("tplExecuteId -> {} \nexecuteQuerySql -> {} \nqueryTemplate -> {}", tplExecuteId,
    //                tuple2.get0(), config.getQuery());
    //        return Tuples.of(tuple2.get0(), config, tuple2.get1());
    //    }

    /**
     * Gets the count execution.
     *
     * @param tplExecuteId the tpl execute id
     * @param params       the params
     * @param config       the config
     * @param resultType   the result type
     * @return the count execution
     */
    private Tuple2<String, ConditionParamsManager> getCountExecution(TplExecuteId tplExecuteId,
            Map<String, Object> params, TplExecuteConfig config) {
        String templateName = tplExecuteId.getId() + TplConfigFactory.COUNT_SUFFIX;
        Tuple3<String, ConditionParamsManager, PropertiesMappingManager> result = getExecution(templateName,
                config.getCount(), params, ArrayUtils.EMPTY_CLASS_ARRAY);
        logger.debug("tplExecuteId -> {}  \nexecuteCountSql -> {}  \ncountTemplate -> {}", tplExecuteId, result.get0(),
                config.getCount());
        return Tuples.of(result.get0(), result.get1());
    }

    //    private Tuple2<String, ConditionParamsManager> getCountExecution(String tplExecuteId, Map<String, Object> params,
    //            TplExecuteConfig config, Class<?> resultType) {
    //        Tuple2<String, ConditionParamsManager> result = getExecution(tplExecuteId + TplConfigFactory.COUNT_SUFFIX,
    //                config.getCount(), params, resultType);
    //        Constants.LOGGER.debug("tplExecuteId -> {}  \nexecuteCountSql -> {}  \ncountTemplate -> {}", tplExecuteId,
    //                result.get0(), config.getCount());
    //        return result;
    //    }

    //    private Tuple2<String, ConditionParamsManager> getExecution(TplExecuteId tplExecuteId, String sql,
    //            Map<String, Object> params, Class<?> resultType) {
    //        String templateName = tplExecuteId.getId() + TplConfigFactory.COUNT_SUFFIX;
    //        logger.debug("execute template name : {}", templateName);
    //        ConditionParamsManager manager = new ConditionParamsManager();
    //        Map<String, Object> root = new HashMap<>();
    //        root.putAll(params);
    //
    //        SqlDbTemplateProcessEnv<TemplateDirective, TemplateMethod> templateProcessEnv = createTemplateProcessEnv(
    //                manager, resultType);
    //        String result = templateEngine.process(templateName, sql, params, templateProcessEnv);
    //        return Tuples.of(result, manager);
    //    }

    /**
     * Gets the execution.
     *
     * @param templateName the template name
     * @param sql          the sql
     * @param params       the params
     * @param resultType   the result type
     * @return the execution
     */
    private Tuple3<String, ConditionParamsManager, PropertiesMappingManager> getExecution(String templateName,
            String sql, Map<String, Object> params, Class<?>... resultTypes) {
        logger.debug("execute template name : {}", templateName);
        ConditionParamsManager conditionParamsManager = new ConditionParamsManager();
        PropertiesMappingManager propertiesMappingManager = new PropertiesMappingManager();

        Map<String, Object> root = new HashMap<>();
        root.putAll(params);
        SqlDbTemplateProcessEnv<TemplateDirective, TemplateMethod> templateProcessEnv = createTemplateProcessEnv(
                conditionParamsManager, propertiesMappingManager, resultTypes);
        String result = templateEngine.process(templateName, sql, params, templateProcessEnv);
        return Tuples.of(result, conditionParamsManager, propertiesMappingManager);
    }

    /**
     * Creates the template process env.
     *
     * @param manager    the manager
     * @param resultType the result type
     * @return the sql db template process env
     */
    private SqlDbTemplateProcessEnv<TemplateDirective, TemplateMethod> createTemplateProcessEnv(
            ConditionParamsManager conditionParamsManager, PropertiesMappingManager propertiesMappingManager,
            Class<?>... resultTypes) {
        SqlDbTemplateProcessEnv<TemplateDirective, TemplateMethod> env = templateEngine.createTemplateProcessEnv();
        env.setConfigFactory(configFactory);
        env.setDialect(jdbc.getDialect());
        env.setConditionParamsManager(conditionParamsManager);
        env.setPropertiesMappingManager(propertiesMappingManager);
        env.setMappingFactory(mappingFactory);
        env.setResultTypes(resultTypes);
        return env;
    }

    /**
     * Find list.
     *
     * @param tplExecuteId the tpl execute id
     * @param params       the params
     * @param offset       the offset
     * @param limit        the limit
     * @return the tuple 5
     */
    private Tuple5<List<Map<String, Object>>, String, TplExecuteConfig, ConditionParamsManager,
            Map<String, Object>> findList(TplExecuteId tplExecuteId, Map<String, Object> params, int offset,
                    int limit) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager, PropertiesMappingManager> tuple4 = getQueryExecution(
                tplExecuteId, params, ArrayUtils.EMPTY_CLASS_ARRAY);
        List<Map<String, Object>> list = null;
        String sql = tuple4.get0();
        ConditionParamsManager manager = tuple4.get2();

        SqlPageQuery<Map<String, Object>> sqlPageQuery = sqlPageFactory.toPage(jdbc.getDialect(), sql, offset, limit,
                getEffectiveParamMap(params, manager));
        list = jdbc.query(sqlPageQuery.getSql(), sqlPageQuery.getParams());
        // 模板SQL不支持默认占位符 xxx = ?
        //        // 默认使用namedParameter
        //                if (manager.getParamNamed() == null || manager.getParamNamed()) {
        //            SqlPageQuery<Map<String, Object>> sqlPageQuery = sqlPageFactory.toPage(jdbc.getDialect(), sql, offset,
        //                    limit, getEffectiveParamMap(params, manager));
        //            list = jdbc.query(sqlPageQuery.getSql(), sqlPageQuery.getParams());
        //            //            list = jdbc.query(jdbc.getDialect().getParamNamedPaginationSql(sql, offset, limit),
        //            //                    jdbc.getDialect().getPaginationSqlParameter(getEffectiveParamMap(params, manager), offset, limit));
        //        } else {
        //            SqlPageQuery<Object[]> sqlPageQuery = sqlPageFactory.toPage(jdbc.getDialect(), sql, offset, limit,
        //                    getEffectiveParamArray(params, manager));
        //            list = jdbc.query(sqlPageQuery.getSql(), sqlPageQuery.getParams());
        //            //            list = jdbc.query(jdbc.getDialect().getPaginationSql(sql, offset, limit), jdbc.getDialect()
        //            //                    .getPaginationSqlParameter(getEffectiveParamArray(params, tuple3.get2()), offset, limit));
        //        }
        return Tuples.of(list, sql, tuple4.get1(), manager, params);
    }

    private <E> Tuple5<List<E>, String, TplExecuteConfig, ConditionParamsManager, Map<String, Object>> findList(
            TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params, int offset, int limit) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
                PropertiesMappingManager> tuple3 = getQueryExecution(tplExecuteId, params, entityType);
        List<E> list = null;
        String sql = tuple3.get0();
        ConditionParamsManager manager = tuple3.get2();

        SqlPageQuery<Map<String, Object>> sqlPageQuery = sqlPageFactory.toPage(jdbc.getDialect(), sql, offset, limit,
                getEffectiveParamMap(params, manager));
        list = jdbc.query(sqlPageQuery.getSql(), entityType, sqlPageQuery.getParams());
        // 模板SQL不支持默认占位符 xxx = ?
        //        // 默认使用namedParameter
        //        if (manager.getParamNamed() == null || manager.getParamNamed()) {
        //            SqlPageQuery<Map<String, Object>> sqlPageQuery = sqlPageFactory.toPage(jdbc.getDialect(), sql, offset,
        //                    limit, getEffectiveParamMap(params, manager));
        //            list = jdbc.query(sqlPageQuery.getSql(), entityType, sqlPageQuery.getParams());
        //            //            list = jdbc.query(jdbc.getDialect().getParamNamedPaginationSql(sql, offset, limit), entityType,
        //            //                    jdbc.getDialect().getPaginationSqlParameter(getEffectiveParamMap(params, manager), offset, limit));
        //        } else {
        //            SqlPageQuery<Object[]> sqlPageQuery = sqlPageFactory.toPage(jdbc.getDialect(), sql, offset, limit,
        //                    getEffectiveParamArray(params, manager));
        //            list = jdbc.query(sqlPageQuery.getSql(), entityType, sqlPageQuery.getParams());
        //            //            list = jdbc.query(jdbc.getDialect().getPaginationSql(sql, offset, limit), entityType, jdbc.getDialect()
        //            //                    .getPaginationSqlParameter(getEffectiveParamArray(params, manager), offset, limit));
        //        }
        return Tuples.of(list, sql, tuple3.get1(), manager, params);
    }

    private <E1,
            E2> Tuple5<List<Tuple2<E1, E2>>, String, TplExecuteConfig, ConditionParamsManager,
                    Map<String, Object>> findList(TplExecuteId tplExecuteId, Class<E1> entityType1,
                            Class<E2> entityType2, Tuple2<String, String> prefixes, Map<String, Object> params,
                            int offset, int limit) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
                PropertiesMappingManager> tuple3 = getQueryExecution(tplExecuteId, params, entityType1, entityType2);
        List<Tuple2<E1, E2>> list = null;
        String sql = tuple3.get0();
        ConditionParamsManager manager = tuple3.get2();
        SqlPageQuery<Map<String, Object>> sqlPageQuery = sqlPageFactory.toPage(jdbc.getDialect(), sql, offset, limit,
                getEffectiveParamMap(params, manager));
        if (prefixes == null) {
            PropertiesMappingManager propManager = tuple3.get3();
            list = jdbc.query(sqlPageQuery.getSql(), entityType1, entityType2,
                    Tuples.of(propManager.getValue(0).getAlias() + ".", propManager.getValue(1).getAlias() + "."),
                    sqlPageQuery.getParams());
        } else {
            list = jdbc.query(sqlPageQuery.getSql(), entityType1, entityType2, prefixes, sqlPageQuery.getParams());
        }
        return Tuples.of(list, sql, tuple3.get1(), manager, params);
    }

    private <E1, E2,
            E3> Tuple5<List<Tuple3<E1, E2, E3>>, String, TplExecuteConfig, ConditionParamsManager,
                    Map<String, Object>> findList(TplExecuteId tplExecuteId, Class<E1> entityType1,
                            Class<E2> entityType2, Class<E3> entityType3, Tuple3<String, String, String> prefixes,
                            Map<String, Object> params, int offset, int limit) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
                PropertiesMappingManager> tuple3 = getQueryExecution(tplExecuteId, params, entityType1, entityType2);
        List<Tuple3<E1, E2, E3>> list = null;
        String sql = tuple3.get0();
        ConditionParamsManager manager = tuple3.get2();
        SqlPageQuery<Map<String, Object>> sqlPageQuery = sqlPageFactory.toPage(jdbc.getDialect(), sql, offset, limit,
                getEffectiveParamMap(params, manager));
        if (prefixes == null) {
            PropertiesMappingManager propManager = tuple3.get3();
            list = jdbc
                    .query(sqlPageQuery.getSql(), entityType1, entityType2, entityType3,
                            Tuples.of(propManager.getValue(0).getAlias() + ".",
                                    propManager.getValue(1).getAlias() + ".", propManager.getValue(2).getAlias() + "."),
                            sqlPageQuery.getParams());
        } else {
            list = jdbc.query(sqlPageQuery.getSql(), entityType1, entityType2, entityType3, prefixes,
                    sqlPageQuery.getParams());
        }
        return Tuples.of(list, sql, tuple3.get1(), manager, params);
    }

    private <E1, E2, E3,
            E4> Tuple5<List<Tuple4<E1, E2, E3, E4>>, String, TplExecuteConfig, ConditionParamsManager,
                    Map<String, Object>> findList(TplExecuteId tplExecuteId, Class<E1> entityType1,
                            Class<E2> entityType2, Class<E3> entityType3, Class<E4> entityType4,
                            Tuple4<String, String, String, String> prefixes, Map<String, Object> params, int offset,
                            int limit) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
                PropertiesMappingManager> tuple3 = getQueryExecution(tplExecuteId, params, entityType1, entityType2);
        List<Tuple4<E1, E2, E3, E4>> list = null;
        String sql = tuple3.get0();
        ConditionParamsManager manager = tuple3.get2();
        SqlPageQuery<Map<String, Object>> sqlPageQuery = sqlPageFactory.toPage(jdbc.getDialect(), sql, offset, limit,
                getEffectiveParamMap(params, manager));
        if (prefixes == null) {
            PropertiesMappingManager propManager = tuple3.get3();
            list = jdbc.query(sqlPageQuery.getSql(), entityType1, entityType2, entityType3, entityType4,
                    Tuples.of(propManager.getValue(0).getAlias() + ".", propManager.getValue(1).getAlias() + ".",
                            propManager.getValue(2).getAlias() + ".", propManager.getValue(3).getAlias() + "."),
                    sqlPageQuery.getParams());
        } else {
            list = jdbc.query(sqlPageQuery.getSql(), entityType1, entityType2, entityType3, entityType4, prefixes,
                    sqlPageQuery.getParams());
        }
        return Tuples.of(list, sql, tuple3.get1(), manager, params);
    }

    private <E1, E2, E3, E4,
            E5> Tuple5<List<Tuple5<E1, E2, E3, E4, E5>>, String, TplExecuteConfig, ConditionParamsManager,
                    Map<String, Object>> findList(TplExecuteId tplExecuteId, Class<E1> entityType1,
                            Class<E2> entityType2, Class<E3> entityType3, Class<E4> entityType4, Class<E5> entityType5,
                            Tuple5<String, String, String, String, String> prefixes, Map<String, Object> params,
                            int offset, int limit) {
        Tuple4<String, TplExecuteConfig, ConditionParamsManager,
                PropertiesMappingManager> tuple3 = getQueryExecution(tplExecuteId, params, entityType1, entityType2);
        List<Tuple5<E1, E2, E3, E4, E5>> list = null;
        String sql = tuple3.get0();
        ConditionParamsManager manager = tuple3.get2();
        SqlPageQuery<Map<String, Object>> sqlPageQuery = sqlPageFactory.toPage(jdbc.getDialect(), sql, offset, limit,
                getEffectiveParamMap(params, manager));
        if (prefixes == null) {
            PropertiesMappingManager propManager = tuple3.get3();
            list = jdbc.query(sqlPageQuery.getSql(), entityType1, entityType2, entityType3, entityType4, entityType5,
                    Tuples.of(propManager.getValue(0).getAlias() + ".", propManager.getValue(1).getAlias() + ".",
                            propManager.getValue(2).getAlias() + ".", propManager.getValue(3).getAlias() + ".",
                            propManager.getValue(4).getAlias() + "."),
                    sqlPageQuery.getParams());
        } else {
            list = jdbc.query(sqlPageQuery.getSql(), entityType1, entityType2, entityType3, entityType4, entityType5,
                    prefixes, sqlPageQuery.getParams());
        }
        return Tuples.of(list, sql, tuple3.get1(), manager, params);
    }

    private <T extends Tuple> int count(TplExecuteId tplExecuteId, String sql, Map<String, Object> params,
            Map<String, Object> paramsWithLimit, ConditionParamsManager conditionParamsManager,
            TplExecuteConfig config) {
        String countSql = null;
        ConditionParamsManager manager = null;
        if (Lang.isEmpty(config.getCount())) {
            countSql = SqlUtils.convertSelectToCount(sql);
            manager = conditionParamsManager;
        } else {
            Tuple2<String, ConditionParamsManager> countTuple = getCountExecution(tplExecuteId, params, config);
            countSql = countTuple.get0();
            manager = countTuple.get1();
        }
        return jdbc.queryInt(countSql, getEffectiveParamMap(paramsWithLimit, manager));
    }

    private Map<String, Object> getEffectiveParamMap(Map<String, Object> params, ConditionParamsManager manager) {
        return params.entrySet().stream().filter(t -> {
            return !manager.filterParamName(t.getKey());
        }).collect(Collectors.toMap(e -> {
            return e.getKey();
        }, e -> {
            return transvert(e.getKey(), e.getValue(), manager);
        }));
    }

    private Object transvert(String name, Object value, ConditionParamsManager manager) {
        // ENHANCE TEST 调用前已经吧value == null的过滤了，不确定IgnorePolicy会否影响，后续测试
        //        if (value == null) {
        //            return value;
        //        }
        Param p = manager.getParam(name);
        if (p != null && Lang.isNotEmpty(p.getTransverter())) {
            Transverter transverter = transverterManager.getExist(p.getTransverter());
            return transverter.transvert(p.getTransverter(), value);
        }
        return value;
    }

    /**
     * 返回sqlPageFactory.
     *
     * @return sqlPageFactory
     */
    public SqlPageFactory getSqlPageFactory() {
        return sqlPageFactory;
    }
}
