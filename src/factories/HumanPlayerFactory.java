package factories;

import models.HumanPlayer;
import models.Player;

public class HumanPlayerFactory extends PlayerFactory {

	@Override
	public
	Player createPlayer() {
		return new HumanPlayer();
	}

}
