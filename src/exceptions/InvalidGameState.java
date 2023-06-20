package exceptions;

@SuppressWarnings("serial")
public class InvalidGameState extends Exception {
	public InvalidGameState(String err) {
		super(err);
	}
}
