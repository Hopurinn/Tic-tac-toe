import static org.junit.Assert.*;
import org.junit.Test;

public class BoardTest {
	public void main(String args[]) {
		org.junit.runner.JUnitCore.main("is.ru.tictactoe.BoardTest");
	}

	private Board board = new Board();	

	@Test
	public void drawBasicInitializedBoard() {
		assertEquals("1 2 3 \n 4 5 6 \n 7 8 9", Board.drawBoard());
	}	

	@Test
	public void updateBoard() {
		assertEquals('X', board.updateBoard(2));
	}
}
