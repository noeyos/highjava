package kr.or.ddit.basic;

import java.util.Random;

import javax.swing.JOptionPane;


/*

	컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오.
	
	컴퓨터의 가위 바위 보는 난수를 이용해서 구하고
	사용자의 입력은 showInputDialong()메서드를 이용해서 입력 받는다.
	
	입력시간은 5초로 제한하고 카운트다운을 진행한다.
	5초 안에 입력이 없으면 게임에 진 것으로 처리한다.
	
	5초 안에 입력이 완료되면 승패를 구해서 결과를 출력한다.
	
	결과 예시1 ==> 5초 안에 입력을 못 했을 경우
	   	  --- 결  과 ---
	시간 초과로 당신이 졌습니다.
	
	결과 예시2 ==> 5초 안에 입력이 완료되었을 경우
		  --- 결  과 ---
		  컴퓨터 : 가위
		  사용자 : 바위
		  결  과 : 당신이 이겼습니다
	
*/

public class ThreadTest07 {
	public static void main(String[] args) {
		Thread th1 = new Input();
		Thread th2 = new Count();
		
		th1.start();
		th2.start();
	}
}

class Input extends Thread {
	
	public static boolean inputCheck = false;
	Random random = new Random();
	String comResult;
	
	@Override
	public void run() {
		
		int com = random.nextInt(2) + 1;
		
		switch(com) {
		case 1:
			comResult = "가위";
			break;
		case 2:
			comResult = "바위";
			break;
		case 3:
			comResult = "보";
			break;
		}
		
		String player = null;
		do {
			player = JOptionPane.showInputDialog("가위 / 바위 / 보");
		} while(!("가위".equals(player) || "바위".equals(player) || "보".equals(player)));
		// while(!"가위".equals(player) && !"바위".equals(player) && !"보".equals(player));

		inputCheck = true;
		
		System.out.println("\n========== 결   과 ==========");
		System.out.println("컴퓨터 : " + comResult);
		System.out.println("사용자 : " + player);
		if(comResult.equals(player)) {
			System.out.println("결  과 : 비겼습니다." );
		} else if(comResult.equals("가위")&&player.equals("바위") ||
				comResult.equals("바위")&&player.equals("보") ||
				comResult.equals("보")&&player.equals("가위")) {
			System.out.println("결  과 : 당신이 이겼습니다." );
		} else {
			System.out.println("결  과 : 당신이 졌습니다." );
		}
		
		switch(player + comResult) {
			case "가위가위" :
			case "바위바위" :
			case "보보" : System.out.println("결  과 : 비겼습니다."); break;
			
			case "가위보" :
			case "바위가위" :
			case "보바위" : System.out.println("결  과 : 당신이 이겼습니다."); break;
			
			default : System.out.println("결  과 : 당신이 졌습니다." ); 
			
		}
	}
}


class Count extends Thread {
	@Override
	public void run() {

		for(int i=5; i>= 1; i--) {
			if(Input.inputCheck == true) {
				return;
			}
			
			System.out.println(i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		System.out.println("\n========== 결   과 ==========");
		System.out.println("시간 초과로 당신이 졌습니다." );
		System.exit(0);
	}
}