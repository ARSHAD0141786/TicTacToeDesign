package models;

import java.util.Scanner;

public class HumanPlayer extends Player {

	public HumanPlayer() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Human Player name : ");
		name = sc.next();
		
		System.out.print("Enter your symbol (1 character) : ");
		symbol = sc.next().charAt(0);
	}
	
	@Override
	public Move getMove(Board board) {
		Scanner sc = new Scanner(System.in);
		Cell cell = null;
		do {
			System.out.print(this.getName() + " enter (row,col) : ");
			int row = sc.nextInt(), col = sc.nextInt();
			while (row <= 0 || row > board.getDimension() || col <= 0 || col > board.getDimension()) {
				System.out.println("Invalid row,col. Must from 1 to " + board.getDimension());
				System.out.print("Enter (row,col) : ");
				row = sc.nextInt();
				col = sc.nextInt();
			}
			row--;col--;
			cell = board.getCells().get(row).get(col);
			if (cell.getState() != CellState.EMPTY) {
				System.out.println("Cell is not empty, please choose another cell");
			}
		} while (cell.getState() != CellState.EMPTY);

		Move mv = new Move(cell, this);

		return mv;
	}
}
