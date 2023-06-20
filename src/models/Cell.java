package models;

public class Cell {
	private int row, col;
	private Player assignedPlayer;
	CellState state = CellState.EMPTY;

	Cell(int row, int col) {
		this.row = row;
		this.col = col;
	}

	char getSymbol() {
		if (assignedPlayer == null)
			return ' ';
		return assignedPlayer.getSymbol();
	}
	
	public Player getPlayer() {
		return assignedPlayer;
	}

	void assignPlayer(Player player) {
		assignedPlayer = player;
		state = CellState.FILLED;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public CellState getState() {
		return state;
	}

	Player undo() {
		Player p = assignedPlayer;
		state = CellState.EMPTY;
		assignedPlayer = null;
		return p;
	}
}
