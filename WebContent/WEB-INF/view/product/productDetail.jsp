<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../include/header.jsp"%>

<style>
	section {
		padding: 10px;
	}
	
	.info {
		overflow: hidden;
	}

	.info img {
		width: 400px;
		float: left;
		margin-right: 20px;
	}
	
	.bookInfo {
		padding-top: 30px;
	}
	
	.bookInfo p {
		margin: 10px 0;
	}
	
	.title {
		width: 100px;
		display: inline-block;
	}
	
	.bookInfo p:nth-of-type(2) .price{
		font-size: 30px;
		color: red;
		font-weight: bold;
	}
	
	.btns {
		margin: 10px 0;
	}
	
	button {
		padding: 5px;
	}
	
	.detail {
		margin-top: 20px;
	}
</style>

<script>
	$(function(){
		$("#btnCart").click(function() {
			//server에서 conut, pNo 보내야 됨
			
			var count = $("#productCnt").val();
			var pNo = ${item.pNo};
			
			// ajax에서 이동했을 경우에는 핸들러에서 이동이 안됨.
			// 핸들러에서 json String을 만들어서 보내서 여기서 이동해야함
			$.ajax({
				url:"${pageContext.request.contextPath}/cart/add.do",
				type:"post",
				data:{"count":count, "no":pNo},
				dataType:"json",
				success:function(res){
					console.log(res)
					if(res.result == "notLogin") {
						//로그인 화면으로 이동
						var flag = confirm("로그인이 안됨. 로그인화면으로 이동하시겠습니까?");
						if(flag == true) {							
							location.href = "${pageContext.request.contextPath}/user/login.do";
						}
					} else if (res.result=="success") {
						alert("장바구니에 추가되었습니다");
					}
				}
			})
		})
	})
</script>

<section>
	<div class="info">
		<img src="${pageContext.request.contextPath }/upload/${item.pFile}" />
		<div class="bookInfo">
			<h2>${item.pName }</h2>
			<p>
				${item.pWriter } | 
				${item.pPublisher } | 
				<fmt:formatDate value="${item.pRegDate }" pattern="yyyy년 MM년 dd일"/> |
				판매부수
			</p>
			<p>
				<span class="title">판매가</span>
				<span class="price"><fmt:formatNumber value="${item.pPrice }"/>원</span>
			</p>
			<div class="cnt">
				<span class="title">상품개수</span>
				<select name="productCnt" id="productCnt">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</select>
			</div>
			<div class="btns">
				<button id="btnCart">장바구니</button>
				<button id="btnOrder">주문하기</button>
			</div>
		</div>
	</div>
	<div class="detail">
		${item.pDetail }
	</div>
</section>

<%@ include file="../include/footer.jsp"%>