package shapes.entities;

import shapes.color.Color;

public abstract class Shape {
    
    private Color color;

    public Color getColor() {

        return color;
    }

    public void setColor(Color color) {

        this.color = color;
    }

    public abstract Double area();
}
