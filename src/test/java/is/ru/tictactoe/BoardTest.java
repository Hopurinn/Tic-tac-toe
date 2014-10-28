package is.ru.tictactoe;

import static org.junit.Assert.*;
import org.junit.Test;

public class BoardTest {
	public void main(String args[]) {
		org.junit.runner.JUnitCore.main("is.ru.tictactoe.BoardTest");
	}

	private Board board = new Board();

	@Test
	public void testDrawBoard() {
		assertEquals(" | 1 | 2 | 3 | \n  --- --- --- \n | 4 | 5 | 6 | \n  --- --- --- \n | 7 | 8 | 9 | ", board.drawBoard());
	}

	@Test
	public void testCheckPosition() {
		Board board = new Board();
		assertEquals(true, board.checkPosition(2,2));
	}

	@Test
	public void testUpdateBoard() {
		assertEquals('X', board.updateBoard(2,2));
	}

	@Test
	public void testCheckForWin() {
		assertEquals('D', board.checkForWin());	
	}

	@Test
	public void testCheckRows() {
		assertEquals('D', board.checkRows());
	}

	@Test
	public void testCheckColumns() {
		assertEquals('D', board.checkColumns());
	}
}
