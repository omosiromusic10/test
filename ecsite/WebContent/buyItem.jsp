<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content=""/>
<meta name="keywords" content="" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
  <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<title>BuyItem画面</title>

<style type="text/css">
/* ========TAG LAYOUT======== */
body{
  margin: 0;
  padding: 0;
  line-height: 1.6;
  letter-spacing: 1px;
  font-family:Verdana, Helvetica, sans-serif;
  font-size: 12px;
  color: #333;
  background: #fff;
  background-image:url("./img/image6.jpg");
}
table{
  text-align: center;
  margin: 0 auto;
}
.roop{
  float: left;
  margin-left:10%;
}
.notroop{
  clear:both;
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
.image{
   float:left;
   margin-left :5.5%;
}
#back{
  clear: both;
  text-align: center;
  margin: 0 auto;
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
           <p>サイト購入画面</p>
        </div>
        <s:form action="BuyItemAction">
        <div class="image">
            <input type="image" src="./img/images.jpg"  width="200px" />
            </div>
        <div class="image">
            <input type="image" src="./img/image2.jpg"  width="200px" />
            </div>
        <div class="image">
            <input type="image" src="./img/image3.jpg"  width="200px" />
            </div>
        <div class="image">
            <input type="image" src="./img/image4.jpg"  width="200px" />
            </div>
        <div class="image">
            <input type="image" src="./img/image5.jpg"  width="200px" />
        </div>
            <s:iterator value="buyItemList">
                <table class="roop">
                <tr>
                    <td>
                        <span>商品名</span>
                    </td>
                    <td>
                        <s:property value="itemName" /><br>
                        <s:hidden name="itemName" value="%{itemName}"/>
                    </td>
                </tr>
                 <tr>
                    <td>
                        <span>値段</span>
                    </td>
                    <td>
                        <s:property value="itemPrice" /><span>円</span><br>
                        <s:hidden name="itemPrice" value="%{itemPrice}"/>
                    </td>
                </tr>
                 <tr>
                    <td>
                        <span>商品個数</span>
                    </td>
                    <td>
                        <select name="count">
                            <option value="0" selected="selected">0</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                        </select>

<!--              これを入れないとcountとして機能しない -->
                    </td>
                </tr>
                </table>
            </s:iterator>
            <table class="notroop">
                <tr>
                    <td>
                        <span>支払い方法</span>
                    </td>
                    <td>
                        <input type="radio" name="pay" value="1" checked="checked">現金払い
                         <input type="radio" name="pay" value="2">クレジットカード
                    </td>
                </tr>
                <tr>
                    <td>
                        <s:submit value="購入"/>
                    </td>
                </tr>
          </table>
              </s:form>
              </div>
                <div id ="back">
            <p>前画面に戻る場合は<a href='<s:url action="GoHomeAction" />'>こちら</a></p>
            <p>マイページは<a href='<s:url action="MyPageAction"  />'>こちら</a></p>
                </div>


<div id="footer">
    <div id="pr">
    </div>
</div>

</body>
</html>