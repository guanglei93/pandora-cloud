package net.ittimeline.pandora.framework.apilog.config;

import jakarta.servlet.Filter;
import net.ittimeline.pandora.framework.apilog.core.filter.ApiAccessLogFilter;
import net.ittimeline.pandora.framework.apilog.core.interceptor.ApiAccessLogInterceptor;
import net.ittimeline.pandora.framework.common.biz.infra.logger.ApiAccessLogCommonApi;
import net.ittimeline.pandora.framework.common.constants.WebFilterOrderConstants;
import net.ittimeline.pandora.framework.web.config.PandoraWebAutoConfiguration;
import net.ittimeline.pandora.framework.web.config.WebProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 访问日志配置
 * @author tony 18601767221@163.com
 * @version 2026/5/16 18:35
 * @since Java 25
 */
@AutoConfiguration(after = PandoraWebAutoConfiguration.class)
public class PandoraApiLogAutoConfiguration implements WebMvcConfigurer {

    /**
     * 创建 ApiAccessLogFilter Bean，记录 API 请求日志
     */
    @Bean
    @ConditionalOnProperty(prefix = "pandora.access-log", value = "enable", matchIfMissing = true) // 允许使用 pandora.access-log.enable=false 禁用访问日志
    public FilterRegistrationBean<ApiAccessLogFilter> apiAccessLogFilter(WebProperties webProperties,
                                                                         @Value("${spring.application.name}") String applicationName,
                                                                         ApiAccessLogCommonApi apiAccessLogApi) {
        ApiAccessLogFilter filter = new ApiAccessLogFilter(webProperties, applicationName, apiAccessLogApi);
        return createFilterBean(filter, WebFilterOrderConstants.API_ACCESS_LOG_FILTER);
    }

    private static <T extends Filter> FilterRegistrationBean<T> createFilterBean(T filter, Integer order) {
        FilterRegistrationBean<T> bean = new FilterRegistrationBean<>(filter);
        bean.setOrder(order);
        return bean;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ApiAccessLogInterceptor());
    }

}
