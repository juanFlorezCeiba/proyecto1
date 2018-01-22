package co.ceiba.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import co.ceiba.domain.Person;
import co.ceiba.testdatabuilder.PersonTestDataBuilder;
;

public class NotifyPersonServiceTest {

	private NotifyPersonService notifyPersonService;
	private EmailService emailService;
	private Mockito mockito;
	
	@Before
	public void setup(){
		emailService = mockito.mock(EmailService.class);
		notifyPersonService = new NotifyPersonService(emailService);
		
	}
	
	@Test
	public void notifyTest(){
		
		//Arrange
		mockito.when(emailService.sendMail(mockito.anyString())).thenReturn("Hola Mundo"); 
		Person person = new PersonTestDataBuilder().build();
		//Act
		String message = notifyPersonService.notify(person);
		//Assert
		Assert.assertNotNull(message);
		System.out.println(message);
		
	}
}
