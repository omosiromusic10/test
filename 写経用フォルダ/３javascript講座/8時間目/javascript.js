var a =20;
if(a>10){
if(a<30){
document.write("A")
}
}
//　この場合でfalseならば弾かれ何も表示されない。
var b =7;
if(b>3){
if(b<10){
document.write("B")
}
}
var age= 81;
if(age <20){
document.write("未成年");
}
else if(age >80){
document.write("高齢者");
}
else{
	document.write("成人");
}

var age1= 40;
if(age1 <20){
document.write("未成年");
}
else if(age1 >=20 && age1 <=80){
document.write("成人");
}
else{
	document.write("高齢者");
}

var c=5;
if (c % 2 == 0){
	document.write("偶数");
}
else{
	document.write("奇数");
}

var kokugo= 80;
var suugaku= 65;
if (kokugo >=70 && suugaku >=70){
document.write("合格！");
}
else{
document.write("不合格");
}

var d=2;
if (d > 1 && d == 2 ){
	document.write("A+");
}
else if (d == 3){
	document.write("B+");
}
else{
	document.write("C+");
}