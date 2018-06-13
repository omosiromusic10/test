
public class Person {
	public String name = null;
	public int age = 0;

	public Person(){}
	public Person(String name, int age){
		this.name = name;
		this.age = age;
		}
	public Person(String name){
		this.name = name;
		this.age = 0;
		}
		public Person(int age){
		this.name = "名前なし";
		this.age = age;
		}
		public Person(int age, String name){
		this.name = name;
		this.age = age;
		}
}
//逆にこちらはpersonを区切って処理しているのでその都度で設定の中身の変更が可能である。

//用は固定化をしたいならこちら？　絶対変更無し　の場合はこちらでもよさそう。