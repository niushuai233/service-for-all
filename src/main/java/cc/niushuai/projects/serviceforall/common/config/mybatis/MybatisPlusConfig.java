package cc.niushuai.projects.serviceforall.common.config.mybatis;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * mp配置
 *
 * @author niushuai
 * @date 2022/4/12 11:50
 */
@Slf4j
@Configuration
@MapperScan(basePackages = {"cc.niushuai.projects.**.mapper"})
public class MybatisPlusConfig {

    /**
     * 新的分页插件,一缓和二缓遵循mybatis的规则,需要设置 MybatisConfiguration#useDeprecatedExecutor = false 避免缓存出现问题(该属性会在旧插件移除后一同移除)
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(pageInnerInterceptor());
        return interceptor;
    }

    private PaginationInnerInterceptor pageInnerInterceptor() {
        PaginationInnerInterceptor interceptor = new PaginationInnerInterceptor(DbType.MYSQL);
        interceptor.setMaxLimit(-1L);
        log.info("Create Mybatis-Plus Page Interceptor Succeed.");
        return interceptor;
    }

    @Bean
    public MybatisInjector sqlInjector() {
        return new MybatisInjector();
    }
}
