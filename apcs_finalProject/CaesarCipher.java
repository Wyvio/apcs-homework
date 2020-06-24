
/**
 * 
 * @author s-zhoujo
 *
 *         Historical; Symmetric
 *         </p>
 *         CaesarCipher encrypts plaintext using the Caesar Cipher, rotating
 *         letters around the alphabet.
 */

public class CaesarCipher implements IEncrypt {

	public int shift;

	public CaesarCipher() {
		this(IEncrypt.nextRandInt() % 25);
	}

	public CaesarCipher(int shift) {
		this.shift = shift;
	}

	@Override
	public String encrypt(String plaintext) {
		return this.encrypt(plaintext, this.shift);

	}

	private String encrypt(String plaintext, int shift) {
		String result = "";

		for (int i = 0; i < plaintext.length(); i++) {
			char c = plaintext.charAt(i);

			if (Character.isLowerCase(c)) {
				c = (char) ((c - 'a' + shift) % 26 + 'a');
			} else if (Character.isUpperCase(c)) {
				c = (char) ((c - 'A' + shift) % 26 + 'A');
			}

			result += c;
		}

		return result;
	}

	@Override
	public String decrypt(String ciphertext) {
		return this.encrypt(ciphertext, 26 - this.shift);

	}

	@Override
	public String toString() {
		return this.getClass().getName() + "\tShift:\t" + this.shift;
	}
}
