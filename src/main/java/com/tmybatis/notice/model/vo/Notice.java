package com.tmybatis.notice.model.vo;

import java.sql.Timestamp;

public class Notice {
	
	private int noticeNo;
	private String noticeSubject;
	private String noticeContent;
	private String noticeWriter;
	private Timestamp writeDate; //임포트!!
	private int viewCount;
	private String attchmentName;
	private String attchmentPath;
	private String attchmentDate;
	
	public Notice() {}

	
	
	//WriteServlet꺼!!3개!!
	public Notice(String noticeSubject, String noticeContent, String noticeWriter) {
		super();
		this.noticeSubject = noticeSubject;
		this.noticeContent = noticeContent;
		this.noticeWriter = noticeWriter;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public String getNoticeSubject() {
		return noticeSubject;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public String getNoticeWriter() {
		return noticeWriter;
	}

	public Timestamp getWriteDate() {
		return writeDate;
	}

	public int getViewCount() {
		return viewCount;
	}

	public String getAttchmentName() {
		return attchmentName;
	}

	public String getAttchmentPath() {
		return attchmentPath;
	}

	public String getAttchmentDate() {
		return attchmentDate;
	}

	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", noticeSubject=" + noticeSubject + ", noticeContent=" + noticeContent
				+ ", noticeWriter=" + noticeWriter + ", writeDate=" + writeDate + ", viewCount=" + viewCount
				+ ", attchmentName=" + attchmentName + ", attchmentPath=" + attchmentPath + ", attchmentDate="
				+ attchmentDate + "]";
	}
	
	
}
