package org.gradle;

import org.junit.Test;
import static org.junit.Assert.*;

public class PersonTest {
    @Test
    public void canConstructAPersonWithAName() {
        Person person = new Person("Larry", 50);
        assertEquals("Larry", person.getName());
    }
	
    @Test
    public void canConstructAPersonWithAnAge() {
        Person person = new Person("Larry", 50);
        assertEquals(50, person.getAge());
    }	
	
	@Test
	public void testGetPersonNameUpperCase() {
		Person person = new Person("Pedro", 40);
		assertEquals("PEDRO", person.getNameInUpperCase());
	}
	
	@Test
	public void testGetPersonNameLowerCase() {
		Person person = new Person("PEDRO", 40);
		assertEquals("pedro", person.getNameInLowerCase());
	}
	
	@Test
	public void testGetPersonNameOrderAsc() {
		Person person = new Person("Guillermo", 25);
		assertEquals("egillmoru", person.getNameSortedAsc());
	}
	
	@Test
	public void testGetPersonNameOrderDesc() {
		Person person = new Person("Guillermo", 25);
		assertEquals("uromllige", person.getNameSortedDesc());
	}	

	@Test
	public void testGetPersonBonus() {
		Person person = new Person("Andres", 38);
		assertEquals(0.8, person.getPersonBonus(10), 0);
		assertEquals(1.6, person.getPersonBonus(20), 0);
		assertEquals(3.2, person.getPersonBonus(30), 0);
		assertEquals(0.0, person.getPersonBonus(40), 0);
	}	
	
	@Test
	public void testGetPersonNameFormatted() {
		Person person = new Person("Pablo", 25);
		assertEquals("PABLO HERNAN CHAVEZ", person.getNameFormatted("Hernan", "Chavez"));
	}
	
	@Test
	public void testGetPersonAgeGroup() {
		Person firstPerson = new Person("Pablo", 10);
		assertEquals("Child", firstPerson.getPersonAgeGroup());
		
		Person secondPerson = new Person("Elizabeth", 18);
		assertEquals("Teenager", secondPerson.getPersonAgeGroup());
		
		Person thirdPerson = new Person("Oscar", 30);
		assertEquals("Adult", thirdPerson.getPersonAgeGroup());		
			
		Person fourthPerson = new Person("Gabriel", 65);
		assertEquals("Third age", fourthPerson.getPersonAgeGroup());		
	}
	
	@Test
	public void testValidatePersonBankAccount() {
		Person person = new Person("Pablo", 25);
		assertTrue(person.isBankAccountValid(135479516816L));
		assertFalse(person.isBankAccountValid(135479516815641L));
	}	
	
	@Test
	public void testValidatePersonPhoneNumber() {
		Person person = new Person("Esteban", 18);
		assertTrue(person.isPhoneNumberValid("601-253-23"));
		assertFalse(person.isPhoneNumberValid("60-232-231"));
	}
	
	@Test
	public void testValidatePersonId() {
		Person person = new Person("Ana", 33);
		assertTrue(person.isIdValid("6749409LP"));
		assertFalse(person.isIdValid("6749409"));
	}
}
