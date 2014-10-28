package is.ru.tictactoe;

public class Board{
	private static char[][] board;
	//Constructor
        public Board(){
                //Create an array of size 9 that represents board
                board = new char[3][3];
		int num = 0;
                //Initialize board with the number of the field
		/* 1 2 3
		*  4 5 6
		*  7 8 9 */
                for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++) { 
				num++;
                        	board[i][j] = (char) num;
			}
                }
        }
	public static String drawBoard(){
		//do stuff
		String s = "1 2 3 \n 4 5 6 \n 7 8 9";
		return s;
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
}
