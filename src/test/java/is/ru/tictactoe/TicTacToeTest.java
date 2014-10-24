package is.ru.tictactoe;

import static org.junit.Assert.*;
import org.junit.Test;

public class TicTacToeTest {
	public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("is.ru.tictactoe.TicTacToeTest");
	}

	@Test
	public void testEmptyString() {
		assertEquals(1, TicTacToe.player(""));
	}
}
