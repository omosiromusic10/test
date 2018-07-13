<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>商品登録・追加</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div id="contents">
<h1>商品登録・追加画面</h1>

<s:if test="!#session.productNameErrorMessageList.isEmpty()">
    <div class="error">
    <div class="error-message">
        <s:iterator value="#session.productNameErrorMEssageList"><s:property /><br></s:iterator>
    </div>
    </div>
</s:if>
<s:if test="!#session.productNameKanaErrorMessageList.isEmpty()">
    <div class="error">
    <div class="error-message">
        <s:iterator value="#session.productNameKanaErrorMEssageList"><s:property /><br></s:iterator>
    </div>
    </div>
</s:if>
<s:if test="!#session.productDescriptionErrorMessageList.isEmpty()">
    <div class="error">
    <div class="error-message">
        <s:iterator value="#session.productDescriptionErrorMEssageList"><s:property /><br></s:iterator>
    </div>
    </div>
</s:if>
<s:if test="!#session.priceErrorMessageList.isEmpty()">
    <div class="error">
    <div class="error-message">
        <s:iterator value="#session.priceErrorMEssageList"><s:property /><br></s:iterator>
    </div>
    </div>
</s:if>
<s:if test="!#session.imageFileNameErrorMessageList.isEmpty()">
    <div class="error">
    <div class="error-message">
        <s:iterator value="#session.imageNamePathErrorMEssageList"><s:property /><br></s:iterator>
    </div>
    </div>
</s:if>
<s:if test="!#session.imageFilePathErrorMessageList.isEmpty()">
    <div class="error">
    <div class="error-message">
        <s:iterator value="#session.imageFilePathErrorMEssageList"><s:property /><br></s:iterator>
    </div>
    </div>
</s:if>

<s:form action="AdminRegistConfirmAction">

<table class="vertical-list-table">
<tr>
    <th scope="row">商品名</th>
    <td><s:textfield name="productName" value="%{#session.productName}" label="商品名" placeholder="商品名" class="txt"/></td>
</tr>
<tr>
    <th scope="row">商品名ふりがな</th>
    <td><s:textfield name="productNameKana" value="%{#session.productNameKana}" label="商品名ふりがな" placeholder="商品名ふりがな" class="txt"/></td>
</tr>
<tr>
    <th scope="row">商品名詳細</th>
    <td><s:textarea name="productDescription" value="%{#session.productDescription}" label="商品名詳細" placeholder="商品名詳細"  class="area"/></td>
</tr>
<tr>
    <th scope="row">価格</th>
    <td><s:textfield name="price" value="%{#session.price}" label="価格" placeholder="価格" class="txt"/></td>
</tr>
<tr>
    <th scope="row">発売会社名</th>
    <td><s:textfield name="releaseCompany" value="%{#session.releaseCompany}" label="発売会社名" placeholder="発売会社名" class="txt"/></td>
</tr>
<tr>
    <th scope="row">発売年月</th>
    <td><s:textfield name="releaseDate" value="%{#session.releaseDate}" label="発売年月" placeholder="発売年月" class="txt"/></td>
</tr>
<tr>
    <th scope="row">画像ファイル名</th>
    <td><s:textfield name="imageFileName" value="%{#session.imageFileName}" label="画像ファイル名" placeholder="画像ファイル名" class="txt"/></td>
</tr>
<tr>
    <th scope="row">画像ファイル</th>
    <td><s:file name="imageFilePath" value="%{#session.imageFilePath}" label="画像ファイル" placeholder="画像ファイル" class="file"/>工事中！</td>
</tr> <!-- 　ここで画像を選択出来る奴にしておく。 -->
</table>

<div class="submit_btn_box">
<div id=".contents-btn-set">
<s:submit value="登録" class="submit_btn" />
</div>
</div>
</s:form>
</div>

<div id="footer">
    <s:include value="footer.jsp" />
</div>

</body>
</html>