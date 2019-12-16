package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Tooltip;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.util.Duration;
import javax.imageio.ImageIO;

public class PanelMain extends BorderPane {
    
    protected PanelTop panelTop;
    protected PanelCenter panelCenter;
    protected PanelBottom panelBottom;
    // Particles System
    protected final VirtualSystem particlesSystem = new VirtualSystem();
    
    private Duration d;
    private KeyFrame k;
    protected Timeline timerForeground;
    
    private void setupTimerAnimationForeground() {
        d = Duration.seconds(GlobalsTimers.getDt());
        k = new KeyFrame(d, (ActionEvent event) -> {
            timerAnimationForegroundTasks();
        });
        timerForeground = new Timeline(k);
        timerForeground.setCycleCount(Timeline.INDEFINITE);
    }
    
    private void setupPanels() {
        panelTop = new PanelTop();
        panelCenter = new PanelCenter(particlesSystem);
        panelBottom = new PanelBottom();
        buttonRestoreParticlesSetup();
        setTop(panelTop);
        setBottom(panelBottom);
        setCenter(panelCenter);
    }
    
    private void actionButtonStart() {
        if (GlobalsTimers.getDt() < 0) {
            GlobalsTimers.setDt(-GlobalsTimers.getDt());
        }
        GlobalsTimers.setT0();
        GlobalsTimers.setTR0();
        setInitStateBoundary();
        flagPause = false;
        isPaused = false;
        
        timerForeground.stop();
        timerForeground.playFromStart();
        
        GlobalsAnimState.isRunning = true;
        GlobalsAnimState.isStopped = false;
        
        hideDialogs();
        
    }
    
    String getStrDate() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = 1 + calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        
        String strDate = "_" + hour + "_" + minute + "_" + seconds + "_" + day + "_" + month + "_" + year;
        
