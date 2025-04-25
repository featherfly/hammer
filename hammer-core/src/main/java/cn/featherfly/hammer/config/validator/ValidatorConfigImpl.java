
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2025-04-25 23:32:25
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.config.validator;

import cn.featherfly.hammer.config.ValidatorConfig;
import cn.featherfly.validation.Validator;
import cn.featherfly.validation.executable.ExecutableValidator;

/**
 * ValidatorConfigImpl.
 *
 * @author zhongj
 */
public class ValidatorConfigImpl implements ValidatorConfig {

    private Validator validator;

    private ExecutableValidator executableValidator;

    /**
     * @param validator
     */
    public ValidatorConfigImpl(Validator validator) {
        this(validator, validator.forExecutables());
    }

    /**
     * @param validator
     * @param executableValidator
     */
    public ValidatorConfigImpl(Validator validator, ExecutableValidator executableValidator) {
        super();
        this.validator = validator;
        this.executableValidator = executableValidator;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Validator getValidator() {
        return validator;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExecutableValidator getExecutableValidator() {
        return executableValidator;
    }

}
