package com.vollino.examples.spring.data;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoTypeMapper;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import com.google.common.collect.Lists;
import com.vollino.examples.spring.data.converters.PolygonReadingConverter;
import com.vollino.examples.spring.data.converters.PolygonWritingConverter;

/**
 * @author Bruno Vollino
 */
@Configuration
@EntityScan(basePackageClasses = MongoDatabaseConfiguration.class)
@ComponentScan(basePackageClasses = MongoDatabaseConfiguration.class)
public class MongoDatabaseConfiguration {

    @Bean
    public CustomConversions customConversions() {
        return new CustomConversions(Lists.newArrayList(new PolygonReadingConverter(), new PolygonWritingConverter()));
    }
}