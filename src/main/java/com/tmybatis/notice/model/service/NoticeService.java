package com.tmybatis.notice.model.service;

import java.util.List;

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

	public List<Notice> selectListAll() {
		// TODO Auto-generated method stub
		List<Notice> nList = nDao.selectList(session);
		return nList;
	}

	public Notice selectOneByNo(int noticeNo) {
		// TODO Auto-generated method stub
		Notice notice = nDao.selectOneByNO(session, noticeNo);
		return notice;
	}

	public int deleteNotice(int noticeNo) {
		// TODO Auto-generated method stub
		int result = nDao.deleteNotice(session,noticeNo);
		
		return result;
		
	}
	
		
}
