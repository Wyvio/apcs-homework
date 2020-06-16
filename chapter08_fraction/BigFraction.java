
/* Jolie Zhou
 * Mr. Peterson
 * APCS Period 2
 * 17 January 2020
 * 
 * This class creates a BigFraction object, with fields and methods (behaviors) representing that of a mathematical fraction.
 * The use of java.math.BigInteger allows for fractions with longer numbers.
 */
import java.math.BigInteger;

public class BigFraction {
	// Fields
	private BigInteger numerator;
	private BigInteger denominator;

	// Constructors
	public BigFraction(BigInteger numerator, BigInteger denominator) {
		this.initialize(numerator, denominator);
	}

	public BigFraction(BigInteger wholeNumber) {
		this.initialize(wholeNumber, BigInteger.ONE);
	}

	public BigFraction(String improperFraction) {
		BigInteger numerator = BigInteger.ONE;
		BigInteger denominator = BigInteger.ONE;

		String temp = "";
		for (int i = 0; i < improperFraction.length(); i++) {
			temp += improperFraction.charAt(i);

			// Sets the numerator if counter is less than total length
			if (i < improperFraction.length() - 1 && improperFraction.substring(i + 1, i + 2).equals("/")) {
				numerator = numerator.multiply(new BigInteger(temp));
				i++;
				temp = "";
			}
		}
		// Sets the denominator
		denominator = new BigInteger(temp);

		this.initialize(numerator, denominator);
	}

	// All constructors call initialize
	private void initialize(BigInteger numerator, BigInteger denominator) {
		if (denominator.equals(BigInteger.ZERO)) {
			throw new IllegalArgumentException("Denominator cannot be 0");
		}
		this.setNumerator(numerator);
		this.setDenominator(denominator);
		this.reduce();
	}

	// Encapsulation: Getters and Setters
	public BigInteger getNumerator() {
		return numerator;
	}

	private void setNumerator(BigInteger numerator) {
		this.numerator = numerator;
	}

	public BigInteger getDenominator() {
		return denominator;
	}

	private void setDenominator(BigInteger denominator) {
		this.denominator = denominator;
	}

	// Simplifying the fraction (accessed in initializing)
	private void reduce() {
		// If denominator neg., switch signs
		boolean denoNeg = denominator.compareTo(BigInteger.ZERO) < 0;

		if (denoNeg) {
			numerator = numerator.negate();
			denominator = denominator.negate();
		}

		// Faster than original method (Loops until denominator value)
		// Loops until gcd value is 1; divide by the gcd
		BigInteger gcd = denominator.gcd(numerator);
		numerator = numerator.divide(gcd);
		denominator = denominator.divide(gcd);
		while (gcd.compareTo(BigInteger.ONE) > 1) {
			numerator = numerator.divide(gcd);
			denominator = denominator.divide(gcd);
			gcd = denominator.gcd(numerator);
		}
	}

	// Mathematical operations
	public BigFraction add(BigFraction fraction) {
		BigInteger numerator = this.getNumerator().multiply(fraction.getDenominator())
				.add(fraction.getNumerator().multiply(this.getDenominator()));
		BigInteger denominator = this.getDenominator().multiply(fraction.getDenominator());

		return new BigFraction(numerator, denominator);
	}

	public BigFraction subtract(BigFraction fraction) {
		BigInteger numerator = this.getNumerator().multiply(fraction.getDenominator())
				.subtract(fraction.getNumerator().multiply(this.getDenominator()));
		BigInteger denominator = this.getDenominator().multiply(fraction.getDenominator());

		return new BigFraction(numerator, denominator);
	}

	public BigFraction multiply(BigFraction fraction) {
		BigInteger numerator = this.getNumerator().multiply(fraction.getNumerator());
		BigInteger denominator = this.getDenominator().multiply(fraction.getDenominator());

		return new BigFraction(numerator, denominator);
	}

	public BigFraction divide(BigFraction fraction) {
		if (fraction.getNumerator().equals(BigInteger.ZERO) || fraction.getDenominator().equals(BigInteger.ZERO)) {
			throw new IllegalArgumentException("Cannot divide by 0");
		}

		BigInteger numerator = this.getNumerator().multiply(fraction.getDenominator());
		BigInteger denominator = this.getDenominator().multiply(fraction.getNumerator());

		return new BigFraction(numerator, denominator);
	}

	// other standard methods
	public String toString() {
		if (this.getDenominator().equals(BigInteger.ONE)) {
			return this.getNumerator() + "";
		} else {
			return this.getNumerator() + "/" + this.getDenominator();
		}
	}

	public String toMixedNumberString() {
		BigInteger whole = numerator.divide(denominator);
		BigInteger numerator = this.getNumerator().subtract(whole.multiply(denominator));
		BigInteger denominator = this.getDenominator();

		if (whole.compareTo(BigInteger.ZERO) != 0 && numerator.abs().compareTo(BigInteger.ZERO) > 0) {
			return whole + "_" + new BigFraction(numerator.abs(), denominator).toString();
		} else if (denominator.abs().compareTo(BigInteger.ONE) == 0) {
			return whole + "";
		} else {
			return new BigFraction(numerator, denominator).toString();
		}
	}

	public int compareTo(BigFraction fraction) {
		BigInteger thisNumerator = this.getNumerator().multiply(fraction.getDenominator());
		BigInteger otherNumerator = fraction.getNumerator().multiply(this.getDenominator());

		if (thisNumerator.compareTo(otherNumerator) < 0) {
			return -1;
		} else if (thisNumerator.equals(otherNumerator)) {
			return 0;
		} else {
			return 1;
		}
	}
}
