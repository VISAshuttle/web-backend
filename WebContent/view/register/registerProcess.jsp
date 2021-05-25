<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager"
		 import="java.sql.Connection"
		 import="java.sql.PreparedStatement"
		 import="java.sql.SQLException"
		 import="jdbc.ConnectionProvider" %>
		 
<%
	String contextPath = request.getContextPath();
	String referer = request.getHeader("referer");
	if (referer == null || !referer.endsWith("register.jsp")) {
		response.sendRedirect(contextPath + "/view/register/register.jsp");
		return;
	}

	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name"),
		   email = request.getParameter("email"),
		   password = request.getParameter("password");
	String memberID = email.substring(0, email.indexOf("@"));
	
	Connection conn = null;
	PreparedStatement preState = null;
	
	try {
		conn = ConnectionProvider.getConnection("chap14");
		preState = conn.prepareStatement("insert into MEMBER values(?, ?, ?, ?)");
		preState.setString(1, memberID);
		preState.setString(2, password);
		preState.setString(3, name);
		preState.setString(4, email);
		
		preState.executeUpdate();
	} finally {
		if (preState != null) try { preState.close(); } catch(SQLException ex) {}
		if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	}
%>

<script>
	alert("회원가입에 성공했습니다.");
	window.location = "<%= contextPath %>/view/login/login.jsp";
</script>