package handler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.model.User;
import member.service.PasswordChangeService;
import member.service.exception.InvalidPasswordException;
import member.service.exception.MemberNotFoundException;

public class PasswordChangeHandler implements CommandHandler {

	private static final String FORM_VIEW = "/WEB-INF/view/main/profile.jsp";

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String reqMethod = req.getMethod().toUpperCase();
		switch (reqMethod) {
		case "GET":
			return processForm(req, resp);
		case "POST":
			return processSubmit(req, resp);
		default:
			resp.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse resp) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		User user = (User) req.getSession().getAttribute("authUser");

		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);

		String currentPassword = req.getParameter("currentPassword");
		String newPassword = req.getParameter("newPassword");

		if (currentPassword == null || currentPassword.isEmpty())		errors.put("EmptyCurrentPassword", Boolean.TRUE);
		if (newPassword == null || newPassword.isEmpty())				errors.put("EmptyNewPassword", Boolean.TRUE);
		if (errors.isEmpty()) {
			try {
				PasswordChangeService pwdChangeService = new PasswordChangeService();
				pwdChangeService.changePassword(user.getId(), currentPassword, newPassword);
				return "/WEB-INF/view/main/passwordChangeSuccess.jsp";
			} catch (InvalidPasswordException e) {
				errors.put("InvalidCurrentPassword", Boolean.TRUE);
				return FORM_VIEW;
			} catch (MemberNotFoundException e) {
				resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
				return null;
			}
		} else {
			return FORM_VIEW;
		}

	}

}
