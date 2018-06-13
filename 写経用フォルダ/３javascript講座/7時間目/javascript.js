/*if文とは・・・「もし○○○なら、XXXと処理する」
という命令をするプログラミング

if分活用例)
　新規でSNSに登録する際、使われているIDであれば、　←○○○なら
 
 「このIDは既に使用されています。」と表示される。　←XXXと処理する。　*/

var a=15;
if(a>10){
document.write("A<br>");}

var b=7;
if(b<10){
document.write("B<br>");}

/* a>b a<b a>=b a<=b 
　　等はわかるが
  初・・・　A==B　これは等しい　＝ひとつじゃだめ！
  A!=B　AとBは等しくない！　
  A<>B　AとBは等しくない！ */
var c =10;
if(c ==10){
document.write("C<br>");
}

var d =15;
if(d !=10){
document.write("D<br>");
}

//アラートも使えるよ！
var e =5;
if(e ==5){
	alert("注意してください！");
}

/* 論理演算子　ってのもあるよ。
&& 意味　and　・・・aとbが共にtrueの場合
|| 意味　or　・・・aかbのどちらかがtrueの場合
!  意味　not・・・aがtrueの場合処理は実行せんよ。 */


var a1= 5;
if(a1 <10 && a1 >3){
document.write("A1");}

var a2= 11;
if(a2 <= 5 || a2 >= 10){
document.write("A2");
}

//0 こっから　else if　やで！

var a3= 11;
if(a3 > 10){
document.write("A3");
}
else if(a3 < 10){
document.write("notA3");
}

var a4= 11;
if(a4 > 7){
document.write("A4");
}
else if(a3 < 8){
document.write("notA4");
}
// ここから　else　のみの書き方！

var a5= 10;
if(a5 > 10){
document.write("A5");
}
else {
document.write("notA5");
}

var a6= 18;
if(a6 > 20){
document.write("成人");
}
else {
document.write("未成年");
}

