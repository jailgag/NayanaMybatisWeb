package com.tmybatis.notice.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.tmybatis.notice.model.vo.Notice;

public class NoticeDAO {

	public int insertNotice(SqlSession session, Notice notice) {
		// TODO Auto-generated method stub
		int result = session.insert("NoticeMapper.insertNotice", notice);
		return result;
	}

	public List<Notice> selectList(SqlSession session) {
		// TODO Auto-generated method stub
		int offset =0 ;
		int limit = 10;
		RowBounds rowBounds = new RowBounds(offset, limit);
		//이아래코드는 rowBounds 적용전과 후 코드!!주석처리함!
//		List<Notice> nList = session.selectList("NoticeMapper.selectList");
		List<Notice> nList = session.selectList("NoticeMapper.selectList", null,rowBounds);
		return nList;
	}

	public Notice selectOneByNO(SqlSession session, int noticeNo) {
		// TODO Auto-generated method stub
		Notice notice = session.selectOne("NoticeMapper.selectOneByNo", noticeNo);
		return notice;
	}

	public int deleteNotice(SqlSession session, int noticeNo) {
		int result = session.delete("NoticeMapper.deleteNotice", noticeNo);
		return result;
		
	}

}
