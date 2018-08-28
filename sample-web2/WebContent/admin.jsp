<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/admin.css">
<title>管理者画面</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div id="contents">
<h1>管理者画面</h1>

<div class="submit_btn_box2">
    <div id=".contents-btn-set">
        <s:form action="AdminRegistAction">
            <s:submit value="商品登録・追加" class="submit_btn2"/>
        </s:form>
    </div>
</div>
<div class="submit_btn_box2">
    <div id=".contents-btn-set">
        <s:form action="AdminEditAction">
            <s:submit value="商品編集・変更" class="submit_btn2"/>
        </s:form>
    </div>
</div>
<div class="submit_btn_box2">
    <div id=".contents-btn-set">
        <s:form action="AdminDeleteAction">
            <s:submit value="商品削除" class="submit_btn2"/>
        </s:form>
    </div>
</div>

<div class="submit_btn_box2">
    <div id=".contents-btn-set">
    <s:form action="AdminProductSelectAction">
        <s:submit value="商品一覧画面" class="submit_btn2"/>
    </s:form>
    </div>
</div>

<div class="submit_btn_box2">
    <div id=".contents-btn-set">
    <s:form action="AdminPurchaseSelectAction">
        <s:submit value="購入履歴一覧画面" class="submit_btn2"/>
    </s:form>
    </div>
</div>
<div class="submit_btn_box2">
    <div id=".contents-btn-set">
    <s:form action="AdminAllSelectAction">
        <s:submit value="データ確認画面" class="submit_btn2"/>
    </s:form>
    </div>
</div>





</div>
<s:include value="footer.jsp"/>

</body>
</html>