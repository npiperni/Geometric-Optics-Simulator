package optics;

public class OpticsCalc {

	private OpticsCalc() {}

	public static double calculateImgDistance(double objDistance, double f) {
		return 1 / ((1 / f) - (1 / objDistance));
	}

	public static double calculateImgHeight(double objHeight, double objDistance, double imgDistance) {
		return ((-imgDistance) / objDistance) * objHeight;
	}

	public static double calculateMag(double imgHeight, double objHeight) {
			return imgHeight / objHeight;
	}

	public static double calculateRay1RefractedLength(double imgDistance, double imgHeight, double objHeight, String lensType, String imgType) {
		if(lensType.equals("Converging") && imgType.equals("Real")) {
			return Math.sqrt(Math.pow(imgDistance,2) + Math.pow(-imgHeight + objHeight,2));
		}else {
			return 70;
		}
	}

	public static double calculateRay1VirtualLength(double imgDistance, double imgHeight, double objHeight, String lensType, String imgType) {
		if(lensType.equals("Converging")) {
			if(imgType.equals("Real")) {
				return 0;
			}else {
				return Math.sqrt(Math.pow(imgDistance,2) + Math.pow(imgHeight - objHeight,2));
			}
		}else {
			return Math.sqrt(Math.pow(imgDistance,2) + Math.pow(objHeight - imgHeight,2));
		}
	}

	public static double calculateRay2PrimaryLength(double objDistance, double objHeight) {
		return Math.sqrt(Math.pow(objHeight,2) + Math.pow(objDistance,2));
	}

	public static double calculateRay2RefractedLength(double imgDistance, double imgHeight, String lensType, String imgType) {
		if(lensType.equals("Converging") && imgType.equals("Real")) {
			return Math.sqrt(Math.pow(imgDistance,2) + Math.pow(-imgHeight,2));
		}else {
			return 70;
		}
	}

	public static double calculateRay2VirtualLength(double imgDistance, double imgHeight, String lensType, String imgType) {
		if(lensType.equals("Converging") && imgType.equals("Virtual")) {
			return Math.sqrt(Math.pow(imgDistance,2) + Math.pow(imgHeight,2));
		}else {
			return 0;
		}
	}

	public static double calculateRay3PrimaryLength(double imgHeight, double objDistance, double objHeight, String lensType, String imgType) {
		if(lensType.equals("Converging")) {
			if(imgType.equals("Real")) {
				return Math.sqrt(Math.pow(objDistance,2) + Math.pow(-imgHeight + objHeight,2));
			}else {
				return Math.sqrt(Math.pow(objDistance,2) + Math.pow(imgHeight - objHeight,2));
			}
		}else {
			return Math.sqrt(Math.pow(objDistance,2) + Math.pow(objHeight - imgHeight,2));
		}
	}

	public static double calculateRay3RefractedLength(double imgDistance, String lensType, String imgType) {
		if(lensType.equals("Converging") && imgType.equals("Real")) {
			return imgDistance;
		}else {
			return 70;
		}
	}

	public static double calculateRay3VirtualLength(double imgDistance, String lensType, String imgType) {
		if(lensType.equals("Converging") && imgType.equals("Real")) {
			return 0;
		}else {
			return -imgDistance;
		}
	}

	public static double calculateRay1Angle(double objHeight, double focalLength, String lensType) {
		if(lensType.equals("Converging")) {
			if(objHeight >=0) {
				return 90 - Math.toDegrees(Math.atan(focalLength / objHeight));
			}else {
				return 270 + Math.toDegrees(Math.atan(focalLength / -objHeight));
			}
		}else {
			if(objHeight >0) {
				return 270 + Math.toDegrees(Math.atan(-focalLength / objHeight));
			}
			return 90 - Math.toDegrees(Math.atan(-focalLength / -objHeight));
		}
	}

	public static double calculateRay2Angle(double objHeight, double objDistance) {
		return Math.toDegrees(Math.atan(objHeight / objDistance));
	}

	public static double calculateRay3Angle(double objHeight, double objDistance, double imgHeight, String lensType, String imgType) {
		if(lensType.equals("Converging")) {
			if(imgType.equals("Real")) {
				return Math.toDegrees(Math.atan((objHeight + -imgHeight) / objDistance));
			}else {
				return -Math.toDegrees(Math.atan((imgHeight - objHeight) / objDistance));
			}
		}else {
			return Math.toDegrees(Math.atan((objHeight - imgHeight) / objDistance));
		}
	}

	public static double calculateRay3NextYStartPos(double objHeight, double imgHeight, String lensType, String imgType) {
		if(lensType.equals("Converging")) {
			if(imgType.equals("Real")) {
				return objHeight + -imgHeight;
			}else {
				return objHeight - imgHeight;
			}
		}else {
			return objHeight - imgHeight;
		}
	}

}
