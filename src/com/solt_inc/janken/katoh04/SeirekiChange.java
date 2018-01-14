package com.solt_inc.janken.katoh04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;

public class SeirekiChange {

	//西暦変換ツール　メイン処理
	public void SeirekiChange_Main(){

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		String sDay[];
		String buf = "";

		while(true){

			try {
				//年月日の入力
				System.out.println("=======================================");
				System.out.println("◆西暦→和暦変換ツール");
				System.out.println("西暦：(yyyy/mm/dd　形式 月と日は1桁入力可能)");
				System.out.print("年月日を入力してください：");
				buf = br.readLine();
				System.out.println("=======================================");
				System.out.println(buf);

				//終了
				if ("9".equals(buf)){
					System.out.println("西暦→和暦変換ツールを終了します。");
					break;
				}

				SeirekiConversion SeirekiConversion = new SeirekiConversion();

				//正常の場合、西暦変換（正規表現）
				if(SeirekiConversion.CheckDay(buf)){
					//西暦変換
					//文字を分割する。	Spilit
					sDay = buf.split("/",0);

					//文字列を日付に変換する
					LocalDateTime d1 = LocalDateTime.of(Integer.parseInt(sDay[0]), Integer.parseInt(sDay[1]), Integer.parseInt(sDay[2]), 0, 0, 0);

					//西暦変換する。
					System.out.println(SeirekiConversion.DayConversionMain(d1));

				} else {
					//エラー
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
