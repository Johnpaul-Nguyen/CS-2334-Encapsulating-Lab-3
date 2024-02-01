
public class Triangle {
	
	private double sideA;
	private double sideB;
	private double sideC;
	
	public static final String POLYGONSHAPE = "Triangle";
	public static final double DEFAULT_SIDE = 1;
	
	public Triangle() {
		sideA = DEFAULT_SIDE;
		sideB = DEFAULT_SIDE;
		sideC = DEFAULT_SIDE;
	}
	public Triangle(double sideA, double sideB, double sideC) {
		
		if (sideA > 0 && sideB > 0 && sideC > 0) {
			if(isTriangle(sideA, sideB, sideC)) {
				this.sideA = sideA;
				this.sideB = sideB;
				this.sideC = sideC;
			}
			else {
				this.sideA = DEFAULT_SIDE;
				this.sideB = DEFAULT_SIDE;
				this.sideC = DEFAULT_SIDE;
			}
		}
		else {
			this.sideA = DEFAULT_SIDE;
			this.sideB = DEFAULT_SIDE;
			this.sideC = DEFAULT_SIDE;
		}
		
		
	}
	public Triangle(double[] sides) {
		
		if(sides == null) {
			sideA = DEFAULT_SIDE;
			sideB = DEFAULT_SIDE;
			sideC = DEFAULT_SIDE;
		}
		else if(sides.length != 3) {
			sideA = DEFAULT_SIDE;
			sideB = DEFAULT_SIDE;
			sideC = DEFAULT_SIDE;
		}
		else {
			double sideA = 0;
			double sideB = 0;
			double sideC = 0;
			
			for(int i = 0; i < sides.length; i++) {
				
				if (sides[i] <= 0) {
					this.sideA = DEFAULT_SIDE;
					this.sideB = DEFAULT_SIDE;
					this.sideC = DEFAULT_SIDE;
					break;
				}
				else {
					switch(i) {
					case 0: sideA = sides[i];
					break;
					case 1: sideB = sides[i];
					break;
					case 2: sideC = sides[i];
					break;
					}
				}
			}
			if(isTriangle(sides)) {
				this.sideA = sideA;
				this.sideB = sideB;
				this.sideC = sideC;
			}
			else {
				this.sideA = DEFAULT_SIDE;
				this.sideB = DEFAULT_SIDE;
				this.sideC = DEFAULT_SIDE;
			}
		}
	}
	public Triangle(Triangle triangle) {
		if(triangle == null || !isTriangle(triangle.getSideA(), triangle.getSideB() ,triangle.getSideC())) {
			sideA = DEFAULT_SIDE;
			sideB = DEFAULT_SIDE;
			sideC = DEFAULT_SIDE;
		}
		else {
			sideA = triangle.getSideA();
			sideB = triangle.getSideB();
			sideC = triangle.getSideC();
		}
	}
	
	public double getSideA() {
		return this.sideA;
	}
	public double getSideB() {
		return this.sideB;
	}
	public double getSideC() {
		return this.sideC;
	}
	public double[] getSides() {
		double[] arr = {this.sideA, this.sideB, this.sideC};
		return arr;
	}
	
	public double getAngleA() {
		return lawOfCosines(sideB, sideC, sideA);
	}
	public double getAngleB() {
		return lawOfCosines(sideA, sideC, sideB);
	}
	public double getAngleC() {
		return lawOfCosines(sideA, sideB, sideC);
	}
	public double[] getAngles() {
		double[] result = {getAngleA(), getAngleB(), getAngleC()};
		return result;
	}
	
	public boolean setSideA(double sideA) {
		if (sideA > 0) {
			if (isTriangle(sideA, this.sideB, this.sideC)) {
				this.sideA = sideA;
				return true;
			}
		}
		return false;
	}
	public boolean setSideB(double sideB) {
		if (sideB > 0) {
			if (isTriangle(this.sideA, sideB, this.sideC)) {
				this.sideB = sideB;
				return true;
			}
		}
		return false;
	}
	public boolean setSideC(double sideC) {
		if (sideC > 0) {
			if (isTriangle(this.sideA, this.sideB, sideC)) {
				this.sideC = sideC;
				return true;
			}
		}
		return false;
	}
	public boolean setSides(double[] sides) {
		if(isTriangle(sides)) {
			this.sideA = sides[0];
			this.sideB = sides[1];
			this.sideC = sides[2];
			return true;
		}
		return false;
	}
	
	public static boolean isTriangle(double a, double b, double c) {
		if ((a > 0) && (b > 0) && (c > 0)) {
			if (a + b > c && b + c > a && a + c > b) {
				return true;
			}
		}
		return false;
	}
	public static boolean isTriangle(double[] sides){
		int a = 0;
		int b = 1;
		int c = 2;
		
		if (sides == null) {
			return false;
		}
		else if (sides.length == 3) {
			if ((sides[a] > 0) && (sides[b] > 0) && (sides[c] > 0)) {
				if ((sides[a] + sides[b] > sides[c]) && (sides[b] + sides[c] > sides[a]) && (sides[a] + sides[c] > sides[b])) {
					return true;
				}
			}
		}
		return false;
	}
	public static double lawOfCosines(double a, double b, double c) {
		return Math.toDegrees(Math.acos((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b)));
	}
	public String toString() {
		String formattedA = String.format("%.4f", sideA);
		String formattedB = String.format("%.4f", sideB);
		String formattedC = String.format("%.4f", sideC);

		return POLYGONSHAPE + "(" + formattedA + ", " + formattedB + ", " + formattedC + ")";
	}
}
