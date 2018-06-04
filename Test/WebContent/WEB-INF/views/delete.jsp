<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="beans.ThreadBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>削除</title>
</head>
<body>
	<p>削除しますか？</p>
	<% ThreadBean bean = (ThreadBean) request.getAttribute("threads"); %>
	<p>ID:<%= bean.getId()%></p>
	<p>タイトル:<%= bean.getTitle()%></p>
	<p>ニックネーム:<%= bean.getNickname()%></p>
	<p>コメント:<%= bean.getMessage()%></p>
	<p>更新日:<%= bean.getUpdate()%></p>
	<p>登録日:<%= bean.getInsert()%></p>
	<form action="/Test/delete" method="POST">
		<input type="hidden" name="id" value=<%= bean.getId()%>>
		<input type="submit" value="はい" />
	</form>
	<form action="/Test/view" method="GET">
		<input type="submit" value="いいえ" />
	</form>
</body>
</html>