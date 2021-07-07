package com.epam.diamondfund;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Gemstone", propOrder = {
        "name",
        "preciousness",
        "origin",
        "visualParameters",
        "value"
})

public class Gemstone {
    @XmlElement(name = "name", required = true)
    private String name;
    @XmlElement(required = true)
    private String preciousness;
    @XmlElement(required = true)
    private String origin;
    @XmlElement(name = "visualParameters", required = true)
    private VisualParameters visualParameters;
    private String value;

    public void setName(String name) {
        this.name = name;
    }

    public void setPreciousness(String preciousness) {
        this.preciousness = preciousness;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setVisualParameters(VisualParameters visualParameters) {
        this.visualParameters = visualParameters;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Gemstone() {
    }

    @Override
    public String toString() {
        return "Gemstone " + name + ", preciousness - " + preciousness +
                ", origin - " + origin + "." +
                "\nVisual Parameters:" + visualParameters +
                "Value - " + value + "\n";
    }
}
