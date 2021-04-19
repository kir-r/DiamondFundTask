package com.epam.diamondfund;

public class VisualParameters {
    private String color;
    private String transparency;
    private String cutting;

    public void setColor(String color) {
        this.color = color;
    }

    public void setTransparency(String transparency) {
        this.transparency = transparency;
    }

    public void setCutting(String cutting) {
        this.cutting = cutting;
    }

    public VisualParameters() {
    }

    public VisualParameters(String color, String transparency, String cutting) {
        this.color = color;
        this.transparency = transparency;
        this.cutting = cutting;
    }

    @Override
    public String toString() {
        return "\ncolor: " + color +
                "\ntransparency: " + transparency +
                "\ncutting: " + cutting + "\n";
    }
}
