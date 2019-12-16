package application;

import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;

public class PanelCBottomLine1 extends FlowPane {

    void setupPadding() {
        int p = 1;
        setPadding(new Insets(p, p, p, p));
    }

    void setupGaps() {
        int hGap = 10, vGap = 1;
        setHgap(hGap);
        setVgap(vGap);
    }

    void setupAlignment() {
        setAlignment(Pos.CENTER);
    }

    void setupBackground() {
        setBackground(new Background(new BackgroundFill(GlobalsPanelColors.colorPanelCBottomLine1Background,
                CornerRadii.EMPTY, Insets.EMPTY)));
    }

    void setupBorder() {
        setBorder(new Border(new BorderStroke(GlobalsPanelColors.colorPanelCBottomLine1Border,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    }

    void setupDecoration() {

        setupPadding();
        setupGaps();
        setupAlignment();
        setupBackground();
        setupBorder();

    }

    // Menu for f1(x)

    Label labelF1=new Label(" [ F1 ( x , t ) = A1 Sin ( k1 x - w1 t ) ] ");

    // Setup of text field dx1 resides on PanelCenter to gain access to
    // reloading the particles matrix of f1(x) after changing dx-resolution,
    // at run-time, without needing to reset the animation
    // It works incredible good!


    // DX1

    Label labelDX1=new Label(" [ DX1 : " + GlobalsFX1.dx1 + " u ] ");

    // Text field for x - resolution : dx1

    Label labelInputDx1 = new Label(" Enter DX1 ");

    // Text field input for DX1

    TextField textFieldDx1 = new TextField();


    // A1


    Label labelA1=new Label(" [ A1 : " + GlobalsFX1.A1 + " u ] ");

    // Text field for amplitude : A1

    Label labelInputA1 = new Label(" Enter A1 ");

    // Text field input for A1

    TextField textFieldA1 = new TextField();



    // K1


    Label labelK1=new Label(" [ K1 : " + GlobalsFX1.K1 + " /u ] ");

    // Text field for wave number : K1

    Label labelInputK1 = new Label(" Enter K1 ");

    // Text field input for K1

    TextField textFieldK1 = new TextField();


    // W1


    Label labelW1=new Label(" [ W1 : " + GlobalsFX1.W1 + " /s ] ");

    // Text field for angular frequency : W1

    Label labelInputW1 = new Label(" Enter W1 ");

    // Text field input for K1

    TextField textFieldW1 = new TextField();
















    void addElements()
    {
        getChildren().addAll(labelF1, labelDX1, labelInputDx1, textFieldDx1, labelA1,
                labelInputA1, textFieldA1, labelK1, labelInputK1, textFieldK1, labelW1, labelInputW1,
                textFieldW1);
    }

    void setup()
    {
        addElements();
        setupDecoration();
    }

    PanelCBottomLine1() {
        
        setup();
        

    }

}
