<%@ page language="java"
		 contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>

<% 
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	if (email == null || password == null) {
		out.print("<script>" + "alert('잘못된 접근입니다.');" + "window.location = 'login.jsp';" + "</script>");
	} else {
		boolean isValidEmail = email.equals("hanguk@naver.com");
		boolean isValidPassword = password.equals("1234");
		
		if (isValidEmail && isValidPassword) {
			session.setAttribute("email", email);
			response.sendRedirect("../main/index.jsp");
		} else {
			out.print("<script>" + "alert('로그인 실패');" + "window.location = 'login.jsp';" + "</script>");
		}
	}
%>