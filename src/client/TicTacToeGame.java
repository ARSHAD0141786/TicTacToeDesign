package client;

import controllers.GameController;
import exceptions.InvalidGameState;
import models.Game;
import models.GameState;

public class TicTacToeGame {

	public static void main(String[] args) {
		
		// Create Game
		// Create Game controller
		// controller.play(Game)
		GameController gc = new GameController();
		
		Game g1 = gc.createNewGame();
		
		try {
			while(gc.play(g1));
		} catch (InvalidGameState e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(gc.getGameState(g1)==GameState.ENDED) {
			System.out.print("Congratulations " + gc.getWinner(g1).getName() + "!!! You won this game.");
		} else if(gc.getGameState(g1) == GameState.DRAW) {
			System.out.println("DRAW!!!");
		}

	}

}
