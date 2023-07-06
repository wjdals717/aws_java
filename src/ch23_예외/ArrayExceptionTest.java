package ch23_예외;

public class ArrayExceptionTest {
	public static void main(String[] args) {
		Integer[] nums = new Integer[] { 10, 20, 30, 40, 50 };
		
		for(int i = 0; i< nums.length + 1; i++) {
			try {
				System.out.println("index[" + i + "]: "+nums[i]);
			}
			catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("배열의 크기를 벗어났습니다.");
			}
			catch(NullPointerException e) {
				System.out.println("참조할 수 없는 주소입니다.");
			}
			catch(RuntimeException e ) {
				System.out.println("나머지 모든 예외 처리");
			}
			catch(Exception e ) {
				System.out.println("최종 예외 처리");
			}
			finally {
				System.out.println("모든 상황에서 실행됨");
			}
		}
		System.out.println("프로그램 정상 종료");
	}
}
