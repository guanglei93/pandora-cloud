package net.ittimeline.pandora.framework.desensitize.core.slider.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;

import java.lang.annotation.*;

/**
 * 车牌号
 *
 * @author tony 18601767221@163.com
 * @version 2026/5/16 17:51
 * @since Java 25
 */
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside

public @interface CarLicenseDesensitize {
    /**
     * 前缀保留长度
     */
    int prefixKeep() default 3;

    /**
     * 后缀保留长度
     */
    int suffixKeep() default 1;

    /**
     * 替换规则，车牌号;比如：粤A66666 脱敏之后为粤A6***6
     */
    String replacer() default "*";

    /**
     * 是否禁用脱敏
     * <p>
     * 支持 Spring EL 表达式，如果返回 true 则跳过脱敏
     */
    String disable() default "";
}
