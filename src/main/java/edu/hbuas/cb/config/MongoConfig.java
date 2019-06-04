package edu.hbuas.cb.config;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.convert.CustomConversions;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

/**
 * Description:
 * Author: Po
 * Date: 2019/4/30 18:22
 **/
@Configuration
public class MongoConfig {
    @Bean
    public MappingMongoConverter mappingMongoConverter(MongoDbFactory factory, MongoMappingContext context, BeanFactory beanFactory) {
        DbRefResolver dbRefResolver = new DefaultDbRefResolver(factory);
        MappingMongoConverter mappingMongoConverter = new MappingMongoConverter(dbRefResolver, context);
        try {
            mappingMongoConverter.setCustomConversions(beanFactory.getBean(CustomConversions.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        mappingMongoConverter.setTypeMapper(new DefaultMongoTypeMapper(null));

        return mappingMongoConverter;
    }
}