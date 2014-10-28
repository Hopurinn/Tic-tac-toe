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
	public static String drawBoard(){
		//Create a string that reads board
		String drawStr = " | ";
		//Go through array 
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				//Adding the number of the current field to string
				//And column separator
				drawStr += board[i][j] + " | ";
				//After first 3 indexes  there is a new line
				if((i == 0 && j == 2) || (i == 1 && j == 2)){
					drawStr += "\n ";
				}
			}
			//Row separator
			if(i == 0 || i == 1){
				drawStr += " --- --- --- \n | ";
			}
		}
		//Return the array with separators (the board)
		return drawStr;
	}

	public static boolean checkPosition(int row, int column) {
		if (board[row][column] == 'X' || board[row][column] == 'O') {
			return false;
		}
		return true;
	}

	public static char updateBoard(char player, int row, int column){
		board[row][column] = player;
		return board[row][column];
	}

	public static char checkForWin() {
		return checkRows();
	}

	public static char checkRows() {
		for (int i = 0; i < 3; i++) {
			int xcounter = 0;
			int ocounter = 0;

			for (int j = 0; j < 3; j++) {
				if (board[i][j] == 'X')
					xcounter++;
				else if (board[i][j] == 'O')
					ocounter++;

				if (xcounter == 3)
					return 'X';
				else if (ocounter == 3)
					return 'O';
			}
		}
		return 'D';
	}

	public static char checkColumns(){
		//Searching for win in columns
		for(int col = 0; col < 3; col++){
			int xcount = 0;
			int ocount = 0;
			for(int row = 0; row < 3; row++){
				if(board[row][col] == 'X')
					xcount++;
				else if(board[row][col] == 'O')
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
		if(board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X')
			return 'X';
		//Check for win /
		else if(board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X')
			return 'X';

		//Check for O wins

		//Check for \ win
		else if(board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O')
			return 'O';
		//Check for / win
		else if(board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O')
			return 'O';

		//Nothing returned, it is a draw (D)
		return 'D';
	}
}
