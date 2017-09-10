package com.solt_inc.janken.katoh03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//------------------------------------------------------
//	和暦、西暦変換ツール
//------------------------------------------------------
public class Main {

	public static void main(String[] args) {

		//年月日の入力
		System.out.print("年月日を入力してください：");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		String buf = "";

		try {

			buf = br.readLine();

			System.out.println(buf);

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}


}
