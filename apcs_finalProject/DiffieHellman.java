import java.math.BigInteger;

/**
 * 
 * @author s-zhoujo
 *
 *         Modern; Asymmetric
 *         </p>
 *         The Diffie-Hellman(-Merkle) Key Exchange establishes a shared secret
 *         between two parties. This class will model from p1's perspective.
 *         </p>
 *         UNUSED; INCOMPLETE
 */
public class DiffieHellman {

	private BigInteger p; // modulus
	private BigInteger g; // base
	private BigInteger p1; // party 1's private key
	private BigInteger p2; // party 2's private key

	public DiffieHellman() {
		p = BigInteger.valueOf(IEncrypt.nextRandPrime());
		g = BigInteger.valueOf(IEncrypt.nextRandCoprime(p.intValue()));
		
		p1 = BigInteger.valueOf(IEncrypt.nextRandInt());
		p2 = BigInteger.valueOf(IEncrypt.nextRandInt());
	}
	
	public String encrypt(String plaintext) {
		// TODO Auto-generated method stub
		return null;
	}

	public String decrypt(String ciphertext) {
		// TODO Auto-generated method stub
		return null;
	}

}
