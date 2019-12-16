package application;

import java.util.Date;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;

public class PanelTopLine1 extends FlowPane {

   Label labelScrDim;

   void labelScrDimSetup() {
      labelScrDim = new Label(null);
      labelScrDimUpdate();
   }

   void labelScrDimUpdate() {
      labelScrDim.setText(" [ WINDOW : " + GlobalsScreen.strDimScreen + " ] ");
   }

   Label labelGraphicsDim;

   void labelGraphicsDimSetup() {
      labelGraphicsDim = new Label(null);
      labelGraphicsDimUpdate();
   }

   void labelGraphicsDimUpdate() {
      labelGraphicsDim.setText(" [ GRAPHICS : " + GlobalsScreen.strDimGraphics + " ] ");
   }

   Label labelFPS;

   void labelFPSSetup() {
      labelFPS = new Label(null);

      labelFPSUpdate();
   }

   void setFonts() {
	   
	  int fontSize=12;
      labelScrDim.setFont(new Font("Verdana", fontSize));
      labelGraphicsDim.setFont(new Font("Verdana", fontSize));
      labelFPS.setFont(new Font("Verdana", fontSize));
      labelTitle.setFont(new Font("Verdana", fontSize));
      labelClock.setFont(new Font("Verdana", fontSize));

   }

   void labelFPSUpdate() {
      String text = " [ FPS : " + GlobalsTimers.getStrFPS() + " Hz ] ";
      labelFPS.setText(text);
   }

   void setupElements() {
      labelScrDimSetup();
      labelGraphicsDimSetup();
      labelFPSSetup();
   }

   // Label Title
   Label labelTitle = new Label("   W   A   V   E   S       F X   ");

   // Label Clock
   Label labelClock = new Label(new Date().toString());

   void labelClockUpdate() {
      String strLabelClock;
      strLabelClock = new Date().toString();
      strLabelClock = " [ " + strLabelClock + " ] ";
      labelClock.setText(strLabelClock);
   }

   void addElements() {
      getChildren().addAll(labelScrDim, labelGraphicsDim, labelFPS, labelTitle, labelClock);
   }

   void setupPadding() {
      int p = 8;
      setPadding(new Insets(p, p, p, p));
   }

   void setupGaps() {
      int hGap = 48;
      int vGap = 5;
      setHgap(hGap);
      setVgap(vGap);
   }

   void setupAlignment() {
      setAlignment(Pos.CENTER);
   }

   void setupBackground() {
      setBackground(new Background(new BackgroundFill(GlobalsPanelColors.colorPanelTopLine1Background,
              CornerRadii.EMPTY, Insets.EMPTY)));
   }

   void setupBorder() {
      setBorder(new Border(new BorderStroke(GlobalsPanelColors.colorPanelTopLine1Border,
              BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
   }

   void updateElements() {
      labelScrDimUpdate();
      labelGraphicsDimUpdate();
      labelFPSUpdate();
      labelClockUpdate();
   }

   void setupDecoration() {
      setupPadding();
      setupGaps();
      setupAlignment();
      setupBackground();
      setupBorder();
   }

   private void setup() {

      setupElements();
      addElements();
      setupDecoration();
      setFonts();
   }

   PanelTopLine1() {
      setup();
   }

}
