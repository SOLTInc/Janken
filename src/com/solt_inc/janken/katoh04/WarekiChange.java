package com.solt_inc.janken.katoh04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WarekiChange {

	//和暦変換ツール　メイン処理
	public void WarekiChange_Main(){

		//年月日の入力
		System.out.println("=======================================");
		System.out.println("◆和暦→西暦変換ツール");
		System.out.println("和暦の場合：(〇〇yy年mm月dd日　形式 月と日は1桁入力可能)");
		System.out.print("年月日を入力してください：");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		String sDay[];
		String buf = "";
		String sWareki;
		Integer iWareki;

		try {

			buf = br.readLine();
			System.out.println("=======================================");
			System.out.println(buf);

			while(true){

				if ("9".equals(buf)){
					System.out.println("西暦→和暦変換ツールを終了します。");
					break;
				}

				WarekiConversion WarekiConversion = new WarekiConversion();

				//正常の場合、西暦変換（正規表現）
				if(WarekiConversion.CheckDay(buf)){
					//和暦変換

					sWareki = buf;
					iWareki = WarekiConversion.WarekiCheck(sWareki);//和暦を数値で取得する
					sWareki = WarekiConversion.WarekiConversionMain(sWareki);//和暦を日付に変換する

					//正しい日付かチェックする。
					if(WarekiConversion.checkDate(sWareki)) {
						//存在する和暦か判定する
						if(WarekiConversion.WarekiExistenceCheck(sWareki,iWareki) == true){
							//変換した和暦を表示します。
							System.out.println(sWareki);
						}
						else {
							System.out.println("正しい和暦ではありません。");
						}
					}
					else{
						System.out.println("正しい日付ではありません。");
					}
				} else {
					//エラー
					System.out.println("入力規則に違反しました。");
				}

				System.out.println("");
				System.out.println("=======================================");
				System.out.println("◆西暦→和暦変換ツール");
				System.out.println("西暦：(yyyy/mm/dd　形式 月と日は1桁入力可能)");
				System.out.print("年月日を入力してください：");
				buf = br.readLine();
				System.out.println("=======================================");
				System.out.println(buf);

			}

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
