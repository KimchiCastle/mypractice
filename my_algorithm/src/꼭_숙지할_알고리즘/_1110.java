package 꼭_숙지할_알고리즘;

import java.util.Scanner;

public class _1110 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		// 초기입력값
		int N = sc.nextInt();
		int copy = N;
		int count = 0;
		
		
		/*
		// N의 1의자리값이 다음 숫자의 10의 자리 수가 된다. 
		//N의 각 자릿수를 더한 값의 1의 자리 수가 다음 수의 1의 자리수가 된다.
		// 1. N의 10의자리 구하기 
		int N_1 = N%10; // -> 다음 숫자의 10의 자리 수
		int N_10 = N/10;

		// 다음수의 10의 자리 
		int T_10 = N_1 * 10; // (N%10)*10
		// 다음수의 1의 자리 (N_1 + N_10)%10 
		int T_1 = (N_1 + N_10)%10;  //(N%10 + N/10)%10 

		// 다음수 T 
		int T = (N%10)*10 + (((N%10)+(N/10))%10);
		
		*/

		while (true) {
			N = (N%10)*10 + (((N%10)+(N/10))%10);
			count++;
			if (N == copy) {
				break;
			}
		}

		System.out.println(count);
		sc.close();
	}

}
