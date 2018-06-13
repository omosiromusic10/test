/* Switch文らしいぜ！
もし○○○とXXXが等しければ　△と処理しなさい。　という事
A==Bという等価に特化した条件分岐だぜ！*/

var a=5;
switch(a){
	case 0:
		document.write("aは0に等しい");
		break;
	case 1:
		document.write("aは1に等しい");
		break;
	default:
		document.write("aは0でも1でもない");
}
var b="青";
switch(b){
	case "赤":
		document.write("赤組です");
		break;
	case "白":
		document.write("白組です");
		break;
	default:
		document.write("エラーです");
}