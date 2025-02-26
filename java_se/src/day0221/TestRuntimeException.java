package day0221;

/**
 * main method에서 arguments 두개를 입력 받아, 두 수를 나누는 일.
 */
public class TestRuntimeException {

	public static void main(String[] args) {

		try {
			int num = Integer.parseInt(args[0]);
			int num2 = Integer.parseInt(args[1]);

			int result = num / num2;

			System.out.println(num + " / " + num2 + " = " + result);
		} catch (ArrayIndexOutOfBoundsException aioobe) {
			System.out.println("죄송합니다.");
			System.out.println("실행법) java TestRunTimeException 값 값");
			System.err.println("실행법) java TestRunTimeException 값 값");
		} catch (NumberFormatException nfe) {
			System.out.println("죄송합니다.");
			System.out.println("값은 숫자 형태로만 입력해주세요");
		} catch (ArithmeticException ae) {
			System.out.println("0으로 나눌 수 없음");
		} catch (Exception e) {
			System.out.println("개발자가 인식하지 못한 예외");
		} finally {
			System.out.println("사용해주셔서 감사합니다.");

		}
	}

}
