package application;

/**
 * Global parameters for the first function
 * f1(x) = A1 sin ( k1 x - w1 t )
 *
 * k : wave number
 * w : angular frequency
 *
 * Important parameter : resolution dx
 *
 * For x = x + dx
 *
 */
public class GlobalsFX1 {

    // X-resolution for f1(x) in math units
    static double dx1=0.3;
    static void setDx1(double val)
    {
        dx1=val;
    }

    // A1 : Wave amplitude

    static double A1=1;

    static void setA1(double val) { A1=val; }


    // K1 : Wave number

    static double K1=1;

    static void setK1(double val) { K1=val; }

    // W1 : Angular frequency

    static double W1=1;

    static void setW1(double val) { W1=val; }



}
