import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCase {
	WebDriver driver = new ChromeDriver();
	String theWebsite = "https://magento.softwaretestingboard.com/";
	String theWebsite2 = "https://www.google.com";
//	String signUpPage = "https://magento.softwaretestingboard.com/customer/account/create/";
	String[] firstNames = { "ahmad", "ali", "omar", "ayat", "alla", "sawsan", "rama" };
	String[] lastNames = { "mohammad", "mustafa", "abdullah", "malek", "saleh", "akram", "zaid" };
	Random rand = new Random();

	@BeforeTest
	public void setUp() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get(theWebsite);
//		driver.navigate().to(theWebsite2);
//		driver.navigate().back();
//		driver.navigate().forward();
//		System.out.println(driver.getCurrentUrl().toUpperCase());
//		System.out.println(driver.getTitle());
//		Thread.sleep(5000);
//		driver.navigate().refresh();
	}

	@Test(priority = 1) // , invocationCount =10) hai mshan yn3ad eltest 10 mrat
	public void signUp() throws InterruptedException {
		// hon fb76hom local mshan bkol test tet3`yer 8emthom elasma2
		int randomIndexForTheFirstName = rand.nextInt(firstNames.length);
		int randomIndexForTheLastName = rand.nextInt(lastNames.length);

		String userFirstName = firstNames[randomIndexForTheFirstName];
		String userLastName = lastNames[randomIndexForTheLastName];
		int randomNumberForTheEmail = rand.nextInt(564548);
		String domainName = "@gmail.com";

		// driver.get(signUpPage);

		// take part of the text only work with (a)tag
		driver.findElement(By.partialLinkText("Create")).click();

		Thread.sleep(5000);
		driver.navigate().refresh();

		// take the full text only work with (a)tag
		driver.findElement(By.linkText("Create an Account")).click();

		WebElement firstNameInput = driver.findElement(By.id("firstname"));
		firstNameInput.sendKeys(userFirstName);
		WebElement lasttNameInput = driver.findElement(By.id("lastname"));
		lasttNameInput.sendKeys(userLastName);
		WebElement emailInput = driver.findElement(By.id("email_address"));
		emailInput.sendKeys(userFirstName + userLastName + randomNumberForTheEmail + domainName);
		WebElement passwordInput = driver.findElement(By.id("password"));
		passwordInput.sendKeys("Rana1234");
		WebElement confirmPasswordInput = driver.findElement(By.id("password-confirmation"));
		confirmPasswordInput.sendKeys("Rana1234");
		Thread.sleep(3000);
		WebElement createAnAccountButton = driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button"));
		createAnAccountButton.click();
	}

	@Test(priority = 2)//, enabled = false)
	public void logOut() throws InterruptedException {
		Thread.sleep(5000);
		String logOutUrl = "https://magento.softwaretestingboard.com/customer/account/logout/";
		driver.get(logOutUrl);
	}
}