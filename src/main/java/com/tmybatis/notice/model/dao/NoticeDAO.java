package com.tmybatis.notice.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.tmybatis.notice.model.vo.Notice;

public class NoticeDAO {

	public int insertNotice(SqlSession session, Notice notice) {
		// TODO Auto-generated method stub
		int result = session.insert("NoticeMapper.insertNotice", notice);
		return result;
	}

}
