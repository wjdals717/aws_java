package ch20_컬렉션;

import java.util.ArrayList;
import java.util.LinkedList;

public class StringArrayListMain {
	public static void main(String[] args) {
		CustomArrayList list  = new CustomArrayList();
		
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		list.add(1, "f");	//1번 인덱스에 f추가
		
//		System.out.println(list.remove());
//		System.out.println(list.remove(5));
		System.out.println(list);
		
		System.out.println("===========================");
		
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("a");
		arrayList.add("b");
		arrayList.add("c");
		arrayList.add("d");
		arrayList.add("e");
		System.out.println(arrayList);
		System.out.println(arrayList.remove(3));
		System.out.println(arrayList);
		arrayList.set(0, "h");
		System.out.println(arrayList);
		
		LinkedList<String> linkedList = new LinkedList<>();
		
		
	}
}
