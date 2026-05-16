package net.ittimeline.pandora.framework.xss.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.util.Collections;
import java.util.List;

/**
 * Xss 配置属性
 * @author tony 18601767221@163.com
 * @version 2026/5/16 19:44
 * @since Java 25
 */
@ConfigurationProperties(prefix = "pandora.xss")
@Validated
@Data
public class XssProperties {

    /**
     * 是否开启，默认为 true
     */
    private boolean enable = true;
    /**
     * 需要排除的 URL，默认为空
     */
    private List<String> excludeUrls = Collections.emptyList();

}