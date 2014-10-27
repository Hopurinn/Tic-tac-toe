public class Board{
	//Constructor
        public Board(){
                //Create an array of size 9 that represents board
                char[] board = new char[9];
                //Initialize board with the number of the field
		/* 1 2 3
		*  4 5 6
		*  7 8 9 */ 
                for(int i = 1; i < 10; i++){
                        board[i] = (char) i;
                }
        }
}
