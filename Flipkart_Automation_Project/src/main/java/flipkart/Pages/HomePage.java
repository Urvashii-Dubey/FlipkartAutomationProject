package flipkart.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import flipkart.Utilities.ActionManager;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[contains(text(),'✕')]")
	WebElement btn_closePopup;

	@FindBy(xpath = "//a[contains(text(),'Login')]")
	WebElement link_login;

	@FindBy(how = How.XPATH, using = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[4]/a[1]/span[1]")
	public WebElement link_becomeASeller;

	@FindBy(xpath = "//a[contains(text(),'Careers')]")
	WebElement link_careers;

	@FindBy(xpath = "//a[contains(text(),'Flipkart Stories')]")
	WebElement link_flipkartStories;

	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[1]/div[1]/div[2]/div[5]/div[1]/div[1]/div[1]/div[1]")
	WebElement link_more;

	@FindBy(xpath = "//div[contains(text(),'Advertise')]")
	WebElement link_advertise;

	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/input[1]")
	WebElement input_search;

	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/button[1]/*[1]")
	WebElement btn_search;

	@FindBy(xpath = "//a[contains(text(),'Press')]")
	WebElement link_press;

	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/a[2]")
	WebElement link_explorePlus;

	@FindBy(xpath = "//div[@id='container']")
	WebElement txt_clickOnsearchBox;
	
	@FindBy(xpath = "//div[contains(text(),'24x7 Customer Care')]")
	WebElement link_24X7customerCare;

	public void closePopup() {
		btn_closePopup.click();
	}

	public void goToLoginLink() {
		link_login.click();
	}

	public void goToBecomeSellerLink() {
		link_becomeASeller.click();
	}

	public void clickOnCareerLink() {
		link_careers.click();
	}

	public void goToFlipkartStoriesLink() {
		link_flipkartStories.click();
	}

	public void goToMoreLink() {
		link_more.click();
	}

	public void goToAvertiseLink() {
		link_advertise.click();
	}

	public void clickOnsearchBox() {
		input_search.click();
	}

	public void clickOnPressLink() {
		link_press.click();
	}

	public void clickOnExplorePlusLink() {
		link_explorePlus.click();
	}
	
	public void goToCustomerCarelink() {
		link_24X7customerCare.click();
	}

	public void enterProductInSearchBox(String ProductName) {
		input_search.sendKeys(ProductName);
	}

	public void clickOnsearchButton() {
		btn_search.click();
	}
	
	public void moveToElement() {
		ActionManager.moveToElement(link_more);
	}
	
}
