package org.pomRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class rewardsPage {
	public rewardsPage(AndroidDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//android.widget.TextView[@text='Reward Shop']")
	private WebElement rewardsPageTitle;
	
	
	public String getRewardsPageTitle() {
		return rewardsPageTitle.getText();
	}
}
