<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="refresh" content="3;URL='AdminRegistAction'"/>
<link rel="stylesheet" href="./css/style.css">
<title>カテゴリー登録完了</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div id="contents">
<h1>カテゴリ登録完了画面</h1>
<div class="success">
カテゴリ情報の登録が完了しました。
3秒後に商品登録画面に戻ります。
</div>
</div>
<s:include value="footer.jsp"/>
</body>
</html>