public class Test {
	public static void main(String[] args){


		Person taro = new Person();
		taro.name = "Taro";
		taro.age = 18;
		System.out.println(taro.name);
		System.out.println(taro.age);
		Person jiro = new Person("jiro", 20);
		System.out.println(jiro.name);
		System.out.println(jiro.age);
		Person saburo = new Person("saburo");
		System.out.println(saburo.name);
		System.out.println(saburo.age);
		Person nanasi = new Person(25);
		System.out.println(nanasi.name);
		System.out.println(nanasi.age);
		Person hanako = new Person(17,"hanako");
		System.out.println(hanako.name);
		System.out.println(hanako.age);

	}
}
//こちらは既にperson.javaで「()」の設定を入れている為、()内での入力が可能になっている。

//結論はやっている根本的な内容は変わらない？