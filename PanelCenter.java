package application;

import javafx.beans.value.ObservableValue;
import javafx.scene.layout.BorderPane;

public class PanelCenter extends BorderPane {

	PanelCTop panelCTop;
	PanelCGraphics panelCGraphics;
	PanelCBottom panelCBottom;

	// Particles System

	VirtualSystem virtualSystem;

	void setupSubPanels() {
		panelCTop = new PanelCTop();
		panelCBottom = new PanelCBottom();
		panelCGraphics = new PanelCGraphics();
		setTop(panelCTop);
		setCenter(panelCGraphics);
		setBottom(panelCBottom);
	}

	void setupSubPanels(VirtualSystem _particlesSystem) {
		panelCTop = new PanelCTop();
		panelCBottom = new PanelCBottom();
		panelCGraphics = new PanelCGraphics(_particlesSystem);
		setTop(panelCTop);
		setCenter(panelCGraphics);
		setBottom(panelCBottom);
	}

	void setupTextFieldDx1() {
		panelCBottom.line1.textFieldDx1.setPromptText("");
		panelCBottom.line1.textFieldDx1.setPrefColumnCount(3);
		panelCBottom.line1.textFieldDx1.textProperty()
				.addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
					actionTextFieldDx1();
				});
	}

	void setupTextFieldDx2() {
		panelCBottom.line2.textFieldDx2.setPromptText("");
		panelCBottom.line2.textFieldDx2.setPrefColumnCount(3);
		panelCBottom.line2.textFieldDx2.textProperty()
				.addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
					actionTextFieldDx2();
				});
	}

	void actionTextFieldDx1() {
		double val = GlobalsFX1.dx1;
		String strVal = panelCBottom.line1.textFieldDx1.getText();
		String strVal2 = strVal.replace(",", ".");
		try {
			val = Double.parseDouble(strVal2);
			if (val > 0)
				GlobalsFX1.setDx1(val);
		} catch (NumberFormatException e) {
			// Ignore exception
		}

		String textLabelDx1 = " [ DX1 : " + GlobalsFX1.dx1 + " u ] ";
		panelCBottom.line1.labelDX1.setText(textLabelDx1);
		reloadMatrixF1();
	}

	void actionTextFieldDx2() {
		double val = GlobalsFX2.dx2;
		String strVal = panelCBottom.line2.textFieldDx2.getText();
		String strVal2 = strVal.replace(",", ".");
		try {
			val = Double.parseDouble(strVal2);
			if (val > 0)
				GlobalsFX2.setDx2(val);
		} catch (NumberFormatException e) {
			// Ignore exception
		}

		String textLabelDx2 = " [ DX2 : " + GlobalsFX2.dx2 + " u ] ";
		panelCBottom.line2.labelDX2.setText(textLabelDx2);
		reloadMatrixF2();
	}

	void reloadMatrixF1() {

		virtualSystem.wavesSystem.fx1.loadParticlesMatrix();
	}

	void reloadMatrixF2() {

		virtualSystem.wavesSystem.fx2.loadParticlesMatrix();
	}

	void setupTextFieldA1() {
		panelCBottom.line1.textFieldA1.setPromptText("");
		panelCBottom.line1.textFieldA1.setPrefColumnCount(3);
		panelCBottom.line1.textFieldA1.textProperty()
				.addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
					actionTextFieldA1();
				});
	}

	void setupTextFieldA2() {
		panelCBottom.line2.textFieldA2.setPromptText("");
		panelCBottom.line2.textFieldA2.setPrefColumnCount(3);
		panelCBottom.line2.textFieldA2.textProperty()
				.addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
					actionTextFieldA2();
				});
	}

	void actionTextFieldA1() {
		double val = GlobalsFX1.A1;
		String strVal = panelCBottom.line1.textFieldA1.getText();
		String strVal2 = strVal.replace(",", ".");
		try {
			val = Double.parseDouble(strVal2);
			if (val != 0)
				GlobalsFX1.setA1(val);
		} catch (NumberFormatException e) {
			// Ignore exception
		}

		String textLabelA1 = " [ A1 : " + GlobalsFX1.A1 + " u ] ";
		panelCBottom.line1.labelA1.setText(textLabelA1);
		reloadMatrixF1();
	}

	void actionTextFieldA2() {
		double val = GlobalsFX2.A2;
		String strVal = panelCBottom.line2.textFieldA2.getText();
		String strVal2 = strVal.replace(",", ".");
		try {
			val = Double.parseDouble(strVal2);
			if (val != 0)
				GlobalsFX2.setA2(val);
		} catch (NumberFormatException e) {
			// Ignore exception
		}

		String textLabelA2 = " [ A2 : " + GlobalsFX2.A2 + " u ] ";
		panelCBottom.line2.labelA2.setText(textLabelA2);
		reloadMatrixF2();
	}

	void setupTextFieldK1() {
		panelCBottom.line1.textFieldK1.setPromptText("");
		panelCBottom.line1.textFieldK1.setPrefColumnCount(3);
		panelCBottom.line1.textFieldK1.textProperty()
				.addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
					actionTextFieldK1();
				});
	}

	void setupTextFieldK2() {
		panelCBottom.line2.textFieldK2.setPromptText("");
		panelCBottom.line2.textFieldK2.setPrefColumnCount(3);
		panelCBottom.line2.textFieldK2.textProperty()
				.addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
					actionTextFieldK2();
				});
	}

	void actionTextFieldK1() {
		double val = GlobalsFX1.K1;
		String strVal = panelCBottom.line1.textFieldK1.getText();
		String strVal2 = strVal.replace(",", ".");
		try {
			val = Double.parseDouble(strVal2);
			if (val != 0)
				GlobalsFX1.setK1(val);
		} catch (NumberFormatException e) {
			// Ignore exception
		}

		String textLabelK1 = " [ K1 : " + GlobalsFX1.K1 + " /u ] ";
		panelCBottom.line1.labelK1.setText(textLabelK1);
		reloadMatrixF1();
	}

	void actionTextFieldK2() {
		double val = GlobalsFX2.K2;
		String strVal = panelCBottom.line2.textFieldK2.getText();
		String strVal2 = strVal.replace(",", ".");
		try {
			val = Double.parseDouble(strVal2);
			if (val != 0)
				GlobalsFX2.setK2(val);
		} catch (NumberFormatException e) {
			// Ignore exception
		}

		String textLabelK2 = " [ K2 : " + GlobalsFX2.K2 + " /u ] ";
		panelCBottom.line2.labelK2.setText(textLabelK2);
		reloadMatrixF2();
	}

	//////

	void setupTextFieldW1() {
		panelCBottom.line1.textFieldW1.setPromptText("");
		panelCBottom.line1.textFieldW1.setPrefColumnCount(3);
		panelCBottom.line1.textFieldW1.textProperty()
				.addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
					actionTextFieldW1();
				});
	}

	void setupTextFieldW2() {
		panelCBottom.line2.textFieldW2.setPromptText("");
		panelCBottom.line2.textFieldW2.setPrefColumnCount(3);
		panelCBottom.line2.textFieldW2.textProperty()
				.addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
					actionTextFieldW2();
				});
	}

	void actionTextFieldW1() {
		double val = GlobalsFX1.W1;
		String strVal = panelCBottom.line1.textFieldW1.getText();
		String strVal2 = strVal.replace(",", ".");
		try {
			val = Double.parseDouble(strVal2);
			if (val != 0)
				GlobalsFX1.setW1(val);
		} catch (NumberFormatException e) {
			// Ignore exception
		}

		String textLabelW1 = " [ W1 : " + GlobalsFX1.W1 + " /s ] ";
		panelCBottom.line1.labelW1.setText(textLabelW1);
		reloadMatrixF1();
	}

	void actionTextFieldW2() {
		double val = GlobalsFX2.W2;
		String strVal = panelCBottom.line2.textFieldW2.getText();
		String strVal2 = strVal.replace(",", ".");
		try {
			val = Double.parseDouble(strVal2);
			if (val != 0)
				GlobalsFX2.setW2(val);
		} catch (NumberFormatException e) {
			// Ignore exception
		}

		String textLabelW2 = " [ W2 : " + GlobalsFX2.W2 + " /s ] ";
		panelCBottom.line2.labelW2.setText(textLabelW2);
		reloadMatrixF2();
	}

	//////////

	void setupTextFieldsF1() {
		setupTextFieldDx1();

		setupTextFieldA1();

		setupTextFieldK1();

		setupTextFieldW1();
	}

	void setupTextFieldsF2() {
		setupTextFieldDx2();

		setupTextFieldA2();

		setupTextFieldK2();

		setupTextFieldW2();
	}

	PanelCenter() {
		super();
		setupSubPanels();
	}

	PanelCenter(VirtualSystem _virtualSystem) {
		super();
		virtualSystem = _virtualSystem;
		setupSubPanels(_virtualSystem);
		setupTextFieldsF1();
		setupTextFieldsF2();

	}

}
