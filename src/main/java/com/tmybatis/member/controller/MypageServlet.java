package com.tmybatis.member.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.tmybatis.member.common.NavigationUtil;
import com.tmybatis.member.model.service.MemberService;
import com.tmybatis.member.model.vo.Member;

/**
 * Servlet implementation class MypageServlet
 */
@WebServlet("/member/mypage")
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MemberService mService = new MemberService();
		HttpSession session = request.getSession();
		Member searchOne = (Member)session.getAttribute("result");
//		String memberId = searchOne.getMemberId();
//		String memberId = (String)(request.getSession()).getAttribute("memberId"); //오브젝트라 다운캐스팅이 필요하다!
//		Member member = mService.selectOneById(memberId);
		//이코드 다시 복습할때 정리할것!!
		if( searchOne != null) {
			String memberId = searchOne.getMemberId();
			Member member = mService.selectOneById(memberId);
			if(member != null) {
				request.setAttribute("member", member);
				request.getRequestDispatcher("/WEB-INF/views/member/mypage.jsp")
				.forward(request, response);
				
			}else {
				request.getRequestDispatcher("/WEB-INF/views/common/error/error.jsp")
				.forward(request, response);
				NavigationUtil.navigateToError(request, response, "404", "데이터가 존재하지않습니다");
				
				//request.getRequestDispatcher("/WEB-INF/views/common/error/error.jsp")
				//.forward(request, response);
			}
		}else {
				request.getRequestDispatcher("/WEB-INF/views/common/error/error.jsp")
				.forward(request, response);
				NavigationUtil.navigateToError(request, response, "404", "로그인이 필요합니다");
				
				//request.getRequestDispatcher("/WEB-INF/views/common/error/error.jsp")
				//.forward(request, response);
			}
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
