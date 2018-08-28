<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>お問合せフォーム</title>
<script>

function disp(){
	confirm("以下の記入で送信してもよろしいでしょうか？");
}

</script>
</head>
<body>
    <jsp:include page="header.jsp"/>
    <div id="contents">
    <h1>お問合せ一覧</h1>
    <s:form method="post" action="InquiryCompleteAction">
    <table class="vertical-list-table">
    <tr>
    <th scope="row">ユーザー名：</th>
    <td><s:property value="#session.userId"/>様</td>
    <s:hidden name="userId" value="%{userId}"/>
    </tr>
    <tr>
    <th scope="row">お問合せの種類：</th>
    <td><select name="qtype" class="cs-div">
        <option value="company">会社について</option>
        <option value="product"> 製品について</option>
        <option value="support"> その他について</option>
    </select></td>
    </tr>
    <tr>
        <th scope="row">お問合せ内容：</th>
        <td><s:textarea name="body" label="お問合せ内容" placeholder="お問合せ内容：" class="area" /></td>
    </tr>
    </table>
    <div class="submit_btn_box">
    <div id=".contents-btn-set">
    <br><s:submit value="送信" class="submit_btn" onClick="disp()" />
    </div>
    </div>



    </s:form>
    </div>
    <s:include value="footer.jsp"/>

</body>
</html>