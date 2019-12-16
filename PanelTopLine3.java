package application;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;

public class PanelTopLine3 extends FlowPane {

    // X MIN 
    Label labelXmin = new Label(" [ X MIN : ] ");

    void labelXminUpdate() {
        String str = " [  X MIN : " + GlobalsXY.strXmin + " u ] ";
        labelXmin.setText(str);
    }

    void setupToolTipLabelXmin() {
        Tooltip labelXminInfo = new Tooltip(" Minimal value of X coordinate ");
        Tooltip.install(labelXmin, labelXminInfo);
    }

    // X MAX
    Label labelXmax = new Label(" [ X MAX :  ] ");

    void labelXmaxUpdate() {
        String str = " [  X MAX : " + GlobalsXY.strXmax + " u ] ";
        labelXmax.setText(str);
    }

    // Y MIN
    Label labelYmin = new Label(" Y MIN ");

    void labelYminUpdate() {
        String str = " [  Y MIN : " + GlobalsXY.strYmin + " u  ] ";
        labelYmin.setText(str);
    }

    void setupToolTipLabelYmin() {
        Tooltip labelYminInfo = new Tooltip(" Minimal value of Y coordinate ");
        Tooltip.install(labelYmin, labelYminInfo);
    }

    // Y MAX
    Label labelYmax = new Label(" [ Y MAX  ] ");

    void labelYmaxUpdate() {
        String str = " [  Y MAX : " + GlobalsXY.strYmax + " u  ] ";
        labelYmax.setText(str);
    }

    // X SCALE
    Label labelXscale = new Label(" [ X SCALE ] ");

    void labelXscaleUpdate() {
        String str = " [ X SCALE :  " + GlobalsXY.strXscale + " px / u ]";
        labelXscale.setText(str);
    }

    // Text field input X scale
    TextField textFieldXscale = new TextField();

