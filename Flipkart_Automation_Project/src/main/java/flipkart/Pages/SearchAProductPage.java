package flipkart.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SearchAProductPage extends BasePage {

	public WebDriver driver;
	public String ProductName = excelFile.getCellData(12, 7);
	public String ProductExpectedTitle = excelFile.getCellData(12, 8);

	public SearchAProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(text(),'Google Pixel 7 (Obsidian, 128 GB)')]")
	WebElement link_product;
	
	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[3]/div[1]/div[2]/div[3]/div[1]/div[1]/h1[1]/span[1]")
	WebElement link_productDetails;

	public void clickOnViewProduct() {
		link_product.click();
	}
	
	public void waitForProductSearchCompletion() {
		String productLink = "//div[contains(text(),'Google Pixel 7 (Obsidian, 128 GB)')]";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(productLink)));
	}
	
	public void waitForProductDetailedView() {
		String productDetails = "//body/div[@id='container']/div[1]/div[3]/div[1]/div[2]/div[3]/div[1]/div[1]/h1[1]/span[1]";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(productDetails)));
	}

	public void assertSearchProduct() {
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = ProductExpectedTitle;
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}

}
