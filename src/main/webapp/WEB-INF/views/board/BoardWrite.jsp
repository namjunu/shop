<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/water.css@2/out/water.css">
<meta charset="UTF-8">
<title>TP - 게시판</title>
</head>
<body>

	<form name = "wform" action="/tp/board/BoardWrite" method="post" onsubmit="return check()">
		제목 : <textarea rows="1" name='b_title'></textarea>
		<hr>
		<textarea rows="10" name='b_content'></textarea>
		작성자 : <%= session.getAttribute("U_ID") %>
		<input type="hidden" name = "b_writer" value = <%=session.getAttribute("U_ID")%>>
		<br>
		<div >
			<div>카테고리 : </div>
			<div>
				<select name="b_category">
				    <option value="free" selected="selected">자유</option>
				    <option value="question">질문</option>
				</select>
			</div>
		</div>
		<input type="submit" value="글쓰기">
	</form>
	
	<script>
	function check() {
	        if (f.b_title.value == "") {
	            alert("제목을 입력해주십시오");
	            f.b_title.focus();
				console.log(f);
	            return false;
	        }
			 if (f.b_content.value == "") {
	            alert("내용을 입력해주세요");
	            f.b_content.focus();
	            return false;
	        }
		}
	</script>
</body>
</html>