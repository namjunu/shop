<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/water.css@2/out/water.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/tp/board/BoardWrite" method="post">
	제목 : <textarea rows="1" name='b_title'></textarea>
	<hr>
	<textarea rows="10" name='b_content'></textarea>
	작성자 : <%= session.getAttribute("id") %>
	<input type="hidden" name = "b_writer" value = <%=session.getAttribute("id")%>>
	<br>
	<div >
		<div>카테고리 : </div>
		<div>
			<select name="b_category">
			    <option value="free" selected="selected">free</option>
			    <option value="test1">test2</option>
			    <option value="test2">test1</option>
			</select>
		</div>
	</div>
	
	<input type="submit" value="글쓰기">
	</form>

</body>
</html>