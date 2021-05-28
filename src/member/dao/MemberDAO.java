package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import jdbc.JDBCUtil;
import member.model.Member;

public class MemberDAO {
	
	public Member selectById(Connection conn, String id) throws SQLException {
		PreparedStatement preState = null;
		ResultSet rs = null;
		try {
			preState = conn.prepareStatement("SELECT * FROM member WHERE memberid = ?");
			preState.setString(1, id);
			rs = preState.executeQuery();
			if (rs.next())
				return new Member(
						rs.getString("memberid"),
						rs.getString("name"),
						rs.getString("password"),
						MapTimestampToDate(rs.getTimestamp("regdate"))
						);
			else
				return null;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(preState);
		}
	}

	private Date MapTimestampToDate(Timestamp date) {
		return date == null ? null : new Date(date.getTime());
	}

	public void insert(Connection conn, Member member) throws SQLException {
		try (PreparedStatement preState = conn.prepareStatement("INSERT INTO member VALUES(?, ?, ?, ?)")) {
			preState.setString(1, member.getId());
			preState.setString(2, member.getName());
			preState.setString(3, member.getPassword());
			preState.setTimestamp(4, new Timestamp(member.getRegDate().getTime()));
			preState.executeUpdate();
		}
	}

	public void update(Connection conn, Member member) throws SQLException {
		try (PreparedStatement preState = conn.prepareStatement("UPDATE member SET name = ?, password = ? WHERE memberid = ?")) {
			preState.setString(1, member.getName());
			preState.setString(2, member.getPassword());
			preState.setString(3, member.getId());
			preState.executeUpdate();
		}
	}
	
}