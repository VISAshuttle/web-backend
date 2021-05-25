package guestbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import guestbook.model.Message;
import jdbc.JDBCUtil;

public class MessageDAO {
	
	private static MessageDAO instance = new MessageDAO();
	public static MessageDAO getInstance() {
		return instance;
	}
	private MessageDAO() {}
	
	public int insert(Connection conn, Message message) throws SQLException {
		PreparedStatement preState = null;
		try {
			preState = conn.prepareStatement(
					"INSERT INTO guestbook_message " + 
					"(guest_name, password, message) VALUES (?, ?, ?)");
			preState.setString(1, message.getGuestName());
			preState.setString(2, message.getPassword());
			preState.setString(3, message.getMessage());
			
			return preState.executeUpdate();
		} finally {
			JDBCUtil.close(preState);
		}
	}

	public Message select(Connection conn, int messageId) throws SQLException {
		PreparedStatement preState = null;
		ResultSet rs = null;
		try {
			preState = conn.prepareStatement(
					"SELECT * FROM guestbook_message WHERE message_id = ?");
			preState.setInt(1, messageId);
			rs = preState.executeQuery();
			
			return rs.next() ? mapResultSetToMessage(rs) : null;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(preState);
		}
	}

	private Message mapResultSetToMessage(ResultSet rs) throws SQLException {
		Message message = new Message();
		message.setId(rs.getInt("message_id"));
		message.setGuestName(rs.getString("guest_name"));
		message.setPassword(rs.getString("password"));
		message.setMessage(rs.getString("message"));
		return message;
	}

	public int selectCount(Connection conn) throws SQLException {
		Statement state = null;
		ResultSet rs = null;
		try {
			state = conn.createStatement();
			rs = state.executeQuery("SELECT COUNT(*) FROM guestbook_message");
			rs.next();
			return rs.getInt(1);
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(state);
		}
	}

	public List<Message> selectList(Connection conn, int firstRow, int endRow) 
			throws SQLException {
		PreparedStatement preState = null;
		ResultSet rs = null;
		try {
			preState = conn.prepareStatement(
					"SELECT * FROM guestbook_message " + 
					"ORDER BY message_id DESC LIMIT ?, ?");
			preState.setInt(1, firstRow - 1);
			preState.setInt(2, endRow - firstRow + 1);
			rs = preState.executeQuery();
			if (rs.next()) {
				List<Message> messageList = new ArrayList<Message>();
				do {
					messageList.add(mapResultSetToMessage(rs));
				} while (rs.next());
				return messageList;
			} else {
				return Collections.emptyList();
			}
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(preState);
		}
	}

	public int delete(Connection conn, int messageId) throws SQLException {
		PreparedStatement preState = null;
		try {
			preState = conn.prepareStatement(
					"DELETE FROM guestbook_message WHERE message_id = ?");
			preState.setInt(1, messageId);
			return preState.executeUpdate();
		} finally {
			JDBCUtil.close(preState);
		}
	}

}