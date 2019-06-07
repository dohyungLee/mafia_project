package mafia_project;

import mafia_project.*;
import java.util.Scanner;
import java.util.Random;

public class chairman {
	public static int playnum = 0, errorcode = 0, countday = 1, countnight = 1, countturn = 0;
	public static int [][] player = new int [5][5];
	
	/*1열은 직업, 2열은 생존여부, 3열은 플레이어 컴퓨터 여부, 4열은 투표, 5열은 마피아가 찍은 사람*/
	//마피아는 5열의 초기화 필수. 계속 죽일수 있기때문?
	//투표는 컴퓨터는 2표씩 주었음. 그냥 표가 너무 적어서.
	
	
	public void delay1() {
		try {
			Thread.sleep(1000);
		} 
		catch (InterruptedException e) {
			System.out.println(e.getMessage());    //sleep 메소드가 발생시키는 InterruptedException
		}
	}
	
	public void delay2() {
		try {
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) {
			System.out.println(e.getMessage());    //sleep 메소드가 발생시키는 InterruptedException
		}
	}
	
	public void playerdeath() {
		murderer Serialmurder = new murderer();
		chairman Delay = new chairman();
		
		for(int i = 0; i < 5; i++) {
			if(player[i][2] == 1 && player[i][1] == 0) {
				
				Serialmurder.serialmurder();
				
				System.out.println("당신은 컴퓨터에게 패배했습니다.");
				Delay.delay2();
				System.out.println("게임이 종료되었습니다.");
				System.exit(0);
			}
		}
	}
	
	/*public void playerwin() {
		chairman Error = new chairman();
		
		for(int i = 0; i < 5; i++) {
			if(player[i])
		}
	}*/
	
	public void deathcheck() {
		for(int i = 0; i < 5; i++) {
			if(player[i][4] == 0 && player[i][1] == 1) {
				player[i][1] = 0;
				
			System.out.println((i+1) + "번 플레이어가 마피아의 손에 살해당했습니다.");
			}
		}
	}
	
	public void revote() {
		citizen Vote = new citizen();
		citizen Randomvote = new citizen();
		
		System.out.println("\n재투표 하겠습니다.\n");
		Randomvote.randomvote();
		
		System.out.println("컴퓨터의 투표결과");
		for(int i = 0; i < 5; i++)
			System.out.println("플레이어 "+ (i+1) +" 의 득표 : " + player[i][3]);
		
		System.out.println(" ");
		
		Vote.vote();
		
		System.out.println("\n최종 투표결과");
		for(int i = 0; i < 5; i++)
			System.out.println("플레이어 "+ (i+1) +" 의 득표 : " + player[i][3]);
	}
	
	public void execution(){
		int whoM = 0;
		chairman Revote = new chairman();
			for(int i = 0; i < 4; i++) { // 사형 집행
				if(player[whoM][3] < player[i+1][3]) // 최대값 구하기
					whoM = i+1;
			}
		
			/*for(int j = 0; j < 4; j++) { //최댓값 중복시 재투표
				if(player[whoM][3] == player[j][3]) {
					Revote.revote();
					break;
				}
			}*/
		System.out.println("\n투표 결과");
		System.out.println("플레이어"+ (whoM+1) + " : 사형\n");
		
		player[whoM][1] = 0;
		
		for(int k = 0; k < 5; k++) {
			player[k][3] = 0;
		}
	}
	
	public void night() {
		doctor Heal = new doctor();
		mafia Kill = new mafia();
		chairman Deathcheck = new chairman();
		chairman Playerdeath = new chairman();
		police Investigation = new police();
		chairman Check  = new chairman();
		
		System.out.println(countnight + " 번째 밤이 되었습니다.\n");
		
		if(player[playnum-1][2] == 1) { //사람일때
			switch(player[playnum-1][0]) {
			case 1:
				//마피아 밤 행동 영역
				Kill.kill();
				Heal.randomheal();
				break;
				
			case 2:
				//경찰 밤 행동 영역
				Investigation.investigation();
				Kill.randomkill();
				Heal.randomheal();
				break;
				
			case 3:
				//의사 밤 행동 영역
				Kill.randomkill();
				Heal.heal();
				break;
				
			default : 
				Kill.randomkill();
				Heal.randomheal();
				
			}
		}
		countnight++;
		
		Deathcheck.deathcheck();
		Playerdeath.playerdeath();
	}
	
