import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


//класс
public class StartQuitBrowser {
    protected WebDriver driver;

    @Before
    public void start() {
//        ChromeOptions fullScreen = new ChromeOptions();
//        fullScreen.addArguments("--start-maximized");
//
//        driver = new ChromeDriver(fullScreen);

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @After
    public void quit() {
        driver.quit();
    }
}
