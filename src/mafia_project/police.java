package mafia_project;


public class police {
	
  public void reveal(int revealnum) {
	Scanner input = new Scanner(System.in);
	  
	while(true) {
	  revealnum = input.nextInt();
		
	  if(revealnum > 4) {
	    System.out,println("존재하지 않는 플레이어입니다.");
	  }
	  else if(player[revealnum][1] == 0) {
		System.out.println("이미 사망한 플레이어입니다.");
	  }
	  else {  // 플레이어넘버 1열 더 추가해야? 플레이어번호와 플레이어 직업은 별개 > 매 게임마다 다름
		if(revealnum == 0 ) {
		  System.out.println(revealnum + "번 플레이어의 직업은 마피아입니다.");
		}
		else if(revealnum == 1 ) {
		  System.out.println(revealnum + "번 플레이어의 직업은 마피아입니다.");
		}
		else if(revealnum == 2 ) {
		  System.out.println(revealnum + "번 플레이어의 직업은 마피아입니다.");
		}
		else if(revealnum == 3 ) {
		  System.out.println(revealnum + "번 플레이어의 직업은 마피아입니다.");
		}
		else if(revealnum == 4 ) {
		  System.out.println(revealnum + "번 플레이어의 직업은 마피아입니다.");
		}
		break;
	  }
	}
  }
}
