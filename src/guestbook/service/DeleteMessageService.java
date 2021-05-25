package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import guestbook.model.Message;
import guestbook.dao.MessageDAO;
import guestbook.service.exception.*;
import jdbc.JDBCUtil;
import jdbc.ConnectionProvider;

public class DeleteMessageService {
	
	private static DeleteMessageService instance = new DeleteMessageService();
	public static DeleteMessageService getInstance() {
		return instance;
	}
	private DeleteMessageService() {}
	
	public int deleteMessage(int messageId, String password) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection("guestbook");
			conn.setAutoCommit(false);

			MessageDAO msgDAO = MessageDAO.getInstance();
			Message msg = msgDAO.select(conn, messageId);
			if (msg == null)						throw new MessageNotFoundException("메시지 없음");
			if (!msg.matchPassword(password))	throw new InvalidPasswordException("패스워드 불일치");
			
			int result = msgDAO.delete(conn, messageId);
			conn.commit();
			return result;
		} catch (SQLException e) {
			JDBCUtil.rollback(conn);
			throw new ServiceException("삭제 실패:" + e.getMessage(), e);
		} catch (InvalidPasswordException | MessageNotFoundException e) {
			JDBCUtil.rollback(conn);
			throw e;
		} finally {
			JDBCUtil.close(conn);
		}
	}
	
}