package buildUp;

public class Ex02_Arrayout {

	public static void main(String[] args) {

		int[] array = { 1, 2, 3 };

		try {
			System.out.println(array[2]);
			System.out.println(100 / 0);

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("인덱스 에러??");

//		} catch (ArithmeticException e) {
//			System.out.println("수학적인 에러?");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 예외 상관없이 한번은 실행
			System.out.println("예외 상관없이 실행");
		}
		System.out.println("다음코드");
	}
}
