/*
 * Create a quilt from a given "block" pattern, vertically flipping the block on every other patch
 */
public class BuggyQuilt {

	public static void main(String[] args) {

		char[][] myBlock = { { 'x', '.', '.', '.', '.' }, { 'x', '.', '.', '.', '.' }, { 'x', '.', '.', '.', '.' },
				{ 'x', 'x', 'x', 'x', 'x' } };
		char[][] myQuilt = new char[3 * myBlock.length][4 * myBlock[0].length];

		createQuilt(myQuilt, myBlock);

		displayPattern(myQuilt);
	}

	public static void displayPattern(char[][] myArray) {
		for (int r = 0; r < myArray.length; r++) {
			for (int c = 0; c < myArray[0].length; c++) {
				// BUG: prints column (as row) and row (as column)
				// FIX: swap values to myArray[r][c]
				System.out.print(myArray[r][c]);
			}
			// BUG: no spacing for rows
			// FIX: println
			System.out.println();
		}
	}

	public static void createQuilt(char[][] quilt, char[][] block) {
		char[][] flippedBlock = createFlipped(block);

		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 4; c++) {
				if (((r + c) % 2) == 0) {
					// BUG: third parameter is row, not column
					// FIX: swap to follow the else clause
					placeBlock(quilt, block, r * block.length, c * block[0].length);
				} else {
					// BUG: quilt and flippedBlock are in the wrong parameter values
					// FIX: swap to follow the if clause
					placeBlock(quilt, flippedBlock, r * block.length, c * block[0].length);
				}
			}
		}
	}

	public static void placeBlock(char[][] quilt, char[][] block, int startRow, int startCol) {
		for (int r = 0; r < block.length; r++) {
			// BUG: ArrayIndexOutOfBounds for c
			// FIX: c < block[r].length
			for (int c = 0; c < block[r].length; c++) {
				quilt[r + startRow][c + startCol] = block[r][c];
			}
		}
	}

	public static char[][] createFlipped(char[][] block) {
		// BUG: rows and cols are both getting length of rows
		// FIX: change blockCols to block[0].length
		int blockRows = block.length;
		int blockCols = block[0].length;
		char[][] flipped = new char[blockRows][blockCols];

		int flippedRow = blockRows;
		for (int row = 0; row < blockRows; row++) {
			for (int col = 0; col < blockCols; col++)
				// BUG: flippedRow is constant and out of bounds and not doing anything
				// FIX: flippedRow - 1 - rowto flip the order
				flipped[flippedRow - 1 - row][col] = block[row][col];
		}

		return flipped;
	}
}
