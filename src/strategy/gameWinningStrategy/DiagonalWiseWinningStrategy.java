package strategy.gameWinningStrategy;

import models.Board;
import models.Cell;

public class DiagonalWiseWinningStrategy implements GameWinningStrategy {

	@Override
	public boolean wonGame(Board board,Cell cell) {
		Integer diag = null;
		int row = cell.getRow(), col = cell.getCol();
		if(row-col == 0) diag = 0;
		else if(row+col == board.getDimension()) diag = 1;
		if(diag != null) {
			return board.getDiagonalMap().get(diag).get(cell.getPlayer().getSymbol()) == board.getDimension();
		}
		return false;
	}

}
