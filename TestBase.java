
	package utils;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import io.github.bonigarcia.wdm.WebDriverManager;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.AfterMethod;
	import java.time.Duration;

	public class TestBase {
	    public WebDriver driver;

	    @BeforeMethod
	    public void setUp() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.manage().window().maximize();
	        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
	    }

	    @AfterMethod
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}



