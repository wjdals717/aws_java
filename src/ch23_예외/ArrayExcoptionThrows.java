package ch23_예외;

public class ArrayExcoptionThrows {

	public static void main(String[] args) {
		Integer[] nums = new Integer[]{1,2,3,4,5};
		try {
			printArray(nums);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("프로그램 정상 종료");
	}

	public static void printArray(Integer[] numArray) throws Exception {	//강제로 예외처리를 실행함 -> main에서 오류 철리를 해주지 않으면 컴파일 오류
		if(true) {	//강제로 예외 발생 //예외 메세지를 넣을 수 있음
			throw new RuntimeException("내가 강제로 생성한 예외");			
		}
		for (int i = 0; i < numArray.length; i++) {
			System.out.println(numArray[i]);
		}//노란줄 : 필요없는 코드라는 의미, 코드상 실행이 되지 않음
	}
}
