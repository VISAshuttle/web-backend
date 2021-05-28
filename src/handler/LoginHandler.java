package handler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.model.User;
import auth.service.LoginService;
import auth.service.exception.LoginFailException;

public class LoginHandler implements CommandHandler {

	private static final String FORM_VIEW = "/WEB-INF/view/login/login.jsp";

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
		String id = trim(req.getParameter("id"));
		String password = trim(req.getParameter("password"));

		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);

		if (id == null || id.isEmpty()) 				errors.put("emptyId", Boolean.TRUE);
		if (password == null || password.isEmpty())	errors.put("emptyPassword", Boolean.TRUE);
		if (errors.isEmpty()) {
			try {
				LoginService loginService = new LoginService();
				User user = loginService.login(id, password);
				req.getSession().setAttribute("authUser", user);
				resp.sendRedirect(req.getContextPath() + "/main/index.do");
				return null;
			} catch (LoginFailException e) {
				errors.put("invalidCridential", Boolean.TRUE);
				return FORM_VIEW;
			}
		} else {
			return FORM_VIEW;
		}

	}
	
	private String trim(String str) {
		return str == null ? null : str.trim();
	}

}