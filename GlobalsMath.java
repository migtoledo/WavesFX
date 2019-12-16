package application;

import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.complex.ComplexUtils;

public class GlobalsMath {

   static Complex polar2ComplexDeg(double ro, double angleDeg) {
      double angleRad = Math.toRadians(angleDeg);
      return ComplexUtils.polar2Complex(ro, angleRad);
   }

   /**
    * Returns the polarCoordinates coordinates of complex number xyCoordinates
    */
   static Complex Complex2PolarDeg(Complex xy) {
      double ro = xy.abs();
      double angleDeg = Math.toDegrees(xy.getArgument());
      return new Complex(ro, angleDeg);
   }

   /**
    * Returns the polarCoordinates coordinates of the pair (x, y)
    */
   static Complex Complex2PolarDeg(double x, double y) {
      return GlobalsMath.Complex2PolarDeg(new Complex(x, y));
   }

}
