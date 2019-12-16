package application;

import javafx.scene.paint.Color;

/** A point with color */
public class PointC extends Point {

    private Color color = GlobalsRadius.defaultColor;

    protected Color getColor() {
        return color;
    }

    private void setColor(Color _color) {
        color = _color;
    }

    protected void setInitialStateXY() {
        setXYinitial();
    }

    PointC() {
        super();
    }

    PointC(XY xy) {
        super(xy);
    }

    // With given color
    
    PointC(XY _xy, Color _color) {
        this(_xy);
        setColor(_color);
    }

}
