package factories;

import models.BotPlayer;
import models.Player;
import strategy.botPlayingStrategy.BotPlayingStrategy;
import strategy.botPlayingStrategy.EasyBotPlayingStrategy;
import strategy.botPlayingStrategy.RandomBotPlayingStrategy;

public class BotPlayerFactory extends PlayerFactory {
	
	private BotPlayingStrategy bps;
	public BotPlayerFactory(BotPlayingStrategy bps) {
		this.bps = bps;
	}
	@Override
	public
	Player createPlayer() {
		return new BotPlayer(bps);
	}

}
