/*jQuery のさまざまなイベント

クリックした時やマウスに触れた時にイﾍﾞﾝﾄを発生させる。

例
$(function(){
$("セレクタ1").イベント(function{
 $("セレクタ2").メソッド(引数);
     });
});　*/
$(function(){
 $("h1").click(function(){
	 $("p").fadeOut();
 });
});

$(function(){
	$("div").click(function(){
		$("p").css("color","blue");
	});
});

$(function(){
    $(".total").click(function(){
		$("h2").text("20");
	});
});

$(function(){
    $(".boxA").click(function(){
	$(".boxB").hide();
	});
});