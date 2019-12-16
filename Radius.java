package application;

/**
 *
 * @author mtg
 *
 *
 * Radius = ( radius in pixels, radius in units )
 */
public class Radius {

    RadiusPixels RadPix;// = GlobalsRadius.defaultRadius.getRadPix();
    RadiusUnits RadUnits;// = GlobalsRadius.defaultRadius.getRadUnits();

    RadiusPixels getRadPix()
    {
        return RadPix;
    }
    
    RadiusUnits getRadUnits()
    {
        return RadUnits;
    }
    
    private void set(RadiusUnits R)
    {
        RadUnits=R;
        RadPix=R.toPixels();
    }
    
    private void set(RadiusPixels R)
    {
        RadPix=R;
        RadUnits=R.toUnits();
    }
    
    
    Radius(RadiusUnits R)
    {
        set(R);
    }
    
    // If we change Scale XY (pixels <---> math units), the
    // units of radius must be updated accordingly,
    // despite of maintaining the same pixel's length.
    void updateUnits()
    {
       // Genial
       double units=RadPix.get()*GlobalsXY.pixelToUnits;
       RadUnits=new RadiusUnits(units);
       /*** TO AVOID REFLECTION'S PROBLEMS "MUST BE"
        * A NEW RADIUS UNITS OBJECT GENERATED
        * FROM THE NEW XY SCALE PIXELS <---> MATH UNITS
        * ************ DEBUG INFO *********************
        */
    }
    
    Radius(RadiusPixels R)
    {
        set(R);
    }
    
    Radius() {
    }

}
