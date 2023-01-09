package flipkart.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import flipkart.Utilities.ExplicitWaitManager;

public class FlipkartSocialLinksPage extends BasePage {

	public WebDriver driver;
	public String FacebookExpectedTitle = excelFile.getCellData(9, 8);
	public String TwitterExpectedTitle = excelFile.getCellData(10, 8);
	public String YouTubeExpectedTitle = excelFile.getCellData(11, 8);

	public FlipkartSocialLinksPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Facebook')]")
	public WebElement link_facebook;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Twitter')]")
	public WebElement link_twitter;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'YouTube')]")
	public WebElement link_youTube;
	
	@FindBy(how = How.XPATH, using = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]")
	public WebElement logo_facebook;
	
	@FindBy(how = How.XPATH, using = "//body/div[@id='react-root']/div[1]/div[1]/div[2]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/h2[1]/div[1]/div[1]/div[1]/div[1]/span[1]/span[1]/span[1]")
	public WebElement logo_twitter;
	
	@FindBy(how = How.XPATH, using = "//ytd-masthead/div[@id='container']/div[@id='start']/ytd-topbar-logo-renderer[@id='logo']/a[@id='logo']/div[1]/ytd-logo[1]/yt-icon[1]")
	public WebElement logo_youTube;

	public void goToFacebookLink() {
		link_facebook.click();
	}

	public void goTotwitterLink() {
		link_twitter.click();
	}

	public void openYouTubeLink() {
		link_youTube.click();
	}
	
	public void waitForFacebookPageLoad() {
		ExplicitWaitManager.waitForTitle(driver, FacebookExpectedTitle, 20);;
	}
	
	public void waitForTwitterPageLoad() {
		ExplicitWaitManager.waitForElementToBeClickable(driver, logo_twitter, 20);
	}
	
	public void waitForYouTubePageLoad() {
		ExplicitWaitManager.waitForElementToBeClickable(driver, logo_youTube, 20);
	}

	public void assertFacebook() {
		String ActualTitle = FacebookExpectedTitle;
		String ExpectedTitle = FacebookExpectedTitle;
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}

	public void assertTwitter() {
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = TwitterExpectedTitle;
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}

	public void assertYouTube() {
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = YouTubeExpectedTitle;
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}

}
