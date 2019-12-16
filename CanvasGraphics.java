package application;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.text.Font;

public final class CanvasGraphics extends Canvas {

   Axes axes = new Axes();
   GridXY grid = new GridXY(GlobalsScreen.getGraphicsW(), GlobalsScreen.getGraphicsH());
   Boundary armadillo = new Boundary();
   DialogHelp dialogHelp = new DialogHelp();
   DialogAbout dialogAbout = new DialogAbout();
   // Virtual System = Particles + Waves
   VirtualSystem virtualSystem;

   // Initial state for the point elements
   void setInitialStateOfAnimElements() {
      virtualSystem.setInitialState();
   }

   void showMouseXY(GraphicsContext gc) {
      double offsetX = 15;
      double offsetY = 25;
      double k1 = 5;
      double k2 = 2;
      String xy = " ( " + GlobalsMouse.strX + " | " + GlobalsMouse.strY + " ) ";
      double x0 = GlobalsMouse.xx;
      double y0 = GlobalsMouse.yy;
      double x = x0 + offsetX;
      double y = y0 + offsetY;

      if (x0 + xy.length() * k1 > GlobalsScreen.getGraphicsW()) {
         x = x - xy.length() * k1;
      }
      if (y0 + xy.length() * k2 > GlobalsScreen.getGraphicsH()) {
         y = y - xy.length() * k2;
      }
      gc.setLineWidth(0.7);
      gc.strokeText(xy, x, y);

   }

   // Auxiliary function for showing the mouse through animation elements
   void ShowForegroundMouseXY(GraphicsContext gc) {
      if (GlobalsMouse.showMouseXY) {
         showMouseXY(gc);
      }
   }

   void drawBackgroundGraphics(GraphicsContext gc) {
      if (GlobalsGridXY.showGridXY) {
         grid.draw(gc);
      }
      if (GlobalsGridXY.showAxes) {
         axes.draw(gc);
      }
      if (GlobalsMouse.showMouseXY) {
         showMouseXY(gc);
      }
      if (GlobalsDialog.showDialogHelp) {
         dialogHelp.draw(gc);
      }
      if (GlobalsDialog.showDialogAbout) {
         dialogAbout.draw(gc);
      }
   }

   void drawPointElements(GraphicsContext gc) {
      virtualSystem.draw(gc);
      ShowForegroundMouseXY(gc);
   }

   void drawAnimElements(GraphicsContext gc) {
      armadillo.draw(gc);
      if(GlobalsTimers.t==0 || GlobalsAnimState.isRunning)
       drawPointElements(gc);
   }

   GraphicsContext initGraphics2D() {
      return getGraphicsContext2D();
   }

   void clearGraphics(GraphicsContext gc) {

      if (GlobalsGraphicsColors.isBlackBackground) {
         gc.setFill(GlobalsGraphicsColors.colorBackground);
         gc.clearRect(0, 0, getWidth(), getHeight());
         gc.fillRect(0, 0, getWidth(), getHeight());
      } else {
         gc.clearRect(0, 0, getWidth(), getHeight());
      }
   }

   void drawGraphics() {
      GlobalsGraphicsColors.updateColors();
      GraphicsContext gc = initGraphics2D();
      clearGraphics(gc);
      gc.setFont(new Font("Courier new", 12));
      gc.setGlobalAlpha(GlobalsGraphicsColors.opacityGraphics);
      drawBackgroundGraphics(gc);

      if (!GlobalsDialog.showingDialog) {
         gc.setGlobalAlpha(GlobalsGraphicsColors.opacityGraphics);
         drawAnimElements(gc);
      }
   }

   static void actionMouseMoved(MouseEvent e) {
      GlobalsMouse.xx = e.getX();
      GlobalsMouse.yy = e.getY();
      GlobalsMouse.updateXY();
   }

   static void actionMouseClicked(MouseEvent e) {
      GlobalsMouse.showMouseXY = !GlobalsMouse.showMouseXY;
      actionMouseMoved(e);
   }

   CanvasGraphics() {
      super();
      setup();
   }

   void actionMouseDragged(MouseEvent e) {
      GlobalsXY.ox += -GlobalsXY.x(e.getX());
      GlobalsXY.oy += -GlobalsXY.y(e.getY());
      e.setDragDetect(false);
      e.consume();
      actionMouseMoved(e);
   }

   void actionScrollWheelMouse(ScrollEvent e) {
      if (e.getDeltaY() > 0) {
         GlobalsXY.xScale += 1;
         GlobalsXY.yScale += 1;
      }

      if (e.getDeltaY() < 0) {
         if (GlobalsXY.xScale > 1 && GlobalsXY.yScale > 1) {
            GlobalsXY.xScale += -1;
            GlobalsXY.yScale += -1;
         }
      }
   }

   void setup() {
      setOnMouseMoved((MouseEvent e) -> {
         actionMouseMoved(e);
      });

      setOnMouseClicked((MouseEvent e) -> {
         actionMouseClicked(e);
      });

      setOnMouseDragged((MouseEvent e) -> {
         actionMouseDragged(e);
      });

      setOnScroll((ScrollEvent e) -> {
         actionScrollWheelMouse(e);

      });

      drawGraphics();
   }

   CanvasGraphics(double width, double height) {
      super(width, height);
      setup();

   }

   CanvasGraphics(double width, double height, VirtualSystem _particlesSystem) {
      super(width, height);
      virtualSystem = _particlesSystem;
      setup();
   }

}
