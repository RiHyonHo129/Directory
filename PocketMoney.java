package Experiment;

import java.awt.EventQueue;

/*
 * There is one 50 yuan, one 20 yuan, one 10 yuan, 
 * two 5 yuan bills and three 1 yuan coins in your pocket.
 *  Write a program to find out whether you can take out a given number (x) yuan.
 */

public class PocketMoney {

	int [] pocketMoney;
	int [] canFind;
	int totalNum = 0;
	
	PocketMoney() {
		pocketMoney = new int [8];
		pocketMoney[0] = 50;
		pocketMoney[1] = 20;
		pocketMoney[2] = 10;
		pocketMoney[3] = 5;
		pocketMoney[4] = 5;
		pocketMoney[5] = 1;
		pocketMoney[6] = 1;
		pocketMoney[7] = 1;
		
		for(int i = 0 ; i < pocketMoney.length ; i++) {
			totalNum += pocketMoney[i];
		}
		
		DP();
	}
	
	void DP() {
		int maxNum = 0;
		
		canFind = new int [totalNum + 1];
		canFind[0] = 1;
		
		for(int i = 0 ; i < pocketMoney.length ; i++)
			for(int j = maxNum ; j >= 0 ; j--)
				if(canFind[j] == 1) {
					canFind[j + pocketMoney[i]] = 1;
					if(maxNum < j + pocketMoney[i])
						maxNum = j + pocketMoney[i];
				}
	}
	
	int calc(int num) {
		if(totalNum < num)
			return 0;
		return canFind[num];
	}
	
}
