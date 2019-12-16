package application;

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

public class PanelCBottomLine2 extends FlowPane {

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
        setBackground(new Background(new BackgroundFill(GlobalsPanelColors.colorPanelCBottomLine2Background,
                CornerRadii.EMPTY, Insets.EMPTY)));
    }

    void setupBorder() {
        setBorder(new Border(new BorderStroke(GlobalsPanelColors.colorPanelCBottomLine2Border,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    }

    void setupDecoration() {

        setupPadding();
        setupGaps();
        setupAlignment();
        setupBackground();
        setupBorder();
    }

    
 // Menu for f2(x)

    Label labelF2=new Label(" [ F2 ( x , t ) = A2 Cos ( k2 x - w2 t ) ] ");

    // Setup of text field dx2 resides on PanelCenter to gain access to
    // reloading the particles matrix of f2(x) after changing dx-resolution,
    // at run-time, without needing to reset the animation
    // It works incredible good!


    // DX2

    Label labelDX2=new Label(" [ DX2 : " + GlobalsFX2.dx2 + " u ] ");

    // Text field for x - resolution : dx2

    Label labelInputDx2 = new Label(" Enter DX2 ");

    // Text field input for DX2

    TextField textFieldDx2 = new TextField();


    // A2


    Label labelA2=new Label(" [ A2 : " + GlobalsFX2.A2 + " u ] ");

    // Text field for amplitude : A2

    Label labelInputA2 = new Label(" Enter A2 ");

    // Text field input for A2

    TextField textFieldA2 = new TextField();



    // K2


    Label labelK2=new Label(" [ K2 : " + GlobalsFX2.K2 + " /u ] ");

    // Text field for wave number : K2

    Label labelInputK2 = new Label(" Enter K2 ");

    // Text field input for K2

    TextField textFieldK2 = new TextField();


    // W2


    Label labelW2=new Label(" [ W2 : " + GlobalsFX2.W2 + " /s ] ");

    // Text field for angular frequency : W2

    Label labelInputW2 = new Label(" Enter W2 ");

    // Text field input for K2

    TextField textFieldW2 = new TextField();

    

    void addElements()
    {
    	getChildren().addAll(labelF2, labelDX2, labelInputDx2, textFieldDx2, labelA2,
                labelInputA2, textFieldA2, labelK2, labelInputK2, textFieldK2, labelW2, 
                labelInputW2, textFieldW2);
    }

    void setup()
    {
        addElements();
        setupDecoration();
    }

    PanelCBottomLine2() {
        
        setup();
    }

}
