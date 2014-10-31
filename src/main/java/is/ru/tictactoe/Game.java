package is.ru.tictactoe;

import java.util.Scanner;

// game class that runs the game
public class Game {
	// static scanner for reading in input
	static Scanner sc = new Scanner(System.in);

	public static void run() {
		// initialize an instance of the game board
		Board board = new Board();

		// boolean value to identify if the game has been won
		boolean gameWon = false;

		// initialize two players, their moves and a variable to identify draw
		char player1 = getPlayer();
		char player2 = getPlayer();
		int move = 0;
		int isDraw = 0;

		board.drawBoard();

		// a loop that continues untill someone has won
		while (!gameWon) {
			// loop to continue to ask the user for input
			// untill it is valid
			do {
			move = getMove(player1);
			} while (board.validateMove(move));

			isDraw++;
			// updates the board with the first players validated move
			board.updateBoard(player1, move);

			// checks if a player has won and saves it in gameWon
			gameWon = board.winnerFound(player1);

			// exits the loop if the game has been won or if 
			// there are no more moves to make
			if (gameWon || isDraw == 9)
				break;

			// repeated steps for player2
			do {
			move = getMove(player2);
			} while (board.validateMove(move));
			isDraw++;
			board.updateBoard(player2, move);

			gameWon = board.winnerFound(player2);
		}
		// print statements according to the game result
		if(board.winnerFound(player1)){
			char winner = board.findWinner(player1);
			System.out.println(winner + " wins");
		}
		else if (board.winnerFound(player1)){
			char winner = board.findWinner(player2);
			System.out.println(winner + " wins");
		}
		else {
			System.out.println("DRAW!");
		}
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
