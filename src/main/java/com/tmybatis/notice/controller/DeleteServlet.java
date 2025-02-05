package com.tmybatis.notice.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.tmybatis.member.common.NavigationUtil;
import com.tmybatis.notice.model.service.NoticeService;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet(name = "NoticeDeleteServlet", urlPatterns = { "/notice/delete" })
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		NoticeService nService = new NoticeService();
		int noticeNo = (request.getParameter("noticeNo") != null)
				? Integer.parseInt(request.getParameter("noticeNo")) : 0;
		int result = nService.deleteNotice(noticeNo);
		if(result > 0) {
			//성공
			response.sendRedirect("/notice/list");
		}else {
			//실패
			NavigationUtil.navigateToError(request, response, "500", "서비스가 완료되지않았습니다");
		}
	}

}
