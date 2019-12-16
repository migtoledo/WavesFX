package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author mtg
 */
public class DialogAbout {
   
   Color colorPaper=Color.WHITE;
   double fontSize=12;
   Font font=new Font("SansSerif", fontSize);
   double textWidth=0.7;
   double rectWidth=5;

   double oxx = GlobalsXY.oxx;
   double oyy = GlobalsXY.oyy;
   double w = 2 * GlobalsXY.oxx;
   double h = 2 * GlobalsXY.oyy;
   double x0Line1 = oxx-200;
   double y0Line1 = 45;

   private void updateDimensions() {
      oxx = GlobalsXY.oxx;
      oyy = GlobalsXY.oyy;
      w = 2 * GlobalsXY.oxx;
      h = 2 * GlobalsXY.oyy;
      x0Line1 = oxx-200;
      y0Line1 = 45;
   }
   
   String info()
   {
      String line1, line2, line3, line4, line5, line6, line7, line8, line9, line10, line11;

      line1 = "W  A  V  E  S       F  X";

      line2 = "\n\nCopyright (c) 2019 M. Toledo González\n";
      
      //line2="";

      line3 = "\nProgrammed in Java";

      line4 = "\n\nLicense GPL v3";

      line5 = "\n\n\n";

      line6 = "ADVANCED METRIC 2D SIMULATOR FOR EVOLVING HARMONIC WAVES";

      line7 = "\n\n -  -  - \n";

      line8 = "\n\n";

      line9 = "This version is dedicated to my family \n ";

      line10 = " \n ";

      line11 = " \n  ";
            
      String nl = "";

      String str = line1 + nl + line2 + nl + line3 + nl + line4 + nl
              + line5 + nl + line6 + nl + line7 + nl + line8 + nl + line9 + nl + line10 + nl + line11;
      
      str=str+"\n[ Press the button CLOSE to close this window ]";
      
      return str;

   }
   
   void draw(GraphicsContext gc) {

      updateDimensions();
      
      gc.setGlobalAlpha(GlobalsGraphicsColors.opacityDialogs);

      gc.setFill(colorPaper);
      gc.setStroke(Color.BLACK);
      
      gc.setFont(font);
      //gc.clearRect(0, 0, w, h);
      gc.fillRect(0, 0, w, h);
      
      gc.setLineWidth(rectWidth);
      gc.strokeRect(10, 10, w-20, h-20);
      
      gc.setLineWidth(textWidth);
      gc.strokeText(info(), x0Line1, y0Line1);

   }
   
   DialogAbout()
   {
      updateDimensions();
   }

}
