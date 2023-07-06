package exam;

import com.google.gson.JsonObject;

class Company {
	private int companyId;
	private String companyName;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	
	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", address=" + address + ", city="
				+ city + ", state=" + state + ", zipCode=" + zipCode + "]";
	}
}

public class CompanyMain {
	public static void main(String[] args) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("companyId", 100);
		jsonObject.addProperty("companyName", "Apple");
		jsonObject.addProperty("address", "Apple Computer Inc. 1 intfinite Loop");
		jsonObject.addProperty("city", "Cupertino");
		jsonObject.addProperty("state", "CA");
		jsonObject.addProperty("zipCode", "95014");
		
		System.out.println(jsonObject);
	}
}
