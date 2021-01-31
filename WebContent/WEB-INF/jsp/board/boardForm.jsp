<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>

<!-- CSS -->
<link rel="stylesheet" href="resources/css/boardForm.css">
</head>

<script>
	function formSubmit(str){
		frm.bId.value = str;
		frm.submit();
	}
</script>

<jsp:include page="../main/menu.jsp" />
<body>
	<form id="frm" name="frm" action="boardView.do" method="post">
		<input type="hidden" id="bId" name="bId">
	</form>
		<div align="center">
			<table class="table table-striped table-hover" border="1">
				<h1>게시판</h1>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>날짜</th>
						<th>조회수</th>
					</tr>
					<c:if test="${empty list }">
						<tr>
							<td>게시글이 없습니다.</td>
						</tr>
					</c:if>
					<c:if test="${not empty list }">
						<c:forEach var="vo" items="${list }">
							<tr onclick="formSubmit(${vo.bId})">
								<td>${vo.bId }</td>
								<td>${vo.bTitle }</td>
								<td>${vo.bName }</td>
								<td>${vo.bDate }</td>
								<td>${vo.bHit }</td>
							</tr>
						</c:forEach>
					</c:if>
			</table>
			
			<hr/>
		<div>
			
			<div id="page" class="text-center">
				<ul class="pagination">
					<li><a href="#">&laquo;</a></li>
					<li class="active"><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">&raquo;</a></li>
				</ul>
			</div>
			<button class="btn btn-default" onclick="location.href='boardInputForm.do'">글쓰기</button>
		</div>
	</div>	

	
	
	
</body>
<jsp:include page="../main/footer.jsp" />
</html>