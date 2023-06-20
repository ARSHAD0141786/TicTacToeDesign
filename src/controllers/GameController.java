package controllers;

import java.util.Scanner;

import exceptions.InvalidBoardSizeException;
import exceptions.InvalidGameState;
import models.Game;
import models.GameState;
import models.Player;

public class GameController {
	Scanner sc = new Scanner(System.in);

	public Game createNewGame() throws InvalidBoardSizeException {

		System.out.print("Enter number of players : ");
		int n = sc.nextInt();
		System.out.print("Enter board dimension : ");
		int d = sc.nextInt();
		
		Game game = Game.getBuilder().addBoard(d).addPlayers(n).build();
		
		return game;
	}
	
	public boolean play(Game game) throws InvalidGameState {
		if(game.getGameState() == GameState.ENDED || game.getGameState() == GameState.DRAW) return false;
		game.run();
		game.print();
		return true;
	}
	
	public Player getWinner(Game game) {
		return game.getWinner();
	}
	
	public GameState getGameState(Game game) {
		return game.getGameState();
	}
}
