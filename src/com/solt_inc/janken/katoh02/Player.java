package com.solt_inc.janken.katoh02;

public class Player {

	//-----------------------------------------------------
	//　プレイヤーの手の設定
	//-----------------------------------------------------
	public Integer Player_Hand(String buf) {

		int te;

		if ("0".equals(buf) || "1".equals(buf) || "2".equals(buf)){
			te = Integer.parseInt(buf);
		}else {
			te = 3; //後だしということで不戦勝
		}

		System.out.println("");
		System.out.println("◆結果");

		switch (te){
		case 0:
			// te = 0;
			System.out.println("あなたの手はグーです。");
			break;
		case 1:
			// te = 1;
			System.out.println("あなたの手はチョキです。");
			break;
		case 2:
			// te = 2;
			System.out.println("あなたの手はパーです。");
			break;
		default:
			// te = 3;
			System.out.println("あなたの手は不正です。");
		}
		return te;

	}
}
