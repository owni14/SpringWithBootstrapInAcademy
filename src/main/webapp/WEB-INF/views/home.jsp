<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/views/include/header.jsp"%>
<script>
$(document).ready(function() {
	var login_result = "${login_result}";
	if (login_result == "fail") {
		alert("로그인에 실패하였습니다. \n아이디와 비밀번호를 확인해주세요");
	}
});
</script>
<div class="row">
	<div class="col-md-12">
		<form role="form" action="/member/login" method="post">
			<div class="form-group">
				<label for="userid"> 아이디 </label>
				<input type="text" class="form-control" id="userid" name="userid" required="required"/>
			</div>
			<div class="form-group">
				<label for="userpw"> 비밀번호 </label>
				<input type="password" class="form-control" id="userpw" name="userpw" required="required"/>
			</div>
			<div class="checkbox">
				<label>
					<input type="checkbox" /> 아이디 저장
				</label>
			</div>
			<button type="submit" class="btn btn-primary">로그인</button>
			<a class="btn btn-success" href="/member/join_form">회원가입</a>
		</form>
	</div>
</div>

<%@ include file="/WEB-INF/views/include/footer.jsp"%>