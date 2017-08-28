package com.solt_inc.janken.katoh02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Past {

	//-----------------------------------------------------
	//　初期チェック
	//-----------------------------------------------------
	public void Input_Check(){

		File file = new File("past.txt");

		CheckFile checkfile = new CheckFile();

		if (checkfile.checkBeforeWritefile(file)){

		}else{

		}

	}

	//-----------------------------------------------------
	//　結果入力
	//-----------------------------------------------------
	public void Input_Past(){

		try{

			File file = new File("past.txt");

			CheckFile checkfile = new CheckFile();

			if (checkfile.checkBeforeWritefile(file)){

				BufferedReader br = new BufferedReader(new FileReader(file));

				String str = br.readLine();

				System.out.println("");
				System.out.println("=======================================");
				System.out.println("◇過去の結果");

				while(str != null){

					System.out.println(str);
					str = br.readLine();

				}

				System.out.println("=======================================");
				System.out.println("");

				br.close();

			}else{
				System.out.println("");
				System.out.println("=======================================");
				System.out.println("◇過去の結果");
				System.out.println("=======================================");
				System.out.println("");
			}

		}catch(FileNotFoundException e){
			System.out.println(e);
		}catch(IOException e){
			System.out.println(e);
		}
	}
	//-----------------------------------------------------
	//　結果出力
	//-----------------------------------------------------
	public void Output_Past(int[] IResultPoint,int te,int ran,int result){
		try{

			File file = new File("past.txt");
			CheckFile checkfile = new CheckFile();

			//パスの取得
			String path = file.getAbsolutePath();

			//ログ出力
			if (checkfile.checkBeforeWritefile(file)){

				BufferedWriter filewriter = new BufferedWriter(new FileWriter(file,true));

				filewriter.write(Output_Text(IResultPoint,te,ran,result));

				filewriter.newLine();

				filewriter.close();

			}else{
				System.out.println("ファイルに書き込めませんでした。");
			}
		}catch(IOException e){
			System.out.println(e);
		}

	}


	//-----------------------------------------------------
	//　結果テキスト
	//-----------------------------------------------------
	private String Output_Text(int[] IResultPoint,int te,int ran,int result){

		String paststr;

		//回数
		paststr = String.valueOf(IResultPoint[1]) + "回目";

		//日付
		Date nowDate1 = new Date();
		SimpleDateFormat f = new SimpleDateFormat("yyyy:MM/dd HH:mm:ss");

		paststr = paststr + "(" + f.format(nowDate1) + ")";

		//自分の手
		switch (te){
		case 0:
			// te = 0;
			paststr = paststr + "\tあなた：グー\t";
			break;
		case 1:
			// te = 1;
			paststr = paststr + "\tあなた：チョキ\t";
			break;
		case 2:
			// te = 2;
			paststr = paststr + "\tあなた：パー\t";
			break;
		default:
			// te = 3;
			paststr = paststr + "\tあなた：不正\t";
		}

		//相手の手
		switch (ran){
		case 0:
			// ran = 0;
			paststr = paststr + "相手：グー\t";
			break;
		case 1:
			// ran = 1;
			paststr = paststr + "相手：チョキ\t";
			break;
		case 2:
			// ran = 2;
			paststr = paststr + "相手：パー\t";
			break;
		default:
			// ran = 3;
			paststr = paststr + "相手：不正\t";
		}

		//結果
		//相手の手
		switch (result){
		case -1:
			// result = -1;
			paststr = paststr + "結果：負け";
			break;
		case 0:
			// result = 0;
			paststr = paststr + "結果：引き分け";
			break;
		case 1:
			// result = 1;
			paststr = paststr + "相手：勝ち";
			break;
		}
		return paststr;
	}


}
