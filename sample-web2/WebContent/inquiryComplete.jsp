<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="refresh" content="10;URL='HomeAction'"/>
<link rel="stylesheet" href="./css/style.css"/>
<title>お問合せ 受付完了</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div id="contents">
<h1>受付完了画面</h1>
<div class="success">
受付の送信が完了しました。
10秒後にホーム画面に戻ります。
</div>

<table class="horizontal-list-table">
<tbody>
<tr>
    <th>名前</th>
    <th>お問合せの種類</th>
    <th>お問合せの内容</th>
</tr>
    <tr>
        <td><s:property value="#session.userId" />様</td>
        <s:if test ='qtype=="company"'>
          <td>会社について</td>
        </s:if>
        <s:if test ='qtype=="product"'>
          <td>製品について</td>
        </s:if>
        <s:if test ='qtype=="etc"'>
          <td>その他について</td>
        </s:if>
        <td><s:property value="body"/></td>
    </tr>

</tbody>
</table>
</div>
<s:include value="footer.jsp"/>

</body>
</html>