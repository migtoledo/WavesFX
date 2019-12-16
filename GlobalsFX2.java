package application;

/**
 * Global parameters for the second function
 * f2(x) = A2 cos ( k2 x - w2 t )
 *
 * k : wave number
 * w : angular frequency
 *
 * Important parameter : resolution dx
 *
 * For x = x + dx
 *
 */
public class GlobalsFX2 {

    // X-resolution for f1(x) in math units
    static double dx2=0.3;
    static void setDx2(double val)
    {
        dx2=val;
    }

    // A2 : Wave amplitude

    static double A2=1;

    static void setA2(double val) { A2=val; }


    // K2 : Wave number

    static double K2=1;

    static void setK2(double val) { K2=val; }

    // W2 : Angular frequency

    static double W2=1;

    static void setW2(double val) { W2=val; }



}
