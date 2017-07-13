package com.solt_inc.janken.kida.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Db {

	@SuppressWarnings("resource")
	public Map<String, String> get() {

		File file = new File("datafile");

		// データファイル存在チェック
		// 相対パス指定でファイルが存在しない場合、ファイルを作成する
		if (file.exists()) {
			// ok
		} else {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// ファイルを読み込み、mapに格納する
		BufferedReader br = null;
		HashMap<String, String> map = new HashMap<String, String>();

		String str;
		String[] strList = null;

		try {
			br = new BufferedReader(new FileReader(file));
			while ((str = br.readLine()) != null) {
				strList = str.split(":");
				map.put(strList[0], strList[1]);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Bean.setMap(map);

		return map;
	}

	public void saveData() {
		File file = new File("datafile");
		try {
			file.createNewFile();
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(
					file)));
			ArrayList<String> lst = Bean.getSaveData();
			for (int i = 0; i < lst.size(); i++) {
				pw.println((String) lst.get(i));
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
