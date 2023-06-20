package strategy.gameWinningStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Board;
import models.Cell;
import models.Player;

public class RowColDiagonalWinningStrategy implements GameWinningStrategy {

	List<Map<Character, Integer>> rowMap = new ArrayList<>();
	List<Map<Character, Integer>> colMap = new ArrayList<>();
	List<Map<Character, Integer>> diagonalMap = new ArrayList<>();
	int dimension;
	
	public RowColDiagonalWinningStrategy(int dimension) {
		this.dimension = dimension;
		for (int i = 0; i < dimension; ++i)
			rowMap.add(new HashMap<>());
		for (int i = 0; i < dimension; ++i)
			colMap.add(new HashMap<>());
		for (int i = 0; i < 2; ++i)
			diagonalMap.add(new HashMap<>()); // Only 2 diagonals possible
	}
	
	@Override
	public boolean wonGame(Cell cell) {
		fillMaps(cell);
		boolean status = false;
		status = status || rowMap.get(cell.getRow()).get(cell.getPlayer().getSymbol()) == dimension;
		status = status || colMap.get(cell.getCol()).get(cell.getPlayer().getSymbol()) == dimension;
		
		Integer diag = null;
		int row = cell.getRow(), col = cell.getCol();
		if(row-col == 0) diag = 0;
		else if(row+col == dimension) diag = 1;
		if(diag != null) {
			status = status || diagonalMap.get(diag).get(cell.getPlayer().getSymbol()) == dimension;
		}
		return status;
	}

	void fillMaps(Cell cell) {
		int row = cell.getRow();
		int col = cell.getCol();
		Player player = cell.getPlayer();
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
}
