package auth.service;

import java.sql.Connection;
import java.sql.SQLException;

import auth.model.User;
import auth.service.exception.LoginFailException;
import jdbc.ConnectionProvider;
import member.dao.MemberDAO;
import member.model.Member;

public class LoginService {

	private MemberDAO MemberDAO = new MemberDAO();

	public User login(String id, String password) {
		try (Connection conn = ConnectionProvider.getConnection("board")) {
			Member member = MemberDAO.selectById(conn, id);
			if (member == null || !member.matchPassword(password))
				throw new LoginFailException();
			else
				return new User(member.getId(), member.getName());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}