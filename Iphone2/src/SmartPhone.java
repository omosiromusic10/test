	public class SmartPhone extends Phone implements Mp3Player,NewFunction {

		}
//そしてここでその内容を強制的に上書き(オーバーライド)させるようにしている
	//そして更にPhoneから継承を行い、データとしてここにのっかっている状態。
	//そしてここが一番継承されているポジションなのでここでも上書きは可能。