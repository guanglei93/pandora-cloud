package net.ittimeline.pandora.framework.jackson.config;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import lombok.extern.slf4j.Slf4j;
import net.ittimeline.pandora.framework.common.util.web.json.JsonUtils;
import net.ittimeline.pandora.framework.common.util.web.json.databind.NumberSerializer;
import net.ittimeline.pandora.framework.common.util.web.json.databind.TimestampLocalDateTimeDeserializer;
import net.ittimeline.pandora.framework.common.util.web.json.databind.TimestampLocalDateTimeSerializer;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author tony 18601767221@163.com
 * @version 2026/5/16 17:32
 * @since Java 25
 */
@AutoConfiguration(after = JacksonAutoConfiguration.class)
@Slf4j
public class PandoraJacksonAutoConfiguration {
    /**
         * 从 Builder 源头定制（关键：使用 *ByType，避免 handledType 要求）
         */
        @Bean
        public Jackson2ObjectMapperBuilderCustomizer ldtEpochMillisCustomizer() {
            return builder -> builder
                    // Long -> Number
                    .serializerByType(Long.class, NumberSerializer.INSTANCE)
                    .serializerByType(Long.TYPE, NumberSerializer.INSTANCE)
                    // LocalDate / LocalTime
                    .serializerByType(LocalDate.class, LocalDateSerializer.INSTANCE)
                    .deserializerByType(LocalDate.class, LocalDateDeserializer.INSTANCE)
                    .serializerByType(LocalTime.class, LocalTimeSerializer.INSTANCE)
                    .deserializerByType(LocalTime.class, LocalTimeDeserializer.INSTANCE)
                    // LocalDateTime < - > EpochMillis
                    .serializerByType(LocalDateTime.class, TimestampLocalDateTimeSerializer.INSTANCE)
                    .deserializerByType(LocalDateTime.class, TimestampLocalDateTimeDeserializer.INSTANCE);
        }

        /**
         * 以 Bean 形式暴露 Module（Boot 会自动注册到所有 ObjectMapper）
         */
        @Bean
        public Module timestampSupportModuleBean() {
            SimpleModule m = new SimpleModule("TimestampSupportModule");
            // Long -> Number，避免前端精度丢失
            m.addSerializer(Long.class, NumberSerializer.INSTANCE);
            m.addSerializer(Long.TYPE, NumberSerializer.INSTANCE);
            // LocalDate / LocalTime
            m.addSerializer(LocalDate.class, LocalDateSerializer.INSTANCE);
            m.addDeserializer(LocalDate.class, LocalDateDeserializer.INSTANCE);
            m.addSerializer(LocalTime.class, LocalTimeSerializer.INSTANCE);
            m.addDeserializer(LocalTime.class, LocalTimeDeserializer.INSTANCE);
            // LocalDateTime < - > EpochMillis
            m.addSerializer(LocalDateTime.class, TimestampLocalDateTimeSerializer.INSTANCE);
            m.addDeserializer(LocalDateTime.class, TimestampLocalDateTimeDeserializer.INSTANCE);
            return m;
        }

        /**
         * 初始化全局 JsonUtils，直接使用主 ObjectMapper
         */
        @Bean
        @SuppressWarnings("InstantiationOfUtilityClass")
        public JsonUtils jsonUtils(ObjectMapper objectMapper) {
            JsonUtils.init(objectMapper);
            log.debug("[init][初始化 JsonUtils 成功]");
            return new JsonUtils();
        }

}
