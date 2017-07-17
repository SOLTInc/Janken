package com.solt_inc.janken.kida.base;

/**
 * 各コンテンツ作成時に継承して使う基本クラス
 * 処理の流れを定義している
 **/
public abstract class BaseService {

	// コンテンツ実行の際はこのメソッドを実行すること
	public void execute(String title){

		title(title);
		if(!chk()){
			dispMenu();
			return;
		}
		init();
		while(body()){}
		dispMenu();
	}

	// タイトル表示
	protected void title(String title){
		System.out.println("**********"+title+"**********");
		System.out.println("");
	}

	// 主処理実施可否チェック処理
	protected boolean chk(){return true;}

	// 初期化処理
	protected void init(){}

	// 主処理
	protected abstract boolean body();

	// メニュー表示処理
	protected void dispMenu(){
		System.out.println("メニュー番号を入力して下さい");
		System.out.println("1:じゃんけん  2:スロット  99:終了");
	}
}
