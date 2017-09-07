package com.solt_inc.janken.katoh02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Past {

	//-----------------------------------------------------
	//　初期チェック
	//-----------------------------------------------------
	public void Input_Check(ArrayList<String> array){
		try{
			File file = new File("past.txt");

			CheckFile checkfile = new CheckFile();

			if (checkfile.checkBeforeWritefile(file)){

				BufferedReader br = new BufferedReader(new FileReader(file));

				String str = br.readLine();

				while(str != null){

					array.add(str);
					str = br.readLine();

				}

				br.close();

			} else {

			}

		} catch(FileNotFoundException e) {
			System.out.println(e);
		} catch(IOException e) {
			System.out.println(e);
		}
	}

	//-----------------------------------------------------
	//　結果入力
	//-----------------------------------------------------
	public void Input_Past(ArrayList<String> array){

		try{

			if (array.size() != 0){

				System.out.println("");
				System.out.println("=======================================");
				System.out.println("◇過去の結果");

				for(int i =0; i < array.size(); i++)
				{
					System.out.println(array.get(i));
				}

				System.out.println("=======================================");
				System.out.println("");

			}else{

				System.out.println("");
				System.out.println("=======================================");
				System.out.println("◇過去の結果");
				System.out.println("=======================================");
				System.out.println("");

			}

		} finally {

		}

	}

	//-----------------------------------------------------
	//　結果コメント格納
	//-----------------------------------------------------
	public void Output_Past_Comment(ArrayList<String> array){
		try{

			File file = new File("past.txt");
			CheckFile checkfile = new CheckFile();

			System.out.println("=======================================");
			System.out.print("追加する行を入力してください。：");

			//手の入力処理
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			String gyostr = "";
			int Count = 0;

			//行　入力処理
			gyostr = br.readLine();

			int gyo = Integer.parseInt(gyostr);

			System.out.print("追加するコメントを入力して下さい：");
			String comment = "";

			//コメント　入力処理
			comment = br.readLine();

			array.set(gyo -1,array.get(gyo -1) + "\t" + comment);

			//ファイルを保存する
			Past Past = new Past();
			Past.Output_Past(array);

		}catch(FileNotFoundException e){
			System.out.println(e);
		}catch(IOException e){
			System.out.println(e);
		}
	}

	//-----------------------------------------------------
	//　結果出力
	//-----------------------------------------------------
	public void Output_Past(ArrayList<String> array){

		try{


			File file = new File("past.txt");
			CheckFile checkfile = new CheckFile();

			//ログ出力
			if (checkfile.checkBeforeWritefile(file)){

				BufferedWriter filewriter = new BufferedWriter(new FileWriter(file));

				for (int i = 0; i< array.size(); i++){
					filewriter.write(array.get(i));
					filewriter.newLine();
				}

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
	public String Output_Text(int[] IResultPoint,int te,int ran,int result){

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
