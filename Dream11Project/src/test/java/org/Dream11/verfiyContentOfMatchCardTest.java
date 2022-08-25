package org.Dream11;

import org.devonicventures.genericUtility.BaseClass;
import org.devonicventures.genericUtility.IConstants;
import org.devonicventures.genericUtility.ListenerImplimentationclass;
import org.devonicventures.genericUtility.ThreadSafeClass;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(org.devonicventures.genericUtility.ListenerImplimentationclass.class)

public class verfiyContentOfMatchCardTest extends BaseClass
{
	@Test
	public void verifyContent() throws InterruptedException {
		//fetch Data From ExcelFile
		String expectedTeam1Name=excelUtility.getDataFromExcelSheet(IConstants.sheetName,4,1);
		String expectedTeam2Name=excelUtility.getDataFromExcelSheet(IConstants.sheetName,4,2);
		String expectedTourName=excelUtility.getDataFromExcelSheet(IConstants.sheetName,4,3);
		String expectedText=excelUtility.getDataFromExcelSheet(IConstants.sheetName,4,4);

		boolean flagImage = homePage.getFlagImgElement();
		Assert.assertTrue(flagImage);
		ListenerImplimentationclass.testLog.info("Flag Validated");
		
		String actualTeam1Name = homePage.getTeam1Name(expectedTeam1Name);
		Assert.assertEquals(actualTeam1Name, expectedTeam1Name, "Team A Name Not validated");
		ThreadSafeClass.getJavaUtility().printStatement("Team A Validated");
		ListenerImplimentationclass.testLog.info("Team A Name validated");

		String actualTeam2Name = homePage.getTeam2Name(expectedTeam2Name);
		Assert.assertEquals(actualTeam2Name, expectedTeam2Name, "Team B Name Not Validated");
		ThreadSafeClass.getJavaUtility().printStatement("Team B Validated");
		ListenerImplimentationclass.testLog.info("Team B Name validated");

		String actualTourName = homePage.getTourName(expectedTourName);
		Assert.assertEquals(actualTourName, expectedTourName, "Tour name Not Validated");
		ThreadSafeClass.getJavaUtility().printStatement("Tour Name Validated");
		ListenerImplimentationclass.testLog.info("Tour Name Validated Validated");

		String actualText = homePage.verifyBellIcon();
		Assert.assertEquals(actualText, expectedText, "Bell icon not validated");
		ThreadSafeClass.getJavaUtility().printStatement("Bell Icon  Validated");
		ListenerImplimentationclass.testLog.info("Bell Icon  Validated");

		homePage.clickCloseBtn();
	}
}
