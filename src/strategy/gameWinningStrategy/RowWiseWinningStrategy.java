package strategy.gameWinningStrategy;

import models.Board;
import models.Cell;

public class RowWiseWinningStrategy implements GameWinningStrategy {

	@Override
	public boolean wonGame(Board board, Cell cell) {
		return board.getRowMap().get(cell.getRow()).get(cell.getPlayer().getSymbol()) == board.getDimension();
	}

}
