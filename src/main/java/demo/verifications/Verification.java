package demo.verifications;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.annotations.Test;

import demo.appModules.SetupInit;
import demo.pageObjects.IndexPage;

public class Verification extends SetupInit{
	
	@Test
	public void createNewApp() {
		
		IndexPage indexPage = new IndexPage();
		
		indexPage.clickOnCreateAnApp(driver);
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now(); 
		indexPage.createNewPage(driver, "New Page "+now);
		
		indexPage.messagingModules(driver);
		
		indexPage.AddSendAnSms(driver);
		
		indexPage.fillSendAnSmsDetails(driver, "7894563215", "Hello");
		
		indexPage.addSendAnEmailAndFillDetails(driver, "abc@gmail.com", "475", "xyz@gmail.com", "abc.123", "from@gmail.com", "to@gmail.com", "Network testing", "Hello");
		
		indexPage.clickOnBasicModule(driver);
		
		indexPage.AddBasicExitApp1(driver);
		
		indexPage.AddBasicExitApp2(driver);
		
		indexPage.AddBasicExitApp3(driver);
		
	}

}
