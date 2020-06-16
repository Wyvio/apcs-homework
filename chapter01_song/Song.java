//Jolie Zhou, APCS Peterson P2
//Programming Assignment #1, 09/11/19

package songProgram;

public class Song{

	public static void main(String[] args) {
		verse1();
		verse2();
		verse3();
		verse4();
		verse5();
		verse6();
	}
	
	// The 5 methods below are animal sounds that are repeated throughout the song.
	// Some sounds call other sounds, so methods call other methods.
	
	public static void catSound() {
		System.out.println("Cat goes fiddle-i-fee.");
	}
	
	public static void henSound() {
		System.out.println("Hen goes chimmy-chuck, chimmy-chuck,");
		catSound();
	}
	
	public static void duckSound() {
		System.out.println("Duck goes quack, quack,");
		henSound();
	}
	
	public static void gooseSound() {
		System.out.println("Goose goes hissy, hissy,");
		duckSound();
	}
	
	public static void sheepSound() {
		System.out.println("Sheep goes baa, baa,");
		gooseSound();
	}
	
	// All methods below the section are verses.
	
	public static void verse1() {
		System.out.println("Bought me a cat and the cat pleased me,");
		System.out.println("I fed my cat under yonder tree.");
		catSound();
	}
	
	public static void verse2() {
		System.out.println("\nBought me a hen and the hen pleased me,");
		System.out.println("I fed my hen under yonder tree.");
		henSound();
	}
	
	public static void verse3() {
		System.out.println("\nBought me a duck and the duck pleased me,");
		System.out.println("I fed my duck under yonder tree.");
		duckSound();
	}
	
	public static void verse4() {
		System.out.println("\nBought me a goose and the goose pleased me,");
		System.out.println("I fed my goose under yonder tree.");
		gooseSound();
	}
	
	public static void verse5() {
		System.out.println("\nBought me a sheep and the sheep pleased me,");
		System.out.println("I fed my sheep under yonder tree.");
		sheepSound();
	}
	
	public static void verse6() {
		System.out.println("\nBought me a pig and the pig pleased me,");
		System.out.println("I fed my pig under yonder tree.");
		
		//The pig sound will not use a method because it is only used once.
		System.out.println("Pig goes oink, oink,");
		sheepSound();
	}
}
