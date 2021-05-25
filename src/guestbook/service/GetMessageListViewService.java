package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import guestbook.model.Message;
import guestbook.model.MessageListView;
import guestbook.dao.MessageDAO;
import guestbook.service.exception.*;
import jdbc.JDBCUtil;
import jdbc.ConnectionProvider;

public class GetMessageListViewService {

	private static GetMessageListViewService instance = new GetMessageListViewService();
	public static GetMessageListViewService getInstance() {
		return instance;
	}
	public GetMessageListViewService() {}

	private static final int MSG_PER_PAGE = 3;

	public MessageListView getMessageListView(int pageNum) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection("guestbook");
			MessageDAO msgDAO = MessageDAO.getInstance();

			List<Message> messageList = null;
			int totalMessages = msgDAO.selectCount(conn);
			int currentPage = pageNum;
			int firstRow = 0, endRow = 0;
			
			if (totalMessages > 0) {
				firstRow = (currentPage - 1) * MSG_PER_PAGE + 1;
				endRow = firstRow + MSG_PER_PAGE - 1;
				messageList = msgDAO.selectList(conn, firstRow, endRow);
			} else {
				currentPage = 0;
				messageList = Collections.emptyList();
			}
			return new MessageListView(messageList, totalMessages, currentPage, MSG_PER_PAGE, firstRow, endRow);
		} catch (SQLException e) {
			throw new ServiceException("목록 구하기 실패: " + e.getMessage(), e);
		} finally {
			JDBCUtil.close(conn);
		}
	}

}
