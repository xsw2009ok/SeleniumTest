package com.autotest.pages;

import org.openqa.selenium.By;

public class LoginPage {
	public static final By LP_CLICK_KEFU = By.xpath("//li/a/p[contains(text(),'客服')]");
	public static final By LP_INPUT_USERNAME = By.id("nickname");
	public static final By LP_INPUT_PASSWORD = By.id("password");
	public static final By LP_BUTTON_LOGIN = By.id("login");
	public static final By LP_RESULT = By.xpath("//div/p/span");
}
