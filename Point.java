package application;

import javafx.geometry.Point2D;

/**
 *
 * @author mtg
 */
public class Point extends Point2D {

    protected XY xy = new XY(0, 0);
    protected XY xy0 = new XY(0, 0);

    void setXY(XY _xy) {
        xy = _xy;
    }

    private void setXY0(XY _xy0) {
        xy0 = _xy0;
    }

    protected void setXYinitial() {
        xy = xy0;
    }

    double gettX() {
        return xy.getX();
    }

    double gettY() {
        return xy.getY();
    }

    XY gettXY() {
        return xy;
    }

    XY gettXY0() {
        return xy0;
    }

    Point() {
        super(0, 0);
       
    }

    Point(XY _xy) {
        super(_xy.getX(), _xy.getY());
        setXY(_xy);
        setXY0(_xy);
    }

    

}
