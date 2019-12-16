package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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

public class PanelCTopLine1 extends FlowPane {


    Label labelPixelsUnits = new Label("1 PIXEL =");

    void updateLabelPixelUnits() {
        GlobalsXY.updateGlobalsXY();
        String str =
                " [ 1 PIXEL = " + GlobalsXY.strPixelToUnits + " u ] [ 1 u = " + GlobalsXY.strUxyToPixels + " px ] ";
        labelPixelsUnits.setText(str);
    }


    Label labelRadiusPixels = new Label("Radius-Pixels =");

    void updateLabelRadiusPixels() {
        GlobalsXY.updateGlobalsXY();
        GlobalsRadius.updateRadius();
        String str = " [ Radius-Pixels = " + GlobalsRadius.radius.getRadPix().get() + " px ] ";
        labelRadiusPixels.setText(str);
    }


    // Text field input for Radius of particles in pixel units

    TextField textFieldInputRadiusPixels = new TextField();

    // Setting up Text Field

    void setupTextFielInputRadiusPixels() {
        textFieldInputRadiusPixels.setPromptText("");
        textFieldInputRadiusPixels.setPrefColumnCount(3);
        textFieldInputRadiusPixels.textProperty().addListener(
                (ObservableValue<? extends String> observable,
                 String oldValue, String newValue) -> {
                    actionTextFieldInputRadiusPixels();
                });
    }

    // Text Field -> Action

    void actionTextFieldInputRadiusPixels() {

        double val = GlobalsRadius.Rpix;

        String strVal = textFieldInputRadiusPixels.getText().replace(",", ".");
        ;

        try {
            val = Double.parseDouble(strVal);
            clearTextFieldInputRadiusUnits();
        } catch (NumberFormatException e) {
            // Ignore exception
        }
        GlobalsRadius.setRadius(new Radius(new RadiusPixels(val)));

    }

    void clearTextFieldInputRadiusPixels() {
        textFieldInputRadiusPixels.clear();
    }


    void clearTextFieldInputRadiusUnits() {
        textFieldInputRadiusUnits.clear();
    }

    void clearTextFieldsInputRadius() {
        clearTextFieldInputRadiusPixels();
        clearTextFieldInputRadiusUnits();
    }


    // Label Radius in units


    Label labelRadiusUnits = new Label("Radius-Units =");

    void updateLabelRadiusUnits() {
        GlobalsXY.updateGlobalsXY();
        GlobalsRadius.updateRadius();
        String str = " [ Radius-Units = " + GlobalsRadius.strRunits + " u ] ";
        labelRadiusUnits.setText(str);
    }


    // Text field input radius in units


    TextField textFieldInputRadiusUnits = new TextField();

    // Setting up Text Field

    void setupTextFielInputRadiusUnits() {
        textFieldInputRadiusUnits.setPromptText("");
        textFieldInputRadiusUnits.setPrefColumnCount(3);
        textFieldInputRadiusUnits.textProperty().addListener(
                (ObservableValue<? extends String> observable,
                 String oldValue, String newValue) -> {
                    actionTextFieldInputRadiusUnits();
                });
    }

    // Text Field -> Action

    void actionTextFieldInputRadiusUnits() {

        double val = GlobalsRadius.Runits;

        String strVal = textFieldInputRadiusUnits.getText().replace(",", ".");
        ;

        try {
            val = Double.parseDouble(strVal);
            clearTextFieldInputRadiusPixels();
        } catch (NumberFormatException e) {
            // Ignore exception
        }
        GlobalsRadius.setRadius(new Radius(new RadiusUnits(val)));

    }


    CheckBox checkBoxProportionalRadius = new CheckBox(" Proportional Radius ");








// Button restore defaults particles

    Button buttonRestoreParticles = new Button(" RESTORE  PARTICLES ");

    // Setup from Main Panel



//


    


    void setupPadding() {
        int p = 2;
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
        setBackground(new Background(new BackgroundFill(GlobalsPanelColors.colorPanelCTopLine1Background,
                CornerRadii.EMPTY, Insets.EMPTY)));
    }

    void setupBorder() {
        setBorder(new Border(new BorderStroke(GlobalsPanelColors.colorPanelCTopLine1Border,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    }


    void updateElements() {
        
        updateLabelPixelUnits();
        updateLabelRadiusPixels();
        updateLabelRadiusUnits();
    }

    void setupDecoration() {

        setupPadding();
        setupGaps();
        setupAlignment();
        setupBackground();
        setupBorder();
    }


    void actionCheckBoxProportionalRadius()
    {
        if(checkBoxProportionalRadius.isSelected()) GlobalsRadius.proportionalRadius=
                true;
        if(checkBoxProportionalRadius.isSelected()==false) GlobalsRadius.proportionalRadius=false;
    }

    void setupCheckBoxProportionalRadius() {
        checkBoxProportionalRadius.selectedProperty().addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> ov,
                                Boolean old_val, Boolean new_val) {
                actionCheckBoxProportionalRadius();

            }
        });
    }


    private void setup() {

        setupTextFielInputRadiusPixels();

        setupTextFielInputRadiusUnits();

        setupCheckBoxProportionalRadius();



        updateElements();

        addElements();

        setupDecoration();

    }

    void addElements() {
        getChildren().addAll(labelPixelsUnits, labelRadiusPixels,
                textFieldInputRadiusPixels, labelRadiusUnits,
                textFieldInputRadiusUnits, checkBoxProportionalRadius,
                buttonRestoreParticles);
    }

    PanelCTopLine1() {

        setup();

    }

}
