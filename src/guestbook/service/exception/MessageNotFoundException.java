package guestbook.service.exception;

public class MessageNotFoundException extends ServiceException {
	
	public MessageNotFoundException(String message) {
		super(message);
	}
	
}