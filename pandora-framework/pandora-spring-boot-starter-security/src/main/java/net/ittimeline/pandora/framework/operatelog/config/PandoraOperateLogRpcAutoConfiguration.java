package net.ittimeline.pandora.framework.operatelog.config;

import net.ittimeline.pandora.framework.common.biz.system.logger.OperateLogCommonApi;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * OperateLog 使用到 Feign 的配置项
 *
 * @author tony 18601767221@163.com
 * @version 2026/5/16 21:24
 * @since Java 25
 */
@AutoConfiguration
@EnableFeignClients(clients = {OperateLogCommonApi.class}) // 主要是引入相关的 API 服务
public class PandoraOperateLogRpcAutoConfiguration {
}
