package flipkart.Utilities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import flipkart.Pages.BasePage;

import org.openqa.selenium.interactions.Action;

public class ActionManager extends BasePage {

	// Single Scroll Down 
	public static void singleScrollDown() {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
	}

	// Scroll Down to the End of the Page 
	public static void scrollDownToBottom() {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
	}
	
	// Move to Element
	public static void moveToElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	// Close the browser pop-up 
	public static void closePopUpBox() {
		Actions actions = new Actions(driver);
		Action action = actions.sendKeys(Keys.ESCAPE).build();
		action.perform();
	}
	
}
