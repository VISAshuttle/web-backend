package handler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.CommandHandler;
import member.service.RegisterRequest;
import member.service.RegisterService;
import member.service.exception.DuplicateIdException;

public class RegisterHandler implements CommandHandler {

	private static final String FORM_VIEW = "/WEB-INF/view/register/register.jsp";
	
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
		RegisterRequest regReq = new RegisterRequest();
		regReq.setId(req.getParameter("email"));
		regReq.setName(req.getParameter("name"));
		regReq.setPassword(req.getParameter("password"));
		regReq.setRetypedPassword(req.getParameter("retypedPassword"));
		
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		regReq.validate(errors);
		if (errors.isEmpty()) {
			try {
				RegisterService regService = new RegisterService();
				regService.register(regReq);
				return "/WEB-INF/view/register/registerSuccess.jsp";
			} catch (DuplicateIdException e) {
				errors.put("DuplicateEmail", Boolean.TRUE);
				return FORM_VIEW;
			}
		} else {
			return FORM_VIEW;
		}
	}

}
