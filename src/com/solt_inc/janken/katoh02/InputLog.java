package com.solt_inc.janken.katoh02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InputLog {

	//-----------------------------------------------------
	//　ログ出力
	//-----------------------------------------------------
	public void Input_Result(ArrayList<Integer> IResultPoint){

		try{
			File file = new File("log.txt");

			CheckFile checkfile = new CheckFile();

			if (checkfile.checkBeforeWritefile(file)){

				BufferedReader br = new BufferedReader(new FileReader(file));

				String str = br.readLine();

				while(str != null){

					IResultPoint.add(Integer.parseInt(str));
					str = br.readLine();
				}

				br.close();

			}else{
				//過去の実績全てに0を格納する。
				IResultPoint.add(0);
				IResultPoint.add(0);
				IResultPoint.add(0);
				IResultPoint.add(0);
				IResultPoint.add(0);
			}

		}catch(FileNotFoundException e){
			System.out.println(e);
		}catch(IOException e){
			System.out.println(e);
		}
	}


}


