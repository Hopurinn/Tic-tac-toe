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

	public static char updateBoard(int row, int column){
		board[row][column] = 'X';
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
			
				else if (ocounter ==3)
					return 'O';
			}
		}
		return 'D';
	}

	public static char checkColumns(){
		return 'D';
	}
}
