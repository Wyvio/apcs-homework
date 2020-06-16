// Stuart Reges
// 9/6/00
//
// StudentMain provides method main for a simple simulation program.

// Jolie Zhou
// Mr. Peterson
// Period 2 APCS
// This project is inspired by Nicky Case's Evolution of Trust (https://ncase.me/trust/).
// Four types of students play rock paper scissors and after 10 rounds are played
// anywhere, the student with the lowest score is eliminated until only one student
// remains.
// This project is probably only fun to write and boring to watch, haha!
// The "matches" will be printed in the console. :)

public class StudentMain {
	public static void main(String[] args) {
		StudentFrame frame = new StudentFrame(30, 15);

		frame.add(5, "Freshman");
		frame.add(5, "Sophmore");
		frame.add(5, "Junior");
		frame.add(5, "Senior");

		frame.start();
	}
}
