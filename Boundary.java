
package application;

import javafx.scene.canvas.GraphicsContext;

/**
 * @author mtg
 */
public class Boundary {
   private final double offsetXY = 3;
   private final double x0 = offsetXY;
   private final double y0 = offsetXY;
   private double x = x0;
   private double y = y0;
   // Corners
   private boolean topBorder = false;
   private boolean rightBorder = false;
   private boolean bottomBorder = false;
   private boolean leftBorder = false;
   // Velocity : ## pixels / s
   private final double v0 = 200;
   private double vx = v0;
   private double vy = 0;
   // step XY pro-cycle : dt
   private double dx = 0;
   private double dy = 0;
   // copy of global variables
   private double dt = GlobalsTimers.dt;
   private double w = GlobalsScreen.getGraphicsW();
   private double h = GlobalsScreen.getGraphicsH();
   private final double k = 200;
   private double L = (w + h) / k;
   // Limits XY
   private double xmax = w - L - x0;
   private double ymax = h - L - y0;

   // Boolean flags for boundaries
   private void setTop() {
      topBorder = true;
      bottomBorder = false;
      rightBorder = false;
      leftBorder = false;
   }

   private void setBottom() {
      topBorder = false;
      bottomBorder = true;
      rightBorder = false;
      leftBorder = false;
   }

   private void setRight() {
      topBorder = false;
      bottomBorder = false;
      rightBorder = true;
      leftBorder = false;
   }

   private void setLeft() {
      topBorder = false;
      bottomBorder = false;
      rightBorder = false;
      leftBorder = true;
   }

   private void setInitVXY() {
      vx = v0;
      vy = 0;
   }

   private void setInitXY() {
      setTop();
      x = x0;
      y = y0;
   }

   final void setInitState() {
      L = (w + h) / k;
      setInitVXY();
      setInitXY();
   }

   private void checkOutBorders() {
      if (rightBorder) {
         x = xmax;
      }
      if (bottomBorder) {
         y = ymax;
      }
      if (leftBorder) {
         x = x0;
      }
      if (topBorder) {
         y = y0;
      }
   }

   private void checkOutInitialXY() {
      if (GlobalsAnimState.isNotRunning && GlobalsTimers.t == 0) {
         x = x0;
         y = y0;
      }
   }

   private void computeXY() {
      dx = vx * dt;
      dy = vy * dt;
      x += dx;
      y += dy;
   }

   private void stepXY() {
      if (GlobalsAnimState.isRunning) {
         computeXY();
      }
   }

   private void updateXY() {
      dt = GlobalsTimers.getDt();
      w = GlobalsScreen.getGraphicsW();
      h = GlobalsScreen.getGraphicsH();
      L = (w + h) / k;
      xmax = w - L - x0;
      ymax = h - L - y0;
      stepXY();
      checkOutBorders();
      checkOutInitialXY();
   }

   // Calculating Boundaries for the Corners
   private void right() {
      if (x + dx > xmax && dx > 0) {
         vy = v0;
         vx = 0;
         x = xmax;
         setRight();
      }
   }

   private void left() {
      if (x + dx < x0 && dx < 0) {
         vy = -v0;
         vx = 0;
         x = x0;
         setLeft();
      }
   }

   private void bottom() {
      if (y + dy > ymax && dy > 0) {
         vx = -v0;
         vy = 0;
         y = ymax;
         setBottom();
      }
   }

   private void top() {
      if (y + dy < y0 && dy < 0) {
         vx = v0;
         vy = 0;
         y = y0;
         setTop();
      }
   }

   private void updateVXY() {
      if (GlobalsAnimState.isRunning) {
         right();
         bottom();
         left();
         top();
      }
   }

   protected final void updateStateTimeXY() {
      updateVXY();
      updateXY();
   }

   protected void draw(GraphicsContext gc) {
      gc.setLineWidth(1.8);
      gc.strokeRect(x, y, L, L);
   }

   Boundary() {
      setInitState();
      updateStateTimeXY();
   }

}
