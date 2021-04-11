package automicgrp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Abnautomation_run {

	public static WebDriver driver;
	Processentries processref = new Processentries();
	boolean next_btn_name= false;
	WebElement next_btn1 = null;
	

	@Parameters({"browser"})
	@BeforeTest

	public static void launchURL(String browser)  {

		// String low_browser = browser.toLowerCase();
		if (browser.toLowerCase().equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.toLowerCase().equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.toLowerCase().equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.get("https://abr.business.gov.au/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

	}

	@BeforeMethod
	public void lookup_abn()  {

		driver.findElement(By.xpath("//*[@id=\"SearchText\"]")).sendKeys("Automic");
		driver.findElement(By.xpath("//*[@id=\"MainSearchButton\"]")).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
	}

	@SuppressWarnings("static-access")
	@Test
	public void clicklink() {
		
		processref.process_entries(driver);
		WebElement next_btn= driver.findElement(By.xpath("//*[@id=\"content-matching\"]/div/div/div/ul/li[6]"));
		
		boolean next_btn_name = next_btn.isEnabled();
		
		
		//disabled PagedList-skipToNext
		while(next_btn_name)
		{
			String chk_btn_enabled= driver.findElement(By.xpath("//*[@id=\"content-matching\"]/div/div/div/ul/li[6]")).getAttribute("class");
			if(!(chk_btn_enabled.contains("disabled"))) {
				driver.findElement(By.xpath("//*[@id=\"content-matching\"]/div/div/div/ul/li[6]")).click();
				processref.process_entries(driver);
				
			}
			else {
				break;
			}
			
		}
		
		System.out.println("All pages are checked against the given input and results are displayed above");

					}
	@AfterTest 
	public void close_browser() {
		driver.close();
	}
			}
