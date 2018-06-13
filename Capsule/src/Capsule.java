
public class Capsule {
	public static void main(String[] args){
		Person taro = new Person("山田太郎",20);
		//ここで山田太郎と１回目で登録
		System.out.println(taro.getName());
		//ここでprivateにされているnameだけではだめなので先程publicになっているgetNameで
		taro.setName("花子");
		//ここはsetName(登録)になっているので花子に登録
		System.out.println(taro.getName());
		//そして登録しただけではわからないので更に表示するとこのようになる
		}

}
