<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/tp/board/BoardWrite" method="post">
	제목 : <textarea rows="1" name='B_TITLE'></textarea>
	<hr>
	<textarea rows="10" name='B_CONTENT'></textarea>
	<input type="submit" value="글쓰기">
	</form>

</body>
</html>