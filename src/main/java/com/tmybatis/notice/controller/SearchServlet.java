package com.tmybatis.notice.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.tmybatis.member.common.NavigationUtil;
import com.tmybatis.notice.model.service.NoticeService;
import com.tmybatis.notice.model.vo.Notice;
import com.tmybatis.notice.model.vo.SearchVO;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/notice/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		NoticeService nService = new NoticeService();
		String searchCondition = request.getParameter("searchCondition");
		String searchKeyword =  request.getParameter("searchKeyword");
		//방법2가지!
		//1. 2개의 값을 담을 VO를 만들기
		SearchVO search = new SearchVO(searchCondition, searchKeyword);
		//2. HashMap을 이용하기
		List<Notice> searchList = nService.selectSearchList(search);
		if(searchList != null &&!searchList.isEmpty()) {
			int totalCount = nService.getTotalCount();
			int boardLimit =10;
			int maxPage =(int)Math.ceil((double)totalCount/boardLimit);
			int currentPage = (request.getParameter("currentPage") != null)
					? Integer.parseInt(request.getParameter("currentPage")) : 1; 
			int naviCountPerPage = 5;
			int startNavi = (currentPage-1)/naviCountPerPage*naviCountPerPage+1;
			int endNavi = (startNavi-1)+naviCountPerPage;
			//밑에 코드추가!!
			if(endNavi > maxPage) {
				endNavi = maxPage;
			}
			request.setAttribute("searchList", searchList);
			request.setAttribute("startNavi",startNavi);
			request.setAttribute("endNavi", endNavi);
			request.setAttribute("maxPage", maxPage);
			request.getRequestDispatcher("/WEB-INF/views/notice/search.jsp")
			.forward(request, response);
		}else {
			NavigationUtil.navigateToError(request, response, "404", "데이터가 존재하지 않습니다");
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
