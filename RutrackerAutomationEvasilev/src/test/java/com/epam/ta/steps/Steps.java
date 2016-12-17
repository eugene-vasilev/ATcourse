package com.epam.ta.steps;

import com.epam.ta.driver.DriverSingleton;
import com.epam.ta.pages.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.reporters.jq.Main;

public class Steps
{
	private WebDriver driver;

	private final Logger logger = LogManager.getRootLogger();

	public void initBrowser()
	{
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver()
	{
		driver.quit();
	}

	public void loginRutracker(String name, String pwd)
	{
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
		mainPage.startLogin();
		mainPage.setName(name);
		mainPage.setPwd(pwd);
		mainPage.checkSSL();
		mainPage.finishLogin();


	}

	public boolean isLoggedIn(String expectedName)
	{
		MainPage mainPage = new MainPage(driver);
		String realName = mainPage.getLoggedInName();
		boolean result = false;
		if((expectedName.toString()).equals(realName.toString())){
			result = true;
			logger.info("Logged in = true");
		}else{
			result = false;
			logger.info("Logged in = false");
		}
		return result;
	}

	public void logoutRutracker()
	{
		MainPage mainPage = new MainPage(driver);
		mainPage.logout();
	}

	public String goToLinuxGamesBranch()
	{
		MainPage mainPage = new MainPage(driver);
		String name = mainPage.getLinuxGameLinkText();
		mainPage.goToLinuxGamesBranch();
		return name;
	}

	public boolean isInBranch(String expectedName)
    {
		ForumBranchPage forumBranchPage = new ForumBranchPage(driver);
		String name = forumBranchPage.getBranchName().toString();
		if(expectedName.equals(name)){
			logger.info("Branch is true");
			return true;
		}else{
			logger.info("Branch is false");
			return false;
		}
	}

	public void search(String searchSample)
	{
		MainPage mainPage = new MainPage(driver);
		mainPage.search(searchSample);
	}

	public boolean isSearched()
    {
		SearchPage searchPage = new SearchPage(driver);
		int count = searchPage.count();
		if (count==1) {
			logger.info("Search is true. Count: "+count);
			return true;
		} else {
			logger.info("Search is false");
			return false;
        }
    }


}
