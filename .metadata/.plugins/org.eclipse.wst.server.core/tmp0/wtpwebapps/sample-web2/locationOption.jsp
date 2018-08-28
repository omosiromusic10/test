<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>locationOption</title>
</head>
<body>
<!-- ヘッダーをインクルード -->
<jsp:include page="header.jsp" />

<div id="contents">

  <h1>locationOption画面</h1>

  <!-- 自宅に配送かBBQ場に配送かを選ぶ -->
  <!-- 自宅を選択した場合、SettlementConfirmActionに飛ぶ   -->
  <!-- BBQ場を選択した場合、LocationChoiceActionに飛ぶ -->

  自宅に配送するか、提携しているBBQ場へ直接配送するかを選択できます。
<br>
<br>

  <table>
    <tr>
      <td>自宅</td>
      <td>
        <s:form action="SettlementConfirmAction">
		  <s:submit value="決済画面へ" class="submit_btn" />
	    </s:form>
      </td>
    </tr>
    <tr>
      <td>BBQ場</td>
      <td>
        <s:form action="LocationChoiceAction">
		  <s:submit value="選択画面へ" class="submit_btn" />
	    </s:form>
      </td>
    </tr>
  </table>

</div>
<!-- フッターをインクルード -->
<jsp:include page="footer.jsp" />
</body>
</html>