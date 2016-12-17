package com.epam.ta.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage extends AbstractPage
{
    private final Logger logger = LogManager.getRootLogger();
	private final String BASE_URL = "https://rutracker.org/";


    @Override
    public void openPage()
    {
        driver.navigate().to(BASE_URL);
        logger.info("Branch forum page opened");
    }

	public SearchPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public int count()
    {
        WebElement table = driver.findElement(By.id("search-results"));
        List fullSearchList = table.findElements(By.className("hl-tr"));

        int result = 0;
        for(Object i : fullSearchList)
        {
            result++;
        }
        return result;
    }
}
