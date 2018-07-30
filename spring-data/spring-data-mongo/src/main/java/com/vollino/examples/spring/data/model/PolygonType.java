package com.vollino.examples.spring.data.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum PolygonType {
    @XmlEnumValue("Square") SQUARE,
    @XmlEnumValue("Circle") CIRCLE
}


