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

import flipkart.Utilities.ExplicitWaitManager;

public class AddTocartPage extends BasePage {

	public WebDriver driver;
	public String CartExpectedTitle = excelFile.getCellData(13, 8);
	public String RemoveItemExpectedTitle = excelFile.getCellData(14, 8);

	public AddTocartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/button[1]")
	WebElement btn_addToCart;

	@FindBy(xpath = "//span[contains(text(),'Price details')]")
	WebElement txt_cartPageText;

	@FindBy(xpath = "//div[contains(text(),'Remove')]")
	WebElement link_removeProduct;

	@FindBy(xpath = "//body/div[@id='container']/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]")
	WebElement txt_confirmRemove;

	@FindBy(xpath = "//div[contains(text(),'Successfully removed Google Pixel 7 (Obsidian, 128')]")
	WebElement txt_removedItem;

	public void clickAddToCart() {
		btn_addToCart.click();
	}

	public void clickRemoveFromCart() {
		link_removeProduct.click();
	}

	public void confirmRemoveFromCart() {
		txt_confirmRemove.click();
	}

	public String removedItem() {
		return txt_removedItem.getText();
	}
	
	public void waitForCartPage() {
		String cartPageText = "//span[contains(text(),'Price details')]";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cartPageText)));
	}
	
	public void waitForBtnToBeClickable() {
		ExplicitWaitManager.waitForElementToBeClickable(driver, link_removeProduct, 10);
	}

	public void waitForPopup() {
		String cartPageText = "//span[contains(text(),'Price details')]";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cartPageText)));
	}

	public void assertAddToCartProduct() {
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = CartExpectedTitle;
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}

	public void assertRemoveFromCartProduct() {
		String ActualTitle = removedItem();
		String ExpectedTitle = RemoveItemExpectedTitle;
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}

}
