package application;

import javafx.scene.paint.Color;

/**
 *
 * @author mtg
 *
 *         <p>
 *
 *         Class for global variables of points PXY with radius, and color
 */
public class GlobalsRadius {

	static final Color defaultColor = Color.BLUE;
	
	// Particles are initialized with given radius, 
	// can make it proportional to the XY scale

	static boolean proportionalRadius = false;

	// Default radius in pixels

	static final Radius defaultRadius = new Radius(new RadiusPixels(10));

	static Radius radius = defaultRadius;

	// Particles without a given initial radius, can input some user-given radius

	static void setRadius(Radius R) {
		radius = R;
	}

	// Radius in pixel units
	static double Rpix = radius.RadPix.get();

	// Radius in math units
	static double Runits = radius.RadUnits.get();

	static String strRpix = String.format("%.2f", Rpix);

	static String strRunits = String.format("%.2f", Runits);

      
	static void updateRadius() {
         
            radius.updateUnits();
		Rpix = radius.RadPix.get();
            Runits = radius.RadUnits.get();
		strRpix = String.format("%.2f", Rpix);
		strRunits = String.format("%.2f", Runits);
	}

}
