package net.ittimeline.pandora.framework.redis.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

/**
 * Cache配置项
 *
 * @author tony 18601767221@163.com
 * @version 2026/5/16 16:54
 * @since Java 25
 */
@ConfigurationProperties("pandora.cache")
@Data
@Validated
public class PandoraCacheProperties {
    /**
     * {@link #redisScanBatchSize} 默认值
     */
    private static final Integer REDIS_SCAN_BATCH_SIZE_DEFAULT = 30;

    /**
     * redis scan 一次返回数量
     */
    private Integer redisScanBatchSize = REDIS_SCAN_BATCH_SIZE_DEFAULT;


}
