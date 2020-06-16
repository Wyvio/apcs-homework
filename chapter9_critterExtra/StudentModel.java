
// Stuart Reges
// 1/26/00
//
// Class StudentModel keeps track of the state of the critter simulation.

import java.util.*;
import java.awt.*;

public class StudentModel {
	private int myHeight;
	private int myWidth;
	private Student[][] myGrid;
	private char[][] display;
	private Map<Student, Point> myList;
	private SortedMap<String, Integer> critterCount;

	private ArrayList<Student> studentScores;
	private int turnsCounter = 0;

	public StudentModel(int width, int height) {
		myWidth = width;
		myHeight = height;
		myGrid = new Student[width][height];
		display = new char[width][height];
		updateDisplay();
		myList = new HashMap<Student, Point>();
		critterCount = new TreeMap<String, Integer>();
		studentScores = new ArrayList<Student>();
	}

	public void add(int number, Class critter) {
		if (myList.size() + number > myWidth * myHeight)
			throw new RuntimeException("adding too many critters");
		for (int i = 0; i < number; i++) {
			Object instance;
			try {
				instance = critter.newInstance();
			} catch (Exception e) {
				throw new RuntimeException("no zero-argument constructor for " + critter);
			}
			if (!(instance instanceof Student)) {
				throw new RuntimeException(critter + " does not implement Student");
			}
			Student next = (Student) instance;
			int x, y;
			do {
				x = randomInt(0, myWidth - 1);
				y = randomInt(0, myHeight - 1);
			} while (myGrid[x][y] != null);
			myGrid[x][y] = next;
			display[x][y] = next.getChar();
			myList.put(next, new Point(x, y));

			// Add in all the students' existence O_o
			studentScores.add(next);
		}
		String name = critter.getName();
		if (!critterCount.containsKey(name))
			critterCount.put(name, number);
		else
			critterCount.put(name, critterCount.get(name) + number);

	}

	private static int randomInt(int low, int high) {
		return low + (int) (Math.random() * (high - low + 1));
	}

	public int getWidth() {
		return myWidth;
	}

	public int getHeight() {
		return myHeight;
	}

	public char getChar(int x, int y) {
		return display[x][y];
	}

	// We want to ask each critter once on each round how to display it.
	// This method does the asking, storing the result in display.
	private void updateDisplay() {
		// set it to all dots
		for (int x = 0; x < myWidth; x++)
			for (int y = 0; y < myHeight; y++)
				if (myGrid[x][y] == null)
					display[x][y] = '.';
				else
					display[x][y] = myGrid[x][y].getChar();
	}

	public void update() {
		class SortByScore implements Comparator<Student> {

			@Override
			public int compare(Student arg0, Student arg1) {
				if (arg0.getScore() > arg1.getScore())
					return 1;
				else if (arg0.getScore() < arg1.getScore())
					return -1;
				else
					return 0;
			}

		}
		studentScores.sort(new SortByScore());
		Student[][] newGrid = new Student[myWidth][myHeight];
		Object[] list = myList.keySet().toArray();
		Collections.shuffle(Arrays.asList(list));

		ArrayList<Student> alreadyCalculated = new ArrayList<Student>(); // array of students that already had their
																			// match results (resolves duplicate tie
																			// issue)
		for (int i = 0; i < list.length; i++) {
			Student next = (Student) list[i]; // "this" student
			Point p = myList.get(next);
			int move = next.getMove(new Info(p.x, p.y));
			movePoint(p, move);
			if (newGrid[p.x][p.y] != null) { // If there is a collision...
				turnsCounter++;
				Student enemy = newGrid[p.x][p.y]; // Opponent student

				int nextPlay = next.getPlay();
				int enemyPlay = enemy.getPlay();

				String nextPlayS = nextPlay == 0 ? "rock" : nextPlay == 1 ? "paper" : "scissors";
				String enemyPlayS = enemyPlay == 0 ? "rock" : enemyPlay == 1 ? "paper" : "scissors";

				if ((nextPlay == enemyPlay + 1) || (nextPlay == 0 && enemyPlay == 2)) {
					// This student won the round.
					next.won();

					System.out.println("The " + next.getClass().getName() + " won against the "
							+ enemy.getClass().getName() + "; \tplayed " + nextPlayS + " to " + enemyPlayS);

				} else if (!(nextPlay == enemyPlay)) { // Will be enemy win going through list
					turnsCounter--; // Prevent double increment
					// If student is a JUNIOR: change play to last winning play (enemy's)
					if (next instanceof Junior) {
						((Junior) next).setPlay(enemyPlay);
					}
				} else if (!alreadyCalculated.contains(next)) {// It's a tie
					// BUG: Enemy will count tie too, so double increment
					System.out.println("It's a tie between the " + next.getClass().getName() + " and the "
							+ enemy.getClass().getName() + "; " + nextPlayS + " to " + enemyPlayS);
					alreadyCalculated.add(enemy);

				}

				// If student is a SOPHMORE: change play to opponent's last play
				if (next instanceof Sophmore) {
					((Sophmore) next).setPlay(enemyPlay);
				}
			}

			// If 10 rounds total have passed...
			if (turnsCounter > 10) {
				// Eliminate a student if they match with lowest score
				studentScores.sort(new SortByScore());

				System.out.println("10 Rounds!");
				for (int x = 0; x < list.length; x++) {
					Student check = (Student) list[x]; // "this" student
					if (check.getScore() == studentScores.get(0).getScore()
							&& check.getClass() == studentScores.get(0).getClass()) {
						// Removes student's score
						studentScores.remove(0);

						// Removes this student.
						critterCount.put(check.getClass().getName(), critterCount.get(check.getClass().getName()) - 1);
						myList.remove(check);
						list = myList.keySet().toArray();

						System.out.println("Eliminated: " + check.getClass().getName());

						x = list.length;
					}
				}

				turnsCounter = 0;
			}
			newGrid[p.x][p.y] = next;
		}
		myGrid = newGrid;
		updateDisplay();
	}

	public Set<Map.Entry<String, Integer>> getCounts() {
		return Collections.unmodifiableSet(critterCount.entrySet());
	}

	// translates a point's coordinates 1 unit in a particular direction
	private void movePoint(Point p, int direction) {
		if (direction == Student.NORTH)
			p.y = (p.y + myHeight - 1) % myHeight;
		else if (direction == Student.SOUTH)
			p.y = (p.y + 1) % myHeight;
		else if (direction == Student.EAST)
			p.x = (p.x + 1) % myWidth;
		else if (direction == Student.WEST)
			p.x = (p.x + myWidth - 1) % myWidth;
		else if (direction != Student.CENTER)
			throw new RuntimeException("Illegal direction");
	}

	// an object used to query a critter's state (position, neighbors)
	private class Info implements StudentInfo {
		private int x;
		private int y;

		public Info(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public char getNeighbor(int direction) {
			Point other = new Point(x, y);
			movePoint(other, direction);
			return display[other.x][other.y];
		}

		public int getHeight() {
			return myHeight;
		}

		public int getWidth() {
			return myWidth;
		}
	}
}
