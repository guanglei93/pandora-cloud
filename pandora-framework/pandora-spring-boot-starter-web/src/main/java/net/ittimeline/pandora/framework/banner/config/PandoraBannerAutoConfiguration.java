package net.ittimeline.pandora.framework.banner.config;

import net.ittimeline.pandora.framework.banner.core.BannerApplicationRunner;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * Banner 的自动配置类
 * @author tony 18601767221@163.com
 * @version 2026/5/16 17:27
 * @since Java 25
 */
@AutoConfiguration
public class PandoraBannerAutoConfiguration {
    @Bean
        public BannerApplicationRunner bannerApplicationRunner() {
            return new BannerApplicationRunner();
        }
}
