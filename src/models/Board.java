
package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Board {
	int dimension;
	List<List<Cell>> cells = null;

	public int getDimension() {
		return dimension;
	}

	public Board(int dimension) {
		this.dimension = dimension;
		cells = new ArrayList<>();

		for (int row = 0; row < dimension; ++row) {
			cells.add(new ArrayList<Cell>(dimension));
			for (int col = 0; col < dimension; ++col) {
				cells.get(row).add(new Cell(row, col));
			}
		}
	}

	void printBoard() {
		StringBuffer sb = new StringBuffer();
		for (int row = 0; row < dimension; ++row) {
			if (row > 0) {
				for (int col = 0; col < dimension; ++col) {
					if (col > 0) {
						sb.append("+");
					}
					sb.append("---");
				}
				sb.append("\n");
			}
			for (int col = 0; col < dimension; ++col) {
				if (col > 0) {
					sb.append("|");
				}
				sb.append(" " + cells.get(row).get(col).getSymbol() + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	public List<List<Cell>> getCells() {
		return cells;
	}

	Move executeMove(Player player) {
		Move mv = player.getMove(this);
		mv.execute();
		return mv;
	}
}
