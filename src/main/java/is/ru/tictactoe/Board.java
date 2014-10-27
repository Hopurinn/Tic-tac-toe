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
}
