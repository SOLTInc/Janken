package com.solt_inc.janken2.katoh;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OutputLog {

	public void Input_Result(int[] IResultPoint){
		try{

		      File file = new File("log.txt");

		      if (checkBeforeWritefile(file)){

		    	BufferedWriter filewriter = new BufferedWriter(new FileWriter(file));

		    	//結果格納
		    	for(int count = 0; count < 5; count++){
			        filewriter.write(String.valueOf(IResultPoint[count]));
			        filewriter.newLine();
		    	}

		        filewriter.close();

		      }else{
		        System.out.println("ファイルに書き込めません");
		      }
		    }catch(IOException e){
		      System.out.println(e);
		    }

	}

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
