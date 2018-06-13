
	public interface Mp3Player {
		public abstract void play();
		public abstract void stop();
		public abstract void next();
		public abstract void back();
}
//まずはここに抽象的な情報としてMp3Playerを記述する。
	//書き方は　public interface ←ここをクラスにしない！
	//これはクラスではないので抽象と呼ぶ