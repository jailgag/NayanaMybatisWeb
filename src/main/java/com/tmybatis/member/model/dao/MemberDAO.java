package com.tmybatis.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//The import java.sql.SQLException is never used??
//상관없음!!
import org.apache.ibatis.session.SqlSession;

import com.tmybatis.member.model.vo.Member;

public class MemberDAO {

	
	//Service에서 코드작성후 아래쓴코드 지우고(주석처리함!) 다시
	//Service에서 메소드만들어서 여기로 넘어옴!!
	//그리고 아래코드 작성!!
	public Member selectOneByLogin(SqlSession conn, Member member) {
		// TODO Auto-generated method stub
		//아래코드 Member result = conn.selectOne작성후
		//콘스해서 selectOne선택해줌!!복습필요함!!!
		//아래코드("MemberMapper",member)
		//("MemberMapper"는 member-mapper.xml에 namespace값을
		//넣어준다!!
		//namespace="MemberMapper니깐
		//그리고!!member-mapper.xml에 id값으로 추가!
		//<select id="selectOneByLogin"값추가!!  
		//아래코드 완성!!복습필요 !!
		Member result = conn.selectOne("MemberMapper.selectOneByLogin",member);
		return result;
	}
	//MemberService에서 넘어옴!!
	public int insertMember(SqlSession conn, Member member) {
		// TODO Auto-generated method stub
		//()안에 "MemberMapper.(insert id부분을 적어준다!!)"
		int result = conn.insert("MemberMapper.insertMember",member); //옆에코드는 member-mapper.xml에서 ()안에 적어주기!!
		return result ;
	}
	public Member selecOneById(SqlSession conn, String memberId) {
		// TODO Auto-generated method stub
		Member member = conn.selectOne("MemberMapper.selectOneBylogin",memberId);
		return member;
	}
	//업데이트서블랏
	public int UpdateMember(SqlSession conn, Member member) {
		// TODO Auto-generated method stub
		int result = conn.update("MemberMapper.updateMember",member); //옆에코드는 member-mapper.xml에서 ()안에 적어주기!!
		return result ;
		
	}
	public int deleteMember(SqlSession conn, String memberId) {
		// TODO Auto-generated method stub
		int result = conn.delete("MemberMapper.deleteMember",memberId); //옆에코드는 member-mapper.xml에서 ()안에 적어주기!!
		return result ;
		
		
	}
		
	
	
	

	
	
//Service에서 넘어옴!!Login
//	public Member selectOneByLogin(Connection conn, Member member) throws SQLException {
		// TODO Auto-generated method stub
		//
		
		
		
		//아래코드는 mybatis SqlSessionTemplate작성후 memberService에서 작업후
		//넘어온후 다시 작성해야해서 아래코드는 주석처리함!!!
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		Member result = null;
//		String query ="SELECT * FROM MEMBER_TBL WHERE MEMBER_ID = ? AND MEMBER_PWD = ?";
//		pstmt = conn.prepareStatement(query); //스로우!!
//		
//		pstmt.setString(1, member.getMemberId());
//		pstmt.setString(2, member.getMemberPwd());
//		
//		rset = pstmt.executeQuery();
//		if(rset.next()) {
//			String memberId = rset.getString("MEMBER_ID");
//			String memberName = rset.getString("MEMBER_NAME");
//			String email = rset.getString("EMAIL");
//			result = new Member(memberId, memberName, email);
//			
//		}
//		pstmt.close();
//		rset.close();
//		return result;
//	}

}
