package com.future.redisson.ioc;

import com.future.redisson.api.conf.RedissonConf;
import com.future.redisson.component.SynchronizedProcessor;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

import static com.future.redisson.api.generator.ProRedissonGenerator.generateRedissonClient;
import static com.future.redisson.api.generator.ProRedissonGenerator.generateSynchronizedProcessor;
import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;

/**
 * redisson configuration
 *
 * @author liuyunfei
 */
@SuppressWarnings({"AlibabaRemoveCommentedCode"})
@ConditionalOnBean(value = RedissonConf.class)
@AutoConfiguration
@Order(HIGHEST_PRECEDENCE)
public class ProRedissonConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProRedissonConfiguration.class);

    @Bean
    RedissonClient redissonClient(RedissonConf redissonConf) {
        LOGGER.info("RedissonClient redissonClient(RedissonConf redissonConf), redissonConf = {}", redissonConf);
        return generateRedissonClient(redissonConf);
    }

    @Bean
    SynchronizedProcessor synchronizedProcessor(RedissonClient redissonClient, RedissonConf redissonConf) {
        LOGGER.info("SynchronizedProcessor synchronizedProcessor(RedissonClient redissonClient,RedissonConf redissonConf), " +
                "redissonClient = {}, redissonConf = {}", redissonClient, redissonConf);
        return generateSynchronizedProcessor(redissonClient, redissonConf);
    }

}
