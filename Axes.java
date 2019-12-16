
package application;

import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author mtg
 */
public class Axes {
	double offsetX = 3;
	double offsetY = 3;
	double w = GlobalsScreen.getGraphicsW();
	double h = GlobalsScreen.getGraphicsH();

	void updateDimensions() {
		w = GlobalsScreen.getGraphicsW();
		h = GlobalsScreen.getGraphicsH();
		GlobalsXY.updateGlobalsXY();
	}

	// Corresponds to given (ox, oy)
	void drawCentered(GraphicsContext gc) {
		gc.setStroke(GlobalsAxesColors.colorAxesCentered);
		gc.strokeLine(w / 2, offsetY, w / 2, h - offsetY);
		gc.strokeLine(offsetX, h / 2, w - offsetX, h / 2);
	}

	void draw(GraphicsContext gc) {
		updateDimensions();
		gc.setLineWidth(3);
		drawMoved(gc);
		drawCentered(gc);
		gc.setStroke(GlobalsGraphicsColors.colorForeground);
	}

	// Corresponds to actual position of origin (0, 0)
	void drawMoved(GraphicsContext gc) {
		gc.setStroke(GlobalsAxesColors.colorAxesMoved);
		
		// For ox=oy=0
		
		double xxMin=GlobalsXY.xx(GlobalsXY.xMin);
		double xxMax=GlobalsXY.xx(GlobalsXY.xMax);
		double yyMin=GlobalsXY.yy(GlobalsXY.yMin);
		double yyMax=GlobalsXY.yy(GlobalsXY.yMax);
		double xx0=GlobalsXY.xx(0);
		double yy0=GlobalsXY.yy(0);
		
		// Vertical
		gc.strokeLine(xx0, yyMin, xx0, yyMax);
		// Horizontal
		gc.strokeLine(xxMin, yy0, xxMax, yy0);
	}

	Axes() {
		offsetX = 3;
		offsetY = 3;
		updateDimensions();
	}

}
