
public class Test {
	public static void main(String[] args){
		Person taro = new Person();
		taro.name="山田太郎";
		taro.age=20;
		System.out.println(taro.name);
		System.out.println(taro.age);

		Person jirou = new Person();
		jirou.name="木村次郎";
		jirou.age=18;
		System.out.println(jirou.name);
		System.out.println(jirou.age);

		Person hanako = new Person();
		hanako.name="鈴木花子";
		hanako.age=16;
		System.out.println(hanako.name);
		System.out.println(hanako.age);

		Person masato = new Person();
		masato.name="野澤真斗";
		masato.age=21;
		masato.phoneNumber ="080-5456-5025";
		masato.address ="masato46491023@icould.com";
		System.out.println(masato.name);
		System.out.println(masato.age);
		System.out.println(masato.phoneNumber);
		System.out.println(masato.address);
        masato.talk();
        masato.walk();
        masato.run();



        Person aibo = new Person();
    	aibo.name="アイボ";
    	System.out.println(aibo.name);
    	aibo.talk();
    	aibo.walk();
    	aibo.run();

    	Person asimo = new Person();
    	asimo.name ="アシモ";
    	System.out.println(asimo.name);
    	asimo.talk();
    	asimo.walk();
    	asimo.run();

    	Person pepper =new Person();
    	pepper.name ="ペッパー";
    	System.out.println(pepper.name);
    	pepper.talk();
    	pepper.walk();
    	pepper.run();

    	Person doracumon =new Person();
    	doracumon.name ="ドラクモン";
    	System.out.println(doracumon.name);
    	doracumon.talk();
    	doracumon.walk();
    	doracumon.run();

}
}

//なのでこちらは全てnameとageを手書き入力しているが