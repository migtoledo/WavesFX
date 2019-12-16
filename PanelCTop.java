package application;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

public class PanelCTop extends VBox {

    PanelCTopLine1 line1;
    PanelCTopLine2 line2;

    void setupLines() {
        line1 = new PanelCTopLine1();
        line2 = new PanelCTopLine2();
    }

    void addLines() {
        
        getChildren().addAll(line1, line2);
        
        
    }

    private void setup() {
        setupLines();
        addLines();
        setPadding(new Insets(2, 2, 2, 2));
    }

    PanelCTop() {
        super();
        setup();
    }
}
