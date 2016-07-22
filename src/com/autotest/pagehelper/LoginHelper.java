package com.autotest.pagehelper;

import com.autotest.pages.LoginPage;
import com.autotest.utils.SeleniumUtil;
import com.autotest.utils.*;

public class LoginHelper {

	public static void inputLoginInfo(SeleniumUtil seleniumUtil, String username,String password,String result){
		seleniumUtil.click(LoginPage.LP_CLICK_KEFU);
		seleniumUtil.input(LoginPage.LP_INPUT_USERNAME, username);
		seleniumUtil.input(LoginPage.LP_INPUT_PASSWORD, password);
		seleniumUtil.sleep(3);
		seleniumUtil.click(LoginPage.LP_BUTTON_LOGIN);
		seleniumUtil.checkLoginResult(result);
	}
}
