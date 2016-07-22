package com.autotest.utils;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.autotest.pages.LoginPage;

public class SeleniumUtil {

	public static Logger log = Logger.getLogger(SeleniumUtil.class.getName());

	public static String url = "http://192.168.100.241";

	public WebDriver driver = null;

	
	public void startBrowers() {

		System.setProperty("webdriver.chrome.driver", "data/chromedriver.exe");

		driver = new ChromeDriver();
		try {
			driver.get(url);
		} catch (Exception e) {
			log.warning("浏览器启动失败");
		}
	}

	
	public void closeBrower() {
		if (driver != null) {
			driver.quit();
		}
	}

	/**
	 * 默认休眠400毫秒
	 */
	public void sleep() {
		try {
			log.info("线程开始休眠，休眠400毫秒");
			Thread.sleep(400);
		} catch (Exception e) {
			log.warning("线程休眠失败");
		}
	}

	/**
	 * 传入需要休眠的(秒)数
	 * 
	 * @param time
	 */
	public void sleep(int time) {
		try {
			log.info("线程开始休眠，休眠" + time * 1000 + "秒");
			Thread.sleep(time * 1000);
		} catch (Exception e) {
			log.warning("线程休眠失败");
		}
	}

	/**
	 * 控件点击
	 * 
	 * @param element
	 */
	public void click(By by) {
		try {
			log.info("点击" + by);
			findElement(by).click();
		} catch (Exception e) {
			log.info("点击" + by + "完成");
		}
	}

	/**
	 * 清除控件中的内容
	 * 
	 * @param element
	 */

	public void clear(By by) {
		try {
			log.info("清除" + by + "数据成功");
			findElement(by).clear();
		} catch (Exception e) {
			log.info("清除" + by + "数据失败");
		}
	}

	/**
	 * 向控件中输入内容
	 * 
	 * @param by
	 * @param str
	 */
	public void input(By by, String str) {
		try {
			log.info("向" + by + "中写入：" + str + "开始");
			findElement(by).sendKeys(str);
		} catch (Exception e) {
			log.warning("写入数据失败");
		}
		log.info("向" + by + "中写入：" + str + "成功！");
	}

	/**
	 * 查找控件
	 * 
	 * @param by
	 * @return
	 */
	public WebElement findElement(By by) {
		return driver.findElement(by);
	}
	
	
	/**
	 * 
	 * @param by
	 * @return
	 */
	public List<WebElement> findElements(By by) {
		return driver.findElements(by);
	}

	/**
	 * 最大化浏览器
	 */
	public void maxBrowser() {
		log.info("最大化浏览器");
		driver.manage().window().maximize();
	}

	/**
	 * 加载控件超时
	 * 
	 * @param timeOut
	 * @param By
	 */
	public void waitForElementToLoad(int timeOut, final By By) {
		log.info("开始查找元素[" + By + "]");
		try {
			(new WebDriverWait(driver, timeOut)).until(new ExpectedCondition<Boolean>() {

				public Boolean apply(WebDriver driver) {
					WebElement element = driver.findElement(By);
					return element.isDisplayed();
				}
			});
		} catch (TimeoutException e) {
			log.warning("超时!! " + timeOut + " 秒之后还没找到元素 [" + By + "]");
			Assert.fail("超时!! " + timeOut + " 秒之后还没找到元素 [" + By + "]");

		}
		log.info("找到了元素 [" + By + "]");
	}

	/**
	 * 页面加载
	 * 
	 * @param timeOut
	 */
	public void waitForPageLoading(int timeOut) {
		driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
	}

	/**
	 * 根据excel的result断言是否登录成功
	 * @param str
	 */
	public void checkLoginResult(String str) {
		sleep();
		Assert.assertEquals(str,findElement(LoginPage.LP_RESULT).getText());

	}
}
