package strategy.botPlayingStrategy;

import models.Board;
import models.Cell;
import models.CellState;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {

	@Override
	public Cell getCell(Board board) {
		for(int row=0;row<board.getDimension();++row) {
			for(int col=0;col<board.getDimension();++col) {
				Cell c = board.getCells().get(row).get(col);
				if(c.getState() == CellState.EMPTY) {
					return c;
				}
			}
		}
		return null;
	}

}
