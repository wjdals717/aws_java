package exam;

import java.util.Arrays;
import java.util.List;

class SubjectService {
	private List<String> subjects;
	
	public SubjectService(List<String> subjects) {
		this.subjects = subjects;
	}
	
	public void showSubject() {
		int length = 3;
		for(int i = 0; i < length; i++) {
			System.out.println(subjects.get(i));
		}
	}
}

public class Main {
	public static void main(String[] args) {
		List<String> subjects = Arrays.asList(new String[] {"C", "Java", "Python"});
		SubjectService subjectService = new SubjectService(subjects);
		subjectService.showSubject();
	}
}