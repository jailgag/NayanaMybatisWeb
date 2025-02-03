<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서비스에러</title>
	 	<link rel="stylesheet" href="../resources/css/reset.css">
        <link rel="stylesheet" href="../resources/css/header.css">
	 	<link rel="stylesheet" href="../resources/css/footer.css">
	  	<link rel="stylesheet" href="../resources/css/error.css">
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
		<main>
			<div class="error-container">
		<h1	class="error-title">404</h1>
		<p class="error-message">
			찾으시는 페이지가 없습니다. 다시 시작하세요
		</p>
		<a href="/" class="home-button">홈으로 돌아가기</a>
		</div>
		</main>
		<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
	</div>
</body>
</html>