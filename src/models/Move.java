package models;

import java.util.Scanner;

public class Move {
	Cell cell;
	Player player;

	public Move(Cell cell, Player player) {
		super();
		this.cell = cell;
		this.player = player;
	}
	
	void execute() {
		cell.assignPlayer(player);
	}
	
	void undo() {
		cell.undo();
	}

	public Cell getCell() {
		return cell;
	}

	public Player getPlayer() {
		return player;
	}

}
