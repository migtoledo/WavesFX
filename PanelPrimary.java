package application;

import java.util.logging.Logger;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.StackPane;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Tooltip;

/**
 * @author mtg
 */
public class PanelPrimary extends StackPane implements ChangeListener<Number> {

    private PanelMain panelMain;
    
    private ChangeListener<Number> scrSizeListener;

    private void updatePanelTopLine1() {
        panelMain.panelTop.line1.updateElements();
    }

    private void updatePanelTopLine2() {
        panelMain.panelTop.line2.updateElements();
    }

    private void updatePanelTopLine3() {
        panelMain.panelTop.line3.updateElements();
    }

    private void updatePanelCTopLine2() {
        panelMain.panelCenter.panelCTop.line2.updateElements();
    }

    private void updatePanelCTopLine1() {
        panelMain.panelCenter.panelCTop.line1.updateElements();
    }

    private void updatePanelCTopLines() {
        updatePanelCTopLine1();
        updatePanelCTopLine2();
    }

    private void updatePanelTopLines() {
        updatePanelTopLine1();
        updatePanelTopLine2();
        updatePanelTopLine3();
    }

    
    private void updateRadius()
    {
        GlobalsRadius.updateRadius();
    }

    private void updateGlobalsXY() {
        GlobalsXY.updateGlobalsXY();
        GlobalsMouse.updateXY();
        updateRadius();
        
    }

    private void updateGlobalsScreen() {
        GlobalsScreen.setScrDim(getWidth(), getHeight());
        double gW = panelMain.panelCenter.panelCGraphics.canvasGraphics.getWidth();
        double gH = panelMain.panelCenter.panelCGraphics.canvasGraphics.getHeight();
        GlobalsScreen.setGraphicsDim(gW, gH);
        // Updating Globals XY
        updateGlobalsXY();
    }

    private void updateGraphics() {
        panelMain.panelCenter.panelCGraphics.canvasGraphics.drawGraphics();
    }

    private void updateGraphicsStatic() {
        if (GlobalsAnimState.isNotRunning) {
            updateGraphics();
        }
    }

    private void updateGlobalsAnimState() {
        GlobalsAnimState.updateStrAnimState();
    }

    private void basicBackgroundTasks() {
        updateGlobalsScreen();
        GlobalsGraphicsColors.updateColors();
        updateGlobalsAnimState();
        updatePanelTopLines();
        updatePanelCTopLines();
        GlobalsDialog.updateShowingDialog();
    }

    private void updateBoundaryXY() {
        panelMain.panelCenter.panelCGraphics.canvasGraphics.armadillo.updateStateTimeXY();
    }

    private void timerBackgroundTasks() {
        basicBackgroundTasks();
        updateGraphicsStatic();
    }

    private void actionScreenSizeListener() {
        updateGlobalsScreen();
        updateBoundaryXY();

        basicBackgroundTasks();
        updateGraphics();
    }

    private void setScrSizeListener() {
        scrSizeListener = ((observable, oldValue, newValue) -> actionScreenSizeListener());
        widthProperty().addListener(scrSizeListener);
        heightProperty().addListener(scrSizeListener);
    }

    private void setup() {
        panelMain = new PanelMain();
        setScrSizeListener();
        updateGlobalsScreen();
        buttonQuitSetup();
        getChildren().add(panelMain);
    }

    private void actionButtonQuit() {

        panelMain.timerForeground.stop();
        timerBackground.stop();
        Logger LOGGER = Logger.getLogger(Main.class.getName());

        String blank = "\n\n";

        String _str0 = "-------------------------------------------------\n";

        String _str1 = "   ";

        String _str2 = "Exiting the program and returning to system ... ";

        String _str3 = "   ";

        String _str4 = "-------------------------------------------------\n";

        String msg = blank + _str0 + _str1 + "\n" + _str2 + "\n" + _str3 + "\n" + _str4;

        LOGGER.info(msg);
        Platform.exit();
    }

    private AnimationTimer timerBackground = new AnimationTimer() {
        @Override
        public void handle(long now) {
            timerBackgroundTasks();
        }
    };

    private void buttonQuitSetup() {
        panelMain.panelBottom.line1.buttonQuit.setOnAction((ActionEvent e) -> {
            actionButtonQuit();
        });
        Tooltip buttonQuitInfo = new Tooltip(" Press to exit the program ");
        Tooltip.install(panelMain.panelBottom.line1.buttonQuit, buttonQuitInfo);
    }

    PanelPrimary() {
        super();
        setup();
        timerBackground.start();
    }

    @Override
    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        throw new UnsupportedOperationException("Not supported yet.");
        // To change body of generated methods, choose Tools | Templates.
    }
}
