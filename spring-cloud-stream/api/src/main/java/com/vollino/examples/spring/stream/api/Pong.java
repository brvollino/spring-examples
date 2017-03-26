package com.vollino.examples.spring.stream.api;

import java.util.Objects;

public class Pong {
    private Integer id;

    public Pong(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pong ping1 = (Pong) o;
        return Objects.equals(id, ping1.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Pong{" +
                "id='" + id + '\'' +
                '}';
    }
}
