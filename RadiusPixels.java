package application;

/** Class for Radius given in pixels */
public class RadiusPixels extends Numero {

	RadiusUnits toUnits() {
		GlobalsXY.updateGlobalsXY();
		return new RadiusUnits(get() * GlobalsXY.pixelToUnits);
	}

	RadiusPixels(RadiusUnits R) {
		this(R.toPixels().get());
	}

	RadiusPixels(double _R) {
		super(_R);
	}

	RadiusPixels() {
		super();
	}
}
