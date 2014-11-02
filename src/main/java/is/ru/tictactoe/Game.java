package is.ru.tictactoe;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

// game class that runs the game
public class Game {
	static Board board;
	static char player;

	public Game() {
		board = new Board();
		player = 'O';
	}

	public static void switchPlayer() {
		if (player == 'X')
			player = 'O';
		else
			player = 'X';
	}

	public static String makeMove(int id) {
		Gson gson = new GsonBuilder().create();
		switchPlayer();
		board.updateBoard(player, id);
		if (player == 'X')
			return gson.toJson("player1");
		else
			return gson.toJson("player2");
	}
}
