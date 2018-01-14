package com.solt_inc.janken.katoh04;

//独自の例外クラス。Exceptionクラスを継承。
class MissInputException extends Exception{
	//warningを回避するための宣言
	private static final long serialVersionUID = 1L;

	// コンストラクタ
	MissInputException(String msg){
		super(msg);
	}
}
