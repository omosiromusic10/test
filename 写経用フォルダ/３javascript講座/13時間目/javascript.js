// 配列について・・・複数の文字や数字を管理
//　格納する番号はプログラミング上　必ず０からスタートだ！

//　箱に入れられた物は「value」と呼ばれ　箱の番号をkey(または添え字)というぞ！
//　あわせてelementになるぞ！ｗ(合体かな？)
var myoji =["田中","高橋","斉藤"]

document.write(myoji);

document.write(myoji[1]);

var myoji =["田中","高橋","斉藤"]
delete myoji[0];
document.write(myoji);

document.write(myoji[0]);

var myoji =["田中","高橋","斉藤"]

myoji[3]="鈴木";
document.write(myoji);

var myoji =["田中","高橋","斉藤"]
myoji[0]="加藤"
document.write(myoji);

var myoji ={"A組":"田中","B組":"高橋","C組":"斉藤"};
document.write(myoji["A組"]);
document.write(myoji);