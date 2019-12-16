package application;

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

public class PanelCTopLine2 extends FlowPane {

   void setupPadding() {
      int p = 2;
      setPadding(new Insets(p, p, p, p));
   }

   void setupGaps() {
      int hGap = 20, vGap = 1;
      setHgap(hGap);
      setVgap(vGap);
   }

   void setupAlignment() {
      setAlignment(Pos.CENTER);
   }

   void setupBackground() {
      setBackground(new Background(new BackgroundFill(GlobalsPanelColors.colorPanelCTopLine2Background,
              CornerRadii.EMPTY, Insets.EMPTY)));
   }

   void setupBorder() {
      setBorder(new Border(new BorderStroke(GlobalsPanelColors.colorPanelCTopLine2Border,
              BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
   }

   Label labelAnimState = new Label("ANIMATION STATE");

   Label labelGeneralInfo = new Label("GENERAL INFO");

   void labelGeneralInfoUpdate() {
      labelGeneralInfo.setText(GlobalsInfo.fileInfo);
   }

   void labelAnimStateUpdate() {
      labelAnimState.setText(GlobalsAnimState.strAnimState);
   }

   Label labelMouseXY = new Label(" ( X | Y ) = ");

   void updateLabelMouseXY() {
      String str
              = " ( X | Y ) =  ( " + GlobalsMouse.strX + " | " + GlobalsMouse.strY + " "
              + ") ";
      labelMouseXY.setText(str);
   }

   void updateElements() {
      labelGeneralInfoUpdate();
      labelAnimStateUpdate();
      updateLabelMouseXY();
   }

   private void addElements() {
      getChildren().addAll(labelAnimState, labelMouseXY, labelGeneralInfo);
   }

   private void setupDecoration() {

      setupPadding();
      setupGaps();
      setupAlignment();
      setupBackground();
      setupBorder();
   }

   PanelCTopLine2() {

      setupDecoration();
      addElements();

   }

}
