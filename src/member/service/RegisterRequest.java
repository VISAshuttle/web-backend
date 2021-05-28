package member.service;

import java.util.Map;

public class RegisterRequest {
	
	private String id, name, password, retypedPassword;
	
	public void validate(Map<String, Boolean> errors) {
		checkEmpty(errors, "emptyId", id);
		checkEmpty(errors, "emptyName", name);
		checkEmpty(errors, "emptyPassword", password);
		checkEmpty(errors, "emptyRetypedPassword", retypedPassword);
		if (!isPasswordEqualToRetyped())
			errors.put("PasswordsNotMatch", Boolean.TRUE);
	}

	public boolean isPasswordEqualToRetyped() {
		return password != null && retypedPassword != null && password.equals(retypedPassword);
	}
	
	private void checkEmpty(Map<String, Boolean> errors, String errorName, String value) {
		if (value == null || value.isEmpty())
			errors.put(errorName, Boolean.TRUE);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRetypedPassword() {
		return retypedPassword;
	}

	public void setRetypedPassword(String retypedPassword) {
		this.retypedPassword = retypedPassword;
	}
	
}