package com.solt_inc.janken.sasaki;

public class StatCheak {

    public Boolean cardCheck(int gooCount, int chokieCount, int parCount, int starCount) {

        boolean gooFlag;
        boolean chokieFlag;
        boolean parFlag;
        boolean starFlag;
        boolean statFlag;

        gooFlag = true;
        chokieFlag = true;
        parFlag = true;
        starFlag = true;
        statFlag = true;


        if(gooCount == 0){
        	gooFlag = false;
        }
        if(chokieCount == 0){
        	chokieFlag = false;
        }
        if(parCount == 0){
        	parFlag = false;
        }
        if(starCount >= 3){
        	starFlag = false;
        }

        if(gooFlag == true && chokieFlag == true && parFlag == true && starFlag == true ){
        	statFlag = false;
        }

        return statFlag;
    }


}
