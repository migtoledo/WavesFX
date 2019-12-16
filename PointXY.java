package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * @author mtg
 *
 * <p>
 * <p>
 *
 * Class for representing point-objects in XY coordinate system
 */
public class PointXY extends PointCR {

   protected void draw(GraphicsContext gc) {
      gc.setFill(getColor());
      gc.fillOval(xxyy().getX(), xxyy().getY(), Diameter(), Diameter());
      gc.strokeOval(xxyy().getX(), xxyy().getY(), Diameter(), Diameter());
   }

   // Chain constructors structure based on ancestor class "Point"
   // With default color, and default radius
   PointXY() {
      super();
   }

   PointXY(Radius R) {
      super(R);
   }

   PointXY(XY xy) {
      super(xy);
   }

   PointXY(XY xy, Radius R) {
      super(xy, R);

   }

   // With given color
   PointXY(XY xy, Color color) {
      super(xy, color);
   }

   // With given color, and given radius in pixels
   PointXY(XY xy, Color color, Radius R) {
      super(xy, color, R);
   }

   PointXY(XY xy, Radius R, Color color) {
      super(xy, color, R);
   }

}
