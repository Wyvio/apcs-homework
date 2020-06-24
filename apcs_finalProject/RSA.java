
/**
 * 
 * @author s-zhoujo
 *
 *         Modern; Asymmetric
 *         </p>
 *         RSA encrypts plaintext using asymmetric RSA encryption, generating 
 *         public and private keys to encrypt and decrypt a message.
 */
import java.math.*;

public class RSA implements IEncrypt {

	private BigInteger n; // modulus
	private BigInteger e; // public key
	private BigInteger d; // private key

	public RSA() {

		BigInteger p = BigInteger.valueOf(IEncrypt.nextRandPrime());
		BigInteger q = BigInteger.valueOf(IEncrypt.nextRandPrime());

		BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));

		n = p.multiply(q);
		e = BigInteger.valueOf(IEncrypt.nextRandCoprime(phi.intValue()));
		d = e.modInverse(phi);
	}

	/**
	 * Encryption Process:
	 * </p>
	 * 1) Converts String plaintext -> byte[] -> BigInteger
	 * </p>
	 * 2) Power of public key, mod modulus
	 * 
	 * @param String plaintext
	 * @return String ciphertext
	 */
	@Override
	public String encrypt(String plaintext) {
		byte[] bytes = plaintext.getBytes();
		BigInteger code = new BigInteger(bytes);

		// CHECK: if check fails, encryption will not work properly
		if (code.compareTo(n) > 0) {
			throw new RuntimeException("modulus is too small");
		}

		BigInteger ciphertext = code.modPow(e, n);

		return ciphertext.toString();
	}

	/**
	 * Decryption Process:
	 * </p>
	 * 1) Converts String ciphertext (with content of BigInteger) -> BigInteger
	 * </p>
	 * 2) Power of private key, mod modulus
	 * </p>
	 * 3) BigInteger -> byte[] -> String
	 * 
	 * @param String ciphertext
	 * @return String plaintext
	 */
	@Override
	public String decrypt(String ciphertext) {
		BigInteger code = new BigInteger(ciphertext);
		BigInteger decoded = code.modPow(d, n);
		String msg = new String(decoded.toByteArray());

		return msg;
	}

	public String toString() {
		return this.getClass().getName() + "\t\tPublic:\t" + e + "\n\t\tPrivate:" + d + "\n\t\tModulus:" + n;
	}

}
