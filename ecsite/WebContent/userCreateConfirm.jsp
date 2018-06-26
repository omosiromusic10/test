<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style" content="text/css"/>
<meta http-equiv="Content-Script" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no"/>
<meta name="description" content=""/>
<meta name="keywords" content="" />
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<title>UserCreateConfirm画面</title>
<style type="text/css">
/* ========TAG LAYOUT======== */
body{
  margin: 0;
  padding: 0;
  line-height: 1.6;
  letter-spacing: 1px;
  font-family: Verdana,Helvetica,sans-serif;
  font-size: 12px;
  color: #333;
  background: #fff;
  background-image:url("./img/image6.jpg");
}
table{
  text-align: center;
  margin: 0 auto;
}
/* ========ID LAYOUT======== */
#top{
  width: 780px;
  margin: 30px auto;
  padding: 0.5em;
  color: #010101;
  font-size:20px;
  background: #eaf3ff;
  border-bottom: solid 3px #516ab6;
  height: 60px;
}
#header{
  width: 100%;
  height: 80px;
  osition: relative;
  padding: 0.2em 0.5em;
  background: -moz-linear-gradient(to right, rgb(111, 124, 255), #ffc994);
  background: -webkit-linear-gradient(to right, rgb(111, 124, 255), #ffc994);
  background: linear-gradient(to right, rgb(111, 124, 255), #ffc994);
  color: white;
  font-weight: lighter;
  box-shadow: 0 0 4px rgba(0, 0, 0, 0.56);
}
.logo{
  float:left;
  width:200px;
  padding-left:10px;
  color:white;
  font-size:25px;
  line-height:80px;
}

#header ul{
  float:right;
  line-height:50px;
}
#header ul li{
  float:left;
  list-style:none;
  padding-right:40px;
  color:white;
  font-size:18px;
}
.home a {
  text-decoration:none;
  color:white;
}
#main{
  width: 100%;
  height: 600px;
  text-align: center;

}
#footer{
  width: 100%;
  height: 80px;
  background-color: black;
  clear: both;
}
</style>
<script type="text/javascript">
    jQuery(function(){
    $(function(){
    $(".home a").hover(
    function(){
    	$(this).css("color","gray");
    },
    function(){
    	$(this).css("color","white");
    });
    });
    });
  </script>
</head>
<body>
    <div id="header">
        <div id="pr">
	 <div class="logo">ECサイトロゴ！</div>
	 <ul class="home">
	     <li><a href="home.jsp">ホーム</a></li><!--  ただhomeページに戻すだけ-->
	     <li><a href='<s:url action="MyPageAction"  />'>購入履歴</a></li>   <!-- これはMyPageActionを経由させつつ移動させなくてはいけない。 -->
	     <li><a href='<s:url action="InquiryAction" />'>お問い合わせ</a></li>  <!-- inquiryActioに連結させてそこからお問い合わせを出来るようにする -->
	     <li><a href='<s:url action="LogoutAction"  />'>ログアウト</a></li> <!-- これはlogoutActionを経由してつなげなくてはいけない。 -->
	 </ul>
	 </div>
        </div>
    <div id="main">
       <div id="top">
           <p>UserCreateConfirm</p>
       </div>
       <div>
           <h3>登録する内容は以下でよろしいですか。</h3>
           <table>
               <s:form action="UserCreateCompleteAction">
                   <tr id="box">
                       <td>
                           <label>ログインID:</label>
                       </td>
                       <td>
                           <s:property value="loginUserId" escape="false"/>
                       </td>
                   </tr>
                   <tr id="box">
                       <td>
                           <label>ログインPASS:</label>
                       </td>
                       <td>
                           <s:property value="loginPassword" escape="false"/>
                       </td>
                   </tr>
                   <tr id="box">
                       <td>
                           <label>ユーザー名:</label>
                       </td>
                       <td>
                           <s:property value="userName" escape="false"/>
                       </td>
                   </tr>
                   <tr>
                       <td>
                           <s:submit value="完了"/>
                       </td>
                  </tr>
                  </s:form>
           </table>
       </div>
    </div>
    <div id="footer">
        <div id="pr">
        </div>
    </div>

</body>
</html>