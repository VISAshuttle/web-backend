<%@ page language="java"
		 contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"
		 import="util.Cookies" %>

<% 
	/* cookie 방식 */
//	response.addCookie(Cookies.createCookie("AUTH", "", "/", 0));

	/* session 방식 */
	session.invalidate();
	
	/* cookie, session 공통 */
	response.sendRedirect("login.jsp");
%>