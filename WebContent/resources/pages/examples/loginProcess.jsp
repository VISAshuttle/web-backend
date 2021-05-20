<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<% 
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	boolean isValidEmail = email.equals("hanguk@naver.com");
	boolean isValidPassword = password.equals("1234");
	
	if (isValidEmail && isValidPassword) {
  		request.getSession().setAttribute("email", email);
		response.sendRedirect("../../index.jsp");
	} else { %>
		<script>
			alert('로그인 실패');
			history.back();
		</script>
<%	}	%>