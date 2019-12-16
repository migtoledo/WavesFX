package application;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;

public final class PanelCGraphics extends Pane {

   CanvasGraphics canvasGraphics;

   // Particles System
   VirtualSystem particlesSystem = new VirtualSystem();

   void setupPadding() {
      int p = 5;
      setPadding(new Insets(p, p, p, p));
   }

   void changeBackgroundColor() {
      setBackground(new Background(
              new BackgroundFill(GlobalsGraphicsColors.colorBackground,
                      CornerRadii.EMPTY, Insets.EMPTY)));
   }

   void setupBackground() {

      setBackground(new Background(
              new BackgroundFill(GlobalsPanelColors.colorPanelCGraphicsBackground,
                      CornerRadii.EMPTY, Insets.EMPTY)));
      changeBackgroundColor();
   }

   void setupBorder() {
      setBorder(new Border(
              new BorderStroke(GlobalsPanelColors.colorPanelCGraphicsBorder,
                      BorderStrokeStyle.SOLID, CornerRadii.EMPTY,
                      BorderWidths.DEFAULT)));
   }

   private void setupDecoration() {
      setupPadding();
      setupBackground();
      setupBorder();
   }

   private void addCanvasGraphics() {
      getChildren().add(canvasGraphics);
   }

   void setupCanvasGraphics() {
      //virtualSystem = new ParticlesSystem();
      canvasGraphics = new CanvasGraphics(getWidth(), getHeight(), particlesSystem);
      setupCanvasDimensions();
      setupCanvasResizing();
      addCanvasGraphics();
   }

   void setupCanvasDimensions() {
      // Bind the width/height property to the wrapper Pane
      canvasGraphics.widthProperty().bind(widthProperty());
      canvasGraphics.heightProperty().bind(heightProperty());
   }

   private void drawGraphics() {
      canvasGraphics.drawGraphics();
   }

   void resizeAction() {
      drawGraphics();
   }

   void setupCanvasResizing() {
      // redraw when resized
      canvasGraphics.widthProperty().addListener(event -> resizeAction());
      canvasGraphics.heightProperty().addListener(event -> resizeAction());
   }

   PanelCGraphics() {
      super();
      setupCanvasGraphics();
      setupDecoration();
      // Draw graphics
      drawGraphics();
   }

   PanelCGraphics(VirtualSystem _particlesSystem) {
      super();
      particlesSystem = _particlesSystem;
      setupCanvasGraphics();
      setupDecoration();
      // Draw graphics
      drawGraphics();

   }
}
