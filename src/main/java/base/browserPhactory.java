package base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class browserPhactory {

	private static ThreadLocal<WebDriver> drivers = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver() {
		return drivers.get();
	}

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new ChromeDriver();
		drivers.set(driver);
		driver.manage().window().maximize();
		System.out.println("[INFO] - INICIO DO TESTE");
		// ACESSANDO KABUM
		getDriver().get("https://www.kabum.com.br/login");

	}

	@After
	public void acessarAmericanas() throws Exception {
		drivers.get().quit();
		System.out.println("[INFO] - FIM DO TESTE");
	}

}
