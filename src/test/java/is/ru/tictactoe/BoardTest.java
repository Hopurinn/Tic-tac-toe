package is.ru.tictactoe;

import static org.junit.Assert.*;
import org.junit.Test;

public class BoardTest {
	public void main(String args[]) {
		org.junit.runner.JUnitCore.main("is.ru.tictactoe.BoardTest");
	}

	private Board board = new Board();

	
	
	
	

	@Test
	public void testCheckPosition() {
		Board board = new Board();
		assertEquals(true, board.checkPosition(2));
	}

	@Test
	public void testCheckRows() {
		assertEquals('D', board.checkRows());
	}

	@Test
	public void testCheckColumns() {
		assertEquals('D', board.checkColumns());
	}

	@Test
	public void testCheckDiagonal() {
		assertEquals('D', board.checkDiagonal());
	}
}
