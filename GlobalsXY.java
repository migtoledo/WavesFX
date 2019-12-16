package application;

/**
 * @author mtg
 * <p>
 * Class for elements of the coordinate system like :
 * <p>
 * xy-scales, relative origin ox, oy, and mouse xy position relative to
 * the mathematical metric space.
 * <p>
 * Transformations between screen-coordinates (pixels) and
 * math-coordinates (metric units ux, uy) need to be considered.
 */
public class GlobalsXY {

    // XY Scales

    static final double xScaleDefault = 60;
    static final double yScaleDefault = 60;

    static double xScale = xScaleDefault;
    static double yScale = yScaleDefault;

    static void setDefaultXYscales() {
        xScale = xScaleDefault;
        yScale = yScaleDefault;
    }

    // Strings for XY scales
    static String strXscale = String.format("%.2f", xScale);
    static String strYscale = String.format("%.2f", yScale);

    static void updateStrXYscales() {
        strXscale = String.format("%.2f", xScale);
        strYscale = String.format("%.2f", yScale);
    }

    // XY scales <---> Pixels distances

    // Pixels corresponding to the XY-unit
    static double uxyToPixels = Math.sqrt(Math.pow(xScale, 2) + Math.pow(yScale, 2));

    static String strUxyToPixels = String.format("%.3f", uxyToPixels);

    static void updateUxyToPixels() {
        uxyToPixels = Math.sqrt(Math.pow(xScale, 2) + Math.pow(yScale, 2))/Math.sqrt(2);
    }

    static double pixelToUnits = 1 / uxyToPixels;

    static String strPixelToUnits = String.format("%.3f", pixelToUnits);

    static void updatePixelToUnits() {
        updateUxyToPixels();
        pixelToUnits = 1 / uxyToPixels;
    }

    static void updateStrPixelUnits() {
        strUxyToPixels = String.format("%.3f", uxyToPixels);
        strPixelToUnits = String.format("%.3f", pixelToUnits);
    }

    static void updatePixelUnits() {
        updatePixelToUnits();
        updateStrPixelUnits();
    }

    // Origin XY

    static final double oxDefault = 0;
    static final double oyDefault = 0;

    // Origin XY in Math-Space (units), corresponds to the center of the screen
    static double ox = oxDefault;
    static double oy = oyDefault;

    static void setDefaultXYorigin() {
        ox = oxDefault;
        oy = oyDefault;
    }

    static void setDefaultsXY() {
        setDefaultXYorigin();
        setDefaultXYscales();
    }

    // Strings for origin XY math-space
    static String strOX = String.format("%.2f", ox);
    static String strOY = String.format("%.2f", oy);

    static void updateStrOXY() {
        strOX = String.format("%.2f", ox);
        strOY = String.format("%.2f", oy);
    }

    // Origin XY in Screen-Space (pixels), corresponds to the center of the screen
    static double oxx = GlobalsScreen.getGraphicsW() / 2;
    static double oyy = GlobalsScreen.getGraphicsH() / 2;

    // Strings for origin XY screen-space
    static String strOXX = String.format("%.2f", oxx);
    static String strOYY = String.format("%.2f", oyy);

    static void updateStrOXXYY() {
        strOXX = String.format("%.2f", oxx);
        strOYY = String.format("%.2f", oyy);
    }

    static void updateStringsXY() {
        updateStrXYscales();
        updateStrOXY();
        updateStrOXXYY();
    }

    // XY MIN - MAX coordinates
    static double xMax = oxx / xScale;
    static double xMin = -oxx / xScale;
    static double yMax = oyy / yScale;
    static double yMin = -oyy / yScale;

    // Strings for XY MIN - MAX variables
    static String strXmax = String.format("%.2f", xMax);
    static String strXmin = String.format("%.2f", xMin);
    static String strYmax = String.format("%.2f", yMax);
    static String strYmin = String.format("%.2f", yMin);

    static void updateXmax() {
        xMax = ox + oxx / xScale;
        strXmax = String.format("%.2f", xMax);
    }

    static void updateXmin() {
        xMin = ox - oxx / xScale;
        strXmin = String.format("%.2f", xMin);
    }

    static void updateYmax() {
        yMax = oy + oyy / yScale;
        strYmax = String.format("%.2f", yMax);
    }

    static void updateYmin() {
        yMin = oy - oyy / yScale;
        strYmin = String.format("%.2f", yMin);
    }

    static void updateXYMinMax() {
        updateXmax();
        updateXmin();
        updateYmax();
        updateYmin();
    }

    static void updateOriginXXYY() {
        oxx = GlobalsScreen.getGraphicsW() / 2;
        oyy = GlobalsScreen.getGraphicsH() / 2;
    }

    static void updateGlobalsXY() {
        updateOriginXXYY();
        updateXYMinMax();
        updatePixelUnits();
        updateStringsXY();
        if(GlobalsRadius.radius!=null) GlobalsRadius.updateRadius();
    }

    // Functions for coordinates Math (x, y) <---> Screen (xx, yy)

    // From screen-space (xx, yy) to math-space (x, y)

    static double xx(double x) {
        updateGlobalsXY();
        double val = 0;
        val = oxx + xScale * (x - ox);
        return val;
    }

    static double yy(double y) {
        updateGlobalsXY();
        double val = 0;
        val = oyy + yScale * (oy - y);
        return val;
    }

    // From math-space (x, y) to screen-space (xx, yy)

    static double x(double xx) {
        updateGlobalsXY();
        double val = 0;
        if (xScale > 0)
            val = ox + (1 / xScale) * (xx - oxx);
        return val;
    }

    static double y(double yy) {
        updateGlobalsXY();
        double val = 0;
        if (yScale > 0)
            val = oy + (1 / yScale) * (oyy - yy);
        return val;
    }

}
