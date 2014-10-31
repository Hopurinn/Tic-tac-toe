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
		int isDraw = 0;
		board.drawBoard();
		while (!gameWon) {
			do {
			move = getMove(player1);
			} while (board.validateMove(move));
			isDraw++;
			board.updateBoard(player1, move);

			gameWon = board.winnerFound();

			if (gameWon || isDraw == 9)
				break;

			do {
			move = getMove(player2);
			} while (board.validateMove(move));
			isDraw++;
			board.updateBoard(player2, move);

			gameWon = board.winnerFound();
		}
		if(isDraw == 9){
			System.out.println("DRAW!");
		}
		else{
			char winner = board.findWinner();
			System.out.println(winner + " wins");
		}
	}

	public static int getMove(char player) {
		System.out.print("Make Your Move " + player + " :");
		int move = sc.nextInt();

		return move;
	}

	public static char getPlayer() {
		System.out.print("What Character Do You Want To Be: ");
		char player = sc.next().charAt(0);

		return player;
	}
}
