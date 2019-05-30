package mafia_project;

import java.util.Scanner;
import java.util.Random;

public class doctor {
	
	public static int playnum;
	
	public static int [][] player = new int [5][5];
	
	/*1열은 직업, 2열은 생존여부, 3열은 플레이어 컴퓨터 여부, 4열은 투표, 5열은 마피아가 찍은 사람*/
	//마피아는 5열의 초기화 필수. 계속 죽일수 있기때문?
	//투표는 컴퓨터는 2표씩 주었음. 그냥 표가 너무 적어서.
	
//-------------------------------------------------------------------	
	public void heal(int healnumber) {
		Scanner input = new Scanner(System.in);
		
		while(true) {
			if(healnumber > 4) {
				System.out.println("존재하지 않는 플레이어 입니다.");
				healnumber = input.nextInt();
			}
			else if(player[healnumber][1] == 0) {
				System.out.println("이미 죽은 플레이어 입니다.");
				healnumber = input.nextInt();
			}
		
			else {
				player[healnumber][4] = 1; //치료
				break;
			}
		}
	}
	
	public void vote(int Votenumber) {
		player[Votenumber-1][3] ++;//투표
	}
	
	public void randomvote() {
		Random randomvt = new Random();
		
		int comvote;
		for(int j=0; j < 2; j++) {
			for(int i = 0; i < 4; i++) {
				comvote = randomvt.nextInt(5);//랜덤 투표
				player[comvote][3] ++;
			}
		}
	}
		
	public void check() {
		for(int i = 0; i < player.length; i++) {
			for(int j = 0; j < player[i].length; j++) {
				System.out.print(player[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
//----------------------------------------------------------------
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		
		int healnum, votenum;
		
		doctor Heal = new doctor(); //객체 선언?
		doctor Vote = new doctor();
		doctor Randomvote = new doctor();
		doctor Check = new doctor();
		
		for(int i = 0; i < player.length; i++) {
			for(int j = 0; j < player[i].length; j++) {
				player[i][j] = 0; //배열 초기화
			}
		}
		
		for(int i = 0; i < 5; i++) {
			player[i][0] = random.nextInt(5)+1;//랜덤초기화, 직업배정
			
			for(int j=0;j < i;j++){
				if(player[i][0] == player[j][0])
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
		
		
//----------------------------------------------------------------------------------------
		//값 확인용...
		/*for(int i = 0; i < player.length; i++) {
			for(int j = 0; j < player[i].length; j++) {
				System.out.print(player[i][j] + " ");
			}
			System.out.println("");
		}*/
		
//----------------------------------------------------------------------------------------
		
		if(player[playnum-1][0] == 3) {
			System.out.println("치료할 사람을 정하세요");
			healnum = scan.nextInt();
			
			Heal.heal(healnum-1);
		}

		System.out.println("");
		Randomvote.randomvote();
		
		System.out.println(" ");
		
		System.out.println("컴퓨터의 투표결과");
		for(int i = 0; i < 5; i++)
			System.out.println("플레이어 "+ (i+1) +" 의 득표 : " + player[i][3]);
		
		System.out.println(" ");
		
		System.out.println("투표하세요.");
		votenum = scan.nextInt();
		while(true) {
			if(votenum == playnum) {
				System.out.println("본인은 투표할 수 없습니다.");
				votenum = scan.nextInt();
			}
			else if(votenum > 5 || votenum < 0) {
				System.out.println("존재하지 않는 플레이어 입니다.");
				votenum = scan.nextInt();
			}
			else {
				Vote.vote(votenum);
				break;
			}
		}
		
		System.out.println("\n최종 투표결과");
		for(int i = 0; i < 5; i++)
			System.out.println("플레이어 "+ (i+1) +" 의 득표 : " + player[i][3]);
		
	}
		
}
