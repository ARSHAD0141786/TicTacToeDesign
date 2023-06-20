package models;

public abstract class Player {
	protected String name;
	protected char symbol;
	
	public char getSymbol() {
		return symbol;
	}
	
	public String getName() {
		return name;
	}

	protected abstract Move getMove(Board board);
}
