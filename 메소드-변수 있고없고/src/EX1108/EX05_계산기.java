package EX1108;

import java.util.Scanner;

public class EX05_계산기 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 정수 입력 >> ");
		int num1 = sc.nextInt();
		System.out.print("두 번재 정수 입력 >> ");
		int num2 = sc.nextInt();
		System.out.print("연산자 입력( +, -, *, /) >>");
		String op = sc.next();

		System.out.println(cal(num1, num2, op));
	}

	public static int cal(int a, int b, String c) {

		
		//return은 한번만 쓸수 있음 -> 하나의 조건에 의해서 실행
		// else에 대한 리턴값을 줘야함
		int result = 0;
		if (c.equals("+")) {
			result = a + b;
		} else if (c.equals("-")) {
			result = a - b;
		} else if (c.equals("*")) {
			result = a * b;
		} else if (c.equals("/")) {
			result = a / b;
		}
		return result;

	}

//	 public static int cal(int a, int b, String c) {
//	      
////	      int result = 0;
//	      if(c.equals("+")) {
//	         return a + b;
//	      }else if(c.equals("-")) {
//	         return a - b;
//	      }else if(c.equals("*")) {
//	         return a * b;
//	      }else if(c.equals("/")) {
//	         return a / b;
//	      }else {
//	         return 0;
//	      }
//	      
	   }
	// 사용자로부터 숫자 2개, 연산자 입력받기
