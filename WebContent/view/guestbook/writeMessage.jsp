<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="guestbook.model.Message"
		 import="guestbook.service.WriteMessageService" %>

<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="message" class="guestbook.model.Message">
	<jsp:setProperty name="message" property="*" />
</jsp:useBean>
<%
	WriteMessageService writeService = WriteMessageService.getInstance();
	int writeResult = writeService.writeMessage(message);
	if (writeResult == 0)	response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
%>

<html>

<head>
	<title>방명록 메시지 남김</title>
</head>

<body>
	방명록에 메시지를 남겼습니다.<br>
	<a href="messageList.jsp">[목록 보기]</a>
</body>

</html>