<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css"/>
<meta http-equiv="Content-Script-Type" content="text/javascript"/>
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<title>BuyItemConfirm画面</title>
<style type="text/css" >
body{
  margin: 0;
  padding: 0;
  line-height: 1.6;
  letter-spacing: 1px;
  font-family: Verdana, Helvetica ,sans-serif;
  font-size: 12px;
  color: #333;
  background: #fff;
  background-image:url("./img/image6.jpg");
}
table{
  text-align: center;
  margin: 0 auto;
}

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
        function submitAction(url){
        	$('form').attr('action',url);
        	$('form').submit();
        }
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
           <p>BuyItem</p>
       </div>
       <div>
           <s:form>
           <s:iterator value="buyItemList">
               <tr>
                   <td>商品名</td>
                   <td><s:property value="itemName" /></td>
               </tr>
               <tr>
                   <td>単体値段</td>
                   <td><s:property value="itemPrice" /><span>円</span></td>
               </tr>
               <tr>
                   <td>購入個数</td>
                   <td><s:property value="count" /><span>個</span></td>
               </tr>
               </s:iterator>
               <tr>
                   <td>支払い方法</td>
                   <td><s:property value="session.pay" /></td>
               </tr>
               <tr>
                   <td>合計金額</td>
                   <td><s:property value="session.total_price"/><span>円</span></td>
               </tr>
               <tr>
                   <td><br></td>
               </tr>
               <tr>
                   <td><input type="button" value="戻る"
                       onclick="submitAction('HomeAction')"/></td>
                   <td><input type="button" value="完了"
                       onclick="submitAction('BuyItemConfirmAction')"/></td>
                   </tr>
               </s:form>
       </div>
    </div>
    <div id="footer">
        <div id="pr">
        </div>
    </div>

</body>
</html>