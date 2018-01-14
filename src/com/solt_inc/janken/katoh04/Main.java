package com.solt_inc.janken.katoh04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) {

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		String buf = "";

		while(true){

			try {

				//年月日の入力
				System.out.println("=======================================");
				System.out.println("西暦→和暦変換ツール：1");
				System.out.println("和暦→西暦変換ツール：2");
				System.out.println("終了します：9");
				System.out.print("入力してください。:");

				//入力
				buf = br.readLine();
				System.out.println("=======================================");
				System.out.println(buf);

				switch(buf){
				case "1":
					//西暦→和暦変換ツール
					System.out.println("西暦→和暦変換ツール");
					SeirekiChange SeirekiChange = new SeirekiChange();
					SeirekiChange.SeirekiChange_Main();
					break;
				case "2":
					//和暦→西暦変換ツール
					System.out.println("和暦→西暦変換ツール");
					WarekiChange WarekiChange = new WarekiChange();
					WarekiChange.WarekiChange_Main();
					break;
				case "9":
					//終了
					System.out.println("終了します。お疲れ様でした。");
					System.exit(0);
					break;

				default:

					throw new MissInputException("入力ミスです。もう一度入力してください。");
				}

				System.out.println("");

			} catch (MissInputException e) {
				System.out.println(e);

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}

}
