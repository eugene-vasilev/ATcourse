package com.epam.ta.pages;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage
{
    private final Logger logger = LogManager.getRootLogger();
	private final String BASE_URL = "https://rutracker.org/";

	@FindBy(className = "a-like")
	private WebElement loginLink;

    @FindBy(className = "login-ssl")
    private WebElement sslCheckBox;

	@FindBy(id = "top-login-uname")
	private WebElement nameInput;

	@FindBy(id = "top-login-pwd")
	private WebElement pwdInput;

	@FindBy(id = "top-login-btn")
	private WebElement loginButton;

    @FindBy(xpath = "//div[@class='logged-in-as-wrap']/a[2]")
    private WebElement logoutButton;

    @FindBy(xpath = "//b[@class='med']")
    private WebElement loggedInNameLink;

    @FindBy(xpath = "//tr[@id='f-899']/td[2]/h4/a")
    private WebElement linuxGamesLink;

    @FindBy(id = "search-text")
    private WebElement searchInput;

    @FindBy(id = "search-submit")
    private WebElement searchButton;

    @FindBy(xpath = "//a[@href='//by.rutracker.org/forum/']")
    private WebElement changeLangButton;

    @FindBy(xpath = "//a[@href='search.php?uid=22453972']")
    private WebElement myMessageButton;

    @FindBy(className = "mrg_16")
    private WebElement MMpageMessage;

    @Override
    public void openPage()
    {
        driver.navigate().to(BASE_URL);
        logger.info("Login page opened");
    }

	public MainPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void startLogin()
    {
        loginLink.click();
    }

	public void setName(String name)
    {
        nameInput.sendKeys(name);
    }

    public void checkSSL()
    {
        sslCheckBox.click();
    }

    public void setPwd(String pwd)
    {
        pwdInput.sendKeys(pwd);
    }

    public void finishLogin()
    {
        loginButton.click();
    }

    public String getLoggedInName()
    {
        String result = loggedInNameLink.getText();
        return result;
    }

    public void search(String searchSample)
    {
        searchInput.sendKeys(searchSample);
        searchButton.click();

    }

	public void logout()
	{
		logoutButton.click();

	}

	public void goToLinuxGamesBranch()
    {
        linuxGamesLink.click();
    }



    public String getLinuxGameLinkText()
    {
        String result = linuxGamesLink.getText().toString();
        return result;
    }

    public void changeLanguage()
    {
        changeLangButton.click();
    }

    public String getUrl()
    {
        WebElement BYEElement = (new WebDriverWait(driver,20))
                .until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Для праваўладальнікаў")));
        return driver.getCurrentUrl();
    }

    public void goToMyMessagePage()
    {
        myMessageButton.click();
    }

    public String getMMpageMessage()
    {
        return MMpageMessage.getText().toString();
    }



}
