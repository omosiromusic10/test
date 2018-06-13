// unshift　で新しい要素を割り込みできるぞ！
var myoji=["田中","高橋","斉藤"];
myoji.unshift("鈴木");
document.write(myoji);

// push　で配列の末尾に、新しく要素を追加できるぞ！

var myoji=["田中","高橋","斉藤"];
myoji.push("鈴木");
document.write(myoji);

// shift で配列の先頭を削除できるぞ！

var myoji=["田中","高橋","斉藤"];
myoji.shift();
document.write(myoji);

// pop　を使えば配列の末尾を削除できるぞ！

var myoji=["田中","高橋","斉藤"];
myoji.pop();
document.write(myoji);

// slice　を使って　配列の一部を切り取れるぞ！
//　※　ここでは１以上　２未満　なので　１の高橋しか表示されないぞ！！！
var myoji=["田中","高橋","斉藤"];
document.write(myoji.slice(1,2));