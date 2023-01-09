package flipkart.TestCases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import flipkart.Pages.AddTocartPage;
import flipkart.Pages.BasePage;
import flipkart.Pages.SearchAProductPage;
import flipkart.Utilities.ActionManager;

public class AddToCartTest extends BasePage {

	@Test(priority = 13, enabled = true, groups = {"smoke"})
	public void AddToCart() throws InterruptedException {

		SearchAProductPage searchAProductPage = new SearchAProductPage(driver);
		AddTocartPage addToCartPage = new AddTocartPage(driver);

		// Searched a product
		SearchAProductTest searchProduct = new SearchAProductTest();
		searchProduct.SearchAProduct();

		test.log(LogStatus.INFO, "-----------------------* Add product to cart *-----------------------");
		logger.info("-----------------------* Add product to cart *-----------------------");

		// Wait for product detailed view page
		searchAProductPage.waitForProductDetailedView();

		// A little scroll
		ActionManager.singleScrollDown();

		addToCartPage.clickAddToCart();
		test.log(LogStatus.INFO, "Clicked on add to cart");
		logger.info("Clicked on add to cart");

		addToCartPage.waitForCartPage();

		// Assertion
		addToCartPage.assertAddToCartProduct();
		test.log(LogStatus.INFO, "Verfied that the product is added to the cart");
		logger.info("Verfied that the product is added to the cart");
	}

	@Test(priority = 14, enabled = true, groups = {"smoke"})
	public void DeleteProductFromCart() throws InterruptedException {

		AddTocartPage removeFromCart = new AddTocartPage(driver);

		// Searched a Product and added it to the cart
		AddToCartTest addToCart = new AddToCartTest();
		addToCart.AddToCart();

		test.log(LogStatus.INFO, "-----------------------* Delete Product from cart *-----------------------");
		logger.info("-----------------------* Delete Product from cart *-----------------------");
		
		// Scroll to the end of the page
		ActionManager.scrollDownToBottom();
		test.log(LogStatus.INFO, "Scroll down to the bottom of the page");
		logger.info("Scroll down to the bottom of the page");
		
		//=========================================================================================================
		Thread.sleep(3000);
		
		// Wait for button to be clickable
		removeFromCart.waitForBtnToBeClickable();
		
		//removeFromCart.clickRemoveFromCart();
		test.log(LogStatus.INFO, "Click to remove item from cart");
		logger.info("Click to remove item from cart");
		
		removeFromCart.confirmRemoveFromCart();
		test.log(LogStatus.INFO, "Confirm deletion of item");
		logger.info("Confirm deletion of item");
		
		// Wait for remove Pop-up
		removeFromCart.waitForPopup();
		
		removeFromCart.assertRemoveFromCartProduct();
		test.log(LogStatus.INFO, "Verfied that the product is removed from cart");
		logger.info("Verfied that the product is removed from cart");
	}

}
