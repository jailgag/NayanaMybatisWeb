package com.tmybatis.notice.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.tmybatis.member.common.SqlSessionTemplate;
import com.tmybatis.notice.model.dao.NoticeDAO;
import com.tmybatis.notice.model.vo.Notice;
import com.tmybatis.notice.model.vo.SearchVO;

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
	//ListServlet에서 넘어옴!!(공지사항조회)
	public List<Notice> selectListAll(int currentPage) {
		// TODO Auto-generated method stub
		List<Notice> nList = nDao.selectList(session, currentPage);
		return nList;
	}
	//3.DetailServlet에서 넘어왔고 !!!공지사항 상세조회!!!
	public Notice selectOneByNo(int noticeNo) {
		// TODO Auto-generated method stub
		Notice notice = nDao.selectOneByNO(session, noticeNo);
		return notice;
	}
	//공지사항 삭제! deleteServlet에서 넘어옴!
	public int deleteNotice(int noticeNo) {
		// TODO Auto-generated method stub
		int result = nDao.deleteNotice(session,noticeNo);
		
		return result;
		
	}
	//
	public int updateNotice(Notice notice) {
		int result = nDao.updateNotice(session,notice);
		return result;
	}

	public int getTotalCount() {
		// TODO Auto-generated method stub
		int totalCount = nDao.getTotalCount(session);
		return totalCount;
	}
	//02/07
	public List<Notice> selectSearchList(SearchVO search) {
		List<Notice> searchList = nDao.selectSearchList(session, search);
		return searchList;
	}

		
}
