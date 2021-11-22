<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style = "position: absolute; top: 45%; left: 40%">
		<form action="UserLogin">
			<div>
				<label for = "id">아이디 </label>
				<input type = "text" id = "id" name = "id"></input>
			</div>
			<div>
				<label for = "pw">비밀번호 </label>
				<input type = "password" id = "pw" name = "pw"></input>
			</div>
				<input type="submit" value = "로그인" name="UserLogin" style = "width: 100%;">
		</form>
	</div>
</body>
</html>