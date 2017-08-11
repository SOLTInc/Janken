package com.solt_inc.janken.katoh02;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OutputLog {

	//-----------------------------------------------------
	//　ログ出力
	//-----------------------------------------------------
	public void Input_Result(int[] IResultPoint){
		try{

		      File file = new File("log.txt");

		      //相対パスの取得
		      String path = file.getAbsolutePath();

		      //ログ出力
		      if (checkBeforeWritefile(file)){

		    	BufferedWriter filewriter = new BufferedWriter(new FileWriter(file));

		    	//結果格納
		    	for(int count = 0; count < 5; count++){
			        filewriter.write(String.valueOf(IResultPoint[count]));
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

	//-----------------------------------------------------
	//　ファイルの存在チェック
	//-----------------------------------------------------
	private static boolean checkBeforeWritefile(File file){
		    if (file.exists()){
		      if (file.isFile() && file.canWrite()){
		        return true;
		      }
		    } else {
		    	try {
					file.createNewFile();
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
		    }
		    return false;
	}
}
