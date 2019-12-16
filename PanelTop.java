package application;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

public class PanelTop extends VBox {

    PanelTopLine1 line1;
    PanelTopLine2 line2;
    PanelTopLine3 line3;

    void setupLines() {
        line1 = new PanelTopLine1();
        line2 = new PanelTopLine2();
        line3 = new PanelTopLine3();
    }

    void addLines() {
        getChildren().addAll(line1, line2, line3);
    }

    void setupDecoration() {
        setPadding(new Insets(2, 2, 2, 2));
    }

    private void setup() {
        setupLines();
        addLines();
        setupDecoration();
    }

    PanelTop() {
        super();
        setup();
    }
}
