package org.pomRepository;

import org.devonicventures.genericUtility.ThreadSafeClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class chatPage {
	
	public chatPage(AndroidDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//android.widget.TextView[@content-desc=\"Experience Dream11 Chat\"]/parent::androidx.appcompat.widget.LinearLayoutCompat/preceding-sibling::android.view.ViewGroup/child::android.widget.TextView[@text='Chat']")
	private WebElement chatTitle ;
	
	@FindBy(xpath="//android.widget.TextView[@text='Rewards']")
	private WebElement rewardsBtn;
	
	
	
	//business libraries
	public String getChatPageTitle() {
		return chatTitle.getText();
	}
	
	public rewardsPage clickOnRewardsBtn() {
		rewardsBtn.click();
		return new rewardsPage(ThreadSafeClass.getDriver());
	}

}
