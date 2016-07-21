package com.autotest.testcase;

import java.util.Map;
import java.util.logging.Logger;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.autotest.base.BaseParpare;
import com.autotest.pages.LoginPage;

import com.autotest.utils.SeleniumUtil;
import com.mysql.jdbc.Driver;

public class Login extends BaseParpare{
	
	public static Logger log = Logger.getLogger(Login.class.getName());
	@Test(dataProvider="testData")
	public void LoginTest(Map<String, String> data) {
		Logger loginlog = Logger.getLogger(this.getClass().getName());

		SeleniumUtil login = new SeleniumUtil();
		try {
			login.startBrowers();

			login.maxBrowser();
		} catch (Exception e) {
			log.warning("打开浏览器或最大化失败");
		}

		login.click(LoginPage.LP_CLICK_KEFU);
		login.input(LoginPage.LP_INPUT_USERNAME, data.get("username"));
		login.input(LoginPage.LP_INPUT_PASSWORD, data.get("password"));
		login.sleep(3);
		login.click(LoginPage.LP_BUTTON_LOGIN);
		login.checkLoginResult(data.get("result"));
		login.closeBrower();
	}
}
