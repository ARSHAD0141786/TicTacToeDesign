package strategy.gameWinningStrategy;

import models.Board;
import models.Cell;

public class ColWiseWinningStrategy implements GameWinningStrategy {

	@Override
	public boolean wonGame(Board board, Cell cell) {
		return board.getColMap().get(cell.getCol()).get(cell.getPlayer().getSymbol()) == board.getDimension();
	}

}
