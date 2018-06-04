<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>書き込み</title>
</head>
<body>
	<form action="/Test/insert" method="POST">
		<p>
			ニックネーム：<input type="text" name="nickname" />
		</p>
		<p>
			タイトル：<input type="text" name="title" />
		</p>
		<p>
			メッセージ：<textarea name="message"></textarea>
		</p>


		<input type="submit"/>
	</form>

</body>
</html>