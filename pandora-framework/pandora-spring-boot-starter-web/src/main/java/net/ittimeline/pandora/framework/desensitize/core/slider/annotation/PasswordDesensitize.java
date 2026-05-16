package net.ittimeline.pandora.framework.desensitize.core.slider.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import net.ittimeline.pandora.framework.desensitize.core.base.annotation.DesensitizeBy;
import net.ittimeline.pandora.framework.desensitize.core.slider.handler.PasswordDesensitization;

import java.lang.annotation.*;

/**
 *
 * @author tony 18601767221@163.com
 * @version 2026/5/16 17:58
 * @since Java 25
 */
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside
@DesensitizeBy(handler = PasswordDesensitization.class)
public @interface PasswordDesensitize {
    /**
     * 前缀保留长度
     */
    int prefixKeep() default 0;

    /**
     * 后缀保留长度
     */
    int suffixKeep() default 0;

    /**
     * 替换规则，密码;
     * <p>
     * 比如：123456 脱敏之后为 ******
     */
    String replacer() default "*";

    /**
     * 是否禁用脱敏
     * <p>
     * 支持 Spring EL 表达式，如果返回 true 则跳过脱敏
     */
    String disable() default "";

}
