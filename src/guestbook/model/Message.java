package guestbook.model;

public class Message {
	
	private int id;
	private String guestName, password, message;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public boolean hasPassword() {
		return this.password != null && !this.password.isEmpty();
	}
	
	public boolean matchPassword(String password) {
		return this.hasPassword() && this.password.equals(password);
	}
	
}