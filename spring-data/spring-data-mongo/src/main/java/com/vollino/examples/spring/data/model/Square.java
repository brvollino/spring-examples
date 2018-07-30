package com.vollino.examples.spring.data.model;

import java.util.Objects;

public class Square extends Polygon {
    private Integer size;

    public Square() {
    }

    public Square(String id, PolygonType type, Integer size) {
        super(id, type);
        this.size = size;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Square)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Square square = (Square) o;
        return Objects.equals(size, square.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), size);
    }

    @Override
    public String toString() {
        return "Square{" +
                "size=" + size +
                '}';
    }
}
