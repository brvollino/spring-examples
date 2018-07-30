package com.vollino.examples.spring.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vollino.examples.spring.data.model.Polygon;

/**
 * @author Bruno Vollino
 */
public interface PolygonRepository extends MongoRepository<Polygon, String> {
}
