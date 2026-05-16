package net.ittimeline.pandora.framework.operatelog.config;

import com.mzt.logapi.service.ILogRecordService;
import com.mzt.logapi.starter.annotation.EnableLogRecord;
import lombok.extern.slf4j.Slf4j;
import net.ittimeline.pandora.framework.operatelog.core.service.LogRecordServiceImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * 操作日志配置类
 *
 * @author tony 18601767221@163.com
 * @version 2026/5/16 21:23
 * @since Java 25
 */
@EnableLogRecord(tenant = "") // 貌似用不上 tenant 这玩意给个空好啦
@AutoConfiguration
@Slf4j
public class PandoraOperateLogConfiguration {
    @Bean
    @Primary
    public ILogRecordService iLogRecordServiceImpl() {
        return new LogRecordServiceImpl();
    }
}
