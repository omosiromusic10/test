<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<link rel="stylesheet" href="./css/style.css">
<title>サンプルウェブホーム！</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>



  <script type="text/javascript">
  var img = ["./images/images.jpg","./images/image2.jpg","./images/image3.jpg","./images/image4.jpg","./images/image5.jpg"];

  var timer;
  var count = -1;

  function timerStart() {
      //画像インデックス
      count++;
      //画像数確認
      if (count == img.length) count = 0;
      //画像出力
      document.getElementById("dat").src = img[count];
      //タイマーを設定
      timer = setTimeout("timerStart()",2000);
  }

  function timerStop() {
      //タイマーをクリア
      clearInterval(timer);
  };

  $(function(){
	    $(".inquiry a").hover(
	    function(){
	    	$(this).css("color","gray");
	    },
	    function(){
	    	$(this).css("color","black");
	    });
	    });

  </script>
</head>
<body>
<jsp:include page="header.jsp" />

<div id="contents">
<!-- メインビジュアル -->
<div id ="MainArea">
<h1>ホーム画面</h1>
<div class="ribbon_box">
    <span class="ribbon">★</span>
    <div>
       <p>サンプルウェブへようこそ！</p>
    </div>
</div>

   <div style="display:inline-flex;">
        <input type="button" value="START" onClick="timerStart()">
        <input type="button" value="STOP" onClick="timerStop()">
    </div>
    <img src="./images/images.jpg" id="dat" width="300" height="300">



</div>

<!-- メインナビ -->
<div id="MainNaviArea">
<div class="4Wrap-clearfix">

<div class="colAinCol4" >
<a href="ProductListAction"><img  src="./images/food.jpg"></a>
<a href="ProductListAction"><img src="./images/food2.jpg"></a>
<a href="ProductListAction"><img src="./images/ice.jpg"></a>
<a href="ProductListAction"><img  src="./images/study.jpg"></a>
</div>



</div>
</div>

<!-- メインコインテンツ -->
<div id="MainContents">
    <div class="col2Wrap-clearfix">
    <div class="colAinCol2">
    <h2>LEFT</h2>



    </div>
    <div class="colBinCol2">
    <h2>商品関連</h2>
    <ul>
        <li>本日のお勧め！</li>
        <li>定番商品</li>
        <li>ランキング</li>
        <li></li>
        <li></li>
   </ul>
        ------------------------------------------------------------------
   <h2>お問合せ</h2>
   <div class="inquiry">
   <ul>
      <li><a href="InquiryAction">商品についてのお問合せ</a></li>
      <li><a href="InquiryAction">弊社についてのお問合せ</a></li>
      <li><a href="InquiryAction">その他についてのお問合せ</a></li>
   </ul>
   </div>

    </div>
    </div>

</div>

<!-- ここで何かさびしいのでアニメーションを作りたい。
と言っても結局jQueryをやろうとしても反応しない。
この上のscriptはecsiteのプロジェクトから持ってきた物で
ecsiteでは通常通りsliderで出来ていた。　何故こちらで出来ないのだろうか。 -->




</div>
<s:include value="footer.jsp"/>

</body>
</html>