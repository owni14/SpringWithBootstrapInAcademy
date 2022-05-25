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
	var frmPaging = $("#frmPaging");
	var create_result = "${create_result}";
	var delete_result = "${delete_result}";
	var reply_result = "${reply_result}";
	console.log("reply_result:" + reply_result);
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
	if (reply_result == "true") {
		alert ("답글 작성 완료");
	} else if (reply_result == "false") {
		alert ("답글 작성 실패");
	}
		
	$(".td_list").click(function() {
		// $(this) : 여러개의 tr 중 클릭된 tr
		var bno = $(this).attr("data-bno");
// 		location.href = "/board/read?bno=" + bno;
		frmPaging.find("input[name=bno]").val(bno);
		frmPaging.attr("action", "/board/read");
		frmPaging.attr("method", "get");
		frmPaging.submit();
	}); // $(".tr_list").click
	
	$("#perPage").change(function() {
		var perPage = $(this).val();
// 		console.log("perPage:" + perPage);
		frmPaging.find("input[name=perPage]").val(perPage);
		frmPaging.attr("action", "/board/list");
		frmPaging.attr("method", "get");
		frmPaging.submit();
	}); // $("#perPage").change
	
	$("a.page-link").click(function(e) {
		e.preventDefault();
		var page = $(this).attr("href");
		frmPaging.find("input[name=page]").val(page);
		// action을 생략하면 브라우저 주소창의 현재 경로
		frmPaging.attr("action", "/board/list");
		// method를 생략하면 get이 기본값
		frmPaging.attr("method", "get");
		frmPaging.submit();
	}); // $("a.page-link").click
	
	// 검색버튼
	$("#btnSearch").click(function() {
		var searchType = $("#searchType").val();
		var keyword = $("#keyword").val();
		frmPaging.find("input[name=searchType]").val(searchType);
		frmPaging.find("input[name=keyword]").val(keyword);
		frmPaging.attr("action", "/board/list");
		frmPaging.attr("method", "get");
		frmPaging.submit();
	}); // $("#btnSearch").click
	
}); // $(document).ready
</script>

<%@ include file="/WEB-INF/views/include/paging.jsp" %>

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
	<!-- n줄씩 보기 : PagingDto.perPage -->
	<div class="row">
		<div class="col-md-12">
			<select name="perPage" id="perPage">
			<c:forEach var="v" begin="5" end="30" step="5">
				<option value="${v}" 
					<c:if test="${v == pagingDto.perPage}">
						selected="selected" 
					</c:if>
				>${v}줄씩 보기</option>
			</c:forEach>
			</select>
			
			<!-- 검색 -->
			<select style="margin-left:30px;" id="searchType">
				<option value="t" 
					<c:if test="${pagingDto.searchType == 't'}">
						selected="selected"
					</c:if>
				>제목</option>
				<option value="c"
					<c:if test="${pagingDto.searchType == 'c'}">
						selected="selected"
					</c:if>
				>내용</option>
				<option value="w"
					<c:if test="${pagingDto.searchType == 'w'}">
						selected="selected"
					</c:if>
				>작성자</option>
				<option value="tc"
					<c:if test="${pagingDto.searchType == 'tc'}">
						selected="selected"
					</c:if>
				>제목 + 내용</option>
				<option value="tcw"
					<c:if test="${pagingDto.searchType == 'tcw'}">
						selected="selected"
					</c:if>
				>제목 + 내용 + 작성자</option>
			</select>
			<input type="text" id="keyword" value="${pagingDto.keyword}">
			<button type="button" class="btn btn-sm btn-success" id="btnSearch">검색</button>
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
						<tr class="tr_list">
							<td>${boardVo.bno}</td>
							<td class="td_list" style="padding-left:${boardVo.re_level * 40}px"  data-bno="${boardVo.bno}">${boardVo.title}</td>
							<td>
							<c:choose>
								<c:when test="${loginVo.userid == boardVo.writer}">
									${boardVo.writer}
								</c:when>
								<c:otherwise>
							
								<button class="btn dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown">
									${boardVo.writer}
								</button>
								<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
									 <a class="dropdown-item disabled" href="#">메뉴</a> 
									 <a class="dropdown-item" href="#">쪽지보내기</a> 
									 <a class="dropdown-item" href="/member/getMemberById?userid=${boardVo.writer}">회원정보보기</a>
								</div>
								</c:otherwise>
							</c:choose>
							</td>
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
					<c:if test="${pagingDto.startPage != 1}">
						<li class="page-item"><a class="page-link" href="${pagingDto.startPage - 1}">이전</a></li>
					</c:if>
					<c:forEach begin="${pagingDto.startPage}" end="${pagingDto.endPage}" var="i">
						<li
							<c:choose>
							<c:when test="${i == param.page}">
								class="page-item active"
							</c:when>
							<c:otherwise>
								class="page-item"
							</c:otherwise>
						</c:choose>
						><a class="page-link" href="${i}">${i}</a></li>
					</c:forEach>
					<c:if test="${pagingDto.endPage != pagingDto.totalPage}">
						<li class="page-item"><a class="page-link" href="${pagingDto.endPage + 1}">다음</a></li>
					</c:if>
				</ul>
			</nav>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/views/include/footer.jsp"%>