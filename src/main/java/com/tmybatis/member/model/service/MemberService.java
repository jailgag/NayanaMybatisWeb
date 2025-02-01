package com.tmybatis.member.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.tmybatis.member.common.JDBCTemplate;
import com.tmybatis.member.common.SqlSessionTemplate;
import com.tmybatis.member.model.dao.MemberDAO;
import com.tmybatis.member.model.vo.Member;

public class MemberService {

	//사용을 하려면!!1.번
	private JDBCTemplate jdbcTemplate;
	
	//4.mDAO 만들기!!
	private MemberDAO mDao;
	
	//*1.아래코드는 SqlSessionTemplate 다적고 넘어와서 추가적으로 적어준거임!!
	//*2로 이동!!
	private SqlSession conn; //마이바티스로 임포트!!
	
	
	//2.번코드 적어줌!!객체를 만들어줌!!
	public MemberService() {
		
		//*2번코드작성!!후 
		//public Member selectOneByLogin(Member member)~
		//로 이동!!*3으로 이동!!!
		//*3으로이동!!
		conn = SqlSessionTemplate.getSqlSession();
		
		//3.JDBC객체!!는 private니깐 new를 만들수 없다!!
		jdbcTemplate = JDBCTemplate.getInstance();
		//5.mDao객체 만들기
		mDao = new MemberDAO();
	}
	
	//로그인서블릿에서 넘어옴!
	public Member selectOneByLogin(Member member) {
		// TODO Auto-generated method stub
		//*3에서 넘어와서 코드 다시 작성!!후 밑에코드 메소드만들고
		//DAO로 넘어감!!!
		
		Member result = mDao.selectOneByLogin(conn, member);
		return result;
		
		
		
		
		
		//*3.이동했는데 다시 코드 작성함!!
		//주석처리한건 그전코드!!
		
//		Connection conn= null;
//		Member result = null;
//		try {
//			conn = jdbcTemplate.getConnection();
//			result = mDao.selectOneByLogin(conn, member);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return result;
	}

	//SingUpServlet에서 넘어옴!!
	public int insertMember(Member member) {
		// TODO Auto-generated method stub
		int result = mDao.insertMember(conn, member);
		return result;
	}
	
}
