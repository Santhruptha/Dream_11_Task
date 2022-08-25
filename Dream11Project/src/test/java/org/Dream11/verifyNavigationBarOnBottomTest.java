package org.Dream11;

import org.devonicventures.genericUtility.BaseClass;
import org.devonicventures.genericUtility.IConstants;
import org.devonicventures.genericUtility.ListenerImplimentationclass;
import org.devonicventures.genericUtility.ThreadSafeClass;
import org.pomRepository.chatPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(org.devonicventures.genericUtility.ListenerImplimentationclass.class)
public class verifyNavigationBarOnBottomTest extends BaseClass {
	
	@Test
	public void verifyNavigation() {
		//fetch data from excel
		String expectedUpcomingTitle = excelUtility.getDataFromExcelSheet(IConstants.sheetName,2,1);
		String expectedWinnerPageTitle = excelUtility.getDataFromExcelSheet(IConstants.sheetName,2,2);
		String expectedChatPageTitle= excelUtility.getDataFromExcelSheet(IConstants.sheetName,2,3);
		String expectedRewardPageTitle = excelUtility.getDataFromExcelSheet(IConstants.sheetName,2,4);
		
		String actualUpComingPageTitle = homePage.clickOnMyMatches().verifyUpcomingMatches();
		Assert.assertEquals(actualUpComingPageTitle, expectedUpcomingTitle,"My Matches Page Not validated");
		ThreadSafeClass.getJavaUtility().printStatement(expectedUpcomingTitle);
		ListenerImplimentationclass.testLog.info("My Match Page Title Validated");
		
		String actualWinnerPageTitle = myMatchpage.clickOnMyWinners().getWinnerPageTitle();
		Assert.assertEquals(actualWinnerPageTitle, expectedWinnerPageTitle,"Winners Page Not validated");
		ThreadSafeClass.getJavaUtility().printStatement(expectedWinnerPageTitle);
		ListenerImplimentationclass.testLog.info("Winner Page Title Validated");
		
		String actualChatPageTitle = winnerPage.clickOnChatBtn().getChatPageTitle();
		Assert.assertEquals(actualChatPageTitle, expectedChatPageTitle, "Chat page Title Not Validated");
		ThreadSafeClass.getJavaUtility().printStatement(expectedChatPageTitle);
		ListenerImplimentationclass.testLog.info("ChatPage Title validated");
		
		String actualRewardsPageTitle = chatpage.clickOnRewardsBtn().getRewardsPageTitle();
		Assert.assertTrue(actualRewardsPageTitle.contains(expectedRewardPageTitle),"Rewards Page Title Not validated");
		ThreadSafeClass.getJavaUtility().printStatement(expectedRewardPageTitle);
		ListenerImplimentationclass.testLog.info("Rewards Page Title Validated");
		
	}

}
