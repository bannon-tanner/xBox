package xboxbasepages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import util.FunctionUtil;
import util.Page;
import util.SystemUtil;
import util.TestCaseBase;
import util.Waiting;

public class XboxSearchGames extends Page {
	//web elements
	@FindBy(name = "s")//it can be located by name
	public WebElement searchInput;
	
	@FindBy(xpath="(//div[@class=\"recent-games\"]//div[@class=\"game-card-desc\"]//a)[1]")
	public WebElement actualGame1;
	@FindBy(xpath="(//div[@class=\"recent-games\"]//div[@class=\"game-card-desc\"]//a)[2]")
	public WebElement actualGame2;
	@FindBy(xpath="(//div[@class=\"recent-games\"]//div[@class=\"game-card-desc\"]//a)[3]")
	public WebElement actualGame3;
	@FindBy(xpath="(//div[@class=\"recent-games\"]//div[@class=\"game-card-desc\"]//a)[4]")
	public WebElement actualGame4;
	@FindBy(xpath="(//div[@class=\"recent-games\"]//div[@class=\"game-card-desc\"]//a)[5]")
	public WebElement actualGame5;

	
	
	//open this page
		public XboxSearchGames open() throws Exception {
			//read the url from property file
			Properties PROPERTIES_RESOURCES = SystemUtil
					.loadPropertiesResources("/testdata_xbox.properties");
			String URL = PROPERTIES_RESOURCES.getProperty("xbox.url.home");
			TestCaseBase.threadDriver.get().navigate().to(URL);

			//return this means browser stays on GoogleHomePage
			return this;
		}
		
		public void  searchUser(String theUser) {	
			searchInput.sendKeys(theUser);
			searchInput.submit();
		}
		
		public boolean  checkGames() {	
			boolean result = true;
			//read the expected Games from property file
			Properties PROPERTIES_RESOURCES = SystemUtil
					.loadPropertiesResources("/testdata_userNgames.properties");
			String game1 = PROPERTIES_RESOURCES.getProperty("game1");
			String game2 = PROPERTIES_RESOURCES.getProperty("game2");
			String game3 = PROPERTIES_RESOURCES.getProperty("game3");
			String game4 = PROPERTIES_RESOURCES.getProperty("game4");
			String game5 = PROPERTIES_RESOURCES.getProperty("game5");
			
			if (!game1.equals(actualGame1.getText())) {
				result = false;
				System.out.println("expected: " + game1 + " actual: " + actualGame1.getText() );
			}
			if (!game2.equals(actualGame2.getText())) {
				result = false;
				System.out.println("expected: " + game2 + " actual: " + actualGame2.getText() );
			}
			if (!game3.equals(actualGame3.getText())) {
				result = false;
				System.out.println("expected: " + game3 + " actual: " + actualGame3.getText() );
			}
			if (!game4.equals(actualGame4.getText())) {
				result = false;
				System.out.println("expected: " + game4 + " actual: " + actualGame4.getText() );
			}
			if (!game5.equals(actualGame5.getText())) {
				result = false;
				System.out.println("expected: " + game5 + " actual: " + actualGame5.getText() );
			}

			System.out.println("expected: " + game1 + " actual: " + actualGame1.getText() );
			System.out.println("expected: " + game2 + " actual: " + actualGame2.getText() );
			System.out.println("expected: " + game3 + " actual: " + actualGame3.getText() );
			System.out.println("expected: " + game4 + " actual: " + actualGame4.getText() );
			System.out.println("expected: " + game5 + " actual: " + actualGame5.getText() );
			
			return result;
		}
		
}
