package application;

public class GlobalsScreen {

    // WINDOW DIMENSIONS
    static double scrW = 0;
    static double scrH = 0;
    static String strScrW = null, strScrH = null;
    static String strDimScreen = null;
    
    static void setScrDim(double w, double h)
    {
        setScrW(w);
        setScrH(h);
    }
    
    
    static void setScrW(double val) {
        scrW = val;
        strScrW = String.format("%.0f", val);
        strDimScreen = strScrW + " x " + strScrH;
    }

    static void setScrH(double val) {
        scrH = val;
        strScrH = String.format("%.0f", val);
        strDimScreen = strScrW + " x " + strScrH;
    }

    static double getScrW() {
        return scrW;
    }

    static double getScrH() {
        return scrH;
    }

    static String getStrScrDim() {
        return strDimScreen;
    }

    static String getStrScrW() {
        return strScrW;
    }

    static String getStrScrH() {
        return strScrH;
    }

    // GRAPHICS DIMENSIONS
    static double graphicsW = 0;
    static double graphicsH = 0;
    static String strGraphicsW = null, strGraphicsH = null;
    static String strDimGraphics = null;
    
    static void setGraphicsDim(double w, double h)
    {
        setGraphicsW(w);
        setGraphicsH(h);
    }

    static void setGraphicsW(double val) {
        graphicsW = val;
        strGraphicsW = String.format("%.0f", val);
        strDimGraphics = strGraphicsW + " x " + strGraphicsH;
    }

    static void setGraphicsH(double val) {
        graphicsH = val;
        strGraphicsH = String.format("%.0f", val);
        strDimGraphics = strGraphicsW + " x " + strGraphicsH;
    }

    static double getGraphicsW() {
        return graphicsW;
    }

    static double getGraphicsH() {
        return graphicsH;
    }

    static String getStrGraphicsDim() {
        return strDimGraphics;
    }

    static String getStrGraphicsW() {
        return strGraphicsW;
    }

    static String getStrGraphicsH() {
        return strGraphicsH;
    }

}
