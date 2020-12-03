package optics;

public class OpticsCalc {

	private static double imgDistance = 0.00;
	private static double imgHeight = 0.00;
	private static double mag = 0.00;

	private static double ray1RefractedLength;
	private static double ray1VirtualLength;
	private static double ray2PrimaryLength;
	private static double ray2RefractedLength;
	private static double ray2VirtualLength;
	private static double ray3PrimaryLength;
	private static double ray3RefractedLength;
	private static double ray3VirtualLength;

	private static double ray1Angle;
	private static double ray2Angle;
	private static double ray3Angle;

	private static double ray3NextYPos;

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

	public static double calculateRay1RefractedLength(double imgDistance, double imgHeight, double objHeight, String lensType, String imgType) {
		if(lensType.equals("Converging") && imgType.equals("Real")) {
			ray1RefractedLength = Math.sqrt(Math.pow(imgDistance,2) + Math.pow(-imgHeight + objHeight,2));
		}else {
			ray1RefractedLength = 70;
		}
		return ray1RefractedLength;
	}

	public static double calculateRay1VirtualLength(double imgDistance, double imgHeight, double objHeight, String lensType, String imgType) {
		if(lensType.equals("Converging")) {
			if(imgType.equals("Real")) {
				ray1VirtualLength = 0;
			}else {
				ray1VirtualLength = Math.sqrt(Math.pow(imgDistance,2) + Math.pow(imgHeight - objHeight,2));
			}
		}else {
			ray1VirtualLength =  Math.sqrt(Math.pow(imgDistance,2) + Math.pow(objHeight - imgHeight,2));
		}
		return ray1VirtualLength;
	}

	public static double calculateRay2PrimaryLength(double objDistance, double objHeight) {
		ray2PrimaryLength = Math.sqrt(Math.pow(objHeight,2) + Math.pow(objDistance,2));
		return ray2PrimaryLength;
	}

	public static double calculateRay2RefractedLength(double imgDistance, double imgHeight, String lensType, String imgType) {
		if(lensType.equals("Converging") && imgType.equals("Real")) {
			ray2RefractedLength = Math.sqrt(Math.pow(imgDistance,2) + Math.pow(-imgHeight,2));
		}else {
			ray2RefractedLength = 70;
		}
		return ray2RefractedLength;
	}

	public static double calculateRay2VirtualLength(double imgDistance, double imgHeight, String lensType, String imgType) {
		if(lensType.equals("Converging") && imgType.equals("Virtual")) {
			ray2VirtualLength = Math.sqrt(Math.pow(imgDistance,2) + Math.pow(imgHeight,2));
		}else {
			ray2VirtualLength = 0;
		}
		return ray2VirtualLength;
	}

	public static double calculateRay3PrimaryLength(double imgHeight, double objDistance, double objHeight, String lensType, String imgType) {
		if(lensType.equals("Converging")) {
			if(imgType.equals("Real")) {
				ray3PrimaryLength = Math.sqrt(Math.pow(objDistance,2) + Math.pow(-imgHeight + objHeight,2));
			}else {
				ray3PrimaryLength = Math.sqrt(Math.pow(objDistance,2) + Math.pow(imgHeight - objHeight,2));
			}
		}else {
			ray3PrimaryLength =  Math.sqrt(Math.pow(objDistance,2) + Math.pow(objHeight - imgHeight,2));
		}
		return ray3PrimaryLength;
	}

	public static double calculateRay3RefractedLength(double imgDistance, String lensType, String imgType) {
		if(lensType.equals("Converging") && imgType.equals("Real")) {
			ray3RefractedLength = imgDistance;
		}else {
			ray3RefractedLength = 70;
		}
		return ray3RefractedLength;
	}

	public static double calculateRay3VirtualLength(double imgDistance, String lensType, String imgType) {
		if(lensType.equals("Converging") && imgType.equals("Real")) {
			ray3VirtualLength = 0;
		}else {
			ray3VirtualLength = -imgDistance;
		}
		return ray3VirtualLength;
	}

	public static double calculateRay1Angle(double objHeight, double focalLength, String lensType) {
		if(lensType.equals("Converging")) {
			ray1Angle = 90 - Math.toDegrees(Math.atan(focalLength / objHeight));
		}else {
			ray1Angle = 270 + Math.toDegrees(Math.atan(-focalLength / objHeight));
		}
		return ray1Angle;
	}

	public static double calculateRay2Angle(double objHeight, double objDistance) {
		ray2Angle = Math.toDegrees(Math.atan(objHeight / objDistance));
		return ray2Angle;
	}

	public static double calculateRay3Angle(double objHeight, double objDistance, double imgHeight, String lensType, String imgType) {
		if(lensType.equals("Converging")) {
			if(imgType.equals("Real")) {
				ray3Angle = Math.toDegrees(Math.atan((objHeight + -imgHeight) / objDistance));
			}else {
				ray3Angle = -Math.toDegrees(Math.atan((imgHeight - objHeight) / objDistance));
			}
		}else {
			ray3Angle =  Math.toDegrees(Math.atan((objHeight - imgHeight) / objDistance));
		}
		return ray3Angle;
	}

	public static double calculateRay3NextYStartPos(double objHeight, double imgHeight, String lensType, String imgType) {
		if(lensType.equals("Converging")) {
			if(imgType.equals("Real")) {
				ray3NextYPos = objHeight + -imgHeight;
			}else {
				ray3NextYPos = objHeight - imgHeight;
			}
		}else {
			ray3NextYPos = objHeight - imgHeight;
		}
		return ray3NextYPos;
	}

	public static double getImgDistance() {
		return imgDistance;
	}

	public static double getImgHeight() {
		return imgHeight;
	}

	public static double getMag() {
		return mag;
	}

	public static double getRay1RefractedLength() {
		return ray1RefractedLength;
	}

	public static double getRay1VirtualLength() {
		return ray1VirtualLength;
	}

	public static double getRay2PrimaryLength() {
		return ray2PrimaryLength;
	}

	public static double getRay2RefractedLength() {
		return ray2RefractedLength;
	}

	public static double getRay2VirtualLength() {
		return ray2VirtualLength;
	}

	public static double getRay3PrimaryLength() {
		return ray3PrimaryLength;
	}

	public static double getRay3RefractedLength() {
		return ray3RefractedLength;
	}

	public static double getRay3VirtualLength() {
		return ray3VirtualLength;
	}

	public static double getRay1Angle() {
		return ray1Angle;
	}

	public static double getRay2Angle() {
		return ray2Angle;
	}

	public static double getRay3Angle() {
		return ray3Angle;
	}

	public static double getRay3NextYPos() {
		return ray3NextYPos;
	}

}
