package com.solt_inc.janken2.katoh;

public class Result {

	public void Jude_Result(int te,int ran){

		//判定＆結果を出す
		//役を判定する
		//こちらグー　相手：チョキ
		if(te == 0 && ran == 1){
			System.out.print("あなたの勝ちです。\r\n");
		//チョキ　パー
		} else if (te == 1 && ran == 2){
			System.out.print("あなたの勝ちです。\r\n");
		//パー　グー
		}else if (te == 2 && ran == 0 ){
			System.out.print("あなたの勝ちです。\r\n");
		//引き分け
		}else if (te == ran){
			System.out.print("引き分けです。\r\n");
		//負け
		}else{
			System.out.print("あなたの負けです。\r\n");
		}
	}
}
