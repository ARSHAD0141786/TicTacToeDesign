package models;

import java.util.Scanner;

import strategy.botPlayingStrategy.BotPlayingStrategy;

public class BotPlayer extends Player {

	BotPlayingStrategy bps;
	public BotPlayer(BotPlayingStrategy bps) {
		symbol = 'B';
		name = "Bot-" + symbol;
		this.bps = bps;
	}
	
	@Override
	public Move getMove(Board board) {
		return new Move(bps.getCell(board),this);
	}
	
	

}
