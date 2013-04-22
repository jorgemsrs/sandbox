class Nan {
	static public void main(String[] args) {
		System.out.println( Double.NaN == Double.NaN );
		System.out.println( isNan(Double.NaN) );
		System.out.println( isNan(3) );
	}

	static boolean isNan(double n) {
		return n!=n;
	}
}