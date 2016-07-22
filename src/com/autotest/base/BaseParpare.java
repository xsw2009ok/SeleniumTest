package com.autotest.base;
/**
 * @author young
 * @Description 测试开始 和 测试结束 的操作
 * 
 * */
import java.io.IOException;
import java.util.Iterator;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import com.autotest.utils.ExcelDataProvider;
import com.autotest.utils.SeleniumUtil;

public class BaseParpare {

	protected SeleniumUtil su = new SeleniumUtil();
	
	@BeforeClass
	public void openBrowser(){
	
	su.startBrowers();
	}
	
	@AfterClass
	public void closeBrowser(){
	su.closeBrower();
	}
	
	
	
	/**
	 * 测试数据提供者 - 方法
	 * */
	@DataProvider(name="testData")
	public Iterator<Object[]> dataFortestMethod() throws IOException {
/*		String moduleName = null; // 模块的名字
		String caseNum = null; // 用例编号
		String className = this.getClass().getName();
		int dotIndexNum = className.indexOf("."); // 取得第一个.的index
		int underlineIndexNum = className.indexOf("_"); // 取得第一个_的index

		if (dotIndexNum > 0) {	
			moduleName = className.substring(24, className.lastIndexOf(".")); // 取到模块的名称
		}

		if (underlineIndexNum > 0) {
			caseNum = className.substring(underlineIndexNum + 1, underlineIndexNum + 4); // 取到用例编号
		}
		//将模块名称和用例的编号传给 ExcelDataProvider ，然后进行读取excel数据
*/
		return new ExcelDataProvider("login", "001");
	}
}
