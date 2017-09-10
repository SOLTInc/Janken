package com.solt_inc.janken.katoh02;

import java.util.ArrayList;

public class Result {

	//-----------------------------------------------------
	//　結果処理
	//-----------------------------------------------------
	public void Jude_Result(int te,int ran ,ArrayList<Integer> IResultPoint,ArrayList<String> array){

		int result;
		//判定＆結果を出す
		//役を判定する
		//こちらグー　相手：チョキ
		if(te == 0 && ran == 1){
			System.out.println("あなたの勝ちです。");
			IResultPoint.set(0, IResultPoint.get(0) + 1);

			result = 1;
			//チョキ　パー
		} else if (te == 1 && ran == 2){
			System.out.println("あなたの勝ちです。");
			IResultPoint.set(0, IResultPoint.get(0) + 1);
			result = 1;
			//パー　グー
		}else if (te == 2 && ran == 0 ){
			System.out.println("あなたの勝ちです。");
			IResultPoint.set(0, IResultPoint.get(0) + 1);
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
			IResultPoint.set(2, IResultPoint.get(2) + 1);
		}

		//チョキを出した数
		if(te == 1)
		{
			IResultPoint.set(3, IResultPoint.get(3) + 1);
		}

		//パーを出した数
		if(te == 2)
		{
			IResultPoint.set(4, IResultPoint.get(4) + 1);
		}

		//対戦数
		IResultPoint.set(1, IResultPoint.get(1) + 1);

		//結果出力
		OutputLog Output = new OutputLog();
		Output.Output_Result(IResultPoint);

		//結果出力
		Past Past = new Past();
		array.add(Past.Output_Text(IResultPoint,te,ran,result));
		Past.Output_Past(array);

		System.out.println("");

	}

}
