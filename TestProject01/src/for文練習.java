//for文はほとんど一緒だ！
/*for
( 初期値(String,int) ; 条件式 ;　増減式){
処理内容
}
*/

public class for文練習 {

	public static void main(String[] args) {
for( int i = 1 ; i <=10 ; i++){
	if( i % 2 == 0 ){
		System.out.println(i + "\n");
	}
}

for ( int h = 0 ; h < 3 ; h++ ){
	for ( int j = 1 ; j < 4 ; j++){
		System.out.println(j + "\n");
	}
}

// 条件演算子　new!!
//　条件式　? 式1 ：　式2

int a = 10;
String b = a >= 0 ? "プラス" : "マイナス";
 System.out.println(b);


 int c = 2;
 String d = c % 2 == 0 ? "偶数" : "奇数" ;
 System.out.println(d);


for ( int e = 0 ; e <= 5 ; e++){
	String f = e % 2 == 0 ? "☆" : "★" ;
	System.out.println(f);
}

// while文はほとんど同じだけど　特殊な形で do whileという物があるぞ！

//　do while 必ず１度は実行させたい時に使う。

/*　初期値;
 * do{
 *  処理内容 ;
 * 　増減式 ;
 * } while (条件式);
 */
int K = 0 ;
do{
	System.out.println(K);;
	K++;
} while(K < 10 );


}}