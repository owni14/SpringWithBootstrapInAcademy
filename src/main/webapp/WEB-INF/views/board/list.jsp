<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/views/include/header.jsp"%>

<style>
tr.tr_list {
	cursor: pointer;
}

tr.tr_list:hover {
	background-color: aliceblue;
}
</style>

<script>
	$(document).ready(function() {
		var create_result = "${create_result}";
		var delete_result = "${delete_result}";
		if (create_result == "true") {
			alert("글 등록 완료");
		} else if (create_result == "false") {
			alert("글 등록 실패")
		}
		if (delete_result == "true") {
			alert("글 삭제 완료");
		} else if (delete_result == "false") {
			alert("글 삭제 실패");
		}

		$(".tr_list").click(function() {
			// $(this) : 여러개의 tr 중 클릭된 tr
			var bno = $(this).attr("data-bno");
			location.href = "/board/read?bno=" + bno;
		});
		console.log("create_result:" + create_result);
	});
</script>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>글목록</h2>
				<p>
					<a class="btn btn-primary btn-large" href="/board/createForm">글쓰기</a>
				</p>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<table class="table">
				<thead>
					<tr>
						<th>#</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${boardList}" var="boardVo">
						<tr class="tr_list" data-bno="${boardVo.bno}">
							<td>${boardVo.bno}</td>
							<td>${boardVo.title}</td>
							<td>${boardVo.writer}</td>
							<td>${boardVo.regdate}</td>
							<td>${boardVo.viewcnt}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<!-- 페이징 -->
	<div class="row">
		<div class="col-md-12">
			<nav>
				<ul class="pagination justify-content-center">
					<li class="page-item"><a class="page-link" href="#">이전</a></li>
					<c:forEach begin="1" end="10" var="i">
						<li
							<c:choose>
							<c:when test="${i == param.page}">
								class="page-item active"
							</c:when>
							<c:otherwise>
								class="page-item"
							</c:otherwise>
						</c:choose>
						><a class="page-link" href="/board/list?page=${i}">${i}</a></li>
					</c:forEach>
					<li class="page-item"><a class="page-link" href="#">다음</a></li>
				</ul>
			</nav>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/views/include/footer.jsp"%>