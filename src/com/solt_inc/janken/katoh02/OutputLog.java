package com.solt_inc.janken.katoh02;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class OutputLog {

	//-----------------------------------------------------
	//　ログ出力
	//-----------------------------------------------------
	public void Output_Result(ArrayList<Integer> IResultPoint){
		try{

			File file = new File("log.txt");
			CheckFile checkfile = new CheckFile();

			//パスの取得
			String path = file.getAbsolutePath();

			//ログ出力
			if (checkfile.checkBeforeWritefile(file)){

				BufferedWriter filewriter = new BufferedWriter(new FileWriter(file));

				//結果格納
				for(int count = 0; count < 5; count++){
					filewriter.write(String.valueOf(IResultPoint.get(count)));
					filewriter.newLine();
				}

				filewriter.close();

				//出力先を記載する。
				System.out.println("Path:" + path + "に実績を出力しました。");

			}else{
				System.out.println("ファイルに書き込めません");
			}
		}catch(IOException e){
			System.out.println(e);
		}

	}

}
