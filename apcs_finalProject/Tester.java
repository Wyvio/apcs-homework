
public class Tester {

	private static final IEncrypt[] CIPHERS = { new CaesarCipher(), new VigenereCipher(), new RSA() };

	public static void main(String[] args) {
		for (IEncrypt x : CIPHERS) {
			test(x, "test");
			test(x, "TEST");
			test(x, "tEsT");
		}
	}

	public static void test(IEncrypt c, String test) {
		System.out.println(c);
		String pt = test;
		long encryptStartTime = System.nanoTime();
		String ct = c.encrypt(pt);
		long encryptEndTime = System.nanoTime();
		long decryptStartTime = System.nanoTime();
		String msg = c.decrypt(ct);
		long decryptEndTime = System.nanoTime();
		System.out.println("\tPlaintext: \t\t" + pt);
		System.out.println("\tCiphertext: \t\t" + ct);
		System.out.println("\tDecrypted Message: \t" + msg);
		System.out.println("\t\tEncryption Time: \t" + (encryptEndTime - encryptStartTime));
		System.out.println("\t\tDecryption Time: \t" + (decryptEndTime - decryptStartTime));
		System.out.println("\t\tTotal Elapsed Time: \t" + (decryptEndTime-encryptStartTime));
		System.out.println();
	}

}
