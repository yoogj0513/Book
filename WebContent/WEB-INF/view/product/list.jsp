<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../include/header.jsp"%>

<style>
	.item {
		float: left;
		width: 20%;
		margin: 25px;
	}
	
	.item img {
		width: 100%;
		height: 280px;
	}
	
	.itemInfo {
		font-size: 12px;
		color: #aaa;
	}	
</style>
<script>
	$(function(){
		$(".item").click(function() {
			var no = $(this).attr("data-no");
			location.href = "${pageContext.request.contextPath}/product/ditail.do"+"?no=" + no;
		});
	})
</script>

<section>
	<p><a href="${pageContext.request.contextPath }/product/add.do">책 등록</a></p>
	<h1>HOME</h1>
	<div id="content">
		<c:forEach var="product" items="${list }">
			<div class="item" data-no="${product.pNo }">
			<!-- a태그를 써서 이동하는게 더 쉬움... -->
				<img src="${pageContext.request.contextPath }/upload/${product.pFile}" />
				<h3>${product.pName }</h3>
				<p class="itemInfo">${product.pWriter } | ${product.pPublisher }</p>
				<h4><fmt:formatNumber value="${product.pPrice }"/> </h4>
			</div>
		</c:forEach>
	</div>
</section>

<%@ include file="../include/footer.jsp"%>