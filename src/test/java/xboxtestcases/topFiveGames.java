package xboxtestcases;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import xboxbasepages.XboxSearchGames;
import util.SystemUtil;
import util.TestCaseBase;
import util.TestData;

public class topFiveGames extends TestCaseBase {
	
	@Test
	public void testTopGames() throws Exception 
	{
		//read the url from property file
		Properties PROPERTIES_RESOURCES = SystemUtil
				.loadPropertiesResources("/testdata_userNgames.properties");
		String userTag = PROPERTIES_RESOURCES.getProperty("input.search.user");
				
		XboxSearchGames xboxSearchGames = new XboxSearchGames();
		xboxSearchGames.open();
		//xboxSearchGames.searchUser("Duskamo");
		xboxSearchGames.searchUser(userTag);
		Assert.assertTrue(xboxSearchGames.checkGames());	
		
		
	}
	
}