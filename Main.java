/**
 * W A V E S    F X 
 * <p>
 * Advanced 2D Simulator for Harmonic Waves
 * <p>
 * By M. Toledo González
 * <p>
 * This software product has been programmed in JAVA FX Standard Edition.
 * <p>
 * Copyright (c) 2019 Miguel Toledo González 
 * <p>
 * LICENSE GPL v3 - FREE SOFTWARE FOUNDATION -
 * <p>
 */
/**
 * VERSION INFO
 * ------------
 * 
 * Just the first version.
 * Dedicated to my family.
 *
 */

/// ------------------- ///
/// PROGRAM ENTRY POINT ///
/// ------------------- ///

package application;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.util.logging.Logger;

public class Main extends Application {

    private void exitMessage() {
        Logger LOGGER = Logger.getLogger(Main.class.getName());
        String blank = "\n\n";
        String _str0 = "-------------------------------------------------\n";
        String _str1 = "   ";
        String _str2 = "Exiting the program and returning to system ... ";
        String _str3 = "   ";
        String _str4 = "-------------------------------------------------\n";
        String msg = blank + _str0 + _str1 + "\n" + _str2 + "\n" + _str3 + "\n" + _str4;
        LOGGER.info(msg);
    }

    private void actionCloseWindow() {
        exitMessage();
        Platform.exit();
    }

    private void presentationMessage() {
        Logger LOGGER = Logger.getLogger(Main.class.getName());
        String blank = "\n\n";
        String _str0 = "-----------------------------------------------\n";
        String _str1 = " W A V E S     F X ";
        String _str2 = " A d v a n c e d    2 D    S i m u l a t o r  ";
        String _str3 = " Copyright (c) 2019 Miguel Toledo González ";
        String _str4 = "-----------------------------------------------\n";
        String msg = blank + _str0 + _str1 + "\n\n" + _str2 + "\n\n" + _str3 + "\n" + _str4;
        LOGGER.info(msg);
    }

    private String getTitle() {
        String str1 = " W A V E S    F X ";
        String str2 = " - - ";
        String str3 = " A d v a n c e d    2 D    S i m u l a t o r ";
        String str4 = " - - ";
        String strTitle = str1 + str2 + str3 + str4;
        return strTitle;
    }

    private void initUI(Stage stage, Scene scene) {

        Image icon = new Image(getClass().getResourceAsStream("icon.png"));
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        presentationMessage();
        stage.setScene(scene);
        stage.getIcons().add(icon);
        stage.setAlwaysOnTop(true);
        stage.centerOnScreen();
        stage.onCloseRequestProperty();
        stage.setOnCloseRequest(event -> actionCloseWindow());
        stage.setTitle(getTitle());
        stage.setMaximized(true);
        stage.show();
    }

    @Override
    public void start(Stage stage) {
        try {
            initUI(stage, new Scene(new PanelRoot(), 800, 600, false, SceneAntialiasing.BALANCED));
        } catch (Exception e) {
            e.getMessage();
            Platform.exit();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
