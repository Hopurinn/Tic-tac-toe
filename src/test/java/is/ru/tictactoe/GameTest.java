package is.ru.tictactoe;

import static org.junit.Assert.*;
import org.junit.Test;

public class GameTest {
        private Game game = new Game();

        public void main(String args[]) {
                org.junit.runner.JUnitCore.main("is.ru.tictactoe.GameTest");
        }

        @Test
	public void testMakeMove() {
		assertEquals("\"player1\"", game.makeMove(1));
	}
}
