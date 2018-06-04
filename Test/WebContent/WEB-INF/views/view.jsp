<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="beans.OrderBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>表示</title>
</head>
<body>
	<h1>★BBS</h1>
	<form action="/Test/insert" method="GET">
		<input type="submit" value="書き込み" />
	</form>
	<hr size="10">
	<%
		for (OrderBean bean : (List<OrderBean>) request.getAttribute("threads")) {
	%>
	<form action="/Test/up" method="GET">
		<div>
			<table>
				<tr>
					<th><div Align="right">id :</div></th>
					<td><div Align="left"><%=bean.getId()%></div></td>
				</tr>
				<tr>
					<th><div Align="right">タイトル :</div></th>
					<td><div Align="left"><%=bean.getTitle()%></div></td>
				</tr>
				<tr>
					<th><div Align="right">ニックネーム :</div></th>
					<td><div Align="left"><%=bean.getNickname()%></div></td>
				</tr>
				<tr>
					<th><div Align="right">コメント :</div></th>
					<td><div Align="left"><%=bean.getMessage()%></div></td>
				</tr>
				<tr>
					<th><div Align="right">更新日 :</div></th>
					<td><div Align="left"><%=bean.getUpdate()%></div></td>
				</tr>
				<tr>
					<th><div Align="right">登録日 :</div></th>
					<td><div Align="left"><%=bean.getInsert()%></div></td>
				</tr>
			</table>
			<input type="hidden" name="id" value="<%=bean.getId()%>">
			<input type="submit" value="更新" />
		</div>
		</form>
		<form action="/Test/delete" method="GET">
			<input type="hidden" name="id" value="<%=bean.getId()%>">
			<input type="submit" value="削除" />
		</form>
		<hr>
	<%
		}
	%>

</body>
</html>