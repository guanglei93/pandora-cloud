package net.ittimeline.pandora.framework.security.config;

import net.ittimeline.pandora.framework.common.biz.system.oauth2.OAuth2TokenCommonApi;
import net.ittimeline.pandora.framework.common.biz.system.permission.PermissionCommonApi;
import net.ittimeline.pandora.framework.security.core.rpc.LoginUserRequestInterceptor;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * d
 *
 * @author tony 18601767221@163.com
 * @version 2026/5/16 21:14
 * @since Java 25
 */
@AutoConfiguration
@EnableFeignClients(clients = {OAuth2TokenCommonApi.class, // 主要是引入相关的 API 服务
        PermissionCommonApi.class})
public class PandoraSecurityRpcAutoConfiguration {
    @Bean
    public LoginUserRequestInterceptor loginUserRequestInterceptor() {
        return new LoginUserRequestInterceptor();
    }

}
