public class Person {

	private String name= null;
	private int age = 0;

	public String getName(){
		return this.name;
	}

	public Person(String name,int age){
		this.name=name;
		this.age=age;
	}

	public void setName(String name){
		this.name = name;
	}

}
//これは情報を見られないようにしてるためprivateにしている。
//今まで見れていたname ageじゃなくて getNameにして表示するようにしている。
//その情報を登録しなおす為にsetNameを使う。