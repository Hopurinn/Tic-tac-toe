package is.ru.tictactoe;

public class Board{
	private static char[][] board;
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
	public static void drawBoard(){
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
	public static boolean validateMove(int num) {
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
	private static int findRow(int num) {
		// initialize the row to 0
		// this is ok because this function is only used
		// when the input is valid/available
		int row = 0;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				// changes num to it's corresponding ASCII value
				// which can be compared to the boards char
				if ((char) num + 48 == board[i][j]) {
					row = i;
				}
			}
		}

		// return the row of num
		return row;
	}

	// function to identify the column of the number entered
        private static int findColumn(int num) {
		// initialize the row to 0
                // this is ok because this function is only used
                // when the input is valid/available
                int column = 0;
                for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
				// changes num to it's corresponding ASCII value
				// which can be compared to the boards char
                                if ((char) num + 48 == board[i][j]) {
                                        column = j;
                                }
                        }
                }

		// return the column of num
                return column;
        }

	// function to update the board from it's current number
	// to the corresponding player's identifier
	public static void updateBoard(char player, int num){
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
	public static boolean winnerFound() {
		// checks if any player has won by getting a whole row
		if (checkRows() == 'X' || checkRows() == 'O')
			return true;
		// checks if any player has won by getting a whole column
		else if (checkColumns() == 'X' || checkColumns() == 'O')
			return true;
		// checks if any player has won by getting a whole diagonal
		else if (checkDiagonal() == 'X' || checkDiagonal() == 'O')
			return true;
		// returns false if no one has won yet
		else
			return false;
	}

	// function that checks if someone has won yet
	// and returns who won
	public static char findWinner() {
		if (checkRows() == 'X' || checkRows() == 'O')
			return checkRows();
		else if (checkColumns() == 'X' || checkColumns() == 'O')
			return checkColumns();
		else if (checkDiagonal() == 'X' || checkDiagonal() == 'O')
			return checkDiagonal();
		else
			return 'D';
	}

	// function that checks all rows, if a player has won 
	// it returns the players identifier
	public static char checkRows() {
		for (int row = 0; row < 3; row++) {
			int xcount = 0;
			int ocount = 0;
			for (int col = 0; col < 3; col++) {
				if (board[row][col] == 'X' || board[row][col] == 'x')
					xcount++;
				else if (board[row][col] == 'O' || board[row][col] == 'o')
					ocount++;

				if (xcount == 3)
					return 'X';
				else if (ocount == 3)
					return 'O';
			}
		}
		// neither x or o returned, it is a draw
		return 'D';
	}

	// function that checks all columns, if a plyer has won
	// it returns the players identifier
	public static char checkColumns(){
		//Searching for win in columns
		for(int col = 0; col < 3; col++){
			int xcount = 0;
			int ocount = 0;
			for(int row = 0; row < 3; row++){
				if(board[row][col] == 'X' || board[row][col] == 'x')
					xcount++;
				else if(board[row][col] == 'O' || board[row][col] == 'o')
					ocount++;

				if(xcount == 3)
					return 'X';
				else if(ocount == 3)
					return 'O';
			}
		}
		//Neither x or o returned, it is a draw (D)
		return 'D';
	}

	public static char checkDiagonal(){
	//Check for X wins
		//Check for win \
		if(board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X'
		|| board[0][0] == 'x' && board[1][1] == 'x' && board[2][2] == 'x')
			return 'X';
		//Check for win /
		else if(board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X'
		|| board[0][2] == 'x' && board[1][1] == 'x' && board[2][0] == 'x')
			return 'X';

	//Check for O wins
		//Check for \ win
		else if(board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O'
		|| board[0][0] == 'o' && board[1][1] == 'o' && board[2][2] == 'o')
			return 'O';
		//Check for / win
		else if(board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O'
		|| board[0][2] == 'o' && board[1][1] == 'o' && board[2][0] == 'o')
			return 'O';

		//Nothing returned, it is a draw (D)
		return 'D';
	}
}
