package org.gradle;

import org.apache.commons.collections.list.GrowthList;
import java.util.*;

public class Person {
    private final String name;
	private final int age;
	private static final Map<Integer, Double> bonusPerAntiquity;
	
	static {
		bonusPerAntiquity = new HashMap<>();
		bonusPerAntiquity.put(10, 0.8);
		bonusPerAntiquity.put(20, 1.6);
		bonusPerAntiquity.put(30, 3.2);
	}

    public Person(String name, int age) {
        this.name = name;
		this.age = age;
        new GrowthList();
    }

    public String getName() {
        return name;
    }
	
	public int getAge() {
        return age;
    }
	
	public String getNameInUpperCase() {
		return name.toUpperCase();
	}
	
	public String getNameInLowerCase() {
		return name.toLowerCase();
	}
	
	public String getNameSortedAsc() {
		List<String> letters = new ArrayList<>(Arrays.asList(name.toLowerCase().split("")));
		Collections.sort(letters);
		StringJoiner sortedWord = new StringJoiner("");
		for (String letter : letters) {
			sortedWord.add(letter);
		}
		return sortedWord.toString();
	}
	
	public String getNameSortedDesc() {
		List<String> letters = new ArrayList<>(Arrays.asList(name.toLowerCase().split("")));
		Collections.sort(letters, Collections.reverseOrder());
		StringJoiner sortedWord = new StringJoiner("");
		for (String letter : letters) {
			sortedWord.add(letter);
		}
		return sortedWord.toString();
	}

	public double getPersonBonus(int antiquity) {
		return bonusPerAntiquity.getOrDefault(antiquity, 0.0);
	}
	
	public String getNameFormatted(String middleName, String lastName) {
		return String.format("%s %s %s", this.name.toUpperCase(), middleName.toUpperCase(), lastName.toUpperCase());
	}	
	
	public String getPersonAgeGroup() {
		if (this.age <= 15)
			return "Child";
		if (this.age <= 22)
			return "Teenager";
		if (this.age <= 40)
			return "Adult";
		
		return "Third age";
	}	
	
	public boolean isBankAccountValid(long bankAccount) {
		return String.valueOf(bankAccount).length() == 12;
	}
	
	public boolean isPhoneNumberValid(String phoneNumber) {
		return phoneNumber.matches("\\d{3}-\\d{3}-\\d{2}");
	}
	
	public boolean isIdValid(String id) {
		return Character.isLetter(id.charAt(id.length() - 1)) && Character.isLetter(id.charAt(id.length() - 2));
	}
}
