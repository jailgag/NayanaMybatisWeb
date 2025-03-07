package com.tmybatis.notice.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.tmybatis.member.common.NavigationUtil;
import com.tmybatis.member.model.vo.Member;
import com.tmybatis.notice.model.service.NoticeService;
import com.tmybatis.notice.model.vo.Notice;

/**
 * Servlet implementation class WriteServlet
 */
@WebServlet("/notice/write")
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/views/notice/write.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String noticeSubject = request.getParameter("noticeSubject");
		String noticeContent = request.getParameter("noticeContent");
		//로그인 사람의 아이디.,세션에서 아디를 가져옴
		HttpSession session = request.getSession();
		Member searchOne =(Member)session.getAttribute("result");
		String noticeWriter = null;
		if(searchOne != null) {
			noticeWriter = searchOne.getMemberId();
		}
		Notice notice = new Notice(noticeSubject, noticeContent, noticeWriter);
		NoticeService nService = new NoticeService();
		int result = nService.insertNotice(notice);
		if(result > 0) {
			//성공시 리스트로 이동 //설계한 
			response.sendRedirect("/notice/list");
		}else {
			NavigationUtil.navigateToError(request, response, "500", "서비스가 완료되지 않았습니다");
		}
	}

}
