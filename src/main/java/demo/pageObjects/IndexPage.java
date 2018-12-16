package demo.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IndexPage {

	public By btn_home_createAnApp = By.id("link-create");
	public By btn_newApp_letsGetStarted = By.xpath("//div[@id='intro-dialog-cont']/div[2]/button");
	public By btn_newApp_newPage = By.id("add-page");
	public By txt_newPage_pageName = By.xpath("//div[@id='create-dialog']/form/p/input");
	public By btn_newPage_Create = By.xpath("//div[@id='create-dialog']/following::button[@type='button' and contains(., 'Create')]");
	public By arr_newApp_messaging = By.xpath("//div[@id='accordion']/h3[4]/a");
	public By node_newApp_start = By.xpath("//div[@id='module-1']//div[@class='syn-node ui-draggable syn-node-active']");
	public By arr_newApp_Dest_messaging = By.id("tabs-1");

	//Send An SMS
	public By lnk_newApp_messaging_sendAnSMS = By.xpath("//div[@id='accordion']/div[4]/ul/li[3]/span[1]");
	public By btn_newApp_messaging_sendAnSMS = By.xpath("//div[@id='accordion']/div[4]/ul/li[3]/a/span");
	public By txt_newApp_messaging_sendAnSMS_phoneNumber = By.name("phone_constant");
	public By txt_newApp_messaging_sendAnSMS_msgTextOrvariable = By.xpath("//div[@id='module-2']/div/div[3]/div/div[2]/div/table/tbody/tr/td[1]/div/textarea");
	public By rec_newApp_messaging_sendAnSMS = By.xpath("//div[@id='module-2']//div[@class='syn-receptor ui-droppable syn-receptor-north ui-draggable syn-receptor-draggable']");
	public By node_newApp_messaging_sendAnSMS_sent = By.xpath("//div[@id='module-2']/div[1]//div[@class='syn-node syn-node-attached-w ui-draggable syn-node-active']");
	public By node_newApp_messaging_sendAnSMS_notSent = By.xpath("//div[@id='module-2']/div[1]//div[@class='syn-node syn-node-attached-e ui-draggable syn-node-active']']");

	//Send By Email
	public By btn_newApp_messaging_sendAnEmail = By.xpath("//div[@id='accordion']/div[4]/ul/li[2]/a/span");
	public By EmailModule = By.id("module-3");
	public By txt_newApp_messaging_sendAnEmail_SMTPHost = By.name("smtp_url");
	public By txt_newApp_messaging_sendAnEmail_port = By.xpath("//input[@class='text number']");
	public By txt_newApp_messaging_sendAnEmail_userName = By.xpath("//input[@name='username'  and @class='text']");
	public By txt_newApp_messaging_sendAnEmail_password = By.xpath("//input[@name='password'  and @class='text']");
	public By txt_newApp_messaging_sendAnEmail_from = By.name("from_constant");
	public By txt_newApp_messaging_sendAnEmail_to = By.name("to_constant");
	public By txt_newApp_messaging_sendAnEmail_subject = By.name("subject_constant");
	public By txt_newApp_messaging_sendAnEmail_msgTextOrvariable = By.xpath("//div[@id='module-3']/div/div[3]/div/div[3]/div/div/table/tbody/tr/td[1]/div/textarea");
	public By rec_newApp_messaging_sendAnEmail = By.xpath("//div[@id='module-3']//div[@class='syn-receptor ui-droppable syn-receptor-north ui-draggable syn-receptor-draggable']");
	public By node_newApp_messaging_sendAnEmail_sent = By.xpath("//div[@id='module-3']/div[1]//div[@class='syn-node syn-node-attached-w ui-draggable syn-node-active']");
	public By node_newApp_messaging_sendAnEmail_notSent = By.xpath("//div[@id='module-3']/div[1]//div[@class='syn-node syn-node-attached-e ui-draggable syn-node-active']");

	//Basic
	public By arr_newApp_basic = By.xpath("//div[@id='accordion']/h3[1]/a");
	public By btn_newApp_basic_hangupForExit = By.xpath("//div[@id='accordion']/div[1]/ul/li[1]/a/span");
	public By rec_newApp_basic_hangupForExit1 = By.xpath("//div[@id='module-4']//div[@class='syn-receptor ui-droppable syn-receptor-north ui-draggable syn-receptor-draggable']");
	public By rec_newApp_basic_hangupForExit2 = By.xpath("//div[@id='module-5']//div[@class='syn-receptor ui-droppable syn-receptor-north ui-draggable syn-receptor-draggable']");
	public By rec_newApp_basic_hangupForExit3 = By.xpath("//div[@id='module-6']//div[@class='syn-receptor ui-droppable syn-receptor-north ui-draggable syn-receptor-draggable']");



	public void clickOnCreateAnApp(WebDriver driver) {
		pause(5);
		clickOnWebElement(driver, btn_home_createAnApp);
		pause(10);
		clickOnWebElement(driver, btn_newApp_letsGetStarted);

	}

	public void createNewPage(WebDriver driver, String pageName) {
		pause(5);
		clickOnWebElement(driver, btn_newApp_newPage);
		pause(5);
		enterValue(driver,txt_newPage_pageName, pageName);
		pause(5);
		clickOnWebElement(driver, btn_newPage_Create);
	}

	public void messagingModules(WebDriver driver){
		pause(5);
		clickOnWebElement(driver, arr_newApp_messaging);

	}

	public void AddSendAnSms(WebDriver driver){
		pause(5);
		clickOnWebElement(driver, btn_newApp_messaging_sendAnSMS);
		pause(5);
		joinStartNodeToSendAnSMSRec(driver);

	}

	public void joinStartNodeToSendAnSMSRec(WebDriver driver) {
		dragAndDropWebElement(driver,node_newApp_start,rec_newApp_messaging_sendAnSMS);
	}

	public void joinNotSentToSendAnEmailRec(WebDriver driver) {
		dragAndDropWebElement(driver,node_newApp_messaging_sendAnSMS_notSent,rec_newApp_messaging_sendAnEmail);
	}

	public void joinSentToSMSExitApp(WebDriver driver) {
		dragAndDropWebElement(driver,node_newApp_messaging_sendAnSMS_sent,rec_newApp_basic_hangupForExit1);
	}

	public void joinSentToEmailExitApp(WebDriver driver) {
		dragAndDropWebElement(driver,node_newApp_messaging_sendAnEmail_sent,rec_newApp_basic_hangupForExit2);
	}

	public void joinNotSentToEmailExitApp(WebDriver driver) {
		dragAndDropWebElement(driver,node_newApp_messaging_sendAnEmail_notSent,rec_newApp_basic_hangupForExit3);
	}

	public void fillSendAnSmsDetails(WebDriver driver,String PhoneNumber, String msgText) {
		pause(5);
		enterValue(driver, txt_newApp_messaging_sendAnSMS_phoneNumber,PhoneNumber);
		pause(5);
		enterValue(driver, txt_newApp_messaging_sendAnSMS_msgTextOrvariable,msgText);

	}

	public void addSendAnEmailAndFillDetails(WebDriver driver,String SMTP, String port, String UserName, String Pwd, String From, String To, String Subject, String msgText){
		pause(5);
		clickOnWebElement(driver, btn_newApp_messaging_sendAnEmail);
		/*pause(5);
		joinNotSentToSendAnEmailRec(driver);*/
		pause(2);
		enterValue(driver, txt_newApp_messaging_sendAnEmail_SMTPHost, SMTP);
		pause(2);
		enterValue(driver, txt_newApp_messaging_sendAnEmail_port, port);
		pause(2);
		enterValue(driver, txt_newApp_messaging_sendAnEmail_userName,  UserName);
		pause(2);
		enterValue(driver, txt_newApp_messaging_sendAnEmail_password, Pwd);
		pause(2);
		enterValue(driver, txt_newApp_messaging_sendAnEmail_from, From);
		pause(2);
		enterValue(driver, txt_newApp_messaging_sendAnEmail_to, To);
		pause(2);
		enterValue(driver, txt_newApp_messaging_sendAnEmail_subject, Subject);
		pause(2);
		enterValue(driver, txt_newApp_messaging_sendAnEmail_msgTextOrvariable, msgText);
		pause(2);
	}

	public void clickOnBasicModule(WebDriver  driver) {
		pause(5);
		clickOnWebElement(driver, arr_newApp_basic);

	}

	public void AddBasicExitApp1(WebDriver  driver) {

		pause(5);
		clickOnWebElement(driver, btn_newApp_basic_hangupForExit);
		/*pause(2);
		joinSentToSMSExitApp(driver);
		 */
	}

	public void AddBasicExitApp2(WebDriver  driver) {

		pause(5);
		clickOnWebElement(driver, btn_newApp_basic_hangupForExit);
		/*pause(2);
		joinSentToEmailExitApp(driver);*/

	}

	public void AddBasicExitApp3(WebDriver  driver) {

		pause(5);
		clickOnWebElement(driver, btn_newApp_basic_hangupForExit);
		/*pause(2);
		joinNotSentToEmailExitApp(driver);*/

	}



	public void enterValue(WebDriver driver, By by, String value) {

		explicitWait(driver,by);
		driver.findElement(by).sendKeys(value);
	}

	public void explicitWait(WebDriver driver, By by) {
		WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void clickOnWebElement(WebDriver driver, By by) {

		explicitWait(driver,by);
		driver.findElement(by).click();
	}

	public void pause(int sec) {

		try {
			Thread.sleep(1000*sec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void dragAndDropWebElement(WebDriver driver, By Source, By Destination) {
		Actions action = new Actions(driver);
		action.dragAndDrop(driver.findElement(Source), driver.findElement(Destination)).build().perform();

	}



}
