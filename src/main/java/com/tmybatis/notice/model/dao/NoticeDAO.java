package com.tmybatis.notice.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.tmybatis.notice.model.vo.Notice;
import com.tmybatis.notice.model.vo.SearchVO;

public class NoticeDAO {
	
	
	//02/04일자시작
	public int insertNotice(SqlSession session, Notice notice) {
		// TODO Auto-generated method stub
		int result = session.insert("NoticeMapper.insertNotice", notice);
		return result;
	}
	//Service에서 넘어옴!!!공지사항 조회!!02/04~5일 강의!!
	public List<Notice> selectList(SqlSession session, int currentPage) {
		// TODO Auto-generated method stub
		//int offset =0을 10으로 바꿈 ;
		//currentPage가 1이면 offset은 0
		//currentPage가 2이면 offset은 10
		//currentPage가 3이면 offset은 20
		
		int limit = 10;
		int offset = (currentPage-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		//이아래코드는 rowBounds 적용전과 후 코드!!주석처리함!주석처리한건(5일강의때 차순정리하는코드작성후)남겨둠!!
//		List<Notice> nList = session.selectList("NoticeMapper.selectList");
		List<Notice> nList = session.selectList("NoticeMapper.selectList", null,rowBounds);
		return nList;
	}
	//공지사항 상세조회!!02/05강의 수업!!
	public Notice selectOneByNO(SqlSession session, int noticeNo) {
		// TODO Auto-generated method stub
		Notice notice = session.selectOne("NoticeMapper.selectOneByNo", noticeNo);
		return notice;
	}
	//공지사항 삭제!!
	public int deleteNotice(SqlSession session, int noticeNo) {
		int result = session.delete("NoticeMapper.deleteNotice", noticeNo);
		return result;
		
	}
	//
	public int updateNotice(SqlSession session, Notice notice) {
		int result = session.update("NoticeMapper.updateNotice", notice);
		return result;
	}
	public int getTotalCount(SqlSession session) {
		// TODO Auto-generated method stub
		int totalCount = session.selectOne("NoticeMapper.getTotalCount");
		return totalCount;
	}
	public List<Notice> selectSearchList(SqlSession session, SearchVO search) {
		List<Notice> searchList = session.selectList("NoticeMapper.selectSearchList",search);
		return searchList;
	}
	

}
