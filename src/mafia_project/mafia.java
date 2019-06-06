package mafia_project;

import java.util.Scanner;
import java.util.Random;
import mafia_project.*;

public class mafia {
	public void kill() {
		Scanner scan = new Scanner(System.in);
		int death;
		
		System.out.println("죽일 플레이어를 고르세요.");
		death = scan.nextInt();
		
		while(true) {
			if(chairman.player[death-1][1] == 1) {
				System.out.println(death + "번 플레이어를 총으로 쏘았습니다.\n");
				chairman.player[death-1][4] = 0;
				break;
			}
			
			else if(chairman.player[death-1][1] == 0){		
				System.out.println("이미 죽은 플레이어 입니다.");
				System.out.println("다시 선택하세요.");
				death = scan.nextInt();
			}
			
			else if(chairman.player[death-1][2] == 1) {
				System.out.println("자신을 선택 할 수 없습니다.");
				System.out.println("다시 선택하세요.");
				death = scan.nextInt();
			}
			
			else if(death < 1 || death > 5){
				System.out.println("잘못된 선택입니다.");
				System.out.println("다시선택하세요.");
				death = scan.nextInt();
			}
		}
	}
	
	public void randomkill() {			
		Random randomkl = new Random();
		int comkill;
			
		comkill = randomkl.nextInt(5);//랜덤선택
		while(true) {
			if(chairman.player[comkill][2] == 1 && chairman.player[comkill][4] == 1) {
				System.out.println("마피아가 총을 쏘았습니다.");
				chairman.player[comkill][4] = 0;
				break;
			}
			else if(chairman.player[comkill][1] == 0) {
				comkill = randomkl.nextInt(5);//랜덤선택
			}
		}
	}
}
