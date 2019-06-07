package mafia_project;

import java.util.Random;
import java.util.Scanner;

import mafia_project.*;
import java.util.Scanner;

public class citizen {
	
	public void randomvote() {
		Random randomvt = new Random();
		int comvote;
		
		for(int k = 0; k < 5; k++) {
			chairman.player[k][3] = 0;
		}

		for(int j=0; j < 2; j++) {
			for(int i = 0; i < 4; i++) {
				if(chairman.player[i][1] == 1) {
					comvote = randomvt.nextInt(5);//랜덤 투표
					
					while(true) {
						if(chairman.player[comvote][1] == 0) {
							comvote = randomvt.nextInt(5);//랜덤 투표
						}
						else if(chairman.player[comvote][1] == 1)
							break;
					}
					chairman.player[comvote][3] ++;
				}
			}
		}
	}
	
	public void vote() {
		Scanner input = new Scanner(System.in);
		int votenumber = 0;
		
		System.out.println("투표하세요.");
		votenumber = input.nextInt();
		
		while(true) {
			if(votenumber == chairman.playnum) {
				System.out.println("본인은 투표할 수 없습니다.");
				votenumber = input.nextInt();
			}
			else if(votenumber > 5 || votenumber < 0) {
				System.out.println("존재하지 않는 플레이어 입니다.");
				votenumber = input.nextInt();
			}
			else if(chairman.player[votenumber-1][1] == 0) {
				System.out.println("이미 죽은 플레이어 입니다.");
				System.out.println("다시 투표해 주세요.");
				votenumber = input.nextInt();
			}
			else {
				chairman.player[votenumber-1][3] ++;//투표
				break;
			}
		}
	}

}
