//1월 18일 과제
// 야구게임 구현하기
// 게임방법 
// - 수비자 번호 1~10까지의 수  (예. 1 3 7) - 랜덤 형식
// - 공격자 입력     결과
//    3  5  7     1S1B
//	  2  3  7     2S
//    7  1  3     3B
//    1  3  7     3S --> 아웃!
//--> 위치 a, 숫자b / a x b o --> ball    a o b o--> strike

package edu_20230117.hk.day11_BaseBall;

import java.util.Arrays;
import java.util.Scanner;

public class BaseBallGame {
	

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int[] depenser = new int[3]; // 수비수 랜덤 숫자 
		int[] offense = new int[3]; // 공격수 1~9 사이 3개 숫자 -> 중복있으면 안됨!

// 수비수
		// 수비수 랜덤 숫자 나오게 (1~10까지 랜덤숫자)
		for (int depnum = 0; depnum < depenser.length; depnum++) {
			depenser[depnum] = (int) ((Math.random() * 10) + 1);
			// 중복값 제거
			for (int num1 = 0; num1 < depnum; num1++) {
				if (depenser[depnum] == depenser[num1]) {
					depnum--;
					break;
				}
			}
		}
		System.out.println("수비수 번호: " + Arrays.toString(depenser)); // 수비수 번호 보기

// 공격수
		
	 
		while (true) {
			
			int offnum =0; 
			// 공격수 3번까지 내용 입력 받기
			for (offnum = 0; offnum < offense.length; offnum++) {
				System.out.println((offnum + 1) + "번째 공격수 번호 입력하세요." + "(1~10 사이의 숫자)");
				int num2 = scan.nextInt();
				if (num2 > 10 && offnum == 0) { // 1~10까지만 입력 받고 싶고나서 10넘으면 다시 이전 번째로 돌아가야하는데,, 안돌아가져,, 
					System.out.println("1~10 사이의 번호만 입력 가능합니다.");
					System.out.println((offnum + 1) + "번째 공격수 번호 입력하세요." + "(1~10 사이의 숫자)");
					num2 = scan.nextInt();
					
				}else if(num2 > 10 && offnum != 0){
					System.out.println("1~10 사이의 번호만 입력 가능합니다.");
					offnum -=1;  
				}

				// 공격수- 중복 숫자 금지
				boolean check = false; // 중복 숫자가 없는지 확인하기
				for (int i = 0; i < offnum; i++) {
					if (num2 == offense[i]) {
						check = true; // 중복되면 종료
						break;
					}
				}
				if (check == false) { // 중복되는 번호 없이 통과하면 여기서 저장
					offense[offnum] = num2;
				} else {
					System.out.println("중복되는 숫자를 입력했습니다."); // 중복되면 표시해주고 다시 이전 번째로 돌아가기
					offnum -= 1;
				}
			}
			

// 공격수 VS 수비수 결과
			int ball = 0;
			int strike = 0;
			int out = 0;
			for (int ii = 0; ii < depenser.length; ii++) {
				for (int j = 0; j < offense.length; j++) {
					if (depenser[ii] == offense[j]) {
						if (ii == j) { // 위치가 같으면 strike 1 증가
							strike = strike + 1;
						}else { // 값은 같은데 위치가 다르면 ball 1 증가
							ball = ball + 1;
					    }   
					}
				}
			}
			
			//System.out.println("Ball :" + ball + " / " + "Strike :" + strike);
			
			/**
			 *  0    0 1 2     
			 *  1  : 0 1 2    
			 *  2  : 0 1 2  
			 *  
			 *  1  4 5 6   
			 *  3  4 5 6 
			 *  4  4 5 6 
			 */
			
			if (strike == 3) { // 다 맞추면 승리
				System.out.println("You Win!");
				break;
			}else if (strike ==0 && ball ==0) {
				System.out.println("Out 입니다.");
			}else {
				System.out.println("Ball :" + ball + " / " + "Strike :" + strike);
			}
			
			
			/* 3루까지 나가면 out 기회는 3번 이후부터 out*/
			
			
			
			
			
	// 아웃도 만들어줘야하는데,,

		} // while 종료
	 

	} // public static void main 종료

} // public class BaseBallGame 종료