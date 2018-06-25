<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript"/>
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content=""/>
<title>BuyItemComplete画面</title>
<style type="text/css">
body{
  margin: 0 ;
  padding: 0;
  line-height: 1.6;
  letter-spacing: 1px;
  font-family:Verdana , Helvetica, sans-serif;
  font-size: 12px;
  color: #333;
  background: #fff;
}
table{
  text-align: center;
  margin: 0 auto;
}

#top{
  width: 780px;
  margin: 30px auto;
  border: 1px solid #333;
}
#header{
  width: 100%;
  height: 80px;
  background-color: black;
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
  height: 500px;
  text-align: center;
}
#footer{
  width: 100%;
  height: 80px;
  background-color: black;
  clear: both;
}
</style>
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
            <p>BuyItemComplete</p>
        </div>
        <div>
            <p>購入手続きが完了致しました。</p>
            <div>
                <a href='<s:url action="MyPageAction"/>'>マイページ</a><span>から購入履歴の確認が可能です。</span>
                <p>Homeへ戻る場合は<a href='<s:url action="GoHomeAction" />'>こちら</a>
            </div>
        </div>
    </div>
    <div id="footer">
        <div id="pr">
        </div>
    </div>

</body>
</html>