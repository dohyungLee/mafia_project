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
			System.out.println("���� �Ǿ����ϴ�.");
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
		
		System.out.println("1~5 �� �÷��̾��� ��ȣ�� ������ �ּ���.");
		int [][] player = new int [5][3];
		
		playnum = scan.nextInt();
		while(true) {
			if(playnum > 5)
				System.out.println("�ٽ� �Է����ּ���.");
			else {
				System.out.println("����� �÷��̾� ��ȣ�� " + playnum + "�� �Դϴ�.");
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
		
		//�� Ȯ�ο�...
		//for(int i = 0; i < 5; i++)
		//System.out.println("player["+i+"]"+"[0] �� �� : " + player[i][0]);
		
		System.out.println("");
		
		switch(player[playnum][0]) {
		case 1:
			System.out.println("����� ������ ���Ǿ� �Դϴ�.");
			break;
		case 2:
			System.out.println("����� ������ ���� �Դϴ�.");
			break;
		case 3:
			System.out.println("����� ������ �ǻ� �Դϴ�.");
			break;
		case 4:
			System.out.println("����� ������ �ù�1 �Դϴ�.");
			break;
		case 5:
			System.out.println("����� ������ �ù�2 �Դϴ�.");
			break;
		}
		
		System.out.println(" ");
		
		
	}
}
