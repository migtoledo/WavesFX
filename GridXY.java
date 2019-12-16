package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author mtg
 *
 *         Class for performing a grid XY
 *
 */
public class GridXY {

	double w = GlobalsScreen.getGraphicsW();
	double h = GlobalsScreen.getGraphicsH();
	
	double offsetXLabelsX=9;
	double offsetYLabelsX=20;
	double offsetXLabelsY=-40;
	double offsetYLabelsY=-9;
	
	private void updateDimensions() {
		w = GlobalsScreen.getGraphicsW();
		h = GlobalsScreen.getGraphicsH();
		GlobalsXY.updateGlobalsXY();
	}

	void drawVlines(GraphicsContext gc) {
		// Pixels-distance X
		double dxx = GlobalsXY.xScale;
		double nmax = GlobalsXY.oxx / dxx;
		for (double n = 0; n <= nmax; n++) {
			double xx1 = GlobalsXY.oxx + (n) * dxx;
			double xx2 = GlobalsXY.oxx - (n) * dxx;
			gc.strokeLine(xx1, 0, xx1, h);
			gc.strokeLine(xx2, 0, xx2, h);
		}
	}

	void drawHlines(GraphicsContext gc) {
		// Pixels-distance Y
		double dyy = GlobalsXY.yScale;
		double nmax = GlobalsXY.oyy / dyy;
		for (double n = 0; n <= nmax; n++) {
			double yy1 = GlobalsXY.oyy + (n) * dyy;
			double yy2 = GlobalsXY.oyy - (n) * dyy;
			gc.strokeLine(0, yy1, w, yy1);
			gc.strokeLine(0, yy2, w, yy2);
		}
	}

	void drawXlabels(GraphicsContext gc) {
		// Pixels-distance X
		double dxx = GlobalsXY.xScale;
		double nmax = GlobalsXY.oxx / dxx;
		for (double n = 0; n <= nmax; n++) {
			double xx1 = GlobalsXY.oxx + (n) * dxx;
			double xx2 = GlobalsXY.oxx - (n) * dxx;
			double xLabels1 = GlobalsXY.x(xx1);
			double xLabels2 = GlobalsXY.x(xx2);
			String strXlabels2 = String.format("%.2f", xLabels2);
			String strXlabels1 = String.format("%.2f", xLabels1);
			if (GlobalsGridXY.showXYlabels) {
				gc.strokeText(strXlabels1, xx1+offsetXLabelsX, GlobalsXY.oyy +offsetYLabelsX);
				gc.strokeText(strXlabels2, xx2+offsetXLabelsX, GlobalsXY.oyy +offsetYLabelsX);
			}
		}
	}

	void drawYlabels(GraphicsContext gc) {
		// Pixels-distance Y
		double dyy = GlobalsXY.yScale;
		double nmax = GlobalsXY.oyy / dyy;
		for (double n = 0; n <= nmax; n++) {
			double yy1 = GlobalsXY.oyy + (n) * dyy;
			double yy2 = GlobalsXY.oyy - (n) * dyy;
			double yLabels1 = GlobalsXY.y(yy1);
			double yLabels2 = GlobalsXY.y(yy2);
			String strYlabels1 = String.format("%.2f", yLabels1);
			String strYlabels2 = String.format("%.2f", yLabels2);
			if (GlobalsGridXY.showXYlabels) {
				gc.strokeText(strYlabels1, GlobalsXY.oxx+offsetXLabelsY, yy1 +offsetYLabelsY);
				gc.strokeText(strYlabels2, GlobalsXY.oxx +offsetXLabelsY, yy2+offsetYLabelsY);
			}
		}
	}

	void drawXYlabels(GraphicsContext gc) {
		if (GlobalsXY.xScale > 25)
			drawXlabels(gc);
		if (GlobalsXY.yScale > 25)
			drawYlabels(gc);
	}

	// Drawing the Grid : Math Units -> Screen Units
	void draw(GraphicsContext gc) {
		updateDimensions();
		gc.setLineWidth(GlobalsGraphicsColors.gridLineWidth);
		gc.setStroke(GlobalsGraphicsColors.colorGrid);
		drawVlines(gc);
		drawHlines(gc);
		if (GlobalsGridXY.showXYlabels) {
			gc.setStroke(GlobalsGraphicsColors.colorLabels);
			gc.setLineWidth(GlobalsGraphicsColors.labelsLineWidth);
			drawXYlabels(gc);
		}
	}

	GridXY() {
		updateDimensions();
	}

	GridXY(double width, double height) {
		w = width;
		h = height;
		updateDimensions();
	}
}
