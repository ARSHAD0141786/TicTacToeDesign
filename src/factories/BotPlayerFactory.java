package factories;

import models.BotPlayer;
import models.Player;
import strategy.botPlayingStrategy.EasyBotPlayingStrategy;

public class BotPlayerFactory extends PlayerFactory {

	@Override
	public
	Player createPlayer() {
		return new BotPlayer(new EasyBotPlayingStrategy());
	}

}
