package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import exceptions.InvalidGameState;
import factories.BotPlayerFactory;
import factories.HumanPlayerFactory;
import factories.PlayerFactory;
import strategy.gameWinningStrategy.ColWiseWinningStrategy;
import strategy.gameWinningStrategy.DiagonalWiseWinningStrategy;
import strategy.gameWinningStrategy.GameWinningStrategy;
import strategy.gameWinningStrategy.RowWiseWinningStrategy;

public class Game {
	Board board;
	List<Player> players;
	int nextMoveIndex = 0;
	List<Move> moves = new ArrayList<>();
	GameState state;
	List<GameWinningStrategy> winningStrategies = new ArrayList<>();
	Player winner;

	
	public Player getWinner() {
		return winner;
	}
	public Game(List<Player> players, Board board) {
		this.players = players;
		this.board = board;
		state = GameState.CREATED;
		winningStrategies.add(new RowWiseWinningStrategy());
		winningStrategies.add(new ColWiseWinningStrategy());
		winningStrategies.add(new DiagonalWiseWinningStrategy());
		
		board.printBoard();
	}

	public void run() throws InvalidGameState {
		if(state == GameState.ENDED || state == GameState.DRAW) {
			throw new InvalidGameState("Game is ended, no more moves can execute");
		}
		
		state = GameState.IN_PROGRESS;
		Move mv = board.executeMove(players.get(nextMoveIndex));
		moves.add(mv);

		
		for(GameWinningStrategy gws : winningStrategies) {
			if(gws.wonGame(board,mv.getCell())) {
				state = GameState.ENDED;
				winner = players.get(nextMoveIndex);
				return;
			}
		}
		
		if(moves.size() == board.getDimension()*board.getDimension()) {
			state = GameState.DRAW;
			winner = null;
			return;
		}
		
		nextMoveIndex++;
		nextMoveIndex = nextMoveIndex % players.size();
	}
	
	public GameState getGameState() {
		return state;
	}

	public static Builder getBuilder() {
		return new Builder();
	}

	public void print() {
		board.printBoard();
	}
	
	public static class Builder {
		List<Player> players = new ArrayList<>();
		Board board;

		public Builder addPlayers(int n) {

			PlayerFactory pf = new HumanPlayerFactory();
			Map<Character, Player> mp = new HashMap<>();
			for (int i = 0; i < n; ++i) {
				Player p = pf.createPlayer();
				if(mp.containsKey(p.getSymbol())) {
					--i;
					System.err.println("Symbol already taken by : " + mp.get(p.getSymbol()).getName());
					continue;
				}
				players.add(p);
			}
			
			// add 1 Bots also when human player is 1
			if(n == 1) {
				pf = new BotPlayerFactory();
				Player b = pf.createPlayer();
				players.add(b);
			}

			return this;
		}

		public Builder addBoard(int dimension) {
			board = new Board(dimension);
			return this;
		}

		boolean verify() {
			if (board.getDimension() <= players.size()) {
				System.out.println("Board is too small to play, increase its dimension");
				return false;
			}
			Set<Character> st = new HashSet<>();
			for (Player p : players) {
				if (st.contains(p.getSymbol())) {
					System.out.println("Players must have unique symbols");
					return false;
				}
				st.add(p.getSymbol());
			}

			return true;
		}

		public Game build() {
			if (!verify()) {
				System.out.println("Game creation is not valid, Please enter valid values");
				return null;
			}
			return new Game(players, board);
		}
	}

}
