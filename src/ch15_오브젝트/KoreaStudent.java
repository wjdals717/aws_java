package ch15_오브젝트;

import java.util.Objects;

public class KoreaStudent {
	private String studentCode;
	private String name;
	
	public KoreaStudent(String studentCode, String name) {
		super();
		this.studentCode = studentCode;
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, studentCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KoreaStudent other = (KoreaStudent) obj;		//다운캐스팅 -> 변수 접근 가능
		return Objects.equals(name, other.name) && Objects.equals(studentCode, other.studentCode);
	}
	
	public String getStudentCode() {
		return studentCode;
	}

	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void showInfo() {
		System.out.println("학번: " + studentCode);
		System.out.println("이름: " + name);
		System.out.println("===============");
	}

	@Override
	public String toString() {
		return "KoreaStudent [studentCode=" + studentCode + ", name=" + name + "]";
	}
	
	
}
