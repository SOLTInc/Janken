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
		System.out.print("年月日を入力してください(yyyy/mm/dd形式 月と日は1桁入力可能)：");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		String buf = "";
		try {

			//入力
			buf = br.readLine();
			System.out.println(buf);

			while(true){
				//正常の場合、西暦変換（正規表現）
				if(Check.CheckDay(buf)){

		            //文字を分割する。	Spilit
					String sDay[] = buf.split("/",0);

					//文字列を日付に変換する
		            LocalDateTime d1 = LocalDateTime.of(Integer.parseInt(sDay[0]), Integer.parseInt(sDay[1]), Integer.parseInt(sDay[2]), 0, 0, 0);

					//西暦変換する。
		            System.out.println(DayConversion.DayConversionMain(d1));

					break;
				}
				else {

					System.out.println("入力規則に違反しました。");
					System.out.print("年月日を入力してください(yyyy/mm/dd形式 月と日は1桁入力可能)：");
					buf = br.readLine();
					System.out.println(buf);

					//不可の場合、再入力
				}
			}


		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}


}
