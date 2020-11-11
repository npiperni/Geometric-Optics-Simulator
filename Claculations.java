package application;

public class Claculations {

	double DI = 0.00;
	double HI = 0.00;
	double M = 0.00;

	public double DIcalc(double OD, double f) {

		if ((OD == 0.00)) {

			System.out.println("INFO missing");

		} else {
			DI = 1 / ((1 / f) - (1 / OD));
		}

		return DI;
	}

	public double HIcalc(double HO, double OD) {

		if (!(HO == 0.00) & !(OD == 0.00) & !(DI == 0.00)) {

			HI = ((-DI) / OD) * HO;

		} else {
			System.out.println("initial values missing");
		}

		return HI;
	}

	public double MAGcalc(double HO, double OD) {
		if (!(DI == 0.00) & !(OD == 0.00)) {

			M = (-DI / OD);

		} else if (!(HO == 0.00) & !(HI == 0.00)) {

			M = (HI / HO);

		}

		return M;
	}

}
