
/**
 * 
 * @author s-zhoujo
 *
 *         IEncrypt is the interface all encryption algorithms will implement.
 * 
 */
import java.util.*;

public interface IEncrypt {

	/**
	 * Uses Random object to generate random integer.
	 * 
	 * @return integer (0 inclusive to 1000000 exclusive)
	 */
	static int nextRandInt() {
		return new Random().nextInt(1000000);
	}

	/**
	 * Uses IEncrypt.nextRandInt() to get random integer, checks if prime.
	 * 
	 * @return integer (Prime from 0 inclusive to 1000 exclusive)
	 */
	static int nextRandPrime() {
		int r = IEncrypt.nextRandInt();
		for (int x = 2; x < r; x++) {
			if (r % x == 0) {
				r = IEncrypt.nextRandInt();
				x = 2;
			}
		}
		//TEST: System.out.println(r);

		return r;
	}

	/**
	 * Uses IEncrypt.nextRandPrime() to get random prime, checks if coprime
	 * 
	 * @param integer number that returned integer will be coprime to
	 * @return integer (0 inclusive to 1000 exclusive)
	 */
	static int nextRandCoprime(int num) {
		int r = IEncrypt.nextRandPrime();

		while (num % r == 0) {
			r = IEncrypt.nextRandPrime();
		}
		// TEST: System.out.println("Coprime" + r + " to " + num);
		return r;
	}

	/**
	 * Methods that will be implemented
	 */
	public String encrypt(String plaintext);

	public String decrypt(String ciphertext);

}
