<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="beans.OrderBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新</title>
</head>
<body>
	<p>この内容で更新しますか？</p>

	<%
		OrderBean bean = (OrderBean) request.getAttribute("threads");
	%>
	<p>
		ID:<%=bean.getId()%></p>
	<p>
		タイトル:<%=bean.getTitle()%></p>
	<p>
		ニックネーム:<%=bean.getNickname()%></p>
	<p>
		コメント:<%=bean.getMessage()%></p>
	<p>
		更新日:<%=bean.getUpdate()%></p>
	<p>
		登録日:<%=bean.getInsert()%></p>







	<form action="/Test/up" method="POST">

	<p>
			タイトル：:<input value=<%=bean.getTitle()%> type="text" name="title" />
		</p>


		<p>
			ニックネーム：<input value= <%=bean.getNickname()%>  type="text" name="nickname" />
		</p>

		<p>
			メッセージ：
			<textarea name="message"><%=bean.getMessage()%></textarea>
		</p>

		<input type="hidden" name="id" value=<%=bean.getId()%>> <input
			type="submit" value="更新" />


	</form>
	<form action="/Test/view" method="GET">
		<input type="submit" value="いいえ" />
	</form>
</body>
</html>