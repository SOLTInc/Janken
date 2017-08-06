package com.solt_inc.janken2.katoh;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Result {

	public void Jude_Result(int te,int ran ,int IvictoryPoint){

		//判定＆結果を出す
		//役を判定する
		//こちらグー　相手：チョキ
		if(te == 0 && ran == 1){
			System.out.println("あなたの勝ちです。");
			IvictoryPoint = IvictoryPoint + 1;
		//チョキ　パー
		} else if (te == 1 && ran == 2){
			System.out.println("あなたの勝ちです。");
			IvictoryPoint = IvictoryPoint + 1;
		//パー　グー
		}else if (te == 2 && ran == 0 ){
			System.out.println("あなたの勝ちです。");
			IvictoryPoint = IvictoryPoint + 1;
		//引き分け
		}else if (te == ran){
			System.out.println("引き分けです。");
		//負け
		}else{
			System.out.println("あなたの負けです。");
		}

		//ファイルの読み書き
		Input_Result(IvictoryPoint);

	}

	public void Input_Result(int IvictoryPoint){
		try{

		      File file = new File("log.txt");

		      if (checkBeforeWritefile(file)){
		        FileWriter filewriter = new FileWriter(file);

		        filewriter.write(String.valueOf(IvictoryPoint));

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