        return strDate;
    }

    // Just the function f=f1(x)
    double f1(double x, double t) {
        double y = GlobalsFX1.A1 * Math.sin(GlobalsFX1.K1 * x - GlobalsFX1.W1 * t);
        return y;
    }

    // Just the function f=f2(x)
    double f2(double x, double t) {
        double y = GlobalsFX2.A2 * Math.cos(GlobalsFX2.K2 * x - GlobalsFX2.W2 * t);
        return y;
    }
    
    void actionButtonSaveData() {
        try {
            //System.exit(0);
            double t = GlobalsTimers.t;
            String strFileName = "dataXY_" + getStrDate() + ".txt";
            File file = new File(strFileName);
            BufferedWriter dataXY = null;
            String strData = null;
            String strLineXY = null;
            
            try {
                dataXY = new BufferedWriter(new FileWriter(file));
            } catch (IOException e) {
                // TODO Auto-generated catch block
            }
            
            strData = "# WAVES FX - Data XY File \n";
            strData = strData + "# DATA XY for t = " + t + " s \n\n";
            strData = strData + "#  x             F1(x,t)=" + GlobalsFX1.A1 + "" + "Sin("
                    + GlobalsFX1.K1 + "x-" + GlobalsFX1.W1 + "t)\n\n";
            
            try {
                dataXY.write(strData);
            } catch (IOException ex) {
                Logger.getLogger(PanelMain.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            for (double x = GlobalsXY.xMin; x < GlobalsXY.xMax; x += GlobalsFX1.dx1) {
                
                String line = " " + x + " " + f1(x, t) + " \n";
                
                try {
                    dataXY.write(line);
                } catch (IOException ex) {
                    Logger.getLogger(PanelMain.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
            String strF2 = "\n#  x             F2(x,t)=" + GlobalsFX2.A2 + "" + "Cos("
                    + GlobalsFX2.K2 + "x-" + GlobalsFX2.W2 + "t)\n\n";
            
            dataXY.write(strF2);
            
            for (double x = GlobalsXY.xMin; x < GlobalsXY.xMax; x += GlobalsFX2.dx2) {
                
                String line = " " + x + " " + f2(x, t) + " \n";
                
                try {
                    dataXY.write(line);
                } catch (IOException ex) {
                    Logger.getLogger(PanelMain.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
            try {
                //dataXY.write(strLineXY);
                dataXY.write("\n# End of Data XY # \n");
                dataXY.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                
            }
            String strInfo = " [ Data XY saved in local folder as text file : " + strFileName + " ] ";
            GlobalsInfo.fileInfo = strInfo;
        } catch (IOException ex) {
            Logger.getLogger(PanelMain.class.getName()).log(Level.SEVERE, null, ex);
            // TODO Auto-generated catch block
        }
    }
    
    void actionButtonSaveScreen() {
        
        String strFileName = "screenImage_" + getStrDate() + ".png";
        
        WritableImage image = this.snapshot(new SnapshotParameters(), null);

        // TODO: probably use a file chooser here
        File file = new File(strFileName);
        
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
        } catch (IOException e) {
            // TODO: handle exception here
        }
        
        GlobalsInfo.fileInfo = " [ Screen saved in local folder as image file : " + strFileName + " ] ";
    }
    
    void actionButtonSaveGraphic() {
        
        String strFileName = "graphicImage_" + getStrDate() + ".png";
        
        WritableImage image = this.panelCenter.panelCGraphics.canvasGraphics.snapshot(new SnapshotParameters(), null);

        // TODO: probably use a file chooser here
        File file = new File(strFileName);
        
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
        } catch (IOException e) {
            // TODO: handle exception here
        }
        
        GlobalsInfo.fileInfo = " [ Graphic saved in local folder as image file : " + strFileName + " ] ";
    }
    
    private void actionButtonBackgroundColor() {
        GlobalsGraphicsColors.isBlackBackground = !GlobalsGraphicsColors.isBlackBackground;
        GlobalsGraphicsColors.updateColors();
        hideDialogs();
        updateGraphics();
    }
    
    private void buttonSaveScreenSetup() {
        panelBottom.line2.buttonSaveScreen.setOnAction((ActionEvent e) -> {
            actionButtonSaveScreen();
        });
        Tooltip buttonSaveScreenInfo = new Tooltip(" Press to save screen ");
        Tooltip.install(panelBottom.line2.buttonSaveScreen, buttonSaveScreenInfo);
    }
    
    private void buttonSaveGraphicSetup() {
        panelBottom.line2.buttonSaveGraphic.setOnAction((ActionEvent e) -> {
            actionButtonSaveGraphic();
        });
        Tooltip buttonSaveGraphicInfo = new Tooltip(" Press to save graphic ");
        Tooltip.install(panelBottom.line2.buttonSaveGraphic, buttonSaveGraphicInfo);
    }
    
    private void buttonBackgroundColorSetup() {
        panelBottom.line1.buttonBackgroundColor.setOnAction((ActionEvent e) -> {
            actionButtonBackgroundColor();
        });
        Tooltip buttonBackgroundColorInfo = new Tooltip(" Press to change the background color ");
        Tooltip.install(panelBottom.line1.buttonBackgroundColor, buttonBackgroundColorInfo);
    }
    
    private boolean flagPause = false;
    
    private boolean isPaused = false;
    
    private void actionButtonPause() {
        isPaused = true;
        GlobalsAnimState.isStopped = false;
        if (!flagPause) {
            timerForeground.stop();
            GlobalsAnimState.isPaused = true;
        } else {
            timerForeground.play();
            GlobalsAnimState.isPaused = false;
        }
        flagPause = !flagPause;
        hideDialogs();
    }
    
    private void actionButtonContinue() {
        flagPause = false;
        isPaused = false;
        timerForeground.play();
        GlobalsAnimState.isStopped = false;
        GlobalsAnimState.isRunning = true;
        GlobalsAnimState.isNotRunning = false;
        GlobalsAnimState.isPaused = false;
        hideDialogs();
    }
    
    private void actionButtonBackwards() {
        GlobalsTimers.setDt(-GlobalsTimers.getDt());
        isPaused = false;
        flagPause = false;
        timerForeground.play();
        GlobalsAnimState.isRunning = true;
        GlobalsAnimState.isNotRunning = false;
        GlobalsAnimState.isPaused = false;
        GlobalsAnimState.isStopped = false;
        hideDialogs();
    }
    
    private void buttonBackwardsSetup() {
        panelBottom.line1.buttonBackwards.setOnAction((ActionEvent e) -> {
            actionButtonBackwards();
        });
        Tooltip buttonBackwardsInfo = new Tooltip(" Press to change the animation's time" + " signature +/- ");
        Tooltip.install(panelBottom.line1.buttonBackwards, buttonBackwardsInfo);
    }
    
    private void synchronizeDt() {
        GlobalsTimers.setDt(GlobalsTimers.getDtReal());
        panelTop.line2.textFieldDt.clear();
    }
    
    private void actionButtonDefaults() {
        synchronizeDt();
        GlobalsXY.setDefaultsXY();
        GlobalsGridXY.setDefaults();
        GlobalsGraphicsColors.setDefaultBackground();
        setInitStateAnimation();
        hideDialogs();
    }

    // Button restore particles setup
    private void actionButtonRestoreParticles() {
        
        GlobalsXY.setDefaultsXY(); // ok

        synchronizeDt();
        
        panelCenter.panelCGraphics.canvasGraphics.setInitialStateOfAnimElements();
        hideDialogs();
        
    }
    
    void actionButtonClose() {
        hideDialogs();
    }
    
    void buttonCloseSetup() {
        Node node = panelBottom.line1.buttonClose;
        panelBottom.line1.buttonClose.setOnAction((ActionEvent e) -> {
            actionButtonClose();
        });
        String str = " Press to close auxiliary windows ";
        Tooltip buttonCloseInfo = new Tooltip(str);
        Tooltip.install(node, buttonCloseInfo);
    }
    
    private void buttonRestoreParticlesSetup() {
        Node node = panelCenter.panelCTop.line1.buttonRestoreParticles;
        panelCenter.panelCTop.line1.buttonRestoreParticles.setOnAction((ActionEvent e) -> {
            actionButtonRestoreParticles();
        });
        String str = " Restore particle parameters to defaults ";
        Tooltip buttonRestoreParticlesInfo = new Tooltip(str);
        Tooltip.install(node, buttonRestoreParticlesInfo);
    }
    
    private void actionButtonHelp() {
        GlobalsDialog.showDialogHelp = !GlobalsDialog.showDialogHelp;
        GlobalsDialog.showDialogAbout = false;
    }
    
    private void actionButtonAbout() {
        GlobalsDialog.showDialogAbout = !GlobalsDialog.showDialogAbout;
        GlobalsDialog.showDialogHelp = false;
    }
    
    private void buttonHelpSetup() {
        panelBottom.line1.buttonHelp.setOnAction((ActionEvent e) -> {
            actionButtonHelp();
        });
        Tooltip buttonHelpInfo = new Tooltip(" Press to show help");
        Tooltip.install(panelBottom.line1.buttonHelp, buttonHelpInfo);
    }
    
    private void buttonAboutSetup() {
        panelBottom.line1.buttonAbout.setOnAction((ActionEvent e) -> {
            actionButtonAbout();
        });
        Tooltip buttonAboutInfo = new Tooltip(" Press to show about info");
        Tooltip.install(panelBottom.line1.buttonAbout, buttonAboutInfo);
    }
    
    private void hideDialogs() {
        GlobalsDialog.showDialogHelp = false;
        GlobalsDialog.showDialogAbout = false;
    }
    
    private void actionButtonReset() {
        actionButtonStop();
        actionButtonDefaults();
        hideDialogs();
    }
    
    private void buttonDefaultsSetup() {
        panelBottom.line1.buttonDefaults.setOnAction((ActionEvent e) -> {
            actionButtonDefaults();
        });
        Tooltip buttonDefaultsInfo = new Tooltip(" Press to set up defaults");
        Tooltip.install(panelBottom.line1.buttonDefaults, buttonDefaultsInfo);
        hideDialogs();
    }
    
    private void buttonSaveDataSetup() {
        panelBottom.line2.buttonSaveData.setOnAction((ActionEvent e) -> {
            actionButtonSaveData();
        });
        
    }
    
    private void buttonResetSetup() {
        panelBottom.line1.buttonReset.setOnAction((ActionEvent e) -> {
            actionButtonReset();
        });
        Tooltip buttonResetInfo = new Tooltip(" Press to reset the animation ");
        Tooltip.install(panelBottom.line1.buttonReset, buttonResetInfo);
        hideDialogs();
    }
    
    private void setInitStateAnimation() {
        setInitStateBoundary();
        particlesSystem.setInitialState();
        hideDialogs();
    }
    
    private void actionButtonStop() {
        
        if (GlobalsTimers.getDt() < 0) {
            GlobalsTimers.setDt(-GlobalsTimers.getDt());
        }
        GlobalsTimers.setT0();
        GlobalsTimers.setTR0();
        setInitStateAnimation();
        flagPause = false;
        timerForeground.stop();
        
        GlobalsAnimState.isRunning = false;
        GlobalsAnimState.isNotRunning = true;
        GlobalsAnimState.isPaused = false;
        GlobalsAnimState.isStopped = true;
        
        synchronizeDt();
        GlobalsXY.setDefaultsXY();
        hideDialogs();
        
    }
    
    private void updateGraphics() {
        panelCenter.panelCGraphics.canvasGraphics.drawGraphics();
    }
    
    private void updateAnimation() {
        updateAnimationVariables();
        updateGraphics();
    }
    
    private void timerAnimationForegroundTasks() {
        updateAnimation();
    }
    
    private void setInitStateBoundary() {
        panelCenter.panelCGraphics.canvasGraphics.armadillo.setInitState();
        panelCenter.panelCGraphics.canvasGraphics.drawGraphics();
    }
    
    private void updateBoundaryStateTimeXY() {
        panelCenter.panelCGraphics.canvasGraphics.armadillo.updateStateTimeXY();
    }
    
    private void updateAnimationVariables() {
        GlobalsTimers.updateAnimationTime();
        GlobalsTimers.updateRealTime();
        updateBoundaryStateTimeXY();
    }
    
    private void buttonStartSetup() {
        panelBottom.line1.buttonStart.setOnAction((ActionEvent e) -> {
            actionButtonStart();
        });
    }
    
    private void buttonPauseSetup() {
        panelBottom.line1.buttonPause.setOnAction((ActionEvent e) -> {
            actionButtonPause();
        });
    }
    
    private void buttonContinueSetup() {
        panelBottom.line1.buttonContinue.setOnAction((ActionEvent e) -> {
            actionButtonContinue();
        });
    }
    
    private void buttonStopSetup() {
        panelBottom.line1.buttonStop.setOnAction((ActionEvent e) -> {
            actionButtonStop();
        });
    }
    
    private void setupPadding() {
        int p = 2;
        setPadding(new Insets(p, p, p, p));
    }
    
    private void setupBackground() {
        setBackground(new Background(
                new BackgroundFill(GlobalsPanelColors.colorPanelMainBackground, CornerRadii.EMPTY, Insets.EMPTY)));
    }
    
    private void setupDecoration() {
        setupPadding();
        setupBackground();
    }
    
    private void setupButtons() {
        buttonStartSetup();
        buttonPauseSetup();
        buttonContinueSetup();
        buttonBackwardsSetup();
        buttonRestoreParticlesSetup();
        buttonDefaultsSetup();
        buttonBackgroundColorSetup();
        buttonResetSetup();
        buttonStopSetup();
        buttonHelpSetup();
        buttonAboutSetup();
        buttonCloseSetup();
        buttonSaveScreenSetup();
        buttonSaveGraphicSetup();
        buttonSaveDataSetup();
    }
    
    PanelMain() {
        super();
        setupPanels();
        setupButtons();
        setupDecoration();
        setupTimerAnimationForeground();
    }
}
