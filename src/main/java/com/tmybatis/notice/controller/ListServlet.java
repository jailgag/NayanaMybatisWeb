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

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/notice/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//02/06고치는 과정 500에러!!삼항연산자 안써서그렇다함!
		NoticeService nService = new NoticeService();
		//endNavi의 최대값이 전체 게시물에 따라서 달라질수 있음
		//ex) 전체 게시물에의 갯수가 232개이고 1페이지당 10개씩 보여준다 하면
		//endNavi의 최대값은 24가됨 -> 이것을 식으로 써서 전체 게시물이 변경될때마다 달라지도록 해야함
		
		int totalCount = 233;
		int boardLimit =10;
		//아래식은 소수점으로 되니깐 더블을 쓰되 강제형변환을 해줘야한다?
		int maxPage =(int)Math.ceil((double)totalCount/boardLimit);;
		
//		maxPage = (totalCount%boardLimit > 0) 
//				? boardLimit / boardLimit+1 
//						: totalCount/boardLimit;
		//		if(totalCount % boardLimit >0)
//		int maxPage = totalCount /boardLimit + 1;
		
		//02/06고치는 과정 500에러!!삼항연산자 안써서그렇다함!
		int currentPage = (request.getParameter("currentPage") != null)
				? Integer.parseInt(request.getParameter("currentPage")) : 1; 
		List<Notice> nList = nService.selectListAll(currentPage);
		if(nList.size() >0) {
			//
			//currentPage: 1~ 5 , startNavi: 1, endNavi: 5 5*1
			//currentPage: 6~ 10 , startNavi: 6, endNavi: 10 = 5*2
			//currentPage: 11~ 15 , startNavi: 11, endNavi: 15= 5*3
			int naviCountPerPage = 5;
			int startNavi = (currentPage-1)/naviCountPerPage*naviCountPerPage+1;
			int endNavi = (startNavi-1)+naviCountPerPage;
			//밑에 코드추가!!
			if(endNavi > maxPage) {
				endNavi = maxPage;
			}
			request.setAttribute("nList", nList);
			request.setAttribute("startNavi",startNavi );
			request.setAttribute("endNavi", endNavi);
			request.getRequestDispatcher("/WEB-INF/views/notice/list.jsp")
			.forward(request, response);
		}else {
			NavigationUtil.navigateToError(request, response, "404", "데이터가 존재하지 않습니다");
		}
	}

}
