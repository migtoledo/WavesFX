package application;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

public class PanelCBottom extends VBox {

    PanelCBottomLine1 line1;
    PanelCBottomLine2 line2;

    void setupLines() {
        line1 = new PanelCBottomLine1();
        line2 = new PanelCBottomLine2();
    }

    void addLines() {
        
        getChildren().addAll(line1, line2);
    }

    private void setup() {
        setupLines();
        addLines();
        setPadding(new Insets(2, 2, 2, 2));
    }

    PanelCBottom() {
        super();
        setup();
    }

}
