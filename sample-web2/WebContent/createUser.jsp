<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>ユーザー情報入力</title>
<link rel="stylesheet" type="text/css" href="./css/style.css" />
</head>
<body>
<jsp:include page ="header.jsp"/>
<div id="contents">
<h1>ユーザー情報入力画面</h1>

<s:if test="!#session.familyNameErrorMessageList.isEmpty()">
    <div class="error">
    <div class="error-message">
        <s:iterator value="#session.familyNameErrorMessageList"><s:property /><br></s:iterator>
    </div>
    </div>
</s:if>
<s:if test="!#session.firstNameErrorMessageList.isEmpty()">
    <div class="error">
    <div class="error-message">
    <s:iterator value="#session.firstNameErrorMessageList"><s:property /><br> </s:iterator>
    </div>
    </div>
</s:if>
<s:if test="!#session.firstNameKanaErrorMessageList.isEmpty()">
    <div class="error">
    <div class="error-message">
    <s:iterator value="#session.firstNameKanaErrorMessageList"><s:property /><br> </s:iterator>
    </div>
    </div>
</s:if>
<s:if test="!#session.familyNameKanaErrorMessageList.isEmpty()">
    <div class="error">
    <div class="error-message">
    <s:iterator value="#session.familyNameKanaErrorMessageList"><s:property /><br> </s:iterator>
    </div>
    </div>
</s:if>
<s:if test="!#session.emailErrorMessageList.isEmpty()">
    <div class="error">
    <div class="error-message">
    <s:iterator value="#session.emailErrorMessageList"><s:property /><br> </s:iterator>
    </div>
    </div>
</s:if>
<s:if test="!#session.loginIDErrorMessageList.isEmpty()">
    <div class="error">
    <div class="error-message">
    <s:iterator value="#session.loginIdErrorMessageList"><s:property /><br> </s:iterator>
    </div>
    </div>
</s:if>
<s:if test="!#session.passwordErrorMessageList.isEmpty()">
    <div class="error">
    <div class="error-message">
    <s:iterator value="#session.passwordErrorMessageList"><s:property /><br> </s:iterator>
    </div>
    </div>
</s:if>

<s:form action="CreateUserConfirmAction">

<table class="vertical-list-table">
<tr>
    <th scope="row">性</th>
    <td><s:textfield name="familyName" value="%{#session.familyName}" label="姓" placeholder="姓" class="txt" /></td>
</tr>
<tr>
    <th scope="row">名</th>
    <td><s:textfield name="firstName" value="%{#session.firstName}" label="名" placeholder="名" class="txt" /></td>
</tr>
<tr>
    <th scope="row">性ふりがな</th>
    <td><s:textfield name="familyNameKana" value="%{#session.familyNameKana}" label="姓ふりがな" placeholder="姓ふりがな" class="txt" /></td>
</tr>
<tr>
    <th scope="row">名ふりがな</th>
    <td><s:textfield name="firtsNameKana" value="%{#session.fistNameKana}" label="名ふりがな" placeholder="名ふりがな" class="txt" /></td>
</tr>
<tr>
    <th scope="row">性別</th>
    <td><s:radio name="sex" list="%{#session.sexList}" value="%{#session.sex}" label="性別" placeholder="性別" /></td>
</tr>
<tr>
    <th scope="row">メールアドレス</th>
    <td><s:textfield name="email" value="%{#session.email}" label="メールアドレス" placeholder="メールアドレス" class="txt" /></td>
</tr>
<tr>
    <th scope="row">パスワード</th>
    <td><s:textfield name="password" value="%{#session.password}" label="パスワード" placeholder="パスワード" class="txt" /></td>
</tr>
</table>
<div class="submit_btn_box">
<div id=".contents-btn-set">
<s:submit value="登録" class="submit_btn" />
</div>
</div>
</s:form>
</div>
<div id="footer">
	<s:include value="footer.jsp"/>
</div>
</body>
</html>