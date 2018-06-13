//　関数とは・・・予めなんらかの処理をまとめておくことで効率よくプラグラミングをする手法！
/* 書き方その１
　　function 関数名(引数1,引数2,引数3・・・){
  処理1;
  処理2;
  return 戻り値
  }
  
  書き方その２
  var 関数名 = function (引数1,引数2,引数3・・・){
  処理1;
  処理2;
  return 戻り値
  } */

document.write("問1<br>")

function menseki (hankei){
	return "面積は" + hankei * hankei * 3.14 +"cm2です。"
}
document.write(menseki(5));
document.write("<br>")
document.write(menseki(7));
document.write("<br>")
document.write(menseki(10));

document.write("<br>")
document.write("問2<br>")

function kingaku (otona,kodomo){
	return 500 * otona + 200 * kodomo + "円です。"
}
document.write(kingaku(2,4));
document.write("<br>")
document.write(kingaku(1,5));
document.write("<br>")
document.write(kingaku(3,7));
