/* hover イベント！　mauseover mauseoutの二つのイベントが出来るよ

書き方

$(function(){
    $("セレクタ").hover(
	function(){
	},
	function(){
	});
	});
	
	上は乗せた時、上ははずした時*/
$(function(){
	$("img").hover(
	function(){
		$(this).animate({width:"220px"});
	},
	function(){
		$(this).animate({width:"200px"})
	}
		);
		});