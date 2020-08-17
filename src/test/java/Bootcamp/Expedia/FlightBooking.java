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
	WebDriverWait w;

	@Test
	public void f() throws InterruptedException {
		dr.get("https://www.goggle.com");
		dr.manage().window().maximize();
		dr.get("https://www.expedia.com");
		dr.findElement(By.linkText("Flights")).click();
		// Actions act = new Actions(dr);
		dr.findElement(By.xpath("//button[@aria-label='Leaving from']")).click();
		dr.findElement(By.id("location-field-leg1-origin")).sendKeys("Minneapolis");
		Thread.sleep(3000);
		// WebElement element = dr.findElement(By.id("location-field-leg1-origin"));
		// act.sendKeys(el, "Minneapolis").perform();
		// dr.findElement(By.xpath("//*[@id=\"location-field-leg1-origin-menu\"]/div[2]/ul/li[2]/button")).click();
		dr.findElements(By.xpath("//*[@data-stid='location-field-leg1-origin-result-item']")).get(1).click();
		Thread.sleep(3000);
		// boolean al = false;
		// Alert alert = dr.switchTo().alert();
		// if(true)
		// alert.dismiss();
		// dr.switchTo().alert().dismiss();

		// new WebDriverWait(dr, 10);
		// w.until(ExpectedConditions.invisibilityOf(selec));

		WebElement destination = dr.findElement(By.xpath("//*[@aria-label='Going to']"));
		destination.click();
		dr.findElement(By.cssSelector("input#location-field-leg1-destination")).sendKeys("New York");
		Thread.sleep(3000);
		dr.findElements(By.xpath("//*[@data-stid='location-field-leg1-destination-result-item']")).get(1).click();
		Thread.sleep(3000);
		// new WebDriverWait(dr, 10);
		// w.until(ExpectedConditions.textToBePresentInElement(destination, "New York
		// (JFK - John F. Kennedy Intl."));
		Thread.sleep(3000);
		dr.findElement(By.linkText("2 travelers")).click();
		dr.findElement(By.xpath("//*[@id=\"adaptive-menu\"]/div/div/section/div[1]/div[1]/div/button[1]")).click();
		dr.findElement(By.cssSelector("#adaptive-menu > div > div > div.uitk-scrim.guestsDoneBtn.fade-button > button"))
				.click();

		// WebElement el =
		// dr.findElement(By.xpath("//*[@aria-labelledby='nextMonth-title']"));
		// JavascriptExecutor executor = (JavascriptExecutor)dr;
		// executor.executeScript("", el);

		dr.findElement(By.xpath("//button[@data-testid='submit-button']")).click();

		WebElement drop = dr.findElement(By.id("sortDropdown"));

		Select s = new Select(drop);
		s.selectByIndex(2);
		Thread.sleep(2000);
		dr.findElement(By.xpath("//*[@data-omniture-rfrr='FLT.SR.Filter.FareOptions.0']")).click();
		Thread.sleep(2000);
		dr.findElement(By.cssSelector("[data-omniture-rfrr='FLT.SR.Filter.Stops.0")).click();
		Thread.sleep(3000);

		// Set<String> ids = dr.getWindowHandles();
		// Iterator<String> iter = ids.iterator();
		// String parent = iter.next();
		// String child = iter.next();
		// dr.switchTo().window(child);
		// System.out.println(dr.getTitle());
		// dr.close();
		// dr.switchTo().defaultContent();

		dr.findElements(By.xpath("//button[@data-test-id='select-button']")).get(0).click();
		Thread.sleep(6000);
		dr.findElements(By.xpath("//*[contains(@data-test-id,'select-button-')]")).get(0).click();
		// dr.findElements(By.xpath("//button[@data-test-id='select-button-1']")).get(0).click();
		// dr.findElements(By.xpath("//button[@data-test-id='select-button-2']")).get(0).click();
		Thread.sleep(6000);
		dr.findElements(By.xpath("//*[@data-test-id='select-button']")).get(0).click();
		Thread.sleep(6000);
		dr.findElements(By.xpath("//*[@data-test-id='select-button-1']")).get(0).click();
		Thread.sleep(6000);
		
		//dr.findElement(By.xpath("//*[@id='forcedChoiceNoThanks']")).click();
		// dr.findElement(By.linkText("No thanks")).click();
		// dr.findElement(By.id("forcedChoiceNoThanks")).click();
		WebElement alert = dr.findElement(By.cssSelector("a#forcedChoiceNoThanks"));
		WebDriverWait w = new WebDriverWait(dr, 10);
		w.until(ExpectedConditions.elementToBeClickable(alert));
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

		// Xpath=//*[contains(text(),'here')]
		// Xpath=//*[contains(@href,'guru99.com')]

		// dr.findElement(By.xpath("//*[@id='firstname[0]' or @])")
		//dr.findElement(By.linkText("Checkout as guest")).click();
		dr.findElement(By.id("firstname[0]")).sendKeys("Leo");
		dr.findElement(By.cssSelector("[data-tealeaf-name='middleName']")).sendKeys("Barcelona");
		dr.findElement(By.id("lastname[0]")).sendKeys("Messi");

		Select se = new Select(dr.findElement(By.xpath("//*[@aria-label='Country/Territory Code']")));
		se.selectByValue("1");

		dr.findElement(By.id("phone-number[0]")).sendKeys("1234567890");
		dr.findElement(By.id("confirmation-sms-provider-checkbox")).click();
		dr.findElement(By.id("gender_male[0]")).click();

		Select month = new Select(dr.findElement(By.id("date_of_birth_month0")));
		month.selectByIndex(1);
		Select day = new Select(dr.findElement(By.id("date_of_birth_day[0]")));
		day.selectByIndex(2);
		Select year = new Select(dr.findElement(By.id("date_of_birth_year[0]")));
		year.selectByValue("2000");

		dr.findElement(By.cssSelector("input[name='creditCards[0].cardholder_name']")).sendKeys("Beresa Gafesu");
		dr.findElement(By.id("creditCardInput")).sendKeys("1234567890123456");
		Select expireMonth = new Select(dr.findElement(By.xpath("//*[@name='creditCards[0].expiration_month']")));
		expireMonth.selectByIndex(1);
		Select expireYear = new Select(dr.findElement(By.cssSelector("[name='creditCards[0].expiration_year']")));
		expireYear.selectByValue("2022");

		dr.findElement(By.id("new_cc_security_code")).sendKeys("123");

		Select billingCountry = (Select) dr.findElement(By.xpath("//*[@name='creditCards[0].country']"));
		billingCountry.selectByValue("USA");
		dr.findElement(By.xpath("//*[@name='creditCards[0].street']")).sendKeys("12344 Chicago Ave");
		dr.findElement(By.xpath("//*[@name='creditCards[0].city']")).sendKeys("Chicago");
		Select state = new Select(dr.findElement(By.cssSelector("[required name='creditCards[0].state']")));
		state.selectByValue("MN");
		dr.findElement(By.xpath("//*[@name='creditCards[0].zipcode']")).sendKeys("55555");
		dr.findElement(By.xpath("//input[@type='email']")).sendKeys("sample@outloo.com");
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
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@AfterTest
	public void afterTest() {
		// dr.quit();
	}

}
