package is.ru.tictactoe;

import static org.junit.Assert.*;
import org.junit.Test;

public class GameTest {
	public void main(String args[]) {
		org.junit.runner.JUnitCore.main("is.ru.tictactoe.GameTest");
	}

	@Test
	public void testRun() {
		assertEquals("Yey!", Game.run());
	}
}
