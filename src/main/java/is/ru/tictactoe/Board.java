package is.ru.tictactoe;

public class Board{
	public static char[][] board;
	//Constructor
        public Board(){
                //Create an double char array of size 3x3 that represents the board
                board = new char[3][3];
		//Create an character for the number of field in board
		char num = '1';
		/* 1 2 3
		*  4 5 6
		*  7 8 9 */
		//Initialize array
                for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++) {
                        	board[i][j] = num;
				num++;
			}
                }
        }
	public void drawBoard(){
		//Create a string that reads board
		System.out.print( " | ");
		//Go through array
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				//Adding the number of the current field to string
				//And column separator
				System.out.print( board[i][j] + " | ");
				//After first 3 indexes  there is a new line
				if((i == 0 && j == 2) || (i == 1 && j == 2)){
					System.out.print( "\n ");
				}
			}
			//Row separator
			if(i == 0 || i == 1){
				System.out.print( " --- --- --- \n | ");
			}
		}
		System.out.println();
	}

	// function that checks if the number entered
	// is still available
	public boolean validateMove(int num) {
		// initialize a boolean variable to true
		boolean moveInvalid = true;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if ((char) num + 48 == board[i][j]) {
					// if the value is found, make moveInvalid false
					moveInvalid = false;
				}
			}
		}

		// return the boolean variable moveInvalid
		// valid = false, invalid = true
		return moveInvalid;
	}

	// function to identify the row of the number entered
	public int findRow(int num) {
		return (num - 1) / 3;
	}

	// function to identify the column of the number entered
        public int findColumn(int num) {
		return (num - 1) % 3;
        }

	// function to update the board from it's current number
	// to the corresponding player's identifier
	public void updateBoard(char player, int num){
		// initialize row and column corresponding 
		// to where the number is in the board
		int row = findRow(num);
		int column = findColumn(num);

		// updates the board to the players identifier
		board[row][column] = player;
		// draws the modified board
		drawBoard();
	}

	// function to check if any player has won the game
	// and returns true if a winner is found and false if not
	public boolean winnerFound(char player) {
		// checks if any player has won by getting a whole row
		if (checkRows(player) == player)
			return true;
		// checks if any player has won by getting a whole column
		else if (checkColumns(player) == player)
			return true;
		// checks if any player has won by getting a whole diagonal
		else if (checkDiagonal(player) == player)
			return true;
		// returns false if no one has won yet
		else
			return false;
	}

	// function that checks if someone has won yet
	// and returns who won
	public char findWinner(char player) {
		if (checkRows(player) == player)
			return checkRows(player);
		else if (checkColumns(player) == player)
			return checkColumns(player);
		else if (checkDiagonal(player) == player)
			return checkDiagonal(player);
		else
			return 'D';
	}

	// function that checks all rows, if a player has won 
	// it returns the players identifier
	public char checkRows(char player) {
		for (int row = 0; row < 3; row++) {
			int count = 0;
			for (int col = 0; col < 3; col++) {
				if (board[row][col] == player)
					count++;
			}
			if (count == 3)
				return player;
		}
		// neither x or o returned, it is a draw
		return 'D';
	}

	// function that checks all columns, if a plyer has won
	// it returns the players identifier
	public char checkColumns(char player){
		for(int col = 0; col < 3; col++){
			int count = 0;
			for(int row = 0; row < 3; row++){
				if(board[row][col] == player)
					count++;
			}
			if (count == 3)
				return player;
		}
		//Neither x or o returned, it is a draw (D)
		return 'D';
	}

	// function that checks the board for diagonal win
	public char checkDiagonal(char player){
		// counts to three to determine win
		int count = 0;

		for (int i = 0; i < 3; i++) {
			if(board[i][i] == player)
				count++;
			if(count == 3)
				return player;
		}
		count = 0;

		for (int i = 0; i < 3; i++) {
			for (int j = 2; j > -1; j--) {
				if(board[i][j] == player)
					count++;
			}
			if(count == 3)
				return player;
		}

		return 'D';
	}
}
