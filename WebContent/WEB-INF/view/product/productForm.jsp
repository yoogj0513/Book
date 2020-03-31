<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<style>
	section {
		width: 500px;
		margin: 0 auto;
		margin-top: 50px;
	}
	
	section p {
		margin: 15px 0;
	}

	label {
		width: 100px;
		float: left;
	}
	
	section input[type='submit'] {
		width: 50px;
		padding: 5px;
		display: block;
		margin: 0 auto;
	}
</style>

<section>
	<form action="add.do" method="post" enctype="multipart/form-data">
		<p>
			<label>책 제목</label>
			<input type="text" name="pName"/>
		</p>
		<p>
			<label>책 가격</label>
			<input type="text" name="pPrice"/>
		</p>
		<p>
			<label>저자</label>
			<input type="text" name="pWriter"/>
		</p>
		<p>
			<label>출판사</label>
			<input type="text" name="pPublisher"/>
		</p>
		<p>
			<label>책종류</label>
			<select name="pType" id="pType">
				<option value="noselect">선택하세요</option>
				<option value="IT">IT</option>
				<option value="문학">문학</option>
				<option value="종교">종교</option>
				<option value="역사">역사</option>
			</select>
		</p>
		<p>
			<label>책이미지</label>
			<input type="file" name="pFile"/>
		</p>
		<p>
			<label>상세설명</label>
			<textarea name="pDetail" id="pDetail" cols="50" rows="10"></textarea>
		</p>
		<p><input type="submit" value="등록"/></p>
	</form>
</section>

<%@ include file="../include/footer.jsp"%>