package is.ru.tictactoe;

public class Board{
	private static char[] board;
	//Constructor
        public Board(){
                //Create an array of size 9 that represents board
                board = new char[9];
                //Initialize board with the number of the field
		/* 1 2 3
		*  4 5 6
		*  7 8 9 */ 
                for(int i = 0; i < 9; i++){
			int num = i+1;
                        board[i] = (char) num;
                }
        }
	public static String drawBoard(){
		//do stuff
		String s = "1 2 3 \n 4 5 6 \n 7 8 9";
		return s;
	}

	public static boolean checkPosition(int index) {
		if (board[index] == 'X' || board[index] == 'O') {
			return false;
		}
		return true;
	}
}
