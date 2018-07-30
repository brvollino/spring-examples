package com.vollino.examples.spring.data.converters;

import java.io.IOException;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.DBObject;
import com.vollino.examples.spring.data.model.Polygon;

@ReadingConverter
public class PolygonReadingConverter implements Converter<DBObject, Polygon> {

    @Override
    public Polygon convert(DBObject source) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            return objectMapper.readValue(objectMapper.writeValueAsString(source), Polygon.class);
        } catch (IOException e) {
            throw new ConversionFailedException(TypeDescriptor.forObject(source), TypeDescriptor.valueOf(Polygon.class), source, e);
        }
    }
}
