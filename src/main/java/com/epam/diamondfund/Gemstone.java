package com.epam.diamondfund;

public class Gemstone {
    private String name;
    private String preciousness;
    private String origin;
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
