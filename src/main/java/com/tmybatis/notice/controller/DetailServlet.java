package com.tmybatis.notice.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.tmybatis.member.common.NavigationUtil;
import com.tmybatis.notice.model.service.NoticeService;
import com.tmybatis.notice.model.vo.Notice;

/**
 * Servlet implementation class DetailServlet
 */
@WebServlet("/notice/detail")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 복습할때 아래 코드 적고 list.jsp도 확인해서 쿼리스트링 바꾸는 ?? 작업해줘야함!!복습할때 집고 넘어갈것!!!
	 * 복습할때 쿼리스트링부분 끝에 숫자만 바뀌어도 게시판이 조회가됨!!
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//설명란적기!!
		//페이지로 이동하는데 그 페이지가 비어있지 않으려면
		//디비에서 Notice객체를 가져오고 request에 setAttribute해서
		//detail.jsp에서 데이터가 출력되도록함
		
		NoticeService nService = new NoticeService();
		//아래 Int형의쿼리스트링 코드
		int noticeNo = (request.getParameter("noticeNo") != null)
				? Integer.parseInt(request.getParameter("noticeNo")) : 1; 
//		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		Notice notice = nService.selectOneByNo(noticeNo);
		if(notice != null) {
			//밑에 setAttribute("notice"~~)값은 detail.jsp에el태그값과 일치!!
			request.setAttribute("notice", notice);
			request.getRequestDispatcher("/WEB-INF/views/notice/detail.jsp")
			.forward(request, response);
			
		}else {
			NavigationUtil.navigateToError(request, response, "404", "데이터가 존재하지않습니다");
		}
	}

}
