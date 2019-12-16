/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.StackPane;

/**
 *
 * @author mtg
 */
public class PanelRoot extends StackPane {

   private PanelPrimary panelPrimary;

   private void setup() {

      panelPrimary = new PanelPrimary();
      getChildren().add(panelPrimary);
   }

   
   private void openProgram()
   {
      String line1 = " R E A D Y   T O   S T A R T   W A V E S   FX1 \n\n ";
      String line2 = " Press the OK button to enter or CANCEL to exit now ";
      String str = line1 + line2;
      Alert openingProgram = new Alert(Alert.AlertType.CONFIRMATION, str);
      openingProgram.showAndWait().ifPresent(response -> {
         if (response == ButtonType.OK) {
            //continue
            System.out.println("\n\nOpening program ...\n\n");
         }
         if (response == ButtonType.CANCEL) {
            System.out.println("\n\nExiting the program ... \n\nGood bye !\n\n");
            System.exit(0);
         }
      });
   }
   
   PanelRoot() {
      super();
      setup();
      //openProgram();

   }

}
