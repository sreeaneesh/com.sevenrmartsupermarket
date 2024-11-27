package com.sevenrmartsupermarket.utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

public class GeneralUtility {
	public String get_Attribute(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}

	public String getCssProperty(WebElement element, String attribute) {
		return element.getCssValue(attribute);
	}

	public List<String> getTextOfElements(List<WebElement> elements) {
		List<String> data = new ArrayList<String>();
		for (WebElement element : elements) {
			data.add(element.getText());
		}
		return data;
	}

	public static String getRandomName() {
		Faker faker = new Faker();
		return faker.name().firstName();

	}

	public static String getRandomAddress() {
		Faker faker = new Faker();
		return faker.address().fullAddress();

	}

}
