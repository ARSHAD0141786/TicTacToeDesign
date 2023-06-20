package strategy.botPlayingStrategy;

import java.util.ArrayList;
import java.util.List;

import models.Board;
import models.Cell;
import models.CellState;
import strategy.gameWinningStrategy.GameWinningStrategy;

public class RandomBotPlayingStrategy implements BotPlayingStrategy {

	@Override
	public Cell getCell(Board board) {
		// Analyse Board
		List<Cell> emptyCells = new ArrayList<>();
		for(List<Cell> lc : board.getCells()) {
			for(Cell c : lc) {
				if(c.getState() == CellState.EMPTY) {
					emptyCells.add(c);
				}
			}
		}
		int sz = emptyCells.size();
		
		return emptyCells.get((int) (Math.random()*(sz)));
	}

}
