package me.blog.exception;

public class PassPortException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4404705464137154072L;
	
	public PassPortException(String message) {
		super(message);
	}
	
	public PassPortException(Throwable cause) {
		super(cause);
	}
	
	public PassPortException(String message, Throwable cause) {
		super(message, cause);
	}

}
