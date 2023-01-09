package flipkart.Utilities;

import java.util.Set;

import flipkart.Pages.BasePage;

public class CommonUtils extends BasePage {

	public static void switchTab() {
		Set<String> handles = driver.getWindowHandles();
		String currentHandle = driver.getWindowHandle();
		for (String handle : handles) {
			if (!handle.equals(currentHandle)) {
				driver.switchTo().window(handle);
			}
		}
	}

}