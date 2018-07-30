package com.vollino.examples.spring.data.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE,
        getterVisibility = JsonAutoDetect.Visibility.ANY, isGetterVisibility = JsonAutoDetect.Visibility.ANY)
public class Wrapper {
    private List<Polygon> polygons;

    public Wrapper() {
    }

    public Wrapper(List<Polygon> polygons) {
        this.polygons = polygons;
    }

    public List<Polygon> getPolygons() {
        return polygons;
    }

    public void setPolygons(List<Polygon> polygons) {
        this.polygons = polygons;
    }

    @Override
    public String toString() {
        return "Wrapper{" +
                "polygons=" + polygons +
                '}';
    }
}