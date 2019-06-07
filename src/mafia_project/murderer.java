package mafia_project;

public class murderer {
	
	public void news() {
		chairman Delay = new chairman();
		
		System.out.println("[속보] 연쇄살인마 탈옥!!");
		Delay.delay1();
		System.out.println("밖에 연쇄 살인마가 돌아다니고 있습니다.");
		Delay.delay1();
		System.out.println("당신이 노려질 수 있습니다. 조심하세요.");
		Delay.delay1();
	}
	
	public void  serialmurder() {
		chairman Delay = new chairman();
		
		System.out.println("연쇄살인마가 당신을 발견했습니다!");
		Delay.delay1();
		System.out.println("도망치세요!");
		Delay.delay1();
		System.out.println("연쇄살인마가 당신을 잡았습니다.");
		Delay.delay1();
		for(int i = 0; i < 4; i++) {
			System.out.println("저항중입니다!");
			Delay.delay1();
		}
		System.out.println("저항하였지만 살인마는 너무 강했습니다.");
		System.out.println("연쇄살인마가 당신을 살해했습니다.");
		Delay.delay1();
	}
}
