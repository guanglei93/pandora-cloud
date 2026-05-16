package net.ittimeline.pandora.framework.translate.config;

import com.fhs.trans.service.impl.TransService;
import net.ittimeline.pandora.framework.translate.core.TranslateUtils;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 *
 * 数据翻译自动配置
 * @author tony 18601767221@163.com
 * @version 2026/5/16 23:19
 * @since Java 25
 */
@AutoConfiguration
public class PandoraTranslateAutoConfiguration {
    @Bean
    @SuppressWarnings({"InstantiationOfUtilityClass", "SpringJavaInjectionPointsAutowiringInspection"})
    public TranslateUtils translateUtils(TransService transService) {
        TranslateUtils.init(transService);
        return new TranslateUtils();
    }
}
