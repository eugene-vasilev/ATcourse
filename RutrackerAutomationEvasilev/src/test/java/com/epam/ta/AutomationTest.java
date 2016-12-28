package com.epam.ta;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.ta.steps.Steps;

public class AutomationTest
{
	private final Logger logger = LogManager.getRootLogger();
	private Steps steps;
	private final String NAME = "dozer95";
	private final String PWD = "6002455";
	private final String SEARCH_SAMPLE = "vst life";
	private final String EXPECTED_URL = "https://by.rutracker.org/forum/";
	private final String MMPAGEMESSAGE = "Подходящих тем или сообщений не найдено";

	@BeforeMethod(description = "Init browser")
	public void setUp()
	{
		steps = new Steps();
		steps.initBrowser();
	}

	@Test(description = "Login to Rutracker")
	public void oneCanLoginRutracker()
	{
		steps.loginRutracker(NAME, PWD);
		Assert.assertTrue(steps.isLoggedIn(NAME));
		steps.logoutRutracker();

	}

	@Test(description = "Go to Linux Games Branch")
	public void oneCanGoToLinuxGamesBranch()
	{
		steps.loginRutracker(NAME,PWD);
		String expectedName = steps.goToLinuxGamesBranch();
		Assert.assertTrue(steps.isInBranch(expectedName));

	}

	@Test(description = "Search on Rutracker")
	public void oneCanSearch()
	{
		steps.loginRutracker(NAME,PWD);
		steps.search(SEARCH_SAMPLE);
		Assert.assertTrue((steps.isSearched()));
	}

	@Test(description = "Change Language for BY")
	public void oneCanChangeLanguage()
	{
		steps.openPage();
		steps.changeLanguage();
		Assert.assertTrue(steps.isLanguageChanged(EXPECTED_URL));
	}

	@Test
	public void oneCanGoToMyMessagePage()
	{
		steps.loginRutracker(NAME,PWD);
		steps.goToMMpage();
		Assert.assertTrue(steps.isInMMpage(MMPAGEMESSAGE));
		steps.logoutRutracker();
	}


	@AfterMethod(description = "Stop Browser")
	public void stopBrowser()
	{
		steps.closeDriver();
	}

}
