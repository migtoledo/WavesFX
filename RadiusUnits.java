package application;

public class RadiusUnits extends Numero {

    RadiusPixels toPixels() {
        GlobalsXY.updateGlobalsXY();
        return new RadiusPixels(get() * GlobalsXY.uxyToPixels);
    }
    
    RadiusUnits(RadiusPixels R)
    {
        this(R.toUnits().get());
    }
    
    RadiusUnits(double _R) {
        super(_R);
    }

    RadiusUnits() {
        super();
    }

}
