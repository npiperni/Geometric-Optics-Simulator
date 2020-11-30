package optics;

public class OpticsCalc {

	private static double imgDistance = 0.00;
	private static double imgHeight = 0.00;
	private static double mag = 0.00;

	public static double calculateImgDistance(double objDistance, double f) {

		if ((objDistance == 0.00)) {

			System.out.println("INFO missing");

		} else {
			imgDistance = 1 / ((1 / f) - (1 / objDistance));
		}

		return imgDistance;
	}

	public static double calculateImgHeight(double objHeight, double objDistance) {

		if (!(objHeight == 0.00) & !(objDistance == 0.00) & !(imgDistance == 0.00)) {

			imgHeight = ((-imgDistance) / objDistance) * objHeight;

		} else {
			System.out.println("initial values missing");
		}

		return imgHeight;
	}

	public static double calculateMag(double objHeight, double objDistance) {
		if (!(imgDistance == 0.00) & !(objDistance == 0.00)) {

			mag = (-imgDistance / objDistance);

		} else if (!(objHeight == 0.00) & !(imgHeight == 0.00)) {

			mag = (imgHeight / objHeight);

		}

		return mag;
	}

}
