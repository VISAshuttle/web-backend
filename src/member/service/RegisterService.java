package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import jdbc.ConnectionProvider;
import jdbc.JDBCUtil;
import member.dao.MemberDAO;
import member.model.Member;
import member.service.exception.DuplicateIdException;

public class RegisterService {
	private MemberDAO memberDAO = new MemberDAO();

	public void register(RegisterRequest regReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection("board");
			conn.setAutoCommit(false);

			Member member = memberDAO.selectById(conn, regReq.getId());
			if (member != null)	throw new DuplicateIdException();

			memberDAO.insert(conn, new Member(regReq.getId(), regReq.getName(), regReq.getPassword(), new Date()));
			conn.commit();
		} catch (SQLException e) {
			JDBCUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JDBCUtil.close(conn);
		}
	}

}