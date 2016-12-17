package com.epam.ta.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForumBranchPage extends AbstractPage
{
    private final Logger logger = LogManager.getRootLogger();
	private final String BASE_URL = "https://rutracker.org/";

    @FindBy(xpath = "//h1[@class='maintitle']/a")
    private WebElement branchNameLink;

    @Override
    public void openPage()
    {
        driver.navigate().to(BASE_URL);
        logger.info("Branch forum page opened");
    }

	public ForumBranchPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public String getBranchName()
    {
        String result = branchNameLink.getText();
        return result;
    }



	public void echo(String q)
    {
        logger.info(q);
    }
}
