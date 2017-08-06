package com.solt_inc.janken2.katoh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args){

		//グーは0 チョキは1 パーは2
      	System.out.println("じゃんけんゲームです。");
      	System.out.println("グーは 0：チョキは1：パーは2:");
      	System.out.print("を入力してください。：");

      	//テキストの入力'
      	InputStreamReader isr = new InputStreamReader(System.in);
      	BufferedReader br = new BufferedReader(isr);
      	String buf = "";

      	//ファイルの入力

      	try {

     		buf = br.readLine();

      		//文字列を数値にする。
      		int te;

      		Player Play = new Player();
      		Cpu Enemy = new Cpu();
      		Result Judge = new Result();

      		int ran;
      		int IVicotoryPoint = 1;
      		while(true){

      			//自分の手を決める
      			te = Play.Player_Hand(buf);

      			//相手の手を決める
      			ran = Enemy.Cpu_Hand();

      			//結果
      			Judge.Jude_Result(te, ran ,IVicotoryPoint);

      			//出力クラス


      			//もう一度
      			System.out.println("==================================================");
      	      	System.out.println("じゃんけんゲームです。");
      	      	System.out.println("グーは 0：チョキは1：パーは2:");
      	      	System.out.println("終了は9:");
      	      	System.out.print("を入力してください。：");
      			buf = br.readLine();

      			if (buf.equals("9"))
      			{
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
