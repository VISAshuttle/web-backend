package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;

import jdbc.ConnectionProvider;
import jdbc.JDBCUtil;
import member.dao.MemberDAO;
import member.model.Member;
import member.service.exception.InvalidPasswordException;
import member.service.exception.MemberNotFoundException;

public class PasswordChangeService extends HttpServlet {

	private MemberDAO memberDAO = new MemberDAO();

	public void changePassword(String id, String currentPassword, String newPassword) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection("board");
			conn.setAutoCommit(false);

			Member member = memberDAO.selectById(conn, id);
			if (member == null)
				throw new MemberNotFoundException();
			if (!member.matchPassword(currentPassword))
				throw new InvalidPasswordException();
			
			member.changePassword(newPassword);
			memberDAO.update(conn, member);
			conn.commit();
		} catch (SQLException e) {
			JDBCUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JDBCUtil.close(conn);
		}
	}

}