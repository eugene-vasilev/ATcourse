package com.epam.ta;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.eclipse.jetty.util.annotation.Name;
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

	@Test
	public void oneCanSearch()
	{
		steps.loginRutracker(NAME,PWD);
		steps.search(SEARCH_SAMPLE);
		Assert.assertTrue((steps.isSearched()));

	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser()
	{
		steps.closeDriver();
	}

}
