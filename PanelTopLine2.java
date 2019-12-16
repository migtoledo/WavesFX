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

public class PanelTopLine2 extends FlowPane {

	Label labelRealdt = new Label(" [ Real dt =  ] ");

	void labelRealdtUpdate() {
		String str = " [  Refresh Period = " + GlobalsTimers.getStrUpdateAnimPeriod() + " s ] ";
		labelRealdt.setText(str);
	}

	void setupToolTipLabelRealdt() {
		Tooltip labelRealdtInfo = new Tooltip(" Real refresh period for " + "the animation, in seconds. ");

		Tooltip.install(labelRealdt, labelRealdtInfo);
	}

	Label labelRealT = new Label(" [ real t =  ] ");

	void labelRealTupdate() {
		String val = GlobalsTimers.getStrTReal();
		String text = " [ real t = " + val + " s ] ";
		labelRealT.setText(text);
	}

	Label labelInputDt = new Label(" Input virtual dt ");

	// Text field input for dt
	TextField textFieldDt = new TextField();

	// Setting up Text Field dt of Top Panel Line 2
	void setupTextFieldDt() {
		textFieldDt.setPromptText("");
		textFieldDt.setPrefColumnCount(3);
		textFieldDt.textProperty()
				.addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
					actionTextFieldDt();
				});
	}

	// Text Field Dt -> Action
	void actionTextFieldDt() {

		double val = GlobalsTimers.updateAnimationPeriod;
		String strVal = textFieldDt.getText();
		String strVal2 = strVal.replace(",", ".");
		try {
			val = Double.parseDouble(strVal2);
		} catch (NumberFormatException e) {
			// Ignore exception
		}
		GlobalsTimers.setDt(val);
	}

	Label labelDt = new Label("dt:");

	void labelDtUpdate() {
		String str = " [  virtual dt : " + GlobalsTimers.getStrDt() + " s  ] ";
		labelDt.setText(str);
	}

	void setupToolTiplabelDt() {
		Tooltip labelDtInfo = new Tooltip(" Virtual refresh period " + "for the animation, in virtual seconds. ");

		Tooltip.install(labelDt, labelDtInfo);
	}

	Label labelAnimTime = new Label(" [ virtual t : " + GlobalsTimers.t + " s  ] ");

	void labelAnimTimeUpdate() {
		String str = " [  virtual t : " + GlobalsTimers.getStrT() + " s  ] ";
		labelAnimTime.setText(str);
	}

	Label labelRtimeVtime = new Label(
			" [ 1 s real-time =  " + GlobalsTimers.getStrRealTimeVersusVirtualTime() + " s virtual-time ]");

	void labelRtimeVtimeUpdate() {
		String str = " [ 1 s real-time =  " + GlobalsTimers.getStrRealTimeVersusVirtualTime() + " s virtual-time ]";
		labelRtimeVtime.setText(str);
	}

	Label labelVtimeRtime = new Label(
			" [ 1 s virtual-time =  " + GlobalsTimers.getStrVirtualTimeVersusRealTime() + " s real-time ]");

	void labelVtimeRtimeUpdate() {
		String str = " [ 1 s virtual-time =  " + GlobalsTimers.getStrVirtualTimeVersusRealTime() + " s real-time ]";
		labelVtimeRtime.setText(str);
	}

	Button buttonSync = new Button(" SYNCHRONIZE ");

	void synchronizeDt() {
		GlobalsTimers.setDt(GlobalsTimers.getDtReal());
		textFieldDt.clear();
	}

	void actionButtonSync() {
		synchronizeDt();
	}

	void buttonSyncSetup() {
		buttonSync.setOnAction((ActionEvent e) -> {
			actionButtonSync();
		});

		Tooltip buttonSyncInfo = new Tooltip(
				" Set differential virtual-time " + "equal to " + "the differential real-time. That makes virtual-time "
						+ "dt coincident with" + " the native CPU clock refresh frequency. ");

		Tooltip.install(buttonSync, buttonSyncInfo);

	}

	void setupPadding() {
		int p = 4;
		setPadding(new Insets(p, p, p, p));
	}

	void setupGaps() {
		int hGap = 4;
		int vGap = 2;
		setHgap(hGap);
		setVgap(vGap);
	}

	void setupAlignment() {
		setAlignment(Pos.CENTER);
	}

	void setupBackground() {
		setBackground(new Background(
				new BackgroundFill(GlobalsPanelColors.colorPanelTopLine2Background, CornerRadii.EMPTY, Insets.EMPTY)));
	}

	void setupBorder() {
		setBorder(new Border(new BorderStroke(GlobalsPanelColors.colorPanelTopLine2Border, BorderStrokeStyle.SOLID,
				CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	}

	void setupDecoration() {
		setupPadding();
		setupGaps();
		setupAlignment();
		setupBackground();
		setupBorder();
	}

	void addElements() {
		getChildren().addAll(labelRealdt, labelRealT, labelInputDt, textFieldDt, labelDt, labelAnimTime,
				labelRtimeVtime, labelVtimeRtime, buttonSync);
	}

	void setFonts() {
		double fontsize = 10;
		labelRealdt.setFont(new Font("Verdana", fontsize));
		labelRealT.setFont(new Font("Verdana", fontsize));
		labelInputDt.setFont(new Font("Verdana", fontsize));
		textFieldDt.setFont(new Font("Verdana", fontsize));
		labelDt.setFont(new Font("Verdana", fontsize));

		labelAnimTime.setFont(new Font("Verdana", fontsize));
		labelRtimeVtime.setFont(new Font("Verdana", fontsize));
		labelVtimeRtime.setFont(new Font("Verdana", fontsize));
		buttonSync.setFont(new Font("Verdana", fontsize));

	}

	void updateElements() {
		labelRealTupdate();
		labelRealdtUpdate();
		labelDtUpdate();
		labelAnimTimeUpdate();
		labelRtimeVtimeUpdate();
		labelVtimeRtimeUpdate();
	}

	private void setup() {
		setupToolTipLabelRealdt();
		setupToolTiplabelDt();
		setupTextFieldDt();
		buttonSyncSetup();
		addElements();
		setupDecoration();
		setFonts();
		updateElements();
	}

	PanelTopLine2() {
		setup();
	}

}
