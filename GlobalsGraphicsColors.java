
package application;

import javafx.scene.paint.Color;

/**
 * @author mtg
 */
public class GlobalsGraphicsColors {
   
   static double opacityGraphics=0.8;
   
   static double opacityDialogs=1;

    static boolean isBlackBackground=false;

    static void setDefaultBackground()
    {
        isBlackBackground=false;
    }
    
    // COLORS OF THE GRID
    
    static Color colorGrid = Color.CADETBLUE;
    //static Color colorVlines = Color.ORANGE;
    static Color colorLabels=Color.WHITE;
    
    static double gridLineWidth=2.5;
    static double labelsLineWidth=0.8;
    
    // COLORS OF THE CANVAS

    static Color colorBackground = Color.WHITE;

    static Color colorForeground = Color.BLACK;


    static void blackBackground()
    {
        colorBackground = Color.BLACK;

        colorForeground = Color.WHITE;
        
        colorLabels=Color.WHITE;

        
    }

    static void whiteBackground()
    {
        colorBackground = Color.WHITE;

        colorForeground = Color.BLACK;
        
        colorLabels=Color.BLACK;
    }

    static void updateColors(){

        if (isBlackBackground) {
            blackBackground();
        } else {
            whiteBackground();
        }
    }
}