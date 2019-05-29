package mafia_project;

import java.util.Scanner;
import java.util.Random;

class check_death{
	check_death(){
		
	}
}

class night{
	public night(){
		while(true) {
			System.out.println("밤이 되었습니다.");
			break;
		}
	}
}

public class doctor {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		
		int playnum;
		night ng = new night();
		
		System.out.println("1~5 중 플레이어의 번호를 지정해 주세요.");
		int [][] player = new int [5][3];
		
		playnum = scan.nextInt();
		while(true) {
			if(playnum > 5)
				System.out.println("다시 입력해주세요.");
			else {
				System.out.println("당신의 플레이어 번호는 " + playnum + "번 입니다.");
				break;
			}
		}
		for(int i = 0; i < 5; i++) {
			player[i][0] = random.nextInt(5)+1;
			
			for(int j=0;j < i;j++){
				if(player[i][0] == player[j][0])
                    i--;
            }	
		}
		
		//값 확인용...
		//for(int i = 0; i < 5; i++)
		//System.out.println("player["+i+"]"+"[0] 의 값 : " + player[i][0]);
		
		System.out.println("");
		
		switch(player[playnum][0]) {
		case 1:
			System.out.println("당신의 직업은 마피아 입니다.");
			break;
		case 2:
			System.out.println("당신의 직업은 경찰 입니다.");
			break;
		case 3:
			System.out.println("당신의 직업은 의사 입니다.");
			break;
		case 4:
			System.out.println("당신의 직업은 시민1 입니다.");
			break;
		case 5:
			System.out.println("당신의 직업은 시민2 입니다.");
			break;
		}
		
		System.out.println(" ");
		
		
	}
}
