package application;


/**
 * Global variables for the mouse
 * like XY position, pressed buttons, etc.
 */
public class GlobalsMouse {
	
	static boolean showMouseXY=false;

    // Coordinates in Screen-Space : pixels
    static double xx=0;
    static double yy=0;
    
    /**
     * Mouse :  xx=getX , yy=getY given by mouse input
     */

    // Coordinates in Math-Space : units
    static double x=0;
    static double y=0;

    // Strings XY

    static String strX = String.format("%.2f", x);
    static String strY = String.format("%.2f", y);

    static void updateStrXY()
    {
        strX = String.format("%.2f", x);
        strY = String.format("%.2f", y);
    }

    static void updateX()
    {
        x=GlobalsXY.ox+(xx-GlobalsXY.oxx)/GlobalsXY.xScale;

    }
    static void updateY()
    {
        y=GlobalsXY.oy+(-yy+GlobalsXY.oyy)/GlobalsXY.yScale;

    }

    static void updateXY()
    {
        updateX();
        updateY();
        updateStrXY();
    }



}
