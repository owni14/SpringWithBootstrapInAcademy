<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/include/header.jsp" %>
<script>
$(document).ready(function() {
	var frmPaging = $("#frmPaging");
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
	}); // $("#btnUpdate").click
	
	$("#btnDelete").click(function(e) {
		e.preventDefault();
		var bno = $(this).attr("href");
		var frmPaging = $("#frmPaging");
		frmPaging.find("input[name=bno]").val(bno);
		frmPaging.attr("action", "/board/delete");
		frmPaging.attr("method", "get");
		frmPaging.submit();
	}); // $("#btnDelete").click
	
	$("#a_list").click(function(e) {
		e.preventDefault();
		frmPaging.find("input[name=bno]").val("${boardVo.bno}");
		frmPaging.attr("action", "/board/list");
		frmPaging.submit();
	}); // $("#a_list").click
	
	$("#btnCommentInsert").click(function() {
		var content = $("#c_content").val();
		var userid = $("#c_userid").val();
		var bno = "${boardVo.bno}";
		var sData = {
			"content" : content,
			"userid"  : userid,
			"bno"	  : bno
		};
		var url = "/comment/insertComment";
		$.post(url, sData, function(rData){
			console.log("rData:" +rData);
			if (rData == "true") {
				getCommentList();
			}
		}); // $.post
	}); // $("#btnCommentInsert").click
	
	function getCommentList() {
		var bno = "${boardVo.bno}";
		var url = "/comment/commentList/" + bno;
		$("#tabl_comment_list").find("tr:gt(0)").remove();
		$.get(url, function(rData) {
			$.each(rData, function() {
				console.log(rData);
				var tr = $("#table_clone tr").clone();
				var tds = tr.find("td");
				tds.eq(0).text(this.cno);
				tds.eq(1).text(this.content);
				tds.eq(2).text(this.userid);
				tds.eq(3).text(this.regdate);
				tds.find(".btnCommentDelete").attr("data-cno", this.cno);
				tds.find(".btnCommentModify").attr("data-cno", this.cno);
				$("#tabl_comment_list").append(tr);
			});
		}); // $.get
	} // function getCommentList()
	
	// 댓글 삭제 버튼
	$("#tabl_comment_list").on("click", ".btnCommentDelete", function() {
		console.log("삭제 버튼 클릭");
		var cno = $(this).attr("data-cno");
		var url = "/comment/deleteComment/" + cno;
		$.get(url, function(rData) {
			console.log(rData);
			if (rData == "true") {
				getCommentList();
			}
		}); // $.get
	}); // $("#tabl_comment_list").on("click", ".btnCommentDelete", function(){})
	
	// 댓글 수정 버튼
	$("#tabl_comment_list").on("click", ".btnCommentModify", function() {
		$("#modal-690226").trigger("click");
		var tr = $(this).parents("tr");
		var comment = tr.find("td").eq(1).text();
		$("#modalContent").val(comment);
		$("#btnModalSave").attr("data-cno", $(this).attr("data-cno"));
	}); // $("#tabl_comment_list").on("click", ".btnCommentModify", function() {})
	
	// 모달창 저장 버튼
	$("#btnModalSave").click(function() {
		var content = $("#modalContent").val();
		console.log("content:" + content);
		var cno = $(this).attr("data-cno");
		var sData = {
			"content" : content,
			"cno" : cno
		};
		var url = "/comment/updateComment";
		$.post(url, sData, function(rData) {
			console.log(rData);
			if (rData == "true") {
				getCommentList();
			}
		});
	}); 
	
	getCommentList();
	
});
</script>
<%@ include file="/WEB-INF/views/include/paging.jsp" %>
<div class="container-fluid">
<!-- 모달  -->
	<div class="row">
		<div class="col-md-12">
			 <a id="modal-690226" href="#modal-container-690226" role="button" class="btn" data-toggle="modal" style="display: none">Launch demo modal</a>
			<div class="modal fade" id="modal-container-690226" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="myModalLabel">댓글 수정</h5> 
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">×</span>
							</button>
						</div>
						<div class="modal-body">
							<input type="text" class="form-control" id="modalContent">
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary" id="btnModalSave" data-dismiss="modal">
								저장
							</button> 
							<button type="button" class="btn btn-secondary" data-dismiss="modal">
								닫기
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- // 모달  -->
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>글 내용 보기</h2>
				<p>
					<a class="btn btn-primary btn-large" id="a_list" href="#">글 목록</a>
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
			<input type="hidden" name="searchType" value="${pagingDto.searchType}">
			<input type="hidden" name="keyword" value="${pagingDto.keyword}">
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
				<a class="btn btn-warning" href="/board/replyForm?bno=${boardVo.bno}">답글</a>
			</form>
		</div>
	</div>
	<!-- 댓글(Comment) -->
	<div class="row" style="margin-top:30px">
		<div class="col-md-9" >
			<input type="text" class="form-control" placeholder="댓글을 입력해주세요." id="c_content">
		</div>
		<div class="col-md-2">
			<input type="text" class="form-control" placeholder="아이디를 입력하세요." id="c_userid">
		</div>
		<div class="col-md-1">
			<button type="button" class="btn btn-sm btn-primary" id="btnCommentInsert">완료</button>
		</div>
	</div>		
	<div class="row">
		<div class="col-md-12" style="margin-top: 30px">
			<table style="display: none;" id="table_clone">
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>
						<button type="button" class="btn btn-sm btn-warning btnCommentModify">수정</button>
					</td>
					<td>
						<button type="button" class="btn btn-sm btn-danger btnCommentDelete">삭제</button>
					</td>
				</tr>
			</table>
			<table class="table" id="tabl_comment_list">
				<tr>
					<td>#</td>
					<td>댓글내용</td>
					<td>작성자</td>
					<td>작성일</td>
					<td>수정</td>
					<td>삭제</td>
				</tr>
			</table>
		</div>
	</div>
	
</div>
<%@ include file="/WEB-INF/views/include/footer.jsp" %>