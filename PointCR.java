package application;

import javafx.scene.paint.Color;

/**
 * A point with color and radius
 */
public class PointCR extends PointC {

   protected Radius radius = GlobalsRadius.defaultRadius;
   protected boolean selfRadius = false;

   // Getting initial radius and initial scale
   private Radius initialRadius;
   private double initialXYscale = GlobalsXY.uxyToPixels;
   private double proportionalRadiusConstant;

   private void setInitialStateRadius() {
      setRadius(initialRadius);
   }

   void setInitialState() {
      setInitialStateRadius();
      setInitialStateXY();
      System.out.println("Hola from PXY");
   }

   // Particles adopt default radius have selfradius=false
   // and they can input some user-given radius
   private void setProportionalRadiusConstant() {
      proportionalRadiusConstant = (initialRadius.RadPix.get() / initialXYscale);
   }

   protected void computeProportionalRadius() {
      double Rpix = proportionalRadiusConstant * GlobalsXY.uxyToPixels;
      radius = new Radius(new RadiusPixels(Rpix));
   }

   private void setInitialRadius(Radius R) {
      initialRadius = R;
   }

   private void setInitialXYscale() {
      initialXYscale = GlobalsXY.uxyToPixels;
   }

   private void setupProportionalRadius(Radius R) {
      setInitialXYscale();
      setInitialRadius(R);
      setProportionalRadiusConstant();
   }

   protected void updateRadiusInput() {
      setRadius(GlobalsRadius.radius);
   }

   // Setting up radius functions
   private void setRadius(Radius R) {
      radius = R;
   }

   // With given radius in pixels
   private void initSelfRadius(Radius R) {
      setRadius(R);
      selfRadius = true;
      setupProportionalRadius(R);
   }

   // Update radius of particles
   void updateRadius() {
      radius.updateUnits();
      if (selfRadius == false) {
         updateRadiusInput();
      } else {
         if (GlobalsRadius.proportionalRadius) {
            computeProportionalRadius();
         }
      }
   }

   XY xxyy() {
      // Transformed XY coordinates Math -> Screen
      updateRadius();
      double xx = GlobalsXY.xx(xy.getX());
      double yy = GlobalsXY.yy(xy.getY());
      double xx0 = xx - radius.RadPix.get();
      double yy0 = yy - radius.RadPix.get();
      return (new XY(xx0, yy0));
   }

   double Diameter() {
      updateRadius();
      return (2 * radius.RadPix.get());
   }

   // Constructors
   PointCR() {
      super();
      setInitialRadius(GlobalsRadius.defaultRadius);
   }

   PointCR(XY xy) {
      super(xy);
      setInitialRadius(GlobalsRadius.defaultRadius);
   }

   // With given color
   PointCR(XY xy, Color color) {
      super(xy, color);
      setInitialRadius(GlobalsRadius.defaultRadius);
   }

   PointCR(Radius R) {
      this();
      initSelfRadius(R);
   }

   PointCR(XY xy, Radius R) {
      this(xy);
      initSelfRadius(R);
   }

   // With given color, and given radius in pixels
   PointCR(XY xy, Color color, Radius R) {
      super(xy, color);
      initSelfRadius(R);
   }
}
