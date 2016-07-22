package com.autotest.testcase;


import java.util.Map;
import java.util.logging.Logger;
import org.testng.annotations.Test;
import com.autotest.base.BaseParpare;
import com.autotest.pagehelper.*;


public class Login extends BaseParpare{
	
	public static Logger log = Logger.getLogger(Login.class.getName());
	@Test(dataProvider="testData")
	public void LoginTest(Map<String, String> data) {
		Logger loginlog = Logger.getLogger(this.getClass().getName());


		LoginHelper.inputLoginInfo(su, data.get("username"), data.get("password"), data.get("result"));
		
		
	}
}
