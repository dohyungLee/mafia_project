package mafia_project;

import mafia_project.*;

import java.util.Random;
import java.util.Scanner;

public class doctor {

	public void heal() {
		Scanner input = new Scanner(System.in);
		chairman Delay = new chairman();
		
		int healnumber = 0;
		System.out.println("치료할 사람을 정하세요");
			healnumber = input.nextInt();
			
		while(true) {
			if(healnumber-1 > 4) {
				System.out.println("존재하지 않는 플레이어 입니다.");
				healnumber = input.nextInt();
			}
			else if(chairman.player[healnumber-1][1] == 0) {
				System.out.println("이미 죽은 플레이어 입니다.");
				healnumber = input.nextInt();
			}
		
			else if(chairman.player[healnumber-1][4] == 0){
				System.out.println("총에 맞은 " + (healnumber) + "번 플레이어를 살렸습니다.");
				chairman.player[healnumber-1][4] = 1; //치료
				Delay.delay2();
				break;
			}
			else {
				System.out.println("이미 살아있는 플레이어 입니다.");
				System.out.println("다시 선택해 주세요.");
				healnumber = input.nextInt();
			}
		}
	}

	public void randomheal() {
		Random randomhl = new Random();
		chairman Delay = new chairman();
		int comheal;
		
		comheal = randomhl.nextInt(5);//랜덤선택
		while(true) {
			if(chairman.player[comheal][1] == 1) {
				if(chairman.player[comheal][1] == 1 && chairman.player[comheal][4] == 0)
					System.out.println("의사가 총에 맞은 플레이어를 치료하였습니다.");
				
				chairman.player[comheal][4] = 1;
				
				Delay.delay2();
				break;
			}
			else if(chairman.player[comheal][4] == 1){
				comheal = randomhl.nextInt(5);//랜덤선택
			}
		}
	}
}
