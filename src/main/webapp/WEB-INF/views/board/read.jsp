<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/include/header.jsp" %>
<script>
$(document).ready(function() {
	var update_result = "${update_result}";
	if (update_result == "true") {
		alert("수정 완료");
	} else if (update_result == "false") {
		alert("수정 실패");
	}
	
	// 수정 버튼
	$("#btnUpdate").click(function() {
		// readonly 해제
		$("*[readonly]").attr("readonly", false);
		$(this).fadeOut("slow");
		$("#btnUpdateRun").fadeIn("slow");
	});
	
	$("#btnDelete").click(function(e) {
		e.preventDefault();
		var bno = $(this).attr("href");
		var frmPaging = $("#frmPaging");
		frmPaging.find("input[name=bno]").val(bno);
		frmPaging.attr("action", "/board/delete");
		frmPaging.attr("method", "get");
		frmPaging.submit();
	});
});
</script>
<%@ include file="/WEB-INF/views/include/paging.jsp" %>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>글 내용 보기</h2>
				<p>
					<a class="btn btn-primary btn-large" href="/board/list?page=${param.page}&perPage=${param.perPage}">글 목록</a>
				</p>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<form role="form" action="/board/updateRun" method="post">
			<input type="hidden" name="bno" value="${boardVo.bno}">
			<input type="hidden" name="page" value="${pagingDto.page}">
			<input type="hidden" name="perPage" value="${pagingDto.perPage}">
				<div class="form-group">
					<label for="title"> 제목 </label> 
					<input type="text" 
						class="form-control" id="title" name="title"
						value="${boardVo.title}" readonly="readonly"/>
				</div>
				<div class="form-group">
					<label for="content"> 내용 </label>
					<textarea class="form-control" id="content" name="content" readonly="readonly">${boardVo.content}</textarea>
				</div>
				<div class="form-group">
					<label for="writer"> 작성자 </label> 
					<input type="text" 
						class="form-control" id="writer" name="writer"
						value="${boardVo.writer}" readonly="readonly"/>
				</div>
				<button type="button" class="btn btn-primary"
					id="btnUpdate">수정</button>
				<button type="submit" class="btn btn-success"
					id="btnUpdateRun" style="display: none;">수정완료</button>
				<a class="btn btn-danger" href="${boardVo.bno}" id="btnDelete">삭제</a>
			</form>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/views/include/footer.jsp" %>