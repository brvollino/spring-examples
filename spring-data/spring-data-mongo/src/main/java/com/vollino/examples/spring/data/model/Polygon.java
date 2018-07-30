package com.vollino.examples.spring.data.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Square.class, name = "SQUARE"),
        @JsonSubTypes.Type(value = Circle.class, name = "CIRCLE")
})
public class Polygon {

    @Id
    private String id;
    private PolygonType type;

    public Polygon() {
        //do nothing
        System.out.println("");
    }

    public Polygon(String id, PolygonType type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PolygonType getType() {
        return type;
    }

    public void setType(PolygonType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Polygon)) {
            return false;
        }
        Polygon polygon = (Polygon) o;
        return Objects.equals(id, polygon.id)
                && type == polygon.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }

    @Override
    public String toString() {
        return "Polygon{" +
                "id='" + id + '\'' +
                ", type=" + type +
                '}';
    }
}
