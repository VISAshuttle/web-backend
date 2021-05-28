package member.model;

import java.util.Date;

public class Member {

	private String id, name, password;
	private Date regDate;

	public Member(String id, String name, String password, Date regDate) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.regDate = regDate;
	}

	public boolean matchPassword(String password) {
		return this.password.equals(password);
	}

	public void changePassword(String newPassword) {
		this.password = newPassword;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public Date getRegDate() {
		return regDate;
	}

}