	public void day() {
		citizen Vote = new citizen();
		chairman Execution = new chairman();
		citizen Randomvote = new citizen();
		chairman Check = new chairman();
		chairman Playerdeath = new chairman();
		
		System.out.println(countday + " 번째 낮이 되었습니다.\n");
		
		Randomvote.randomvote();
		
		System.out.println("컴퓨터의 투표결과");
		for(int i = 0; i < 5; i++)
			System.out.println("플레이어 "+ (i+1) +" 의 득표 :" + " " + player[i][3]);
		
		System.out.println(" ");
		
		Vote.vote();
		
		System.out.println("\n최종 투표결과");
		for(int i = 0; i < 5; i++)
			System.out.println("플레이어 "+ (i+1) +" 의 득표 : " + player[i][3]);
		
		Execution.execution();
		
		countday++;
		
		Playerdeath.playerdeath();
	}
	
	public void check() {
		for(int i = 0; i < player.length; i++) {
			for(int j = 0; j < player[i].length; j++) {
				System.out.print(player[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		
		int votenum = 0;
		
		chairman Randomvote = new chairman();
		chairman Day = new chairman();
		chairman Night = new chairman();
		chairman Check = new chairman();
		chairman Execution =  new chairman();
		chairman Playerdeath = new chairman();
		chairman Delay = new chairman();
		murderer News = new murderer();
		
		
		for(int i = 0; i < player.length; i++) {
			for(int j = 0; j < player[i].length; j++) {
				player[i][j] = 0; //배열 초기화
			}
		}
		
		for(int i = 0; i < 5; i++) {
			player[i][0] = random.nextInt(5)+1;//랜덤초기화, 직업배정
			
			for(int j=0;j < i;j++){
				if(player[i][0] == player[j][0]) // 중복제거
                    i--;
            }	
		}
		
		Check.check();
		
		System.out.println("1~5 중에서 자신의 플레이어 번호를 설정해주세요.");
		
		playnum = scan.nextInt();
		
		while(true) {
			if(playnum > 5) {
				System.out.println("다시 입력해주세요");
				playnum = scan.nextInt();

			}
			else {
				Delay.delay2();
				System.out.println("자신의 플레이어 번호는 " + playnum + " 번 입니다.\n");
				break;
			}
		}
		
		for(int i = 0; i < 5; i++) {
			if(i == playnum-1) {
				player[i][2] = 1;//플레이어인지 컴퓨터인지 구별
				i++;
			}
			else
				player[i][2] = 0;
		}
		
		switch(player[playnum-1][0]) {
		case 1:
			System.out.println("당신은 마피아 입니다.\n");
			break;
		case 2:
			System.out.println("당신은 경찰 입니다.\n");
			break;
		case 3:
			System.out.println("당신은 의사 입니다.\n");
			break;
		case 4:
			System.out.println("당신은 시민1 입니다.\n");
			break;
		case 5:
			System.out.println("당신은 시민2 입니다.\n");
			break;
		}
		
		for(int i = 0; i < 5; i++) {
			player[i][1] = 1; // 모든사람 생존 초기화
			player[i][4] = 1;
		}	
		
		while(true) {
			Playerdeath.playerdeath();
			
			if(countturn == 1) {
				News.news();
			}
				
			Night.night();
			Playerdeath.playerdeath();
			
			System.out.println(" ");
			Delay.delay2();
			
			Day.day();
			Delay.delay2();
			
			countturn ++;
			Playerdeath.playerdeath();
			
			Check.check();
			
			Delay.delay2();
			
		}	
	}
}
	
