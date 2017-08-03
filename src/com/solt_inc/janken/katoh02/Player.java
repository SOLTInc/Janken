package com.solt_inc.janken2.katoh;

public class Player {

	public Integer Player_Hand(String buf) {

		int te;

		if (buf.equals("0") || buf.equals("1") || buf.equals("2")){
  				te = Integer.parseInt(buf);
  			}else {
  				te = 3; //後だしということで不戦勝
  			}

  			switch (te){
  				case 0:
  					// te = 0;
  					System.out.print("あなたの手はグーです。\r\n");
  					break;
  				case 1:
  					// te = 1;
  					System.out.print("あなたの手はチョキです。\r\n");
  					break;
  				case 2:
  					// te = 2;
  					System.out.print("あなたの手はパーです。\r\n");
  					break;
  				default:
  					// te = 3;
  					System.out.print("あなたの手は不正です。\r\n");
  			}
		return te;

	}
}
