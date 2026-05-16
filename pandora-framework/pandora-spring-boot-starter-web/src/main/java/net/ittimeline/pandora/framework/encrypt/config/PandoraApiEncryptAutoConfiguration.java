package net.ittimeline.pandora.framework.encrypt.config;

import lombok.extern.slf4j.Slf4j;
import net.ittimeline.pandora.framework.common.constants.WebFilterOrderConstants;
import net.ittimeline.pandora.framework.encrypt.core.filter.ApiEncryptFilter;
import net.ittimeline.pandora.framework.web.config.WebProperties;
import net.ittimeline.pandora.framework.web.core.handler.GlobalExceptionHandler;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import static net.ittimeline.pandora.framework.web.config.PandoraWebAutoConfiguration.createFilterBean;

/**
 * API 加密 AutoConfiguration
 *
 * @author tony 18601767221@163.com
 * @version 2026/5/16 19:57
 * @since Java 25
 */
@AutoConfiguration
@Slf4j
@EnableConfigurationProperties(ApiEncryptProperties.class)
@ConditionalOnProperty(prefix = "pandora.api-encrypt", name = "enable", havingValue = "true")
public class PandoraApiEncryptAutoConfiguration {
    @Bean
    public FilterRegistrationBean<ApiEncryptFilter> apiEncryptFilter(WebProperties webProperties,
                                                                     ApiEncryptProperties apiEncryptProperties,
                                                                     RequestMappingHandlerMapping requestMappingHandlerMapping,
                                                                     GlobalExceptionHandler globalExceptionHandler) {
        ApiEncryptFilter filter = new ApiEncryptFilter(webProperties, apiEncryptProperties,
                requestMappingHandlerMapping, globalExceptionHandler);
        return createFilterBean(filter, WebFilterOrderConstants.API_ENCRYPT_FILTER);

    }
}
