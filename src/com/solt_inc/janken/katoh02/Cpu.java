package com.solt_inc.janken2.katoh;

import java.util.Random;

public class Cpu {

	public Integer Cpu_Hand() {
		//CPUが出す役 乱数入力
		Random rnd = new Random();

		//相手の役を設定する
		int ran = rnd.nextInt(3);

		switch (ran){
			case 0:
				System.out.print("相手の手はグーです。\r\n");
				break;
			case 1:
				System.out.print("相手の手はチョキです。\r\n");
				break;
			case 2:
				System.out.print("相手の手はパーです。\r\n");
				break;
			default:
				System.out.print("相手の手は不正です。\r\n");
		}

		return ran;

	}
}
