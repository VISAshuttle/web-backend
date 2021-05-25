package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import guestbook.model.Message;
import guestbook.service.exception.ServiceException;
import guestbook.dao.MessageDAO;
import jdbc.JDBCUtil;
import jdbc.ConnectionProvider;

public class WriteMessageService {
	
	private static WriteMessageService instance = new WriteMessageService();
	public static WriteMessageService getInstance() {
		return instance;
	}
	private WriteMessageService() {}
	
	public int writeMessage(Message message) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection("guestbook");
			MessageDAO msgDAO = MessageDAO.getInstance();
			return msgDAO.insert(conn, message);
		} catch (SQLException e) {
			throw new ServiceException("메시지 등록 실패: " + e.getMessage(), e);
		} finally {
			JDBCUtil.close(conn);
		}
	}
	
}
