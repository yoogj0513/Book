<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	* {
		margin: 0;
		padding: 0;
	}
	
	ul {
		list-style: none;
	}
	
	a {
		text-decoration: none;
		color: #000;
	}
	
	#container {
		width: 1024px;
		margin: 0 auto;
	}
	
	#container header {
		position: relative;
	}
	
	#container header h1{
		text-align: center;
		margin-top: 10px;
		margin-bottom: 20px;
	}
	
	#container header h1 a {
		color: navy;
	}
	
	header ul.header_menu {
		position: absolute;
		right: 5px;
		top: 15px;
	}
	
	header ul.header_menu li {
		float: left;
		margin: 0 5px;
	}
	
	nav {
		height: 50px;
		background: navy;
	}
	
	nav ul {
		overflow: hidden;
	}
	
	nav ul li {
		float: left;
		width: 16.6%;
		text-align: center;
		line-height: 50px;
	}
	
	nav ul a {
		color: white;
		font-size: 17px;
		display: block;
	}
	
	nav ul a:hover {
		color: black;
		background: white;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>
	<div id="container">
		<header>
			<h1><a href="list.do">Book</a></h1>
			<ul class="header_menu">
				<c:if test="${Auth == null }">			
					<li><a href="${pageContext.request.contextPath}/user/login.do">로그인</a></li>
					<li><a href="#">회원가입</a></li>
				</c:if>
				<c:if test="${Auth != null }">
					<li>${Auth }님 / </li>
					<li><a href="${pageContext.request.contextPath}/user/logout.do">로그아웃</a></li>
				</c:if>
			</ul>
			<nav>
				<ul>
					<li><a href="#">베스트</a></li>
					<li><a href="#">신상품</a></li>
					<li><a href="#">IT</a></li>
					<li><a href="#">문학</a></li>
					<li><a href="#">종교</a></li>
					<li><a href="#">역사</a></li>
				</ul>
			</nav>
		</header>