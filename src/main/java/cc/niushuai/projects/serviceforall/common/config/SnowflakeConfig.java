package cc.niushuai.projects.serviceforall.common.config;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 配置雪花算法
 *
 * @author niushuai
 * @date 2022/4/11 13:15
 */
@Slf4j
@Configuration
public class SnowflakeConfig {

    @Resource
    private SnowflakeProperties snowflakeProperties;

    @Bean
    public Snowflake snowflake() {
        log.info("Create Snowflake With workerId: {}, dataCenterId: {}", snowflakeProperties.getWorkerId(), snowflakeProperties.getDataCenterId());
        return IdUtil.getSnowflake(snowflakeProperties.getWorkerId(), snowflakeProperties.getDataCenterId());
    }
}

@Data
@Component
@PropertySource(value = {"classpath:properties/snowflake.properties"}, ignoreResourceNotFound = true, encoding = "UTF-8")
@ConfigurationProperties(prefix = "snowflake")
class SnowflakeProperties {
    private Long workerId = 1L;
    private Long dataCenterId = 1L;
}
