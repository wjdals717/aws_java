package ch15_오브젝트;

public class EqualsMain {
	public static void main(String[] args) {
		KoreaStudent koreaStudent1 = new KoreaStudent("2023001", "변정민");
		KoreaStudent koreaStudent2 = new KoreaStudent("2023002", "정가영");
		KoreaStudent koreaStudent3 = new KoreaStudent("2023003", "우주영");
		KoreaStudent koreaStudent4 = new KoreaStudent("2023001", "변정민");
		
//		메모리 주소 비교
		System.out.println(koreaStudent1 == koreaStudent4);
//		데이터(값) 비교
		System.out.println(koreaStudent1.getStudentCode() == koreaStudent4.getStudentCode()
				&& koreaStudent1.getName() == koreaStudent4.getName());	//학번과 이름 비교
		
		System.out.println(koreaStudent1.equals(koreaStudent4)); 		//업캐스팅
		
	}
}
