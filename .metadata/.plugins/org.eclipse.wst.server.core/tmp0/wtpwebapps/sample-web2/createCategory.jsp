<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/style.css"/>
<title>カテゴリ作成画面</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div id="contents">
<h1>カテゴリ作成画面</h1>
<h2>既存のカテゴリー一覧</h2>
<table class="horizontal-list-table">

<thead>
<tr>
<th><s:label value="カテゴリ名"/></th>
<th><s:label value="カテゴリ名詳細"/></th>
</tr>
</thead>
<tbody>
<s:iterator value="#session.mCategoryDtoList">
<tr>
<td><s:property value="categoryName"/></td>
<td><s:property value="categoryDescription"/></td>
</tr>
</s:iterator>
</tbody>

</table>
<h2>新規カテゴリ入力欄</h2>

<s:if test="!#session.categoryNameErrorMessageList.isEmpty()">
    <div class="error">
    <div class="error-message">
        <s:iterator value="#session.categoryNameErrorMessageList"><s:property/><br></s:iterator>
    </div>
    </div>
</s:if>
<s:if test="!#session.categoryDescriptionErrorMessageList.isEmpty()">
    <div class="error">
    <div class="error-message">
        <s:iterator value="#session.categoryDescriptionErrorMessageList"><s:property/><br></s:iterator>
    </div>
    </div>
</s:if>



<s:form action="CreateCategoryCompleteAction" >
<table class="vertical-list-table">
<tr>
    <th scope="row">カテゴリ名</th>
    <td><s:textfield name="categoryName" value="%{#session.categoryName}" label="カテゴリ名" placeholder="カテゴリ名" class="txt"/></td>
</tr>
<tr>
    <th scope="row">カテゴリ名詳細</th>
    <td><s:textfield name="categoryDescription" value="%{#session.categoryDescription}" label="カテゴリ名詳細" placeholder="カテゴリ名詳細" class="txt"/></td>
</tr>

</table>

<div class="submit_btn_box">
<div id=".contents-btn-set">
<s:submit value="カテゴリ確認画面へ" class="submit_btn" />
</div>
</div>
</s:form>
</div>
<div id="footer">
    <s:include value="footer.jsp"/>
</div>

</body>
</html>