package com.solt_inc.janken.katoh02;

import java.util.ArrayList;

public class History {

	public void History_result(ArrayList<Integer> IResultPoint){

		System.out.println("");
		System.out.println("=======================================");
		System.out.println("◇過去の実績");
		System.out.println("勝ち数："+ IResultPoint.get(0));
		System.out.println("対戦数："+ IResultPoint.get(1));
		System.out.println("グーを出した数："+ IResultPoint.get(2));
		System.out.println("チョキを出した数："+ IResultPoint.get(3));
		System.out.println("パーを出した数："+ IResultPoint.get(4));
		System.out.println("=======================================");
		System.out.println("");
	}
}
