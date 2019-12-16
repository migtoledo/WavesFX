package application;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

public class PanelBottom extends VBox {

    PanelBottomLine1 line1;
    PanelBottomLine2 line2;

    void setupLines() {
        line1 = new PanelBottomLine1();
        line2 = new PanelBottomLine2();
    }

    void addLines() {
        
        getChildren().addAll(line1, line2);
    }

    void setupDecoration()
    {
    	int p=1;
        setPadding(new Insets(p, p, p, p));
    }

    private void setup() {

        setupLines();
        addLines();
        setupDecoration();
    }

    PanelBottom() {

        super();
        setup();
    }

}
