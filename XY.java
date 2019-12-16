package application;

import org.apache.commons.math3.complex.Complex;

/**
 *
 * @author mtg
 */
public class XY extends Complex {
    
	private static final long serialVersionUID = 1L;
	private double x=0;
    private double y=0;

    private void setX(double real) {
        x = real;
    }

    private void setY(double imaginary) {
        y = imaginary;
    }

    double getX() {
        return getReal();
    }

    double getY() {
        return getImaginary();
    }

    private void setXY(double real, double imaginary) {
        setX(real);
        setY(imaginary);
    }

    XY getSelf() {
        return this;
    }

    Complex getAsComplex() {
        return (new Complex(getX(), getY()));
    }

    XY getXY() {
        return (new XY(getX(), getY()));
    }

    XY get() {
        return getSelf();
    }

    XY(XY xy) {
        this(xy.getX(), xy.getY());
    }

    XY(Complex xy) {
        this(xy.getReal(), xy.getImaginary());
    }

    XY() {
        this(0, 0);
        setXY(0, 0);
    }

    XY(double real, double imaginary) {
        super(real, imaginary);
        setXY(real, imaginary);
    }

    XY(double real) {
        super(real);
        setX(real);
        setY(0);
    }

}
