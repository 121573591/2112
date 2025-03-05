/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  jakarta.validation.ConstraintViolation
 *  jakarta.validation.Validation
 *  jakarta.validation.Validator
 *  jakarta.validation.ValidatorFactory
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Set
 */
package cn.hutool.extra.validation;

import cn.hutool.extra.validation.BeanValidationResult;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.Set;

public class ValidationUtil {
    private static final Validator validator;

    public static Validator getValidator() {
        return validator;
    }

    public static <T> Set<ConstraintViolation<T>> validate(T bean, Class<?> ... groups) {
        return validator.validate(bean, groups);
    }

    public static <T> Set<ConstraintViolation<T>> validateProperty(T bean, String propertyName, Class<?> ... groups) {
        return validator.validateProperty(bean, propertyName, groups);
    }

    public static <T> BeanValidationResult warpValidate(T bean, Class<?> ... groups) {
        return ValidationUtil.warpBeanValidationResult(ValidationUtil.validate(bean, groups));
    }

    public static <T> BeanValidationResult warpValidateProperty(T bean, String propertyName, Class<?> ... groups) {
        return ValidationUtil.warpBeanValidationResult(ValidationUtil.validateProperty(bean, propertyName, groups));
    }

    private static <T> BeanValidationResult warpBeanValidationResult(Set<ConstraintViolation<T>> constraintViolations) {
        BeanValidationResult result = new BeanValidationResult(constraintViolations.isEmpty());
        for (ConstraintViolation constraintViolation : constraintViolations) {
            BeanValidationResult.ErrorMessage errorMessage = new BeanValidationResult.ErrorMessage();
            errorMessage.setPropertyName(constraintViolation.getPropertyPath().toString());
            errorMessage.setMessage(constraintViolation.getMessage());
            errorMessage.setValue(constraintViolation.getInvalidValue());
            result.addErrorMessage(errorMessage);
        }
        return result;
    }

    static {
        try (ValidatorFactory factory2 = Validation.buildDefaultValidatorFactory();){
            validator = factory2.getValidator();
        }
    }
}

