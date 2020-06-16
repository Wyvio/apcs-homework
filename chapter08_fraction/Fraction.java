/* Jolie Zhou
 * Mr. Peterson
 * APCS Period 2
 * 17 January 2020
 * 
 * This class creates a Fraction object, with fields and methods (behaviors) representing that of a mathematical fraction.
 */
public class Fraction {
	// Fields
	private int numerator;
	private int denominator;

	// Constructors
	public Fraction(int numerator, int denominator) {
		this.initialize(numerator, denominator);
	}

	public Fraction(int wholeNumber) {
		this.initialize(wholeNumber, 1);
	}

	public Fraction(String improperFraction) {
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

	private void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	private void setDenominator(int denominator) {
		this.denominator = denominator;
	}

	// Simplifying the fraction (accessed in initializing)
	private void reduce() {
		// If the denominator is negative, switch signs
		boolean denoNeg = denominator < 0;
		// Adjust negative signs
		if (denoNeg) {
			numerator *= -1;
			denominator *= -1;
		}

		// Loops until gcd is 1
		for (int i = denominator; i > 1; i--) {
			if (numerator % i == 0 && denominator % i == 0) {
				numerator /= i;
				denominator /= i;
				i = denominator;
			}
		}
	}

	// Mathematical operations
	// Adds two fractions and returns a fraction
	public Fraction add(Fraction fraction) {
		int numerator = this.getNumerator() * fraction.getDenominator()
				+ fraction.getNumerator() * this.getDenominator();
		int denominator = this.getDenominator() * fraction.getDenominator();

		return new Fraction(numerator, denominator);
	}

	// Subtracts two fractions and returns a fraction
	public Fraction subtract(Fraction fraction) {
		int numerator = this.getNumerator() * fraction.getDenominator()
				- fraction.getNumerator() * this.getDenominator();
		int denominator = this.getDenominator() * fraction.getDenominator();

		return new Fraction(numerator, denominator);
	}

	// Multiplies two fractions and returns a new fraction
	public Fraction multiply(Fraction fraction) {
		int numerator = this.getNumerator() * fraction.getNumerator();
		int denominator = this.getDenominator() * fraction.getDenominator();

		return new Fraction(numerator, denominator);
	}

	// Divides two fractions and returns a new fraction
	public Fraction divide(Fraction fraction) {
		if (fraction.getNumerator() == 0 || fraction.getDenominator() == 0) {
			throw new IllegalArgumentException("Cannot divide by 0");
		}

		int numerator = this.getNumerator() * fraction.getDenominator();
		int denominator = this.getDenominator() * fraction.getNumerator();

		return new Fraction(numerator, denominator);
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
		int whole = numerator / denominator;
		int numerator = this.getNumerator() - whole * denominator;
		int denominator = this.getDenominator();

		// Choose appropriate formating if actual mixed number
		if (Math.abs(whole) == 0 && Math.abs(numerator) > 0) {
			return new Fraction(numerator, denominator).toString();
		} else if (Math.abs(denominator) == 1) {
			return whole + "";
		} else {
			return whole + "_" + new Fraction(Math.abs(numerator), denominator).toString();
		}
	}

	// Returns -1 if less, 0 if equal, 1 if greater than
	public int compareTo(Fraction fraction) {
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
