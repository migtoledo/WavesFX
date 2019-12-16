package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;

public class PanelBottomLine1 extends FlowPane {

    Button buttonStart = new Button(" S T A R T ");

    Button buttonPause = new Button(" P A U S E ");

    Button buttonContinue = new Button(" C O N T I N U E ");

    Button buttonBackwards = new Button(" B A C K W A R D S ");

    Button buttonStop = new Button(" S T O P ");

    Button buttonDefaults = new Button(" D E F A U L T S ");

    Button buttonBackgroundColor = new Button(" B L A C K / W H I T E ");

    Button buttonHelp = new Button(" H E L P ");


    Button buttonAbout = new Button(" A B O U T ");



    Button buttonReset = new Button(" R E S E T ");
    
    Button buttonClose = new Button(" C L O S E ");
    

    Button buttonQuit = new Button(" Q U I T ");
    


    void setupPadding() {
        int p = 4;
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
        setBackground(new Background(new BackgroundFill(
                GlobalsPanelColors.colorPanelBottomLine1Background,
                CornerRadii.EMPTY, Insets.EMPTY)));
    }

    void setupBorder() {
        setBorder(new Border(
                new BorderStroke(GlobalsPanelColors.colorPanelBottomLine1Border,
                        BorderStrokeStyle.SOLID, CornerRadii.EMPTY,
                        BorderWidths.DEFAULT)));
    }

    void setupDecoration() {
        setupPadding();
        setupGaps();
        setupAlignment();
        setupBackground();
        setupBorder();
    }

    void addElements() {
        getChildren().addAll(buttonStart, buttonPause, buttonContinue,
                buttonBackwards, buttonStop, buttonDefaults, 
                buttonBackgroundColor, buttonHelp, buttonAbout, buttonReset,
                buttonClose, buttonQuit);
    }
    


    private void setup() {
        setupDecoration();

        addElements();
    }

    PanelBottomLine1() {
        setup();
    }

}
