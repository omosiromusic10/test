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
  function nameHello(name){
  return name +"さん。こんにちは";
  }
document.write(nameHello("山田"));
document.write("<br>")
document.write(nameHello("鈴木"));
document.write("<br>")
document.write(nameHello("佐藤"));

 function jikoShokai(shugo,myoji){
  return shugo +"の名前は"+ myoji + "です。";
  }
document.write(jikoShokai("私","山田"));
document.write("<br>")
document.write(jikoShokai("僕","鈴木"));
document.write("<br>")
document.write(jikoShokai("俺","佐藤"));

 function menseki(tate,yoko){
  return "面積は" + tate*yoko + "cm2です。";
  }
document.write(menseki(3,2));
document.write("<br>")
document.write(menseki(4,3));
document.write("<br>")
document.write(menseki(5,8));
