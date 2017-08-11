package com.solt_inc.janken.katoh02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	//-----------------------------------------------------
	//　メイン処理
	//-----------------------------------------------------
	public static void main(String[] args){

		//じゃんけんゲーム紹介テキスト
      	System.out.println("じゃんけんゲームです。");
      	System.out.println("グーは 0：チョキは1：パーは2:");
      	System.out.print("を入力してください。：");

      	//手の入力処理
      	InputStreamReader isr = new InputStreamReader(System.in);
      	BufferedReader br = new BufferedReader(isr);
      	String buf = "";

      	//ファイルの入力（未記入）

      	try {

     		buf = br.readLine();

      		//文字列を数値にする。
      		int te;

      		Player Play = new Player();
      		Cpu Enemy = new Cpu();
      		Result Judge = new Result();
      		OutputLog Output = new OutputLog();

      		int ran;

      		//ログ変数
      		int[] IResultPoint = new int[5];//0：勝ち数、1:対戦数、2:グーの出した数、3:チョキの出した数、4:パーの出した数

      		//仮
      		IResultPoint[0] = 0;
      		IResultPoint[1] = 0;
      		IResultPoint[2] = 0;
      		IResultPoint[3] = 0;
      		IResultPoint[4] = 0;

      		while(true){

      			//自分の手を決める
      			te = Play.Player_Hand(buf);

      			//相手の手を決める
      			ran = Enemy.Cpu_Hand();

      			//結果
      			Judge.Jude_Result(te, ran ,IResultPoint);

      			//もう一度
      			System.out.println("==================================================");
      	      	System.out.println("じゃんけんゲームです。");
      	      	System.out.println("グーは 0：チョキは1：パーは2:");
      	      	System.out.println("終了は9:");
      	      	System.out.print("を入力してください。：");
      			buf = br.readLine();

      			if (buf.equals("9"))
      			{
          			//結果出力
          			Output.Input_Result(IResultPoint);

      				System.out.println("終了します。おつかれさまでした。");
      				break;
      			}
      		}

      	} catch (IOException e) {
      		// TODO 自動生成された catch ブロック
      		e.printStackTrace();
      	}

    }

}
