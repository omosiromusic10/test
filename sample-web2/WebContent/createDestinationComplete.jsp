<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="refresh" content="3;URL='SettlementConfirmAction'"/>
<link rel="stylesheet" href="./css/style.css">
<title>宛先情報完了</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div id="contents">
<h1>宛先情報完了画面</h1>
<div class="success">
宛先情報の登録が完了しました。
3秒後に決済確認画面に戻ります。
</div>
</div>
<s:include value="footer.jsp"/>
</body>
</html>