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
				System.out.println("相手の手はグーです。");
				break;
			case 1:
				System.out.println("相手の手はチョキです。");
				break;
			case 2:
				System.out.println("相手の手はパーです。");
				break;
			default:
				System.out.println("相手の手は不正です。");
		}

		return ran;

	}
}
