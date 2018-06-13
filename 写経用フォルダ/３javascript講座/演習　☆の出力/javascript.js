document.write("問1<br>");

for (a = 1 ; a <= 5 ; a++){
	document.write("★");
}

document.write("<br>問2");

for (a = 1 ; a <= 2 ; a++){
	document.write("<br>")
	for (b = 1 ; b <= 3 ; b++){
		document.write("★");
	}
}

document.write("<br>問3");

for (a = 1 ; a <= 2 ; a++){
	document.write("<br>")
	for (b = 1 ; b <= 5 ; b++){
		document.write("☆");
	}
}

document.write("<br>問4");

for (a = 1 ; a <= 4 ; a++){
	document.write("<br>")
	for (b = 1 ; b <= 5 ; b++){
		document.write("★");
	}
}

document.write("<br>問5");

for (a = 1 ; a <= 4 ; a++){
	document.write("<br>")
	for (b = 1 ; b <= 3 ; b++){
		document.write("★");
	}
}

document.write("<br>問6");

for (a = 1 ; a <= 3 ; a++){
	document.write("<br>")
	for (b = 1 ; b <= 1 ; b++){
		document.write("★☆★");
	}
}

document.write("<br>同問6");

for (a = 1 ; a <= 3 ; a++){
	document.write("<br>")
	for (b = 1 ; b <= 2 ; b++){
		document.write("★");
	if (b == 1){
		document.write("☆");
	}
	}
}

document.write("<br>問7");

for (a = 1 ; a <= 4 ; a++){
	document.write("<br>")
	for (b = 1 ; b <= 3 ; b++){
		document.write("★");
	if (b == 1 || b == 2){
		document.write("☆");
	}
	}
}

document.write("<br>問8");

document.write("<br>")
for (a = 1 ; a <= 1 ; a++){
	document.write("★");
}
document.write("<br>")
for (a = 1 ; a <= 2 ; a++){
	document.write("★");
}
document.write("<br>")
for (a = 1 ; a <= 3 ; a++){
	document.write("★");
}
document.write("<br>")
for (a = 1 ; a <= 4 ; a++){
	document.write("★");
}
document.write("<br>")
for (a = 1 ; a <= 5 ; a++){
	document.write("★");
}

document.write("<br>");

for(a = 1 ; a <= 5 ; a++){
	for (b = 1 ; b <= 5 ; b++){
		document.write("★");
		if(a == b){
			document.write("<br>")
			break;
		}
	}
}