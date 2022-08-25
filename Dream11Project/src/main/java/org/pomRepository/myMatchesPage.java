package org.pomRepository;

import org.devonicventures.genericUtility.ThreadSafeClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class myMatchesPage {
	
	public myMatchesPage(AndroidDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//android.widget.TextView[@text='Upcoming']")
	private WebElement upComingText ;
	
	@FindBy(xpath="//android.widget.TextView[@text='Winners']")
	private WebElement winnersBtn ;
	
	
	//business libraries
	public String verifyUpcomingMatches() {
		 return upComingText.getText();
	}
	
	public winnersPage clickOnMyWinners() {
		winnersBtn.click();
		return new winnersPage(ThreadSafeClass.getDriver());
	}

}
