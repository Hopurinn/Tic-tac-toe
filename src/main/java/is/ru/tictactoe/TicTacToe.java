package is.ru.tictactoe;

import java.util.Scanner;

public class TicTacToe {
	// scanner to determine if the player wishes to play again
	private static Scanner input = new Scanner(System.in);

	// main
	public static void main(String[] args) {
		char c;
		do {
			// runs the game
			Game.run();
			System.out.println("Do you want to play again?(y/n)");
			c = input.next().charAt(0);
		// runs until the user choses to quit (n)
		} while(c == 'y');
		System.out.println("BYE! Thanks for playing, looking forward to seeing you again next time");
	}
}
