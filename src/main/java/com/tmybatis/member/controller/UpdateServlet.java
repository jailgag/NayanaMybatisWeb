package com.tmybatis.member.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.tmybatis.member.common.NavigationUtil;
import com.tmybatis.member.model.service.MemberService;
import com.tmybatis.member.model.vo.Member;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/member/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String phone =request.getParameter("phone");
		String address =request.getParameter("address");
		String hobby = request.getParameter("hobby");
		String memberId = request.getParameter("memberId");
		Member member = new Member(memberId, email, phone, address, hobby);
		MemberService mService = new MemberService();
		int result = mService.updateMember(member); //다시 작성!!
		if(result > 0) {
			//성공시 메인페이지(또는 마이페이지)이동
			response.sendRedirect("/member/mypage"); // 마이페이지로 이동오키!!
		}else {
			request.getRequestDispatcher("/WEB-INF/views/common/error/error.jsp")
			.forward(request, response);
			NavigationUtil.navigateToError(request, response, "500", "서비스가 완료되지 않았습니다");
			//request.getRequestDispatcher("/WEB-INF/views/common/error/error.jsp")
			//.forward(request, response);
		}
	}

}
