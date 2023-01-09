package flipkart.Utilities;

import org.testng.IAnnotationTransformer;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.ITestAnnotation;

public class TestExecutionListener implements IAnnotationTransformer {

	@SuppressWarnings({ "unused", "rawtypes" })
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		
		// Created a list to store the file which is to be executed
		List<String> activatedTest = new ArrayList<>();
		String[] group;
		ReadingExcelFile data = new ReadingExcelFile();

		int r_count = data.RowCount();

		for (int i = 1; i < r_count; i++) {
			String value = data.getCellData(i, 1).toLowerCase();
			if (value.equals("yes")) {
				String method = data.getCellData(i, 0);
				activatedTest.add(method);
			}
		}

		String name = testMethod.getName();

		// Test case execution by using "enabled = true" in @Test annotation
		if (activatedTest.contains(name)) {
			annotation.setEnabled(true);
		} else {
			annotation.setEnabled(false);
		}
	}
}
