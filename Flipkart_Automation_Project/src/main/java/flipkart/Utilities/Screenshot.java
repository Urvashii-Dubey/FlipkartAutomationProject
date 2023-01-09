package flipkart.Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {

	public static void takeScreenShot(WebDriver driver, String fileName) {

		String screenshotFileName = System.getProperty("user.dir") + "//FailedTestsScreenshot//" + fileName + " .jpg";
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {

			FileUtils.copyFile(scrFile, new File(screenshotFileName));
			System.out.println("Screenshot Captured");

		} catch (IOException io) {

			io.printStackTrace();

		} catch (Exception e) {

			System.out.println("Exception while taking Screenshot" + e.getMessage());

		}
	}
}
