package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProfileHandler implements CommandHandler {

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
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse resp) {
		return FORM_VIEW;
	}

}
