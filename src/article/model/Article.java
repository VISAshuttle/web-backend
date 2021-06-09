package article.model;

import java.util.Date;

import auth.model.User;

public class Article {

	private Integer articleNo;
	private User writer;
	private String title;
	private Date regDate;
	private Date modifiedDate;
	private int readCount;

	public Article(Integer articleNo, User writer, String title, Date regDate, Date modifiedDate, int readCount) {
		this.articleNo = articleNo;
		this.writer = writer;
		this.title = title;
		this.regDate = regDate;
		this.modifiedDate = modifiedDate;
		this.readCount = readCount;
	}

	public Integer getArticleNo() {
		return articleNo;
	}

	public User getWriter() {
		return writer;
	}

	public String getTitle() {
		return title;
	}

	public Date getRegDate() {
		return regDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public int getReadCount() {
		return readCount;
	}

}