    // Setting up Text Field dt of Top Panel Line 2
    void setupTextFieldXscale() {
        textFieldXscale.setPromptText("");
        textFieldXscale.setPrefColumnCount(3);
        textFieldXscale.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            actionTextFieldXscale();
        });
    }

    void clearTextFieldXscale()
    {
        textFieldXscale.clear();
    }

    void clearTextFieldYscale()
    {
        textFieldYscale.clear();
    }

    void clearTextFieldOX()
    {
        textFieldOX.clear();
    }

    void clearTextFieldOY()
    {
        textFieldOY.clear();
    }



    // Text Field X SCALE -> Action
    void actionTextFieldXscale() {
        double val = GlobalsXY.xScale;
        String strVal = textFieldXscale.getText().replace(",", ".");
        try {
            val = Double.parseDouble(strVal);
            clearTextFieldOY();
            clearTextFieldOX();
            clearTextFieldYscale();
        } catch (NumberFormatException e) {
            // Ignore exception
        }
        if (val > 0) {
            GlobalsXY.xScale = val;
            GlobalsXY.updateGlobalsXY();
        }
    }

    // Y SCALE
    Label labelYscale = new Label(" [ Y SCALE ]");

    void labelYscaleUpdate() {
        String str = " [ Y SCALE :  " + GlobalsXY.strYscale + " px / u ]";
        labelYscale.setText(str);
    }

    //
    // Text field input Y scale
    TextField textFieldYscale = new TextField();

    // Setting up Text Field 
    void setupTextFieldYscale() {
        textFieldYscale.setPromptText("");
        textFieldYscale.setPrefColumnCount(3);
        textFieldYscale.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            actionTextFieldYscale();
        });
    }

    // Text Field Y SCALE -> Action
    void actionTextFieldYscale() {
        double val = GlobalsXY.yScale;
        String strVal = textFieldYscale.getText().replace(",", ".");
        try {
            val = Double.parseDouble(strVal);
            clearTextFieldOY();
            clearTextFieldOX();
            clearTextFieldXscale();
        } catch (NumberFormatException e) {
            // Ignore exception
        }
        if (val > 0) {
            GlobalsXY.yScale = val;
            GlobalsXY.updateGlobalsXY();
        }
    }

    // -----------------------------
    // OX
    Label labelOX = new Label(" [ OX ] ");

    void labelOXUpdate() {
        String str = " [ OX  :  " + GlobalsXY.strOX + " u ]";
        labelOX.setText(str);
    }

    // Text field input OX
    TextField textFieldOX = new TextField();

    // Setting up Text Field OX
    void setupTextFieldOX() {
        textFieldOX.setPromptText("");
        textFieldOX.setPrefColumnCount(3);
        textFieldOX.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            actionTextFieldOX();
        });
    }

    // Text Field OX -> Action
    void actionTextFieldOX() {
        double val = GlobalsXY.ox;
        String strVal = textFieldOX.getText().replace(",", ".");
        try {
            val = Double.parseDouble(strVal);
            clearTextFieldOY();
            clearTextFieldXscale();
            clearTextFieldYscale();
        } catch (NumberFormatException e) {
            // Ignore exception
        }
        GlobalsXY.ox = val;
        GlobalsXY.updateGlobalsXY();
    }

    // ----------------------------
    // -----------------------------
    // OY
    Label labelOY = new Label(" [ OY ] ");

    void labelOYUpdate() {
        String str = " [ OY  :  " + GlobalsXY.strOY + " u ]";
        labelOY.setText(str);
    }

    // Text field input OY
    TextField textFieldOY = new TextField();

    // Setting up Text Field OY
    void setupTextFieldOY() {
        textFieldOY.setPromptText("");
        textFieldOY.setPrefColumnCount(3);
        textFieldOY.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            actionTextFieldOY();
        });
    }

    // Text Field OY -> Action
    void actionTextFieldOY() {
        double val = GlobalsXY.oy;
        String strVal = textFieldOY.getText().replace(",", ".");
        try {
            val = Double.parseDouble(strVal);
            clearTextFieldOX();
            clearTextFieldXscale();
            clearTextFieldYscale();
        } catch (NumberFormatException e) {
            // Ignore exception
        }
        GlobalsXY.oy = val;
        GlobalsXY.updateGlobalsXY();
    }

    // ----------------------------
    // RESTORE XY DEFAULTS
    void actionButtonRestore() {
        GlobalsXY.setDefaultsXY();
        textFieldXscale.clear();
        textFieldYscale.clear();
        textFieldOX.clear();
        textFieldOY.clear();
    }

    Button buttonRestore = new Button(" RESTORE  X Y ");

    void buttonRestoreSetup() {
        buttonRestore.setOnAction((ActionEvent e) -> {
            actionButtonRestore();

        });

        Tooltip buttonRestoreInfo = new Tooltip(" Restore XY parameters to defaults ");

        Tooltip.install(buttonRestore, buttonRestoreInfo);

    }

    void setupPadding() {
        int p = 5;
        setPadding(new Insets(p, p, p, p));
    }

    void setupGaps() {
        int hGap = 6;
        int vGap = 2;
        setHgap(hGap);
        setVgap(vGap);
    }

    void setupAlignment() {
        setAlignment(Pos.CENTER);
    }

    void setupBackground() {
        setBackground(new Background(
                new BackgroundFill(GlobalsPanelColors.colorPanelTopLine3Background, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    void setupBorder() {
        setBorder(new Border(new BorderStroke(GlobalsPanelColors.colorPanelTopLine3Border, BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    }

    void setupDecoration() {
        setupPadding();
        setupGaps();
        setupAlignment();
        setupBackground();
        setupBorder();
        setFonts();
    }

    void addElements() {
        getChildren().addAll(labelXmin, labelXmax, labelYmin,
                labelYmax, labelXscale, textFieldXscale, labelYscale,
                textFieldYscale, labelOX, textFieldOX, labelOY, textFieldOY,
                buttonRestore);
    }

    void updateElements() {
        labelXmaxUpdate();
        labelXminUpdate();
        labelYminUpdate();
        labelYmaxUpdate();
        labelXscaleUpdate();
        labelYscaleUpdate();
        labelOXUpdate();
        labelOYUpdate();
    }

    void setFonts() {
		double fontsize = 10;
		labelXmin.setFont(new Font("Verdana", fontsize));
		labelXmax.setFont(new Font("Verdana", fontsize));
		labelYmin.setFont(new Font("Verdana", fontsize));
		labelYmax.setFont(new Font("Verdana", fontsize));
		labelXscale.setFont(new Font("Verdana", fontsize));

		textFieldXscale.setFont(new Font("Verdana", fontsize));
		labelYscale.setFont(new Font("Verdana", fontsize));
		textFieldYscale.setFont(new Font("Verdana", fontsize));
		labelOX.setFont(new Font("Verdana", fontsize));
		
		textFieldOX.setFont(new Font("Verdana", fontsize));
		labelOY.setFont(new Font("Verdana", fontsize));
		textFieldOY.setFont(new Font("Verdana", fontsize));
		buttonRestore.setFont(new Font("Verdana", fontsize));
		

	}
    
    
    private void setup() {
        setupToolTipLabelXmin();
        setupToolTipLabelYmin();
        setupTextFieldXscale();
        setupTextFieldYscale();
        setupTextFieldOX();
        setupTextFieldOY();
        buttonRestoreSetup();
        addElements();
        setupDecoration();
        updateElements();
    }

    PanelTopLine3() {
        setup();
    }

}
