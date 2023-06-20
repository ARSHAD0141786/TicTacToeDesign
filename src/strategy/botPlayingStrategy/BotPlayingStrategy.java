package strategy.botPlayingStrategy;

import models.Board;
import models.Cell;

public interface BotPlayingStrategy {
	Cell getCell(Board board);
}
