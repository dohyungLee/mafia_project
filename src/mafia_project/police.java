package mafia_project;

import mafia_project.*;
import java.util.Scanner;

public class police {
	public void investigation() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("정체를 알고 싶은 플레이어를 선택하세요.");
		int suspect = scan.nextInt();
		
			if(chairman.player[suspect-1][1] != 0) {
				switch(chairman.player[suspect-1][0]) {
					case 1:
						System.out.println("지목한 플레이어는 마피아 입니다.");
						break;
					case 3:
						System.out.println("지목한 플레이어는 의사 입니다.");
						break;
					default:
						System.out.println("지목한 플레이어는 시민입니다.");
						break;	
				}
			}
			else {
				System.out.println("지목한 플레이어는 이미 죽었습니다.");
				suspect = scan.nextInt();
			}
	}

}
