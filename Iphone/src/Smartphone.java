
public class Smartphone extends Mp3Player {
	public void call(){
		System.out.println("電話");
	}
	public void mail(){
		System.out.println("メール");
	}
	public void photo(){
		System.out.println("写真");
	}
	public void internet(){
		System.out.println("インターネット");
	}
}
//ここでも電話、メール、写真、インターネットのvoidが書かれている。
//しかし、extends　で親のpublicになっており、Mp3Playerを継承している事となる。
//つまり今この中に入っているのはここで書いた事を含め8つである

//※、なお、ここでMp3Playerの再生、停止、次へ、戻り。等を上書きする事も可能である。