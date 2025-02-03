package com.tmybatis.member.controller;

import java.io.IOException;

import com.tmybatis.member.common.NavigationUtil;
import com.tmybatis.member.model.service.MemberService;
import com.tmybatis.member.model.vo.Member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/member/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * **파일을 옮길때는 무조건 서버를 끄고 옮긴다 안그러면 나중에 캐시?때문에 문제발생!!
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/views/member/login.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String memberId = request.getParameter("memberId");
		String memberPwd =request.getParameter("memberPw") ;
		Member member = new Member(memberId, memberPwd);
		Member result = new MemberService().selectOneByLogin(member);//콘트롤시프트O!!임포트
		if(result != null) {
			//세션에 정보를저장!!
			//어느 페이지에서든지 로그인 인증정보확인 가능!
			HttpSession session = request.getSession();
			//전코드는 ()안에 ("member", member);였는데
			//이번엔n.setAttribute("result", result);임!!!
			//haader.jsp에서
			// <c:if test="${sessionScope.member.memberId == null }">
			// <c:if test="${sessionScope.result.memberId == null }">
			//가운에 result로 바꿔줘야함!!
			//그러면 마이페이지로 넘어감!! 안바꿔주면 다시 위에 로그인 뜸!!
			session.setAttribute("result", result);
			response.sendRedirect("/");
		}else {
			//실패
//			request.getRequestDispatcher("/WEB-INF/views/common/error/error.jsp")
//			.forward(request, response);
			NavigationUtil.navigateToError(request, response, "404", "데이터가 존재하지 않습니다");
//			request.setAttribute("error", 404);
//			request.setAttribute("errorMessage", "데이터가 존재하지않습니다");
//			request.getRequestDispatcher("/WEB-INF/views/common/error/error.jsp")
//			.forward(request, response);
		}
	}

}
