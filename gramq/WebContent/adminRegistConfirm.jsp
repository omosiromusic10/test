<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>商品商品内容確認</title>
</head>
<body>
<!--  <jsp:include page="header.jsp"/> -->
<div id="contents">
<h1>商品登録内容確認画面</h1>
<s:form action="AdminRegistCompleteAction">


<!--  テーブルクラスは仮で記述　ここでは確認なので画像や入力した情報を表示する -->
<table class="vertical-list-table">
<tr>
    <th scope="row"><s:label value="商品カテゴリ"/></th>
    <td><s:property value="categoryId"/></td>
</tr>
<tr>
    <th scope="row"><s:label value="商品名"/></th>
    <td><s:property value="productName"/></td>
</tr>
<tr>
    <th scope="row"><s:label value="商品名ふりがな"/></th>
    <td><s:property value="productNameKana"/></td>
</tr>
<tr>
    <th scope="row"><s:label value="商品名詳細"/></th>
    <td><s:property value="productDescription"/></td>
</tr>
<tr>
    <th scope="row"><s:label value="発売会社名"/></th>
    <td><s:property value="releaseCompany"/></td>
</tr>
<tr>
    <th scope="row"><s:label value="発売年月"/></th>
    <td><s:property value="releaseDate"/></td>
</tr>
<tr>
    <th scope="row"><s:label value="画像ファイル名"/></th>
    <td><s:property value="imageFileName"/></td>
</tr>
<tr>
    <th scope="row"><s:label value="画像ファイル"/></th>
    <td><img src="userimages/<s:property value="userImageFileName"/>" width="500" height="300" /></td>
</tr>

</table>
<div class="submit_btn_box">
<div id="./contents-btn-set">
<s:submit value="登録" class="submit_btn"/>
</div>
</div>
<s:hidden name="productName" value="%{productName}"/>
<s:hidden name="productNameKana" value="%{productNameKana}"/>
<s:hidden name="productDescription" value="%{productDescription}"/>
<s:hidden name="price" value="%{price}"/>
<s:hidden name="imageFileName" value="%{imageFileName}"/>
<s:hidden name="imageFilePath" value="%{imageFilePath}"/>
<s:hidden name="releaseCompany" value="%{releaseCompany}"/>
<s:hidden name="releaseDate" value="%{releaseDate}"/>

</s:form>
</div>

<!--  <s:include value="footer.jsp"/> -->

</body>
</html>