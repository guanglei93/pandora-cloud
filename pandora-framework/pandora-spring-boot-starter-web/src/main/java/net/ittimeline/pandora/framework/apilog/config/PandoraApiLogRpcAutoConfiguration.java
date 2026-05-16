package net.ittimeline.pandora.framework.apilog.config;

import net.ittimeline.pandora.framework.common.biz.infra.logger.ApiAccessLogCommonApi;
import net.ittimeline.pandora.framework.common.biz.infra.logger.ApiErrorLogCommonApi;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * API 日志使用到 Feign 的配置项
 *
 * @author tony 18601767221@163.com
 * @version 2026/5/16 18:56
 * @since Java 25
 */
@AutoConfiguration
@EnableFeignClients(clients = {ApiAccessLogCommonApi.class, ApiErrorLogCommonApi.class}) // 主要是引入相关的 API 服务
public class PandoraApiLogRpcAutoConfiguration {
}
