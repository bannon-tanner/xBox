package xboxtestcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import xboxbasepages.XboxLeaderboardPage;
import util.TestCaseBase;
import util.TestData;

public class topFive extends TestCaseBase {
	
	@Test
	public void testGamertag() throws Exception 
	{
		XboxLeaderboardPage xboxLeaderboardPage = new XboxLeaderboardPage();
		xboxLeaderboardPage.open();
		Assert.assertTrue(xboxLeaderboardPage.getGamertags());	
	}
	
}

