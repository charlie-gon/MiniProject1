<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>

<!-- CSS -->
<link rel="stylesheet" href="resources/css/boardForm.css">
<!-- Function -->
<script>
	function updateAlert(str){
		var msg = confirm("수정하시겠습니까?");
		if(msg){
			frm.bId.value = str;
			frm.submit();
		}
	}
	
	function deleteAlert(){
		var msg = confirm("삭제하시겠습니까?");
		if(msg){
			location.href = "boardDelete.do";
		}
	}
</script>

</head>
<jsp:include page="../main/menu.jsp" />
<body>

<!-- Page content -->
<div style="max-width: 2000px; margin-top: 46px" align="center" id="main">

	<div align="center">
		<h1>게시글 상세 페이지</h1>
		
		<form id="frm" name="frm" action="boardUpdateForm.do" method="post">
		<input type="hidden" id="bId" name="bId">
		</form>
		
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
				<td colspan="7"><textarea rows="10" cols="100" required="required" readonly>${vo.bContent }</textarea></td>
			</tr>
		</table>

		<hr />
		<div>
			<button class="btn btn-default" type="button" onclick="updateAlert(${vo.bId})">수정</button>
			&nbsp;&nbsp;
			<button class="btn btn-default" type="button" onclick="deleteAlert()">삭제</button>
			&nbsp;&nbsp;
			<button class="btn btn-default" type="button" onclick="location.href='boardForm.do'">목록</button>
		</div>
	</div>		
</div>	

</body>
<jsp:include page="../main/footer.jsp" />
</html>