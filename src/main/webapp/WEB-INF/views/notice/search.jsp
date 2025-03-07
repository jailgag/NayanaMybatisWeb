<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>제주의 꿈 - 공지사항 목록</title>
			<link rel="stylesheet" href="../resources/css/reset.css">
		   	<link rel="stylesheet" href="../resources/css/header.css">
		   	<link rel="stylesheet" href="../resources/css/footer.css">
		   	<link rel="stylesheet" href="../resources/css/list.css">
	</head>
	<body>
		<div id="container">
			<jsp:include page="/WEB-INF/views/include/header.jsp" ></jsp:include>
			<main>
		
		<section class="board-title">
		<h1>공지사항</h1>
		</section>
		<div class="search-container">
			<form class="search-form"  action="/notice/search" method="get"">
				<select class="search-select" name="searchCondition">
					<option value="title">제목</option>
					<option value="content">내용</option>
					<option value="writer">작성자</option>
				</select>
				<input type="text" class="search-input" name="searchKeyword" placehoder="검색어를 입력하세요">
				<button type="submit" class="search-button">검색</button>
			</form>
		</div>
		
		<section class="board-content">
			<table class="notice-table">
			
			
			<thead>
				<tr>
					<th class="num">번호</th>
					<th class="title">제목</th>
					<th class="writer">작성자</th>
					<th class="date">작성일</th>
					<th class="views">조회수</th>
				</tr>
			</thead>
			<tbody>
			<!-- varstatus는 반복과정에서 반복상태 정보를 담을수있게 하는 속성
				~ 1~2는 결과값이 정수
				1.index : 현재 반복의 0부터 시작하는 인덱스번호
				2.count : 반복된 항목의 수
				~3~6번은 결과값이 true, false
				3.first : 첫번째이면 true, 아니면  false
				4.last :마지막이면 true, 아니면  false
				5.even : 짝수 번째면 true, 아니면  false
				6.odd : 홀수 번째면 true, 아니면  false
				**주로 1~2를 사용함!
				아래 코드로 하니 공지사항 번호가 10~시작?
				<td class="num">${nList.size() - i.index }
				 -->
			<c:forEach items="${searchList }" var="notice" varStatus="i">
				<tr>
					<td class="num">${searchList.size() - i.index }</td>
					<td class="title"><a href="/notice/detail?noticeNo=${notice.noticeNo }">"${notice.noticeSubject }</a></td>
					<td class="writer">${notice.noticeWriter }</td>
					<td class="date">${notice.writeDate }</td>
					<td class="views">${notice.viewCount }</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
			<div class="pagination">
			<!--  
			404에러 떠서 오타수정후 정상작동하나 < 여기는 404뜸
			/ 오입력!!-->
			<c:if test="${startNavi ne 1 }">
				<a href="/notice/list?currentPage=${startNavi -1 }" class="prev">&lt;</a>
			</c:if>
			<c:forEach begin="${startNavi }" end="${endNavi}" var="p">
			<a href="/notice/list?currentPage=${p }">${p }</a>
			</c:forEach>
			<c:if test="${endNavi ne maxPage }">
				<a href="/notice/list?currentPage=${endNavi +1 }" class="next">&gt;</a>
			</c:if>
			</div>
		</section>
		</main> 
		 <jsp:include page="/WEB-INF/views/include/footer.jsp" /> 
		 </div>
	</body>
</html>