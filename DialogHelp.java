package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author mtg
 */
public class DialogHelp {
   
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

      line1 = " This program computes and represents graphically harmonic waves. ";

      line2 = " All the operations are done at real / virtual time simultaneously. \n";

      line3 = " For example, if you input the differential virtual time period to 0.004 s ";

      line4 = " that means that for each pulse of real-time refresh period = 0.002 s ";

      line5 = " the virtual-time advance an amount of time exactly 0.004 s . \n";

      line6 = " In that case the relation between real / virtual time is 1 : 2 , also ";

      line7 = " the effect is just that the virtual-time runs 2x faster respect to the real-time .";

      line8 = " This program shows you the equivalence between real-time and virtual-time . \n";

      line9 = " All the other commands for XY scales, relative origin XY, etc. are self-explanatory. ";

      line10 = " You can use your mouse wheel to change the scales, ";

      line11 = " and you can also drag-and-drop the relative origin XY at run-time. ";
            
      String nl = "\n";

      String str = line1 + nl + line2 + nl + line3 + nl + line4 + nl
              + line5 + nl + line6 + nl + line7 + nl + line8 + nl + line9 + nl + line10 + nl + line11;
      
      str=str+"\n\n[ Press the button CLOSE to close this window ]";
      
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
   
   DialogHelp()
   {
      updateDimensions();
   }

}
