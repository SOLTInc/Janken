package com.solt_inc.janken.kida.top;

import com.solt_inc.janken.kida.base.BaseService;
import com.solt_inc.janken.kida.common.Util;
import com.solt_inc.janken.kida.data.Db;
import com.solt_inc.janken.kida.jyanken.Jyanken;
import com.solt_inc.janken.kida.slot.Slot;



public class Menu {

	public static void main(String[] args) {

		Db db = new Db();
		db.get();

		dispMenu();

		Util utl = new Util();
		Secret sc = new Secret();

		while(true){

			String str = utl.getInput();
			int num = utl.exchangeInt(str);

			switch(num){

			case 1:
				BaseService j = new Jyanken();
				j.execute("ジャンケン");
				sc.clear();
				break;

			case 2:
				BaseService s = new Slot();
				s.execute("スロット");
				sc.clear();
				break;

			case 99:
				System.out.println("アプリを終了します");
				System.exit(0);
				break;

			default:

				if(sc.isDataClear(num)){
					sc.dataDelete();
					db.get();
					dispMenu();
					break;
				}
				System.out.println("もう一度入力して下さい");
				System.out.println("1:じゃんけん  2:スロット  99:終了");
				break;

			}
		}
	}

	protected static void dispMenu(){
		System.out.println("メニュー番号を入力して下さい");
		System.out.println("1:じゃんけん  2:スロット  99:終了");


	}

}
