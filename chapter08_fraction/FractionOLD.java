/* Jolie Zhou
 * Mr. Peterson
 * APCS Period 2
 * 17 January 2020
 * 
 * This class creates a Fraction object, with fields and methods (behaviors) representing that of a mathematical fraction.
 * This code is less efficient.
 */
public class FractionOLD {
	// Fields
	private int numerator;
	private int denominator;

	// Constructors
	public FractionOLD(int numerator, int denominator) {
		this.initialize(numerator, denominator);
	}

	public FractionOLD(int wholeNumber) {
		this.initialize(wholeNumber, 1);
	}

	public FractionOLD(String improperFraction) {
		int numerator = 1;
		int denominator = 1;

		String temp = "";
		for (int i = 0; i < improperFraction.length(); i++) {
			temp += improperFraction.charAt(i);

			// Sets the numerator if counter is less than total length
			if (i < improperFraction.length() - 1 && improperFraction.substring(i + 1, i + 2).equals("/")) {
				numerator *= Integer.parseInt(temp);
				i++;
				temp = "";
			}
		}
		// Sets the denominator
		denominator = Integer.parseInt(temp);

		this.initialize(numerator, denominator);
	}

	// All constructors call initialize.
	private void initialize(int numerator, int denominator) {
		if (denominator == 0) {
			throw new IllegalArgumentException("Denominator cannot be 0");
		}
		this.setNumerator(numerator);
		this.setDenominator(denominator);
		this.reduce();
	}

	// Encapsulation: Getters and Setters
	public int getNumerator() {
		return numerator;
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}

	// Simplifying the fraction (accessed in initializing)
	private void reduce() {
		// If both terms are negative, change both to positive
		boolean bothNeg = numerator < 0 && denominator < 0;
		// If numerator pos. and denominator neg., switch signs
		boolean denoNeg = numerator > 0 && denominator < 0;

		// Adjust negative signs
		if (bothNeg || denoNeg) {
			numerator *= -1;
			denominator *= -1;
		}

		// Loops until denominator value, trying to find gcd and divide
		for (int i = 2; i <= denominator; i++) {
			if (numerator % i == 0 && denominator % i == 0) {
				numerator /= i;
				denominator /= i;
				i = 1;
			}
		}
	}

	// Mathematical operations
	// Adds two fractions and returns a fraction
	public FractionOLD add(FractionOLD fraction) {
		int numerator = this.getNumerator() * fraction.getDenominator()
				+ fraction.getNumerator() * this.getDenominator();
		int denominator = this.getDenominator() * fraction.getDenominator();

		return new FractionOLD(numerator, denominator);
	}

	// Subtracts two fractions and returns a fraction
	public FractionOLD subtract(FractionOLD fraction) {
		int numerator = this.getNumerator() * fraction.getDenominator()
				- fraction.getNumerator() * this.getDenominator();
		int denominator = this.getDenominator() * fraction.getDenominator();

		return new FractionOLD(numerator, denominator);
	}

	// Multiplies two fractions and returns a new fraction
	public FractionOLD multiply(FractionOLD fraction) {
		int numerator = this.getNumerator() * fraction.getNumerator();
		int denominator = this.getDenominator() * fraction.getDenominator();

		return new FractionOLD(numerator, denominator);
	}

	// Divides two fractions and returns a new fraction
	public FractionOLD divide(FractionOLD fraction) {
		if (fraction.getNumerator() == 0 || fraction.getDenominator() == 0) {
			throw new IllegalArgumentException("Cannot divide by 0");
		}

		int numerator = this.getNumerator() * fraction.getDenominator();
		int denominator = this.getDenominator() * fraction.getNumerator();

		return new FractionOLD(numerator, denominator);
	}

	// Other standard methods
	// Returns Fraction to String (improper fraction) x/x
	public String toString() {
		if (this.getDenominator() == 1) {
			return this.getNumerator() + "";
		} else {
			return this.getNumerator() + "/" + this.getDenominator();
		}
	}

	// Returns Fraction as mixed number x_x/x
	public String toMixedNumberString() {
		int number = 0;
		int numerator = this.getNumerator();
		int denominator = this.getDenominator();

		if (denominator != 1) {

			// Loop until numerator value less than denominator value to find whole values
			// For positive fractions
			while (numerator > denominator) {
				number++;
				numerator -= denominator;
			}

			// For negative fractions
			while (numerator < -1 * denominator) {
				number -= 1;
				numerator += denominator;
			}

		}

		// Choose appropriate formating if actual mixed number
		if (number > 0 || number < 0) {
			return number + "_" + new FractionOLD(Math.abs(numerator), denominator).toString();
		} else {
			return new FractionOLD(numerator, denominator).toString();
		}
	}

	// Returns -1 if less, 0 if equal, 1 if greater than
	public int compareTo(FractionOLD fraction) {
		int thisNumerator = this.getNumerator() * fraction.getDenominator();
		int otherNumerator = fraction.getNumerator() * this.getDenominator();

		if (thisNumerator < otherNumerator) {
			return -1;
		} else if (thisNumerator == otherNumerator) {
			return 0;
		} else {
			return 1;
		}
	}
}
