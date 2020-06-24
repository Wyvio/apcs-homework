/**
 * 
 * @author s-zhoujo
 *
 *         Historical; Symmetric
 *         </p>
 *         ViegenereCipher encrypts plaintext using the polyalphabetic Vigenere
 *         Cipher, repeating through letters in a shift word to rotate letters
 *         around the alphabet.
 */

public class VigenereCipher implements IEncrypt {

	private String shiftWord;

	public VigenereCipher() {
		this("shift");
	}

	public VigenereCipher(String s) {
		this.shiftWord = s.toLowerCase();
	}

	@Override
	public String encrypt(String plaintext) {
		// Finds the shift for each letter of the given plaintext
		int[] shifts = new int[plaintext.length()];
		for (int i = 0; i < shifts.length; i++) {
			shifts[i] = shiftWord.charAt(i % shiftWord.length()) - 'a';
		}
		// Calls helper method to find ciphertext
		return this.encrypt(plaintext, shifts);
	}

	private String encrypt(String plaintext, int[] shifts) {
		String result = "";
		for (int i = 0; i < plaintext.length(); i++) {
			char c = plaintext.charAt(i);
			int shift = shifts[i];
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
		int[] shifts = new int[ciphertext.length()];
		for (int i = 0; i < shifts.length; i++) {
			shifts[i] = 26 - (shiftWord.charAt(i % shiftWord.length()) - 'a');
		}
		return this.encrypt(ciphertext, shifts);
	}

	@Override
	public String toString() {
		return this.getClass().getName() + "\tShift:\t" + this.shiftWord;
	}

}
