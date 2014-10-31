package is.ru.tictactoe;

import java.util.Scanner;

public class TicTacToe {
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		Game game = new Game();
		char c;
		do {
			game.run();
			System.out.println("Do you want to play again?(y/n)");
			c = input.next().charAt(0);
		} while(c == 'y');
	}
}
