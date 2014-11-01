package is.ru.tictactoe;

import static org.junit.Assert.*;
import org.junit.Test;

public class BoardTest {
	private Board board = new Board();

	public void main(String args[]) {
		org.junit.runner.JUnitCore.main("is.ru.tictactoe.BoardTest");
	}

	@Test
	public void testBoard() {
		assertEquals('1', board.board[0][0]);
	}

	@Test
	public void testIsValidMove() {
		assertEquals(false, board.isValidMove(-1));
		assertEquals(false, board.isValidMove(10));
		assertEquals(true, board.isValidMove(2));
		board.board[1][1] = 'X';
		assertEquals(false, board.isValidMove(5));
		board.board[1][1] = '5';
	}

	@Test
	public void testFindRow() {
		assertEquals(0, board.findRow(1));
		assertEquals(1, board.findRow(6));
		assertEquals(2, board.findRow(8));
	}

	@Test
	public void testFindColumn() {
		assertEquals(0, board.findRow(1));
		assertEquals(1, board.findRow(5));
		assertEquals(2, board.findRow(9));
	}

	@Test
	public void testUpdateBoard() {
		board.updateBoard('o',1);
		assertEquals('o', board.board[0][0]);
	}

	@Test
	public void testWinnerFound() {
		assertEquals(false, board.winnerFound('O'));
	}

	@Test
	public void testFindWinner() {
		assertEquals('D', board.findWinner('O'));

		// test 2
		board.board[0][0] = 'X';
		board.board[1][0] = 'X';
		board.board[2][0] = 'X';
		assertEquals('X', board.findWinner('X'));
	}

	@Test
	public void testCheckRows() {
		assertEquals('D', board.checkRows('X'));
	}

	@Test
	public void testCheckColumns() {
		assertEquals('D', board.checkColumns('X'));
	}

	@Test
	public void testCheckDiagonal() {
		assertEquals('D', board.checkDiagonal('X'));
	}
}
