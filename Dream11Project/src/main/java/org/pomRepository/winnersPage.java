package org.pomRepository;

import org.devonicventures.genericUtility.ThreadSafeClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class winnersPage {
	

	public winnersPage(AndroidDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//android.widget.TextView[@content-desc='share']/parent::androidx.appcompat.widget.LinearLayoutCompat/preceding-sibling::android.view.ViewGroup/child::android.widget.TextView[@text='Winners']")
	private WebElement winnersText ;
	
	@FindBy(xpath="//android.widget.TextView[@text='Chat']")
	private WebElement chatBtn;
	
	@FindBy(xpath="//android.widget.TextView[@text='Direct Chat']")
	private WebElement ElementToWait;
	
	//business library
	public String getWinnerPageTitle() {
		return winnersText.getText();
	}
	
	public chatPage clickOnChatBtn() {
		chatBtn.click();
		ThreadSafeClass.getMobileUtility().explicitWaitByvisibilityOf(ElementToWait);
		return new chatPage(ThreadSafeClass.getDriver());
		
	}

}
