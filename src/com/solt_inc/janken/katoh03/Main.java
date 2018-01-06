package com.solt_inc.janken.katoh03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;

//------------------------------------------------------
//	和暦、西暦変換ツール
//------------------------------------------------------
public class Main {

	public static void main(String[] args) {

		//クラスの生成
		Check Check = new Check();
		DayConversion DayConversion = new DayConversion();

		//年月日の入力
		System.out.println("=======================================");
		System.out.println("◆西暦⇔和暦変換ツール");
		System.out.println("西暦の場合：(yyyy/mm/dd　形式 月と日は1桁入力可能)");
		System.out.println("和暦の場合：(〇〇yy年mm月dd日　形式 月と日は1桁入力可能)");
		System.out.print("年月日を入力してください：");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		String buf = "";
		String sWareki;
		String sDay[];
		Integer iWareki;

		try {

			//入力
			buf = br.readLine();
			System.out.println("=======================================");
			System.out.println(buf);

			while(true){

				if ("9".equals(buf)){
					System.out.println("終了します。おつかれさまでした。");
					break;
				}

				//正常の場合、西暦変換（正規表現）
				switch(Check.CheckDay(buf)){
				case 0:
					//エラー
					System.out.println("入力規則に違反しました。");
					break;
				case 1:
					//西暦変換
					//文字を分割する。	Spilit
					sDay = buf.split("/",0);

					//文字列を日付に変換する
		            LocalDateTime d1 = LocalDateTime.of(Integer.parseInt(sDay[0]), Integer.parseInt(sDay[1]), Integer.parseInt(sDay[2]), 0, 0, 0);

					//西暦変換する。
		            System.out.println(DayConversion.DayConversionMain(d1));
					break;

				case 2:
					//和暦変換

					sWareki = buf;

					iWareki = DayConversion.WarekiCheck(sWareki);//和暦を数値で取得する
					sWareki = DayConversion.WarekiConversionMain(sWareki);//和暦を日付に変換する

					//正しい日付かチェックする。
					if(Check.checkDate(sWareki)) {
						//存在する和暦か判定する
						if(DayConversion.WarekiExistenceCheck(sWareki,iWareki) == true){
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

					break;

				case 3:
					//和暦変換(元年)
					//和暦を日付に変換する
					sWareki = buf;
					sWareki = DayConversion.WarekigannenConversionMain(sWareki);

					//正しい日付かチェックする。
					if(Check.checkDate(sWareki)){
						//存在する和暦か判定する
						if(DayConversion.WarekigannenExistenceCheck(sWareki) == true){
							//変換した和暦を表示します。
							System.out.println(sWareki);
						}
						else{
							System.out.println("正しい和暦ではありません。");
						}
					}
					else {
						System.out.println("正しい日付ではありません。");
					}

					break;
				}

				System.out.println("");
				System.out.println("=======================================");
				System.out.println("◆西暦⇔和暦変換ツール");
				System.out.println("西暦の場合：(yyyy/mm/dd　形式 月と日は1桁入力可能)");
				System.out.println("和暦の場合：(〇〇yy年mm月dd日　形式 月と日は1桁入力可能)");
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
