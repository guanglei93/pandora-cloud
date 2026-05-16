package net.ittimeline.pandora.framework.common.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import net.ittimeline.pandora.framework.common.core.ArrayValuable;

import java.lang.annotation.*;

/**
 * 自定义校验注解，用于标注字段/参数的值必须在指定枚举范围内。
 * @author tony 18601767221@163.com
 * @version 2026/5/16 14:26
 * @since Java 25
 */
@Target({
        ElementType.METHOD,
        ElementType.FIELD,
        ElementType.ANNOTATION_TYPE,
        ElementType.CONSTRUCTOR,
        ElementType.PARAMETER,
        ElementType.TYPE_USE
})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {EnumValueValidator.class, EnumValueCollectionValidator.class}
)
public @interface EnumValue {
    /**
     * @return 实现 ArrayValuable 接口的类
     */
    Class<? extends ArrayValuable<?>> value();

    String message() default "必须在指定范围 {value}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
