package article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import article.model.Article;
import auth.model.User;
import jdbc.JDBCUtil;

public class ArticleDAO {

	public Article insert(Connection conn, Article article) throws SQLException {
		PreparedStatement preState = null;
		Statement state = null;
		ResultSet rs = null;
		try {
			preState = conn.prepareStatement("insert into article "
					+ "(writer_id, writer_name, title, regdate, moddate, read_cnt) " + "values (?,?,?,?,?,0)");
			preState.setString(1, article.getWriter().getId());
			preState.setString(2, article.getWriter().getName());
			preState.setString(3, article.getTitle());
			preState.setTimestamp(4, toTimestamp(article.getRegDate()));
			preState.setTimestamp(5, toTimestamp(article.getModifiedDate()));
			int insertedCount = preState.executeUpdate();

			if (insertedCount > 0) {
				state = conn.createStatement();
				rs = state.executeQuery("select last_insert_id() from article");
				if (rs.next()) {
					Integer newNo = rs.getInt(1);
					return new Article(newNo, article.getWriter(), article.getTitle(), article.getRegDate(),
							article.getModifiedDate(), 0);
				}
			}
			return null;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(state);
			JDBCUtil.close(preState);
		}
	}

	private Timestamp toTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}

	public int selectCount(Connection conn) throws SQLException {
		Statement state = null;
		ResultSet rs = null;
		try {
			state = conn.createStatement();
			rs = state.executeQuery("select count(*) from article");
			if (rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(state);
		}
	}

	public List<Article> select(Connection conn, int startRow, int size) throws SQLException {
		PreparedStatement preState = null;
		ResultSet rs = null;
		try {
			preState = conn.prepareStatement("select * from article " + "order by article_no desc limit ?, ?");
			preState.setInt(1, startRow);
			preState.setInt(2, size);
			rs = preState.executeQuery();
			List<Article> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertArticle(rs));
			}
			return result;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(preState);
		}
	}

	private Article convertArticle(ResultSet rs) throws SQLException {
		return new Article(rs.getInt("article_no"), new User(rs.getString("writer_id"), rs.getString("writer_name")),
				rs.getString("title"), toDate(rs.getTimestamp("regdate")), toDate(rs.getTimestamp("moddate")),
				rs.getInt("read_cnt"));
	}

	private Date toDate(Timestamp timestamp) {
		return new Date(timestamp.getTime());
	}

	public Article selectById(Connection conn, int no) throws SQLException {
		PreparedStatement preState = null;
		ResultSet rs = null;
		try {
			preState = conn.prepareStatement("select * from article where article_no = ?");
			preState.setInt(1, no);
			rs = preState.executeQuery();
			Article article = null;
			if (rs.next()) {
				article = convertArticle(rs);
			}
			return article;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(preState);
		}
	}

	public void increaseReadCount(Connection conn, int no) throws SQLException {
		try (PreparedStatement preState = conn
				.prepareStatement("update article set read_cnt = read_cnt + 1 " + "where article_no = ?")) {
			preState.setInt(1, no);
			preState.executeUpdate();
		}
	}

	public int update(Connection conn, int no, String title) throws SQLException {
		try (PreparedStatement preState = conn
				.prepareStatement("update article set title = ?, moddate = now() " + "where article_no = ?")) {
			preState.setString(1, title);
			preState.setInt(2, no);
			return preState.executeUpdate();
		}
	}

}