package com.solt_inc.janken2.katoh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args){

		//グーは0 チョキは1 パーは2
      	System.out.print("じゃんけんゲームです。\r\nグーは 0：チョキは1：パーは2:\r\nを入力してください。：");
      	InputStreamReader isr = new InputStreamReader(System.in);
      	BufferedReader br = new BufferedReader(isr);
      	String buf = "";
      	try {

     		buf = br.readLine();

      		//文字列を数値にする。
      		int te;

      		Player Play = new Player();
      		Cpu Enemy = new Cpu();
      		Result Judge = new Result();

      		int ran;

      		while(true){

      			//自分の手を決める
      			te = Play.Player_Hand(buf);

      			//相手の手を決める
      			ran = Enemy.Cpu_Hand();

      			//結果
      			Judge.Jude_Result(te, ran);

      			//もう一度
      			System.out.print("==================================================\r\n");
      			System.out.print("じゃんけんゲームです。\r\nグーは 0：チョキは1：パーは2:終了は9：\r\nを入力してください。：");
      			buf = br.readLine();

      			if (buf.equals("9"))
      			{
      				System.out.print("終了します。おつかれさまでした。");
      				break;
      			}
      		}

      	} catch (IOException e) {
      		// TODO 自動生成された catch ブロック
      		e.printStackTrace();
      	}

    }

}
