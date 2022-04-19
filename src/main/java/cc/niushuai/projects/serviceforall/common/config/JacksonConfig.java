package cc.niushuai.projects.serviceforall.common.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * 配置JSON序列化方式
 *
 * @author niushuai
 * @date 2022/4/1 10:38
 */
@Configuration
public class JacksonConfig {

    @Bean
    public Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder() {

        return Jackson2ObjectMapperBuilder.json()
                // bean为null时不抛异常
                .failOnEmptyBeans(false)
                // 未知属性时不抛异常
                .failOnUnknownProperties(false)
                // 时区与pattern
                .timeZone(TimeZone.getTimeZone("GMT+8"))
                .dateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"))
                // ALWAYS 默认策略，任何情况都执行序列化
                // NON_NULL 属性为 NULL 不序列化
                // NON_EMPTY  null、集合数组等没有内容、空字符串等，都不会被序列化
                // NON_DEFAULT  如果字段是默认值，就不会被序列化
                // NON_ABSENT  null的不会序列化，但如果类型是AtomicReference，依然会被序列化
                .serializationInclusion(JsonInclude.Include.ALWAYS)
                // 序列化时的排序按照字母属性
                //.featuresToEnable(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY);
                // 禁止时间序列化为时间戳
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }
}
