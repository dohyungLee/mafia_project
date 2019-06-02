package mafia_project;

import java.util.Scanner;

import mafia_project.*;
import java.util.Scanner;

public class citizen {
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
			else {
				chairman.player[votenumber-1][3] ++;//투표
				break;
			}
		}
	}

}
