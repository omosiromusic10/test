<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test</title>
</head>
<body>
<p>こんにちは！</p>

<%! static int countA=0; %>

//なぜここで更新すると増えるのか？
//そしてstatic　intとは何か？

<%
    int countB=0;
    countA++;
    countB++;
%>

<p>宣言による変数 countA=<%=countA %>
<p>スクリプトレットによる変数 countB=<%=countB %></p>

<p><% out.println(Math.random()); %></p>
<p><%=Math.random() %></p>

<p>お名前を入力してください。</p>
<form method="post" action="greeting-out.jsp">
<input type="text" name="user">
<input type="submit" value="確定">
</form>

<form method="post" action="total-out.jsp">
<input type="text" name="price">
円ｘ
<input type="text" name="count">
個+送料
<input type="text" name="delivery">
円=
<input type="submit" value="計算">
</form>


</body>
</html>