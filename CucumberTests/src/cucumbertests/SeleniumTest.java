package cucumbertests;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class SeleniumTest {

	private WebDriver driver;
	private String baseUrl, browserName, browserVersion;

	public void setUp() throws Exception {

		driver = new FirefoxDriver();
		baseUrl = "http://socialfunnel.it.dh-karlsruhe.de:8080/SocialFunnel";
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
		Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
		browserName = caps.getBrowserName();
		browserVersion = caps.getVersion();
		System.out.println("Running on " + browserName + " on version " + browserVersion);
	}

	public void tearDown() {
		driver.quit();
	}

	public void goToHomePage() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	public void clickRegister() {
		driver.findElement(By.id("btnRegistrieren")).click();
	}
	public void enterpassword() {
		driver.findElement(By.id("txtPasswort")).sendKeys("test123");
	}

	public void enterpassword2() {
		driver.findElement(By.id("txtPasswort2")).sendKeys("test123");
	}

	public void checkbox() {
		driver.findElement(By.id("checkbox")).click();
	}

	public void wrongEntry() {
		driver.findElement(By.id("txtPasswort2")).sendKeys("falschesPasswort");
	}

	public void onPage(String string) {
		assertTrue(driver.getCurrentUrl().contains(string));
	}

	public void errorMessage() {
		assertTrue(driver.findElement(By.className("v-app mytheme v-overlay-container")) != null);
	}

	public void notloggedin() {
		onPage("login");
		onPage("register");
	}

	public void chooseNetwork() {
		driver.findElement(By.id("listNetwork")).click();
	}

	public void titleAsExpected() {
		assertTrue(driver.getTitle().equalsIgnoreCase("SocialFunnel"));
		
	}

	public void networkListCheck() {
		assertTrue(driver.findElement(By.className("v-slot")) != null);
	}

}
