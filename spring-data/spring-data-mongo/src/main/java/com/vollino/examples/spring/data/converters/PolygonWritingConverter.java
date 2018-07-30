package com.vollino.examples.spring.data.converters;

import java.io.IOException;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.vollino.examples.spring.data.model.Polygon;

@WritingConverter
public class PolygonWritingConverter implements Converter<Polygon, DBObject> {

    @Override
    public DBObject convert(Polygon source) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return BasicDBObject.parse(objectMapper.writeValueAsString(source));
        } catch (IOException e) {
            throw new ConversionFailedException(TypeDescriptor.forObject(source), TypeDescriptor.valueOf(DBObject.class), source, e);
        }
    }
}
