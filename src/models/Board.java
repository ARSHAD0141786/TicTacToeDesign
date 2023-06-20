package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Board {
	int dimension;
	List<List<Cell>> cells = null;

	List<Map<Character, Integer>> rowMap = new ArrayList<>();
	List<Map<Character, Integer>> colMap = new ArrayList<>();
	List<Map<Character, Integer>> diagonalMap = new ArrayList<>();

	
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

		for (int i = 0; i < dimension; ++i)
			rowMap.add(new HashMap<>());
		for (int i = 0; i < dimension; ++i)
			colMap.add(new HashMap<>());
		for (int i = 0; i < 2; ++i)
			diagonalMap.add(new HashMap<>()); // Only 2 diagonals possible
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

	public List<List<Cell>> getCells(){
		return cells;
	}
	
	void fillMaps(Cell cell, Player player) {
		int row = cell.getRow();
		int col = cell.getCol();
		rowMap.get(row).put(player.getSymbol(), rowMap.get(row).getOrDefault(player.getSymbol(), 0)+1);
		colMap.get(col).put(player.getSymbol(), colMap.get(col).getOrDefault(player.getSymbol(), 0)+1);
		Integer diag = null;
		if (row == col)
			diag = 0;
		else if ((row + col) == dimension)
			diag = 1;
		if (diag != null) {
			diagonalMap.get(diag).put(player.getSymbol(),
					diagonalMap.get(diag).getOrDefault(player.getSymbol(), 0)+1);
		}
	}
	
	Move executeMove(Player player) {
		Move mv = player.getMove(this);
		mv.execute();
		fillMaps(mv.getCell(), mv.getPlayer());
		return mv;
	}
	public List<Map<Character, Integer>> getRowMap() {
		return rowMap;
	}
	public List<Map<Character, Integer>> getColMap() {
		return colMap;
	}
	public List<Map<Character, Integer>> getDiagonalMap() {
		return diagonalMap;
	}
}
