package exam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class data {
	private String name;
	private String rating;
	private int age;
}

public class MapList {
	public static void main(String[] args) {
		Map<String, Object> data1  =new HashMap<>();
		data1.put("name", "홍길동");
		data1.put("rating", "vip");
		data1.put("age", "30");
		
		Map<String, Object> data2  =new HashMap<>();
		data2.put("name", "김기영");
		data2.put("rating", "gold");
		data2.put("age", "35");
		
		List<Map<String, Object>> customers = new ArrayList<>();
		customers.add(data1);
		customers.add(data2);
		
		for(Map<String, Object> customer : customers) {
			for(String key: customer.keySet()) {
				System.out.print(key + "=");
				System.out.println(customer.get(key));
			}
			/*
			for(Entry<String, Object> key: customer.entrySet()) {
				System.out.print(key.getKey() + "=");
				System.out.println(key.getValue());
			}*/
		}
	}
}
