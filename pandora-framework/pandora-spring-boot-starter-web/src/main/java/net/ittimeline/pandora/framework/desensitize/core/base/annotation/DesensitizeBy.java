package net.ittimeline.pandora.framework.desensitize.core.base.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import net.ittimeline.pandora.framework.desensitize.core.base.handler.DesensitizationHandler;
import net.ittimeline.pandora.framework.desensitize.core.base.serializer.StringDesensitizeSerializer;

import java.lang.annotation.*;

/**
 * 顶级脱敏注解，自定义注解需要使用此注解
 *
 * @author tony 18601767221@163.com
 * @version 2026/5/16 17:35
 * @since Java 25
 */
@Documented
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside // 此注解是其他所有 jackson 注解的元注解，打上了此注解的注解表明是 jackson 注解的一部分
@JsonSerialize(using = StringDesensitizeSerializer.class) // 指定序列化器
public @interface DesensitizeBy {
    /**
     * 脱敏处理器
     */
    @SuppressWarnings("rawtypes")
    Class<? extends DesensitizationHandler> handler();
}
