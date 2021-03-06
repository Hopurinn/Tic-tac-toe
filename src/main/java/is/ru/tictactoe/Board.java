package is.ru.tictactoe;

public class Board{
	public static char[][] board;
	//Constructor
        public Board(){
                //Create an double char array of size 3x3 that represents the board
                board = new char[3][3];
		initializeBoard();
        }

	public void initializeBoard() {
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
	public boolean isValidMove(int num) {
		if (num < 1 || 9 < num)
			return false;
		int column = findColumn(num);
		int row = findRow(num);
		return (board[row][column] == '0' + num) ? true : false;
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
	}

	// function that runs all checks for if specific
	// player has won
	public boolean checkForWin(char player) {
		if (checkRows(player))
			return true;
		if (checkColumns(player))
			return true;
		if (checkDiagonal(player))
			return true;
		return false;
	}

	// function that checks all rows, if a player has won 
	// it returns the players identifier
	public boolean checkRows(char player) {
		for (int row = 0; row < 3; row++) {
			int count = 0;
			for (int col = 0; col < 3; col++) {
				if (board[row][col] == player)
					count++;
			}
			if (count == 3)
				return true;
		}
		// neither x or o returned, it is a draw
		return false;
	}

	// function that checks all columns, if a plyer has won
	// it returns the players identifier
	public boolean checkColumns(char player){
		for(int col = 0; col < 3; col++){
			int count = 0;
			for(int row = 0; row < 3; row++){
				if(board[row][col] == player)
					count++;
			}
			if (count == 3)
				return true;
		}
		//Neither x or o returned, it is a draw (D)
		return false;
	}

	// function that checks the board for diagonal win
	public boolean checkDiagonal(char player){
		// counts to three to determine win
		int count = 0;

		for (int i = 0; i < 3; i++) {
			if(board[i][i] == player)
				count++;
		}
		if(count == 3)
			return true;
		count = 0;

		for (int i = 0, j = 2; i < 3 && j >= 0; i++, j--) {
			if(board[i][j] == player)
				count++;
		}
		if(count == 3)
			return true;

		return false;
	}
}
