<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정 페이지</title>

<!-- CSS -->
<link rel="stylesheet" href="resources/css/boardForm.css">
<!-- Function -->
<script>
	function editAlert(){
		var msg = confirm("수정하시겠습니까?");
		if(msg){
		frm.action = "boardUpdateComplete.do";
		frm.submit();
		}
	}
	
	function editCancel(str){
		var msg = confirm("취소하시겠습니까?");
		if(msg){
			frm.action = "boardView.do";
			frm.submit();
		}
	}
</script>

</head>
<jsp:include page="../main/menu.jsp" />
<body>

<!-- Page content -->
<div style="max-width: 2000px; margin-top: 46px" align="center" id="main">

	<div align="center">
		<h1>게시글 수정 페이지</h1>
		
		<form id="frm" name="frm" method="post">
			<input type="hidden" id="bId" name="bId" value="${vo.bId }">
		
		
		<table class="table table-striped table-bordered" border="1">
			<tr>
				<th width="100">제목</th>
				<td align="center" colspan="7" id="bTitle">${vo.bTitle }</td>
				</tr>
			<tr>
				<th width="100">작성자</th>
				<td align="center">${vo.bName }</td>
				<th width="100">작성일자</th>
				<td align="center">${vo.bDate }</td>
				<th width="100">조회수</th>	
				<td align="center">${vo.bHit }</td>
				<td colspan="2"></td>
			</tr>
			
			<tr>
				<th width="50">내용</th>
				<td colspan="7"><textarea rows="10" cols="100" required="required" id="bContent" name="bContent">${vo.bContent }</textarea></td>
			</tr>
		</table>

		<hr />
		<div>
			<button class="btn btn-default" type="button" onclick="editAlert()">완료</button>
			&nbsp;&nbsp;
			<button class="btn btn-default" type="reset" onclick="editCancel(${vo.bId})">취소</button>
			&nbsp;&nbsp;
			<button class="btn btn-default" type="button" onclick="location.href='boardForm.do'">목록</button>
		</div>
		</form>
	</div>		
</div>	

</body>
<jsp:include page="../main/footer.jsp" />
</html>