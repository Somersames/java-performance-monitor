package xyz.somersames.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

/**
 * @author szh
 * @create 2019-05-09 0:02
 **/
@Configuration
@ConditionalOnProperty(prefix = "spring.mongo" ,havingValue = "true",name = "enable")
public class MongoConfig {
}
