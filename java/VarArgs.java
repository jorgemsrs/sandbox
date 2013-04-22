
class VarArgs {
	static public void main(String[] args) {
		acceptVarargs(1,2,3,4,5);
		acceptVarargs(new double[] {6,7,8,9,10});
		acceptArray(new double[] {6,7,8,9,10});
	}

	static void acceptVarargs(double ... args) {
		for (double num : args) {
			System.out.println("Varargs: " + num);
		}
	}

	static void acceptArray(double [] args) {
		for (double num : args) {
			System.out.println("Array: " + num);
		}
	}

}