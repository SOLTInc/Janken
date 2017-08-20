package com.solt_inc.janken.katoh02;

import java.io.File;
import java.io.IOException;

public class CheckFile {

	//-----------------------------------------------------
	//　ファイルの存在チェック
	//-----------------------------------------------------
	public boolean checkBeforeWritefile(File file){
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
