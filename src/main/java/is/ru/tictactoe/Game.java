package is.ru.tictactoe;

import java.util.Scanner;

public class Game {
	static Scanner sc = new Scanner(System.in);
	public static void run() {
		Board board = new Board();

		boolean gameWon = false;
		char player1 = getPlayer();
		char player2 = getPlayer();
		int move;

		board.drawBoard();
		while (!gameWon) {
			do {
			move = getMove();
			} while (board.checkPosition(move));
			board.updateBoard(player1, move);

			gameWon = board.checkForWin();

			if (gameWon)
				break;

			do {
			move = getMove();
			} while (board.checkPosition(move));
			board.updateBoard(player2, move);

			gameWon = board.checkForWin();
		}

		char winner = board.checkForWinner();
		System.out.println(winner + " wins");
	}

	public static int getMove() {
		System.out.print("Make Your Move: ");
		int move = sc.nextInt();

		return move;
	}

	public static char getPlayer() {
		System.out.print("What Character Do You Want To Be: ");
		char player = sc.next().charAt(0);

		return player;
	}
}
