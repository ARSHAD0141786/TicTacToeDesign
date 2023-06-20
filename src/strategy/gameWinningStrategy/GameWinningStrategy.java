package strategy.gameWinningStrategy;

import models.Board;
import models.Cell;

public interface GameWinningStrategy {

	public boolean wonGame(Cell cell);
	
}
