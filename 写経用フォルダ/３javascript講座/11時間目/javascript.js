// 応用編だぜ！
for(var i = 1 ; i<=10 ; i++){
	if(i % 2 == 0){
	document.write(i+"<br>");}
}
for(var i = 1 ; i<=3 ; i++){
	document.write("■外側のfor文"+i+"回目<br>");
for(var a = 1 ; a<=3 ; a++){
	document.write("内側のfor文"+a+"回目<br>");
}
}
for(var i = 1 ; i<=3 ; i++){
	document.write("■外側のfor文"+i+"回目<br>");
}
for(var a = 1 ; a<=3 ; a++){
	document.write("内側のfor文"+a+"回目<br>");
}
for(var i = 1 ; i<=9 ; i++){
	for(var a =1; a<=9 ;a++){
		document.write(i * a);
	}
	document.write("→"+i+"の段<br>");
}