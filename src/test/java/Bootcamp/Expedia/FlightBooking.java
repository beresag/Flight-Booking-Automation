package Bootcamp.Expedia;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class FlightBooking {
	WebDriver dr;
	WebDriverWait waitTime;

	@Test
	public void f() throws InterruptedException {
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		dr.get("https://www.goggle.com");
		dr.manage().window().maximize();
		dr.get("https://www.expedia.com");
		dr.findElement(By.linkText("Flights")).click();
		dr.findElement(By.xpath("//button[@aria-label='Leaving from']")).click();
		dr.findElement(By.id("location-field-leg1-origin")).sendKeys("Minneapolis");
		Thread.sleep(3000);
		dr.findElements(By.xpath("//*[@data-stid='location-field-leg1-origin-result-item']")).get(1).click();
		Thread.sleep(3000);
		
		// dr.switchTo().alert().dismiss();

		WebElement destination = dr.findElement(By.xpath("//*[@aria-label='Going to']"));
		destination.click();
		dr.findElement(By.cssSelector("input#location-field-leg1-destination")).sendKeys("New York");
		Thread.sleep(3000);
		dr.findElements(By.xpath("//*[@data-stid='location-field-leg1-destination-result-item']")).get(1).click();
		Thread.sleep(3000);
		dr.findElement(By.linkText("2 travelers")).click();
		dr.findElement(By.xpath("//*[@id=\"adaptive-menu\"]/div/div/section/div[1]/div[1]/div/button[1]")).click();
		dr.findElement(By.cssSelector("#adaptive-menu > div > div > div.uitk-scrim.guestsDoneBtn.fade-button > button"))
				.click();
		Thread.sleep(2000);
		dr.findElement(By.xpath("//button[@data-testid='submit-button']")).click();
		
		Thread.sleep(3000);
		WebElement drop = dr.findElement(By.id("sortDropdown"));
		Select s = new Select(drop);
		s.selectByIndex(2);
		Thread.sleep(6000);
		dr.findElement(By.xpath("//*[@data-omniture-rfrr='FLT.SR.Filter.FareOptions.0']")).click();
		Thread.sleep(6000);
		dr.findElement(By.cssSelector("[data-omniture-rfrr='FLT.SR.Filter.Stops.0']")).click();
		

		/*
		 * Set<String> ids = dr.getWindowHandles(); Iterator<String> iter =
		 * ids.iterator(); String parent = iter.next(); String child = iter.next();
		 * dr.switchTo().window(child); System.out.println(dr.getTitle()); dr.close();
		 * dr.switchTo().defaultContent();
		 */
		Thread.sleep(6000);
		dr.findElements(By.xpath("//button[@data-test-id='select-button']")).get(0).click();
		
		WebElement select1 = dr.findElement(By.xpath("//*[contains(@data-test-id,'select-button-') or @class='btn-secondary t-select-btn btn-sub-action']"));
		WebDriverWait w1 = new WebDriverWait(dr,10);
		w1.until(ExpectedConditions.elementToBeClickable(select1));
		select1.click();
	    //dr.findElement(By.xpath("//*[contains(@data-test-id,'select-button-') or @class='btn-secondary t-select-btn btn-sub-action']"));
		
		// dr.findElements(By.xpath("//*[contains(@data-test-id,'select-button-')]")).get(0).click();
		// dr.findElements(By.xpath("//button[@data-test-id='select-button-1']")).get(0).click();
		// dr.findElements(By.xpath("//button[@data-test-id='select-button-2']")).get(0).click();
		//Thread.sleep(6000);
	    WebElement select2 = dr.findElements(By.xpath("//*[@data-test-id='select-button']")).get(0);
		WebDriverWait w2 = new WebDriverWait(dr, 10);
		w2.until(ExpectedConditions.elementToBeClickable(select2));
		select2.click();
		//Thread.sleep(6000);
		WebElement select3 = dr.findElements(By.xpath("//*[@data-test-id='select-button-1']")).get(0);
		WebDriverWait w3 = new WebDriverWait(dr, 10);
		w3.until(ExpectedConditions.elementToBeClickable(select3));
		select3.click();

		// dr.findElement(By.xpath("//*[@id='forcedChoiceNoThanks']")).click();
		// dr.findElement(By.linkText("No thanks")).click();
		// dr.findElement(By.id("forcedChoiceNoThanks")).click();

		WebElement alert = dr.findElement(By.cssSelector("a#forcedChoiceNoThanks"));
		WebDriverWait waitTime = new WebDriverWait(dr, 10);
		waitTime.until(ExpectedConditions.elementToBeClickable(alert));
		alert.click();

		// get.windowhandle(): helps in getting the window handle of the current window
		// get.windowhandles(): helps in getting the handles of all the windows opened
		// set: helps to set the window handles which is in the form of a string.
		// switch to: helps in switching between the windows

		Set<String> ids = dr.getWindowHandles();
		Iterator<String> iter = ids.iterator();
		String parent = iter.next();
		String child = iter.next();
		dr.switchTo().window(child);
		System.out.println(dr.getTitle());

		Thread.sleep(6000);
		dr.findElement(By.id("bookButton")).click();

		dr.findElement(By.xpath("//*[@id='firstname[0]' or @data-stid='checkoutAsGuest-button']")).click();
		// dr.findElement(By.linkText("Checkout as guest")).click();
		dr.findElement(By.id("firstname[0]")).sendKeys("Leo");
		dr.findElement(By.cssSelector("[data-tealeaf-name='middleName']")).sendKeys("Barcelona");
		dr.findElement(By.id("lastname[0]")).sendKeys("Messi");
		/* USA is selected by default if you want to change the value uncomment the following
		   two lines and change the value*/
		// Select se = new Select(dr.findElement(By.xpath("//*[@aria-label='Country/TerritoryCode']")));
		// se.selectByValue("1");
		dr.findElement(By.id("phone-number[0]")).sendKeys("1234567890");
		// This checkbox is selected by default
		dr.findElement(By.id("confirmation-sms-provider-checkbox")).isSelected();
		dr.findElement(By.id("gender_male[0]")).click();

		Select month = new Select(dr.findElement(By.id("date_of_birth_month0")));
		month.selectByValue("03");
		Select day = new Select(dr.findElement(By.id("date_of_birth_day[0]")));
		day.selectByValue("05");
		Select year = new Select(dr.findElement(By.id("date_of_birth_year[0]")));
		year.selectByValue("2000");

		dr.findElement(By.cssSelector("[data-tealeaf-name='cardHolderName_1']")).sendKeys("Leo Messi");
		dr.findElement(By.id("creditCardInput")).sendKeys("374326386873984");
		Select expireMonth = new Select(dr.findElement(By.xpath("//*[@name='creditCards[0].expiration_month']")));
		expireMonth.selectByValue("8");
		Select expireYear = new Select(dr.findElement(By.cssSelector("[name='creditCards[0].expiration_year']")));
		expireYear.selectByValue("2022");
		dr.findElement(By.id("new_cc_security_code")).sendKeys("123");

		// USA is selected by default if you want to change the country uncomment the following two lines and provide the value
		//Select billingCountry = new Select(dr.findElement(By.xpath("//*[@name='creditCards[0].country']")));
		// billingCountry.selectByValue("USA");
		dr.findElement(By.xpath("//*[@name='creditCards[0].street']")).sendKeys("12344 3rd Avenue");
		dr.findElement(By.xpath("//*[@name='creditCards[0].city']")).sendKeys("St.Paul");
		Select state = new Select(dr.findElement(By.cssSelector("[data-validation-message='Please select a state.']")));
		state.selectByValue("MN");
		dr.findElement(By.xpath("//*[@name='creditCards[0].zipcode']")).sendKeys("55101");
		dr.findElement(By.xpath("//input[@data-tealeaf-name='email']")).sendKeys("sample@outlook.com");
		dr.findElement(By.id("complete-booking")).click();
	}

	@BeforeTest
	public void beforeTest() {
		String path = System.getProperty("user.dir");
		String browserName = "chrome";
		// System.setProperty("webdriver.edge.driver", path +
		// "\\drivers\\msedgedriver.exe");
		// dr = new EdgeDriver();
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", path + "\\drivers\\chromedriver.exe");
			dr = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", path + "\\drivers\\geckodriver.exe");
			dr = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", path + "\\drivers\\IEDriverServer.exe");
			dr = new InternetExplorerDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", path + "\\drivers\\msedgedriver.exe");
			dr = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("opera")) {
			System.setProperty("webdriver.opera.driver", path + "\\drivers\\operadriver.exe");
			dr = new OperaDriver();
		}
		
	}

	@AfterTest
	public void afterTest() {
		//dr.quit();
	}

}
