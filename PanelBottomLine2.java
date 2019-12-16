package application;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;

public class PanelBottomLine2 extends FlowPane {

    Button buttonShowXYlabels = new Button(" S H O W / H I D E  XY  L A B E L S ");

    void actionButtonShowXYlabels() {
        GlobalsGridXY.showXYlabels = !GlobalsGridXY.showXYlabels;
    }

    void buttonShowXYlabelsSetup() {
        buttonShowXYlabels.setOnAction((ActionEvent e) -> {
            actionButtonShowXYlabels();
        });
        String str=" Press to show or to hide the XY labels ";
        Tooltip buttonShowXYlabelsInfo = new Tooltip(str);
        Tooltip.install(buttonShowXYlabels, buttonShowXYlabelsInfo);
    }

    Button buttonShowAxes = new Button(" S H O W / H I D E  A X E S ");

    void actionButtonShowAxes() {
        GlobalsGridXY.showAxes = !GlobalsGridXY.showAxes;
    }

    void buttonShowAxesSetup() {
        buttonShowAxes.setOnAction((ActionEvent e) -> {
            actionButtonShowAxes();
        });
        String str=" Press to show or to hide the XY axes ";
        Tooltip buttonShowAxesInfo = new Tooltip(str);
        Tooltip.install(buttonShowAxes, buttonShowAxesInfo);
    }

    Button buttonShowGrid = new Button(" S H O W / H I D E  G R I D ");
    
    
    Button buttonSaveScreen=new Button(" S A V E   S C R E E N ");
    
    Button buttonSaveGraphic=new Button(" S A V E   G R A P H I C ");
    
    Button buttonSaveData=new Button(" S A V E   D A T A ");
    

    void actionButtonShowGrid() {
        GlobalsGridXY.showGridXY = !GlobalsGridXY.showGridXY;
    }

    void buttonShowGridSetup() {
        buttonShowGrid.setOnAction((ActionEvent e) -> {
            actionButtonShowGrid();
        });
        String str=" Press to show or to hide the Grid XY ";
        Tooltip buttonShowGridInfo = new Tooltip(str);
        Tooltip.install(buttonShowGrid, buttonShowGridInfo);
    }

    void addElements() {
        getChildren().addAll(buttonShowAxes, buttonShowGrid, 
                buttonShowXYlabels, buttonSaveScreen, buttonSaveGraphic, buttonSaveData);
    }

    void setupPadding() {
        int p = 1;
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
                GlobalsPanelColors.colorPanelBottomLine2Background,
                CornerRadii.EMPTY, Insets.EMPTY)));
    }

    void setupBorder() {
        setBorder(new Border(new BorderStroke(GlobalsPanelColors.colorPanelBottomLine2Border,
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    }

    void setupDecoration() {
        setupPadding();
        setupGaps();
        setupAlignment();
        setupBackground();
        setupBorder();
    }

    void setupButtons() {
        buttonShowAxesSetup();
        buttonShowGridSetup();
        buttonShowXYlabelsSetup();
    }

    private void setup() {
        setupButtons();
        addElements();
        setupDecoration();
    }

    PanelBottomLine2() {
        setup();
    }
}
