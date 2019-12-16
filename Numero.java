package application;

public class Numero {

	private double N = 0;

	protected final void set(double _N) {
		N = _N;
	}

	protected final double get() {
		return N;
	}

	Numero(double _N) {
		set(_N);
	}

	Numero() {
		set(0);
	}

}
