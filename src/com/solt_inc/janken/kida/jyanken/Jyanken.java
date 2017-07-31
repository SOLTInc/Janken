package com.solt_inc.janken.kida.jyanken;

import com.solt_inc.janken.kida.base.BaseService;
import com.solt_inc.janken.kida.common.Util;
import com.solt_inc.janken.kida.data.Bean;

public class Jyanken extends BaseService {

	Util utl;
	JyankenUtil jutl;

	protected void init(){
		utl = new Util();
		jutl = new JyankenUtil();
	}

	@Override
	public boolean body() {

		System.out.println("ジャンケン・・・");
		System.out.println("1:グー  2:チョキ  3:パー  98:勝敗の記録  99:終了");

			int hand = 0;
			boolean chkflg = true;
			while(chkflg){

				String str = utl.getInput();
				int num = utl.exchangeInt(str);

				if (num == 99 ) {
					System.out.println("ジャンケンを終了します");
					return false;
				}

				// 入力値を判定
				hand = jutl.chkJyankenInput(str);
				if (hand != 0 && hand != 98) {
					chkflg = false;
				} else if (hand == 98) {
					record();
					System.out.println("");
					System.out.println("");
					System.out.println("ジャンケン・・・");
					System.out.println("1:グー  2:チョキ  3:パー  98:勝敗の記録  99:終了");
				} else {
					System.out.println("ジャンケン・・・（もう一回入力）");
					System.out.println("1:グー  2:チョキ  3:パー  98:勝敗の記録  99:終了");
				}
			}

			// COMの出す手
			int com = (int) (Math.random() * 3)+1; // 1から3までの乱数

			if((hand == 1 && com == 2) || (hand == 2 && com == 3) || (hand == 3 && com == 1)){

				System.out.println("あなた:"+jutl.exchangejyanken(hand)+"    COM:"+jutl.exchangejyanken(com));
				System.out.println("あなたの勝ち   スロット用コイン1枚獲得");
				System.out.println("");
				Bean.setjWin();
				Bean.coinPlus(1);

			}else if((hand == 1 && com == 3) || (hand == 2 && com == 1) || (hand == 3 && com == 2)){
				System.out.println("あなた:"+jutl.exchangejyanken(hand)+"    COM:"+jutl.exchangejyanken(com));
				System.out.println("あなたの負け");
				System.out.println("");
				Bean.setjLose();
			}else{
				System.out.println("あなた:"+jutl.exchangejyanken(hand)+"    COM:"+jutl.exchangejyanken(com));
				System.out.println("あいこ");
				System.out.println("");
				Bean.setjDraw();
			}
			return true;
	}

	private void record() {
		System.out.println("");
		System.out.println("勝敗の記録");
		System.out.println("-----------------------------");
		System.out.println("|       |  今回  |  累計  |  ");
		System.out.println("-----------------------------");
		System.out.println("|勝ち   | "+String.format("%6s", getKonkai(Bean.getjWin(), "jWin")) +" | " + String.format("%6s", Bean.getjWin()) +" |  ");
		System.out.println("-----------------------------");
		System.out.println("|負け   | "+String.format("%6s", getKonkai(Bean.getjLose(), "jLose")) +" | " + String.format("%6s", Bean.getjLose()) +" |  ");
		System.out.println("-----------------------------");
		System.out.println("|あいこ | "+String.format("%6s", getKonkai(Bean.getjDraw(), "jDraw")) +" | " + String.format("%6s", Bean.getjDraw()) +" |  ");
		System.out.println("-----------------------------");
	}

	private int getKonkai(int param, String keyName) {

		Util utl = new Util();
		int returnInt = param - utl.exchangeInt(Bean.getMap().get(keyName));

		return returnInt;
	}

}
