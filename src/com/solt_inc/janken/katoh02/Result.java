package com.solt_inc.janken.katoh02;

public class Result {

	//-----------------------------------------------------
	//　結果処理
	//-----------------------------------------------------
	public void Jude_Result(int te,int ran ,int[] IResultPoint){

		int result;
		//判定＆結果を出す
		//役を判定する
		//こちらグー　相手：チョキ
		if(te == 0 && ran == 1){
			System.out.println("あなたの勝ちです。");
			IResultPoint[0] = IResultPoint[0] + 1;
			result = 1;
			//チョキ　パー
		} else if (te == 1 && ran == 2){
			System.out.println("あなたの勝ちです。");
			IResultPoint[0] = IResultPoint[0] + 1;
			result = 1;
			//パー　グー
		}else if (te == 2 && ran == 0 ){
			System.out.println("あなたの勝ちです。");
			IResultPoint[0] = IResultPoint[0] + 1;
			result = 1;
			//引き分け
		}else if (te == ran){
			System.out.println("引き分けです。");
			result = 0;
			//負け
		}else{
			System.out.println("あなたの負けです。");
			result = -1;
		}

		//ログ用処理
		//グーを出した数
		if(te == 0)
		{
			IResultPoint[2] = IResultPoint[2] + 1;
		}

		//チョキを出した数
		if(te == 1)
		{
			IResultPoint[3] = IResultPoint[3] + 1;
		}

		//パーを出した数
		if(te == 2)
		{
			IResultPoint[4] = IResultPoint[4] + 1;
		}

		//対戦数
		IResultPoint[1] = IResultPoint[1] + 1;

		//結果出力
		Past Past = new Past();
		Past.Output_Past(IResultPoint,te, ran ,result);

		System.out.println("");

	}

}
