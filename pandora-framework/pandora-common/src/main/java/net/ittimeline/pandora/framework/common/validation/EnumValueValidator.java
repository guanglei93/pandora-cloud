package net.ittimeline.pandora.framework.common.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import net.ittimeline.pandora.framework.common.core.ArrayValuable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 单值校验器
 * 校验单个值是否在枚举范围内
 * @author tony 18601767221@163.com
 * @version 2026/5/16 14:29
 * @since Java 25
 */
public class EnumValueValidator implements ConstraintValidator<EnumValue, Object> {

    private List<?> values;

    @Override
    public void initialize(EnumValue annotation) {
        ArrayValuable<?>[] values = annotation.value().getEnumConstants();
        if (values.length == 0) {
            this.values = Collections.emptyList();
        } else {
            this.values = Arrays.asList(values[0].array());
        }
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        // 为空时，默认不校验，即认为通过
        if (value == null) {
            return true;
        }
        // 校验通过
        if (values.contains(value)) {
            return true;
        }
        // 校验不通过，自定义提示语句
        context.disableDefaultConstraintViolation(); // 禁用默认的 message 的值
        context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate()
                .replaceAll("\\{value}", values.toString())).addConstraintViolation(); // 重新添加错误提示语句
        return false;
    }

}