package com.solt_inc.janken.katoh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {

	public static void main(String[] args) {

		//グーは0 チョキは1 パーは2
		System.out.print("じゃんけんゲームです。\r\nグーは 0：チョキは1：パーは2:\r\nを入力してください。：");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String buf = "";
		try {
			buf = br.readLine();

			//文字列を数値にする。
			int te;

			while(true){
				
				
				if (buf.equals("0") || buf.equals("1") || buf.equals("2")){
					te = Integer.parseInt(buf);
				}else {
					te = 3; //後だしということで不戦勝
				}

				switch (te){
					case 0:
						// te = 0;
						System.out.print("あなたの手はグーです。\r\n");
						break;
					case 1:
						// te = 1;
						System.out.print("あなたの手はチョキです。\r\n");
						break;
					case 2:
						// te = 2;
						System.out.print("あなたの手はパーです。\r\n");
						break;
					default:
						// te = 3;
						System.out.print("あなたの手は不正です。\r\n");
				}

				//CPUが出す役 乱数入力
				Random rnd = new Random();

				//相手の役を設定する
				int ran = rnd.nextInt(3);

				switch (ran){
					case 0:
						System.out.print("相手の手はグーです。\r\n");
						break;
					case 1:
						System.out.print("相手の手はチョキです。\r\n");
						break;
					case 2:
						System.out.print("相手の手はパーです。\r\n");
						break;
					default:
						System.out.print("相手の手は不正です。\r\n");
				}

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

				//もう一度
				System.out.print("じゃんけんゲームです。\r\nグーは 0：チョキは1：パーは2:\r\nを入力してください。：");
				buf = br.readLine();
			}

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

}
