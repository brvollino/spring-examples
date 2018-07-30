package com.vollino.examples.spring.data.repository;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.vollino.examples.spring.data.MongoDatabaseConfiguration;
import com.vollino.examples.spring.data.model.Polygon;

@Import(MongoDatabaseConfiguration.class)
@SpringBootApplication(scanBasePackageClasses = Polygon.class)
public class Application {

}
