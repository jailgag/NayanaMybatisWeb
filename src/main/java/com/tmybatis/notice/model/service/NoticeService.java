package com.tmybatis.notice.model.service;

import org.apache.ibatis.session.SqlSession;

import com.tmybatis.member.common.SqlSessionTemplate;
import com.tmybatis.notice.model.dao.NoticeDAO;
import com.tmybatis.notice.model.vo.Notice;

public class NoticeService {

	private NoticeDAO nDao;
	
	private SqlSession session;
	
	public NoticeService() {
		nDao = new NoticeDAO();
		session = SqlSessionTemplate.getSqlSession();
		
	}
	
	public int insertNotice(Notice notice) {
		// TODO Auto-generated method stub
		int result = nDao.insertNotice(session,notice);
		
		return result;
	}
	
		
}
