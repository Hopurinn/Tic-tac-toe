package is.ru.tictactoe;

import spark.*;
import static spark.Spark.*;
import spark.servlet.SparkApplication;

public class TicTacToe implements SparkApplication{
	public static void main(String[] args) {
		staticFileLocation("/public");
		SparkApplication tictactoe = new TicTacToe();
		String port = System.getenv("PORT");
        	if (port != null) {
         	   	setPort(Integer.valueOf(port));
        	}
		tictactoe.init();
	}

	public void init(){
		final Game game = new Game();

		post(new Route("/id"){
			@Override
			public Object handle(Request request, Response response){
				Integer number = Integer.valueOf(request.queryParams("id"));
				return game.makeMove(number);
			}
		});
	}
}
