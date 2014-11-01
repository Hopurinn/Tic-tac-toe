package is.ru.tictactoe;

import java.util.Scanner;

// game class that runs the game
public class Game {
	// static scanner for reading in input
	static Scanner sc = new Scanner(System.in);

	static Board board;

	public static void run() {
		// initialize an instance of the game board
		board = new Board();

		// initialize two players, their moves and a variable to identify draw
		char player1 = getPlayer();
		char player2 = getPlayer();

		for (int i = 0; i < 9; i++) {
			if (play(player1)) {
				System.out.println(player1 + " wins!");
				return;
			}
			if (play(player2)) {
				System.out.println(player2 + " wins!");
				return;
			}
		}

		System.out.println("DRAW!");
	}

	// function that runs does players playturn
	public static boolean play(char player) {
		board.drawBoard();

		int move = 0;

		do {
                	move = getMove(player);
                } while (!board.isValidMove(move));

		board.updateBoard(player, move);

		return board.checkForWin(player);
	}

	// function that gets the players move and returns it
	public static int getMove(char player) {
		System.out.print("Make Your Move " + player + " :");
		int move = sc.nextInt();

		return move;
	}

	// function that gets the players identifyer and returns it
	public static char getPlayer() {
		System.out.print("What Character Do You Want To Be: ");
		char player = sc.next().charAt(0);

		return player;
	}
}
