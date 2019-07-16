package com.gfk.web_test.util;

import java.util.HashMap;
import java.util.Map;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import io.codearte.jfairy.producer.text.TextProducer;



public class RandomTestDataGenerator {
	
	public Map<String,String> randomTDGen() {
		
		Fairy fairy = Fairy.create();
		Person person = fairy.person();
		TextProducer text = Fairy.create().textProducer();
		Map<String,String> testData = new HashMap<String,String>();
		
		if(person.isMale()) {
			testData.put("title", "Mr");
		}else {
			testData.put("title", "Mrs");
		}
		
		testData.put("firstname", person.firstName());
		testData.put("lastname", person.lastName());
		testData.put("email", person.email());
		testData.put("password", "testpassword");
		testData.put("day", Integer.toString(person.dateOfBirth().getDayOfMonth()));
		testData.put("month", Integer.toString(person.dateOfBirth().getMonthOfYear()));
		testData.put("year", Integer.toString(person.dateOfBirth().getYear()));
		testData.put("company",person.getCompany().name());
		testData.put("address1",person.getAddress().apartmentNumber()+" "+person.getAddress().street());
		testData.put("address2",person.getAddress().streetNumber());
		testData.put("city",person.getAddress().getCity());
		testData.put("postcode",person.getAddress().getPostalCode());
		testData.put("addlinfo",text.sentence(3));
		testData.put("mobilephone",person.telephoneNumber());
		testData.put("alias",text.word(2));
		return testData;
	}

}
