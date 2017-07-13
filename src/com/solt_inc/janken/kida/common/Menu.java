package com.solt_inc.janken.kida.common;

import com.solt_inc.janken.kida.data.Db;
import com.solt_inc.janken.kida.jyanken.Jyanken;
import com.solt_inc.janken.kida.slot.Slot;

public class Menu {

	public static void main(String[] args) {

		Db db = new Db();
		db.get();

		System.out.println("メニュー番号を入力して下さい");
		System.out.println("1:じゃんけん  2:スロット  99:終了");

		boolean flg = true;
		Util utl = new Util();
		Secret sc = new Secret();

		while (flg) {

			String str = utl.getInput();
			int num = utl.exchangeInt(str);

			switch (num) {

			case 1:
				Jyanken j = new Jyanken();
				j.plsyJyanken();
				System.out.println("メニュー番号を入力して下さい");
				System.out.println("1:じゃんけん  2:スロット  99:終了");
				sc.clear();
				break;

			case 2:
				Slot s = new Slot();
				s.playSlot();
				System.out.println("メニュー番号を入力して下さい");
				System.out.println("1:じゃんけん  2:スロット  99:終了");
				sc.clear();
				break;

			case 99:
				System.out.println("アプリを終了します");
				System.exit(0);
				break;

			default:

				if (sc.isDataClear(num)) {
					sc.dataDelete();
					System.out.println("メニュー番号を入力して下さい");
					System.out.println("1:じゃんけん  2:スロット  99:終了");
					break;
				}
				System.out.println("もう一度入力して下さい");
				System.out.println("1:じゃんけん  2:スロット  99:終了");
				break;
			}
		}
	}

}
