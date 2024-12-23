import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


//класс
public class StartQuitBrowser {
    protected WebDriver driver;

    protected void start() {
//        ChromeOptions fullScreen = new ChromeOptions();
//        fullScreen.addArguments("--start-maximized");
//
//        driver = new ChromeDriver(fullScreen);

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    protected void quit() {
        driver.quit();
    }
}
