<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../include/header.jsp" %>

<style>
	section fieldset {
		width: 285px;
		margin: 0 auto;
		margin-top: 150px;
		padding: 30px;
		text-align: center;
	}
	
	section p {
		margin-bottom: 20px;
	}
	
	section p:last-child {
		margin-bottom: 0;
		margin-top: 30px;
	}
	
	label {
		float: left;
		width: 100px;
		text-align: left;
	}
	
	p input {
		padding: 5px;
	}
	
	.error {
		color: red;
		font-size: 11px;
		padding: 10px;
	}
</style>
		<section>
			<!-- 현 위치의 마지막 / 뒤에 값만 바꿈. user/..으로 넣지 않음 -->
			<form action="login.do" method="post">
				<fieldset>
					<p>
						<label>아이디</label>
						<input type="text" name="id"/>
					</p>
					<p>
						<label>비밀번호</label>
						<input type="password" name="password"/>
					</p>
					<p>
						<input type="submit" value="로그인"/>
					</p>
					<c:if test="${error == 'notMathID' }">
						<span class="error">등록되어 있지 않은 ID입니다.</span>
					</c:if>
				</fieldset>
			</form>
		</section>

<%@ include file="../include/footer.jsp" %>