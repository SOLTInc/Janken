package com.solt_inc.janken.katoh02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InputLog {

	//-----------------------------------------------------
	//　ログ出力
	//-----------------------------------------------------
	public void Input_Result(int[] IResultPoint){

		try{

		int i = 0;

		File file = new File("log.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));

		if (checkBeforeWritefile(file)){

			String str = br.readLine();

			  while(str != null){

			    IResultPoint[i] = Integer.parseInt(str);
			    i = i + 1;
			    str = br.readLine();
			  }

		}else{
			//過去の実績全てに0を格納する。
      		IResultPoint[0] = 0;
      		IResultPoint[1] = 0;
      		IResultPoint[2] = 0;
      		IResultPoint[3] = 0;
      		IResultPoint[4] = 0;
		}

		br.close();

		}catch(FileNotFoundException e){
				System.out.println(e);
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


