package org.pomRepository;

import org.devonicventures.genericUtility.ThreadSafeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class homePage {

	public homePage(AndroidDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//android.widget.TextView[@text='My Matches']")
	private WebElement myMatchesBtn ;

	@FindBy(xpath="//android.widget.TextView[@text='Upcoming']")
	private WebElement upcomingText ;

	@FindBy(xpath="//android.view.ViewGroup[@content-desc=\"Match_Card_1\"]/android.widget.ImageView[1]")
	private WebElement bellIcon;

	@FindBy(xpath="//android.widget.TextView[@text='Set Reminders']")
	private WebElement setRemainderText;

	@FindBy(xpath="//android.widget.TextView[@text='Set Reminders']/preceding-sibling::android.widget.ImageView")
	private WebElement closeBtn;


	@FindBy(xpath="//android.widget.ImageView[@content-desc=\"Match_Card_1_Flag_1\"]")
	private WebElement flagImg;


	//business libraries
	public myMatchesPage clickOnMyMatches() {
		ThreadSafeClass.getMobileUtility().implicitWait(10);
		myMatchesBtn.click();
		ThreadSafeClass.getMobileUtility().explicitWaitByvisibilityOf(upcomingText);
		return	new myMatchesPage(ThreadSafeClass.getDriver());

	}

	//Dynamic xpath to get team1
	
	String partialXpathOfTeam1="//android.widget.TextView[@text='%s']";
	
	public WebElement convertStringToWebElementOfTeam1(String partialXpath, String replaceData ) {
		String xpath = String.format(partialXpath, replaceData);
		return ThreadSafeClass.getDriver().findElement(By.xpath(xpath));
	}
	
	public String getTeam1Name(String expectedTourName) {
		ThreadSafeClass.getMobileUtility().explicitWaitByvisibilityOf(myMatchesBtn);
		return convertStringToWebElement(partialXpath,expectedTourName).getText();
	}
	
	//Dynamic xpath to get team2
	
		String partialXpathOfTeam2="//android.widget.TextView[@text='%s']";
		
		public WebElement convertStringToWebElementOfTeam2(String partialXpath, String replaceData ) {
			String xpath = String.format(partialXpath, replaceData);
			return ThreadSafeClass.getDriver().findElement(By.xpath(xpath));
		}
		
		public String getTeam2Name(String expectedTourName) {
			ThreadSafeClass.getMobileUtility().explicitWaitByvisibilityOf(myMatchesBtn);
			return convertStringToWebElement(partialXpath,expectedTourName).getText();
		}

	
	
	//Dynamic xpath
	String partialXpath="//android.view.ViewGroup[@content-desc=\"Match_Card_1\"]/child::android.widget.TextView[@text='%s']";

	public WebElement convertStringToWebElement(String partialXpath, String replaceData ) {
		String xpath = String.format(partialXpath, replaceData);
		return ThreadSafeClass.getDriver().findElement(By.xpath(xpath));
	}

	public String getTourName(String expectedTourName) {
		return convertStringToWebElement(partialXpath,expectedTourName).getText();
	}



	public String verifyBellIcon() {
		bellIcon.click();
		return setRemainderText.getText();
	}

	public void clickCloseBtn() {
		closeBtn.click();
	}
	
	public boolean getFlagImgElement() {
		return flagImg.isDisplayed();
	}



}





