package mafia_project;

import mafia_project.*;
import java.util.Scanner;
import java.util.Random;

public class chairman {
	public static int playnum = 0, errorcode = 0, countday = 1, countnight = 1;
	public static int [][] player = new int [5][5];
	
	/*1열은 직업, 2열은 생존여부, 3열은 플레이어 컴퓨터 여부, 4열은 투표, 5열은 마피아가 찍은 사람*/
	//마피아는 5열의 초기화 필수. 계속 죽일수 있기때문?
	//투표는 컴퓨터는 2표씩 주었음. 그냥 표가 너무 적어서.
	
	
	public void randomvote() {
		Random randomvt = new Random();
		int comvote;
		
		for(int k = 0; k < 5; k++) {
			player[k][3] = 0;
		}

		for(int j=0; j < 2; j++) {
			for(int i = 0; i < 4; i++) {
				comvote = randomvt.nextInt(5);//랜덤 투표
				player[comvote][3] ++;
			}
		}
	}
	
	public void deathcheck() {
		for(int i = 0; i < 5; i++) {
			if(player[i][4] == 0) {
				player[i][1] = 0;
			}
		}
	}
	
	public void revote() {
		chairman Randomvote = new chairman();
		citizen Vote = new citizen();
		
		System.out.println("재투표 하겠습니다.\n");
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
		
		for(int i = 0; i < 4; i++) {
			if(player[whoM][3] < player[i+1][3])
				whoM = i+1;
		}
		System.out.println("\n투표 결과");
		System.out.println("플레이어"+ (whoM+1) + " : 사형\n");
		
		player[whoM][1] = 0;
	}
	
	public void night() {
		doctor Heal = new doctor();
		mafia Kill = new mafia();
		police Investigation = new police();
		
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
				Heal.heal();
				Kill.randomkill();
				break;
				
			}
		}
		countnight++;
	}
	
	public void day() {
		citizen Vote = new citizen();
		chairman Execution = new chairman();
		chairman Randomvote = new chairman();
		chairman Check = new chairman();
		
		System.out.println(countday + " 번째 낮이 되었습니다.\n");
		
		Randomvote.randomvote();
		
		System.out.println("컴퓨터의 투표결과");
		for(int i = 0; i < 5; i++)
			System.out.println("플레이어 "+ (i+1) +" 의 득표 :"
					+ " " + player[i][3]);
		
		System.out.println(" ");
		
		Vote.vote();
		
		System.out.println("\n최종 투표결과");
		for(int i = 0; i < 5; i++)
			System.out.println("플레이어 "+ (i+1) +" 의 득표 : " + player[i][3]);
		
		Execution.execution();
		
		Check.check();
		
		countday++;
	}
	
	public void check() {
		for(int i = 0; i < player.length; i++) {
			for(int j = 0; j < player[i].length; j++) {
				System.out.print(player[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	public void error() {
		System.out.println("Hello World!");
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
		chairman Error = new chairman();
		
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
		}	
		
		while(true) {
			Day.day();
			Night.night();
			
			Check.check();
			System.out.println(" ");
			
			//에러를 내고 싶을 땐 errorcode를 1로 설정
			
			if(errorcode == 1) {
				Error.error();
				break;
			}
		}	
	}
}
