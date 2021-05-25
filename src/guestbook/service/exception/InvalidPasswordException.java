package guestbook.service.exception;

public class InvalidPasswordException extends ServiceException {
	
	public InvalidPasswordException(String message) {
		super(message);
	}
	
}