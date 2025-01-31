package com.tmybatis.member.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionTemplate {
	
	//시작하는데 아래코드 작성시 SqlSession~작성후 임포트시
	//ibatis로 해야함!!그전에 lib에 mybatis-3.5~넣어주고 시작!!
	public static SqlSession getSqlSession() { //1.
		//2.!!
		SqlSession session = null;
		//SessionFactoryBuilder --> SessionFactory --> session!!
		
		//6.String resource =""; ""안에 경로를 적어줌!!
		String resource ="mybatis-config.xml";
		
		//5.InputStream적고 임포트!위에import java.io.InputStream; 확인!!아래코드작성!
		//	InputStream is;
		//8. Resources 추가해서 콘스하면 2번재?ibatis로 Resources로임포트!
		//하고 .get적으면 Resources.getResourceAsStream(resource);
		//아래 코드로 선택!! 
		//선택후 9!! Resources.getResourceAsStream(resource)
		// 클릭후 서라운드 트라이 캐치 해줌!!!
		//캐치해주고!! try 안에!!!3.4.7. 넣어줌!!!
		//넣기전에 코드는 주석처리함!!
		//그러면 끝!!!적고 Service로 이동!!!
		
		InputStream is;
		try {
			is = Resources.getResourceAsStream(resource);
			//3.
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			
			//4.SqlSession적고 콘스하면아래 SqlSessionFactory선택!!후 아래 코드작성!
			SqlSessionFactory factory = builder.build(is);
			
			//7. 아래코드적고!!xml파일작성후!6에 경로적어주고!!8로이동!!
			session = factory.openSession(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//3.
//		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		
		//4.SqlSession적고 콘스하면아래 SqlSessionFactory선택!!후 아래 코드작성!
//		SqlSessionFactory factory = builder.build(is);
		
		//7. 아래코드적고!!xml파일작성후!6에 경로적어주고!!8로이동!!
//		session = factory.openSession();
		
		
		return session;
	}
}
