package com.solt_inc.janken.katoh02;

public class History {

	public void History_result(int[] IResultPoint){

		System.out.println("");
		System.out.println("=======================================");
		System.out.println("◇過去の実績");
		System.out.println("勝ち数："+ IResultPoint[0]);
		System.out.println("対戦数："+ IResultPoint[1]);
		System.out.println("グーを出した数："+ IResultPoint[2]);
		System.out.println("チョキを出した数："+ IResultPoint[3]);
		System.out.println("パーを出した数："+ IResultPoint[4]);
		System.out.println("=======================================");
		System.out.println("");
	}
}
